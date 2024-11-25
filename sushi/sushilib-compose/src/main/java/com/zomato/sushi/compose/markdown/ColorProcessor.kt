package com.zomato.sushi.compose.markdown

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.getColor
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import java.util.regex.Pattern

class ColorProcessor() : Processor {

    private data class Transformation(
        val start: Int,
        val end: Int,
        val transformedText: AnnotatedString,
        val color: ULong
    )

    companion object {
        private const val REGEX = "(\\{)(.+?)(\\|)((.|\\n)+?)(\\})"
        const val COLOR_GROUP = 2
        const val TEXT_GROUP = 4
    }

    override fun isApplicable(props: MarkdownParserProps): Boolean {
        return true
    }

    @OptIn(ExperimentalSushiApi::class)
    override fun process(context: Context?, src: AnnotatedString): AnnotatedString {
        val transformationsList = mutableListOf<Transformation>()
        val matcher = getPattern().matcher(src)

        while (matcher.find()) {
            val color = matcher.group(COLOR_GROUP)
            var textStart = -1
            var textEnd = -1
            runCatching {
                textStart = matcher.start(TEXT_GROUP)
                textEnd = matcher.end(TEXT_GROUP)
            }
            if (textStart != -1 && textEnd != -1) {
                val text = src.subSequence(textStart, textEnd)

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

        return buildAnnotatedString {
            var currentStartIdx = 0

            transformationsList.forEach {
                this.append(src.subSequence(currentStartIdx, it.start))
                this.append(it.transformedText)
                this.addStyle(
                    SpanStyle(color = Color(it.color)),
                    this.length - it.transformedText.length, this.length
                )
                currentStartIdx = it.end
            }

            append(src.subSequence(currentStartIdx, src.length))
        }
    }


    private fun getPattern(): Pattern {
        return Pattern.compile(REGEX)
    }

    private fun isValidInteger(integerString: String?): Boolean {
        if (integerString.isNullOrEmpty())
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
}
