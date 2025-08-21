package com.zomato.sushi.compose.atoms.loader

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * Properties for configuring a SushiLoader component.
 *
 * SushiLoader is a animated loading indicator that consists of two concentric arcs
 * rotating at different angles to create a visually appealing loading animation.
 * These properties allow customization of its appearance and animation behavior.
 *
 * @property innerAngleOffset The angular offset between the inner and outer arcs in degrees
 * @property outerColor The color of the outer arc
 * @property innerColor The color of the inner arc
 * @property animationSpeedMultiplier Factor that controls animation speed (higher values = faster)
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiLoaderProps(
    val innerAngleOffset: Float? = null,
    val outerColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val innerColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val animationSpeedMultiplier: Float? = null
)