package com.zomato.sushi.compose.atoms.indicators.type

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.zomato.sushi.compose.atoms.indicators.Dot
import com.zomato.sushi.compose.atoms.indicators.model.DotGraphic
import kotlin.math.abs
import kotlin.math.absoluteValue

/**
 * @author gupta.anirudh@zomato.com
 */
@Composable
internal fun ShiftIndicator(
    offsetProvider: () -> Float,
    dotCount: Int,
    dotSpacing: Dp,
    onDotClicked: ((Int) -> Unit)?,
    modifier: Modifier = Modifier,
    selectedDotsGraphic: DotGraphic? = null,
    dotsGraphic: DotGraphic = DotGraphic(),
    shiftSizeFactor: Float = 3f,
    currentFillProgressProvider: (() -> Float)? = null,
    fillProgressColor: Color = Color.Unspecified,
) {
    Box(modifier = modifier) {
        Row(
            Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(
                dotSpacing, alignment = Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val currentDotIndex by remember(offsetProvider()) {
                derivedStateOf {
                    offsetProvider().toInt()
                }
            }
            repeat(dotCount) { dotIndex ->
                val dotWidth by remember(offsetProvider()) {
                    derivedStateOf {
                        computeDotWidth(dotIndex, offsetProvider(), dotsGraphic, shiftSizeFactor)
                    }
                }
                val finalDotGraphic = when {
//                    selectedDotsGraphic != null && selectedDotsGraphic != dotsGraphic -> {
//                        remember {
//                            derivedStateOf {
//                                interpolateDotGraphic(
//                                    selected = selectedDotsGraphic,
//                                    unselected = dotsGraphic,
//                                    currentDotIndex = currentDotIndex,
//                                    globalOffset = offsetProvider()
//                                )
//                            }
//                        }.value
//                    }
                    currentDotIndex == dotIndex -> {
                        selectedDotsGraphic ?: dotsGraphic
                    }
                    else -> {
                        dotsGraphic
                    }
                }
                Box {
                    Dot(
                        finalDotGraphic,
                        Modifier
                            .clip(dotsGraphic.shape)
                            .drawWithContent {
                                drawContent()

                                if (currentDotIndex == dotIndex && currentFillProgressProvider != null) {
                                    val progress = currentFillProgressProvider()
                                    val progressWidth = size.width * progress

                                    val borderSize = 1.dp.toPx()

                                    val paddedSize = Size(
                                        width = size.width - 2 * borderSize,
                                        height = size.height - 2 * borderSize
                                    )

                                    val outline = dotsGraphic.shape.createOutline(
                                        size = paddedSize,
                                        layoutDirection = layoutDirection,
                                        density = this
                                    )

                                    val clipPath = when (outline) {
                                        is Outline.Rounded -> Path().apply {
                                            addRoundRect(outline.roundRect)
                                        }
                                        is Outline.Generic -> outline.path
                                        is Outline.Rectangle -> Path().apply {
                                            addRect(outline.rect)
                                        }
                                    }.apply { translate(Offset(borderSize, borderSize)) }

                                    clipPath(clipPath) {
                                        drawRect(
                                            color = fillProgressColor,
                                            size = Size(progressWidth, size.height)
                                        )
                                    }
                                }
                            }
                            .graphicsLayer {
                                alpha = computeAlpha(dotIndex, offsetProvider(), minAlpha = 0.8f)
                            }
                            .width(dotWidth)
                            .clickable {
                                onDotClicked?.invoke(dotIndex)
                            }
                    )
                }
            }
        }
    }
}

private fun computeDotWidth(
    currentDotIndex: Int,
    globalOffset: Float,
    dotsGraphic: DotGraphic,
    shiftSizeFactor: Float
): Dp {
    val diffFactor = 1f - (currentDotIndex - globalOffset).absoluteValue.coerceAtMost(1f)
    val widthToAdd = ((shiftSizeFactor - 1f).coerceAtLeast(0f) * dotsGraphic.size * diffFactor)
    return dotsGraphic.size + widthToAdd
}

private fun computeAlpha(
    currentDotIndex: Int,
    globalOffset: Float,
    minAlpha: Float
): Float {
    return minAlpha + (1f - minAlpha) * (1f - abs(globalOffset - currentDotIndex).coerceIn(0f, 1f))
}

private fun interpolateDotGraphic(
    selected: DotGraphic,
    unselected: DotGraphic,
    currentDotIndex: Int,
    globalOffset: Float
): DotGraphic {
    val distance = abs(globalOffset - currentDotIndex)
    val t = 1f - distance.coerceIn(0f, 1f)

    return DotGraphic(
        size = lerpDp(unselected.size, selected.size, t),
        color = lerpColor(unselected.color, selected.color, t),
        shape = if (t > 0.5f) selected.shape else unselected.shape,
        borderWidth = lerpDpOrNull(unselected.borderWidth, selected.borderWidth, t),
        borderColor = lerpColor(unselected.borderColor, selected.borderColor, t)
    )
}

private fun lerpDp(start: Dp, end: Dp, t: Float): Dp {
    return (start.value + (end.value - start.value) * t).dp
}

private fun lerpDpOrNull(start: Dp?, end: Dp?, t: Float): Dp? {
    if (start == null && end == null) return null
    val s = start ?: 0.dp
    val e = end ?: 0.dp
    return lerpDp(s, e, t)
}

private fun lerpColor(start: Color, end: Color, t: Float): Color {
    return Color(
        red = lerp(start.red, end.red, t),
        green = lerp(start.green, end.green, t),
        blue = lerp(start.blue, end.blue, t),
        alpha = lerp(start.alpha, end.alpha, t),
    )
}

private fun lerp(start: Float, end: Float, t: Float): Float {
    return start + (end - start) * t
}