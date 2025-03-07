package com.zomato.sushi.compose.atoms.indicators.type

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.zomato.sushi.compose.atoms.indicators.Dot
import com.zomato.sushi.compose.atoms.indicators.model.DotGraphic
import kotlin.math.absoluteValue

@Composable
internal fun BalloonIndicator(
    offsetProvider: () -> Float,
    dotCount: Int,
    dotSpacing: Dp,
    onDotClicked: ((Int) -> Unit)?,
    modifier: Modifier = Modifier,
    dotsGraphic: DotGraphic = DotGraphic(size = 12.dp),
    balloonSizeFactor: Float = 1.5f,
) {
    Box(modifier = modifier) {
        Row(
            Modifier
                .padding(
                    start = (dotsGraphic.size * (balloonSizeFactor - 1)) / 2,
                    end = (dotsGraphic.size * (balloonSizeFactor - 1)) / 2
                )
                .fillMaxSize()
                .heightIn(min = dotsGraphic.size * balloonSizeFactor),
            horizontalArrangement = Arrangement.spacedBy(
                dotSpacing, alignment = Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(dotCount) { dotIndex ->
                val dotSize by remember(offsetProvider()) {
                    derivedStateOf { computeDotWidth(dotIndex, offsetProvider(), dotsGraphic, balloonSizeFactor) }
                }
                val dotModifier by remember(dotSize) {
                    mutableStateOf(
                        Modifier
                            .scale(dotSize)
                            .clickable {
                                onDotClicked?.invoke(dotIndex)
                            })
                }
                Dot(dotsGraphic, dotModifier)
            }
        }
    }
}

private fun computeDotWidth(
    currentDotIndex: Int,
    globalOffset: Float,
    dotsGraphic: DotGraphic,
    balloonSizeFactor: Float
): Float {
    val diffFactor = 1f - (currentDotIndex - globalOffset).absoluteValue.coerceAtMost(1f)
    val sizeToAdd = ((balloonSizeFactor - 1f).coerceAtLeast(0f) * dotsGraphic.size * diffFactor)
    return (dotsGraphic.size + sizeToAdd) / dotsGraphic.size
}