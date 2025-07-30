---
title: Snackbar
description: A customizable snackbar component for brief messages
---

# SushiSnackbar

A composable that displays a snackbar message with an optional action.

SushiSnackbar provides brief feedback about operations through a message at the
bottom of the screen. It can include an action button and customizable styling.
Snackbars are typically used to inform users of a process that an app has performed
or will perform, and provide an opportunity to respond or undo that action.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img class="component-preview" src="../preview_snackbar.png" alt="Snackbar Preview">
</div>

## Example

The `SushiSnackbar` component is typically used with a `SushiSnackbarHostState` to show messages:

```kotlin
// First, create and remember a snackbar host state
val snackbarHostState = remember { SushiSnackbarHostState() }
val scope = rememberCoroutineScope()

// Then, add the snackbar host to your Scaffold
Scaffold(
    modifier = Modifier.fillMaxSize(),
    snackbarHost = {
        SushiSnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.padding(16.dp)
        )
    }
) { innerPadding ->
    // Your screen content
    
    // Button to trigger the snackbar
    SushiButton(
        props = SushiButtonProps(text = "Show Snackbar"),
        onClick = {
            scope.launch {
                // Basic snackbar
                val basicProps = SushiSnackbarProps(
                    message = SushiTextProps(
                        text = "This is a basic snackbar message",
                        type = SushiTextType.Regular400
                    ),
                    snackbarDuration = SushiSnackbarDuration.Short
                )
                snackbarHostState.showSnackbar(basicProps)
                
                // Snackbar with action
                val actionProps = SushiSnackbarProps(
                    message = SushiTextProps(text = "Item removed from cart"),
                    actionText = SushiTextProps(text = "UNDO"),
                    snackbarDuration = SushiSnackbarDuration.Long
                )
                snackbarHostState.showSnackbar(actionProps)
                
                // Custom colored snackbar
                val customProps = SushiSnackbarProps(
                    message = SushiTextProps(
                        text = "Payment successful!",
                        type = SushiTextType.Medium500,
                        color = SushiTheme.colors.white
                    ),
                    containerColor = SushiTheme.colors.surface.success,
                    contentColor = SushiTheme.colors.white,
                    snackbarDuration = SushiSnackbarDuration.Short
                )
                snackbarHostState.showSnackbar(customProps)
            }
        }
    )
}
```

## Component API

### SushiSnackbarProps

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`message`</div>| The main text message to display in the snackbar |
| <div class='parameter'>`containerColor`</div>| The background color of the snackbar |
| <div class='parameter'>`contentColor`</div>| The color of the text content |
| <div class='parameter'>`actionText`</div>| The text for the optional action button |
| <div class='parameter'>`snackbarDuration`</div>| Controls how long the snackbar remains visible |

### SushiSnackbarDuration

| Value                                   | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`Short`</div>| Displayed for a brief period (1500ms) |
| <div class='parameter'>`Long`</div>| Displayed for a longer period (3500ms) |
| <div class='parameter'>`Indefinite`</div>| Displayed until explicitly dismissed |

### SushiSnackbarHostState

The `SushiSnackbarHostState` class provides methods to control snackbars:

| Method                                 | Description                      |
|---------------------------------------|----------------------------------|
| <div class='parameter'>`showSnackbar(snackbarProps: SushiSnackbarProps)`</div>| Shows a snackbar with the given properties |
| <div class='parameter'>`cancelSnackbar()`</div>| Dismisses the currently displayed snackbar |