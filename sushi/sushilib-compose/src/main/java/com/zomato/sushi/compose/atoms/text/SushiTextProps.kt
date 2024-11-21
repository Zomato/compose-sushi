package com.zomato.sushi.compose.atoms.text

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.foundation.SushiUnspecified

// markdown version: always 3 for now
// isClickable
// gradientColorData
// shouldNotAdjustFontSize
// tailText
// replacementText
// gradient support in color, bgcolor
@ExperimentalSushiApi
@Immutable
data class SushiTextProps constructor(
    val text: String? = Default.text,
    val color: ColorSpec = Default.color,
    val type: TextTypeSpec? = Default.type,
    val maxLines: Int? = Default.maxLines,
    val prefixIcon: SushiIconProps? = null,
    val suffixIcon: SushiIconProps? = null,
    val letterSpacing: TextUnit = Default.letterSpacing,
    val isMarkDownEnabled: Boolean? = Default.isMarkDownEnabled,
    val textDecoration: TextDecoration? = Default.textDecoration,
    val textAlign: TextAlign? = Default.textAlign,
    val overflow: TextOverflow? = Default.overflow,
    val overflowText: String? = Default.overflowText,
    val softWrap: Boolean? = Default.softWrap,
    val minLines: Int? = null
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
            softWrap = null,
            minLines = null
        )
    }
}
