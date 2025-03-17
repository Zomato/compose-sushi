package com.zomato.sushi.compose.atoms.separator

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Provides default values and utility functions for SushiDivider components.
 * These defaults are used when specific properties are not provided in SushiDividerProps.
 */
object SushiDividerDefaults {
    internal val type = SushiDividerType.Straight

    /**
     * Returns the appropriate height/thickness for a divider based on its type.
     * Each divider type has a specific default thickness that looks best for that style.
     *
     * @param type The type of divider to get the height for
     * @return The recommended height/thickness for the specified divider type
     */
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