---
title: Horizontal Pager
description: Horizontal paging components for carousels and swipeable content
---

# SushiHorizontalPager

SushiHorizontalPager allow users to swipe between pages of content. It provides a way to create carousels, image galleries, onboarding flows, or any UI
that requires paging through content, and enables horizontal swiping.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img class="component-preview" src="../preview_horizontal_pager.png" alt="Pager Preview">
</div>

## Example

### SushiHorizontalPager

```kotlin
// First, create a PagerState that manages the paging behavior
val pagerState = rememberPagerState(pageCount = { 5 }) // 5 pages

// Create the pager with default settings
SushiHorizontalPager(
    state = pagerState,
    modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
) { page ->
    // Content for each page
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        SushiText(
            props = SushiTextProps(
                text = "Page ${page + 1}",
                type = SushiTextType.Bold700
            )
        )
    }
}

// Create a pager with custom styling and behavior
SushiHorizontalPager(
    state = pagerState,
    contentPadding = PaddingValues(horizontal = 32.dp), // Padding on sides
    pageSpacing = 16.dp, // Space between pages
    pageSize = PageSize.Fixed(180.dp), // Fixed page width
    beyondViewportPageCount = 2, // Keep 2 offscreen pages loaded
    userScrollEnabled = true // Allow user scrolling
) { page ->
    // Page content goes here
}
```

### Programmatic Navigation

```kotlin
val scope = rememberCoroutineScope()
val pagerState = rememberPagerState(pageCount = { 5 })

// Navigate to a specific page with animation
SushiButton(
    props = SushiButtonProps(text = "Next Page"),
    onClick = {
        scope.launch {
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.animateScrollToPage(nextPage)
        }
    }
)
```

### Auto-Scrolling Carousel

```kotlin
// Auto-scroll effect
var autoScrollEnabled by remember { mutableStateOf(true) }
val pagerState = rememberPagerState(pageCount = { items.size })

LaunchedEffect(autoScrollEnabled) {
    if (autoScrollEnabled) {
        while(true) {
            delay(3000) // Scroll every 3 seconds
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.animateScrollToPage(nextPage)
        }
    }
}

// The pager
SushiHorizontalPager(
    state = pagerState,
    // other properties
) { page ->
    // Page content
}
```

### Using with Page Indicators

```kotlin
Box(modifier = Modifier.fillMaxWidth()) {
    // The pager
    SushiHorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) { page ->
        // Page content
    }
    
    // Page indicators at the bottom
    Box(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(16.dp)
    ) {
        SushiIndicator(
            dotCount = pagerState.pageCount,
            type = SushiIndicatorType.Balloon(
                dotsGraphic = DotGraphic(
                    color = Color.White,
                    size = 8.dp
                )
            ),
            pagerState = pagerState
        )
    }
}
```

## Component API

### SushiHorizontalPager Parameters

Both components share most parameters, with slight differences due to orientation:

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`state`</div>| The state object to control and observe the pager's state |
| <div class='parameter'>`modifier`</div>| The modifier to be applied to the pager |
| <div class='parameter'>`contentPadding`</div>| Padding to be applied to the pager content |
| <div class='parameter'>`pageSize`</div>| Strategy defining how pages should be sized |
| <div class='parameter'>`beyondViewportPageCount`</div>| The number of pages to keep loaded beyond the visible viewport |
| <div class='parameter'>`pageSpacing`</div>| Spacing between each page |
| <div class='parameter'>`flingBehavior`</div>| The fling behavior that defines how the pager should handle fling gestures |
| <div class='parameter'>`userScrollEnabled`</div>| Whether user scrolling is enabled |
| <div class='parameter'>`reverseLayout`</div>| Whether the layout should be reversed |
| <div class='parameter'>`key`</div>| Optional lambda to provide a unique key for each page |
| <div class='parameter'>`pageNestedScrollConnection`</div>| Nested scroll connection to be applied to each page |
| <div class='parameter'>`snapPosition`</div>| Position to which the pages should snap |
| <div class='parameter'>`verticalAlignment`</div>| Vertical alignment of each page within the pager |