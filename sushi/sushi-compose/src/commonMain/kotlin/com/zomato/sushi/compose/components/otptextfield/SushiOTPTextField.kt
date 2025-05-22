package com.zomato.sushi.compose.components.otptextfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.toast.rememberToastController
import kotlin.math.min

/**
 * A customizable OTP (One-Time Password) input field component for the Sushi design system.
 * 
 * SushiOTPTextField provides a series of individual input fields for entering verification
 * codes, with automatic focus management and styling consistent with the Sushi design system.
 * This variant uses a filled visual style.
 *
 * @param modifier The modifier to be applied to the component
 * @param state State controlling the OTP value and behavior
 * @param enabled Whether the input fields are enabled
 * @param readOnly Whether the input fields are read-only
 * @param isError Whether to display the component in an error state
 * @param autoFocus Whether to automatically focus the first input field when displayed
 * @param textStyle The style to apply to the input text
 * @param colors Colors configuration for different states of the component
 * @param visualTransformation Transformation to apply to the input text (e.g., for masking)
 * @param keyboardType The type of keyboard to show for input
 * @param onComplete Callback invoked when all fields are filled with digits
 *
 * @author gupta.anirudh@zomato.com
 */
@Composable
fun SushiOTPTextField(
    modifier: Modifier = Modifier,
    state: SushiOTPState = rememberOtpState(SushiOTPTextFieldDefaults.otpLength),
    enabled: Boolean = true,
    readOnly: Boolean = false,
    isError: Boolean = false,
    autoFocus: Boolean = true,
    textStyle: TextStyle = SushiTheme.typography.semiBold600,
    colors: SushiOTPTextFieldColors = SushiOTPTextFieldDefaults.filledColors(),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.NumberPassword,
    onComplete: (String) -> Unit = {},
) {
    SushiComponentBase(
        modifier
            .testTag("SushiOTPTextField")
    ) {
        OTPTextFieldLayout(
            modifier = Modifier,
            state = state,
            enabled = enabled,
            readOnly = readOnly,
            isError = isError,
            autoFocus = autoFocus,
            textStyle = textStyle,
            type = SushiOTPTextFieldType.Filled,
            colors = colors,
            visualTransformation = visualTransformation,
            onComplete = onComplete,
            keyboardType = keyboardType
        )
    }

}

/**
 * A variant of SushiOTPTextField with outlined visual style.
 * 
 * Each input field is displayed with a border outline rather than a filled background.
 * All other behavior is identical to the standard SushiOTPTextField.
 *
 * @see SushiOTPTextField for parameter descriptions
 */
@Composable
fun SushiOutlinedOTPTextField(
    modifier: Modifier = Modifier,
    state: SushiOTPState = rememberOtpState(SushiOTPTextFieldDefaults.otpLength),
    enabled: Boolean = true,
    readOnly: Boolean = false,
    isError: Boolean = false,
    autoFocus: Boolean = true,
    textStyle: TextStyle = SushiTheme.typography.semiBold600,
    colors: SushiOTPTextFieldColors = SushiOTPTextFieldDefaults.outlinedColors(),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.NumberPassword,
    onComplete: (String) -> Unit = {},
) {
    SushiComponentBase(
        modifier
            .testTag("SushiOutlinedOTPTextField")
    ) {
        OTPTextFieldLayout(
            modifier = Modifier,
            state = state,
            enabled = enabled,
            readOnly = readOnly,
            isError = isError,
            autoFocus = autoFocus,
            textStyle = textStyle,
            type = SushiOTPTextFieldType.Outlined,
            colors = colors,
            visualTransformation = visualTransformation,
            onComplete = onComplete,
            keyboardType = keyboardType
        )
    }
}

/**
 * A variant of SushiOTPTextField with underlined visual style.
 * 
 * Each input field is displayed with only a bottom border line rather than a full outline.
 * All other behavior is identical to the standard SushiOTPTextField.
 *
 * @see SushiOTPTextField for parameter descriptions
 */
