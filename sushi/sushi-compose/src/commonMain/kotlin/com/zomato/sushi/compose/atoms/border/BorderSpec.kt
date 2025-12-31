package com.zomato.sushi.compose.atoms.border

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.SushiGradientColorSpec
import com.zomato.sushi.compose.atoms.color.toBrush
import com.zomato.sushi.compose.utils.takeIfSpecified

/**
 * @param borderSides border sides makes sense only if provided [shape] is a [RoundedCornerShape]
 */
data class BorderSpec(
    val width: Dp? = null,
    val color: SushiGradientColorSpec? = null,
    val borderType: BorderType? = null,
    val borderSides: BorderSides? = BorderSides(),
    val shape: Shape? = null,
    val radius: Dp? = null
)

/**
 * Base sealed class for different types of border configurations.
 *
 * This class serves as the foundation for a type-safe way to define various border styles.
 * New border types can be added by extending this sealed class.
 */
sealed class BorderType {

    data object Normal : BorderType()
    /**
     * Configuration for a dashed border style.
     *
     * Defines all the visual properties needed to render a dashed border around a composable,
     * including color, width, dash pattern, and shape.
     *
     * @property dashWidth The width of each dash in the pattern
     * @property dashGap The gap between each dash in the pattern
     */
    data class DashedBorderType(
        val dashWidth: Dp = 4.dp,
        val dashGap: Dp = 4.dp
    ) : BorderType()
}

data class BorderSides(
    val left: Boolean = true,
    val top: Boolean = true,
    val right: Boolean = true,
    val bottom: Boolean = true
) {
    val isAllSides: Boolean
        get() = left && top && right && bottom
}

/**
 * Applies a border to a composable based on the provided configuration.
 * This allows for a consistent API while supporting multiple border styles.
 *
 * @param border The border spec to apply, or null for no border
 * @return A modifier with the specified border applied, or the original modifier if [border] is null
 */
@Composable
fun Modifier.border(border: BorderSpec?): Modifier {
    if (border == null) return this
    return when (border.borderType) {
        is BorderType.DashedBorderType -> {
            this.dashedBorder(border)
        }
        BorderType.Normal -> {
            this.normalBorder(border)
        }
        else -> {
            this.normalBorder(border)
        }
    }
}

