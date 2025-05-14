---
title: Indicator
description: A customizable page indicator component for carousels and pagers
---

# SushiIndicator

A composable that displays page indicators for carousel or pager components.

SushiIndicator integrates with Compose's PagerState to automatically reflect
the current page and animate transitions between pages. It offers three distinct visual styles:

- **Balloon**: Dots expand like a balloon when active
- **Shift**: Active dots expand horizontally into a pill shape
- **Spring**: A separate selector dot moves between fixed position dots

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img src="../preview_indicators.png" alt="Indicator Preview">
</div>

## Example

The `SushiIndicator` component is used to display page indicators that integrate with pagers.

```kotlin
// Create a pager state
val pagerState = rememberPagerState { 5 }

// Basic Balloon Indicator
SushiIndicator(
    dotCount = 5,
    type = SushiIndicatorType.Balloon(),
    pagerState = pagerState,
    modifier = Modifier.padding(16.dp)
)

// Shift Indicator with custom color
SushiIndicator(
    dotCount = 5,
    type = SushiIndicatorType.Shift(
        dotsGraphic = DotGraphic(
            color = SushiTheme.colors.blue.v500.value
        )
    ),
    pagerState = pagerState,
    modifier = Modifier.padding(16.dp)
)

// Spring Indicator with custom dots
SushiIndicator(
    dotCount = 5,
    type = SushiIndicatorType.Spring(
        dotsGraphic = DotGraphic(
            color = Color.Transparent,
            borderColor = SushiTheme.colors.base.theme.v500.value,
            borderWidth = 2.dp,
            size = 12.dp
        ),
        selectorDotGraphic = DotGraphic(
            color = SushiTheme.colors.base.theme.v500.value,
            size = 10.dp
        )
    ),
    pagerState = pagerState,
    modifier = Modifier.padding(16.dp)
)

// Manual control version
SushiIndicator(
    dotCount = totalPages,
    type = SushiIndicatorType.Balloon(),
    currentPage = currentPage,
    currentPageOffsetFraction = { currentOffset },
    onDotClicked = { index -> 
        // Handle dot click to navigate to that page
    },
    modifier = Modifier.padding(16.dp)
)
```

## Component API

### SushiIndicator

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`dotCount`</div>| The total number of pages to display indicators for |
| <div class='parameter'>`type`</div>| The visual style of the indicators (Balloon, Shift, or Spring) |
| <div class='parameter'>`pagerState`</div>| The state of the associated pager component |
| <div class='parameter'>`currentPage`</div>| The current page index (for manual control version) |
| <div class='parameter'>`currentPageOffsetFraction`</div>| Function providing fractional offset (for manual control) |
| <div class='parameter'>`dotSpacing`</div>| Spacing between adjacent dots |
| <div class='parameter'>`onDotClicked`</div>| Optional callback for when a dot is clicked |

### Indicator Types

#### Balloon

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`dotsGraphic`</div>| The appearance configuration for the dots |
| <div class='parameter'>`balloonSizeFactor`</div>| The maximum size multiplication factor for the active dot |

#### Shift

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`dotsGraphic`</div>| The appearance configuration for the dots |
| <div class='parameter'>`shiftSizeFactor`</div>| The maximum width multiplication factor for the active dot |

#### Spring

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`dotsGraphic`</div>| The appearance configuration for the background dots |
| <div class='parameter'>`selectorDotGraphic`</div>| The appearance configuration for the moving selector dot |

### DotGraphic

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`size`</div>| The diameter/size of the dot |
| <div class='parameter'>`color`</div>| The fill color of the dot |
| <div class='parameter'>`shape`</div>| The shape of the dot (default is CircleShape) |
| <div class='parameter'>`borderWidth`</div>| Optional width of the border around the dot |
| <div class='parameter'>`borderColor`</div>| The color of the border (if borderWidth is specified) |