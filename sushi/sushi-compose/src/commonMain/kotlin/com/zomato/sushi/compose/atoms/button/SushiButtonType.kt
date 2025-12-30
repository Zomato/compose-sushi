package com.zomato.sushi.compose.atoms.button

import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec


/**
 * @author gupta.anirudh@zomato.com
 *
 * Defines the visual style variants for SushiButton components.
 *
 * - Text: Button with only text, no background or border
 * - Solid: Button with solid background color and text
 * - Outline: Button with a border outline and text
 * - Underline: Button with underlined text
 */
sealed interface SushiButtonType {
    data object Text : SushiButtonType

    data object Solid : SushiButtonType

    data object Outline : SushiButtonType

    data class Underline(
        val dotSize: Dp? = null,
        val gapSize: Dp? = null,
        val strokeWidth: Dp? = null,
        val color: ColorSpec? = null
    ) : SushiButtonType
}