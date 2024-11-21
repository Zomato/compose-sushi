package com.zomato.sushi.compose.atoms.button

import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.foundation.SushiUnspecified

@ExperimentalSushiApi
@Immutable
data class SushiButtonProps(
    val text: String? = Default.text,
    val subtext: String? = Default.subtext,
    val type: SushiButtonType? = Default.type,
    val size: SushiButtonSize? = Default.size,
    val fontColor: ColorSpec = Default.fontColor,
    val color: ColorSpec = Default.color,
    val borderColor: ColorSpec = Default.borderColor,
    val suffixIcon: SushiIconProps? = Default.suffixIcon,
    val prefixIcon: SushiIconProps? = Default.prefixIcon,
    val isDisabled: Boolean? = Default.isDisabled,
    val textAlignment: Alignment.Horizontal? = Default.textAlignment,
    val isMarkDownEnabled: Boolean? = Default.isMarkDownEnabled,
    val shape: Shape? = Default.shape,
    val iconSpacing: Dp? = Default.iconSpacing
) {
    companion object {
        val Default = SushiButtonProps(
            text = null,
            subtext = null,
            type = null,
            size = null,
            fontColor = SushiUnspecified.asColorSpec(),
            color = SushiUnspecified.asColorSpec(),
            borderColor = SushiUnspecified.asColorSpec(),
            suffixIcon = null,
            prefixIcon = null,
            textAlignment = null,
            isDisabled = null,
            isMarkDownEnabled = null,
            shape = null,
            iconSpacing = null
        )
    }
}