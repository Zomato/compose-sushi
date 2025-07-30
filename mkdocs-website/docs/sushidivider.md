---
title: Divider
description: A customizable divider component with various styles
---

# SushiDivider

A composable that displays a divider with various customizable styles.

SushiDivider provides visual separation between content sections using different
line styles such as solid, dotted, dashed, and decorative patterns like zigzags.
It supports both horizontal and vertical orientations as well as customizable colors
and thicknesses.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img class="component-preview" src="../preview_divider.png" alt="Divider Preview">
</div>

## Example

The `SushiDivider` component is used to create visual separation between content elements.

```kotlin
// Basic straight divider
SushiDivider(
    props = SushiDividerProps(
        type = SushiDividerType.Straight,
        color = SushiColorData(ColorName.Red, ColorVariation.Variation500)
    ),
    Modifier.fillMaxWidth().padding(vertical = 16.dp)
)

// Dotted divider
SushiDivider(
    props = SushiDividerProps(
        type = SushiDividerType.Dotted,
        color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)
    ),
    Modifier.fillMaxWidth().padding(vertical = 16.dp)
)

// ZigZag pattern divider
SushiDivider(
    props = SushiDividerProps(
        type = SushiDividerType.ZigZag(
            direction = SushiDividerType.ZigZag.Direction.Top,
            radius = 2.dp,
            width = 24.dp,
            height = 12.dp
        ),
        color = SushiColorData(ColorName.Green, ColorVariation.Variation500),
    ),
    Modifier.fillMaxWidth().padding(vertical = 16.dp)
)
```

## Component API

### SushiDividerProps

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`type`</div>| The visual style of the divider (default is SushiDividerType.Straight) |
| <div class='parameter'>`color`</div>| The color of the divider (default is determined by theme) |
| <div class='parameter'>`height`</div>| The thickness of the divider (default varies by type) |

### SushiDividerType

The `SushiDividerType` defines different visual styles for dividers:

| Type                                   | Description                      |
|---------------------------------------|----------------------------------|
| <div class='parameter'>`Straight`</div>| A standard solid straight line divider |
| <div class='parameter'>`Dotted`</div>| A dotted line divider with small, closely spaced dots |
| <div class='parameter'>`Dashed`</div>| A dashed line divider with small dashes and gaps |
| <div class='parameter'>`StraightThick`</div>| A solid straight line divider with a thicker stroke width |
| <div class='parameter'>`DottedSpaced`</div>| A dotted line divider with larger spacing between dots |
| <div class='parameter'>`Vertical`</div>| A vertical solid straight line divider |
| <div class='parameter'>`VerticalDotted`</div>| A vertical dotted line divider with small, closely spaced dots |
| <div class='parameter'>`ZigZag`</div>| A decorative zigzag pattern divider with configurable direction, radius, width, and height |
| <div class='parameter'>`Pink`</div>| A special pink-colored divider (project-specific) |
| <div class='parameter'>`Menu`</div>| A menu-style divider with a triangular notch (project-specific) |