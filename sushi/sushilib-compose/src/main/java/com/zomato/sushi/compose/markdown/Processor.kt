package com.zomato.sushi.compose.markdown

import androidx.compose.ui.text.AnnotatedString

interface Processor {
    fun isApplicable(props: MarkdownParserProps): Boolean
    fun process(props: MarkdownParserProps, src: AnnotatedString): AnnotatedString
}