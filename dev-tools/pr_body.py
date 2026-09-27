# Parses the release-relevant sections of a pull request body (see PULL_REQUEST_TEMPLATE.md).
#
# This file is shared verbatim by the PR validators and the release changelog generator:
#   - Zomato/Android            DevTools/release_notes/pr_body.py  (source of truth)
#   - Zomato/android-mono-repo  scripts/pr_body.py                 (copy)
#   - Zomato/ed-android         scripts/pr_body.py                 (copy)
#   - Zomato/compose-sushi      dev-tools/pr_body.py               (copy)
# The changelog generator in Zomato/Android parses PRs of every release repo with this code, so
# any change here must be copied to the other repos, or their validators will accept bodies the
# changelog cannot read.
#
# Python 3.7 compatible, standard library only.

import re

SHIPPING_TITLE_SECTION = "shipping title"
CLASSIFICATION_SECTION = "classification"
CHANGELOG_SECTION = "changelog"

# Current and previous template placeholder lines of the "Shipping title" section.
SHIPPING_TITLE_PLACEHOLDERS = {
    "add a single-liner shipping title",
    "add a single-liner shipping title and shipping label",
}

FEATURES = "features"
UPDATES_FIXES = "updates_fixes"
PLATFORM = "platform"
CLEANUP = "cleanup"

# Changelog order.
CATEGORIES = [FEATURES, UPDATES_FIXES, PLATFORM, CLEANUP]

# Checkbox label (text before the " — " description, normalised by _normalise) -> category.
# The single-word labels are the tags of the previous template, still accepted so PRs raised
# before the template change land in the right section.
_CATEGORY_BY_LABEL = {
    "features": FEATURES,
    "feature": FEATURES,
    "updates/fixes": UPDATES_FIXES,
    "updates": UPDATES_FIXES,
    "fixes": UPDATES_FIXES,
    "platform": PLATFORM,
    "cleanup": CLEANUP,
    # previous template
    "feat": FEATURES,
    "fix": UPDATES_FIXES,
    "update": UPDATES_FIXES,
    "perf": PLATFORM,
    "chore": CLEANUP,
}

_HTML_COMMENT = re.compile(r"<!--.*?-->", re.DOTALL)
_HEADING = re.compile(r"^\s{0,3}#{1,6}\s+(.*?)\s*#*\s*$")
_CHECKBOX = re.compile(r"^\s*[-*+]\s+\[([ xX])\]\s*(.*?)\s*$")
# "—", "–" or " - " separate the checkbox label from its description.
_LABEL_SEPARATOR = re.compile(r"\s+[—–-]\s+|[—–]")


class PrBody(object):
    def __init__(self, shipping_title, categories, opted_out, has_classification_section):
        # First non-placeholder line of the "Shipping title" section, or None.
        self.shipping_title = shipping_title
        # Ticked categories, in CATEGORIES order, without duplicates.
        self.categories = categories
        # True when any box in the "Changelog" section is ticked.
        self.opted_out = opted_out
        self.has_classification_section = has_classification_section


def parse(body):
    sections = _split_sections(_HTML_COMMENT.sub("", body or ""))

    shipping_title = None
    categories = set()
    opted_out = False
    has_classification_section = False

    for heading, lines in sections:
        if heading.startswith(SHIPPING_TITLE_SECTION):
            if shipping_title is None:
                shipping_title = _first_title_line(lines)
            # The previous template kept the classification boxes under "Shipping title".
            categories.update(_ticked_categories(lines))
        elif heading.startswith(CLASSIFICATION_SECTION):
            has_classification_section = True
            categories.update(_ticked_categories(lines))
        elif heading.startswith(CHANGELOG_SECTION):
            if any(ticked for ticked, _ in _checkboxes(lines)):
                opted_out = True

    ordered = [c for c in CATEGORIES if c in categories]
    return PrBody(shipping_title, ordered, opted_out, has_classification_section)


def _split_sections(body):
    sections = []
    current = None
    for line in body.splitlines():
        match = _HEADING.match(line)
        if match:
            current = (match.group(1).strip().lower(), [])
            sections.append(current)
        elif current is not None:
            current[1].append(line)
    return sections


def _checkboxes(lines):
    for line in lines:
        match = _CHECKBOX.match(line)
        if match:
            yield match.group(1) in ("x", "X"), match.group(2)


def _ticked_categories(lines):
    for ticked, text in _checkboxes(lines):
        if not ticked:
            continue
        label = _normalise(_LABEL_SEPARATOR.split(text, 1)[0])
        category = _CATEGORY_BY_LABEL.get(label)
        if category is None:
            # "Fix, crash, ANR" style labels: fall back to the first word.
            category = _CATEGORY_BY_LABEL.get(_normalise(re.split(r"[\s,]+", text, 1)[0]))
        if category is not None:
            yield category


def _first_title_line(lines):
    for line in lines:
        stripped = line.strip()
        if not stripped or _CHECKBOX.match(stripped):
            continue
        # Tolerate the title being written as a bullet.
        stripped = re.sub(r"^[-*+]\s+", "", stripped).strip()
        if not stripped or stripped.lower().rstrip(".") in SHIPPING_TITLE_PLACEHOLDERS:
            continue
        return stripped
    return None


def _normalise(label):
    return re.sub(r"\s+", "", label).strip("*_`:.").lower()
