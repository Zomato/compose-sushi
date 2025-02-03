package com.zomato.sushi.compose.modifiers.shimmer

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.node.PointerInputModifierNode
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.foundation.SushiRawColorTokens
import com.zomato.sushi.compose.internal.SushiPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import kotlin.math.sqrt
import kotlin.math.tan

/**
 * @author gupta.anirudh@zomato.com
 */
sealed interface SushiShimmerType {
    data class Filled(
        val shape: Shape,
        val shapeColor: Color,
        val color: Color
    ) : SushiShimmerType

    data class Overlay(
        val color: Color,
        val shape: Shape
    ) : SushiShimmerType
}

sealed interface SushiShimmerProgress {
    data class Auto(
        val duration: Long  // in ms
    ) : SushiShimmerProgress

    /**
     * Value between 0..1, signifying the progress.
     */
    @JvmInline value class Progress(val valueProvider: () -> Float) : SushiShimmerProgress
}

object SushiShimmerDefaults {
    val type = SushiShimmerType.Overlay(Color.White, RectangleShape)
    val progress = SushiShimmerProgress.Auto(duration = 1000)
}

fun Modifier.shimmer(
    enabled: Boolean,
    type: SushiShimmerType = SushiShimmerDefaults.type,
    progress: SushiShimmerProgress = SushiShimmerDefaults.progress,
    disableInteractions: Boolean = true
): Modifier = this.then(
    SushiShimmerModifierNodeElement(
        enabled = enabled,
        type = type,
        progress = progress,
        disableInteractions = disableInteractions
    )
)

data class SushiShimmerModifierNodeElement(
    val enabled: Boolean,
    val type: SushiShimmerType,
    val progress: SushiShimmerProgress,
    val disableInteractions: Boolean
): ModifierNodeElement<SushiShimmerModifierNode>() {

    override fun create() = SushiShimmerModifierNode(
        enabled = enabled,
        type = type,
        progress = progress,
        disableInteractions = disableInteractions
    )

    override fun update(node: SushiShimmerModifierNode) {
        node.updateNode(
            enabled = enabled,
            type = type,
            progress = progress,
            disableInteractions = disableInteractions
        )
    }
}

class SushiShimmerModifierNode(
    private var enabled: Boolean,
    private var type: SushiShimmerType,
    private var progress: SushiShimmerProgress,
    private var disableInteractions: Boolean
) : Modifier.Node(), DrawModifierNode, PointerInputModifierNode {

    private val currentProgress = Animatable(0f)
    private var progressUpdateJob: Job? = null

    init {
        updateNode(
            enabled = enabled,
            type = type,
            progress = progress,
            disableInteractions = disableInteractions
        )
    }

    fun updateNode(
        enabled: Boolean,
        type: SushiShimmerType,
        progress: SushiShimmerProgress,
        disableInteractions: Boolean
    ) {
        this.enabled = enabled
        this.type = type
        this.progress = progress
        this.disableInteractions = disableInteractions

        if (isAttached) {
            initProgressUpdate()
        }
    }

    override fun onAttach() {
        super.onAttach()
        initProgressUpdate()
    }

    private fun initProgressUpdate() {
        progressUpdateJob?.cancel()
        if (!enabled) {
            return
        }
        progressUpdateJob = coroutineScope.launch {
            when (val progress = progress) {
                is SushiShimmerProgress.Auto -> {
                    currentProgress.animateTo(
                        1f,
                        infiniteRepeatable(tween(1000), RepeatMode.Restart)
                    )
                }
                is SushiShimmerProgress.Progress -> {
                    while (isActive) {
                        while (isActive) {
                            currentProgress.snapTo(progress.valueProvider.invoke())
                            yield() // Yield to avoid blocking other operations
                        }
                    }
                }
            }
        }
    }

    override fun ContentDrawScope.draw() {
        if (!enabled) {
            drawContent()
            return
        }

        when (val type = type) {
            is SushiShimmerType.Filled -> {
                drawFilled(type)
            }
            is SushiShimmerType.Overlay -> {
                drawContent()
            }
        }
        val color = when (val type = type) {
            is SushiShimmerType.Filled -> type.color
            is SushiShimmerType.Overlay -> type.color
        }
        val clipShape = when (val type = type) {
            is SushiShimmerType.Filled -> type.shape
            is SushiShimmerType.Overlay -> type.shape
        }
        drawShimmer(currentProgress.value, color, Color.Transparent, clipShape)
    }

    private fun DrawScope.drawShimmer(
        progress: Float, // Progress value between 0f and 1f
        shimmerColor: Color,
        baseColor: Color,
        clipShape: Shape,
        angleInDegrees: Float = 10f
    ) {
        // Clamp progress between 0f and 1f
        val clampedProgress = progress.coerceIn(0f, 1f)

        // Angle of the shimmer in radians
        val angleInRadians = Math.toRadians(angleInDegrees.toDouble())

        // Canvas diagonal length to cover the entire shimmer movement
        val canvasDiagonal = sqrt(size.width * size.width + size.height * size.height)
        val shimmerWidth = canvasDiagonal * 0.3f // Adjust the width as needed

        // Calculate shimmer position based on progress
        val totalWidth = size.width + shimmerWidth
        val shimmerStartX = -shimmerWidth + totalWidth * clampedProgress
        val shimmerEndX = shimmerStartX + shimmerWidth

        // Brush for shimmer gradient
        val shimmerBrush = Brush.linearGradient(
            colors = listOf(baseColor, shimmerColor, baseColor),
            start = Offset(shimmerStartX, 0f),
            end = Offset(
                shimmerEndX,
                tan(angleInRadians.toFloat()) * size.width
            ),
            tileMode = TileMode.Clamp
        )

        val path = when (val clipOutline = clipShape.createOutline(size, layoutDirection, Density(density))) {
            is Outline.Rectangle -> Path().apply { addRect(clipOutline.rect) }
            is Outline.Rounded -> Path().apply { addRoundRect(clipOutline.roundRect) }
            is Outline.Generic -> clipOutline.path
        }

        clipPath(path) {
            // Draw shimmer
            drawRect(brush = shimmerBrush, size = size)
        }
    }

    private fun ContentDrawScope.drawFilled(props: SushiShimmerType.Filled) {
        val size = Size(size.width, size.height)
        val outline = props.shape.createOutline(
            size = size,
            layoutDirection = layoutDirection,
            density = this
        )
        drawOutline(
            outline = outline,
            color = props.shapeColor,
            style = Fill
        )
    }

    override fun onCancelPointerInput() {
        // no-op
    }

    override fun onPointerEvent(pointerEvent: PointerEvent, pass: PointerEventPass, bounds: IntSize) {
        if (enabled && disableInteractions) {
            pointerEvent.changes.forEach { it.consume() }
        }
    }
}

@SushiPreview
@Composable
private fun ShimmerPreview1() {
    SushiPreview {
        SushiButton(
            SushiButtonProps(
                text = "Shimmer Overlay"
            ),
            onClick = {

            },
            Modifier.shimmer(
                enabled = true,
                SushiShimmerType.Overlay(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
            )
        )
    }
}

@SushiPreview
@Composable
private fun ShimmerPreview2() {
    SushiPreview {
        SushiButton(
            SushiButtonProps(
                text = "Shimmer Filled"
            ),
            onClick = {

            },
            Modifier.shimmer(
                enabled = true,
                SushiShimmerType.Filled(
                    shape = RoundedCornerShape(10.dp),
                    shapeColor = SushiRawColorTokens.Grey200,
                    color = Color.White
                )
            )
        )
    }
}