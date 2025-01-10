package com.zomato.sushi.compose.shapes.squircle

import androidx.compose.foundation.shape.RoundedCornerShape

/** Collection of commonly used corner smoothing values for a [SquircleShape]. */
object SquircleCornerSmoothing {

    val Default: Float get() = Medium

    /** Does not apply corner smoothing. The result will be [RoundedCornerShape]. */
    val None: Float get() = 0.55f

    /** Applies a small amount of corner smoothing, resulting slightly pronounced [SquircleShape]. */
    val Small: Float get() = 0.67f

    /** Applies a medium amount of corner smoothing, resulting quite pronounced [SquircleShape]. */
    val Medium: Float get() = 0.72f

    /** Applies a high amount of corner smoothing, resulting highly pronounced [SquircleShape]. */
    val High: Float get() = 0.8f

    /** Applies a full amount of corner smoothing, resulting fully pronounced [SquircleShape]. */
    val Full: Float get() = 1f

}