package com.zomato.sushi.compose.atoms.indicators.type

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.indicators.model.DotGraphic

sealed interface SushiIndicatorType {
    data class Balloon(
        val dotsGraphic: DotGraphic = DotGraphic(size = 12.dp),
        val balloonSizeFactor: Float = 1.5f,
    ) : SushiIndicatorType

    data class Shift(
        val dotsGraphic: DotGraphic = DotGraphic(),
        val shiftSizeFactor: Float = 3f,
    ) : SushiIndicatorType

    data class Spring(
        val dotsGraphic: DotGraphic = DotGraphic(),
        val selectorDotGraphic: DotGraphic = DotGraphic(color = Color.Black),
    ) : SushiIndicatorType
}