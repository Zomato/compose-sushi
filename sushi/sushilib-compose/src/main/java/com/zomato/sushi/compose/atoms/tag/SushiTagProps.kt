package com.zomato.sushi.compose.atoms.tag

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIconProps

/**
 * Created by Kashish on 10,January,2025
 * Zomato, Gurgaon, India.
 */

@Immutable
data class SushiTagProps(
    val text: String? = null,
    val size: SushiTagSize? = null,
    val type: SushiTagType? = null,
    val color: ColorSpec? = null,
    val fontColor: ColorSpec? = null,
    val borderColor: ColorSpec? = null,
    val suffixIcon: SushiIconProps? = null,
    val prefixIcon: SushiIconProps? = null,
    val iconSpacing: Dp? = null,
    val shape: Shape? = null,
    val markdown: Boolean? = true
)