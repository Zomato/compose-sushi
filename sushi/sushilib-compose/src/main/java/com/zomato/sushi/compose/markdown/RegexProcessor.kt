package com.zomato.sushi.compose.markdown

internal interface RegexProcessor<T> {
    fun transform(t: T): T
}
