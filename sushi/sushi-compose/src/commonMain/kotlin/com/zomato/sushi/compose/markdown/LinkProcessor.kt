package com.zomato.sushi.compose.markdown

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink

/**
 * Processor that converts markdown link syntax into clickable links.
 *
 * This processor recognizes patterns like "[link text](https://example.com)" and transforms
 * them into clickable links with proper styling. Links are handled by [LocalUriHandler]
 * when clicked.
 *
 * @author gupta.anirudh@zomato.com
 */
class LinkProcessor() : Processor {

    companion object {
        private val REGEX = "(\\[)((.|\\n)+?)(]\\()(.+?)(\\))".toRegex()
        private const val LINK_GROUP = 5
        private const val TEXT_GROUP = 2
    }

    private data class Transformation(
        val start: Int,
        val end: Int,
        val transformedText: AnnotatedString,
        val link: String?
    )

    override val cacheKeys: List<Any> @Composable get() = emptyList()

    @Composable
    override fun process(props: MarkdownParserProps, src: AnnotatedString, parser: MarkdownParser): AnnotatedString {
        if (!props.isClickable) {
            return src
        }
        val transformationsList = mutableListOf<Transformation>()
        val matchResults = REGEX.findAll(src)

        matchResults.forEach { matchResult ->
            val linkGroup = matchResult.groups[LINK_GROUP]
            val textGroup = matchResult.groups[TEXT_GROUP]

            if (textGroup != null) {
                transformationsList.add(
                    Transformation(
                        start = matchResult.range.first,
                        end = matchResult.range.last + 1,
                        transformedText = AnnotatedString(textGroup.value),
                        link = linkGroup?.value
                    )
                )
            }
        }

        return buildAnnotatedString {
            var currentStartIdx = 0

            transformationsList.forEach {
                this.append(src.subSequence(currentStartIdx, it.start))
                withLink(
                    LinkAnnotation.Url(
                        it.link ?: "",
                        styles = TextLinkStyles(
                            style = SpanStyle(
                                textDecoration = TextDecoration.Underline
                            ),
                        )
                    )
                ) {
                    append(it.transformedText)
                }
                currentStartIdx = it.end
            }

            append(src.subSequence(currentStartIdx, src.length))
        }
    }
}
