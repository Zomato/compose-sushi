package com.zomato.sushi.compose.components.otptextfield

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.foundation.SushiTheme

/**
 * Provides default values and utility functions for SushiOTPTextField components.
 * These defaults are used when specific properties are not provided directly.
 *
 * @author gupta.anirudh@zomato.com
 */
object SushiOTPTextFieldDefaults {
    /**
     * Default shape for OTP text field items with rounded corners.
     */
    val otpTextFieldShape: Shape = RoundedCornerShape(8.dp)
    
    /**
     * Default number of digits in an OTP.
     */
    const val otpLength = 6
    
    /**
     * Default width for each digit field.
     */
    val itemWidth = 48.dp
    
    /**
     * Default height for each digit field.
     */
    val itemHeight = 48.dp

    private val unfocusedOutlineThickness = 2.dp
    private val focusedOutlineThickness = 2.dp
    
    /**
     * Default spacing between digit fields.
     */
    val itemSpacing = 8.dp

    /**
     * Creates a default set of colors for outlined OTP text fields.
     * Uses colors from the Sushi theme for consistency.
     *
     * @return Colors configuration for outlined OTP text fields
     */
    @Composable
    fun outlinedColors() =
        SushiOTPTextFieldColors(
            focusedTextColor = SushiTheme.colors.text.primary,
            unfocusedTextColor = SushiTheme.colors.text.secondary,
            disabledTextColor = SushiTheme.colors.text.disabled,
            errorTextColor = SushiTheme.colors.text.error,
            focusedContainerColor = SushiTheme.colors.transparent,
            unfocusedContainerColor = SushiTheme.colors.transparent,
            disabledContainerColor = SushiTheme.colors.transparent,
            errorContainerColor = SushiTheme.colors.transparent,
            cursorColor = SushiTheme.colors.text.primary,
            errorCursorColor = SushiTheme.colors.text.primary,
            textSelectionColors = LocalTextSelectionColors.current,
            focusedOutlineColor = SushiTheme.colors.text.primary,
            unfocusedOutlineColor = SushiTheme.colors.text.secondary,
            disabledOutlineColor = SushiTheme.colors.text.disabled,
            errorOutlineColor = SushiTheme.colors.text.error,
        )

    /**
     * Creates a default set of colors for filled OTP text fields.
     * Uses colors from the Sushi theme for consistency.
     *
     * @return Colors configuration for filled OTP text fields
     */
    @Composable
    fun filledColors() =
        SushiOTPTextFieldColors(
            focusedTextColor = SushiTheme.colors.text.primary,
            unfocusedTextColor = SushiTheme.colors.text.secondary,
            disabledTextColor = SushiTheme.colors.text.disabled,
            errorTextColor = SushiTheme.colors.text.error,
            focusedContainerColor = SushiTheme.colors.surface.primary,
            unfocusedContainerColor = SushiTheme.colors.surface.primary,
            disabledContainerColor = SushiTheme.colors.surface.primary,
            errorContainerColor = SushiTheme.colors.surface.primary,
            cursorColor = SushiTheme.colors.text.primary,
            errorCursorColor = SushiTheme.colors.text.primary,
            textSelectionColors = LocalTextSelectionColors.current,
            focusedOutlineColor = SushiTheme.colors.transparent,
            unfocusedOutlineColor = SushiTheme.colors.transparent,
            disabledOutlineColor = SushiTheme.colors.transparent,
            errorOutlineColor = SushiTheme.colors.transparent,
        )

    /**
     * Creates a default set of colors for underlined OTP text fields.
     * Uses colors from the Sushi theme for consistency.
     *
     * @return Colors configuration for underlined OTP text fields
     */
    @Composable
    fun underlinedColors() =
        SushiOTPTextFieldColors(
            focusedTextColor = SushiTheme.colors.text.primary,
            unfocusedTextColor = SushiTheme.colors.text.secondary,
            disabledTextColor = SushiTheme.colors.text.disabled,
            errorTextColor = SushiTheme.colors.text.error,
            focusedContainerColor = SushiTheme.colors.transparent,
            unfocusedContainerColor = SushiTheme.colors.transparent,
            disabledContainerColor = SushiTheme.colors.transparent,
            errorContainerColor = SushiTheme.colors.transparent,
            cursorColor = SushiTheme.colors.text.primary,
            errorCursorColor = SushiTheme.colors.text.primary,
            textSelectionColors = LocalTextSelectionColors.current,
            focusedOutlineColor = SushiTheme.colors.text.primary,
            unfocusedOutlineColor = SushiTheme.colors.text.secondary,
            disabledOutlineColor = SushiTheme.colors.text.disabled,
            errorOutlineColor = SushiTheme.colors.text.error,
        )

