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
@Stable
sealed interface ColorSpec {
    companion object

    @get:Composable @Stable
    val value: Color
}

fun Color.asColorSpec(): ColorSpec = ComposeColorSpec(this)
fun Int.asIntColorSpec(): ColorSpec = IntColorSpec(this.toLong())
fun Long.asIntColorSpec(): ColorSpec = IntColorSpec(this)
fun String.asHexColorSpec(): ColorSpec = HexColorSpec(this)

/**
 * Alpha value between 0..1
 */
fun ColorSpec.withAlpha(alpha: Float) = this.transform { it.copy(alpha = alpha) }