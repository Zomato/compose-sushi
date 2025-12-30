package com.zomato.sushi.compose.atoms.tag

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.border.BorderSpec
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.text.SushiTextProps

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
 * @property border The border of the tag
 * @property suffixIcon Optional icon to display after the text
 * @property prefixIcon Optional icon to display before the text
 * @property iconSpacing Custom spacing between icons and text
 * @property shape Optional custom shape to override the default shape from the type
 *
 * Created by Kashish on 10,January,2025
 * Zomato, Gurgaon, India.
 */
@Immutable
data class SushiTagProps(
    val text: SushiTextProps? = null,
    val size: SushiTagSize? = null,
    val type: SushiTagType? = null,
    val color: ColorSpec? = null,
    val border: BorderSpec? = null,
    val suffixIcon: SushiIconProps? = null,
    val prefixIcon: SushiIconProps? = null,
    val iconSpacing: Dp? = null,
    val shape: Shape? = null
)