package com.zomato.sushi.compose.modifiers.clip

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.node.ModifierNodeElement

/**
 * @author gupta.anirudh@zomato.com
 */

enum class ClipDirection {
    Start, End, Top, Bottom
}

fun Modifier.clip(percentage: Float, direction: ClipDirection): Modifier = this.then(
    ClipPercentageModifierNodeElement(
        percentage = percentage,
        direction = direction
    )
)

fun Modifier.clipStart(percentage: Float): Modifier = this.then(
    ClipPercentageModifierNodeElement(
        percentage = percentage,
        direction = ClipDirection.Start
    )
)

fun Modifier.clipEnd(percentage: Float): Modifier = this.then(
    ClipPercentageModifierNodeElement(
        percentage = percentage,
        direction = ClipDirection.End
    )
)

fun Modifier.clipTop(percentage: Float): Modifier = this.then(
    ClipPercentageModifierNodeElement(
        percentage = percentage,
        direction = ClipDirection.Top
    )
)

fun Modifier.clipBottom(percentage: Float): Modifier = this.then(
    ClipPercentageModifierNodeElement(
        percentage = percentage,
        direction = ClipDirection.Bottom
    )
)

data class ClipPercentageModifierNodeElement(
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

class ClipPercentageModifierNode(
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