---
title: SushiRadioButton
description: A customizable radio button component for the Sushi design system.
---

# SushiRadioButton

A customizable radio button component for the Sushi design system.

SushiRadioButton provides a standard radio button implementation with support for:

- Primary and secondary text labels
- Custom positioning (radio button at start or end)
- Vertical alignment control
- Custom colors for selected and unselected states
- Custom content through the infoContent parameter
- Accessibility through semantic properties

Radio buttons are typically used in groups where only one option can be selected at a time,
though this component doesn't enforce that behavior - it's up to the parent component to
manage the selected state across a group of radio buttons.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img class="component-preview" src="../preview_radiobutton.png" alt="RadioButton Preview">
</div>

## Example

The `SushiRadioButton` component is used to create radio button groups where only one option can be
selected.

```kotlin
var selectedOption by remember { mutableIntStateOf(1) }

SushiRadioButton(
    props = SushiRadioButtonProps(
        selected = selectedOption == 1,
        text = SushiTextProps(
            text = "Standard Delivery",
            type = SushiTextType.Medium500
        ),
        subText = SushiTextProps(
            text = "Free • 3-5 business days",
            type = SushiTextType.Regular300,
            color = SushiTheme.colors.text.secondary
        )
    ),
    onClick = { selectedOption = 1 },
    modifier = Modifier.padding(vertical = 4.dp)
)

SushiRadioButton(
    props = SushiRadioButtonProps(
        selected = selectedOption == 2,
        text = SushiTextProps(
            text = "Express Delivery",
            type = SushiTextType.Medium500
        ),
        subText = SushiTextProps(
            text = "$5.99 • 1-2 business days",
            type = SushiTextType.Regular300,
            color = SushiTheme.colors.text.secondary
        )
    ),
    onClick = { selectedOption = 2 },
    modifier = Modifier.padding(vertical = 4.dp)
)
```

## Component API

### SushiRadioButton

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`id`</div>| Optional identifier for the radio button |
| <div class='parameter'>`selected`</div>| Whether the radio button is selected (true) or unselected (false) |
| <div class='parameter'>`text`</div>| Primary text properties to display alongside the radio button |
| <div class='parameter'>`subText`</div>| Secondary text properties to display below the primary text |
| <div class='parameter'>`enabled`</div>| Whether the radio button is interactive (true) or disabled (false) |
| <div class='parameter'>`unselectedColor`</div>| The color for the radio button when unselected |
| <div class='parameter'>`selectedColor`</div>| The color for the radio button when selected |
| <div class='parameter'>`padding`</div>| The padding around the radio button component |
| <div class='parameter'>`verticalAlignment`</div>| The vertical alignment of the radio button relative to its text |
| <div class='parameter'>`direction`</div>| The position of the radio button relative to its text (Start or End) |