package com.zomato.sushi.compose.markdown

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.getColor
import com.zomato.sushi.compose.atoms.color.withAlpha
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.core.SushiColorToken

internal fun MatchGroup.getTextRange(): TextRange {
    return getGroupRange().let {
        TextRange(it.start, it.endExclusive)
    }
}

internal expect fun MatchGroup.getGroupRange(): IntRange

@Composable
internal fun parseColor(color: String): Color? {
    var parsedColor: ColorSpec? = ColorName.fromColorName(color)
        ?.let { getColor(it, ColorVariation.Variation500, SushiTheme.colors) }
    if (color.contains("-")) {
        val colorObjectString = color.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (colorObjectString.size == 2 && isValidInteger(colorObjectString[1])) {
            val name = ColorName.fromColorName(colorObjectString[0])
            val tint = ColorVariation.fromInt(colorObjectString[1].toInt())
            parsedColor = if (name != null && tint != null) {
                getColor(name, tint, SushiTheme.colors)
            } else {
                null
            }
        }
        if (colorObjectString.size == 3 && isValidInteger(colorObjectString[1])) {
            val name = ColorName.fromColorName(colorObjectString[0])
            val tint = ColorVariation.fromInt(colorObjectString[1].toInt())
            val alpha = colorObjectString[2].toFloatOrNull() ?: 1.0f
            parsedColor = if (name != null && tint != null) {
                getColor(name, tint, SushiTheme.colors).withAlpha(alpha = alpha)
            } else {
                null
            }
        }
    } else if (color.contains("color.")) {
        parsedColor = SushiTheme.colorTokenMapper.invoke(SushiColorToken(color))
    }
    return parsedColor?.value
}

private fun isValidInteger(integerString: String?): Boolean {
    if (integerString.isNullOrEmpty())
        return false
    else {
        try {
            integerString.toInt()
        } catch (e: Throwable) {
            return false
        }
    }
    return true
}