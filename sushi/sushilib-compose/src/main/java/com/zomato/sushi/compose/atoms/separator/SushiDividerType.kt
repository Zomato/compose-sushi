package com.zomato.sushi.compose.atoms.separator

enum class Direction {
    Top, Bottom
}

sealed interface SushiDividerType {
    data object Straight : SushiDividerType
    data object Dotted : SushiDividerType
    data object Pink : SushiDividerType
    data object VerticalDotted : SushiDividerType
    data object Dashed : SushiDividerType
    data object StraightThick : SushiDividerType
    data object Vertical : SushiDividerType
    data object Menu : SushiDividerType
    data object DottedSpaced : SushiDividerType
    data class ZigZag(val direction: Direction, val radius: Float? = null, val width: Float? = null, val height: Float? = null) : SushiDividerType
}
