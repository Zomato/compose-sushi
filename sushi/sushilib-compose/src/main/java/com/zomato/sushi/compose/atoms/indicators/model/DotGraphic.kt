package com.zomato.sushi.compose.atoms.indicators.model

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Defines the visual appearance of dots used in indicators.
 *
 * DotGraphic encapsulates all visual properties of indicator dots including size, color,
 * shape, and optional border styles. This allows for consistent styling across different
 * indicator types while providing full customization capabilities.
 *
 * @property size The diameter/size of the dot
 * @property color The fill color of the dot
 * @property shape The shape of the dot (default is CircleShape)
 * @property borderWidth Optional width of the border around the dot (null means no border)
 * @property borderColor The color of the border (if borderWidth is specified)
 *
 * @author gupta.anirudh@zomato.com
 */
data class DotGraphic constructor(
    val size: Dp = 16.dp,
    val color: Color = Color.White,
    val shape: Shape = CircleShape,
    val borderWidth: Dp? = null,
    val borderColor: Color = Color.White,
)