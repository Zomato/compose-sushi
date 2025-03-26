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
 *
 * Properties for configuring a SushiButton component.
 *
 * @property text Primary text to display in the button
 * @property subText Optional secondary text below the primary text
 * @property type Button style type (Text, Solid, or Outline)
 * @property size Button size variant (Small, Medium, or Large)
 * @property fontColor Color for the button text
 * @property fontType Typography style for the button text
 * @property color Background color of the button
 * @property borderColor Color of the button border (for Outline type)
 * @property suffixIcon Optional icon to display after the button text
 * @property prefixIcon Optional icon to display before the button text
 * @property enabled Whether the button is enabled and can be interacted with
 * @property horizontalArrangement How to arrange content horizontally in the button
 * @property verticalAlignment How to align content vertically in the button
 * @property textAlignment Horizontal alignment of text within the button
 * @property markdown Whether to interpret text as markdown
 * @property shape The shape of the button
 * @property iconSpacing Spacing between icons and text
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