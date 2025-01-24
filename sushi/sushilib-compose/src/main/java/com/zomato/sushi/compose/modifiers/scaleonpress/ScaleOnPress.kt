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
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.modifiers.invisibleIf
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author gupta.anirudh@zomato.com
 */

fun Modifier.scaleOnPress(
    enabled: Boolean = true
): Modifier = this.then(
    SushiScaleOnPressModifierNodeElement(
        enabled = enabled
    )
)

data class SushiScaleOnPressModifierNodeElement(
    val enabled: Boolean
): ModifierNodeElement<SushiScaleOnPressModifierNode>() {

    override fun create() = SushiScaleOnPressModifierNode(
        enabled = enabled
    )

    override fun update(node: SushiScaleOnPressModifierNode) {
        node.updateNode(
            enabled = enabled
        )
    }
}

class SushiScaleOnPressModifierNode(
    private var enabled: Boolean
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
            enabled = enabled
        )
    }

    fun updateNode(
        enabled: Boolean
    ) {
        this.enabled = enabled
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
                delay(250)
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
    Preview {
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