---
title: Dialog
description: A customizable alert dialog component for displaying important information
---

# SushiAlertDialog

A customizable alert dialog component for the Sushi design system.

SushiAlertDialog provides a modal dialog for displaying important information
or requesting user decisions. It supports an optional header image, title, subtitle,
custom content, and up to three action buttons. The dialog can be configured with
different button layouts (vertical or horizontal) and dismissal behaviors.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img src="../preview_dialog.png" alt="Dialog Preview">
</div>

## Example

The `SushiAlertDialog` component is used to create modal dialogs for important interactions:

```kotlin
// First, create state to control the dialog's visibility
var showDialog by remember { mutableStateOf(false) }

// Button to show the dialog
SushiButton(
    props = SushiButtonProps(text = "Show Dialog"),
    onClick = { showDialog = true },
    modifier = Modifier.fillMaxWidth()
)

// Display the dialog when needed
if (showDialog) {
    SushiAlertDialog(
        props = SushiAlertDialogProps(
            title = SushiTextProps(
                text = "Confirm Action",
                type = SushiTextType.Bold600,
                textAlign = TextAlign.Center
            ),
            subtitle = SushiTextProps(
                text = "Are you sure you want to proceed with this action?",
                type = SushiTextType.Regular400,
                textAlign = TextAlign.Center
            ),
            positiveButton = SushiButtonProps(
                text = "Confirm",
                type = SushiButtonType.Text,
                horizontalArrangement = Arrangement.Center
            ),
            negativeButton = SushiButtonProps(
                text = "Cancel",
                type = SushiButtonType.Text,
                horizontalArrangement = Arrangement.Center
            )
        ),
        onDismissRequest = { showDialog = false },
        onPositiveButtonClick = { 
            // Handle positive action
            showDialog = false 
        },
        onNegativeButtonClick = { showDialog = false }
    ) {
        // Optional additional content
        Spacer(modifier = Modifier.height(8.dp))
    }
}
```

### Customization Examples

```kotlin
// Dialog with image
SushiAlertDialog(
    props = SushiAlertDialogProps(
        image = SushiImageProps(
            painter = painterResource(R.drawable.success_icon),
            contentScale = ContentScale.Fit,
            bgColor = SushiTheme.colors.green.v100,
            width = 80.dp,
            height = 80.dp,
            shape = CircleShape
        ),
        title = SushiTextProps(text = "Success!"),
        subtitle = SushiTextProps(text = "Your order has been placed successfully."),
        positiveButton = SushiButtonProps(text = "OK")
    ),
    onDismissRequest = { /* handler */ },
    onPositiveButtonClick = { /* handler */ }
) {
    // Optional content
}

// Dialog with vertical buttons
SushiAlertDialog(
    props = SushiAlertDialogProps(
        title = SushiTextProps(text = "Rate Your Experience"),
        subtitle = SushiTextProps(text = "How would you rate your food delivery experience?"),
        alignment = SushiAlertDialogProps.ButtonAlignment.Vertical,
        positiveButton = SushiButtonProps(text = "Excellent"),
        negativeButton = SushiButtonProps(text = "Average"),
        neutralButton = SushiButtonProps(text = "Poor")
    ),
    onDismissRequest = { /* handler */ },
    onPositiveButtonClick = { /* handler */ },
    onNegativeButtonClick = { /* handler */ },
    onNeutralButtonClick = { /* handler */ }
) {
    // Optional content
}

// Non-dismissible dialog
SushiAlertDialog(
    props = SushiAlertDialogProps(
        title = SushiTextProps(text = "Important Notice"),
        subtitle = SushiTextProps(text = "This requires your confirmation."),
        positiveButton = SushiButtonProps(text = "I Understand"),
        dismissOnBackPress = false,
        dismissOnClickOutside = false
    ),
    onDismissRequest = { /* Cannot dismiss except by button */ },
    onPositiveButtonClick = { /* handler */ }
) {
    // Content
}
```

## Component API

### SushiAlertDialogProps

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`id`</div>| Optional identifier for the dialog |
| <div class='parameter'>`image`</div>| Optional image to display at the top of the dialog |
| <div class='parameter'>`title`</div>| Optional title text displayed at the top of the dialog |
| <div class='parameter'>`subtitle`</div>| Optional subtitle text displayed below the title |
| <div class='parameter'>`positiveButton`</div>| Optional properties for the primary action button |
| <div class='parameter'>`negativeButton`</div>| Optional properties for the secondary action button |
| <div class='parameter'>`neutralButton`</div>| Optional properties for the tertiary action button |
| <div class='parameter'>`alignment`</div>| How the buttons should be arranged (vertically or horizontally) |
| <div class='parameter'>`dismissOnBackPress`</div>| Whether the dialog should dismiss when the back button is pressed |
| <div class='parameter'>`dismissOnClickOutside`</div>| Whether the dialog should dismiss when clicked outside its bounds |

### ButtonAlignment

| Value                                   | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`Vertical`</div>| Buttons are arranged vertically (stacked), each taking the full width of the dialog |
| <div class='parameter'>`Horizontal`</div>| Buttons are arranged horizontally (side by side) at the bottom of the dialog |