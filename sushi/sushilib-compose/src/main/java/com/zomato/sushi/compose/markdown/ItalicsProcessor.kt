package com.zomato.sushi.compose.markdown

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle

class ItalicsProcessor(private val parserVersion: Int) : MarkdownProcessor {

    companion object {
        private const val REGEX_ITALIC_V1 = "_"
        private const val REGEX_ITALIC_V2 = "<i><i>"
    }

    override fun getParserVersion(): Int {
        return parserVersion
    }

    override fun getProcessingString(): String {
        return if (getParserVersion() == MarkdownParser.PARSER_VERSION_2) REGEX_ITALIC_V2 else REGEX_ITALIC_V1
    }

    override fun apply(builder: AnnotatedString.Builder, start: Int, end: Int): AnnotatedString.Builder {
        if (isMarkdownInApplicable(builder, start, end)) return builder

        builder.addStyle(SpanStyle(fontStyle = FontStyle.Italic), start, end)
        return builder
    }
}
