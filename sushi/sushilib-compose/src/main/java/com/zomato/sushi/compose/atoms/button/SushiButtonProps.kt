package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.text.TextTypeSpec
import com.zomato.sushi.compose.foundation.SushiUnspecified

@ExperimentalSushiApi
@Immutable
data class SushiButtonProps(
    val text: String? = Default.text,
    val subText: String? = Default.subText,
    val type: SushiButtonType? = Default.type,
    val size: SushiButtonSize? = Default.size,
    val fontColor: ColorSpec = Default.fontColor,
    val fontType: TextTypeSpec? = Default.fontType,
    val color: ColorSpec = Default.color,
    val borderColor: ColorSpec = Default.borderColor,
    val suffixIcon: SushiIconProps? = Default.suffixIcon,
    val prefixIcon: SushiIconProps? = Default.prefixIcon,
    val enabled: Boolean? = Default.enabled,
    val horizontalArrangement: Arrangement.Horizontal? = Default.horizontalArrangement,
    val verticalAlignment: Alignment.Vertical? = Default.verticalAlignment,
    val textAlignment: Alignment.Horizontal? = Default.textAlignment,
    val markdown: Boolean? = Default.markdown,
    val shape: Shape? = Default.shape,
    val iconSpacing: Dp? = Default.iconSpacing
) {
    companion object {
        val Default = SushiButtonProps(
            text = null,
            subText = null,
            type = null,
            size = null,
            fontColor = SushiUnspecified.asColorSpec(),
            fontType = null,
            color = SushiUnspecified.asColorSpec(),
            borderColor = SushiUnspecified.asColorSpec(),
            suffixIcon = null,
            prefixIcon = null,
            horizontalArrangement = null,
            verticalAlignment = null,
            textAlignment = null,
            enabled = null,
            markdown = null,
            shape = null,
            iconSpacing = null
        )
    }
}