package com.zomato.sushi.compose.markdown

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.AnnotatedString

/**
 * Main parser for transforming markdown text into styled AnnotatedString.
 * 
 * MarkdownParser orchestrates a chain of processors to transform plain text with
 * markdown syntax into richly styled text. It supports a variety of formatting
 * including bold, italic, colors, and links through its configurable processor pipeline.
 *
 * @property processors The list of processors to apply in sequence
 *
 * @author gupta.anirudh@zomato.com
 */
class MarkdownParser private constructor(
    private val processors: List<Processor>
) {

    companion object {
        /**
         * Default parser instance with standard processors pre-configured.
         * Includes support for bold, italic, strikethrough, colors, font weights, and links.
         */
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

    /**
     * Parses a text string with markdown syntax into an AnnotatedString.
     * 
     * This method applies all configured processors in sequence, with memoization
     * for performance optimization. Each processor transforms the text based on its
     * specific markdown syntax rules.
     *
     * @param text The text containing markdown syntax to parse
     * @param props Configuration properties for the parser
     * @return An AnnotatedString with all styles applied
     */
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

    /**
     * Builder for constructing MarkdownParser instances with custom processor configurations.
     */
    class Builder {
        private var processors: MutableList<Processor> = mutableListOf()

        /**
         * Adds a single processor to the parser configuration.
         *
         * @param processor The processor to add
         * @return This builder for method chaining
         */
        fun processor(processor: Processor): Builder = this.apply {
            this.processors.add(processor)
        }

        /**
         * Adds multiple processors to the parser configuration.
         *
         * @param processors The processors to add
         * @return This builder for method chaining
         */
        fun processors(vararg processors: Processor): Builder  = this.apply {
            this.processors.addAll(processors.toList())
        }

        /**
         * Creates a MarkdownParser with the configured processors.
         *
         * @return A new MarkdownParser instance
         */
        fun build(): MarkdownParser {
            return MarkdownParser(
                processors = processors
            )
        }
    }
}


