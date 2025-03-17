package com.zomato.sushi.compose.markdown

import com.zomato.sushi.compose.foundation.SushiFontSizeMultiplier

/**
 * Configuration properties for the Markdown parser.
 * 
 * MarkdownParserProps allows customization of how the markdown text is processed and rendered,
 * including controlling interactive behavior and text scaling.
 *
 * @property isClickable Whether links in the text should be clickable
 * @property fontSizeMultiplier Function to scale font sizes, enabling text size accessibility
 *
 * @author gupta.anirudh@zomato.com
 */
data class MarkdownParserProps(
    val isClickable: Boolean,
    val fontSizeMultiplier: SushiFontSizeMultiplier
) {
    companion object {
        /**
         * Default configuration with clickable links and no font size scaling.
         */
        val default = MarkdownParserProps(
            isClickable = true,
            fontSizeMultiplier = { it }
        )
    }
}