    /**
     * Determines the appropriate outline thickness based on focus state.
     *
     * @param interactionSource Source of interaction to determine focus state
     * @return The border thickness appropriate for the current focus state
     */
    @Composable
    fun containerBorderThickness(
        interactionSource: InteractionSource,
    ): Dp {
        val focused by interactionSource.collectIsFocusedAsState()

        return if (focused) focusedOutlineThickness else unfocusedOutlineThickness
    }

    /**
     * Decoration box that wraps the input field with appropriate styling based on the field type.
     * 
     * This function handles the visual appearance of each digit field, including container
     * background, borders, and positioning of the input text.
     *
     * @param value The current text value
     * @param innerTextField The composable function that renders the actual input field
     * @param visualTransformation Transformation applied to the text (e.g., for masking)
     * @param interactionSource Source of interaction for the field
     * @param colors Colors configuration for the field
     * @param type The visual style of the field (Outlined, Filled, or Underlined)
     * @param modifier Additional modifiers to apply to the box
     * @param enabled Whether the field is enabled
     * @param isError Whether the field is in error state
     */
    @Composable
    fun DecorationBox(
        value: String,
        innerTextField: @Composable () -> Unit,
        visualTransformation: VisualTransformation,
        interactionSource: InteractionSource,
        colors: SushiOTPTextFieldColors,
        type: SushiOTPTextFieldType,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        isError: Boolean = false,
    ) {
        val transformedText =
            remember(value, visualTransformation) {
                visualTransformation.filter(AnnotatedString(value))
            }.text.text

        val borderThickness = containerBorderThickness(interactionSource)

        val containerModifier =
            when (type) {
                SushiOTPTextFieldType.Underlined ->
                    Modifier.containerUnderline(
                        transformedText,
                        enabled,
                        isError,
                        interactionSource,
                        colors,
                        borderThickness,
                    )

                else -> Modifier.containerOutline(transformedText, enabled, isError, interactionSource, colors, borderThickness)
            }

        Box(
            modifier =
                modifier
                    .background(colors.containerColor(enabled, isError, interactionSource).value, otpTextFieldShape)
                    .defaultMinSize(minHeight = itemHeight)
                    .then(containerModifier),
        ) {
            Box(
                modifier = Modifier.align(Alignment.Center),
            ) {
                innerTextField()
            }
        }
    }
}

@Composable
internal fun animateTextFieldBorderAsState(
    value: String,
    enabled: Boolean,
    isError: Boolean,
    interactionSource: InteractionSource,
    colors: SushiOTPTextFieldColors,
    borderThickness: Dp,
): State<BorderStroke> {
    val indicatorColor = colors.containerOutlineColor(value, enabled, isError, interactionSource)

    return rememberUpdatedState(
        BorderStroke(borderThickness, SolidColor(indicatorColor.value)),
    )
}

@Suppress("ComposeModifierComposed")
internal fun Modifier.containerOutline(
    value: String,
    enabled: Boolean,
    isError: Boolean,
    interactionSource: InteractionSource,
    colors: SushiOTPTextFieldColors,
    borderThickness: Dp,
) = composed(
    inspectorInfo =
        debugInspectorInfo {
            name = "indicatorLine"
            properties["value"] = value
            properties["enabled"] = enabled
            properties["isError"] = isError
            properties["interactionSource"] = interactionSource
            properties["colors"] = colors
            properties["borderThickness"] = borderThickness
        },
) {
    val stroke =
        animateTextFieldBorderAsState(
            value,
            enabled,
            isError,
            interactionSource,
            colors,
            borderThickness,
        )

    this.then(Modifier.border(stroke.value, shape = SushiOTPTextFieldDefaults.otpTextFieldShape))
}

@Suppress("ComposeModifierComposed")
internal fun Modifier.containerUnderline(
    value: String,
    enabled: Boolean,
    isError: Boolean,
    interactionSource: InteractionSource,
    colors: SushiOTPTextFieldColors,
    borderThickness: Dp,
) = composed {
    val indicatorColor = colors.containerOutlineColor(value, enabled, isError, interactionSource)

    this.then(
        Modifier.drawBehind {
            val strokeWidthPx = borderThickness.toPx()
            drawLine(
                color = indicatorColor.value,
                start = androidx.compose.ui.geometry.Offset(0f, size.height - strokeWidthPx / 2),
                end = androidx.compose.ui.geometry.Offset(size.width, size.height - strokeWidthPx / 2),
                strokeWidth = strokeWidthPx,
            )
        },
    )
}