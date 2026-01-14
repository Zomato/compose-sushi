package com.zomato.sushi.compose.components.tooltip.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TooltipScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
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
internal class TooltipPositionProviderImpl constructor(
    val type: TooltipAnchorPosition,
    val tooltipAnchorSpacingProvider: () -> Int,
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
                    .padding(PaddingValues(8.dp, 4.dp))
        ) {
            content()
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

        val tooltipOutline = tooltipShape.createOutline(size, layoutDirection, density)
        val caretOutline = caretShape.createOutline(size, layoutDirection, density)

        when (tooltipOutline) {
            is Outline.Generic -> tooltipPath.addPath(tooltipOutline.path)
            is Outline.Rounded -> tooltipPath.addRoundRect(tooltipOutline.roundRect)
            is Outline.Rectangle -> tooltipPath.addRect(tooltipOutline.rect)
        }

        // Applies the given caret shape to the caret path that will be manipulated
        when (caretOutline) {
            is Outline.Generic -> caretPath.addPath(caretOutline.path)
            is Outline.Rounded -> caretPath.addRoundRect(caretOutline.roundRect)
            is Outline.Rectangle -> caretPath.addRect(caretOutline.rect)
        }

        caretPath.transform(transformationMatrix.value)

        combinedPath.op(path1 = tooltipPath, path2 = caretPath, operation = PathOperation.Union)

        return Outline.Generic(combinedPath)
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