---
title: Shimmer
description: A customizable loading state shimmer effect
---

# SushiShimmer

A composable that displays a shimmer loading effect over placeholder content.

SushiShimmer creates a shimmering animation effect typically used to indicate
loading states in UI. It provides a scope that allows creating shimmer effects
over custom shapes and text elements.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img src="../preview_shimmer.png" alt="Shimmer Preview">
</div>

## Example

The `SushiShimmer` component is used to create loading state indicators with customizable
animations:

```kotlin
// Basic shimmer with default properties
SushiShimmer(
    props = SushiShimmerProps(),
    modifier = Modifier.fillMaxWidth()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header with circle and text
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ShimmerItem(
                Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Column {
                ShimmerItem(
                    Modifier
                        .height(16.dp)
                        .width(150.dp)
                        .clip(RoundedCornerShape(4.dp))
                )
                Spacer(modifier = Modifier.height(8.dp))
                ShimmerItem(
                    Modifier
                        .height(12.dp)
                        .width(100.dp)
                        .clip(RoundedCornerShape(4.dp))
                )
            }
        }
        
        // Content
        ShimmerItem(
            Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    }
}

// Shimmer with custom colors and animation parameters
SushiShimmer(
    props = SushiShimmerProps(
        bgColor = SushiTheme.colors.blue.v100,
        animationColor = SushiTheme.colors.blue.v300,
        animationDuration = 800,
        animationDelay = 0
    ),
    modifier = Modifier.fillMaxWidth()
) {
    // Your shimmer content here
}

// Shimmer with text elements
SushiShimmer(
    props = SushiShimmerProps(),
    modifier = Modifier.fillMaxWidth()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ShimmerText(
            sushiTextProps = SushiTextProps(
                text = "This is a shimmer text headline",
                type = SushiTextType.Bold700
            ),
            modifier = Modifier.fillMaxWidth()
        )
        
        ShimmerText(
            sushiTextProps = SushiTextProps(
                text = "This is a longer paragraph text that demonstrates how the shimmer effect works.",
                type = SushiTextType.Regular400
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
```

## Component API

### SushiShimmerProps

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`bgColor`</div>| The background color of the shimmer effect |
| <div class='parameter'>`animationColor`</div>| The highlight color that moves across the shimmer |
| <div class='parameter'>`animationWidth`</div>| The width of the highlight gradient in dp |
| <div class='parameter'>`angleOffset`</div>| The angle offset of the gradient to create diagonal effects |
| <div class='parameter'>`animationDuration`</div>| The duration of one complete animation cycle in milliseconds |
| <div class='parameter'>`animationDelay`</div>| The delay between animation cycles in milliseconds |

### SushiShimmerScope

Within the SushiShimmer content lambda, you have access to these functions:

| Function                                | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`ShimmerItem(modifier: Modifier)`</div>| Creates a generic shimmer item with the specified modifier. This can be used to create placeholder shapes with the shimmer effect. |
| <div class='parameter'>`ShimmerText(sushiTextProps: SushiTextProps, modifier: Modifier)`</div>| Creates a shimmer text with the specified text properties and modifier. This applies the shimmer effect to text content. |