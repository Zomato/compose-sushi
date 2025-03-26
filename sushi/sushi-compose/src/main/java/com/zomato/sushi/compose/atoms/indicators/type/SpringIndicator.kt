package com.zomato.sushi.compose.atoms.indicators.type

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.indicators.Dot
import com.zomato.sushi.compose.atoms.indicators.model.DotGraphic

/**
 * @author gupta.anirudh@zomato.com
 */
@Composable
internal fun SpringIndicator(
    offsetProvider: () -> Float,
    dotCount: Int,
    dotSpacing: Dp,
    onDotClicked: ((Int) -> Unit)?,
    modifier: Modifier = Modifier,
    dotsGraphic: DotGraphic = DotGraphic(),
    selectorDotGraphic: DotGraphic = DotGraphic(color = Color.Black),
) {
    Box(modifier = modifier) {
        val percentage by remember(offsetProvider(), dotCount) {
            derivedStateOf {
                offsetProvider() / (dotCount - 1)
            }
        }
        Row(
            Modifier
                .align(Alignment.Center)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(
                dotSpacing, alignment = Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(dotCount) { dotIndex ->
                Dot(
                    dotsGraphic,
                    Modifier.clickable {
                        onDotClicked?.invoke(dotIndex)
                    }
                )
            }
        }
        Dot(
            selectorDotGraphic,
            Modifier
                .align(Alignment.CenterStart)
                .layout { measurable, constraints ->
                    val placeable = measurable.measure(constraints)
                    val parentWidth = constraints.maxWidth
                    val offsetX = ((parentWidth - placeable.width) * percentage).toInt()

                    layout(placeable.width, placeable.height) {
                        placeable.place(offsetX, 0)
                    }
                }
        )
    }
}