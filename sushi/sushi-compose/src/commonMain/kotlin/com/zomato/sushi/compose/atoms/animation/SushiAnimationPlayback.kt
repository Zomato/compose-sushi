package com.zomato.sushi.compose.atoms.animation

import kotlin.jvm.JvmInline

/**
 * Defines how a Sushi animation should be played back.
 * This interface provides different strategies for controlling animation playback,
 * such as auto-playing with configuration options or manually controlling via progress value.
 *
 * @author gupta.anirudh@zomato.com
 */
sealed interface SushiAnimationPlayback {
    /**
     * Configuration for automatically playing a Lottie animation.
     *
     * @property isPlaying Whether the animation should be playing or paused
     * @property restartOnPlay Whether the animation should restart when resuming from a paused state
     * @property reverseOnRepeat Whether the animation should play in reverse after completing a forward playback
     * @property speed The playback speed factor (1.0f is normal speed, 2.0f is double speed, etc.)
     * @property iterations The number of times to repeat the animation (use -1 for infinite looping)
     */
    data class AutoPlay(
        val isPlaying: Boolean = true,
        val restartOnPlay: Boolean = true,
        val reverseOnRepeat: Boolean = false,
        val speed: Float = 1f,
        val iterations: Int = 1
    ) : SushiAnimationPlayback

    /**
     * Controls animation manually through a progress value provider function.
     * This allows for precise control of the animation state from external sources.
     *
     * Value between 0..1, signifying the progress.
     * Generally used when [LottieCompositionSource] is provided as the source in [SushiAnimation].
     * 
     * @property valueProvider Function that returns the current animation progress (0.0 to 1.0)
     */
    @JvmInline value class Progress(val valueProvider: () -> Float) : SushiAnimationPlayback
}