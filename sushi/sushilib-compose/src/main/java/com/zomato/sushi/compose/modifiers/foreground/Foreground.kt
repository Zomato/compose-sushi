package com.zomato.sushi.compose.modifiers.foreground

import androidx.annotation.FloatRange
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.node.ObserverModifierNode
import androidx.compose.ui.node.invalidateDraw
import androidx.compose.ui.node.observeReads
import androidx.compose.ui.platform.InspectorInfo
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.LayoutDirection

/**
 * @author gupta.anirudh@zomato.com
 */

@Stable
fun Modifier.foreground(
    brush: Brush,
    shape: Shape = RectangleShape,
    @FloatRange(from = 0.0, to = 1.0)
    alpha: Float = 1.0f
) = this.then(
    ForegroundElement(
        brush = brush,
        alpha = alpha,
        shape = shape,
        inspectorInfo = debugInspectorInfo {
            name = "foreground"
            properties["alpha"] = alpha
            properties["brush"] = brush
            properties["shape"] = shape
        }
    )
)

@Stable
fun Modifier.foreground(
    color: Color,
    shape: Shape = RectangleShape
): Modifier {
    val alpha = 1.0f // for solid colors
    return this.then(
        ForegroundElement(
            color = color,
            shape = shape,
            alpha = alpha,
            inspectorInfo = debugInspectorInfo {
                name = "foreground"
                value = color
                properties["color"] = color
                properties["shape"] = shape
            }
        )
    )
}

private class ForegroundElement(
    private val color: Color = Color.Unspecified,
    private val brush: Brush? = null,
    private val alpha: Float,
    private val shape: Shape,
    private val inspectorInfo: InspectorInfo.() -> Unit
) : ModifierNodeElement<ForegroundNode>() {
    override fun create(): ForegroundNode {
        return ForegroundNode(
            color,
            brush,
            alpha,
            shape
        )
    }

    override fun update(node: ForegroundNode) {
        node.color = color
        node.brush = brush
        node.alpha = alpha
        node.shape = shape
    }

    override fun InspectorInfo.inspectableProperties() {
        inspectorInfo()
    }

    override fun hashCode(): Int {
        var result = color.hashCode()
        result = 31 * result + (brush?.hashCode() ?: 0)
        result = 31 * result + alpha.hashCode()
        result = 31 * result + shape.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        val otherModifier = other as? ForegroundElement ?: return false
        return color == otherModifier.color &&
            brush == otherModifier.brush &&
            alpha == otherModifier.alpha &&
            shape == otherModifier.shape
    }
}

private class ForegroundNode(
    var color: Color,
    var brush: Brush?,
    var alpha: Float,
    var shape: Shape,
) : DrawModifierNode, Modifier.Node(), ObserverModifierNode {

    // Naively cache outline calculation if input parameters are the same, we manually observe
    // reads inside shape#createOutline separately
    private var lastSize: Size = Size.Unspecified
    private var lastLayoutDirection: LayoutDirection? = null
    private var lastOutline: Outline? = null
    private var lastShape: Shape? = null

    override fun ContentDrawScope.draw() {
        drawContent()
        if (shape === RectangleShape) {
            // shortcut to avoid Outline calculation and allocation
            drawRect()
        } else {
            drawOutline()
        }
    }

    override fun onObservedReadsChanged() {
        // Reset cached properties
        lastSize = Size.Unspecified
        lastLayoutDirection = null
        lastOutline = null
        lastShape = null
        // Invalidate draw so we build the cache again - this is needed because observeReads within
        // the draw scope obscures the state reads from the draw scope's observer
        invalidateDraw()
    }

    private fun ContentDrawScope.drawRect() {
        if (color != Color.Unspecified) drawRect(color = color)
        brush?.let { drawRect(brush = it, alpha = alpha) }
    }

    private fun ContentDrawScope.drawOutline() {
        val outline = getOutline() ?: return
        if (color != Color.Unspecified) drawOutline(outline, color = color)
        brush?.let { drawOutline(outline, brush = it, alpha = alpha) }
    }

    private fun ContentDrawScope.getOutline(): Outline? {
        var outline: Outline? = null
        if (size == lastSize && layoutDirection == lastLayoutDirection && lastShape == shape) {
            outline = lastOutline
        } else {
            // Manually observe reads so we can directly invalidate the outline when it changes
            observeReads {
                outline = shape.createOutline(size, layoutDirection, this)
            }
        }
        lastOutline = outline
        lastSize = size
        lastLayoutDirection = layoutDirection
        lastShape = shape
        return outline
    }
}