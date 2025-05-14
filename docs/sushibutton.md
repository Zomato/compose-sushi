---
title: SushiButton
description: A customizable button component that supports different visual styles, sizes, and content configurations.
---

# SushiButton

A customizable button component that supports different visual styles, sizes, and content
configurations.

SushiButton provides a standardized button implementation with support for:

- Different visual styles (Text, Solid, Outline)
- Various sizes (Small, Medium, Large)
- Prefix and suffix icons
- Custom content through the content parameter
- Accessibility through semantic properties

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img src="../preview_button.png" alt="Button Preview">
</div>

## Example

The `SushiButton` component is used to create buttons with various styles and configurations.

```kotlin
SushiButton(
    props = SushiButtonProps(
        text = "Solid Button",
        type = SushiButtonType.Solid,
        prefixIcon = SushiIconProps(code = SushiIconCodes.IconStarFill)
    ),
    onClick = { /* Handle click */ },
    modifier = Modifier.fillMaxWidth()
)
```

## Component API

### SushiButton

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`text`</div>| Primary text to display in the button |
| <div class='parameter'>`subText`</div>| Optional secondary text below the primary text |
| <div class='parameter'>`type`</div>| Button style type (Text, Solid, or Outline) |
| <div class='parameter'>`size`</div>| Button size variant (Small, Medium, or Large) |
| <div class='parameter'>`fontColor`</div>| Color for the button text |
| <div class='parameter'>`fontType`</div>| Typography style for the button text |
| <div class='parameter'>`color`</div>| Background color of the button |
| <div class='parameter'>`borderColor`</div>| Color of the button border (for Outline type) |
| <div class='parameter'>`suffixIcon`</div>| Optional icon to display after the button text |
| <div class='parameter'>`prefixIcon`</div>| Optional icon to display before the button text |
| <div class='parameter'>`enabled`</div>| Whether the button is enabled and can be interacted with |
| <div class='parameter'>`horizontalArrangement`</div>| How to arrange content horizontally in the button |
| <div class='parameter'>`verticalAlignment`</div>| How to align content vertically in the button |
| <div class='parameter'>`textAlignment`</div>| Horizontal alignment of text within the button |
| <div class='parameter'>`markdown`</div>| Whether to interpret text as markdown |
| <div class='parameter'>`shape`</div>| The shape of the button |
| <div class='parameter'>`iconSpacing`</div>| Spacing between icons and text |