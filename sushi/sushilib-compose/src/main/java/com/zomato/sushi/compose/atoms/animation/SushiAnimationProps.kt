package com.zomato.sushi.compose.atoms.animation

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * Properties for configuring a SushiAnimation component.
 * This class encapsulates all the parameters that can be used to customize
 * the appearance and behavior of a SushiAnimation.
 *
 * @property source The animation source to be displayed
 * @property playback The playback configuration controlling how the animation plays
 * @property width Optional explicit width for the animation
 * @property height Optional explicit height for the animation
 * @property aspectRatio Optional aspect ratio to maintain (width:height)
 * @property bgColor Background color for the animation container
 *
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