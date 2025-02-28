package com.zomato.sushi.compose.components.tooltip

import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.image.SushiImageProps
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.SushiUnspecified

data class SushiTooltipProps(
    val text: SushiTextProps? = null,
    val prefixImage: SushiImageProps? = null,
    val suffixImage: SushiImageProps? = null,
    val containerColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val caretSize: DpSize? = null,   // use DpSize.Unspecified for no caret
    val shape: Shape? = null,
    val shadowElevation: Dp? = null
)