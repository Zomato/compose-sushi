package com.zomato.sushi.compose.modifiers.scaleonpress

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.node.PointerInputModifierNode
import androidx.compose.ui.node.invalidateDraw
import androidx.compose.ui.unit.IntSize
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.modifiers.invisibleIf
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Modifier that provides a scale animation when the component is pressed.
 * 
 * This creates an interactive visual feedback by slightly reducing the size of
 * the component when pressed, then returning to normal size when released.
 *
 * @author gupta.anirudh@zomato.com
 */

/**
 * Applies a scale-on-press effect to a composable.
 * 
 * When the composable is pressed, it scales down slightly to provide visual feedback,
 * then returns to its normal size when released. This creates a satisfying press effect
 * for interactive elements.
 *
 * @param enabled Whether the scale effect is enabled
 * @param delayMs Optional delay before the scale animation starts (in milliseconds)
 * @return A modifier with the scale-on-press behavior
 */
/**
 * Applies a scale-on-press effect to a composable.
 * 
 * When the composable is pressed, it scales down slightly to provide visual feedback,
 * then returns to its normal size when released. This creates a satisfying press effect
 * for interactive elements.
 *
 * @param enabled Whether the scale effect is enabled
 * @param delayMs Optional delay before the scale animation starts (in milliseconds)
 * @return A modifier with the scale-on-press behavior
 *
 * @author gupta.anirudh@zomato.com
 */
fun Modifier.scaleOnPress(
    enabled: Boolean = true,
    delayMs: Long = 0,
): Modifier = this.then(
    SushiScaleOnPressModifierNodeElement(
        enabled = enabled,
        delayMs = delayMs
    )
)

/**
 * Internal implementation details for the scale-on-press modifier.
 */
data class SushiScaleOnPressModifierNodeElement(
    val enabled: Boolean,
    val delayMs: Long
): ModifierNodeElement<SushiScaleOnPressModifierNode>() {

    override fun create() = SushiScaleOnPressModifierNode(
        enabled = enabled,
        delayMs = delayMs
    )

    override fun update(node: SushiScaleOnPressModifierNode) {
        node.updateNode(
            enabled = enabled,
            delayMs = delayMs
        )
    }
}

/**
 * Node implementation for the scale-on-press modifier that handles
 * the animation and pointer input logic.
 */
class SushiScaleOnPressModifierNode(
    private var enabled: Boolean,
    private var delayMs: Long
) : Modifier.Node(), DrawModifierNode, PointerInputModifierNode {

    private val actualScale = Animatable(1f)
    private var scaleAnimateJob: Job? = null
    private var pressedScale: Float = 1f
    private var isPressed: Boolean = false
        set(value) {
            field = value
            animateScale()
        }

    init {
        updateNode(
            enabled = enabled,
            delayMs = delayMs
        )
    }

    fun updateNode(
        enabled: Boolean,
        delayMs: Long
    ) {
        this.enabled = enabled
        this.delayMs = delayMs
    }

    override fun onAttach() {
        super.onAttach()
    }

    private fun animateScale() {
        if (!isAttached) {
            scaleAnimateJob?.cancel()
            return
        }
        if (isPressed) {
            scaleAnimateJob?.cancel()
            scaleAnimateJob = coroutineScope.launch {
                delay(delayMs)
                actualScale.animateTo(pressedScale, spring())
            }
        } else {
            scaleAnimateJob?.cancel()
            scaleAnimateJob = coroutineScope.launch {
                actualScale.animateTo(
                    1f
                )
            }
        }
    }

    override fun ContentDrawScope.draw() {
        pressedScale = 1f - (0.05f * this.size.maxDimension) / this.size.maxDimension
        when {
            !enabled -> drawContent()
            isPressed -> scale(actualScale.value, actualScale.value, center) {
                this@draw.drawContent()
            }
            else -> {
                drawContent()
            }
        }
    }

    override fun onCancelPointerInput() {
        isPressed = false
        invalidateDraw()
    }

    override fun onPointerEvent(pointerEvent: PointerEvent, pass: PointerEventPass, bounds: IntSize) {
        if (pass == PointerEventPass.Main) {
            when (pointerEvent.type) {
                PointerEventType.Press -> {
                    isPressed = true
                    invalidateDraw()
                }

                PointerEventType.Move -> {
                    isPressed = false
                    invalidateDraw()
                }

                PointerEventType.Scroll -> {
                    isPressed = false
                    invalidateDraw()
                }

                PointerEventType.Release -> {
                    isPressed = false
                    invalidateDraw()
                }
            }
        }
    }

    override fun onDetach() {
        isPressed = false
        invalidateDraw()
    }
}

@SushiPreview
@Composable
private fun ScaleOnPressPreview1() {
    SushiPreview {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            val show = remember { mutableStateOf(false) }
            SushiButton(
                SushiButtonProps(
                    text = "Scaling Sample"
                ),
                onClick = {
                    show.value = true
                },
                Modifier
                    .scaleOnPress(enabled = true)
            )
            if (show.value) {
                SushiText(
                    SushiTextProps(text = "Click working :)"),
                    Modifier.invisibleIf(!show.value)
                )
            }
        }
    }
}