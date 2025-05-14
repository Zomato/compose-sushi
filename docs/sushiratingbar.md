---
title: Rating Bar
description: A customizable star-based rating component for user input and display
---

# SushiRatingBar

A customizable rating bar component for the Sushi design system.

SushiRatingBar displays a row of stars that can be partially or fully filled to represent
a rating value. Users can interact with the rating bar to select a rating by tapping on
the stars. The component provides visual feedback through scaling animations when pressed.

Use this component to collect user ratings or display rating information for items like
restaurants, products, or services.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img src="../preview_ratingbar.png" alt="Rating Bar Preview">
</div>

## Example

The `SushiRatingBar` component is used to display and collect star ratings:

```kotlin
// Create state to track rating value
var rating by remember { mutableFloatStateOf(3.5f) }

// Basic usage with default settings (5 stars)
SushiRatingBar(
    props = SushiRatingBarProps(
        rating = rating
    ),
    onRatingChange = {
        rating = it
        // Handle the rating change
    }
)

// Custom configuration
SushiRatingBar(
    props = SushiRatingBarProps(
        rating = rating,
        starCount = 4,                  // Show 4 stars instead of 5
        betweenSpacing = 12.dp,         // Custom spacing between stars
        tintColor = SushiTheme.colors.yellow.v600  // Custom star color
    ),
    onRatingChange = {
        rating = it
    },
    modifier = Modifier.height(32.dp)   // Custom height
)

// Read-only rating display (ignore onRatingChange)
SushiRatingBar(
    props = SushiRatingBarProps(
        rating = 4.5f,
        tintColor = SushiTheme.colors.yellow.v500
    ),
    onRatingChange = { /* do nothing for read-only */ }
)

// Displaying partial stars
SushiRatingBar(
    props = SushiRatingBarProps(
        rating = 3.7f  // Will show 3 full stars and 1 star at 70% filled
    ),
    onRatingChange = { rating = it }
)
```

## Component API

### SushiRatingBarProps

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`rating`</div>| The current rating value, representing the number of filled stars. Can be a fractional value for partial star filling. |
| <div class='parameter'>`betweenSpacing`</div>| The spacing between each star in the rating bar |
| <div class='parameter'>`starCount`</div>| The total number of stars to display in the rating bar (default is 5) |
| <div class='parameter'>`tintColor`</div>| Optional color to apply to the stars |

### Default Values

| Value                               | Default                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`starCount`</div>| 5 stars |
| <div class='parameter'>`betweenSpacing`</div>| 10.dp |
| <div class='parameter'>`startSize`</div>| 20.dp (default height) |