package com.zomato.sushi.compose.atoms.color

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.SushiGradientColorSpec.LinearDirection.BottomLeftToTopRight
import com.zomato.sushi.compose.atoms.color.SushiGradientColorSpec.LinearDirection.BottomRightToTopLeft
import com.zomato.sushi.compose.atoms.color.SushiGradientColorSpec.LinearDirection.BottomToTop
import com.zomato.sushi.compose.atoms.color.SushiGradientColorSpec.LinearDirection.LeftToRight
import com.zomato.sushi.compose.atoms.color.SushiGradientColorSpec.LinearDirection.RightToLeft
import com.zomato.sushi.compose.atoms.color.SushiGradientColorSpec.LinearDirection.TopLeftToBottomRight
import com.zomato.sushi.compose.atoms.color.SushiGradientColorSpec.LinearDirection.TopRightToBottomLeft
import com.zomato.sushi.compose.atoms.color.SushiGradientColorSpec.LinearDirection.TopToBottom
import com.zomato.sushi.compose.internal.SushiPreview
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

/**
 * Configuration for creating gradient colors in the Sushi design system.
 * 
 * SushiGradientColorData provides a way to define gradient colors with various types
 * (linear, radial, sweep) and configurations. It can be converted to a Compose Brush
 * for use with background or other drawing operations.
 *
 * @property colors List of colors to use in the gradient
 * @property type Type of gradient (Linear, Radial, or Sweep) and its configuration
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiGradientColorSpec(
    val colors: PersistentList<ColorSpec> = persistentListOf(),
    val type: GradientType? = null
) {
    /**
     * Defines the direction for linear gradients.
     * Each direction specifies a start point and end point for the gradient.
     */
    enum class LinearDirection {
        TopToBottom,
        TopRightToBottomLeft,
        RightToLeft,
        BottomRightToTopLeft,
        BottomToTop,
        BottomLeftToTopRight,
        LeftToRight,
        TopLeftToBottomRight
    }

    /**
     * Defines the types of gradients supported by SushiGradientColorData.
     */
    sealed interface GradientType {
        /**
         * Linear gradient configuration.
         *
         * @property direction The direction of the gradient
         * @property size Optional size to calculate gradient endpoints
         * @property tileMode How the gradient should repeat
         */
        @Immutable
        data class Linear(
            val direction: LinearDirection? = null,
            val size: Size? = null,
            val tileMode: TileMode? = null
        ) : GradientType

        /**
         * Radial gradient configuration.
         *
         * @property center Center point of the gradient
         * @property radius Radius of the gradient
         * @property tileMode How the gradient should repeat
         */
        @Immutable
        data class Radial(
            val center: Offset? = null,
            val radius: Float? = null,
            val tileMode: TileMode? = null
        ) : GradientType

        /**
         * Sweep gradient (also known as angular or conical gradient) configuration.
         *
         * @property center Center point of the gradient
         */
        @Immutable
        data class Sweep(
            val center: Offset? = null
        ) : GradientType
    }
}

/**
 * A Size with infinite dimensions, used as a default for gradient calculations.
 */
private val Size.Companion.Infinite: Size get() = Size(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)

/**
 * Default direction for linear gradients.
 */
val defaultLinearDirection: SushiGradientColorSpec.LinearDirection = SushiGradientColorSpec.LinearDirection.LeftToRight

/**
 * Converts a SushiGradientColorData to a Compose Brush that can be used for drawing.
 *
 * @param defaultTileMode The default tile mode to use if not specified in the gradient type
 * @param defaultGradientType The default gradient type to use if not specified in the SushiGradientColorData
 * @return A Compose Brush representing the gradient
 */
