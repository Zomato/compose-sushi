package com.zomato.sushi.compose.components.viewflipper

object SushiViewFlipperDefaults {
    const val flipIntervalMs = 3000L
    const val flipAnimationDurationMs = 600

    internal val SushiViewFlipperProps.flipIntervalMsOrDefault: Long get() = this.flipInterval ?: SushiViewFlipperDefaults.flipIntervalMs
    internal val SushiViewFlipperProps.flipAnimationDurationMsOrDefault: Int get() = this.animationDuration ?: SushiViewFlipperDefaults.flipAnimationDurationMs
    internal val SushiViewFlipperProps.countOrDefault: Int get() = this.count ?: 1
    internal val SushiViewFlipperProps.isPlayingOrDefault: Boolean get() = this.isPlaying ?: true
}