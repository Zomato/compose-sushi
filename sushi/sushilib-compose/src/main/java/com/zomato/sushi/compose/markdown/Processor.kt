package com.zomato.sushi.compose.markdown

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.AnnotatedString

interface Processor {

    @get:Composable
    @Stable
    val cacheKeys: List<Any>

    @Composable
    fun process(props: MarkdownParserProps, src: AnnotatedString, parser: MarkdownParser): AnnotatedString
}