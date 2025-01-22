package com.zomato.sushi.compose.atoms.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

/**
 * @author gupta.anirudh@zomato.com
 */
@Stable
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

fun ColorSpec.transform(transform: (Color) -> Color): ColorSpec {
    return ColorSpecTransformer(this, transform)
}