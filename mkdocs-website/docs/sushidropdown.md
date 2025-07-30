---
title: DropDown
description: A customizable dropdown menu component for displaying options
---

# SushiDropDown

A customizable dropdown menu component for the Sushi design system.

SushiDropDown provides a popup menu that can contain various types of items including
text items, checkboxes, and radio buttons. The dropdown can be anchored to any component
and supports custom content or predefined item types.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img class="component-preview" src="../preview_dropdown.png" alt="DropDown Preview">
</div>

## Example

The `SushiDropDown` component is used to create dropdown menus with various types of items:

```kotlin
// First, create state variables to control the dropdown visibility
var isExpanded by remember { mutableStateOf(false) }

// Create a trigger element (like a button)
SushiButton(
    props = SushiButtonProps(
        text = "Show Dropdown",
        prefixIcon = SushiIconProps(code = SushiIconCodes.IconChevronDown)
    ),
    onClick = { isExpanded = true }
)

// Create the dropdown items
val items = persistentListOf(
    // Text items
    DropDownItem.TextItem(SushiTextProps(text = "Option 1")),
    DropDownItem.TextItem(SushiTextProps(text = "Option 2")),
    
    // Checkbox items
    DropDownItem.CheckBoxItem(SushiCheckBoxProps(
        text = SushiTextProps(text = "Checkbox Option"),
        checked = false
    )),
    
    // Radio button items
    DropDownItem.RadioButtonItem(SushiRadioButtonProps(
        text = SushiTextProps(text = "Radio Option"),
        selected = true
    ))
)

// Show the dropdown when expanded
if (isExpanded) {
    SushiDropDown(
        props = SushiDropDownProps(
            expanded = true,
            items = items
        ),
        onDismissRequest = { isExpanded = false },
        onEvent = { index, event ->
            when (event) {
                is DropDownEvent.OnTextItemClicked -> {
                    // Handle text item click
                    isExpanded = false
                }
                is DropDownEvent.OnCheckChanged -> {
                    // Handle checkbox state change
                    // Update your items list with the new state
                }
                is DropDownEvent.OnRadioButtonCheckChanged -> {
                    // Handle radio button selection
                    // Update your items list with the new selection
                }
            }
        }
    )
}
```

### Customization Examples

```kotlin
// Custom positioning with offset
SushiDropDown(
    props = SushiDropDownProps(
        expanded = isExpanded,
        offset = DpOffset(20.dp, 10.dp),
        items = items
    ),
    onDismissRequest = { /* handler */ }
)

// Custom shape
SushiDropDown(
    props = SushiDropDownProps(
        expanded = isExpanded,
        shape = RoundedCornerShape(16.dp),
        items = items
    ),
    onDismissRequest = { /* handler */ }
)

// Custom color and border
SushiDropDown(
    props = SushiDropDownProps(
        expanded = isExpanded,
        containerColor = SushiTheme.colors.blue.v700.value,
        border = BorderStroke(2.dp, SushiTheme.colors.base.theme.v500.value),
        items = items
    ),
    onDismissRequest = { /* handler */ }
)

// Custom content
SushiDropDown(
    props = SushiDropDownProps(expanded = isExpanded),
    onDismissRequest = { /* handler */ },
    content = {
        Column(modifier = Modifier.padding(16.dp)) {
            SushiText(props = SushiTextProps(text = "Custom Header"))
            
            // Custom items or content
            Row(verticalAlignment = Alignment.CenterVertically) {
                SushiIcon(props = SushiIconProps(code = SushiIconCodes.IconCheck))
                SushiText(props = SushiTextProps(text = "Custom Item"))
            }
            
            // You can use SushiDropDownItem for consistent styling
            SushiDropDownItem(
                item = DropDownItem.TextItem(SushiTextProps(text = "Item")),
                onEvent = { /* handler */ }
            )
        }
    }
)
```

## Component API

### SushiDropDownProps

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`expanded`</div>| Whether the dropdown menu is currently shown |
| <div class='parameter'>`offset`</div>| Position offset from the anchor position |
| <div class='parameter'>`properties`</div>| Additional popup properties (e.g., focusability, dismiss behavior) |
| <div class='parameter'>`shape`</div>| The shape of the dropdown menu container |
| <div class='parameter'>`containerColor`</div>| The background color of the dropdown menu |
| <div class='parameter'>`tonalElevation`</div>| When using surface color, this affects the overlay color intensity |
| <div class='parameter'>`shadowElevation`</div>| The elevation that determines the size of the shadow |
| <div class='parameter'>`border`</div>| Optional border to draw around the dropdown |
| <div class='parameter'>`items`</div>| List of items to display in the dropdown menu |

### DropDownItem Types

The `DropDownItem` sealed interface supports three item types:

| Type                                   | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`TextItem`</div>| A simple text item in the dropdown menu |
| <div class='parameter'>`CheckBoxItem`</div>| A checkbox item in the dropdown menu |
| <div class='parameter'>`RadioButtonItem`</div>| A radio button item in the dropdown menu |

### DropDownEvent Types

The `DropDownEvent` sealed interface provides type-safe event handling:

| Event                                  | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`OnCheckChanged`</div>| Event fired when a checkbox item's checked state changes |
| <div class='parameter'>`OnRadioButtonCheckChanged`</div>| Event fired when a radio button item's selected state changes |
| <div class='parameter'>`OnTextItemClicked`</div>| Event fired when a text item is clicked |