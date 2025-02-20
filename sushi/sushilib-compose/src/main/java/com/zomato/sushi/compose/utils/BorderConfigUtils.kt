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
 * Created by Nitin Kumar on 18/01/25.
 * Zomato, Gurgaon, India.
 */

sealed class BorderConfig

data class DashedBorderConfig(
    val color: Color,
    val width: Dp,
    val dashWidth: Dp,
    val dashGap: Dp,
    val shape: Shape
) : BorderConfig()

fun Modifier.border(config: BorderConfig?): Modifier {
    config ?: return this
    return when (config) {
        is DashedBorderConfig -> {
            this.then(
                Modifier.dashedBorder(config)
            )
        }
    }
}

fun Modifier.dashedBorder(
    config: DashedBorderConfig? = null
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

        // Draw the border
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
