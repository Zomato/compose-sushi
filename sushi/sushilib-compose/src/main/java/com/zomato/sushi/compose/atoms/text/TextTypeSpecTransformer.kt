@file:OptIn(ExperimentalSushiApi::class)
package com.zomato.sushi.compose.atoms.text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

private data class TextTypeSpecTransformer(
    val original: TextTypeSpec,
    val transform: (TextStyle) -> TextStyle
) : TextTypeSpec {

    override val typeStyle: TextStyle
        @Composable @Stable get() {
            val value = original.typeStyle
            return remember(value) { transform(value) }
        }
}

@ExperimentalSushiApi
fun TextTypeSpec.transform(transform: (TextStyle) -> TextStyle): TextTypeSpec {
    return TextTypeSpecTransformer(this, transform)
}