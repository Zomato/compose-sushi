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


operator fun CornerConfig?.plus(other: CornerConfig): CornerConfig {
    return CornerConfig(
        topStart = (this?.topStart ?: 0.dp) + (other.topStart ?: 0.dp),
        topEnd = (this?.topEnd ?: 0.dp) + (other.topEnd ?: 0.dp),
        bottomEnd = (this?.bottomEnd ?: 0.dp) + (other.bottomEnd ?: 0.dp),
        bottomStart = (this?.bottomStart ?: 0.dp) + (other.bottomStart ?: 0.dp),
    )
}

operator fun CornerConfig?.plus(other: Dp): CornerConfig {
    return CornerConfig(
        topStart = (this?.topStart ?: 0.dp) + other,
        topEnd = (this?.topEnd ?: 0.dp) + other,
        bottomEnd = (this?.bottomEnd ?: 0.dp) + other,
        bottomStart = (this?.bottomStart ?: 0.dp) + other,
    )
}

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