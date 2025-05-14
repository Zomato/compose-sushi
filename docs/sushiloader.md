---
title: SushiLoader
description: An animated loading indicator with two concentric rotating arcs.
---

# SushiLoader

A composable that displays an animated loading indicator with two concentric rotating arcs.

SushiLoader provides a visually appealing loading animation using two concentric arcs
that rotate at different angles. The component adapts to the available space while
maintaining a minimum size to ensure visibility. The animation, colors, and angular
relationship between arcs can be customized through props.

The loader automatically scales to fill its container while maintaining proper proportions,
making it suitable for various use cases from small inline loaders to large centered spinners.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img src="../preview_loader.png" alt="Loader Preview">
</div>

## Example

The `SushiLoader` component is used to display loading indicators with various customizations.

```kotlin
// Default loader
SushiLoader(
    props = SushiLoaderProps()
)

// Custom size
SushiLoader(
    props = SushiLoaderProps(),
    modifier = Modifier.size(48.dp)
)

// Custom colors
SushiLoader(
    props = SushiLoaderProps(
        outerColor = SushiColorData(ColorName.Blue, ColorVariation.Variation500),
        innerColor = SushiColorData(ColorName.Green, ColorVariation.Variation500)
    )
)

// Custom animation speed and angle
SushiLoader(
    props = SushiLoaderProps(
        animationSpeedMultiplier = 2.0f,
        innerAngleOffset = 90f
    )
)
```

## Component API

### SushiLoader

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`innerAngleOffset`</div>| The angular offset between the inner and outer arcs in degrees |
| <div class='parameter'>`outerColor`</div>| The color of the outer arc |
| <div class='parameter'>`innerColor`</div>| The color of the inner arc |
| <div class='parameter'>`animationSpeedMultiplier`</div>| Factor that controls animation speed (higher values = faster) |