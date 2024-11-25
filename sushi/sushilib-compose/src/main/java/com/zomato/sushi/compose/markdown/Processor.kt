package com.zomato.sushi.compose.markdown

import android.content.Context
import androidx.compose.ui.text.AnnotatedString

interface Processor {
    fun isApplicable(props: MarkdownParserProps): Boolean
    fun process(context: Context?, src: AnnotatedString): AnnotatedString
}