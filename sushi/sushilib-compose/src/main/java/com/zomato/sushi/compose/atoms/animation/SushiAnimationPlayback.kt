package com.zomato.sushi.compose.atoms.animation

sealed interface SushiAnimationPlayback {
    data class AutoPlay(
        val isPlaying: Boolean = true,
        val restartOnPlay: Boolean = true,
        val reverseOnRepeat: Boolean = false,
        val speed: Float = 1f,
        val iterations: Int = 1
    ) : SushiAnimationPlayback

    /**
     * Value between 0..1, signifying the progress.
     * Generally used when [LottieCompositionSource] is provided as the source in [SushiAnimation].
     */
    @JvmInline value class Progress(val valueProvider: () -> Float) : SushiAnimationPlayback
}