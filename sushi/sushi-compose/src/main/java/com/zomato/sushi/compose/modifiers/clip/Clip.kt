package com.zomato.sushi.compose.modifiers.clip

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.node.ModifierNodeElement

/**
 * Defines the direction from which a composable should be clipped.
 * This enum provides options to clip from any edge of the composable.
 *
 * @author gupta.anirudh@zomato.com
 */
enum class ClipDirection {
    /** Clip from the leading edge (left in LTR, right in RTL) */
    Start,
    
    /** Clip from the trailing edge (right in LTR, left in RTL) */
    End,
    
    /** Clip from the top edge */
    Top,
    
    /** Clip from the bottom edge */
    Bottom
}

/**
 * Clips a specified percentage of the composable from the given direction.
 * 
 * This modifier can be used to create partial reveal animations or other visual effects
 * where only a portion of a composable should be visible.
 *
 * @param percentage The percentage of the composable to clip (0.0 to 1.0)
 * @param direction The direction from which to apply the clipping
 * @return A modifier that clips the composable
 */
fun Modifier.clip(percentage: Float, direction: ClipDirection): Modifier = this.then(
    ClipPercentageModifierNodeElement(
        percentage = percentage,
        direction = direction
    )
)

/**
 * Clips a specified percentage of the composable from the leading edge.
 *
 * @param percentage The percentage of the composable to clip (0.0 to 1.0)
 * @return A modifier that clips the composable from the start
 */
fun Modifier.clipStart(percentage: Float): Modifier = this.then(
    ClipPercentageModifierNodeElement(
        percentage = percentage,
        direction = ClipDirection.Start
    )
)

/**
 * Clips a specified percentage of the composable from the trailing edge.
 *
 * @param percentage The percentage of the composable to clip (0.0 to 1.0)
 * @return A modifier that clips the composable from the end
 */
fun Modifier.clipEnd(percentage: Float): Modifier = this.then(
    ClipPercentageModifierNodeElement(
        percentage = percentage,
        direction = ClipDirection.End
    )
)

/**
 * Clips a specified percentage of the composable from the top edge.
 *
 * @param percentage The percentage of the composable to clip (0.0 to 1.0)
 * @return A modifier that clips the composable from the top
 */
fun Modifier.clipTop(percentage: Float): Modifier = this.then(
    ClipPercentageModifierNodeElement(
        percentage = percentage,
        direction = ClipDirection.Top
    )
)

/**
 * Clips a specified percentage of the composable from the bottom edge.
 *
 * @param percentage The percentage of the composable to clip (0.0 to 1.0)
 * @return A modifier that clips the composable from the bottom
 */
fun Modifier.clipBottom(percentage: Float): Modifier = this.then(
    ClipPercentageModifierNodeElement(
        percentage = percentage,
        direction = ClipDirection.Bottom
    )
)

private data class ClipPercentageModifierNodeElement(
    val percentage: Float,
    val direction: ClipDirection
): ModifierNodeElement<ClipPercentageModifierNode>() {

    override fun create() = ClipPercentageModifierNode(
        percentage = percentage,
        direction = direction
    )

    override fun update(node: ClipPercentageModifierNode) {
        node.update(
            percentage = percentage,
            direction = direction
        )
    }
}

private class ClipPercentageModifierNode(
    private var percentage: Float,
    private var direction: ClipDirection
) : Modifier.Node(), DrawModifierNode {

    fun update(
        percentage: Float,
        direction: ClipDirection
    ) {
        this.percentage = percentage
        this.direction = direction
    }

    override fun ContentDrawScope.draw() {
        val clampedPercentage = percentage.coerceIn(0f, 1f)

        val start = if (direction == ClipDirection.End) (size.width * (1f - clampedPercentage)) else 0f
        val top = if (direction == ClipDirection.Bottom) (size.height * (1f - clampedPercentage)) else 0f
        val bottom = if (direction == ClipDirection.Top) (size.height * clampedPercentage) else size.height
        val end = if (direction == ClipDirection.Start) (size.width * clampedPercentage) else size.width

        clipRect(
            left = start,
            top = top,
            right = end,
            bottom = bottom
        ) {
            this@draw.drawContent()
        }
    }
}