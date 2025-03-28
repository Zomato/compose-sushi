package com.zomato.sushi.compose.atoms.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

/**
 * @author gupta.anirudh@zomato.com
 */
@Stable
internal data class IntColorSpec(
    val colorCode: Long
) : ColorSpec {
    private val _color = Color(colorCode)
    override val value: Color
        @Composable @Stable get() = _color
}
