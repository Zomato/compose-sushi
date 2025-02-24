package com.zomato.sushi.compose.atoms.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiTextProps(
    val text: CharSequence? = null,
    val color: ColorSpec = SushiUnspecified.asColorSpec(),
    val type: TextTypeSpec? = null,
    val maxLines: Int? = null,
    val prefixIcon: SushiIconProps? = null,
    val suffixIcon: SushiIconProps? = null,
    val letterSpacing: TextUnit = TextUnit.Unspecified,
    val markdown: Boolean? = null,
    val textDecoration: SushiTextDecoration? = null,
    val textAlign: TextAlign? = null,
    val overflow: TextOverflow? = null,
    val overflowText: String? = null,
    val overflowTextColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val softWrap: Boolean? = null,
    val minLines: Int? = null,
    val prefixSpacing: Dp? = null,
    val suffixSpacing: Dp? = null,
    val horizontalArrangement: Arrangement.Horizontal? = null,
    val verticalAlignment: Alignment.Vertical? = null,
    val textBrush: Brush? = null
)

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
