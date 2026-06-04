package com.zomato.sushi.compose.components.tooltip.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TooltipScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Matrix
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupPositionProvider
import com.zomato.sushi.compose.components.tooltip.SushiTooltipDefaults

private val TooltipMinWidth = 40.dp
private val RichTooltipMaxWidth = 320.dp
private val TooltipMinHeight = 24.dp
private val SpacingBetweenTooltipAndAnchor = 4.dp
private val ContainerElevation = 3.dp

@OptIn(ExperimentalMaterial3Api::class)
class TooltipPositionProviderImpl constructor(
    val type: TooltipAnchorPosition,
    val tooltipAnchorSpacingProvider: () -> Int,
    val transformAnchorBounds: IntOffset = IntOffset.Zero
) : PopupPositionProvider {
    override fun calculatePosition(
        anchorBounds: IntRect,
        windowSize: IntSize,
        layoutDirection: LayoutDirection,
        popupContentSize: IntSize,
    ): IntOffset {
        return when (type) {
            TooltipAnchorPosition.Left -> leftPositioning(anchorBounds, popupContentSize)
            TooltipAnchorPosition.Right ->
                rightPositioning(anchorBounds, popupContentSize, windowSize)
            TooltipAnchorPosition.Above ->
                abovePositioning(anchorBounds, popupContentSize, windowSize)
            TooltipAnchorPosition.Below ->
                belowPositioning(anchorBounds, popupContentSize, windowSize)
            TooltipAnchorPosition.Start ->
                startPositioning(layoutDirection, anchorBounds, popupContentSize, windowSize)
            TooltipAnchorPosition.End ->
                endPositioning(layoutDirection, anchorBounds, popupContentSize, windowSize)
            else -> abovePositioning(anchorBounds, popupContentSize, windowSize)
        }.let {
            it.copy(
                x = it.x + transformAnchorBounds.x,
                y = it.y + transformAnchorBounds.y
            )
        }
    }

    fun leftPositioning(anchorBounds: IntRect, popupContentSize: IntSize): IntOffset {
        // Horizontal alignment preference: left -> right
        // Vertical preference: center

        // Tooltip prefers to be to the left of the anchor
        var x = anchorBounds.left - (popupContentSize.width + tooltipAnchorSpacingProvider())

        if (x < 0) {
            // Flip the tooltip to be on the right if
            // it collides with the left side of the screen
            x = anchorBounds.right + tooltipAnchorSpacingProvider()
        }

        // We vertically center the tooltip with the anchor
        var y = (anchorBounds.top + anchorBounds.bottom - popupContentSize.height) / 2
        return IntOffset(x, y)
    }

    fun rightPositioning(
        anchorBounds: IntRect,
        popupContentSize: IntSize,
        windowSize: IntSize,
    ): IntOffset {
        // Horizontal alignment preference: right -> left
        // Vertical preference: center

        // Tooltip prefers to be to the right of the anchor
        var x = anchorBounds.right + tooltipAnchorSpacingProvider()

        if (x + popupContentSize.width > windowSize.width) {
            // Flip the tooltip to be on the left if
            // it collides with the right side of the screen
            x = anchorBounds.left - (popupContentSize.width + tooltipAnchorSpacingProvider())
        }

        // We vertically center the tooltip with the anchor
        var y = (anchorBounds.top + anchorBounds.bottom - popupContentSize.height) / 2
        return IntOffset(x, y)
    }

    fun abovePositioning(
        anchorBounds: IntRect,
        popupContentSize: IntSize,
        windowSize: IntSize,
    ): IntOffset {
        // Horizontal alignment preference: middle -> start -> end
        // Vertical preference: above -> below

        // Tooltip prefers to be center aligned horizontally.
        var x = anchorBounds.left + (anchorBounds.width - popupContentSize.width) / 2

        if (x < 0) {
            // Make tooltip start aligned if colliding with the
            // left side of the screen
            x = anchorBounds.left
        } else if (x + popupContentSize.width > windowSize.width) {
            // Make tooltip end aligned if colliding with the
            // right side of the screen
            x = anchorBounds.right - popupContentSize.width
        }

        // Tooltip prefers to be above the anchor,
        // but if this causes the tooltip to overlap with the anchor
        // then we place it below the anchor
        var y = anchorBounds.top - popupContentSize.height - tooltipAnchorSpacingProvider()
        if (y < 0) y = anchorBounds.bottom + tooltipAnchorSpacingProvider()
        return IntOffset(x, y)
    }

    fun belowPositioning(
        anchorBounds: IntRect,
        popupContentSize: IntSize,
        windowSize: IntSize,
    ): IntOffset {
        // Horizontal alignment preference: middle -> start -> end
        // Vertical preference: below -> above

        // Tooltip prefers to be center aligned horizontally.
        var x = anchorBounds.left + (anchorBounds.width - popupContentSize.width) / 2

        if (x < 0) {
            // Make tooltip start aligned if colliding with the
            // left side of the screen
            x = anchorBounds.left
        } else if (x + popupContentSize.width > windowSize.width) {
            // Make tooltip end aligned if colliding with the
            // right side of the screen
            x = anchorBounds.right - popupContentSize.width
        }

        // Tooltip prefers to be below the anchor,
        // but if this causes the tooltip to overlap with the anchor
        // then we place it above the anchor
        var y = anchorBounds.bottom + tooltipAnchorSpacingProvider()
        if (y + popupContentSize.height > windowSize.height) {
            y = anchorBounds.top - popupContentSize.height - tooltipAnchorSpacingProvider()
        }
        return IntOffset(x, y)
    }

    fun startPositioning(
        layoutDirection: LayoutDirection,
        anchorBounds: IntRect,
        popupContentSize: IntSize,
        windowSize: IntSize,
    ): IntOffset {
        return if (layoutDirection == LayoutDirection.Ltr) {
            leftPositioning(anchorBounds, popupContentSize)
        } else {
            rightPositioning(anchorBounds, popupContentSize, windowSize)
        }
    }

    fun endPositioning(
        layoutDirection: LayoutDirection,
        anchorBounds: IntRect,
        popupContentSize: IntSize,
        windowSize: IntSize,
    ): IntOffset {
        return if (layoutDirection == LayoutDirection.Ltr) {
            rightPositioning(anchorBounds, popupContentSize, windowSize)
        } else {
            leftPositioning(anchorBounds, popupContentSize)
        }
    }
}

