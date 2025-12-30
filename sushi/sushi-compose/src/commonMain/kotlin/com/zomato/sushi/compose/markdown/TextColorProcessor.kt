package com.zomato.sushi.compose.markdown

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import com.zomato.sushi.compose.foundation.SushiTheme

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
class TextColorProcessor() : Processor {

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
    override fun process(props: MarkdownParserProps, src: AnnotatedString): AnnotatedString {
        val transformationsList = mutableListOf<Transformation>()
        val matchResults = REGEX.findAll(src)

        matchResults.forEach { matchResult ->
            val colorGroup = matchResult.groups[COLOR_GROUP]
            val textGroup = matchResult.groups[TEXT_GROUP]
            val color = colorGroup?.value?.let { parseColor(it) }

            if (textGroup != null && color != null) {
                val transformedText = src.subSequence(textGroup.getTextRange())
                transformationsList.add(
                    Transformation(
                        start = matchResult.range.first,
                        end = matchResult.range.last + 1,
                        transformedText = transformedText,
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
}
