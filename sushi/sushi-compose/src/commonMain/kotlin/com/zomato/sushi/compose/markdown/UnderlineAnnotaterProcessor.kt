package com.zomato.sushi.compose.markdown

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString

/**
 * Processor that applies underline formatting to text surrounded by <u>.
 * 
 * This processor recognizes text patterns like "<u>underlined text<u>" and adds
 * a string annotation for underlining to the content between <u>...<u> tags.
 *
 * [com.zomato.sushi.compose.atoms.text.SushiText] handles the added
 * annotation to add underline styling.
 *
 * @author gupta.anirudh@zomato.com
 */
class UnderlineAnnotaterProcessor() : Processor {

    private data class Transformation(
        val start: Int,
        val end: Int,
        val text: AnnotatedString
    )

    companion object {
        const val ANNOTATION_TAG = "UNDERLINE"
        private val REGEX = "<u>(.*?)<u>".toRegex()
        private const val TEXT_GROUP = 1
    }

    override val cacheKeys: List<Any> @Composable get() = emptyList()

    @Composable
    override fun process(props: MarkdownParserProps, src: AnnotatedString): AnnotatedString {
        val transformationsList = mutableListOf<Transformation>()
        val matchResults = REGEX.findAll(src)

        matchResults.forEach { matchResult ->
            val textGroup = matchResult.groups[TEXT_GROUP]

            if (textGroup != null) {
                val transformedText = src.subSequence(textGroup.getTextRange())
                transformationsList.add(
                    Transformation(
                        start = matchResult.range.first,
                        end = matchResult.range.last + 1,
                        text = transformedText
                    )
                )
            }
        }

        return buildAnnotatedString {
            var currentStartIdx = 0

            transformationsList.forEach {
                this.append(src.subSequence(currentStartIdx, it.start))
                this.append(it.text)
                this.addStringAnnotation(
                    tag = ANNOTATION_TAG,
                    annotation = "true",
                    start = this.length - it.text.length,
                    end = this.length
                )
                currentStartIdx = it.end
            }

            append(src.subSequence(currentStartIdx, src.length))
        }
    }
}
