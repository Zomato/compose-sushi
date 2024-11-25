package com.zomato.sushi.compose.markdown

import android.content.Context
import androidx.compose.ui.text.AnnotatedString

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

        val defaultProps by lazy {
            MarkdownParserProps(
                isClickable = true
            )
        }
    }

    fun parse(
        context: Context?,
        text: String,
        props: MarkdownParserProps = defaultProps
    ): AnnotatedString {
        return processors
            .filter { it.isApplicable(props) }
            .fold(AnnotatedString(text), { acc, markdownProcessor ->  markdownProcessor.process(context, acc) })
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


