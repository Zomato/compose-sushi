package com.zomato.sushi.compose.markdown

import android.content.Context
import android.text.TextUtils
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.getColor
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import java.util.regex.Pattern

internal class ColorProcessorCompose(private val parserVersion: Int) :
    RegexProcessor<AnnotatedString.Builder> {

    override fun transform(t: AnnotatedString.Builder): AnnotatedString.Builder {
        return t
    }

    private data class Transformation(
        val start: Int,
        val end: Int,
        val transformedText: AnnotatedString,
        val color: ULong
    )

    @OptIn(ExperimentalSushiApi::class)
    fun transformWithColorData(
        annotatedString: AnnotatedString,
        context: Context
    ): AnnotatedString {
        val transformationsList = mutableListOf<Transformation>()
        val matcher = getPattern().matcher(annotatedString)

        while (true) {
            if (!matcher.find()) break
            val color = matcher.group(COLOR_GROUP)
            var textStart = -1
            var textEnd = -1
            runCatching {
                textStart = matcher.start(TEXT_GROUP)
                textEnd = matcher.end(TEXT_GROUP)
            }
            if (textStart != -1 && textEnd != -1) {
                val text = annotatedString.subSequence(textStart, textEnd)

                var parsedColor: ULong = ColorName.fromColorName(color)
                    ?.let { getColor(it, ColorVariation.Variation500).value } ?: 0UL
                if (color?.contains("-") == true) {
                    val colorObjectString = color.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                    if (colorObjectString.size == 2 && isValidInteger(colorObjectString[1])) {
                        val name = ColorName.fromColorName(colorObjectString[0])
                        val tint = ColorVariation.fromInt(colorObjectString[1].toInt())
                        parsedColor = if (name != null && tint != null) {
                            getColor(name, tint).value
                        } else {
                            0UL
                        }
                    }
                    if (colorObjectString.size == 3 && isValidInteger(colorObjectString[1])) {
                        val name = ColorName.fromColorName(colorObjectString[0])
                        val tint = ColorVariation.fromInt(colorObjectString[1].toInt())
                        val alpha = colorObjectString[2].toFloatOrNull() ?: 1.0f
                        parsedColor = if (name != null && tint != null) {
                            getColor(name, tint).copy(alpha = alpha).value
                        } else {
                            0UL
                        }
                    }
                }

                transformationsList.add(
                    Transformation(
                        start = matcher.start(),
                        end = matcher.end(),
                        transformedText = text,
                        color = parsedColor
                    )
                )
            }
        }

        val result = AnnotatedString.Builder().apply {
            var currentStartIdx = 0

            transformationsList.forEach {
                this.append(annotatedString.subSequence(currentStartIdx, it.start))
                this.append(it.transformedText)
                this.addStyle(
                    SpanStyle(color = Color(it.color)),
                    this.length - it.transformedText.length, this.length
                )
                currentStartIdx = it.end
            }

            append(annotatedString.subSequence(currentStartIdx, annotatedString.length))
        }

        return result.toAnnotatedString()
    }


    private fun getPattern(): Pattern {
        return if (parserVersion == MarkdownParser.PARSER_VERSION_3) {
            Pattern.compile(COLOR_REGEX_V3)
        } else {
            Pattern.compile(COLOR_REGEX_DEFAULT)
        }
    }

    private fun isValidInteger(integerString: String?): Boolean {
        if (TextUtils.isEmpty(integerString))
            return false
        else {
            try {
                integerString?.toInt()
            } catch (e: java.lang.Exception) {
                return false
            }
        }
        return true
    }

    companion object {
        private const val COLOR_REGEX_V3 = "(\\{)(.+?)(\\|)((.|\\n)+?)(\\})"
        private const val COLOR_REGEX_DEFAULT = "(\\{)(.+?)(\\|)(.+?)(\\})"
        const val COLOR_GROUP = 2
        const val TEXT_GROUP = 4
    }
}
