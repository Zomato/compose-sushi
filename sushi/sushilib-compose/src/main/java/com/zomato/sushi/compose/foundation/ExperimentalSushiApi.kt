package com.zomato.sushi.compose.foundation

/**
 * @author gupta.anirudh@zomato.com
 */
@RequiresOptIn(
    level = RequiresOptIn.Level.ERROR,
    message = "This is an experimental API for Compose and is likely to change before becoming " +
        "stable."
)
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.PROPERTY_GETTER
)
@Retention(AnnotationRetention.BINARY)
annotation class ExperimentalSushiApi