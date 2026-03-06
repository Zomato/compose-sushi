package com.zomato.sushi.compose.components.calender.data

internal fun <T : Comparable<T>> checkRange(start: T, end: T) {
    check(end >= start) {
        "start: $start is greater than end: $end"
    }
}

internal expect fun log(tag: String, message: String)
