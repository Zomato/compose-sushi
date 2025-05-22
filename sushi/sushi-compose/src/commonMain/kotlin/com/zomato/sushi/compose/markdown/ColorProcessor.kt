package com.zomato.sushi.compose.markdown

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.getColor
import com.zomato.sushi.compose.atoms.color.withAlpha
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.core.SushiColorToken

/**
 * Processor that applies custom text colors using curly brace syntax.
 *
 * This processor recognizes patterns like "{red-500|text}" and applies the specified
 * color to the enclosed text. It integrates with the Sushi design system's color system
 * to provide access to the full color palette.
 *
 * Format: {colorName[-variation[-alpha]]|text} where:
 * - colorName: color name from SushiColors (e.g., "red", "blue", "green")
 * - variation: optional variation/shade (e.g., 500, 700) - defaults to 500 if omitted
 * - alpha: optional alpha value between 0 and 1 - defaults to 1 if omitted
 * - text: content to be colored
 *
 * @author gupta.anirudh@zomato.com
 */
class ColorProcessor() : Processor {

    private data class Transformation(
        val start: Int,
        val end: Int,
        val transformedText: AnnotatedString,
        val color: Color
    )

    companion object {
        private val REGEX = "(\\{)(.+?)(\\|)((.|\\n)+?)(\\})".toRegex()
        private const val COLOR_GROUP = 2
        private const val TEXT_GROUP = 4
    }

    override val cacheKeys: List<Any> @Composable get() = listOf(SushiTheme.colorTokenMapper)

    @Composable
    override fun process(props: MarkdownParserProps, src: AnnotatedString, parser: MarkdownParser): AnnotatedString {
        val transformationsList = mutableListOf<Transformation>()
        val matchResults = REGEX.findAll(src)

        matchResults.forEach { matchResult ->
            val colorGroup = matchResult.groups[COLOR_GROUP]
            val textGroup = matchResult.groups[TEXT_GROUP]
            val color = colorGroup?.value?.let { parseColor(it) }

            if (textGroup != null && color != null) {
                transformationsList.add(
                    Transformation(
                        start = matchResult.range.first,
                        end = matchResult.range.last + 1,
                        transformedText = AnnotatedString(textGroup.value),
                        color = color
                    )
                )
            }
        }

        return buildAnnotatedString {
            var currentStartIdx = 0

            transformationsList.forEach {
                this.append(src.subSequence(currentStartIdx, it.start))
                this.append(it.transformedText)
                this.addStyle(
                    SpanStyle(color = it.color),
                    this.length - it.transformedText.length,
                    this.length
                )
                currentStartIdx = it.end
            }

            append(src.subSequence(currentStartIdx, src.length))
        }
    }

    @Composable
    private fun parseColor(color: String): Color? {
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
}
