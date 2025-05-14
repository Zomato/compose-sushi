---
title: Text
description: A customizable text component with rich styling options
---

# SushiText

A customizable text component that supports various styling options, decorations, prefix/suffix
icons, and expandable text functionality.

Features:

 * Text styling with different typography styles
 * Optional prefix and suffix icons or custom composables
 * Text decorations like underline and strikethrough
 * Support for markdown formatting
 * Expandable text with "read more" functionality
 * Text alignment and arrangement customization

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img src="../preview_text.png" alt="Text Preview">
</div>

## Example

The `SushiText` component is used to display text with various styles and properties.

```kotlin
SushiText(
    props = SushiTextProps(
        text = "Hello World!",
        prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
        suffixIcon = SushiIconProps(code = SushiIconCodes.IconContactlessDining, color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)),
        color = SushiColorData(ColorName.Red, ColorVariation.Variation500),
        type = SushiTextType.Regular300,
        horizontalArrangement = Arrangement.SpaceBetween,
        textDecoration = SushiTextDecoration.Underline()
    ),
    Modifier.fillMaxWidth()
)
```

## Component API

### SushiText

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`text`</div>| The text content to display |
| <div class='parameter'>`color`</div>| The color specification for the text |
| <div class='parameter'>`type`</div>| The typography style to apply to the text |
| <div class='parameter'>`maxLines`</div>| Maximum number of lines to display before truncating |
| <div class='parameter'>`prefixIcon`</div>| Optional icon to display before the text |
| <div class='parameter'>`suffixIcon`</div>| Optional icon to display after the text |
| <div class='parameter'>`letterSpacing`</div>| Spacing between letters in the text |
| <div class='parameter'>`markdown`</div>| Whether to interpret the text as markdown |
| <div class='parameter'>`textDecoration`</div>| Optional decoration to apply to the text (underline or strikethrough) |
| <div class='parameter'>`textAlign`</div>| Text alignment within its container |
| <div class='parameter'>`overflow`</div>| How to handle text that doesn't fit within maxLines |
| <div class='parameter'>`overflowText`</div>| Text to show as part of the "read more" functionality |
| <div class='parameter'>`overflowTextColor`</div>| Color for the overflow text |
| <div class='parameter'>`softWrap`</div>| Whether text should wrap to the next line |
| <div class='parameter'>`minLines`</div>| Minimum number of lines to display |
| <div class='parameter'>`prefixSpacing`</div>| Space between the prefix icon and the text |
| <div class='parameter'>`suffixSpacing`</div>| Space between the text and the suffix icon |
| <div class='parameter'>`horizontalArrangement`</div>| How to arrange content horizontally |
| <div class='parameter'>`verticalAlignment`</div>| How to align content vertically |
| <div class='parameter'>`textBrush`</div>| Optional brush for creating gradient or other effects on text |