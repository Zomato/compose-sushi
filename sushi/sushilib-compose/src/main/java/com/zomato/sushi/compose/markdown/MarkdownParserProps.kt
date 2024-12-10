package com.zomato.sushi.compose.markdown

import com.zomato.sushi.compose.foundation.SushiFontSizeMultiplier

data class MarkdownParserProps(
    val isClickable: Boolean,
    val fontSizeMultiplier: SushiFontSizeMultiplier
) {
    companion object {
        val default = MarkdownParserProps(
            isClickable = true,
            fontSizeMultiplier = { it }
        )
    }
}