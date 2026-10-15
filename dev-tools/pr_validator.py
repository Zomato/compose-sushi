# Validates that a pull request carries what the release changelog needs:
#   - it is added to a release milestone, unless it opts out of the changelog
#   - its "Shipping title" is filled (not the template placeholder)
#   - at least one "Classification" box is ticked
#
#   python3 pr_validator.py <pr number> <owner/repo> <token>
#
# Kept identical in every release repo, next to a copy of pr_body.py (see the note there):
# Zomato/Android DevTools/, android-mono-repo scripts/, ed-android scripts/, compose-sushi dev-tools/.
# Python 3.7 compatible, standard library only.

import json
import os
import sys
import urllib.error
import urllib.request

_HERE = os.path.dirname(os.path.abspath(__file__))
sys.path[:0] = [_HERE, os.path.join(_HERE, "release_notes")]
import pr_body  # noqa: E402

API_URL = "https://api.github.com"
COMMENT_MARKER = "Pull request validator"
# github-actions[bot] and ZTravisBot, whose earlier validator comments get replaced.
BOT_USER_IDS = {41898282, 28433059}


def request(token, method, path, payload=None):
    data = json.dumps(payload).encode("utf-8") if payload is not None else None
    req = urllib.request.Request(API_URL + path, data=data, method=method)
    req.add_header("Authorization", "Bearer " + token)
    req.add_header("Accept", "application/vnd.github+json")
    if data is not None:
        req.add_header("Content-Type", "application/json")
    with urllib.request.urlopen(req, timeout=60) as response:
        body = response.read().decode("utf-8")
        return json.loads(body) if body else None


def validate(pr, repo):
    errors = []
    parsed = pr_body.parse(pr.get("body"))
    example = "v19.9.1" if repo == "Zomato/Android" else "zomato-v19.9.1"
    # The milestone only feeds the changelog, so PRs that opt out of it may skip it.
    if not pr.get("milestone") and not parsed.opted_out:
        errors.append("Add this PR to the milestone of the release it ships in (e.g. `{0}`), "
                      "or tick the **Changelog** opt-out box.".format(example))

    if not parsed.shipping_title:
        errors.append("Fill the **Shipping title** section with a one-line summary "
                      "(replace the template placeholder).")
    if not parsed.categories:
        errors.append("Tick at least one option in the **Classification** section: "
                      "Features, Updates/Fixes, Platform, Cleanup.")
    return errors


def replace_comment(token, repo, number, comment):
    """Deletes earlier validator comments, then posts `comment` (if any)."""
    comments = request(token, "GET", "/repos/{0}/issues/{1}/comments?per_page=100".format(repo, number))
    for old in comments:
        if COMMENT_MARKER in (old.get("body") or "") and old["user"]["id"] in BOT_USER_IDS:
            request(token, "DELETE", "/repos/{0}/issues/comments/{1}".format(repo, old["id"]))
    if comment:
        request(token, "POST", "/repos/{0}/issues/{1}/comments".format(repo, number), {"body": comment})


def main():
    number, repo, token = sys.argv[1], sys.argv[2], sys.argv[3]
    try:
        pr = request(token, "GET", "/repos/{0}/pulls/{1}".format(repo, number))
    except urllib.error.HTTPError as err:
        print("::error::Could not fetch {0}#{1}: {2}".format(repo, number, err))
        sys.exit(1)

    errors = validate(pr, repo)
    if errors:
        comment = "**{0} failed** :cry:\n\n{1}".format(
            COMMENT_MARKER, "\n".join("* " + error for error in errors))
    else:
        comment = None

    try:
        replace_comment(token, repo, number, comment)
    except urllib.error.HTTPError as err:
        # Commenting is a courtesy, the check result is what gates the merge.
        print("::warning::Could not update the validator comment: {0}".format(err))

    if errors:
        for error in errors:
            print("::error::" + error)
        sys.exit(1)
    print("{0} passed".format(COMMENT_MARKER))


if __name__ == "__main__":
    main()
