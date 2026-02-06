package com.zomato.sushi.compose

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @author gupta.anirudh@zomato.com
 *
 * A data class representing the corner configuration.
 *
 * @property topStart The corner radius for the top start corner
 * @property topEnd The corner radius for the top end corner
 * @property bottomEnd The corner radius for the bottom end corner
 * @property bottomStart The corner radius for the bottom start corner
 */
data class CornerConfig(
    val topStart: Dp? = null,
    val topEnd: Dp? = null,
    val bottomEnd: Dp? = null,
    val bottomStart: Dp? = null
)

/**
 * Converts a [CornerConfig] to a [RoundedCornerShape].
 *
 * @param defaultRadius The default radius to use if no corner radius is specified.
 *
 * @return A [RoundedCornerShape] based on the corner configuration.
 */
fun CornerConfig.toShape(defaultRadius: Dp = 0.dp): RoundedCornerShape {
    return RoundedCornerShape(
        topStart = this.topStart ?: defaultRadius,
        topEnd = this.topEnd ?: defaultRadius,
        bottomEnd = this.bottomEnd ?: defaultRadius,
        bottomStart = this.bottomStart ?: defaultRadius,
    )
}