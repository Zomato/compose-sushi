---
title: Bottom Sheet
description: A modal bottom sheet component that slides up from the bottom of the screen
---

# SushiBottomSheet

A customizable bottom sheet component for the Sushi design system.

SushiBottomSheet provides a modal bottom sheet that slides up from the bottom of the screen
to display additional content. The component is built on top of Material 3's ModalBottomSheet
with Sushi-specific styling and integration with the Sushi design system.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img src="../preview_bottom_sheet.png" alt="Bottom Sheet Preview">
</div>

## Example

The `SushiBottomSheet` component is used to display content in a modal sheet that slides up from the
bottom of the screen:

```kotlin
// First, create state variables to control the bottom sheet visibility
var showBottomSheet by remember { mutableStateOf(false) }
val sheetState = rememberModalBottomSheetState()
val scope = rememberCoroutineScope()

// Button to show the bottom sheet
SushiButton(
    props = SushiButtonProps(text = "Show Bottom Sheet"),
    onClick = { showBottomSheet = true },
    modifier = Modifier.fillMaxWidth()
)

// Display the bottom sheet when triggered
if (showBottomSheet) {
    SushiBottomSheet(
        props = SushiBottomSheetProps(),  // Using default props
        onDismissRequest = { showBottomSheet = false },
        sheetState = sheetState
    ) {
        // Bottom sheet content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SushiText(
                props = SushiTextProps(
                    text = "Bottom Sheet Title",
                    type = SushiTextType.Bold700
                )
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            SushiText(
                props = SushiTextProps(
                    text = "This is the content of the bottom sheet.",
                    type = SushiTextType.Regular400
                )
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            SushiButton(
                props = SushiButtonProps(text = "Close"),
                onClick = {
                    scope.launch {
                        sheetState.hide()
                        showBottomSheet = false
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
```

### Customization Examples

```kotlin
// Custom colored bottom sheet
SushiBottomSheet(
    props = SushiBottomSheetProps(
        containerColor = SushiTheme.colors.blue.v050,  // Light blue background
        contentColor = SushiTheme.colors.blue.v900     // Dark blue text
    ),
    onDismissRequest = { /* handler */ }
) {
    // Content
}

// Custom shape bottom sheet
SushiBottomSheet(
    props = SushiBottomSheetProps(
        shape = RoundedCornerShape(
            topStart = 48.dp,
            topEnd = 48.dp
        )
    ),
    onDismissRequest = { /* handler */ }
) {
    // Content
}

// Non-dismissible bottom sheet
SushiBottomSheet(
    props = SushiBottomSheetProps(
        properties = ModalBottomSheetProperties(
            shouldDismissOnBackPress = false
        )
    ),
    onDismissRequest = { /* handler */ },
    sheetState = rememberModalBottomSheetState(confirmValueChange = { false })
) {
    // Content with explicit dismiss button
}
```

## Component API

### SushiBottomSheetProps

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`shape`</div>| The shape of the bottom sheet, typically defining rounded corners at the top |
| <div class='parameter'>`containerColor`</div>| The background color of the bottom sheet |
| <div class='parameter'>`contentColor`</div>| The color of the text and other content in the bottom sheet |
| <div class='parameter'>`tonalElevation`</div>| The elevation of the bottom sheet that affects its shadow and surface tint |
| <div class='parameter'>`properties`</div>| Additional properties controlling the bottom sheet behavior, such as scrim opacity and whether it's dismissible |