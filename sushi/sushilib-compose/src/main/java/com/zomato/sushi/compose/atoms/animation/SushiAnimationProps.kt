@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.animation

import androidx.compose.runtime.Stable
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

@ExperimentalSushiApi
@Stable
data class SushiAnimationProps(
    val source: SushiAnimationSource? = Default.source,
    val playback: SushiAnimationPlayback? = Default.playback
) {

    companion object {
        val Default = SushiAnimationProps(
            source = null,
            playback = null
        )
    }
}