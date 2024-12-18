package com.zomato.sushi.compose.markdown

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import java.util.regex.Pattern

/**
 * @author gupta.anirudh@zomato.com
 */
class StrikethroughProcessor() : Processor {

    private data class Transformation(
        val start: Int,
        val end: Int,
        val text: AnnotatedString
    )

    companion object {
        private const val REGEX = "~~(.*?)~~"
        const val TEXT_GROUP = 1
    }

    override val cacheKeys: List<Any> @Composable get() = emptyList()

    @Composable
    override fun process(props: MarkdownParserProps, src: AnnotatedString, parser: MarkdownParser): AnnotatedString {
        val transformationsList = mutableListOf<Transformation>()
        val matcher = getPattern().matcher(src)

        while (matcher.find()) {
            var textStart = -1
            var textEnd = -1
            runCatching {
                textStart = matcher.start(TEXT_GROUP)
                textEnd = matcher.end(TEXT_GROUP)
            }
            if (textStart != -1 && textEnd != -1) {
                val text = src.subSequence(textStart, textEnd)
                transformationsList.add(
                    Transformation(
                        start = matcher.start(),
                        end = matcher.end(),
                        text = text
                    )
                )
            }
        }

        return buildAnnotatedString {
            var currentStartIdx = 0

            transformationsList.forEach {
                this.append(src.subSequence(currentStartIdx, it.start))
                this.append(it.text)
                this.addStyle(SpanStyle(textDecoration = TextDecoration.LineThrough), it.start, it.end)
                currentStartIdx = it.end
            }

            append(src.subSequence(currentStartIdx, src.length))
        }
    }


    private fun getPattern(): Pattern {
        return Pattern.compile(REGEX)
    }
}
