---
title: SushiCard
description: A customizable card component for displaying related content in a contained unit.
---

# SushiCard

A customizable card component for the Sushi design system.

SushiCard provides a surface for displaying related content in a contained unit. It supports:

- Custom shapes including rounded corners and ticket shapes
- Solid and dashed borders
- Elevation control
- Custom background colors
- Content composition through ColumnScope

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img src="../preview_card.png" alt="Card Preview">
</div>

## Example

The `SushiCard` component is used to create cards with various styles and configurations.

```kotlin
// Basic card with rounded corners
SushiCard(
    modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        SushiText(
            props = SushiTextProps(
                text = "Card Title",
                type = SushiTextType.SemiBold600
            )
        )
        
        SushiText(
            props = SushiTextProps(
                text = "Card content goes here with any composable content",
                type = SushiTextType.Regular400
            ),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

// Card with custom background color and elevation
SushiCard(
    containerColor = SushiTheme.colors.blue.v100,
    elevation = 8.dp,
    modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
) {
    // Card content here
}

// Card with solid border
SushiCard(
    border = BorderStroke(1.dp, SushiTheme.colors.grey.v300.value),
    shape = RoundedCornerShape(12.dp),
    modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
) {
    // Card content here
}

// Card with dashed border and ticket shape
SushiCard(
    shape = TicketShape(16.dp.toPx(), 0.7f),
    borderConfig = DashedBorderConfig(
        color = SushiTheme.colors.red.v500.value,
        width = 2.dp,
        dashWidth = 5.dp,
        dashGap = 6.dp,
        shape = TicketShape(16.dp.toPx(), 0.7f)
    ),
    modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
) {
    // Card content here
}
```

## Component API

### SushiCard

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`modifier`</div>| The modifier to be applied to the card |
| <div class='parameter'>`borderConfig`</div>| Optional configuration for custom borders (e.g., dashed borders) |
| <div class='parameter'>`shape`</div>| The shape of the card (defaults to rounded corners) |
| <div class='parameter'>`containerColor`</div>| The background color of the card |
| <div class='parameter'>`border`</div>| Optional border stroke for the card (for solid borders) |
| <div class='parameter'>`elevation`</div>| The elevation of the card which determines its shadow |
| <div class='parameter'>`content`</div>| The composable content to be displayed inside the card |

### DashedBorderConfig

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`color`</div>| The color of the border |
| <div class='parameter'>`width`</div>| The thickness of the border line |
| <div class='parameter'>`dashWidth`</div>| The width of each dash in the pattern |
| <div class='parameter'>`dashGap`</div>| The gap between each dash in the pattern |
| <div class='parameter'>`shape`</div>| The shape to apply the border to (e.g., rectangle, rounded corner) |