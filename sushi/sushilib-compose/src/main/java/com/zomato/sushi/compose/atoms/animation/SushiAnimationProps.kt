package com.zomato.sushi.compose.atoms.animation

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * @author gupta.anirudh@zomato.com
 */
@Stable
data class SushiAnimationProps constructor(
    val source: SushiAnimationSource? = null,
    val playback: SushiAnimationPlayback? = null,
    val width: Dp? = null,
    val height: Dp? = null,
    val aspectRatio: Float? = null,
    val bgColor: ColorSpec = SushiUnspecified.asColorSpec()
)