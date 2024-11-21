package com.zomato.sushi.compose.markdown

import android.content.Context
import androidx.compose.ui.text.AnnotatedString
import com.zomato.sushi.compose.markdown.MarkdownParser.Companion.PARSER_VERSION_1

/**
 * @return true if markdown is not applicable.
 */
fun isMarkdownInApplicable(builder: AnnotatedString.Builder, start: Int, end: Int): Boolean {
    if (builder.toString().isEmpty() && start == end) return true
    return false
}

/**
 * @param text text which contains regex
 * if it contain ay link then pass context and isClickable as true.
 */
fun parseMarkedDownText(
    text: String?,
    isClickable: Boolean? = false,
    parserVersion: Int? = null,
    context: Context? = null
): AnnotatedString {
    return MarkdownParser.parse(
        text,
        isClickable ?: false,
        parserVersion ?: PARSER_VERSION_1,
        context
    )
}
