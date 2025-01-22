package com.zomato.sushi.compose.markdown

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.AnnotatedString

/**
 * @author gupta.anirudh@zomato.com
 */
class MarkdownParser private constructor(
    private val processors: List<Processor>
) {

    companion object {
        val default by lazy {
            MarkdownParser.Builder()
                .processor(BoldProcessor())
                .processor(ItalicProcessor())
                .processor(StrikethroughProcessor())
                .processor(ColorProcessor())
                .processor(FontWeightProcessor())
                .processor(LinkProcessor())
                .build()
        }
    }

    @Composable
    fun parse(
        text: CharSequence,
        props: MarkdownParserProps
    ): AnnotatedString {
        val keys = listOf(text, props) + processors.flatMap { it.cacheKeys }
        var result: AnnotatedString? = remember(*keys.toTypedArray()) { null }

        if (result == null) {
            val initialAnnotatedString = when {
                text is AnnotatedString -> text
                else -> AnnotatedString(text.toString())
            }
            result = processors
                .fold(initialAnnotatedString, { acc, markdownProcessor ->
                    kotlin.runCatching { markdownProcessor.process(props, acc, this) }.getOrElse { acc }
                })
        }

        return result
    }

    class Builder {
        private var processors: MutableList<Processor> = mutableListOf()

        fun processor(processor: Processor): Builder = this.apply {
            this.processors.add(processor)
        }

        fun processors(vararg processors: Processor): Builder  = this.apply {
            this.processors.addAll(processors.toList())
        }

        fun build(): MarkdownParser {
            return MarkdownParser(
                processors = processors
            )
        }
    }
}


