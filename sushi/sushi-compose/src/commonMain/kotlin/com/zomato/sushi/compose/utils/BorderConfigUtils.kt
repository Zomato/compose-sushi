package com.zomato.sushi.compose.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp

/**
 * Utility functions and classes for creating and applying custom border styles to composables.
 *
 * @author Nitin Kumar (18/01/25)
 */

/**
 * Base sealed class for different types of border configurations.
 * 
 * This class serves as the foundation for a type-safe way to define various border styles.
 * New border types can be added by extending this sealed class.
 */
sealed class BorderType

/**
 * Configuration for a dashed border style.
 * 
 * Defines all the visual properties needed to render a dashed border around a composable,
 * including color, width, dash pattern, and shape.
 *
 * @property color The color of the border
 * @property width The thickness of the border line
 * @property dashWidth The width of each dash in the pattern
 * @property dashGap The gap between each dash in the pattern
 * @property shape The shape to apply the border to (e.g., rectangle, rounded corner)
 */
data class DashedBorderType(
    val color: Color,
    val width: Dp,
    val dashWidth: Dp,
    val dashGap: Dp,
    val shape: Shape
) : BorderType()

/**
 * Applies a border to a composable based on the provided configuration.
 * 
 * This function serves as a dispatcher that routes to the appropriate border implementation
 * based on the type of BorderConfig provided. This allows for a consistent API while
 * supporting multiple border styles.
 *
 * @param config The border configuration to apply, or null for no border
 * @return A modifier with the specified border applied, or the original modifier if config is null
 */
fun Modifier.border(config: BorderType?): Modifier {
    config ?: return this
    return when (config) {
        is DashedBorderType -> {
            this.then(
                Modifier.dashedBorder(config)
            )
        }
    }
}

/**
 * Applies a dashed border to a composable with the specified configuration.
 * 
 * This function draws a dashed border that follows the outline of the specified shape.
 * It correctly handles different shape types (rectangle, rounded rectangle, or custom path)
 * to ensure the border properly follows the shape's edges.
 *
 * @param config The dashed border configuration, or null for no border
 * @return A modifier with the dashed border applied, or the original modifier if config is null
 */
fun Modifier.dashedBorder(
    config: DashedBorderType? = null
): Modifier {
    config ?: return this
    return this.then(Modifier.drawWithContent {
        drawContent() // Draw the original content first

        // Convert Dp values to Px
        val strokeWidthPx = config.width.toPx()
        val dashWidthPx = config.dashWidth.toPx()
        val dashGapPx = config.dashGap.toPx()

        // Path effect for dashed lines
        val pathEffect = PathEffect.dashPathEffect(
            floatArrayOf(dashWidthPx, dashGapPx), 0f // Phase (start offset)
        )

        // Get the shape outline
        val outline = config.shape.createOutline(
            size = size, layoutDirection = layoutDirection, density = this
        )

        // Draw the border based on the outline type
        when (outline) {
            is Outline.Rectangle -> {
                drawRect(
                    color = config.color,
                    topLeft = Offset.Zero,
                    size = size,
                    style = Stroke(width = strokeWidthPx, pathEffect = pathEffect)
                )
            }

            is Outline.Rounded -> {
                val radii = outline.roundRect.run {
                    CornerRadius(topLeftCornerRadius.x, topLeftCornerRadius.y)
                }
                drawRoundRect(
                    color = config.color,
                    topLeft = Offset.Zero,
                    size = size,
                    cornerRadius = radii,
                    style = Stroke(width = strokeWidthPx, pathEffect = pathEffect)
                )
            }

            is Outline.Generic -> {
                drawPath(
                    path = outline.path,
                    color = config.color,
                    style = Stroke(width = strokeWidthPx, pathEffect = pathEffect)
                )
            }
        }
    })
}
