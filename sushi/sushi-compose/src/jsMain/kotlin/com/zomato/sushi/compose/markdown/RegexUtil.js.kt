package com.zomato.sushi.compose.markdown

internal actual fun MatchGroup.getGroupRange(): IntRange {
    // TODO: Kotlin/js does not have matchGroup.range property as of now.
    // https://discuss.kotlinlang.org/t/issues-with-regexp-in-multiplatform-projects/22509
    throw Exception("matchGroup.range is not implemented in Kotlin/js")
}