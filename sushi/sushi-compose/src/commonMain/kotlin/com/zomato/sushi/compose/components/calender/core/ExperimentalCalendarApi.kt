package com.zomato.sushi.compose.components.calender.core

@RequiresOptIn(
    message = "This calendar API is experimental and is " +
        "likely to change or to be removed in the future.",
    level = RequiresOptIn.Level.ERROR,
)
@Retention(AnnotationRetention.BINARY)
public annotation class ExperimentalCalendarApi
