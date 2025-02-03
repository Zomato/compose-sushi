package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.text.TextTypeSpec
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiButtonProps(
    val text: String? = null,
    val subText: String? = null,
    val type: SushiButtonType? = null,
    val size: SushiButtonSize? = null,
    val fontColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val fontType: TextTypeSpec? = null,
    val color: ColorSpec = SushiUnspecified.asColorSpec(),
    val borderColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val suffixIcon: SushiIconProps? = null,
    val prefixIcon: SushiIconProps? = null,
    val enabled: Boolean? = null,
    val horizontalArrangement: Arrangement.Horizontal? = null,
    val verticalAlignment: Alignment.Vertical? = null,
    val textAlignment: Alignment.Horizontal? = null,
    val markdown: Boolean? = null,
    val shape: Shape? = null,
    val iconSpacing: Dp? = null
)