@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

@ExperimentalSushiApi
sealed interface ColorSpec {
    companion object

    @get:Composable @Stable
    val value: Color
}

internal fun ColorSpec.Companion.fromColor(color: Color): ColorSpec = ComposeColorSpec(color)
internal fun ColorSpec.Companion.fromColorInt(color: Long): ColorSpec = IntColorSpec(color)
internal fun ColorSpec.Companion.fromHexCode(hexCode: String): ColorSpec = HexColorSpec(hexCode)

fun Color.asColorSpec(): ColorSpec = ComposeColorSpec(this)

fun ColorSpec.withAlpha(alpha: Float) = this.transform { it.copy(alpha = alpha) }