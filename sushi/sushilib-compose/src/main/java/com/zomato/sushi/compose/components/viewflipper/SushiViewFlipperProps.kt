package com.zomato.sushi.compose.components.viewflipper

import androidx.compose.runtime.Immutable

@Immutable
data class SushiViewFlipperProps(
    val flipInterval: Long? = null,
    val animationDuration: Int? = null,
    val animationDirection: FlipAnimationDirection? = null,
    val isPlaying: Boolean? = null,
    val count: Int? = null
) {
    enum class FlipAnimationDirection {
        FlipToTop,
        FlipToBottom
    }
}

