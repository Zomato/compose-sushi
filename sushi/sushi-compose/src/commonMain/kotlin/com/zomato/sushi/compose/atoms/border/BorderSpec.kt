package com.zomato.sushi.compose.atoms.border

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.SushiGradientColorSpec
import com.zomato.sushi.compose.utils.BorderType

data class BorderSpec(
    val width: Dp? = null,
    val color: SushiGradientColorSpec? = null,
    val borderType: BorderType? = null,
    val borderSides: BorderSides? = BorderSides(),
    val shape: RoundedCornerShape? = null,
    val radius: Dp? = null
)

data class BorderSides(
    val left: Boolean = true,
    val top: Boolean = true,
    val right: Boolean = true,
    val bottom: Boolean = true
)