---
title: SushiTextField
description: A customizable text input field component for the Sushi design system.
---

# SushiTextField

A customizable text input field component for the Sushi design system.

SushiTextField provides a standard text field with support for:

- Labels and placeholder text
- Error states and support text
- Prefix and suffix text/icons
- Custom styling via colors and shapes
- Keyboard options and actions
- Accessibility features

This component wraps the Material3 OutlinedTextField to maintain consistency
with the design system while leveraging the functionality of the standard component.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img src="../preview_textfield.png" alt="TextField Preview">
</div>

## Example

The `SushiTextField` component is used to create text input fields with various configurations.

```kotlin
var text by remember { mutableStateOf("") }

SushiTextField(
    props = SushiTextFieldProps(
        text = text,
        label = SushiTextProps(text = "Phone Number"),
        prefixText = SushiTextProps(text = "+91"),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        supportText = SushiTextProps(text = "Enter your mobile number")
    ),
    onValueChange = { text = it },
    modifier = Modifier.fillMaxWidth()
)
```

## Component API

### SushiTextField

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`id`</div>| Optional identifier for the text field |
| <div class='parameter'>`text`</div>| Current text value displayed in the field |
| <div class='parameter'>`textStyle`</div>| Typography style for the input text |
| <div class='parameter'>`placeholder`</div>| Text displayed when the field is empty |
| <div class='parameter'>`enabled`</div>| Whether the text field is interactive (true) or disabled (false) |
| <div class='parameter'>`readOnly`</div>| Whether the text field allows user input (false) or is read-only (true) |
| <div class='parameter'>`isError`</div>| Whether to display the text field in an error state |
| <div class='parameter'>`label`</div>| Optional label text displayed above the text field |
| <div class='parameter'>`keyboardOptions`</div>| Options controlling the behavior of the software keyboard |
| <div class='parameter'>`keyboardActions`</div>| Actions to perform based on keyboard input |
| <div class='parameter'>`singleLine`</div>| Whether the text field should be limited to a single line |
| <div class='parameter'>`showResetButton`</div>| Show a reset button to clear the text field's input |
| <div class='parameter'>`maxLines`</div>| Maximum number of lines to display when not in single line mode |
| <div class='parameter'>`minLines`</div>| Minimum number of lines to display |
| <div class='parameter'>`shape`</div>| The shape of the text field container |
| <div class='parameter'>`visualTransformation`</div>| Optional transformation for displaying the text (e.g., password masking) |
| <div class='parameter'>`supportText`</div>| Optional supporting text displayed below the text field |
| <div class='parameter'>`prefixIcon`</div>| Optional icon displayed at the start of the text field |
| <div class='parameter'>`leadingIcon`</div>| Optional icon displayed at the start of the text field (always visible) |
| <div class='parameter'>`suffixIcon`</div>| Optional icon displayed at the end of the text field |
| <div class='parameter'>`trailingIcon`</div>| Optional icon displayed at the end of the text field (always visible) |
| <div class='parameter'>`prefixText`</div>| Optional text displayed at the start of the text field |
| <div class='parameter'>`suffixText`</div>| Optional text displayed at the end of the text field |
| <div class='parameter'>`colors`</div>| Color scheme for the text field's various states |