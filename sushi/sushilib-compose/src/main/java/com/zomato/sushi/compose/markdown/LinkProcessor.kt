package com.zomato.sushi.compose.markdown

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import java.util.regex.Pattern

/**
 * Links handled by LocalUriHandler.current
 */
class LinkProcessor() : Processor {

    companion object {
        private const val REGEX = "(\\[)((.|\\n)+?)(]\\()(.+?)(\\))"
        private const val LINK_GROUP = 5
        private const val TEXT_GROUP = 2
    }

    private data class Transformation(
        val start: Int,
        val end: Int,
        val transformedText: AnnotatedString,
        val link: String?
    )

    override fun isApplicable(props: MarkdownParserProps): Boolean {
        return props.isClickable
    }

    override fun process(props: MarkdownParserProps, src: AnnotatedString): AnnotatedString {
        val transformationsList = mutableListOf<Transformation>()
        val matcher = getPattern().matcher(src)

        while (matcher.find()) {
            val link = matcher.group(LINK_GROUP)
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
                        transformedText = text,
                        link = link
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


    private fun getPattern(): Pattern {
        return Pattern.compile(REGEX)
    }
}
