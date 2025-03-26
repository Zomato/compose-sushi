package com.zomato.sushi.compose.atoms.shimmer

import androidx.compose.runtime.Composable
import com.zomato.sushi.compose.foundation.SushiTheme

/**
 * Internal default values for SushiShimmer component.
 * These are used when specific properties are not provided in SushiShimmerProps.
 */
object SushiShimmerDefaults {
    /**
     * Default background color for the shimmer effect.
     */
    val bgColor @Composable get() = SushiTheme.colors.surface.shimmer

    /**
     * Default animation highlight color.
     */
    val animationColor @Composable get() = SushiTheme.colors.surface.primary


    internal const val WIDTH = 500f
    internal const val ANGLE_OFFSET = 270f
    internal const val ANIMATION_DURATION = 1000
    internal const val ANIMATION_DELAY = 50
}