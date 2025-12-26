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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.indicators.Dot
import com.zomato.sushi.compose.atoms.indicators.model.DotGraphic
import kotlin.math.roundToInt

/**
 * @author gupta.anirudh@zomato.com
 */
@Composable
internal fun ColoredIndicator(
    offsetProvider: () -> Float,
    dotCount: Int,
    dotSpacing: Dp,
    onDotClicked: ((Int) -> Unit)?,
    modifier: Modifier = Modifier,
    dotsGraphic: DotGraphic = DotGraphic(size = 12.dp),
    selectedColor: Color
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
                val isSelected by remember(offsetProvider) {
                    derivedStateOf {
                        offsetProvider().roundToInt() == dotIndex
                    }
                }
                val dotsGraphic = if (isSelected) {
                    dotsGraphic.copy(color = selectedColor)
                } else {
                    dotsGraphic
                }
                Dot(dotsGraphic,
                    Modifier
                        .clickable {
                            onDotClicked?.invoke(dotIndex)
                        }
                )
            }
        }
    }
}