package com.zomato.sushi.compose.markdown

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
    }

    fun parse(
        text: String,
        props: MarkdownParserProps
    ): AnnotatedString {
        return processors
            .filter { it.isApplicable(props) }
            .fold(AnnotatedString(text), { acc, markdownProcessor ->  markdownProcessor.process(props, acc) })
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


