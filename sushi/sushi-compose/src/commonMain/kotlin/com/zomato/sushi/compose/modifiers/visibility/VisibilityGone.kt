package com.zomato.sushi.compose.modifiers.visibility

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.node.LayoutModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.unit.Constraints
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.internal.SushiPreview

/**
 * Makes a component's visibility as gone if the condition is true.
 *
 * @param enabled true if the component's visibility should be gone, false otherwise.
 * @return A modifier that makes the component's visibility gone when the condition is true
 */
fun Modifier.visibilityGone(
    enabled: Boolean = true
): Modifier = this.then(
    SushiVisibilityGoneModifierNodeElement(
        enabled = enabled
    )
)

/**
 * Internal implementation details for the visibility gone modifier.
 */
private data class SushiVisibilityGoneModifierNodeElement(
    val enabled: Boolean
): ModifierNodeElement<SushiVisibilityGoneModifierNode>() {

    override fun create() = SushiVisibilityGoneModifierNode(
        enabled = enabled
    )

    override fun update(node: SushiVisibilityGoneModifierNode) {
        node.updateNode(
            enabled = enabled
        )
    }
}

/**
 * Node implementation for the visibility gone modifier.
 */
private class SushiVisibilityGoneModifierNode(
    private var enabled: Boolean
) : Modifier.Node(), LayoutModifierNode {
    init {
        updateNode(
            enabled = enabled
        )
    }

    fun updateNode(
        enabled: Boolean
    ) {
        this.enabled = enabled
    }

    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints
    ): MeasureResult {
        val placeable = measurable.measure(constraints)
        return layout(
            if (enabled) 0 else placeable.width,
            if (enabled) 0 else placeable.height
        ) {
            if (!enabled) {
                placeable.placeRelative(0, 0)
            }
        }
    }
}

@SushiPreview
@Composable
private fun VisibilityGonePreview1() {
    SushiPreview {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            val show = remember { mutableStateOf(true) }
            SushiButton(
                SushiButtonProps(
                    text = "Button"
                ),
                onClick = {
                    show.value = false
                },
                Modifier
                    .visibilityGone(enabled = !show.value)
            )
            SushiText(
                SushiTextProps(text =
                    if (show.value) {
                        "Click button to make it Gone visibility"
                    } else {
                        "Click this text to make the button visible again"
                    }
                ),
                onClick = {
                    show.value = true
                }
            )
        }
    }
}