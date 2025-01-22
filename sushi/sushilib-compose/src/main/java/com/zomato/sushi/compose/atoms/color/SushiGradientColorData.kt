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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.SushiGradientColorData.LinearDirection.BottomLeftToTopRight
import com.zomato.sushi.compose.atoms.color.SushiGradientColorData.LinearDirection.BottomRightToTopLeft
import com.zomato.sushi.compose.atoms.color.SushiGradientColorData.LinearDirection.BottomToTop
import com.zomato.sushi.compose.atoms.color.SushiGradientColorData.LinearDirection.LeftToRight
import com.zomato.sushi.compose.atoms.color.SushiGradientColorData.LinearDirection.RightToLeft
import com.zomato.sushi.compose.atoms.color.SushiGradientColorData.LinearDirection.TopLeftToBottomRight
import com.zomato.sushi.compose.atoms.color.SushiGradientColorData.LinearDirection.TopRightToBottomLeft
import com.zomato.sushi.compose.atoms.color.SushiGradientColorData.LinearDirection.TopToBottom
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.internal.SushiPreview
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

/**
 * @author gupta.anirudh@zomato.com
 */

@Immutable
data class SushiGradientColorData(
    val colors: PersistentList<ColorSpec> = persistentListOf(),
    val shape: Shape? = null,
    val strokeColor: ColorSpec? = null,
    val strokeWidth: Dp? = null,
    val type: GradientType? = null
) {
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

    sealed interface GradientType {
        @Immutable
        data class Linear(
            val direction: LinearDirection? = null,
            val size: Size? = null,
            val tileMode: TileMode? = null
        ) : GradientType

        @Immutable
        data class Radial(
            val center: Offset? = null,
            val radius: Float? = null,
            val tileMode: TileMode? = null
        ) : GradientType

        @Immutable
        data class Sweep(
            val center: Offset? = null
        ) : GradientType
    }
}

private val Size.Companion.Infinite: Size get() = Size(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)

val defaultLinearDirection: SushiGradientColorData.LinearDirection = SushiGradientColorData.LinearDirection.LeftToRight

@Composable
fun SushiGradientColorData.toBrush(
    defaultTileMode: TileMode = TileMode.Clamp,
    defaultGradientType: SushiGradientColorData.GradientType = SushiGradientColorData.GradientType.Linear(defaultLinearDirection)
): Brush {
    val colors = colors.map { it.value }.toList()

    return remember(this, defaultGradientType, colors) {
        when (val type = this.type ?: defaultGradientType) {
            is SushiGradientColorData.GradientType.Linear -> {
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
            is SushiGradientColorData.GradientType.Radial -> {
                val tileMode = type.tileMode ?: defaultTileMode

                Brush.radialGradient(
                    colors = colors,
                    center = type.center ?: Offset.Unspecified,
                    radius = type.radius ?: Float.POSITIVE_INFINITY,
                    tileMode = tileMode
                )
            }
            is SushiGradientColorData.GradientType.Sweep -> {
                Brush.sweepGradient(
                    colors = colors,
                    center = type.center ?: Offset.Unspecified
                )
            }
        }
    }
}

fun SushiGradientColorData.LinearDirection.startOffset(size: Size): Offset = when (this) {
    TopToBottom -> Offset(size.width / 2, 0f)
    TopRightToBottomLeft -> Offset(size.width, 0f)
    RightToLeft -> Offset(size.width, size.height / 2)
    BottomRightToTopLeft -> Offset(size.width, size.height)
    BottomToTop -> Offset(size.width / 2, size.height)
    BottomLeftToTopRight -> Offset(0f, size.height)
    LeftToRight -> Offset(0f, size.height / 2)
    TopLeftToBottomRight -> Offset(0f, 0f)
}

fun SushiGradientColorData.LinearDirection.endOffset(size: Size): Offset = when (this) {
    TopToBottom -> Offset(size.width / 2, size.height)
    TopRightToBottomLeft -> Offset(0f, size.height)
    RightToLeft -> Offset(0f, size.height / 2)
    BottomRightToTopLeft -> Offset(0f, 0f)
    BottomToTop -> Offset(size.width / 2, 0f)
    BottomLeftToTopRight -> Offset(size.width, 0f)
    LeftToRight -> Offset(size.width, size.height / 2)
    TopLeftToBottomRight -> Offset(size.width, size.height)
}

@SushiPreview
@Composable
private fun SushiGradientPreview() {
    Preview {
        Column {
            val colors = persistentListOf(Color.Transparent.asColorSpec(), Color.Red.asColorSpec(), Color.Blue.asColorSpec(), Color.Green.asColorSpec())
            val sweepGradientData = SushiGradientColorData(
                colors = colors,
                type = SushiGradientColorData.GradientType.Sweep()
            )
            Box(Modifier
                .background(sweepGradientData.toBrush())
                .size(200.dp)
            )
            val radialGradient = SushiGradientColorData(
                colors = colors,
                type = SushiGradientColorData.GradientType.Radial()
            )
            Box(Modifier
                .background(radialGradient.toBrush())
                .size(200.dp)
            )
            val linearGradientData = SushiGradientColorData(
                colors = colors,
                type = SushiGradientColorData.GradientType.Linear(
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