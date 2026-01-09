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


    internal const val Width = 500f
    internal const val AngleOffset = 270f
    internal const val AnimationDuration = 1000
    internal const val AnimationDelay = 50
}