@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
internal data class IntColorSpec(
    val colorCode: Long
) : ColorSpec {
    private val _color = Color(colorCode)
    override val value: Color
        @Composable @Stable get() = _color
}
