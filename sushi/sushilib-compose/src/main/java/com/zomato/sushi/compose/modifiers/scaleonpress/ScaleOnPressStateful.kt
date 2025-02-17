package com.zomato.sushi.compose.modifiers.scaleonpress

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
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
import com.zomato.sushi.compose.internal.SushiPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author gupta.anirudh@zomato.com
 */

@Composable
fun rememberScaleOnPressState(
    initialIsPressed: Boolean = false
): MutableState<ScaleOnPressState> {
    return remember {
        mutableStateOf(
            ScaleOnPressState(
                isCurrentlyPressed = mutableStateOf(initialIsPressed)
            )
        )
    }
}

data class ScaleOnPressState(
    val isCurrentlyPressed: MutableState<Boolean>
)

fun Modifier.scaleOnPress(
    state: ScaleOnPressState,
    delayMs: Long = 0,
): Modifier = this.then(
    SushiScaleOnPressStatefulModifierNodeElement(
        state = state,
        delayMs = delayMs
    )
)

fun Modifier.scaleOnPressAnchor(
    state: ScaleOnPressState
): Modifier = this.then(
    SushiScaleOnPressStatefulAnchorModifierNodeElement(
        state = state
    )
)

data class SushiScaleOnPressStatefulModifierNodeElement(
    val state: ScaleOnPressState,
    val delayMs: Long
): ModifierNodeElement<SushiScaleOnPressStatefulModifierNode>() {

    override fun create() = SushiScaleOnPressStatefulModifierNode(
        state = state,
        delayMs = delayMs
    )

    override fun update(node: SushiScaleOnPressStatefulModifierNode) {
        node.updateNode(
            state = state,
            delayMs = delayMs
        )
    }
}

class SushiScaleOnPressStatefulModifierNode(
    private var state: ScaleOnPressState,
    private var delayMs: Long
) : Modifier.Node(), DrawModifierNode {

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
            state = state,
            delayMs = delayMs
        )
    }

    fun updateNode(
        state: ScaleOnPressState,
        delayMs: Long
    ) {
        this.state = state
        this.delayMs = delayMs
    }

    override fun onAttach() {
        super.onAttach()
        coroutineScope.launch {
            snapshotFlow { state.isCurrentlyPressed.value }
                .collect {
                    isPressed = it
                }
        }
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
                actualScale.animateTo(pressedScale, spring()) {
                    invalidateDraw()
                }
            }
        } else {
            scaleAnimateJob?.cancel()
            scaleAnimateJob = coroutineScope.launch {
                actualScale.animateTo(
                    1f
                ) {
                    invalidateDraw()
                }
            }
        }
    }

    override fun ContentDrawScope.draw() {
        pressedScale = 1f - (0.05f * this.size.maxDimension) / this.size.maxDimension
        when {
            isPressed -> scale(actualScale.value, actualScale.value, center) {
                this@draw.drawContent()
            }
            else -> {
                drawContent()
            }
        }
    }
}

data class SushiScaleOnPressStatefulAnchorModifierNodeElement(
    val state: ScaleOnPressState
): ModifierNodeElement<SushiScaleOnPressStatefulAnchorModifierNode>() {

    override fun create() = SushiScaleOnPressStatefulAnchorModifierNode(
        state = state
    )

    override fun update(node: SushiScaleOnPressStatefulAnchorModifierNode) {
        node.updateNode(
            state = state
        )
    }
}

class SushiScaleOnPressStatefulAnchorModifierNode(
    private var state: ScaleOnPressState
) : Modifier.Node(), PointerInputModifierNode {

    private var isPressed: Boolean = state.isCurrentlyPressed.value
        set(value) {
            field = value
            state.isCurrentlyPressed.value = value
        }

    init {
        updateNode(
            state = state
        )
    }

    fun updateNode(
        state: ScaleOnPressState
    ) {
        this.state = state
    }

    override fun onAttach() {
        super.onAttach()
    }

    override fun onCancelPointerInput() {
        isPressed = false
    }

    override fun onPointerEvent(pointerEvent: PointerEvent, pass: PointerEventPass, bounds: IntSize) {
        if (pass == PointerEventPass.Main) {
            when (pointerEvent.type) {
                PointerEventType.Press -> {
                    isPressed = true
                }

                PointerEventType.Move -> {
                    isPressed = false
                }

                PointerEventType.Scroll -> {
                    isPressed = false
                }

                PointerEventType.Release -> {
                    isPressed = false
                }
            }
        }
    }

    override fun onDetach() {
        isPressed = false
    }
}

@SushiPreview
@Composable
private fun ScaleOnPressPreview1() {
    SushiPreview {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            val scaleOnPressState by rememberScaleOnPressState()
            SushiButton(
                SushiButtonProps(
                    text = "1st Button will be Scaled"
                ),
                onClick = {

                },
                Modifier
                    .scaleOnPress(scaleOnPressState)
            )
            SushiButton(
                SushiButtonProps(
                    text = "2nd Button will be Scaled"
                ),
                onClick = {

                },
                Modifier
                    .scaleOnPress(scaleOnPressState)
            )
            SushiButton(
                SushiButtonProps(
                    text = "Anchor Button"
                ),
                onClick = {

                },
                Modifier
                    .scaleOnPressAnchor(scaleOnPressState)
            )
        }
    }
}