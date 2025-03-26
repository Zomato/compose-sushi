package com.zomato.sushi.compose.components.tooltip

import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.image.SushiImageProps
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * Properties for configuring a SushiTooltip component.
 *
 * SushiTooltipProps encapsulates all configuration options for tooltips in the Sushi design system,
 * allowing for customization of content, appearance, and positioning behavior.
 *
 * @property text Properties for configuring the tooltip's text content
 * @property prefixImage Optional image to display before the text
 * @property suffixImage Optional image to display after the text
 * @property containerColor Background color of the tooltip (defaults to inverse surface color)
 * @property caretSize Size of the tooltip's pointer/caret (width and height)
 *                     Use DpSize.Unspecified for no caret
 * @property shape Shape of the tooltip container (defaults to rounded corners)
 * @property shadowElevation Shadow depth for the tooltip to create visual hierarchy
 *
 * @author gupta.anirudh@zomato.com
 */
data class SushiTooltipProps(
    val text: SushiTextProps? = null,
    val prefixImage: SushiImageProps? = null,
    val suffixImage: SushiImageProps? = null,
    val containerColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val caretSize: DpSize? = null,   // use DpSize.Unspecified for no caret
    val shape: Shape? = null,
    val shadowElevation: Dp? = null
)