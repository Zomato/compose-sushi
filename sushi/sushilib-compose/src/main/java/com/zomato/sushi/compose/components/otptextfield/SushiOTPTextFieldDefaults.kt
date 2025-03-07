package com.zomato.sushi.compose.components.otptextfield

import android.annotation.SuppressLint
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
 * @author gupta.anirudh@zomato.com
 */

object SushiOTPTextFieldDefaults {
    val otpTextFieldShape: Shape = RoundedCornerShape(8.dp)
    const val otpLength = 6
    val itemWidth = 48.dp
    val itemHeight = 48.dp
    private val unfocusedOutlineThickness = 2.dp
    private val focusedOutlineThickness = 2.dp
    val itemSpacing = 8.dp

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

    @Composable
    fun containerBorderThickness(
        interactionSource: InteractionSource,
    ): Dp {
        val focused by interactionSource.collectIsFocusedAsState()

        return if (focused) focusedOutlineThickness else unfocusedOutlineThickness
    }

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

@SuppressLint("ComposeModifierComposed")
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

@SuppressLint("ComposeModifierComposed")
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