@file:OptIn(ExperimentalSushiApi::class)
package com.zomato.sushi.compose.atoms.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
@Immutable
data class SushiTextProps constructor(
    val text: CharSequence? = Default.text,
    val color: ColorSpec = Default.color,
    val type: TextTypeSpec? = Default.type,
    val maxLines: Int? = Default.maxLines,
    val prefixIcon: SushiIconProps? = null,
    val suffixIcon: SushiIconProps? = null,
    val letterSpacing: TextUnit = Default.letterSpacing,
    val isMarkDownEnabled: Boolean? = Default.isMarkDownEnabled,
    val textDecoration: SushiTextDecoration? = Default.textDecoration,
    val textAlign: TextAlign? = Default.textAlign,
    val overflow: TextOverflow? = Default.overflow,
    val overflowText: String? = Default.overflowText,
    val overflowTextColor: ColorSpec? = Default.overflowTextColor,
    val softWrap: Boolean? = Default.softWrap,
    val minLines: Int? = null,
    val prefixSpacing: Dp? = Default.prefixSpacing,
    val suffixSpacing: Dp? = Default.suffixSpacing,
    val horizontalArrangement: Arrangement.Horizontal? = Default.horizontalArrangement,
    val verticalAlignment: Alignment.Vertical? = Default.verticalAlignment
) {

    companion object {
        val Default = SushiTextProps(
            text = null,
            color = SushiUnspecified.asColorSpec(),
            type = null,
            prefixIcon = null,
            suffixIcon = null,
            maxLines = null,
            letterSpacing = TextUnit.Unspecified,
            isMarkDownEnabled = null,
            textDecoration = null,
            textAlign = null,
            overflow = null,
            overflowText = null,
            overflowTextColor = SushiUnspecified.asColorSpec(),
            softWrap = null,
            minLines = null,
            prefixSpacing = null,
            suffixSpacing = null,
            horizontalArrangement = null,
            verticalAlignment = null
        )
    }
}

sealed interface SushiTextDecoration {
    data class Underline(
        val dotSize: Dp? = null,
        val gapSize: Dp? = null,
        val strokeWidth: Dp? = null,
        val color: ColorSpec? = null
    ) : SushiTextDecoration

    data class LineThrough(
        val dotSize: Dp? = null,
        val gapSize: Dp? = null,
        val strokeWidth: Dp? = null,
        val color: ColorSpec? = null
    ) : SushiTextDecoration
}
