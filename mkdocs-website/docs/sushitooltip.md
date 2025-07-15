---
title: Tooltip
description: A customizable tooltip component for displaying contextual information
---

# SushiTooltip

A customizable tooltip component for the Sushi design system.

SushiTooltip displays contextual information or hints when users hover over or interact with UI
elements. The component supports customizable content, including text, images, and custom layouts,
with configurable appearance options like color, shape, and pointer position.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img class="component-preview" src="../preview_tooltip.png" alt="Tooltip Preview">
</div>

## Example

The `SushiTooltip` component is used within a `SushiTooltipBox` to create tooltips:

```kotlin
// First, create a tooltip state and remember a coroutine scope
val tooltipState = rememberTooltipState()
val scope = rememberCoroutineScope()

// Basic text tooltip
SushiTooltipBox(
    positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
    tooltip = {
        SushiTooltip(
            props = SushiTooltipProps(
                text = SushiTextProps(
                    text = "This is a basic tooltip with text only",
                    color = SushiTheme.colors.text.inverse
                )
            )
        )
    },
    state = tooltipState
) {
    // Anchor element - the tooltip will be positioned relative to this
    SushiButton(
        props = SushiButtonProps(text = "Hover or Click Me"),
        onClick = {
            scope.launch {
                tooltipState.show()
            }
        }
    )
}
```

### Customization Examples

```kotlin
// Tooltip with prefix and suffix icons
SushiTooltip(
    props = SushiTooltipProps(
        text = SushiTextProps(
            text = "Important information",
            color = SushiTheme.colors.text.inverse
        ),
        prefixImage = SushiImageProps(
            painterResource(R.drawable.ic_info),
            width = 20.dp,
            contentDescription = "Info",
            colorFilter = ColorFilter.tint(SushiTheme.colors.yellow.v500.value)
        ),
        suffixImage = SushiImageProps(
            painterResource(R.drawable.ic_warning),
            width = 20.dp,
            contentDescription = "Warning"
        )
    )
)

// Custom colored tooltip
SushiTooltip(
    props = SushiTooltipProps(
        text = SushiTextProps(
            text = "Warning: This action cannot be undone",
            color = Color.White
        ),
        containerColor = SushiTheme.colors.red.v600,
        prefixImage = SushiImageProps(
            painterResource(R.drawable.ic_warning),
            width = 20.dp,
            contentDescription = "Warning",
            colorFilter = ColorFilter.tint(Color.White)
        )
    )
)

// Custom shape tooltip with no caret
SushiTooltip(
    props = SushiTooltipProps(
        text = SushiTextProps(
            text = "This tooltip has a custom shape with no caret",
            color = SushiTheme.colors.text.inverse
        ),
        caretSize = DpSize.Unspecified,  // No caret
        shape = RoundedCornerShape(16.dp)  // More rounded corners
    )
)

// Tooltip with custom content
SushiTooltip(
    props = SushiTooltipProps(
        containerColor = SushiTheme.colors.blue.v700
    ),
    content = {
        Column(modifier = Modifier.padding(16.dp)) {
            SushiText(
                props = SushiTextProps(
                    text = "Custom Tooltip",
                    type = SushiTextType.Bold600,
                    color = Color.White
                )
            )
            
            // More custom content...
        }
    }
)
```

### Programmatically Showing/Hiding Tooltips

```kotlin
// Show the tooltip
scope.launch {
    tooltipState.show()
}

// Hide the tooltip
scope.launch {
    tooltipState.dismiss()
}
```

## Component API

### SushiTooltipProps

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`text`</div>| Properties for configuring the tooltip's text content |
| <div class='parameter'>`prefixImage`</div>| Optional image to display before the text |
| <div class='parameter'>`suffixImage`</div>| Optional image to display after the text |
| <div class='parameter'>`containerColor`</div>| Background color of the tooltip (defaults to inverse surface color) |
| <div class='parameter'>`caretSize`</div>| Size of the tooltip's pointer/caret (width and height) |
| <div class='parameter'>`shape`</div>| Shape of the tooltip container (defaults to rounded corners) |
| <div class='parameter'>`shadowElevation`</div>| Shadow depth for the tooltip to create visual hierarchy |

### SushiTooltipBox Parameters

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`positionProvider`</div>| Provider that determines tooltip position relative to anchor |
| <div class='parameter'>`tooltip`</div>| Tooltip content to be displayed when triggered |
| <div class='parameter'>`state`</div>| State object that controls when the tooltip is shown or hidden |
| <div class='parameter'>`focusable`</div>| Whether the tooltip can receive focus |
| <div class='parameter'>`enableUserInput`</div>| Whether user interactions can trigger the tooltip |
| <div class='parameter'>`content`</div>| The anchor content that the tooltip will be attached to |