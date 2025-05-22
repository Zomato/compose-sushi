package com.zomato.sushi.compose.markdown

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration

/**
 * Processor that applies strikethrough formatting to text surrounded by double tildes.
 * 
 * This processor recognizes text patterns like "~~strikethrough text~~" and applies
 * TextDecoration.LineThrough styling to the content between the tildes.
 *
 * @author gupta.anirudh@zomato.com
 */
class StrikethroughProcessor() : Processor {

    private data class Transformation(
        val start: Int,
        val end: Int,
        val text: AnnotatedString
    )

    companion object {
        private val REGEX = "~~(.*?)~~".toRegex()
        private const val TEXT_GROUP = 1
    }

    override val cacheKeys: List<Any> @Composable get() = emptyList()

    @Composable
    override fun process(props: MarkdownParserProps, src: AnnotatedString, parser: MarkdownParser): AnnotatedString {
        val transformationsList = mutableListOf<Transformation>()
        val matchResults = REGEX.findAll(src)

        matchResults.forEach { matchResult ->
            val textGroup = matchResult.groups[TEXT_GROUP]

            if (textGroup != null) {
                transformationsList.add(
                    Transformation(
                        start = matchResult.range.first,
                        end = matchResult.range.last + 1,
                        text = AnnotatedString(textGroup.value)
                    )
                )
            }
        }

        return buildAnnotatedString {
            var currentStartIdx = 0

            transformationsList.forEach {
                this.append(src.subSequence(currentStartIdx, it.start))
                this.append(it.text)
                this.addStyle(
                    SpanStyle(textDecoration = TextDecoration.LineThrough),
                    this.length - it.text.length,
                    this.length
                )
                currentStartIdx = it.end
            }

            append(src.subSequence(currentStartIdx, src.length))
        }
    }
}
