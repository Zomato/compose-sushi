package com.zomato.sushi.compose.atoms.border

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.SushiGradientColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.color.toBrush
import com.zomato.sushi.compose.atoms.color.asSushiGradientColorSpec
import com.zomato.sushi.compose.internal.SushiPreview
import kotlinx.collections.immutable.persistentListOf

/**
 * A specification for defining border in the Sushi design system.
 *
 * @property width The width of the border
 * @property color The color of the border
 * @property borderType The type of border (e.g., solid, dashed)
 * @property borderSides The specific sides of the border to apply (only when provided [shape] is a [RoundedCornerShape])
 * @property shape The shape of the border (e.g., rounded, non-rounded)
 *
 * @author gupta.anirudh@zomato.com
 */
data class BorderSpec(
    val width: Dp? = null,
    val color: SushiGradientColorSpec? = null,
    val borderType: BorderType? = null,
    val borderSides: BorderSides? = null,
    val shape: Shape? = null
)

/**
 * Base sealed class for different types of border configurations.
 *
 * This class serves as the foundation for a type-safe way to define various border styles.
 * New border types can be added by extending this sealed class.
 */
sealed class BorderType {

    /**
     * Configuration for a solid border style.
     */
    data object Solid : BorderType()

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

/**
 * A data class representing the sides of a border.
 *
 * @property left Whether the border should be drawn on the left side
 * @property top Whether the border should be drawn on the top side
 * @property right Whether the border should be drawn on the right side
 * @property bottom Whether the border should be drawn on the bottom side
 *
 * @author gupta.anirudh@zomato.com
 */
data class BorderSides(
    val left: Boolean = true,
    val top: Boolean = true,
    val right: Boolean = true,
    val bottom: Boolean = true
) {
    val isAll: Boolean
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
        BorderType.Solid -> {
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
    val sides = border.borderSides ?: BorderSides()
    val shape = border.shape ?: RoundedCornerShape(0.dp)

    if (shape !is RoundedCornerShape) {
        return this.border(
            width = border.width ?: 0.dp,
            brush = borderColor,
            shape = shape
        )
    }

    if (sides.isAll) {
        return this.border(
            width = border.width ?: 0.dp,
            brush = borderColor,
            shape = shape
        )
    }

    return this.drawWithContent {
        drawContent()

        val strokeWidth = border.width?.toPx() ?: 0f
        val halfStroke = strokeWidth / 2f
        val radiusTopStartPx = shape.topStart.toPx(size, this)
        val radiusTopEndPx = shape.topEnd.toPx(size, this)
        val radiusBottomEndPx = shape.bottomEnd.toPx(size, this)
        val radiusBottomStartPx = shape.bottomStart.toPx(size, this)

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

    val borderBrush = border.color?.toBrush() ?: return this
    val sides = border.borderSides ?: BorderSides()
    val shape = border.shape ?: RoundedCornerShape(0.dp)

    // Check if we need to render only specific sides
    val needsSpecificSides = !sides.isAll
    val isRoundedCorner = shape is RoundedCornerShape

    // If we need specific sides and have RoundedCornerShape, use custom drawing
    if (needsSpecificSides && isRoundedCorner) {
        return this.drawWithContent {
            drawContent()

            val strokeWidthPx = border.width?.toPx() ?: 0f
            if (strokeWidthPx <= 0f) return@drawWithContent

            val dashWidthPx = border.borderType.dashWidth.toPx()
            val dashGapPx = border.borderType.dashGap.toPx()
            val pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(dashWidthPx, dashGapPx), 0f
            )

            val halfStroke = strokeWidthPx / 2f
            val radiusTopStartPx = shape.topStart.toPx(size, this)
            val radiusTopEndPx = shape.topEnd.toPx(size, this)
            val radiusBottomEndPx = shape.bottomEnd.toPx(size, this)
            val radiusBottomStartPx = shape.bottomStart.toPx(size, this)

            // left border
            if (sides.left) {
                val startY = if (sides.top && radiusTopStartPx > 0f) radiusTopStartPx else 0f
                val endY = if (sides.bottom && radiusBottomStartPx > 0f) {
                    size.height - radiusBottomStartPx
                } else {
                    size.height
                }
                drawLine(
                    brush = borderBrush,
                    start = Offset(halfStroke, startY),
                    end = Offset(halfStroke, endY),
                    strokeWidth = strokeWidthPx,
                    pathEffect = pathEffect
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
                    brush = borderBrush,
                    start = Offset(startX, halfStroke),
                    end = Offset(endX, halfStroke),
                    strokeWidth = strokeWidthPx,
                    pathEffect = pathEffect
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
                    brush = borderBrush,
                    start = Offset(size.width - halfStroke, startY),
                    end = Offset(size.width - halfStroke, endY),
                    strokeWidth = strokeWidthPx,
                    pathEffect = pathEffect
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
                    brush = borderBrush,
                    start = Offset(startX, size.height - halfStroke),
                    end = Offset(endX, size.height - halfStroke),
                    strokeWidth = strokeWidthPx,
                    pathEffect = pathEffect
                )
            }

            // top-left corner arc
            if (radiusTopStartPx > 0f && sides.top && sides.left) {
                val arcSize = Size(
                    radiusTopStartPx * 2 - strokeWidthPx,
                    radiusTopStartPx * 2 - strokeWidthPx
                )
                drawArc(
                    brush = borderBrush,
                    startAngle = 180f,
                    sweepAngle = 90f,
                    useCenter = false,
                    topLeft = Offset(halfStroke, halfStroke),
                    size = arcSize,
                    style = Stroke(width = strokeWidthPx, pathEffect = pathEffect)
                )
            }

            // top-right corner arc
            if (radiusTopEndPx > 0f && sides.top && sides.right) {
                val arcSize = Size(
                    radiusTopEndPx * 2 - strokeWidthPx,
                    radiusTopEndPx * 2 - strokeWidthPx
                )
                drawArc(
                    brush = borderBrush,
                    startAngle = 270f,
                    sweepAngle = 90f,
                    useCenter = false,
                    topLeft = Offset(
                        size.width - radiusTopEndPx * 2 + halfStroke,
                        halfStroke
                    ),
                    size = arcSize,
                    style = Stroke(width = strokeWidthPx, pathEffect = pathEffect)
                )
            }

            // bottom-right corner arc
            if (radiusBottomEndPx > 0f && sides.bottom && sides.right) {
                val arcSize = Size(
                    radiusBottomEndPx * 2 - strokeWidthPx,
                    radiusBottomEndPx * 2 - strokeWidthPx
                )
                drawArc(
                    brush = borderBrush,
                    startAngle = 0f,
                    sweepAngle = 90f,
                    useCenter = false,
                    topLeft = Offset(
                        size.width - radiusBottomEndPx * 2 + halfStroke,
                        size.height - radiusBottomEndPx * 2 + halfStroke
                    ),
                    size = arcSize,
                    style = Stroke(width = strokeWidthPx, pathEffect = pathEffect)
                )
            }

            // bottom-left corner arc
            if (radiusBottomStartPx > 0f && sides.bottom && sides.left) {
                val arcSize = Size(
                    radiusBottomStartPx * 2 - strokeWidthPx,
                    radiusBottomStartPx * 2 - strokeWidthPx
                )
                drawArc(
                    brush = borderBrush,
                    startAngle = 90f,
                    sweepAngle = 90f,
                    useCenter = false,
                    topLeft = Offset(
                        halfStroke,
                        size.height - radiusBottomStartPx * 2 + halfStroke
                    ),
                    size = arcSize,
                    style = Stroke(width = strokeWidthPx, pathEffect = pathEffect)
                )
            }
        }
    }

    // If we need specific sides but shape is not RoundedCornerShape, use line-based drawing
    if (needsSpecificSides && !isRoundedCorner) {
        return this.drawWithContent {
            drawContent()

            val strokeWidthPx = border.width?.toPx() ?: 0f
            if (strokeWidthPx <= 0f) return@drawWithContent

            val dashWidthPx = border.borderType.dashWidth.toPx()
            val dashGapPx = border.borderType.dashGap.toPx()
            val pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(dashWidthPx, dashGapPx), 0f
            )

            val halfStroke = strokeWidthPx / 2f

            // left border
            if (sides.left) {
                drawLine(
                    brush = borderBrush,
                    start = Offset(halfStroke, 0f),
                    end = Offset(halfStroke, size.height),
                    strokeWidth = strokeWidthPx,
                    pathEffect = pathEffect
                )
            }

            // top border
            if (sides.top) {
                drawLine(
                    brush = borderBrush,
                    start = Offset(0f, halfStroke),
                    end = Offset(size.width, halfStroke),
                    strokeWidth = strokeWidthPx,
                    pathEffect = pathEffect
                )
            }

            // right border
            if (sides.right) {
                drawLine(
                    brush = borderBrush,
                    start = Offset(size.width - halfStroke, 0f),
                    end = Offset(size.width - halfStroke, size.height),
                    strokeWidth = strokeWidthPx,
                    pathEffect = pathEffect
                )
            }

            // bottom border
            if (sides.bottom) {
                drawLine(
                    brush = borderBrush,
                    start = Offset(0f, size.height - halfStroke),
                    end = Offset(size.width, size.height - halfStroke),
                    strokeWidth = strokeWidthPx,
                    pathEffect = pathEffect
                )
            }
        }
    }

    // Default case: draw all sides using shape outline
    return this.then(Modifier.drawWithContent {
        drawContent()

        val strokeWidthPx = border.width?.toPx() ?: 0f
        if (strokeWidthPx <= 0f) return@drawWithContent

        val dashWidthPx = border.borderType.dashWidth.toPx()
        val dashGapPx = border.borderType.dashGap.toPx()

        val pathEffect = PathEffect.dashPathEffect(
            floatArrayOf(dashWidthPx, dashGapPx), 0f
        )

        val outline = shape.createOutline(
            size = size, layoutDirection = layoutDirection, density = this
        )

        when (outline) {
            is Outline.Rectangle -> {
            drawRect(
                brush = borderBrush,
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
                    brush = borderBrush,
                    topLeft = Offset.Zero,
                    size = size,
                    cornerRadius = radii,
                    style = Stroke(width = strokeWidthPx, pathEffect = pathEffect)
                )
            }

            is Outline.Generic -> {
                drawPath(
                    path = outline.path,
                    brush = borderBrush,
                    style = Stroke(width = strokeWidthPx, pathEffect = pathEffect)
                )
            }
        }
    })
}

@Composable
@SushiPreview
private fun BorderSpecPreview1() {
    SushiPreview {
        Box(
            Modifier
                .padding(12.dp)
                .border(
                    BorderSpec(
                        width = 2.dp,
                        color = Color.Red.asSushiGradientColorSpec(),
                        borderType = BorderType.DashedBorderType(
                            dashWidth = 4.dp,
                            dashGap = 4.dp
                        ),
                        shape = RoundedCornerShape(20.dp)
                    )
                )
                .size(100.dp)
        )
    }
}

@Composable
@SushiPreview
private fun BorderSpecPreview2() {
    SushiPreview {
        Box(
            Modifier
                .padding(12.dp)
                .border(
                    BorderSpec(
                        width = 2.dp,
                        color = Color.Red.asSushiGradientColorSpec(),
                        borderType = BorderType.Solid,
                        shape = RoundedCornerShape(20.dp)
                    )
                )
                .size(100.dp)
        )
    }
}

@Composable
@SushiPreview
private fun BorderSpecPreview3() {
    SushiPreview {
        Box(
            Modifier
                .padding(12.dp)
                .border(
                    BorderSpec(
                        width = 2.dp,
                        color = Color.Red.asSushiGradientColorSpec(),
                        borderType = BorderType.Solid,
                        shape = RoundedCornerShape(20.dp),
                        borderSides = BorderSides(
                            bottom = false
                        )
                    )
                )
                .size(100.dp)
        )
    }
}

@Composable
@SushiPreview
private fun BorderSpecPreview4() {
    SushiPreview {
        Box(
            Modifier
                .padding(12.dp)
                .border(
                    BorderSpec(
                        width = 2.dp,
                        color = Color.Red.asSushiGradientColorSpec(),
                        borderType = BorderType.Solid,
                        shape = RoundedCornerShape(20.dp),
                        borderSides = BorderSides(
                            bottom = false,
                            right = false
                        )
                    )
                )
                .size(100.dp)
        )
    }
}

@Composable
@SushiPreview
private fun BorderSpecPreview5() {
    // Dashed border with gradient color
    SushiPreview {
        Box(
            Modifier
                .padding(12.dp)
                .border(
                    BorderSpec(
                        width = 2.dp,
                        color = SushiGradientColorSpec(
                            colors = persistentListOf(
                                Color.Blue.asColorSpec(),
                                Color.Red.asColorSpec(),
                                Color.Green.asColorSpec()
                            )
                        ),
                        borderType = BorderType.DashedBorderType(
                            dashWidth = 8.dp,
                            dashGap = 4.dp
                        ),
                        shape = RoundedCornerShape(20.dp)
                    )
                )
                .size(100.dp)
        )
    }
}

@Composable
@SushiPreview
private fun BorderSpecPreview6() {
    // Dashed border with border sides
    SushiPreview {
        Box(
            Modifier
                .padding(12.dp)
                .border(
                    BorderSpec(
                        width = 2.dp,
                        color = Color.Blue.asSushiGradientColorSpec(),
                        borderType = BorderType.DashedBorderType(
                            dashWidth = 6.dp,
                            dashGap = 3.dp
                        ),
                        shape = RoundedCornerShape(12.dp),
                        borderSides = BorderSides(
                            bottom = false,
                            right = false
                        )
                    )
                )
                .size(100.dp)
        )
    }
}

@Composable
@SushiPreview
private fun BorderSpecPreview7() {
    // Dashed border with border sides and gradient
    SushiPreview {
        Box(
            Modifier
                .padding(12.dp)
                .border(
                    BorderSpec(
                        width = 2.dp,
                        color = SushiGradientColorSpec(
                            colors = persistentListOf(
                                Color.Blue.asColorSpec(),
                                Color.Red.asColorSpec(),
                                Color.Green.asColorSpec()
                            )
                        ),
                        borderType = BorderType.DashedBorderType(
                            dashWidth = 6.dp,
                            dashGap = 3.dp
                        ),
                        shape = RoundedCornerShape(12.dp),
                        borderSides = BorderSides(
                            bottom = false,
                            right = false
                        )
                    )
                )
                .size(100.dp)
        )
    }
}

@Composable
@SushiPreview
private fun BorderSpecPreview8() {
    // Normal border with non-RoundedCornerShape and specific sides
    SushiPreview {
        Box(
            Modifier
                .padding(12.dp)
                .border(
                    BorderSpec(
                        width = 2.dp,
                        color = Color.Green.asSushiGradientColorSpec(),
                        borderType = BorderType.Solid,
                        borderSides = BorderSides(
                            left = false,
                            top = false
                        )
                    )
                )
                .size(100.dp)
        )
    }
}

@Composable
@SushiPreview
private fun BorderSpecPreview9() {
    // Dashed border with non-RoundedCornerShape and specific sides
    SushiPreview {
        Box(
            Modifier
                .padding(12.dp)
                .border(
                    BorderSpec(
                        width = 2.dp,
                        color = Color.Magenta.asSushiGradientColorSpec(),
                        borderType = BorderType.DashedBorderType(
                            dashWidth = 8.dp,
                            dashGap = 6.dp
                        ),
                        borderSides = BorderSides(
                            top = false,
                            bottom = false
                        )
                    )
                )
                .size(100.dp)
        )
    }
}