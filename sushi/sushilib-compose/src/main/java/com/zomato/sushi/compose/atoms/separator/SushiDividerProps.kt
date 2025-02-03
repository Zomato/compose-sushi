package com.zomato.sushi.compose.atoms.separator

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.ColorSpec

@Immutable
data class SushiDividerProps(
    val type: SushiDividerType? = null,
    val color: ColorSpec? = null,
    val height: Dp? = null
)

object SushiDividerDefaults {
    internal val type = SushiDividerType.Straight


    fun getDividerHeight(type: SushiDividerType): Dp {
        return when (type) {
            SushiDividerType.Straight, SushiDividerType.Dashed -> 1f.dp
            SushiDividerType.StraightThick -> 8f.dp
            SushiDividerType.Dotted -> 3f.dp
            SushiDividerType.DottedSpaced -> 0.8f.dp
            SushiDividerType.Pink -> 3f.dp
            SushiDividerType.Menu -> 2f.dp
            is SushiDividerType.ZigZag -> type.height ?: 24f.dp
            SushiDividerType.Vertical -> 1.dp
            SushiDividerType.VerticalDotted -> 3.dp
        }
    }
}