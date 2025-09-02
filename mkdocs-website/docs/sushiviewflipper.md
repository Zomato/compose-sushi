---
title: ViewFlipper
description: A component for automatically cycling through content with animated transitions
---

# SushiViewFlipper

A composable that automatically cycles through multiple content items with animated transitions.

SushiViewFlipper provides a way to display a sequence of items in the same space, automatically
transitioning between them with customizable animation. This is useful for displaying
rotating promotions, suggestions, or other content that should cycle through multiple options.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img class="component-preview" src="../preview_view_flipper.png" alt="ViewFlipper Preview">
</div>

## Example

The `SushiViewFlipper` component is used to automatically cycle through different content items:

```kotlin
// Basic usage with a list of items
val searchSuggestions = listOf(
    "Search for \"Pizza\"",
    "Search for \"Burger\"",
    "Search for \"Pasta\"",
    "Search for \"Sushi\"",
    "Search for \"Salad\""
)

// Create a ViewFlipper that cycles through the suggestions
SushiViewFlipper(
    props = SushiViewFlipperProps(
        count = searchSuggestions.size  // Number of items to display
    ),
    modifier = Modifier.fillMaxWidth()
) { index ->
    // Content for each item based on index
    SushiText(
        props = SushiTextProps(
            text = searchSuggestions[index],
            color = SushiTheme.colors.text.secondary
        ),
        modifier = Modifier.padding(16.dp)
    )
}
```

### Customization Examples

```kotlin
// Custom flip interval (faster transitions)
SushiViewFlipper(
    props = SushiViewFlipperProps(
        count = items.size,
        flipInterval = 1000L  // 1 second flip interval
    ),
    onFlip = { index ->
        // Called when a flip occurs
        currentItemIndex = index
    }
) { index ->
    // Item content
}

// Custom animation direction
SushiViewFlipper(
    props = SushiViewFlipperProps(
        count = items.size,
        animationDirection = SushiViewFlipperProps.FlipAnimationDirection.FlipToBottom
        // New content slides in from top, current content slides out to bottom
    )
) { index ->
    // Item content
}

// Play/Pause control
var isPlaying by remember { mutableStateOf(true) }

SushiViewFlipper(
    props = SushiViewFlipperProps(
        count = items.size,
        isPlaying = isPlaying  // Control whether animation is playing
    )
) { index ->
    // Item content
}

// Custom animation duration
SushiViewFlipper(
    props = SushiViewFlipperProps(
        count = items.size,
        animationDuration = 1200,  // Slower animation (1.2 seconds)
        flipInterval = 4000L       // Show each item for 4 seconds
    )
) { index ->
    // Item content
}
```

### Dynamic Content

```kotlin
// Create state for a dynamic item list
var itemCount by remember { mutableStateOf(3) }

// ViewFlipper with dynamic count
SushiViewFlipper(
    props = SushiViewFlipperProps(
        count = itemCount  // Can be updated to change the number of items
    )
) { index ->
    // Content for the current index
}

// Button to update the content
SushiButton(
    props = SushiButtonProps(text = "Add Item"),
    onClick = {
        itemCount++
    }
)
```

## Component API

### SushiViewFlipperProps

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`flipInterval`</div>| Time in milliseconds between content flips (default: 3000ms) |
| <div class='parameter'>`animationDuration`</div>| Duration of the flip animation in milliseconds (default: 600ms) |
| <div class='parameter'>`animationDirection`</div>| Direction for the flip animation (FlipToTop or FlipToBottom) |
| <div class='parameter'>`isPlaying`</div>| Whether the flipper should be actively cycling (default: true) |
| <div class='parameter'>`count`</div>| Number of items to display in the flipper (default: 1) |

### FlipAnimationDirection

| Value                                   | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`FlipToTop`</div>| New content slides in from bottom, current content slides out to top |
| <div class='parameter'>`FlipToBottom`</div>| New content slides in from top, current content slides out to bottom |