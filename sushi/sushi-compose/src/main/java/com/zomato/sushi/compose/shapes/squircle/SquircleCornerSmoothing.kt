package com.zomato.sushi.compose.shapes.squircle

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable

/** Collection of commonly used corner smoothing values for a [SquircleShape]. */
@Immutable
@JvmInline
value class SquircleCornerSmoothing private constructor(val value: Float) {
    companion object {
        /** Does not apply corner smoothing. The result will be [RoundedCornerShape]. */
        val None: SquircleCornerSmoothing = SquircleCornerSmoothing(0.55f)

        /** Applies a small amount of corner smoothing, resulting slightly pronounced [SquircleShape]. */
        val Small: SquircleCornerSmoothing = SquircleCornerSmoothing(0.67f)

        /** Applies a medium amount of corner smoothing, resulting quite pronounced [SquircleShape]. */
        val Medium: SquircleCornerSmoothing = SquircleCornerSmoothing(0.72f)

        /** Applies a high amount of corner smoothing, resulting highly pronounced [SquircleShape]. */
        val High: SquircleCornerSmoothing = SquircleCornerSmoothing(0.8f)

        /** Applies a full amount of corner smoothing, resulting fully pronounced [SquircleShape]. */
        val Full: SquircleCornerSmoothing = SquircleCornerSmoothing(1f)

        /** Default corner smoothing value. */
        val Default: SquircleCornerSmoothing = Medium
    }
}