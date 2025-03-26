package com.zomato.sushi.compose.components.viewflipper

/**
 * Provides default values and extension functions for SushiViewFlipper components.
 * These defaults are used when specific properties are not provided in SushiViewFlipperProps.
 *
 * @author gupta.anirudh@zomato.com
 */
object SushiViewFlipperDefaults {
    /**
     * Default time interval between content flips in milliseconds.
     */
    const val flipIntervalMs = 3000L
    
    /**
     * Default duration of the flip animation in milliseconds.
     */
    const val flipAnimationDurationMs = 600

    internal val SushiViewFlipperProps.flipIntervalMsOrDefault: Long get() = this.flipInterval ?: SushiViewFlipperDefaults.flipIntervalMs
    internal val SushiViewFlipperProps.flipAnimationDurationMsOrDefault: Int get() = this.animationDuration ?: SushiViewFlipperDefaults.flipAnimationDurationMs
    internal val SushiViewFlipperProps.countOrDefault: Int get() = this.count ?: 1
    internal val SushiViewFlipperProps.isPlayingOrDefault: Boolean get() = this.isPlaying ?: true
}