package com.zomato.sushi.compose.atoms.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

/**
 * A specification for accessing colors in the Sushi design system.
 * 
 * This interface abstracts different ways of defining colors (hex strings, color resources, 
 * theme references, etc.) and provides a uniform way to access the actual Color value
 * through the 'value' property.
 *
 * @author gupta.anirudh@zomato.com
 */
@Stable
sealed interface ColorSpec {
    companion object

    /**
     * The actual Color value represented by this specification.
     * This is a composable property as some color specs might need to read from the theme
     * or other composable-scoped values.
     */
    @get:Composable @Stable
    val value: Color
}

/**
 * Converts a Compose [Color] object to a [ColorSpec].
 *
 * @return A ColorSpec representing this Color
 */
fun Color.asColorSpec(): ColorSpec = ComposeColorSpec(this)

/**
 * Converts an Int color value (ARGB format) to a [ColorSpec].
 *
 * @return A ColorSpec representing this color integer
 */
fun Int.asIntColorSpec(): ColorSpec = IntColorSpec(this.toLong())

/**
 * Converts a Long color value (ARGB format) to a [ColorSpec].
 *
 * @return A ColorSpec representing this color long
 */
fun Long.asIntColorSpec(): ColorSpec = IntColorSpec(this)

/**
 * Converts a hex color string (e.g. "#FF0000" for red) to a [ColorSpec].
 *
 * @return A ColorSpec representing this hex color string
 */
fun String.asHexColorSpec(): ColorSpec = HexColorSpec(this)

/**
 * Creates a new ColorSpec with the specified alpha (transparency) value.
 *
 * @param alpha Alpha value between 0.0 (fully transparent) and 1.0 (fully opaque)
 * @return A new ColorSpec with the specified alpha applied
 */
fun ColorSpec.withAlpha(alpha: Float) = this.transform { it.copy(alpha = alpha) }