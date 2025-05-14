---
title: SushiTag
description: A customizable tag component for displaying categories, attributes, or status information.
---

# SushiTag

A customizable tag component for the Sushi design system.

SushiTag is a small, compact component typically used to display categories,
attributes, or status information. It supports various visual styles (rounded,
capsule, outlined, dashed), sizes, and optional prefix/suffix icons.

Tags can be interactive (clickable) or static, and can contain custom content
or use the standard text and icon layout.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img src="../preview_tag.png" alt="Tag Preview">
</div>

## Example

The `SushiTag` component is used to create compact, visual indicators for various attributes and
categories.

```kotlin
// Basic tag
SushiTag(
    props = SushiTagProps(
        text = "Capsule",
        type = SushiTagType.Capsule,
        size = SushiTagSize.Medium
    )
)

// Tag with icon and custom colors
SushiTag(
    props = SushiTagProps(
        text = "Vegetarian",
        type = SushiTagType.RoundedOutline,
        size = SushiTagSize.Small,
        prefixIcon = SushiIconProps(
            code = SushiIconCodes.IconCheck,
            color = SushiTheme.colors.green.v600
        ),
        borderColor = SushiTheme.colors.green.v600,
        fontColor = SushiTheme.colors.green.v600
    )
)
```

## Component API

### SushiTag

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`text`</div>| The text content to display in the tag |
| <div class='parameter'>`size`</div>| The size variant of the tag (affects padding and text size) |
| <div class='parameter'>`type`</div>| The visual style of the tag (affects shape and border) |
| <div class='parameter'>`color`</div>| The background color of the tag |
| <div class='parameter'>`fontColor`</div>| The color of the text and icons in the tag |
| <div class='parameter'>`borderColor`</div>| The color of the border (for outline and dashed types) |
| <div class='parameter'>`suffixIcon`</div>| Optional icon to display after the text |
| <div class='parameter'>`prefixIcon`</div>| Optional icon to display before the text |
| <div class='parameter'>`iconSpacing`</div>| Custom spacing between icons and text |
| <div class='parameter'>`shape`</div>| Optional custom shape to override the default shape from the type |
| <div class='parameter'>`markdown`</div>| Whether to interpret the text content as markdown |