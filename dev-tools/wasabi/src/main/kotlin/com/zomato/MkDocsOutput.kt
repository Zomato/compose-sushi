package com.zomato

import com.zomato.data.Config

internal fun generateMkDocsIconBrowserPage(config: Config): String {
    val iconCount = config.glyphs.size
    val iconJsonEntries = config.glyphs.joinToString(",\n") { icon ->
        val name = icon.css.sanitizeForDisplay()
        val code = icon.code.toString(16)
        """    {"name": "$name", "code": "$code"}"""
    }

    return """---
title: Icon Browser
description: Browse and search all Wasabi icons available in the Sushi design system.
---

# Icon Browser

Browse and search all **$iconCount** Wasabi icons available in the Sushi design system. Icons are rendered using the Wasabi icon font.

<div id="icon-browser">
    <input
        type="text"
        id="icon-search"
        placeholder="Search by icon name or code..."
        oninput="filterIcons()"
    />
    <div id="icon-count"></div>
    <div id="icon-grid"></div>
</div>

<style>
#icon-browser {
    font-family: var(--md-text-font, "okra", sans-serif);
}
#icon-search {
    width: 100%;
    padding: 12px 16px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 12px;
    box-sizing: border-box;
    outline: none;
    font-family: inherit;
    transition: border-color 0.2s;
}
#icon-search:focus {
    border-color: #d52e3f;
    box-shadow: 0 0 0 2px rgba(213, 46, 63, 0.15);
}
#icon-count {
    margin: 8px 0 4px 4px;
    font-size: 13px;
    color: #888;
}
#icon-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(140px, 1fr));
    gap: 12px;
    margin-top: 12px;
}
.icon-card {
    background: #f8f9fb;
    border-radius: 12px;
    padding: 16px 8px 12px;
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
    transition: box-shadow 0.2s, transform 0.15s;
    cursor: pointer;
    border: 1px solid transparent;
}
.icon-card:hover {
    box-shadow: 0 2px 12px rgba(0,0,0,0.10);
    transform: translateY(-2px);
    border-color: #e0e0e0;
}
.icon-glyph {
    font-family: "wasabi" !important;
    font-size: 22px;
    line-height: 1;
    color: #272727;
    margin-bottom: 10px;
}
.icon-name {
    font-size: 12px;
    color: #333;
    word-break: break-word;
    line-height: 1.3;
}
.icon-code {
    font-size: 13px;
    color: #555;
    margin-top: 6px;
    padding: 2px 8px;
    background: #eef0f4;
    border-radius: 4px;
    font-family: var(--md-text-font, "okra", sans-serif);
    letter-spacing: 0.3px;
}
.icon-card.copied .icon-code {
    color: #d52e3f;
    font-weight: bold;
}
</style>

<script>
var ALL_ICONS = [
$iconJsonEntries
];

function renderIcons(icons) {
    var grid = document.getElementById("icon-grid");
    var countEl = document.getElementById("icon-count");
    countEl.textContent = icons.length + " icon" + (icons.length !== 1 ? "s" : "") + " found";
    if (icons.length === 0) {
        grid.innerHTML = '<div style="grid-column:1/-1;text-align:center;padding:40px;color:#888;">No icons match your search.</div>';
        return;
    }
    var html = "";
    for (var i = 0; i < icons.length; i++) {
        var ic = icons[i];
        html += '<div class="icon-card" onclick="copyCode(this, \'' + ic.code + '\')" title="Click to copy code: ' + ic.code + '">';
        html += '<div class="icon-glyph">&#x' + ic.code + ';</div>';
        html += '<div class="icon-name">' + ic.name + '</div>';
        html += '<div class="icon-code">' + ic.code + '</div>';
        html += '</div>';
    }
    grid.innerHTML = html;
}

function filterIcons() {
    var q = document.getElementById("icon-search").value.toLowerCase().trim();
    if (!q) {
        renderIcons(ALL_ICONS);
        return;
    }
    var filtered = ALL_ICONS.filter(function(ic) {
        return ic.name.toLowerCase().indexOf(q) !== -1 || ic.code.indexOf(q) !== -1;
    });
    renderIcons(filtered);
}

function copyCode(el, code) {
    if (navigator.clipboard) {
        navigator.clipboard.writeText(code);
    }
    el.classList.add("copied");
    var codeEl = el.querySelector(".icon-code");
    var orig = codeEl.textContent;
    codeEl.textContent = "Copied!";
    setTimeout(function() {
        el.classList.remove("copied");
        codeEl.textContent = orig;
    }, 1200);
}

document.addEventListener("DOMContentLoaded", function() {
    renderIcons(ALL_ICONS);
});
</script>
"""
}
