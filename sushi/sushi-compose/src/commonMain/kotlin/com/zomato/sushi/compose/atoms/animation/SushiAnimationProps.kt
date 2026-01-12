package com.zomato.sushi.compose.atoms.animation

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec

/**
 * Properties for configuring a SushiAnimation component.
 * This class encapsulates all the parameters that can be used to customize
 * the appearance and behavior of a SushiAnimation.
 *
 * @property source The animation source to be displayed
 * @property playback The playback configuration controlling how the animation plays
 * @property width Optional explicit width for the animation
 * @property height Optional explicit height for the animation
 * @property shape The shape to clip the animation to (e.g., RoundedCornerShape)
 * @property contentDescription Accessibility description of the animation for screen readers
 * @property aspectRatio Optional aspect ratio to maintain (width:height)
 * @property bgColor Background color for the animation container
 * @property alpha Opacity level from 0.0 (transparent) to 1.0 (opaque)
 * @property scaleFactor Additional scaling factor applied to the animation
 *
 * @author gupta.anirudh@zomato.com
 */
@Stable
data class SushiAnimationProps constructor(
    val source: SushiAnimationSource? = null,
    val playback: SushiAnimationPlayback? = null,
    val width: Dp? = null,
    val height: Dp? = null,
    val shape: Shape? = null,
    val contentDescription: String? = null,
    val aspectRatio: Float? = null,
    val bgColor: ColorSpec? = null,
    val alpha: Float? = null,
    val scaleFactor: Float? = null,
    val contentScale: ContentScale? = null
)