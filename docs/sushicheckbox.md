---
title: SushiCheckBox
description: A customizable checkbox component for the Sushi design system.
---

# SushiCheckBox

A customizable checkbox component for the Sushi design system.

SushiCheckBox provides a standard checkbox implementation with support for:

- Different sizes (Mini, Default)
- Primary and secondary text labels
- Custom positioning (checkbox at start or end)
- Vertical alignment control
- Custom content through the infoContent parameter
- Consistent styling with the design system

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img src="../preview_checkbox.png" alt="CheckBox Preview">
</div>

## Example

The `SushiCheckBox` component is used to create checkboxes with different configurations.

```kotlin
var checked by remember { mutableStateOf(false) }

SushiCheckBox(
    props = SushiCheckBoxProps(
        checked = checked,
        text = SushiTextProps(text = "I accept the terms and conditions"),
        subText = SushiTextProps(
            text = "By checking this box, you agree to our Terms of Service",
            type = SushiTextType.Regular300,
            color = SushiTheme.colors.text.secondary
        ),
        color = SushiTheme.colors.green.v600
    ),
    onCheckedChange = { checked = it },
    modifier = Modifier.fillMaxWidth()
)
```

## Component API

### SushiCheckBox

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`id`</div>| Optional identifier for the checkbox |
| <div class='parameter'>`checked`</div>| Whether the checkbox is checked (true) or unchecked (false) |
| <div class='parameter'>`text`</div>| Primary text properties to display alongside the checkbox |
| <div class='parameter'>`subText`</div>| Secondary text properties to display below the primary text |
| <div class='parameter'>`enabled`</div>| Whether the checkbox is interactive (true) or disabled (false) |
| <div class='parameter'>`color`</div>| The color for the checkbox when checked |
| <div class='parameter'>`size`</div>| The size variant of the checkbox (Mini or Default) |
| <div class='parameter'>`boxPadding`</div>| The padding around the checkbox component |
| <div class='parameter'>`verticalAlignment`</div>| The vertical alignment of the checkbox relative to its text |
| <div class='parameter'>`direction`</div>| The position of the checkbox relative to its text (Start or End) |