@Composable
@ExperimentalMaterial3Api
internal fun TooltipScope.PlainTooltip(
    modifier: Modifier = Modifier,
    caretShape: (Shape)? = null,
    maxWidth: Dp = TooltipDefaults.plainTooltipMaxWidth,
    shape: Shape = TooltipDefaults.plainTooltipContainerShape,
    contentColor: Color = TooltipDefaults.plainTooltipContentColor,
    containerColor: Color = TooltipDefaults.plainTooltipContainerColor,
    contentPadding: PaddingValues = PaddingValues(4.dp, 4.dp),
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    content: @Composable () -> Unit,
) {
    val tooltipShape: Shape
    val tooltipModifier: Modifier
    if (caretShape != null) {
        val transformationMatrix = remember { mutableStateOf(Matrix()) }
        val density = LocalDensity.current
        val windowContainerSize = LocalWindowInfo.current.containerSize
        tooltipModifier =
            Modifier.layoutCaret(
                transformationMatrix,
                density,
                windowContainerSize,
                { obtainAnchorBounds() },
                obtainPositionProvider(),
            )
                .then(modifier)
        tooltipShape =
            remember(shape, caretShape) {
                TooltipCaretShape(transformationMatrix, shape, caretShape)
            }
    } else {
        tooltipShape = shape
        tooltipModifier = modifier
    }

    Surface(
        modifier = tooltipModifier,
        shape = tooltipShape,
        color = containerColor,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
    ) {
        Box(
            modifier =
                Modifier.sizeIn(
                    minWidth = TooltipMinWidth,
                    maxWidth = maxWidth,
                    minHeight = TooltipMinHeight,
                )
                    .padding(contentPadding)
        ) {
            CompositionLocalProvider(
                LocalContentColor provides contentColor,
                content = content,
            )
        }
    }
}

