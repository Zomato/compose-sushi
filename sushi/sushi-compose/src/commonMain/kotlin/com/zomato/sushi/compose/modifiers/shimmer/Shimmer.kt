package com.zomato.sushi.compose.modifiers.shimmer

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import kotlin.jvm.JvmInline
import kotlin.math.PI
import kotlin.math.sqrt
import kotlin.math.tan

/**
 * Provides shimmer effect modifiers for Sushi components.
 * 
 * Shimmer effects are animated gradient overlays commonly used as loading indicators
 * or to create visual interest. This implementation supports two main types of shimmer:
 * overlay (which adds a shimmer on top of content) and filled (which replaces content
 * with a shimmer placeholder).
 *
 * @author gupta.anirudh@zomato.com
 */

/**
 * Defines the type of shimmer effect to apply.
 */
sealed interface SushiShimmerType {
    /**
     * A shimmer effect that replaces the composable content with a colored shape.
     * 
     * This type is useful for creating placeholder shimmer loaders where the content
     * is hidden and replaced with a shimmer animation on a solid background.
     *
     * @property shape The shape to use for the shimmer effect
     * @property shapeColor The background color of the shape
     * @property color The color of the shimmer animation
     */
    data class Filled(
        val shape: Shape = RoundedCornerShape(20.dp),
        val shapeColor: Color,
        val color: Color
    ) : SushiShimmerType

    /**
     * A shimmer effect that overlays the composable content.
     * 
     * This type maintains the original content visibility but applies 
     * a shimmer animation over it, clipped to the specified shape.
     *
     * @property color The color of the shimmer animation
     * @property shape The shape to clip the shimmer effect to
     */
    data class Overlay(
        val color: Color,
        val shape: Shape
    ) : SushiShimmerType
}

/**
 * Defines how the shimmer animation progresses.
 */
sealed interface SushiShimmerProgress {
    /**
     * Automatically animates the shimmer effect in a continuous loop.
     *
     * @property duration Duration of a full shimmer animation cycle in milliseconds
     */
    data class Auto(
        val duration: Long  // in ms
    ) : SushiShimmerProgress

    /**
     * Allows manual control of the shimmer animation progress.
     * 
     * This is useful for synchronizing shimmer effects with other animations
     * or creating custom animation patterns.
     *
     * @property valueProvider Function that returns the current progress value (0.0 to 1.0)
     */
    @JvmInline value class Progress(val valueProvider: () -> Float) : SushiShimmerProgress
}

/**
 * Default values for shimmer modifiers.
 */
object SushiShimmerDefaults {
    /** Default shimmer type - overlay with white shimmer on a rectangle shape */
    val type = SushiShimmerType.Overlay(Color.White, RectangleShape)
    
    /** Default shimmer progress - automatic animation with 1000ms duration */
    val progress = SushiShimmerProgress.Auto(duration = 1000)
}

/**
 * Applies a shimmer effect to a composable.
 * 
 * The shimmer effect creates an animated gradient that moves across the composable,
 * commonly used to indicate loading states. The effect can either overlay the content
 * or replace it entirely with a placeholder.
 *
 * @param enabled Whether the shimmer effect is enabled
 * @param type The type of shimmer effect to apply (overlay or filled)
 * @param progress How the shimmer animation should progress (auto or manually controlled)
 * @param disableInteractions Whether to disable pointer interactions when shimmer is enabled
 * @param enableTransition Whether to animate a fade in/out when [enabled] changes
 * @param transitionDuration Duration of the fade in/out animation in milliseconds (only used when [enableTransition] is true)
 * @return A modifier with the shimmer effect applied
 */
fun Modifier.shimmer(
    enabled: Boolean,
    type: SushiShimmerType = SushiShimmerDefaults.type,
    progress: SushiShimmerProgress = SushiShimmerDefaults.progress,
    disableInteractions: Boolean = true,
    enableTransition: Boolean = false,
    transitionDuration: Int = 300
): Modifier = this.then(
    SushiShimmerModifierNodeElement(
        enabled = enabled,
        type = type,
        progress = progress,
        disableInteractions = disableInteractions,
        enableTransition = enableTransition,
        transitionDuration = transitionDuration
    )
)

