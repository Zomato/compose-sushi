package com.zomato.sushi.compose.components.viewflipper

import androidx.compose.runtime.Immutable

/**
 * Properties for configuring a SushiViewFlipper component.
 *
 * SushiViewFlipperProps encapsulates configuration options for an automatic content flipper
 * that cycles through multiple items with customizable timing, animation direction, and behavior.
 *
 * @property flipInterval Time in milliseconds between content flips (default: 3000ms)
 * @property animationDuration Duration of the flip animation in milliseconds (default: 600ms)
 * @property animationDirection Direction for the flip animation (FlipToTop or FlipToBottom)
 * @property isPlaying Whether the flipper should be actively cycling (default: true)
 * @property count Number of items to display in the flipper (default: 1)
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiViewFlipperProps(
    val flipInterval: Long? = null,
    val animationDuration: Int? = null,
    val animationDirection: FlipAnimationDirection? = null,
    val isPlaying: Boolean? = null,
    val count: Int? = null
) {
    /**
     * Defines the direction of the flip animation.
     */
    enum class FlipAnimationDirection {
        /**
         * New content slides in from bottom, current content slides out to top
         */
        FlipToTop,
        
        /**
         * New content slides in from top, current content slides out to bottom
         */
        FlipToBottom
    }
}

