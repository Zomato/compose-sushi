package com.zomato.sushi.compose.atoms.text

import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.IconSizeSpec
import com.zomato.sushi.compose.atoms.icon.SushiIconCode
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * Properties for configuring continuous icons in Sushi components like [SushiText].
 *
 * @param code The [SushiIconCode] representing the icon to be displayed.
 * @param size The size of the icon.
 * @param color The color of the icon.
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class ContinuousIconProps(
    val code: SushiIconCode? = null,
    val size: IconSizeSpec? = null,
    val color: ColorSpec = SushiUnspecified.asColorSpec(),
)