private data class SushiShimmerModifierNodeElement(
    val enabled: Boolean,
    val type: SushiShimmerType,
    val progress: SushiShimmerProgress,
    val disableInteractions: Boolean,
    val enableTransition: Boolean,
    val transitionDuration: Int
): ModifierNodeElement<SushiShimmerModifierNode>() {

    override fun create() = SushiShimmerModifierNode(
        enabled = enabled,
        type = type,
        progress = progress,
        disableInteractions = disableInteractions,
        enableTransition = enableTransition,
        transitionDuration = transitionDuration
    )

    override fun update(node: SushiShimmerModifierNode) {
        node.updateNode(
            enabled = enabled,
            type = type,
            progress = progress,
            disableInteractions = disableInteractions,
            enableTransition = enableTransition,
            transitionDuration = transitionDuration
        )
    }
}

private class SushiShimmerModifierNode(
    private var enabled: Boolean,
    private var type: SushiShimmerType,
    private var progress: SushiShimmerProgress,
    private var disableInteractions: Boolean,
    private var enableTransition: Boolean,
    private var transitionDuration: Int
) : Modifier.Node(), DrawModifierNode, PointerInputModifierNode {

    private val currentProgress = Animatable(0f)

    /**
     * Drives the fade in/out when [enableTransition] is true.
     * Starts at 1f when shimmer is initially enabled, 0f otherwise —
     * so there is no fade animation on first composition.
     */
    private val shimmerAlpha = Animatable(if (enabled) 1f else 0f)

    private var progressUpdateJob: Job? = null
    private var alphaTransitionJob: Job? = null

    init {
        // Propagate initial state; coroutine work is deferred until onAttach.
        updateNode(
            enabled = enabled,
            type = type,
            progress = progress,
            disableInteractions = disableInteractions,
            enableTransition = enableTransition,
            transitionDuration = transitionDuration
        )
    }

    fun updateNode(
        enabled: Boolean,
        type: SushiShimmerType,
        progress: SushiShimmerProgress,
        disableInteractions: Boolean,
        enableTransition: Boolean,
        transitionDuration: Int
    ) {
        val enabledChanged = this.enabled != enabled
        this.enabled = enabled
        this.type = type
        this.progress = progress
        this.disableInteractions = disableInteractions
        this.enableTransition = enableTransition
        this.transitionDuration = transitionDuration

        if (isAttached) {
            initProgressUpdate()
            handleEnabledChange(enabledChanged)
        }
    }

    override fun onAttach() {
        super.onAttach()
        initProgressUpdate()
    }

    /**
     * Handles fade in/out animation when [enabled] toggles.
     * - Fade-in (false→true): start shimmer progress immediately so it is
     *   already moving as the overlay fades in.
     * - Fade-out (true→false): animate alpha to 0, then cancel shimmer progress
     *   so drawing stops only after the fade completes.
     */
    private fun handleEnabledChange(enabledChanged: Boolean) {
        if (!enabledChanged) {
            return
        }
        alphaTransitionJob?.cancel()
        if (enabled) {
            alphaTransitionJob = coroutineScope.launch {
                if (enableTransition) {
                    shimmerAlpha.animateTo(1f, tween(transitionDuration))
                } else {
                    shimmerAlpha.snapTo(1f)
                }
            }
        } else {
            alphaTransitionJob = coroutineScope.launch {
                if (enableTransition) {
                    shimmerAlpha.animateTo(0f, tween(transitionDuration))
                } else {
                    shimmerAlpha.snapTo(0f)
                }
            }
        }
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
                        currentProgress.snapTo(progress.valueProvider.invoke())
                        yield()
                        delay(1)    // Small delay to avoid blocking other operations
                    }
                }
            }
        }
    }

    override fun ContentDrawScope.draw() {
        val alpha = shimmerAlpha.value

        // Nothing to draw for the shimmer layer — render content as-is.
        if (alpha <= 0f) {
            drawContent()
            return
        }

        when (val type = type) {
            is SushiShimmerType.Filled -> {
                // Cross-fade: draw the real content underneath at the inverse alpha so
                // it becomes fully visible exactly as the filled placeholder disappears.
                if (alpha < 1f) {
                    drawContext.canvas.saveLayer(
                        bounds = Rect(Offset.Zero, size),
                        paint = Paint().apply { this.alpha = 1f - alpha }
                    )
                    drawContent()
                    drawContext.canvas.restore()
                }
                drawFilled(type, alpha)
            }
            is SushiShimmerType.Overlay -> drawContent()
        }
        val color = when (val type = type) {
            is SushiShimmerType.Filled -> type.color
            is SushiShimmerType.Overlay -> type.color
        }
        val clipShape = when (val type = type) {
            is SushiShimmerType.Filled -> type.shape
            is SushiShimmerType.Overlay -> type.shape
        }
        drawShimmer(currentProgress.value, color, Color.Transparent, clipShape, alpha = alpha)
    }

    private fun DrawScope.drawShimmer(
        progress: Float, 
        shimmerColor: Color,
        baseColor: Color,
        clipShape: Shape,
        angleInDegrees: Float = 10f,
        alpha: Float = 1f
    ) {
        // Clamp progress between 0f and 1f
        val clampedProgress = progress.coerceIn(0f, 1f)

        // Angle of the shimmer in radians
        val angleInRadians = toRadians(angleInDegrees.toDouble())

        // Canvas diagonal length to cover the entire shimmer movement
        val canvasDiagonal = sqrt(size.width * size.width + size.height * size.height)
        val shimmerWidth = canvasDiagonal * 0.3f // Adjust the width as needed

        // Calculate shimmer position based on progress
        val totalWidth = size.width + shimmerWidth
        val shimmerStartX = -shimmerWidth + totalWidth * clampedProgress
        val shimmerEndX = shimmerStartX + shimmerWidth

        // Scale shimmer colors by the current alpha for smooth fade in/out.
        val fadedShimmerColor = shimmerColor.copy(alpha = shimmerColor.alpha * alpha)
        val fadedBaseColor = baseColor.copy(alpha = baseColor.alpha * alpha)

        // Brush for shimmer gradient
        val shimmerBrush = Brush.linearGradient(
            colors = listOf(fadedBaseColor, fadedShimmerColor, fadedBaseColor),
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

    private fun toRadians(degrees: Double): Double = degrees * (PI / 180.0)

    private fun ContentDrawScope.drawFilled(props: SushiShimmerType.Filled, alpha: Float = 1f) {
        val size = Size(size.width, size.height)
        val outline = props.shape.createOutline(
            size = size,
            layoutDirection = layoutDirection,
            density = this
        )
        drawOutline(
            outline = outline,
            color = props.shapeColor.copy(alpha = props.shapeColor.alpha * alpha),
            style = Fill
        )
    }

    override fun onCancelPointerInput() {
        // no-op
    }

    override fun onPointerEvent(pointerEvent: PointerEvent, pass: PointerEventPass, bounds: IntSize) {
        // Block interactions whenever shimmer is at least partially visible.
        if (shimmerAlpha.value > 0f && disableInteractions) {
            pointerEvent.changes.forEach { it.consume() }
        }
    }
}

@SushiPreview
@Composable
private fun ShimmerPreview1() {
    SushiPreview {
        var enabled by remember {
            mutableStateOf(true)
        }
        LaunchedEffect(Unit) {
            while (true) {
                delay(4000)
                enabled = !enabled
            }
        }
        SushiButton(
            SushiButtonProps(
                text = "Shimmer Overlay"
            ),
            onClick = {

            },
            modifier = Modifier.shimmer(
                enabled = enabled,
                SushiShimmerType.Overlay(
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                ),
                enableTransition = true,
                transitionDuration = 800
            )
        )
    }
}

@SushiPreview
@Composable
private fun ShimmerPreview2() {
    SushiPreview {
        var enabled by remember {
            mutableStateOf(true)
        }
        LaunchedEffect(Unit) {
            while (true) {
                delay(4000)
                enabled = !enabled
            }
        }
        SushiButton(
            SushiButtonProps(
                text = "Shimmer Filled"
            ),
            onClick = {

            },
            modifier = Modifier.shimmer(
                enabled = enabled,
                SushiShimmerType.Filled(
                    shape = RoundedCornerShape(10.dp),
                    shapeColor = SushiRawColorTokens.Grey200,
                    color = Color.White
                ),
                enableTransition = true,
                transitionDuration = 800
            )
        )
    }
}