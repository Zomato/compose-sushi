package com.zomato.sushi.compose.atoms.separator

import androidx.compose.ui.unit.Dp

sealed interface SushiDividerType {
    data object Straight : SushiDividerType
    data object Dotted : SushiDividerType
    data object Pink : SushiDividerType // Move to Z
    data object VerticalDotted : SushiDividerType
    data object Dashed : SushiDividerType
    data object StraightThick : SushiDividerType
    data object Vertical : SushiDividerType
    data object Menu : SushiDividerType // Move to Z
    data object DottedSpaced : SushiDividerType

    // Move to Z
    data class ZigZag(
        val direction: Direction,
        val radius: Dp? = null,
        val width: Dp? = null,
        val height: Dp? = null
    ) : SushiDividerType {
        enum class Direction {
            Top,
            Bottom
        }
    }
}
