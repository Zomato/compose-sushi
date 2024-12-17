@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.animation

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiUnspecified

@ExperimentalSushiApi
@Stable
data class SushiAnimationProps(
    val source: SushiAnimationSource? = Default.source,
    val playback: SushiAnimationPlayback? = Default.playback,
    val width: Dp? = Default.width,
    val height: Dp? = Default.height,
    val aspectRatio: Float? = Default.aspectRatio,
    val bgColor: ColorSpec = Default.bgColor,
) {

    companion object {
        val Default = SushiAnimationProps(
            source = null,
            playback = null,
            width = null,
            height = null,
            aspectRatio = null,
            bgColor = SushiUnspecified.asColorSpec()
        )
    }
}