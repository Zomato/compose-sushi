---
title: OTP Input
description: A customizable OTP (One-Time Password) input field component
---

# SushiOTPTextField

A customizable OTP (One-Time Password) input field component for the Sushi design system.

SushiOTPTextField provides a series of individual input fields for entering verification
codes, with automatic focus management and styling consistent with the Sushi design system.
It comes in three visual styles: filled, outlined, and underlined.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img src="../preview_otp_input.png" alt="OTP Input Preview">
</div>

## Example

The `SushiOTPTextField` component is used to create OTP input fields for verification codes:

```kotlin
// Create an OTP state for 6 digits
val otpState = rememberOtpState(6)

// Use the filled style (default)
SushiOTPTextField(
    state = otpState,
    autoFocus = true, // Automatically focus the first field
    onComplete = { code ->
        // Handle the completed 6-digit code
        println("OTP completed: $code")
    }
)

// Or use the outlined style
SushiOutlinedOTPTextField(
    state = otpState,
    autoFocus = true,
    onComplete = { code ->
        // Handle the completed 6-digit code
    }
)

// Or use the underlined style
SushiUnderlinedOTPTextField(
    state = otpState,
    autoFocus = true,
    onComplete = { code ->
        // Handle the completed 6-digit code
    }
)
```

### Customization Examples

```kotlin
// Custom length (4 digits)
val otpState4 = rememberOtpState(4)
SushiOTPTextField(
    state = otpState4,
    autoFocus = false,
    onComplete = { code -> /* Handle 4-digit code */ }
)

// Custom text style
SushiOTPTextField(
    state = otpState,
    textStyle = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = SushiTheme.colors.blue.v700.value
    ),
    onComplete = { code -> /* Handle code */ }
)

// Password masking
SushiOTPTextField(
    state = otpState,
    visualTransformation = PasswordVisualTransformation(),
    onComplete = { code -> /* Handle code */ }
)

// Custom colors
val customColors = SushiOTPTextFieldDefaults.filledColors().copy(
    focusedContainerColor = SushiTheme.colors.blue.v100,
    unfocusedContainerColor = SushiTheme.colors.blue.v050,
    focusedTextColor = SushiTheme.colors.blue.v900,
    unfocusedTextColor = SushiTheme.colors.blue.v700,
    cursorColor = SushiTheme.colors.blue.v600
)

SushiOTPTextField(
    state = otpState,
    colors = customColors,
    onComplete = { code -> /* Handle code */ }
)

// Error state
SushiOTPTextField(
    state = otpState,
    isError = true,
    onComplete = { code -> /* Handle code */ }
)

// Disabled state
SushiOTPTextField(
    state = otpState,
    enabled = false,
    onComplete = { code -> /* Handle code */ }
)

// Read-only state (for displaying a pre-filled code)
SushiOTPTextField(
    state = otpState,
    readOnly = true,
    onComplete = { code -> /* Handle code */ }
)

// Alphanumeric keyboard (accepts letters and numbers)
SushiOTPTextField(
    state = otpState,
    keyboardType = KeyboardType.Text,
    onComplete = { code -> /* Handle code */ }
)
```

### Programmatically Setting Values

```kotlin
// Pre-fill values
otpState.onDigitEntered(0, '1')
otpState.onDigitEntered(1, '2')
otpState.onDigitEntered(2, '3')
otpState.onDigitEntered(3, '4')

// Clear values
for (i in 0 until otpState.length) {
    otpState.onDigitDeleted(i)
}

// Check if complete
val isComplete = otpState.isComplete()
```

## Component API

### SushiOTPTextField Parameters

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`state`</div>| State controlling the OTP value and behavior |
| <div class='parameter'>`enabled`</div>| Whether the input fields are enabled |
| <div class='parameter'>`readOnly`</div>| Whether the input fields are read-only |
| <div class='parameter'>`isError`</div>| Whether to display the component in an error state |
| <div class='parameter'>`autoFocus`</div>| Whether to automatically focus the first input field when displayed |
| <div class='parameter'>`textStyle`</div>| The style to apply to the input text |
| <div class='parameter'>`colors`</div>| Colors configuration for different states of the component |
| <div class='parameter'>`visualTransformation`</div>| Transformation to apply to the input text (e.g., for masking) |
| <div class='parameter'>`keyboardType`</div>| The type of keyboard to show for input |
| <div class='parameter'>`onComplete`</div>| Callback invoked when all fields are filled |

### SushiOTPState Methods

| Method                                  | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`onDigitEntered(index: Int, value: Char)`</div>| Programmatically sets a digit at the specified position |
| <div class='parameter'>`onDigitDeleted(index: Int)`</div>| Clears the digit at the specified position |
| <div class='parameter'>`isFieldEmpty(index: Int)`</div>| Checks if the field at the specified position is empty |
| <div class='parameter'>`isComplete()`</div>| Checks if all fields have been filled |
| <div class='parameter'>`code`</div>| Property that returns the current OTP value (padded with spaces) |