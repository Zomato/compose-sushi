package com.zomato.sushi.compose.markdown

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration

class StrikethroughProcessor(private val parserVersion: Int) : MarkdownProcessor {
    override fun getParserVersion(): Int {
        return parserVersion
    }

    override fun getProcessingString(): String {
        return "~~"
    }

    override fun apply(builder: AnnotatedString.Builder, start: Int, end: Int): AnnotatedString.Builder {
        if (isMarkdownInApplicable(
                builder,
                start,
                end
            )
        ) return builder
        builder.addStyle(SpanStyle(textDecoration = TextDecoration.LineThrough), start, end)
        return builder
    }
}
