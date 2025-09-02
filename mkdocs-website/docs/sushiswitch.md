---
title: SushiSwitch
description: A customizable toggle switch component for the Sushi design system.
---

# SushiSwitch

A customizable toggle switch component for the Sushi design system.

SushiSwitch provides a standard switch component with support for:

- Primary and secondary text labels
- Custom positioning (switch at start or end)
- Vertical alignment control
- Customizable colors
- Custom content through the infoContent parameter
- Accessibility through semantic properties

Switches are typically used to toggle between two states (on/off) for a single option.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img class="component-preview" src="../preview_switch.png" alt="Switch Preview">
</div>

## Example

The `SushiSwitch` component is used to create toggle switches for settings and preferences.

```kotlin
var notificationsEnabled by remember { mutableStateOf(true) }

SushiSwitch(
    props = SushiSwitchProps(
        isChecked = notificationsEnabled,
        text = SushiTextProps(
            text = "Push Notifications",
            type = SushiTextType.Medium500
        ),
        subText = SushiTextProps(
            text = "Receive alerts about new offers and updates",
            type = SushiTextType.Regular300,
            color = SushiTheme.colors.text.secondary
        )
    ),
    onCheckedChange = { notificationsEnabled = it },
    modifier = Modifier.padding(vertical = 4.dp)
)
```

## Component API

### SushiSwitch

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`id`</div>| Optional identifier for the switch |
| <div class='parameter'>`isChecked`</div>| Whether the switch is checked (on) or unchecked (off) |
| <div class='parameter'>`text`</div>| Primary text properties to display alongside the switch |
| <div class='parameter'>`subText`</div>| Secondary text properties to display below the primary text |
| <div class='parameter'>`isEnabled`</div>| Whether the switch is interactive (true) or disabled (false) |
| <div class='parameter'>`color`</div>| The color for the switch when checked |
| <div class='parameter'>`padding`</div>| The padding around the switch component |
| <div class='parameter'>`verticalAlignment`</div>| The vertical alignment of the switch relative to its text |
| <div class='parameter'>`direction`</div>| The position of the switch relative to its text (Start or End) |