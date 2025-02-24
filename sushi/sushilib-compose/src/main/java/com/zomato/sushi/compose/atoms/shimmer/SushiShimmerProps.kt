package com.zomato.sushi.compose.atoms.shimmer

import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.atoms.color.ColorSpec

@Immutable
data class SushiShimmerProps(
    val bgColor: ColorSpec? = Default.bgColor,
    val animationColor: ColorSpec? = Default.animationColor,
    val animationWidth: Float? = Default.animationWidth,
    val angleOffset: Float? = Default.angleOffset,
    val animationDuration: Int? = Default.animationDuration,
    val animationDelay: Int? = Default.animationDelay
) {
    companion object {
        val Default = SushiShimmerProps(
            bgColor = null,
            animationColor = null,
            animationWidth = null,
            angleOffset = null,
            animationDuration = null,
            animationDelay = null
        )
    }
}
