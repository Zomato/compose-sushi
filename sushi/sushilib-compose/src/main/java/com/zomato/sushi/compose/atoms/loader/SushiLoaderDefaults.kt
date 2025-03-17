package com.zomato.sushi.compose.atoms.loader

import androidx.compose.ui.unit.dp

/**
 * Provides default values for SushiLoader components.
 * These defaults are used when specific properties are not provided in SushiLoaderProps.
 *
 * @author gupta.anirudh@zomato.com
 */
object SushiLoaderDefaults {
    /**
     * Minimum size (width and height) of the loader in dp.
     * This ensures the loader remains visible and properly proportioned even in small containers.
     */
    public val minSize = 50.dp

    internal val innerAngleOffset = 0f
    internal val animationSpeedMultiplier = 1f
}