private class TooltipCaretShape(
    private val transformationMatrix: MutableState<Matrix>,
    private val tooltipShape: Shape,
    private val caretShape: Shape,
) : Shape {
    val tooltipPath = Path()
    val combinedPath = Path()
    val caretPath = Path()

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        tooltipPath.reset()
        combinedPath.reset()
        caretPath.reset()

        // Get the caret outline and transform it to find its position
        val caretOutline = caretShape.createOutline(size, layoutDirection, density)
        when (caretOutline) {
            is Outline.Generic -> caretPath.addPath(caretOutline.path)
            is Outline.Rounded -> caretPath.addRoundRect(caretOutline.roundRect)
            is Outline.Rectangle -> caretPath.addRect(caretOutline.rect)
        }
        caretPath.transform(transformationMatrix.value)

        // Create a modified tooltip shape with flattened corner where caret is positioned
        val modifiedTooltipOutline = createModifiedTooltipOutline(
            tooltipShape,
            size,
            layoutDirection,
            density
        )

        when (modifiedTooltipOutline) {
            is Outline.Generic -> tooltipPath.addPath(modifiedTooltipOutline.path)
            is Outline.Rounded -> tooltipPath.addRoundRect(modifiedTooltipOutline.roundRect)
            is Outline.Rectangle -> tooltipPath.addRect(modifiedTooltipOutline.rect)
        }

        // Use Union operation to combine tooltip (with flattened corner) and caret
        // Since the corner radius is 0 where the caret touches, the union is seamless
        combinedPath.op(path1 = tooltipPath, path2 = caretPath, operation = PathOperation.Union)

        return Outline.Generic(combinedPath)
    }
    
    private fun createModifiedTooltipOutline(
        originalShape: Shape,
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        // If the shape is RoundedCornerShape, modify it to have 0 radius at the caret corner
        if (originalShape is RoundedCornerShape) {
            val originalOutline = originalShape.createOutline(size, layoutDirection, density)
            
            if (originalOutline is Outline.Rounded) {
                val roundRect = originalOutline.roundRect
                val topLeftRadius = roundRect.topLeftCornerRadius
                val topRightRadius = roundRect.topRightCornerRadius
                val bottomRightRadius = roundRect.bottomRightCornerRadius
                val bottomLeftRadius = roundRect.bottomLeftCornerRadius
                
                // Get the caret bounds (already transformed)
                val caretBounds = caretPath.getBounds()
                
                // The caret is positioned outside the tooltip (above/below/left/right)
                // We need to check if the caret's horizontal/vertical span intersects with corner regions
                
                // Determine caret position relative to tooltip
                val caretIsAbove = caretBounds.bottom <= 0f
                val caretIsBelow = caretBounds.top >= size.height
                val caretIsLeft = caretBounds.right <= 0f
                val caretIsRight = caretBounds.left >= size.width
                
                var newTopLeft = topLeftRadius
                var newTopRight = topRightRadius
                var newBottomRight = bottomRightRadius
                var newBottomLeft = bottomLeftRadius
                
                if (caretIsAbove) {
                    // Caret is above tooltip, check horizontal position against top corners
                    // Check if caret's horizontal span overlaps with top-left corner region
                    if (caretBounds.left < topLeftRadius.x && caretBounds.right > 0f) {
                        // Calculate how much of the corner region is NOT covered by the caret
                        // If caret covers the corner fully, radius = 0
                        // If caret covers partially, reduce radius proportionally
                        val caretStartX = maxOf(0f, caretBounds.left)
                        val caretEndX = minOf(topLeftRadius.x, caretBounds.right)
                        val coveredWidth = caretEndX - caretStartX
                        
                        // The new radius should start from where the caret ends
                        newTopLeft = if (caretStartX <= 0f) {
                            // Caret starts at or before the corner, use remaining space
                            CornerRadius(maxOf(0f, topLeftRadius.x - coveredWidth))
                        } else {
                            // Caret starts within corner region
                            CornerRadius(caretStartX)
                        }
                    }
                    // Check if caret's horizontal span overlaps with top-right corner region
                    if (caretBounds.right > (size.width - topRightRadius.x) && caretBounds.left < size.width) {
                        val cornerStartX = size.width - topRightRadius.x
                        val caretStartX = maxOf(cornerStartX, caretBounds.left)
                        val caretEndX = minOf(size.width, caretBounds.right)
                        val coveredWidth = caretEndX - caretStartX
                        
                        // The new radius should be for the part not covered by caret
                        newTopRight = if (caretEndX >= size.width) {
                            CornerRadius(maxOf(0f, topRightRadius.x - coveredWidth))
                        } else {
                            CornerRadius(size.width - caretEndX)
                        }
                    }
                } else if (caretIsBelow) {
                    // Caret is below tooltip, check horizontal position against bottom corners
                    if (caretBounds.left < bottomLeftRadius.x && caretBounds.right > 0f) {
                        val caretStartX = maxOf(0f, caretBounds.left)
                        val caretEndX = minOf(bottomLeftRadius.x, caretBounds.right)
                        val coveredWidth = caretEndX - caretStartX
                        
                        newBottomLeft = if (caretStartX <= 0f) {
                            CornerRadius(maxOf(0f, bottomLeftRadius.x - coveredWidth))
                        } else {
                            CornerRadius(caretStartX)
                        }
                    }
                    if (caretBounds.right > (size.width - bottomRightRadius.x) && caretBounds.left < size.width) {
                        val cornerStartX = size.width - bottomRightRadius.x
                        val caretStartX = maxOf(cornerStartX, caretBounds.left)
                        val caretEndX = minOf(size.width, caretBounds.right)
                        val coveredWidth = caretEndX - caretStartX
                        
                        newBottomRight = if (caretEndX >= size.width) {
                            CornerRadius(maxOf(0f, bottomRightRadius.x - coveredWidth))
                        } else {
                            CornerRadius(size.width - caretEndX)
                        }
                    }
                } else if (caretIsLeft) {
                    // Caret is to the left of tooltip, check vertical position against left corners
                    if (caretBounds.top < topLeftRadius.y && caretBounds.bottom > 0f) {
                        val caretStartY = maxOf(0f, caretBounds.top)
                        val caretEndY = minOf(topLeftRadius.y, caretBounds.bottom)
                        val coveredHeight = caretEndY - caretStartY
                        
                        newTopLeft = if (caretStartY <= 0f) {
                            CornerRadius(maxOf(0f, topLeftRadius.y - coveredHeight))
                        } else {
                            CornerRadius(caretStartY)
                        }
                    }
                    if (caretBounds.bottom > (size.height - bottomLeftRadius.y) && caretBounds.top < size.height) {
                        val cornerStartY = size.height - bottomLeftRadius.y
                        val caretStartY = maxOf(cornerStartY, caretBounds.top)
                        val caretEndY = minOf(size.height, caretBounds.bottom)
                        val coveredHeight = caretEndY - caretStartY
                        
                        newBottomLeft = if (caretEndY >= size.height) {
                            CornerRadius(maxOf(0f, bottomLeftRadius.y - coveredHeight))
                        } else {
                            CornerRadius(size.height - caretEndY)
                        }
                    }
                } else if (caretIsRight) {
                    // Caret is to the right of tooltip, check vertical position against right corners
                    if (caretBounds.top < topRightRadius.y && caretBounds.bottom > 0f) {
                        val caretStartY = maxOf(0f, caretBounds.top)
                        val caretEndY = minOf(topRightRadius.y, caretBounds.bottom)
                        val coveredHeight = caretEndY - caretStartY
                        
                        newTopRight = if (caretStartY <= 0f) {
                            CornerRadius(maxOf(0f, topRightRadius.y - coveredHeight))
                        } else {
                            CornerRadius(caretStartY)
                        }
                    }
                    if (caretBounds.bottom > (size.height - bottomRightRadius.y) && caretBounds.top < size.height) {
                        val cornerStartY = size.height - bottomRightRadius.y
                        val caretStartY = maxOf(cornerStartY, caretBounds.top)
                        val caretEndY = minOf(size.height, caretBounds.bottom)
                        val coveredHeight = caretEndY - caretStartY
                        
                        newBottomRight = if (caretEndY >= size.height) {
                            CornerRadius(maxOf(0f, bottomRightRadius.y - coveredHeight))
                        } else {
                            CornerRadius(size.height - caretEndY)
                        }
                    }
                }
                
                // Create modified RoundRect
                val modifiedRoundRect = RoundRect(
                    left = roundRect.left,
                    top = roundRect.top,
                    right = roundRect.right,
                    bottom = roundRect.bottom,
                    topLeftCornerRadius = newTopLeft,
                    topRightCornerRadius = newTopRight,
                    bottomRightCornerRadius = newBottomRight,
                    bottomLeftCornerRadius = newBottomLeft
                )
                
                return Outline.Rounded(modifiedRoundRect)
            }
        }
        
        // If not a RoundedCornerShape or can't be modified, return original
        return originalShape.createOutline(size, layoutDirection, density)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
private fun Modifier.layoutCaret(
    transformationMatrix: MutableState<Matrix>,
    density: Density,
    windowContainerSize: IntSize,
    getAnchorLayoutCoordinates: MeasureScope.() -> LayoutCoordinates?,
    positionProvider: PopupPositionProvider,
): Modifier =
    this.layout { measurables, constraints ->
        val placeable = measurables.measure(constraints)
        val width = placeable.width
        val height = placeable.height
        val windowContainerWidthInPx = windowContainerSize.width
        val windowContainerHeightInPx = windowContainerSize.height
        val tooltipWidth = width.toFloat()
        val tooltipHeight = height.toFloat()
        val anchorLayoutCoordinates = getAnchorLayoutCoordinates()

        if (anchorLayoutCoordinates != null) {
            val screenWidthPx: Int
            val tooltipAnchorSpacing: Int
            with(density) {
                screenWidthPx = windowContainerWidthInPx
                tooltipAnchorSpacing = SpacingBetweenTooltipAndAnchor.roundToPx()
            }
            val anchorBounds = anchorLayoutCoordinates.boundsInWindow()
            val anchorTop = anchorBounds.top
            val anchorBottom = anchorBounds.bottom
            val anchorRight = anchorBounds.right
            val anchorLeft = anchorBounds.left
            val tooltipWidth: Float = tooltipWidth
            val tooltipHeight: Float = tooltipHeight
            val caretY =
                if (positionProvider is TooltipPositionProviderImpl) {
                    when (positionProvider.type) {
                        TooltipAnchorPosition.Left,
                        TooltipAnchorPosition.Right,
                        TooltipAnchorPosition.Start,
                        TooltipAnchorPosition.End -> {
                            tooltipHeight / 2
                        }
                        TooltipAnchorPosition.Above -> {
                            if (anchorTop - tooltipHeight - tooltipAnchorSpacing < 0) {
                                0f
                            } else {
                                tooltipHeight
                            }
                        }
                        TooltipAnchorPosition.Below -> {
                            if (
                                anchorBottom + tooltipHeight + tooltipAnchorSpacing >
                                windowContainerHeightInPx
                            ) {
                                tooltipHeight
                            } else {
                                0f
                            }
                        }
                        else -> {
                            if (anchorTop - tooltipHeight - tooltipAnchorSpacing < 0) {
                                0f
                            } else {
                                tooltipHeight
                            }
                        }
                    }
                } else {
                    // If a custom position provider is given
                    // we treat it like AbovePositionProvider.
                    if (anchorTop - tooltipHeight - tooltipAnchorSpacing < 0) {
                        0f
                    } else {
                        tooltipHeight
                    }
                }

            val position =
                if (positionProvider is TooltipPositionProviderImpl) {
                    when (positionProvider.type) {
                        TooltipAnchorPosition.Left -> {
                            val caretX =
                                if (anchorLeft - tooltipAnchorSpacing - tooltipWidth < 0) {
                                    // We are placing the tooltip to the right of the anchor
                                    0f
                                } else {
                                    tooltipWidth
                                }
                            Offset(x = caretX, y = caretY)
                        }
                        TooltipAnchorPosition.Right -> {
                            val caretX =
                                if (
                                    anchorRight + tooltipAnchorSpacing + tooltipWidth >
                                    windowContainerWidthInPx
                                ) {
                                    // We are placing the tooltip to the left of the anchor
                                    tooltipWidth
                                } else {
                                    0f
                                }
                            Offset(x = caretX, y = caretY)
                        }
                        TooltipAnchorPosition.Start -> {
                            val caretX =
                                if (layoutDirection == LayoutDirection.Ltr) {
                                    if (anchorLeft - tooltipAnchorSpacing - tooltipWidth < 0) {
                                        // We are placing the tooltip to the right of the anchor
                                        0f
                                    } else {
                                        tooltipWidth
                                    }
                                } else {
                                    if (
                                        anchorRight + tooltipAnchorSpacing + tooltipWidth >
                                        windowContainerWidthInPx
                                    ) {
                                        // We are placing the tooltip to the left of the anchor
                                        tooltipWidth
                                    } else {
                                        0f
                                    }
                                }
                            Offset(x = caretX, y = caretY)
                        }
                        TooltipAnchorPosition.End -> {
                            val caretX =
                                if (layoutDirection == LayoutDirection.Ltr) {
                                    if (
                                        anchorRight + tooltipAnchorSpacing + tooltipWidth >
                                        windowContainerWidthInPx
                                    ) {
                                        // We are placing the tooltip to the left of the anchor
                                        tooltipWidth
                                    } else {
                                        0f
                                    }
                                } else {
                                    if (anchorLeft - tooltipAnchorSpacing - tooltipWidth < 0) {
                                        // We are placing the tooltip to the right of the anchor
                                        0f
                                    } else {
                                        tooltipWidth
                                    }
                                }
                            Offset(x = caretX, y = caretY)
                        }
                        else -> {
                            Offset(
                                x = caretX(tooltipWidth, screenWidthPx, anchorBounds),
                                y = caretY,
                            )
                        }
                    }
                } else {
                    Offset(x = caretX(tooltipWidth, screenWidthPx, anchorBounds), y = caretY)
                }

            // Translate matrix to position
            val matrix = Matrix()
            matrix.translate(x = position.x, y = position.y)

            // We rotate matrix depending on positioning of the tooltip
            if (positionProvider is TooltipPositionProviderImpl) {
                when (positionProvider.type) {
                    TooltipAnchorPosition.Left -> {
                        // Need to rotate it about the z axis by 90 degrees
                        if (anchorLeft - tooltipAnchorSpacing - tooltipWidth < 0) {
                            // Tooltip is being placed to the right of the anchor
                            matrix.rotateZ(90f)
                        } else {
                            matrix.rotateZ(-90f)
                        }
                    }
                    TooltipAnchorPosition.Right -> {
                        // Need to rotate it about the z axis by 90 degrees
                        if (
                            anchorRight + tooltipAnchorSpacing + tooltipWidth >
                            windowContainerWidthInPx
                        ) {
                            // Tooltip is being placed to the left of the anchor
                            matrix.rotateZ(-90f)
                        } else {
                            matrix.rotateZ(90f)
                        }
                    }
                    TooltipAnchorPosition.Start -> {
                        if (layoutDirection == LayoutDirection.Ltr) {
                            // Need to rotate it about the z axis by 90 degrees
                            if (anchorLeft - tooltipAnchorSpacing - tooltipWidth < 0) {
                                // Tooltip is being placed to the right of the anchor
                                matrix.rotateZ(90f)
                            } else {
                                matrix.rotateZ(-90f)
                            }
                        } else {
                            // Need to rotate it about the z axis by 90 degrees
                            if (
                                anchorRight + tooltipAnchorSpacing + tooltipWidth >
                                windowContainerWidthInPx
                            ) {
                                // Tooltip is being placed to the left of the anchor
                                matrix.rotateZ(-90f)
                            } else {
                                matrix.rotateZ(90f)
                            }
                        }
                    }
                    TooltipAnchorPosition.End -> {
                        if (layoutDirection == LayoutDirection.Ltr) {
                            // Need to rotate it about the z axis by 90 degrees
                            if (
                                anchorRight + tooltipAnchorSpacing + tooltipWidth >
                                windowContainerWidthInPx
                            ) {
                                // Tooltip is being placed to the left of the anchor
                                matrix.rotateZ(-90f)
                            } else {
                                matrix.rotateZ(90f)
                            }
                        } else {
                            // Need to rotate it about the z axis by 90 degrees
                            if (anchorLeft - tooltipAnchorSpacing - tooltipWidth < 0) {
                                // Tooltip is being placed to the right of the anchor
                                matrix.rotateZ(90f)
                            } else {
                                matrix.rotateZ(-90f)
                            }
                        }
                    }
                    else -> {
                        if (caretY == 0f) {
                            // caret needs to be placed above tooltip
                            // Need to rotate it about the x axis by 180 degrees
                            matrix.rotateX(180f)
                        }
                    }
                }
            } else {
                if (caretY == 0f) {
                    // caret needs to be placed above tooltip
                    // Need to rotate it about the x axis by 180 degrees
                    matrix.rotateX(180f)
                }
            }
            transformationMatrix.value = matrix
        }
        layout(width, height) { placeable.place(0, 0) }
    }

private fun caretX(tooltipWidth: Float, screenWidthPx: Int, anchorBounds: Rect): Float {
    val anchorLeft = anchorBounds.left
    val anchorRight = anchorBounds.right
    val anchorMid = (anchorLeft + anchorRight) / 2
    return if (tooltipWidth >= screenWidthPx) {
        // Tooltip is greater than or equal to the width of the screen
        // The horizontal placement just needs to be in the center of the anchor
        anchorMid
    } else if (anchorMid - tooltipWidth / 2 < 0) {
        // The tooltip needs to be start aligned if it would
        // collide with the left side of screen when attempting to center.
        // We have a horizontal correction for the caret if the tooltip will
        // also collide with the right edge of the screen when start aligned
        val horizontalCorrection = maxOf(tooltipWidth - screenWidthPx, -anchorLeft)
        anchorMid + horizontalCorrection
    } else if (anchorMid + tooltipWidth / 2 > screenWidthPx) {
        // The tooltip needs to be end aligned if it would
        // collide with the right side of the screen when attempting to center.
        // We have a horizontal correction for the caret if the tooltip will
        // also collide with the left edge of the screen when end aligned
        val horizontalCorrection = minOf(tooltipWidth - anchorRight, 0f)
        anchorMid + horizontalCorrection
    } else {
        // Tooltip can centered neatly without colliding with screen edge
        tooltipWidth / 2
    }
}

@ExperimentalMaterial3Api
/**
 * Default [Shape] of the caret used by tooltips.
 *
 * @param caretSize the size of the caret used
 */
internal class DefaultTooltipCaretShape(val caretSize: DpSize = SushiTooltipDefaults.caretSize) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        val caretPath = Path()
        val caretWidthPx: Float
        val caretHeightPx: Float
        with(density) {
            caretWidthPx = caretSize.width.toPx()
            caretHeightPx = caretSize.height.toPx()
        }

        caretPath.apply {
            moveTo(x = 0f, 0f)
            lineTo(x = caretWidthPx / 2, y = 0f)
            lineTo(x = 0f, y = caretHeightPx)
            lineTo(x = -caretWidthPx / 2, y = 0f)
            close()
        }

        return Outline.Generic(caretPath)
    }
}