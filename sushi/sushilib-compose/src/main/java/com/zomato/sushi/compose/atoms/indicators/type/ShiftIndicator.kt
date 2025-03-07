package com.zomato.sushi.compose.atoms.indicators.type

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.times
import com.zomato.sushi.compose.atoms.indicators.Dot
import com.zomato.sushi.compose.atoms.indicators.model.DotGraphic
import kotlin.math.absoluteValue

@Composable
internal fun ShiftIndicator(
    offsetProvider: () -> Float,
    dotCount: Int,
    dotSpacing: Dp,
    onDotClicked: ((Int) -> Unit)?,
    modifier: Modifier = Modifier,
    dotsGraphic: DotGraphic = DotGraphic(),
    shiftSizeFactor: Float = 3f,
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
            repeat(dotCount) { dotIndex ->
                val dotWidth by remember(offsetProvider()) {
                    derivedStateOf { computeDotWidth(dotIndex, offsetProvider(), dotsGraphic, shiftSizeFactor) }
                }
                val dotModifier by remember(dotWidth) {
                    mutableStateOf(
                        Modifier
                            .width(dotWidth)
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
    shiftSizeFactor: Float
): Dp {
    val diffFactor = 1f - (currentDotIndex - globalOffset).absoluteValue.coerceAtMost(1f)
    val widthToAdd = ((shiftSizeFactor - 1f).coerceAtLeast(0f) * dotsGraphic.size * diffFactor)
    return dotsGraphic.size + widthToAdd
}