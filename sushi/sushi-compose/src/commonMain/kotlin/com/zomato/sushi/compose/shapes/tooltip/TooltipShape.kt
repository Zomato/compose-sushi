package com.zomato.sushi.compose.shapes.tooltip

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview

/**
 * The position of the pointer relative to the tooltip.
 */
enum class TooltipPointerPosition {
    Top,
    Bottom,
    Left,
    Right
}

/**
 * A shape that draws a tooltip with rounded corners and a triangular pointer.
 *
 * @param topStart the corner size for the top start corner
 * @param topEnd the corner size for the top end corner
 * @param bottomEnd the corner size for the bottom end corner
 * @param bottomStart the corner size for the bottom start corner
 * @param pointerWidth the width of the triangular pointer
 * @param pointerHeight the height of the triangular pointer
 * @param pointerPosition the position of the pointer (Top, Bottom, Left, Right)
 * @param pointerBias the position bias of the pointer along the edge (0.0 = start, 0.5 = center, 1.0 = end)
 */
class TooltipShape(
    val topStart: CornerSize,
    val topEnd: CornerSize,
    val bottomEnd: CornerSize,
    val bottomStart: CornerSize,
    val pointerWidth: Dp = 24.dp,
    val pointerHeight: Dp = 12.dp,
    val pointerPosition: TooltipPointerPosition = TooltipPointerPosition.Bottom,
    val pointerBias: Float = 0.5f
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        var topStart = topStart.toPx(size, density)
        var topEnd = topEnd.toPx(size, density)
        var bottomEnd = bottomEnd.toPx(size, density)
        var bottomStart = bottomStart.toPx(size, density)
        val minDimension = size.minDimension
        if (topStart + bottomStart > minDimension) {
            val scale = minDimension / (topStart + bottomStart)
            topStart *= scale
            bottomStart *= scale
        }
        if (topEnd + bottomEnd > minDimension) {
            val scale = minDimension / (topEnd + bottomEnd)
            topEnd *= scale
            bottomEnd *= scale
        }
        require(
            topStart >= 0.0f && topEnd >= 0.0f && bottomEnd >= 0.0f && bottomStart >= 0.0f
        ) {
            "Corner size in Px can't be negative(topStart = $topStart, topEnd = $topEnd, " +
                    "bottomEnd = $bottomEnd, bottomStart = $bottomStart)!"
        }
        return createOutline(
            size = size,
            topStart = topStart,
            topEnd = topEnd,
            bottomEnd = bottomEnd,
            bottomStart = bottomStart,
            layoutDirection = layoutDirection,
            density = density
        )
    }

    private fun createOutline(
        size: Size,
        topStart: Float,
        topEnd: Float,
        bottomEnd: Float,
        bottomStart: Float,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            when (pointerPosition) {
                TooltipPointerPosition.Bottom -> {
                    drawBottomPointerTooltip(
                        size, topStart, topEnd, bottomEnd, bottomStart,
                        with(density) { pointerWidth.toPx() }, with(density) { pointerHeight.toPx() }, pointerBias, layoutDirection
                    )
                }
                TooltipPointerPosition.Top -> {
                    drawTopPointerTooltip(
                        size, topStart, topEnd, bottomEnd, bottomStart,
                        with(density) { pointerWidth.toPx() }, with(density) { pointerHeight.toPx() }, pointerBias, layoutDirection
                    )
                }
                TooltipPointerPosition.Left -> {
                    drawLeftPointerTooltip(
                        size, topStart, topEnd, bottomEnd, bottomStart,
                        with(density) { pointerWidth.toPx() }, with(density) { pointerHeight.toPx() }, pointerBias, layoutDirection
                    )
                }
                TooltipPointerPosition.Right -> {
                    drawRightPointerTooltip(
                        size, topStart, topEnd, bottomEnd, bottomStart,
                        with(density) { pointerWidth.toPx() }, with(density) { pointerHeight.toPx() }, pointerBias, layoutDirection
                    )
                }
            }
        }
        return Outline.Generic(path)
    }

    fun copy(
        topStart: CornerSize,
        topEnd: CornerSize,
        bottomEnd: CornerSize,
        bottomStart: CornerSize
    ): TooltipShape {
        return TooltipShape(
            topStart = topStart,
            topEnd = topEnd,
            bottomEnd = bottomEnd,
            bottomStart = bottomStart,
            pointerWidth = pointerWidth,
            pointerHeight = pointerHeight,
            pointerPosition = pointerPosition,
            pointerBias = pointerBias
        )
    }

    private fun Path.drawBottomPointerTooltip(
        size: Size,
        topStartRadius: Float,
        topEndRadius: Float,
        bottomEndRadius: Float,
        bottomStartRadius: Float,
        pointerWidthPx: Float,
        pointerHeightPx: Float,
        bias: Float,
        layoutDirection: LayoutDirection
    ) {
        val bodyHeight = size.height - pointerHeightPx

        // Handle RTL layout
        val (topLeft, topRight, bottomRight, bottomLeft) = if (layoutDirection == LayoutDirection.Ltr) {
            listOf(topStartRadius, topEndRadius, bottomEndRadius, bottomStartRadius)
        } else {
            listOf(topEndRadius, topStartRadius, bottomStartRadius, bottomEndRadius)
        }

        // Calculate pointer position with bias, clamped to avoid corners
        val minPointerX = maxOf(topLeft, bottomLeft) + pointerWidthPx / 2
        val maxPointerX = size.width - maxOf(topRight, bottomRight) - pointerWidthPx / 2
        val pointerCenterX = if (maxPointerX > minPointerX) {
            minPointerX + (maxPointerX - minPointerX) * bias.coerceIn(0f, 1f)
        } else {
            size.width / 2f // Fallback to center if not enough space
        }

        // Start from top-left corner
        moveTo(topLeft, 0f)

        // Top edge
        lineTo(size.width - topRight, 0f)

        // Top-right corner
        if (topRight > 0f) {
            arcTo(
                rect = Rect(
                    left = size.width - 2 * topRight,
                    top = 0f,
                    right = size.width,
                    bottom = 2 * topRight
                ),
                startAngleDegrees = -90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        // Right edge
        lineTo(size.width, bodyHeight - bottomRight)

        // Bottom-right corner
        if (bottomRight > 0f) {
            arcTo(
                rect = Rect(
                    left = size.width - 2 * bottomRight,
                    top = bodyHeight - 2 * bottomRight,
                    right = size.width,
                    bottom = bodyHeight
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        // Bottom edge to pointer start (right side)
        lineTo(pointerCenterX + pointerWidthPx / 2, bodyHeight)

        // Pointer
        lineTo(pointerCenterX, size.height) // Pointer tip
        lineTo(pointerCenterX - pointerWidthPx / 2, bodyHeight)

        // Bottom edge from pointer end (left side)
        lineTo(bottomLeft, bodyHeight)

        // Bottom-left corner
        if (bottomLeft > 0f) {
            arcTo(
                rect = Rect(
                    left = 0f,
                    top = bodyHeight - 2 * bottomLeft,
                    right = 2 * bottomLeft,
                    bottom = bodyHeight
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        // Left edge
        lineTo(0f, topLeft)

        // Top-left corner
        if (topLeft > 0f) {
            arcTo(
                rect = Rect(
                    left = 0f,
                    top = 0f,
                    right = 2 * topLeft,
                    bottom = 2 * topLeft
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        close()
    }

    private fun Path.drawTopPointerTooltip(
        size: Size,
        topStartRadius: Float,
        topEndRadius: Float,
        bottomEndRadius: Float,
        bottomStartRadius: Float,
        pointerWidthPx: Float,
        pointerHeightPx: Float,
        bias: Float,
        layoutDirection: LayoutDirection
    ) {
        val bodyTop = pointerHeightPx

        val (topLeft, topRight, bottomRight, bottomLeft) = if (layoutDirection == LayoutDirection.Ltr) {
            listOf(topStartRadius, topEndRadius, bottomEndRadius, bottomStartRadius)
        } else {
            listOf(topEndRadius, topStartRadius, bottomStartRadius, bottomEndRadius)
        }

        val minPointerX = maxOf(topLeft, bottomLeft) + pointerWidthPx / 2
        val maxPointerX = size.width - maxOf(topRight, bottomRight) - pointerWidthPx / 2
        val pointerCenterX = if (maxPointerX > minPointerX) {
            minPointerX + (maxPointerX - minPointerX) * bias.coerceIn(0f, 1f)
        } else {
            size.width / 2f
        }

        // Start from pointer tip
        moveTo(pointerCenterX, 0f)
        lineTo(pointerCenterX + pointerWidthPx / 2, bodyTop)

        // Top edge (right of pointer)
        lineTo(size.width - topRight, bodyTop)

        // Top-right corner
        if (topRight > 0f) {
            arcTo(
                rect = Rect(
                    size.width - 2 * topRight, bodyTop,
                    size.width, bodyTop + 2 * topRight
                ),
                startAngleDegrees = -90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        // Right edge
        lineTo(size.width, size.height - bottomRight)

        // Bottom-right corner
        if (bottomRight > 0f) {
            arcTo(
                rect = Rect(
                    size.width - 2 * bottomRight, size.height - 2 * bottomRight,
                    size.width, size.height
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        // Bottom edge
        lineTo(bottomLeft, size.height)

        // Bottom-left corner
        if (bottomLeft > 0f) {
            arcTo(
                rect = Rect(
                    0f, size.height - 2 * bottomLeft,
                    2 * bottomLeft, size.height
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        // Left edge
        lineTo(0f, bodyTop + topLeft)

        // Top-left corner
        if (topLeft > 0f) {
            arcTo(
                rect = Rect(
                    0f, bodyTop,
                    2 * topLeft, bodyTop + 2 * topLeft
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        // Top edge (left of pointer)
        lineTo(pointerCenterX - pointerWidthPx / 2, bodyTop)
        lineTo(pointerCenterX, 0f)

        close()
    }

    private fun Path.drawLeftPointerTooltip(
        size: Size,
        topStartRadius: Float,
        topEndRadius: Float,
        bottomEndRadius: Float,
        bottomStartRadius: Float,
        pointerWidthPx: Float,
        pointerHeightPx: Float,
        bias: Float,
        layoutDirection: LayoutDirection
    ) {
        val bodyLeft = pointerWidthPx

        val (topLeft, topRight, bottomRight, bottomLeft) = if (layoutDirection == LayoutDirection.Ltr) {
            listOf(topStartRadius, topEndRadius, bottomEndRadius, bottomStartRadius)
        } else {
            listOf(topEndRadius, topStartRadius, bottomStartRadius, bottomEndRadius)
        }

        val minPointerY = maxOf(topLeft, topRight) + pointerHeightPx / 2
        val maxPointerY = size.height - maxOf(bottomLeft, bottomRight) - pointerHeightPx / 2
        val pointerCenterY = if (maxPointerY > minPointerY) {
            minPointerY + (maxPointerY - minPointerY) * bias.coerceIn(0f, 1f)
        } else {
            size.height / 2f
        }

        // Start from pointer tip
        moveTo(0f, pointerCenterY)
        lineTo(bodyLeft, pointerCenterY - pointerHeightPx / 2)

        // Left edge (above pointer)
        lineTo(bodyLeft, topLeft)

        // Top-left corner
        if (topLeft > 0f) {
            arcTo(
                rect = Rect(
                    bodyLeft, 0f,
                    bodyLeft + 2 * topLeft, 2 * topLeft
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        // Top edge
        lineTo(size.width - topRight, 0f)

        // Top-right corner
        if (topRight > 0f) {
            arcTo(
                rect = Rect(
                    size.width - 2 * topRight, 0f,
                    size.width, 2 * topRight
                ),
                startAngleDegrees = -90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        // Right edge
        lineTo(size.width, size.height - bottomRight)

        // Bottom-right corner
        if (bottomRight > 0f) {
            arcTo(
                rect = Rect(
                    size.width - 2 * bottomRight, size.height - 2 * bottomRight,
                    size.width, size.height
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        // Bottom edge
        lineTo(bodyLeft + bottomLeft, size.height)

        // Bottom-left corner
        if (bottomLeft > 0f) {
            arcTo(
                rect = Rect(
                    bodyLeft, size.height - 2 * bottomLeft,
                    bodyLeft + 2 * bottomLeft, size.height
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        // Left edge (below pointer)
        lineTo(bodyLeft, pointerCenterY + pointerHeightPx / 2)
        lineTo(0f, pointerCenterY)

        close()
    }

    private fun Path.drawRightPointerTooltip(
        size: Size,
        topStartRadius: Float,
        topEndRadius: Float,
        bottomEndRadius: Float,
        bottomStartRadius: Float,
        pointerWidthPx: Float,
        pointerHeightPx: Float,
        bias: Float,
        layoutDirection: LayoutDirection
    ) {
        val bodyWidth = size.width - pointerWidthPx

        val (topLeft, topRight, bottomRight, bottomLeft) = if (layoutDirection == LayoutDirection.Ltr) {
            listOf(topStartRadius, topEndRadius, bottomEndRadius, bottomStartRadius)
        } else {
            listOf(topEndRadius, topStartRadius, bottomStartRadius, bottomEndRadius)
        }

        val minPointerY = maxOf(topLeft, topRight) + pointerHeightPx / 2
        val maxPointerY = size.height - maxOf(bottomLeft, bottomRight) - pointerHeightPx / 2
        val pointerCenterY = if (maxPointerY > minPointerY) {
            minPointerY + (maxPointerY - minPointerY) * bias.coerceIn(0f, 1f)
        } else {
            size.height / 2f
        }

        // Start from top-left corner
        moveTo(topLeft, 0f)

        // Top edge
        lineTo(bodyWidth - topRight, 0f)

        // Top-right corner
        if (topRight > 0f) {
            arcTo(
                rect = Rect(
                    bodyWidth - 2 * topRight, 0f,
                    bodyWidth, 2 * topRight
                ),
                startAngleDegrees = -90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        // Right edge (above pointer)
        lineTo(bodyWidth, pointerCenterY - pointerHeightPx / 2)

        // Pointer
        lineTo(size.width, pointerCenterY) // tip
        lineTo(bodyWidth, pointerCenterY + pointerHeightPx / 2)

        // Right edge (below pointer)
        lineTo(bodyWidth, size.height - bottomRight)

        // Bottom-right corner
        if (bottomRight > 0f) {
            arcTo(
                rect = Rect(
                    bodyWidth - 2 * bottomRight, size.height - 2 * bottomRight,
                    bodyWidth, size.height
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        // Bottom edge
        lineTo(bottomLeft, size.height)

        // Bottom-left corner
        if (bottomLeft > 0f) {
            arcTo(
                rect = Rect(
                    0f, size.height - 2 * bottomLeft,
                    2 * bottomLeft, size.height
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        // Left edge
        lineTo(0f, topLeft)

        // Top-left corner
        if (topLeft > 0f) {
            arcTo(
                rect = Rect(
                    0f, 0f,
                    2 * topLeft, 2 * topLeft
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        close()
    }
}

/**
 * Creates a TooltipShape with the same corner size for all corners.
 *
 * @param corner the corner size to apply to all four corners
 * @param pointerWidth the width of the triangular pointer
 * @param pointerHeight the height of the triangular pointer
 * @param pointerPosition the position of the pointer
 * @param pointerBias the position bias of the pointer (0.0 = start, 0.5 = center, 1.0 = end)
 */
fun TooltipShape(
    corner: CornerSize = CornerSize(0.dp),
    pointerWidth: Dp = 24.dp,
    pointerHeight: Dp = 12.dp,
    pointerPosition: TooltipPointerPosition = TooltipPointerPosition.Bottom,
    pointerBias: Float = 0.5f
) = TooltipShape(
    topStart = corner,
    topEnd = corner,
    bottomEnd = corner,
    bottomStart = corner,
    pointerWidth = pointerWidth,
    pointerHeight = pointerHeight,
    pointerPosition = pointerPosition,
    pointerBias = pointerBias
)

/**
 * Creates a TooltipShape with corner sizes specified in Dp.
 *
 * @param topStart the corner size for the top start corner in Dp
 * @param topEnd the corner size for the top end corner in Dp
 * @param bottomEnd the corner size for the bottom end corner in Dp
 * @param bottomStart the corner size for the bottom start corner in Dp
 * @param pointerWidth the width of the triangular pointer in Dp
 * @param pointerHeight the height of the triangular pointer in Dp
 * @param pointerPosition the position of the pointer
 * @param pointerBias the position bias of the pointer (0.0 = start, 0.5 = center, 1.0 = end)
 */
fun TooltipShape(
    topStart: Dp = 0.dp,
    topEnd: Dp = 0.dp,
    bottomEnd: Dp = 0.dp,
    bottomStart: Dp = 0.dp,
    pointerWidth: Dp = 24.dp,
    pointerHeight: Dp = 12.dp,
    pointerPosition: TooltipPointerPosition = TooltipPointerPosition.Bottom,
    pointerBias: Float = 0.5f
) = TooltipShape(
    topStart = CornerSize(topStart),
    topEnd = CornerSize(topEnd),
    bottomEnd = CornerSize(bottomEnd),
    bottomStart = CornerSize(bottomStart),
    pointerWidth = pointerWidth,
    pointerHeight = pointerHeight,
    pointerPosition = pointerPosition,
    pointerBias = pointerBias
)

/**
 * Creates a TooltipShape with the same corner size (in Dp) for all corners.
 *
 * @param size the corner size in Dp to apply to all four corners
 * @param pointerWidth the width of the triangular pointer in Dp
 * @param pointerHeight the height of the triangular pointer in Dp
 * @param pointerPosition the position of the pointer
 * @param pointerBias the position bias of the pointer (0.0 = start, 0.5 = center, 1.0 = end)
 */
fun TooltipShape(
    corner: Dp,
    pointerWidth: Dp = 24.dp,
    pointerHeight: Dp = 12.dp,
    pointerPosition: TooltipPointerPosition = TooltipPointerPosition.Bottom,
    pointerBias: Float = 0.5f
) = TooltipShape(
    corner = CornerSize(corner),
    pointerWidth = pointerWidth,
    pointerHeight = pointerHeight,
    pointerPosition = pointerPosition,
    pointerBias = pointerBias
)

/**
 * A [Box] that draws a tooltip using [TooltipShape].
 *
 * @param shape the shape of the tooltip
 * @param modifier the modifier to be applied to the tooltip
 * @param contentPadding the padding to be applied to the tooltip's content
 * @param color the color of the tooltip's background
 * @param contentAlignment the alignment of the tooltip's content
 * @param propagateMinConstraints whether to propagate the minimum constraints to the tooltip's content
 * @param content the content of the tooltip
 */
@Composable
fun TooltipBox(
    shape: TooltipShape,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    color: Color = Color.Transparent,
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier
            .background(
                color = color,
                shape = shape
            )
            .padding(contentPadding)
            .padding(
                start = if (shape.pointerPosition == TooltipPointerPosition.Left) shape.pointerWidth else 0.dp,
                top = if (shape.pointerPosition == TooltipPointerPosition.Top) shape.pointerHeight else 0.dp,
                end = if (shape.pointerPosition == TooltipPointerPosition.Right) shape.pointerWidth else 0.dp,
                bottom = if (shape.pointerPosition == TooltipPointerPosition.Bottom) shape.pointerHeight else 0.dp
            ),
        contentAlignment = contentAlignment,
        propagateMinConstraints = propagateMinConstraints,
        content = content
    )
}

@Composable
@SushiPreview
private fun TooltipBoxPreview() {
    SushiPreview {
        Column(
            modifier = Modifier.padding(32.dp)
        ) {
            val shape = TooltipShape(
                topStart = 16.dp,
                topEnd = 4.dp,
                bottomEnd = 16.dp,
                bottomStart = 4.dp,
                pointerWidth = 12.dp,
                pointerHeight = 8.dp,
                pointerPosition = TooltipPointerPosition.Bottom,
                pointerBias = 0.7f
            )
            TooltipBox(
                shape = shape,
                Modifier
                    .border(
                        1.dp,
                        SushiTheme.colors.black.value,
                        shape
                    ),
                contentPadding = PaddingValues(12.dp),
                color = SushiTheme.colors.red.v500.value,
            ) {
                SushiText(
                    SushiTextProps(
                        text = "A Tooltip Shaped Box Preview"
                    )
                )
            }
        }
    }
}

@Composable
@SushiPreview
private fun TooltipShapePreview() {
    SushiPreview {
        Column(
            modifier = Modifier.padding(32.dp)
        ) {
            val pointerHeight = 8.dp
            val shape = TooltipShape(
                topStart = 16.dp,
                topEnd = 4.dp,
                bottomEnd = 16.dp,
                bottomStart = 4.dp,
                pointerWidth = 12.dp,
                pointerHeight = pointerHeight,
                pointerPosition = TooltipPointerPosition.Bottom,
                pointerBias = 1.0f
            )
            Box(
                modifier = Modifier
                    .border(
                        1.dp,
                        SushiTheme.colors.black.value,
                        shape
                    )
                    .background(
                        color = SushiTheme.colors.red.v500.value,
                        shape = shape
                    )
                    .padding(12.dp)
                    .padding(bottom = pointerHeight)
            ) {
                SushiText(
                    SushiTextProps(
                        text = "Tooltip Shape Preview"
                    )
                )
            }
        }
    }
}
