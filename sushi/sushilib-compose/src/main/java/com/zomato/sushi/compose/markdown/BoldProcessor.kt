package com.zomato.sushi.compose.markdown

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight

class BoldProcessor(private val version: Int) : MarkdownProcessor {

    override fun getParserVersion(): Int {
        return version
    }

    override fun getProcessingString(): String {
        return "**"
    }

    override fun apply(builder: AnnotatedString.Builder, start: Int, end: Int): AnnotatedString.Builder {
        if (isMarkdownInApplicable(builder, start, end)) return builder

        builder.addStyle(SpanStyle(fontWeight = FontWeight.Bold), start, end)
        return builder
    }
}