@Composable
fun SushiUnderlinedOTPTextField(
    modifier: Modifier = Modifier,
    state: SushiOTPState = rememberOtpState(SushiOTPTextFieldDefaults.otpLength),
    enabled: Boolean = true,
    readOnly: Boolean = false,
    isError: Boolean = false,
    autoFocus: Boolean = true,
    textStyle: TextStyle = SushiTheme.typography.semiBold600,
    colors: SushiOTPTextFieldColors = SushiOTPTextFieldDefaults.underlinedColors(),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.NumberPassword,
    onComplete: (String) -> Unit = {},
) {
    SushiComponentBase(
        modifier
            .testTag("SushiUnderlinedOTPTextField")
    ) {
        OTPTextFieldLayout(
            modifier = Modifier,
            state = state,
            enabled = enabled,
            readOnly = readOnly,
            isError = isError,
            autoFocus = autoFocus,
            textStyle = textStyle,
            colors = colors,
            visualTransformation = visualTransformation,
            onComplete = onComplete,
            type = SushiOTPTextFieldType.Underlined,
            keyboardType = keyboardType
        )
    }
}

@Composable
private fun OTPTextFieldLayout(
    state: SushiOTPState,
    enabled: Boolean,
    readOnly: Boolean,
    isError: Boolean,
    textStyle: TextStyle,
    type: SushiOTPTextFieldType,
    colors: SushiOTPTextFieldColors,
    onComplete: (String) -> Unit,
    keyboardType: KeyboardType,
    modifier: Modifier = Modifier,
    autoFocus: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    LaunchedEffect(state.code) {
        if (state.isComplete()) {
            onComplete(state.code.trim())
        }
    }

    val otpLength = state.length
    val focusRequester = remember { FocusRequester() }

    CompositionLocalProvider(LocalTextSelectionColors provides colors.selectionColors) {
        Layout(
            content = {
                repeat(otpLength) { index ->
                    OTPTextFieldItem(
                        state = state,
                        position = index,
                        colors = colors,
                        textStyle = textStyle,
                        readOnly = readOnly,
                        enabled = enabled,
                        isError = isError,
                        focusRequester = focusRequester,
                        visualTransformation = visualTransformation,
                        type = type,
                        keyboardType = keyboardType
                    )
                }
            },
            modifier = modifier,
        ) { measurables, constraints ->
            val itemSpacingPx = SushiOTPTextFieldDefaults.itemSpacing.toPx().toInt()
            val availableWidth = constraints.maxWidth - itemSpacingPx * (otpLength - 1)
            val itemWidthPx =
                min(
                    SushiOTPTextFieldDefaults.itemWidth.toPx().toInt(),
                    availableWidth / otpLength,
                )

            val placeables =
                measurables.map { measurable ->
                    measurable.measure(constraints.copy(minWidth = itemWidthPx, maxWidth = itemWidthPx))
                }

            val containerWidth = itemWidthPx * otpLength + itemSpacingPx * (otpLength - 1)
            val containerHeight = placeables.maxOf { it.height }

            layout(width = containerWidth, height = containerHeight) {
                var xPosition = 0
                placeables.forEachIndexed { index, placeable ->
                    placeable.placeRelative(x = xPosition, y = 0)
                    xPosition += placeable.width + if (index < otpLength - 1) itemSpacingPx else 0
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        if (autoFocus) {
            focusRequester.requestFocus()
        }
    }
}

@Composable
private fun OTPTextFieldItem(
    state: SushiOTPState,
    position: Int,
    colors: SushiOTPTextFieldColors,
    textStyle: TextStyle,
    readOnly: Boolean,
    enabled: Boolean,
    isError: Boolean,
    focusRequester: FocusRequester,
    visualTransformation: VisualTransformation,
    type: SushiOTPTextFieldType,
    keyboardType: KeyboardType
) {
    val singleValue = state.code[position]
    val value = if (singleValue.isWhitespace()) "" else singleValue.toString()

    val interactionSource = state.interactionSources[position]
    val cursorBrush = SolidColor(colors.cursorColor(isError).value)

    val textColor =
        textStyle.color.takeOrElse {
            colors.textColor(enabled, isError, interactionSource).value
        }
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor)).merge(TextStyle(textAlign = TextAlign.Center))

    BasicTextField(
        value = value,
        textStyle = mergedTextStyle,
        readOnly = readOnly,
        enabled = enabled,
        onValueChange = { newValue ->
            when {
                newValue.isNotEmpty() && (newValue.last().isDigit() && (keyboardType == KeyboardType.Number || keyboardType == KeyboardType.NumberPassword)) -> {
                    state.onDigitEntered(position, newValue.last())
                }

                newValue.isNotEmpty() && !(keyboardType == KeyboardType.Number || keyboardType == KeyboardType.NumberPassword) -> {
                    state.onDigitEntered(position, newValue.last())
                }

                newValue.isEmpty() -> {
                    state.onDigitDeleted(position)
                }
            }
        },
        modifier =
            Modifier
                .then(
                    if (position == 0) {
                        Modifier.focusRequester(focusRequester)
                    } else {
                        Modifier
                    },
                )
                .onPreviewKeyEvent { keyEvent ->
                    if (keyEvent.type == KeyEventType.KeyDown && keyEvent.key == Key.Backspace && state.isFieldEmpty(position)) {
                        state.onBackspacePressed(position)
                        true
                    } else {
                        false
                    }
                }
                .semantics {
                    contentDescription = "OTP Digit ${position + 1} of ${state.length}"
                },
        keyboardOptions =
            KeyboardOptions(
                keyboardType = keyboardType,
            ),
        keyboardActions =
            KeyboardActions(onNext = {
                state.focusManager.moveFocus(FocusDirection.Next)
            }),
        singleLine = true,
        visualTransformation = visualTransformation,
        interactionSource = interactionSource,
        cursorBrush = cursorBrush,
        decorationBox = { inputField ->
            SushiOTPTextFieldDefaults.DecorationBox(
                value = value,
                innerTextField = inputField,
                visualTransformation = visualTransformation,
                type = type,
                colors = colors,
                enabled = enabled,
                isError = isError,
                interactionSource = interactionSource,
            )
        },
    )
}

/**
 * Creates and remembers an OTP state for the given length.
 * 
 * This function provides a convenient way to create an OTP state object with
 * access to the necessary dependencies for focus management and keyboard control.
 *
 * @param length The number of digits in the OTP
 * @return A new SushiOTPState instance
 */
@Composable
fun rememberOtpState(length: Int): SushiOTPState {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    return remember(length, focusManager, keyboardController) {
        SushiOTPState(
            length = length,
            focusManager = focusManager,
            keyboardController = keyboardController,
        )
    }
}

@SushiPreview
@Composable
private fun SushiOTPTextFieldPreview() {
    val toastController = rememberToastController()
    SushiPreview {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            SushiOTPTextField(state = rememberOtpState(4), autoFocus = false, onComplete = { code ->
                toastController.show("OTP completed: $code")
            })

            SushiOutlinedOTPTextField(state = rememberOtpState(4), autoFocus = true, onComplete = { code ->
                toastController.show("OTP completed: $code")
            })

            SushiUnderlinedOTPTextField(state = rememberOtpState(4), autoFocus = false, onComplete = { code ->
                toastController.show("OTP completed: $code")
            })

            SushiOTPTextField(state = rememberOtpState(6), autoFocus = false, onComplete = { code ->
                toastController.show("OTP completed: $code")
            })

            SushiOutlinedOTPTextField(state = rememberOtpState(6), autoFocus = false, onComplete = { code ->
                toastController.show("OTP completed: $code")
            })

            SushiUnderlinedOTPTextField(state = rememberOtpState(6), autoFocus = false, onComplete = { code ->
                toastController.show("OTP completed: $code")
            })
        }
    }
}