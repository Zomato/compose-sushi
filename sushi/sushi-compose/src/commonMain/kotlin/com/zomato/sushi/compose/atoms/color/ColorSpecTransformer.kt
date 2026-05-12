package com.zomato.sushi.compose.atoms.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import kotlinx.collections.immutable.mutate

/**
 * A wrapper around a [ColorSpec] that applies a transformation function to the original color.
 * 
 * This class allows for modifying an existing [ColorSpec] by applying a transformation function
 * to its [Color] value while preserving the original specification. The transformation is applied
 * in the [value] getter, ensuring that changes to the original color are reflected in the
 * transformed color.
 *
 * @property original The original [ColorSpec] to transform
 * @property transform The function to apply to the original [Color]
 * 
 * @author gupta.anirudh@zomato.com
 */
@Stable
private data class ColorSpecTransformer(
    val original: ColorSpec,
    val transform: (Color) -> Color
) : ColorSpec {
    override val value: Color
        @Composable @Stable get() {
            if (original is SushiGradientColorSpec) {
                return original.transformGradientColorSpec(transform).value
            }
            val value = original.value
            return transform(value)
        }

    @Composable
    private fun SushiGradientColorSpec.transformGradientColorSpec(
        transform: (Color) -> Color
    ): SushiGradientColorSpec {
        return this.copy(
            colors = this.colors.mutate {
                for (i in it.indices) {
                    it[i] = transform(it[i].value).asColorSpec()
                }
            },
            themedPropsList = this.themedPropsList?.mutate {
                for (i in it.indices) {
                    it[i] = it[i].copy(
                        props = it[i].props.transformGradientColorSpec(transform)
                    )
                }
            }
        )
    }
}



/**
 * Extension function to transform a [ColorSpec] by applying a custom transformation
 * to its [Color] value.
 *
 * This is useful for making modifications to existing color specs without creating
 * completely new specs, such as adjusting alpha, saturation, or other color attributes.
 *
 * Example usage:
 * ```
 * val fadeColor = myColorSpec.transform { it.copy(alpha = 0.5f) }
 * ```
 *
 * @param transform The function to apply to the original [Color]
 * @return A new [ColorSpec] that applies the transformation to this spec's color
 */
fun ColorSpec.transform(transform: (Color) -> Color): ColorSpec {
    return ColorSpecTransformer(this, transform)
}