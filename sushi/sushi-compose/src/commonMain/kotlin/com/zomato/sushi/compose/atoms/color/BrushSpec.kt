package com.zomato.sushi.compose.atoms.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * A specification for accessing brush in the Sushi design system.
 *
 * This interface abstracts different ways of defining brush (gradient, etc.) and provides a uniform way to access the actual Brush value
 * through the 'brush' property.
 *
 * @author gupta.anirudh@zomato.com
 */
@Stable
sealed interface BrushSpec : ColorSpec {
    companion object

    /**
     * The actual Brush value represented by this specification.
     * This is a composable property as some brush specs might need to read from the theme
     * or other composable-scoped values.
     */
    @get:Composable @Stable
    val brush: Brush
}

/**
 * Converts a Compose [Brush] object to a [BrushSpec].
 *
 * @return A BrushSpec representing this Brush
 */
fun Brush.asBrushSpec(): BrushSpec = ComposeBrushSpec(this, Color.Transparent)