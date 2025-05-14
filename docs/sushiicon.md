---
title: SushiIcon
description: A composable component that displays an icon from the Sushi design system.
---

# SushiIcon

A composable component that displays an icon from the Sushi design system.

SushiIcon renders icons from the Wasabi icon font based on the provided properties.
It supports customization of size, color, and click interactions.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img src="../preview_icon.png" alt="Icon Preview">
</div>

## Example

The `SushiIcon` component is used to display an icon from the Sushi design system.

```kotlin
SushiIcon(
    SushiIconProps(
        code = SushiIconCodes.IconMStarfilled,
        size = SushiIconSize.Size900
    )
)
```

## Component API

### SushiIcon

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`code`</div>| The SushiIconCode representing the specific icon to display |
| <div class='parameter'>`size`</div>| The size specification for the icon |
| <div class='parameter'>`color`</div>| The color specification for the icon |
| <div class='parameter'>`parsedIcon`</div>| The parsed Unicode character derived from the icon code |