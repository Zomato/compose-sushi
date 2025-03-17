package com.zomato.sushi.compose.atoms.tag

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIconProps

/**
 * Properties for configuring a SushiTag component.
 *
 * SushiTag is a small, compact component used to display categories, 
 * attributes, or status information. These properties control the 
 * appearance and content of the tag.
 *
 * @property text The text content to display in the tag
 * @property size The size variant of the tag (affects padding and text size)
 * @property type The visual style of the tag (affects shape and border)
 * @property color The background color of the tag
 * @property fontColor The color of the text and icons in the tag
 * @property borderColor The color of the border (for outline and dashed types)
 * @property suffixIcon Optional icon to display after the text
 * @property prefixIcon Optional icon to display before the text
 * @property iconSpacing Custom spacing between icons and text
 * @property shape Optional custom shape to override the default shape from the type
 * @property markdown Whether to interpret the text content as markdown
 *
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