@Composable
private fun Modifier.normalBorder(border: BorderSpec): Modifier {
    val borderColor = border.color?.toBrush() ?: return this
    val sides = border.borderSides ?: return this

    if (border.shape !is RoundedCornerShape) {
        return this.border(
            width = border.width ?: 0.dp,
            brush = borderColor,
            shape = border.shape ?: RoundedCornerShape(0.dp)
        )
    }

    if (border.borderSides.isAllSides) {
        return this.border(
            width = border.width ?: 0.dp,
            brush = borderColor,
            shape = border.shape
        )
    }

    return this.drawWithContent {
        drawContent()

        val strokeWidth = border.width?.toPx() ?: 0f
        val halfStroke = strokeWidth / 2f
        val radiusTopStartPx = border.shape.topStart.toPx(size, this)
        val radiusTopEndPx = border.shape.topEnd.toPx(size, this)
        val radiusBottomEndPx = border.shape.bottomEnd.toPx(size, this)
        val radiusBottomStartPx = border.shape.bottomStart.toPx(size, this)

        // left border
        if (sides.left) {
            val startY = if (sides.top && radiusTopStartPx > 0f) radiusTopStartPx else 0f
            val endY = if (sides.bottom && radiusBottomStartPx > 0f) {
                size.height - radiusBottomStartPx
            } else {
                size.height
            }
            drawLine(
                brush = borderColor,
                start = Offset(halfStroke, startY),
                end = Offset(halfStroke, endY),
                strokeWidth = strokeWidth
            )
        }

        // top border
        if (sides.top) {
            val startX = if (sides.left && radiusTopStartPx > 0f) radiusTopStartPx else 0f
            val endX = if (sides.right && radiusTopEndPx > 0f) {
                size.width - radiusTopEndPx
            } else {
                size.width
            }
            drawLine(
                brush = borderColor,
                start = Offset(startX, halfStroke),
                end = Offset(endX, halfStroke),
                strokeWidth = strokeWidth
            )
        }

        // right border
        if (sides.right) {
            val startY = if (sides.top && radiusTopEndPx > 0f) radiusTopEndPx else 0f
            val endY = if (sides.bottom && radiusBottomEndPx > 0f) {
                size.height - radiusBottomEndPx
            } else {
                size.height
            }
            drawLine(
                brush = borderColor,
                start = Offset(size.width - halfStroke, startY),
                end = Offset(size.width - halfStroke, endY),
                strokeWidth = strokeWidth
            )
        }

        // bottom border
        if (sides.bottom) {
            val startX = if (sides.left && radiusBottomStartPx > 0f) radiusBottomStartPx else 0f
            val endX = if (sides.right && radiusBottomEndPx > 0f) {
                size.width - radiusBottomEndPx
            } else {
                size.width
            }
            drawLine(
                brush = borderColor,
                start = Offset(startX, size.height - halfStroke),
                end = Offset(endX, size.height - halfStroke),
                strokeWidth = strokeWidth
            )
        }

        // top-left corner arc
        if (radiusTopStartPx > 0f && sides.top && sides.left) {
            val arcSize = Size(
                radiusTopStartPx * 2 - strokeWidth,
                radiusTopStartPx * 2 - strokeWidth
            )
            drawArc(
                brush = borderColor,
                startAngle = 180f,
                sweepAngle = 90f,
                useCenter = false,
                topLeft = Offset(halfStroke, halfStroke),
                size = arcSize,
                style = Stroke(width = strokeWidth)
            )
        }

        // top-right corner arc
        if (radiusTopEndPx > 0f && sides.top && sides.right) {
            val arcSize = Size(
                radiusTopEndPx * 2 - strokeWidth,
                radiusTopEndPx * 2 - strokeWidth
            )
            drawArc(
                brush = borderColor,
                startAngle = 270f,
                sweepAngle = 90f,
                useCenter = false,
                topLeft = Offset(
                    size.width - radiusTopEndPx * 2 + halfStroke,
                    halfStroke
                ),
                size = arcSize,
                style = Stroke(width = strokeWidth)
            )
        }

        // bottom-right corner arc
        if (radiusBottomEndPx > 0f && sides.bottom && sides.right) {
            val arcSize = Size(
                radiusBottomEndPx * 2 - strokeWidth,
                radiusBottomEndPx * 2 - strokeWidth
            )
            drawArc(
                brush = borderColor,
                startAngle = 0f,
                sweepAngle = 90f,
                useCenter = false,
                topLeft = Offset(
                    size.width - radiusBottomEndPx * 2 + halfStroke,
                    size.height - radiusBottomEndPx * 2 + halfStroke
                ),
                size = arcSize,
                style = Stroke(width = strokeWidth)
            )
        }

        // bottom-left corner arc
        if (radiusBottomStartPx > 0f && sides.bottom && sides.left) {
            val arcSize = Size(
                radiusBottomStartPx * 2 - strokeWidth,
                radiusBottomStartPx * 2 - strokeWidth
            )
            drawArc(
                brush = borderColor,
                startAngle = 90f,
                sweepAngle = 90f,
                useCenter = false,
                topLeft = Offset(
                    halfStroke,
                    size.height - radiusBottomStartPx * 2 + halfStroke
                ),
                size = arcSize,
                style = Stroke(width = strokeWidth)
            )
        }
    }
}

@Composable
private fun Modifier.dashedBorder(
    border: BorderSpec,
): Modifier {
    if (border.borderType !is BorderType.DashedBorderType) {
        return this
    }

    val color = border.color?.colors?.getOrNull(0)?.value?.takeIfSpecified()

    return this.then(Modifier.drawWithContent {
        drawContent() // Draw the original content first

        // Convert Dp values to Px
        val strokeWidthPx = border.width?.toPx() ?: 0f
        val dashWidthPx = border.borderType.dashWidth.toPx()
        val dashGapPx = border.borderType.dashGap.toPx()

        // Path effect for dashed lines
        val pathEffect = PathEffect.dashPathEffect(
            floatArrayOf(dashWidthPx, dashGapPx), 0f // Phase (start offset)
        )

        // Get the shape outline
        val outline = border.shape?.createOutline(
            size = size, layoutDirection = layoutDirection, density = this
        )

        // Draw the border based on the outline type
        when (outline) {
            is Outline.Rectangle -> {
                color?.let {
                    drawRect(
                        color = color,
                        topLeft = Offset.Zero,
                        size = size,
                        style = Stroke(width = strokeWidthPx, pathEffect = pathEffect)
                    )
                    drawRect(
                        color = color,
                        topLeft = Offset.Zero,
                        size = size,
                        style = Stroke(width = strokeWidthPx, pathEffect = pathEffect)
                    )
                }
            }

            is Outline.Rounded -> {
                val radii = outline.roundRect.run {
                    CornerRadius(topLeftCornerRadius.x, topLeftCornerRadius.y)
                }
                color?.let {
                    drawRoundRect(
                        color = color,
                        topLeft = Offset.Zero,
                        size = size,
                        cornerRadius = radii,
                        style = Stroke(width = strokeWidthPx, pathEffect = pathEffect)
                    )
                }
            }

            is Outline.Generic -> {
                color?.let {
                    drawPath(
                        path = outline.path,
                        color = color,
                        style = Stroke(width = strokeWidthPx, pathEffect = pathEffect)
                    )
                }
            }

            else -> {

            }
        }
    })
}
