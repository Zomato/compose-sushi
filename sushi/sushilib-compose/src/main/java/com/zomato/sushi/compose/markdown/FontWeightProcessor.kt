package com.zomato.sushi.compose.markdown

import android.content.Context
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.zomato.sushi.compose.atoms.internal.scaled
import com.zomato.sushi.compose.foundation.FontTypes
import com.zomato.sushi.compose.foundation.OkraFontFamily
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
import java.util.regex.Pattern

class FontWeightProcessor(): Processor {

    companion object {
        private const val FONT_REGEX_V3 = "(\\<)(.+?)(\\|)((.|\\n)+?)(\\>)"
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

    override fun isApplicable(props: MarkdownParserProps): Boolean {
        return true
    }

    override fun process(context: Context?, src: AnnotatedString): AnnotatedString {
        val transformationsList = mutableListOf<Transformation>()
        val matcher = getPattern().matcher(src)

        while (matcher.find()) {
            val font = matcher.group(FONT_GROUP)
            var textStart = -1
            var textEnd = -1
            runCatching {
                textStart = matcher.start(TEXT_GROUP)
                textEnd = matcher.end(TEXT_GROUP)
            }

            if (textStart != -1 && textEnd != -1) {
                val text = src.subSequence(textStart, textEnd)

                val fontDataList = font?.split(FONT_DATA_DELIMITER)

                transformationsList.add(
                    Transformation(
                        start = matcher.start(),
                        end = matcher.end(),
                        transformedText = text,
                        fontWeight = getFontWeight(fontDataList?.getOrNull(FONT_WEIGHT_INDEX)),
                        fontSize = getFontSize(fontDataList?.getOrNull(FONT_SIZE_INDEX), context)
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
                        fontSize = it.fontSize,
                        fontFamily = OkraFontFamily
                    ),
                    this.length - it.transformedText.length, this.length
                )
                currentStartIdx = it.end
            }

            append(src.subSequence(currentStartIdx, src.length))
        }
    }

    private fun getPattern(): Pattern {
        return Pattern.compile(FONT_REGEX_V3)
    }

    private fun getFontWeight(label: String?): FontWeight {
        val fontType = FontTypes.fromLabel(label) ?: FontTypes.Regular
        return fontType.fontWeight()
    }

    private fun getFontSize(value: String?, context: Context?): TextUnit {
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
        return context?.let { size.scaled(context) } ?: size
    }
}
