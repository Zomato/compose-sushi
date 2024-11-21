package com.zomato.sushi.compose.markdown

import androidx.compose.ui.text.AnnotatedString

interface MarkdownProcessor {
    /**
     * Version of parser being used.
     *
     * @see MarkdownParser
     */
    fun getParserVersion(): Int

    /**
     * String to be recognised for applying markdown.
     */
    fun getProcessingString(): String

    /**
     * Apply formatting to the text.
     * @param builder contains text before applying formatting.
     * @param start start of formatting.
     * @param end end of formatting.
     *
     * @return Builder after applying formatting.
     */
    fun apply(builder: AnnotatedString.Builder, start: Int, end: Int): AnnotatedString.Builder
}
