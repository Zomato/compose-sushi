package com.zomato.sushi.compose.markdown

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.AnnotatedString

/**
 * Interface defining a text processor for Sushi's markdown system.
 * 
 * Processors are responsible for transforming text by identifying specific patterns
 * (like bold, italic, colors) and applying the corresponding styles to create
 * rich text rendering. Each processor focuses on a specific type of markdown syntax.
 *
 * @author gupta.anirudh@zomato.com
 */
interface Processor {

    /**
     * List of objects that should trigger recomposition when they change.
     * Used to ensure efficient caching of processed text.
     */
    @get:Composable
    @Stable
    val cacheKeys: List<Any>

    /**
     * Processes the source text to apply this processor's specific formatting.
     * 
     * @param props Configuration properties for the markdown parsing
     * @param src The source text to process
     * @param parser Reference to the parent parser for potential nested processing
     * @return The processed text with styles applied
     */
    @Composable
    fun process(props: MarkdownParserProps, src: AnnotatedString, parser: MarkdownParser): AnnotatedString
}