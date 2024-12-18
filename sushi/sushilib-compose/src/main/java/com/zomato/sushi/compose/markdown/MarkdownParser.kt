package com.zomato.sushi.compose.markdown

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.AnnotatedString

// todox: remove
private data class CacheKey(
    val text: String,
    val props: MarkdownParserProps
)

/**
 * @author gupta.anirudh@zomato.com
 */
class MarkdownParser private constructor(
    private val processors: List<Processor>,
    // todox: remove
    // private val cache: ConcurrentHashMap<CacheKey, AnnotatedString> = ConcurrentHashMap()
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
        text: String,
        props: MarkdownParserProps
    ): AnnotatedString {
        val keys = listOf(text, props) + processors.flatMap { it.cacheKeys }
        var result: AnnotatedString? = remember(*keys.toTypedArray()) { null/*cache[CacheKey(text, props)]*/ } // todox: remove commented

        if (result == null) {
            result = processors
                .fold(AnnotatedString(text), { acc, markdownProcessor ->  markdownProcessor.process(props, acc, this) })
                // todox: remove commented
                // .also { cache[CacheKey(text, props)] = it }
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


