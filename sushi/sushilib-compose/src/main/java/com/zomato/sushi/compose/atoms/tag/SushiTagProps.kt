package com.zomato.sushi.compose.atoms.tag

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * Created by Kashish on 10,January,2025
 * Zomato, Gurgaon, India.
 */

@ExperimentalSushiApi
@Immutable
data class SushiTagProps(
    val text: String? = Default.text,
    val size: SushiTagSize = Default.size,
    val type: SushiTagType = Default.type,
    val color: ColorSpec? = Default.color,
    val fontColor: ColorSpec? = Default.fontColor,
    val borderColor: ColorSpec? = Default.borderColor,
    val suffixIcon: SushiIconProps? = Default.suffixIcon,
    val prefixIcon: SushiIconProps? = Default.prefixIcon,
    val iconSpacing: Dp? = Default.iconSpacing,
    val shape: Shape? = Default.shape,
    val markdown: Boolean = true
) {
    companion object {
        val Default = SushiTagProps(
            text = null,
            size = SushiTagSize.Medium,
            type = SushiTagType.Rounded,
            color = SushiUnspecified.asColorSpec(),
            fontColor = SushiUnspecified.asColorSpec(),
            borderColor = SushiUnspecified.asColorSpec(),
            suffixIcon = null,
            prefixIcon = null,
            iconSpacing = null,
            shape = null
        )
    }
}