@Composable
fun SushiGradientColorSpec.toBrush(
    defaultTileMode: TileMode = TileMode.Clamp,
    defaultGradientType: SushiGradientColorSpec.GradientType = SushiGradientColorSpec.GradientType.Linear(defaultLinearDirection)
): Brush {
    val colors = colors.map { it.value }.toList()

    return remember(this, defaultGradientType, colors) {
        when (val type = this.type ?: defaultGradientType) {
            is SushiGradientColorSpec.GradientType.Linear -> {
                val direction = type.direction ?: defaultLinearDirection
                val startOffset = direction.startOffset(type.size ?: Size.Infinite)
                val endOffset = direction.endOffset(type.size ?: Size.Infinite)
                val tileMode = type.tileMode ?: defaultTileMode

                if (colors.size < 2) {
                    Brush.linearGradient(
                        colors = listOf(colors.first(), colors.first()),
                        start = Offset.Zero,
                        end = Offset.Zero,
                        tileMode = tileMode
                    )
                } else {
                    Brush.linearGradient(
                        colors = colors,
                        start = startOffset,
                        end = endOffset,
                        tileMode = tileMode
                    )
                }
            }
            is SushiGradientColorSpec.GradientType.Radial -> {
                val tileMode = type.tileMode ?: defaultTileMode

                Brush.radialGradient(
                    colors = colors,
                    center = type.center ?: Offset.Unspecified,
                    radius = type.radius ?: Float.POSITIVE_INFINITY,
                    tileMode = tileMode
                )
            }
            is SushiGradientColorSpec.GradientType.Sweep -> {
                Brush.sweepGradient(
                    colors = colors,
                    center = type.center ?: Offset.Unspecified
                )
            }
        }
    }
}

/**
 * Calculates the start offset for a linear gradient based on the direction and size.
 *
 * @param size The size to use for calculating coordinates
 * @return The start offset for the gradient
 */
fun SushiGradientColorSpec.LinearDirection.startOffset(size: Size): Offset = when (this) {
    TopToBottom -> Offset(size.width / 2, 0f)
    TopRightToBottomLeft -> Offset(size.width, 0f)
    RightToLeft -> Offset(size.width, size.height / 2)
    BottomRightToTopLeft -> Offset(size.width, size.height)
    BottomToTop -> Offset(size.width / 2, size.height)
    BottomLeftToTopRight -> Offset(0f, size.height)
    LeftToRight -> Offset(0f, size.height / 2)
    TopLeftToBottomRight -> Offset(0f, 0f)
}

/**
 * Calculates the end offset for a linear gradient based on the direction and size.
 *
 * @param size The size to use for calculating coordinates
 * @return The end offset for the gradient
 */
fun SushiGradientColorSpec.LinearDirection.endOffset(size: Size): Offset = when (this) {
    TopToBottom -> Offset(size.width / 2, size.height)
    TopRightToBottomLeft -> Offset(0f, size.height)
    RightToLeft -> Offset(0f, size.height / 2)
    BottomRightToTopLeft -> Offset(0f, 0f)
    BottomToTop -> Offset(size.width / 2, 0f)
    BottomLeftToTopRight -> Offset(size.width, 0f)
    LeftToRight -> Offset(size.width, size.height / 2)
    TopLeftToBottomRight -> Offset(size.width, size.height)
}

/**
 * Converts ColorSpec to SushiGradientColorSpec
 *
 * @param size The size to use for calculating coordinates
 * @return The end offset for the gradient
 */
fun ColorSpec.toSushiGradientColorData(): SushiGradientColorSpec {
    return SushiGradientColorSpec(persistentListOf(this))
}

@SushiPreview
@Composable
private fun SushiGradientPreview() {
    SushiPreview {
        Column {
            val colors = persistentListOf(Color.Transparent.asColorSpec(), Color.Red.asColorSpec(), Color.Blue.asColorSpec(), Color.Green.asColorSpec())
            val sweepGradientData = SushiGradientColorSpec(
                colors = colors,
                type = SushiGradientColorSpec.GradientType.Sweep()
            )
            Box(Modifier
                .background(sweepGradientData.toBrush())
                .size(200.dp)
            )
            val radialGradient = SushiGradientColorSpec(
                colors = colors,
                type = SushiGradientColorSpec.GradientType.Radial()
            )
            Box(Modifier
                .background(radialGradient.toBrush())
                .size(200.dp)
            )
            val linearGradientData = SushiGradientColorSpec(
                colors = colors,
                type = SushiGradientColorSpec.GradientType.Linear(
                    direction = TopLeftToBottomRight
                )
            )
            Box(Modifier
                .background(linearGradientData.toBrush())
                .size(200.dp)
            )
        }
    }
}