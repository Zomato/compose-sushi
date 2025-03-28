package com.zomato.sushi.compose.foundation

import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.node.DelegatableNode
import androidx.compose.ui.node.DrawModifierNode

/**
 * Creates an indication that doesn't draw any visual feedback for interactions.
 * 
 * This is useful when you want to disable the default ripple effect or other indications
 * that are provided by Material components, while still maintaining the interaction
 * functionality.
 * 
 * @return An IndicationNodeFactory that doesn't produce any visual effects
 */
@Stable
fun noIndication(): IndicationNodeFactory {
    return NoIndicationNodeFactory
}

/**
 * Implementation of a no-op indication factory that doesn't draw any visual feedback.
 * This factory simply draws the content without adding any indication effects.
 */
private data object NoIndicationNodeFactory : IndicationNodeFactory {
    override fun create(interactionSource: InteractionSource): DelegatableNode {
        return object : Modifier.Node(), DrawModifierNode {
            override fun ContentDrawScope.draw() {
                drawContent()
            }
        }
    }
}