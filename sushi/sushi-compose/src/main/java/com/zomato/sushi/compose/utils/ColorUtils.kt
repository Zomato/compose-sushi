package com.zomato.sushi.compose.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.transform

/**
 * @author gupta.anirudh@zomato.com
 */

/**
 * Returns this color if it's specified (has a defined value), otherwise returns null.
 * 
 * This extension function is useful for filtering out unspecified/undefined colors
 * before using them in UI components.
 *
 * @return The original color if specified, or null otherwise
 */
fun Color.takeIfSpecified() = this.takeIf { it.isSpecified }

/**
 * Returns this ColorSpec if its value is specified, otherwise returns null.
 * 
 * This composable extension function is the ColorSpec equivalent of Color.takeIfSpecified(),
 * allowing for the same type of filtering with the more flexible ColorSpec type.
 *
 * @return The original ColorSpec if its value is specified, or null otherwise
 */
@Composable
inline fun ColorSpec.takeIfSpecified() = this.takeIf { it.value.isSpecified }

/**
 * Transforms this ColorSpec by replacing its color value with an alternative if it's unspecified.
 * 
 * This function is useful for providing fallback colors when a ColorSpec might contain
 * an unspecified value, ensuring components always have a valid color to work with.
 *
 * @param altColor A function that provides the alternative color to use if this ColorSpec is unspecified
 * @return A new ColorSpec with either the original specified color or the alternative
 */
inline fun ColorSpec.takeIfUnspecified(crossinline altColor: () -> Color) = this.transform {
    if (it.isSpecified) {
        it
    } else {
        altColor()
    }
}

inline fun ColorSpec?.takeIfNullOrUnspecified(crossinline altColor: () -> Color) = this?.transform {
    if (it.isSpecified) {
        it
    } else {
        altColor()
    }
} ?: altColor()