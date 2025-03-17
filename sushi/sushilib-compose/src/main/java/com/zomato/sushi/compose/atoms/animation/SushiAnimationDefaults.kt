package com.zomato.sushi.compose.atoms.animation

/**
 * Provides default values for SushiAnimation configurations.
 * These defaults are used when specific properties are not provided
 * in the SushiAnimationProps.
 * @author gupta.anirudh@zomato.com
 */
object SushiAnimationDefaults {
    /**
     * Default playback configuration for animations.
     * Uses AutoPlay with default settings.
     */
    internal val playback = SushiAnimationPlayback.AutoPlay()
}