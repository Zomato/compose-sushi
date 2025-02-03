package com.zomato.sushi.compose.atoms.separator

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec

@Immutable
data class SushiDividerProps(
    val type: SushiDividerType? = null,
    val color: ColorSpec? = null,
    val height: Dp? = null
)