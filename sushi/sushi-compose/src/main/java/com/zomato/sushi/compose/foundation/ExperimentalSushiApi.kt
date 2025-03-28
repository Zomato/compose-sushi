package com.zomato.sushi.compose.foundation

/**
 * Annotation used to mark APIs in the Sushi design system that are experimental and subject to change.
 *
 * Classes, functions, properties, or other declarations marked with this annotation should be
 * considered unstable and may change significantly in future releases without following
 * the standard deprecation cycle.
 *
 * Usage of APIs marked with this annotation requires explicit opt-in from consumers.
 *
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