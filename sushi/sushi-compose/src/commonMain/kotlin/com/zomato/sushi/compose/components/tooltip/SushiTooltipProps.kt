package com.zomato.sushi.compose.components.tooltip

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.border.BorderSpec
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.image.SushiImageProps
import com.zomato.sushi.compose.atoms.text.SushiTextProps

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
 * @property caretShape shape of the caret (defaults to a triangle). Use [SushiTooltipDefaults.noCaretShape] to hide the caret entirely.
 * @property shape Shape of the tooltip container (defaults to rounded corners)
 * @property shadowElevation Shadow depth for the tooltip to create visual hierarchy
 * @property maxWidth Maximum width of the tooltip container (defaults to 80% of screen width)
 * @property contentPadding Optional padding between the tooltip surface and its content
 * @property border Optional border drawn around the complete tooltip shape, including its caret
 *
 * @author gupta.anirudh@zomato.com
 */
data class SushiTooltipProps(
    val text: SushiTextProps? = null,
    val prefixImage: SushiImageProps? = null,
    val suffixImage: SushiImageProps? = null,
    val containerColor: ColorSpec? = null,
    val caretShape: Shape? = null,
    val shape: Shape? = null,
    val shadowElevation: Dp? = null,
    val maxWidth: Dp? = null,
    val contentPadding: PaddingValues? = null,
    val border: BorderSpec? = null
)
