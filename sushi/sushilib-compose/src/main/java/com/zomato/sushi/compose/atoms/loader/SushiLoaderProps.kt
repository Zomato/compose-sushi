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
    val innerAngleOffset: Float? = Default.innerAngleOffset,
    val outerColor: ColorSpec = Default.outerColor,
    val innerColor: ColorSpec = Default.innerColor,
    val animationSpeedMultiplier: Float? = Default.animationSpeedMultiplier
) {
    companion object {
        val Default = SushiLoaderProps(
            innerAngleOffset = null,
            outerColor = SushiUnspecified.asColorSpec(),
            innerColor = SushiUnspecified.asColorSpec(),
            animationSpeedMultiplier = null
        )
    }
}