package com.zomato.sushi.compose.atoms.loader

import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiLoaderProps(
    val innerAngleOffset: Float? = null,
    val outerColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val innerColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val animationSpeedMultiplier: Float? = null
)