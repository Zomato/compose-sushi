@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

/**
 * @author gupta.anirudh@zomato.com
 */
private data class ColorSpecTransformer(
    val original: ColorSpec,
    val transform: (Color) -> Color
) : ColorSpec {
    override val value: Color
        @Composable @Stable get() {
            val value = original.value
            return remember(value) { transform(value) }
        }
}

@ExperimentalSushiApi
fun ColorSpec.transform(transform: (Color) -> Color): ColorSpec {
    return ColorSpecTransformer(this, transform)
}