package com.zomato.sushi.compose.components.otptextfield

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import com.zomato.sushi.compose.atoms.color.ColorSpec
import androidx.compose.runtime.getValue

/**
 * Defines the complete set of colors used by SushiOTPTextField components in various states.
 * 
 * This class provides fine-grained control over all the color aspects of OTP text fields,
 * including different colors for focused/unfocused states, disabled state, and error state.
 *
 * @property focusedTextColor Color of the text when a field has focus
 * @property unfocusedTextColor Color of the text when a field doesn't have focus
 * @property disabledTextColor Color of the text when a field is disabled
 * @property errorTextColor Color of the text when a field is in error state
 * @property focusedContainerColor Background color when a field has focus
 * @property unfocusedContainerColor Background color when a field doesn't have focus
 * @property disabledContainerColor Background color when a field is disabled
 * @property errorContainerColor Background color when a field is in error state
 * @property cursorColor Color of the cursor in normal state
 * @property errorCursorColor Color of the cursor in error state
 * @property textSelectionColors Colors for text selection highlights
 * @property focusedOutlineColor Color of the outline/border when a field has focus
 * @property unfocusedOutlineColor Color of the outline/border when a field doesn't have focus
 * @property disabledOutlineColor Color of the outline/border when a field is disabled
 * @property errorOutlineColor Color of the outline/border when a field is in error state
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiOTPTextFieldColors(
    val focusedTextColor: ColorSpec,
    val unfocusedTextColor: ColorSpec,
    val disabledTextColor: ColorSpec,
    val errorTextColor: ColorSpec,
    val focusedContainerColor: ColorSpec,
    val unfocusedContainerColor: ColorSpec,
    val disabledContainerColor: ColorSpec,
    val errorContainerColor: ColorSpec,
    val cursorColor: ColorSpec,
    val errorCursorColor: ColorSpec,
    val textSelectionColors: TextSelectionColors,
    val focusedOutlineColor: ColorSpec,
    val unfocusedOutlineColor: ColorSpec,
    val disabledOutlineColor: ColorSpec,
    val errorOutlineColor: ColorSpec,
) {
    /**
     * Determines the appropriate container background color based on the field's state.
     *
     * @param enabled Whether the field is enabled
     * @param isError Whether the field is in error state
     * @param interactionSource Source of interaction to determine focus state
     * @return State holding the appropriate container color
     */
    @Composable
    internal fun containerColor(
        enabled: Boolean,
        isError: Boolean,
        interactionSource: InteractionSource,
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        return rememberUpdatedState(
            when {
                !enabled -> disabledContainerColor.value
                isError -> errorContainerColor.value
                focused -> focusedContainerColor.value
                else -> unfocusedContainerColor.value
            },
        )
    }

    /**
     * Determines the appropriate outline/border color based on the field's state.
     *
     * @param value Current text value in the field
     * @param enabled Whether the field is enabled
     * @param isError Whether the field is in error state
     * @param interactionSource Source of interaction to determine focus state
     * @return State holding the appropriate outline color
     */
    @Composable
    fun containerOutlineColor(
        value: String,
        enabled: Boolean,
        isError: Boolean,
        interactionSource: InteractionSource,
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()
        return rememberUpdatedState(
            when {
                !enabled -> disabledOutlineColor.value
                isError -> errorOutlineColor.value
                value.trim().isNotEmpty() -> focusedOutlineColor.value
                focused -> focusedOutlineColor.value
                else -> unfocusedOutlineColor.value
            },
        )
    }

    /**
     * Determines the appropriate text color based on the field's state.
     *
     * @param enabled Whether the field is enabled
     * @param isError Whether the field is in error state
     * @param interactionSource Source of interaction to determine focus state
     * @return State holding the appropriate text color
     */
    @Composable
    internal fun textColor(
        enabled: Boolean,
        isError: Boolean,
        interactionSource: InteractionSource,
    ): State<Color> {
        val focused by interactionSource.collectIsFocusedAsState()

        return rememberUpdatedState(
            when {
                !enabled -> disabledTextColor.value
                isError -> errorTextColor.value
                focused -> focusedTextColor.value
                else -> unfocusedTextColor.value
            },
        )
    }

    /**
     * Determines the appropriate cursor color based on error state.
     *
     * @param isError Whether the field is in error state
     * @return State holding the appropriate cursor color
     */
    @Composable
    internal fun cursorColor(isError: Boolean): State<Color> {
        return rememberUpdatedState(if (isError) errorCursorColor.value else cursorColor.value)
    }

    /**
     * The text selection colors to use for the text field.
     */
    internal val selectionColors: TextSelectionColors
        @Composable get() = textSelectionColors
}