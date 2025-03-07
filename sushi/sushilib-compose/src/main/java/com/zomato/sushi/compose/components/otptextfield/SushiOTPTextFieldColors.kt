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

    @Composable
    internal fun cursorColor(isError: Boolean): State<Color> {
        return rememberUpdatedState(if (isError) errorCursorColor.value else cursorColor.value)
    }

    internal val selectionColors: TextSelectionColors
        @Composable get() = textSelectionColors
}