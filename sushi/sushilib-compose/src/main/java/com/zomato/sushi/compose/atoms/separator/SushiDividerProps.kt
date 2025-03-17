package com.zomato.sushi.compose.atoms.separator

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec

/**
 * Properties for configuring a SushiDivider component.
 *
 * @property type The visual style of the divider (default is SushiDividerType.Straight)
 * @property color The color of the divider (default is determined by theme)
 * @property height The thickness of the divider (default varies by type)
 */
@Immutable
data class SushiDividerProps(
    val type: SushiDividerType? = null,
    val color: ColorSpec? = null,
    val height: Dp? = null
)