package com.zomato.sushi.compose.markdown

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.zomato.sushi.compose.foundation.SushiFontWeight
import com.zomato.sushi.compose.foundation.SushiTextSize050
import com.zomato.sushi.compose.foundation.SushiTextSize100
import com.zomato.sushi.compose.foundation.SushiTextSize200
import com.zomato.sushi.compose.foundation.SushiTextSize300
import com.zomato.sushi.compose.foundation.SushiTextSize400
import com.zomato.sushi.compose.foundation.SushiTextSize500
import com.zomato.sushi.compose.foundation.SushiTextSize600
import com.zomato.sushi.compose.foundation.SushiTextSize700
import com.zomato.sushi.compose.foundation.SushiTextSize800
import com.zomato.sushi.compose.foundation.SushiTextSize900
import com.zomato.sushi.compose.foundation.fontWeight

/**
 * Processor that applies custom font weight and size to text based on angle bracket syntax.
 *
 * This processor recognizes patterns like "<bold-300|text>" and applies the specified
 * font weight (bold) and size (300) to the enclosed text. It integrates with the Sushi
 * design system's typography tokens to ensure consistent text styling.
 *
 * Format: <weight-size|text> where:
 * - weight: font weight name (light, regular, medium, semibold, bold, extrabold)
 * - size: numeric size value (50, 100, 200, etc. up to 900)
 * - text: content to be styled
 *
 * @author gupta.anirudh@zomato.com
 */
class FontWeightProcessor(): Processor {

    companion object {
        private val FONT_REGEX = "(\\<)(.+?)(\\|)((.|\\n)+?)(\\>)".toRegex()
        private const val FONT_GROUP = 2
        private const val TEXT_GROUP = 4
        private val FONT_DATA_DELIMITER = "-".toRegex()
        private const val FONT_WEIGHT_INDEX = 0
        private const val FONT_SIZE_INDEX = 1
    }

    private data class Transformation(
        val start: Int,
        val end: Int,
        val transformedText: AnnotatedString,
        val fontWeight: FontWeight,
        val fontSize: TextUnit
    )

    override val cacheKeys: List<Any> @Composable get() = emptyList()

    @Composable
    override fun process(props: MarkdownParserProps, src: AnnotatedString): AnnotatedString {
        val transformationsList = mutableListOf<Transformation>()
        val matchResults = FONT_REGEX.findAll(src)

        matchResults.forEach { matchResult ->
            val fontGroup = matchResult.groups[FONT_GROUP]
            val textGroup = matchResult.groups[TEXT_GROUP]

            if (textGroup != null) {
                val fontDataList = fontGroup?.value?.split(FONT_DATA_DELIMITER)
                val transformedText = src.subSequence(textGroup.getTextRange())

                transformationsList.add(
                    Transformation(
                        start = matchResult.range.first,
                        end = matchResult.range.last + 1,
                        transformedText = transformedText,
                        fontWeight = getFontWeight(fontDataList?.getOrNull(FONT_WEIGHT_INDEX)),
                        fontSize = getFontSize(fontDataList?.getOrNull(FONT_SIZE_INDEX), props)
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
                    SpanStyle(
                        fontWeight = it.fontWeight,
                        fontSize = it.fontSize
                    ),
                    this.length - it.transformedText.length,
                    this.length
                )
                currentStartIdx = it.end
            }

            append(src.subSequence(currentStartIdx, src.length))
        }
    }

    private fun getFontWeight(label: String?): FontWeight {
        val sushiFontWeight = SushiFontWeight.fromLabel(label) ?: SushiFontWeight.Regular
        return sushiFontWeight.fontWeight()
    }

    private fun getFontSize(value: String?, props: MarkdownParserProps): TextUnit {
        val sizeInt = runCatching { value?.toInt() }.getOrNull()
        val size = when (sizeInt) {
            50 -> SushiTextSize050
            100 -> SushiTextSize100
            200 -> SushiTextSize200
            300 -> SushiTextSize300
            400 -> SushiTextSize400
            500 -> SushiTextSize500
            600 -> SushiTextSize600
            700 -> SushiTextSize700
            800 -> SushiTextSize800
            900 -> SushiTextSize900
            else -> SushiTextSize500
        }
        return props.fontSizeMultiplier(size)
    }
}
