package com.zomato.sushi.compose.atoms.text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle

/**
 * A wrapper around [TextTypeSpec] that applies a transformation function to the original text style.
 *
 * This class allows for modifying an existing [TextTypeSpec] by applying a transformation function
 * to its [TextStyle] while preserving the original specification. The transformation is applied
 * in the [typeStyle] getter, ensuring that changes to the original style are reflected in the
 * transformed style.
 *
 * @property original The original [TextTypeSpec] to transform
 * @property transform The function to apply to the original [TextStyle]
 */
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

/**
 * Extension function to transform a [TextTypeSpec] by applying a custom transformation
 * to its [TextStyle].
 *
 * This is useful for making small modifications to existing text styles without creating
 * completely new styles, such as changing the font size, color, or other attributes.
 *
 * Example usage:
 * ```
 * val modifiedType = SushiTextType.Regular400.transform { style ->
 *    style.copy(fontSize = 18.sp, letterSpacing = 0.5.sp)
 * }
 * @param transform The function to apply to the original [TextStyle]
 * @return A new [TextTypeSpec] that applies the transformation to this spec's style
 */
fun TextTypeSpec.transform(transform: (TextStyle) -> TextStyle): TextTypeSpec {
    return TextTypeSpecTransformer(this, transform)
}