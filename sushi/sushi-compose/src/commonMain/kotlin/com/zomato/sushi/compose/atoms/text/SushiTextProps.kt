package com.zomato.sushi.compose.atoms.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * @author gupta.anirudh@zomato.com
 *
 * Properties for configuring a SushiText component.
 *
 * @property text The text content to display
 * @property color The color specification for the text
 * @property type The typography style to apply to the text
 * @property maxLines Maximum number of lines to display before truncating
 * @property prefixIcon Optional icon to display before the text
 * @property suffixIcon Optional icon to display after the text
 * @property letterSpacing Spacing between letters in the text
 * @property markdown Whether to interpret the text as markdown
 * @property textDecoration Optional decoration to apply to the text (underline or strikethrough)
 * @property textAlign Text alignment within its container
 * @property overflow How to handle text that doesn't fit within maxLines
 * @property overflowText Text to show as part of the "read more" functionality
 * @property overflowTextColor Color for the overflow text
 * @property softWrap Whether text should wrap to the next line
 * @property minLines Minimum number of lines to display
 * @property prefixSpacing Space between the prefix icon and the text
 * @property suffixSpacing Space between the text and the suffix icon
 * @property horizontalArrangement How to arrange content horizontally
 * @property verticalAlignment How to align content vertically
 * @property textBrush Optional brush for creating gradient or other effects on text
 * @property autoSize Enable auto sizing (uses biggest font size that fits the constraints, including [maxLines]). This takes precedence over size defined in [type].
 */
@Immutable
data class SushiTextProps(
    val text: CharSequence? = null,
    val color: ColorSpec = SushiUnspecified.asColorSpec(),
    val type: TextTypeSpec? = null,
    val maxLines: Int? = null,
    val prefixIcon: SushiIconProps? = null,
    val suffixIcon: SushiIconProps? = null,
    val letterSpacing: TextUnit = TextUnit.Unspecified,
    val markdown: Boolean? = null,
    val textDecoration: SushiTextDecoration? = null,
    val textAlign: TextAlign? = null,
    val overflow: TextOverflow? = null,
    val overflowText: String? = null,
    val overflowTextColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val softWrap: Boolean? = null,
    val minLines: Int? = null,
    val prefixSpacing: Dp? = null,
    val suffixSpacing: Dp? = null,
    val horizontalArrangement: Arrangement.Horizontal? = null,
    val verticalAlignment: Alignment.Vertical? = null,
    val textBrush: Brush? = null,
    val autoSize: TextAutoSize? = null
)

/**
 * Decorations that can be applied to text, such as underline or strikethrough.
 * Each decoration type allows customization of appearance parameters.
 */
sealed interface SushiTextDecoration {
    /**
     * Underline decoration for text.
     *
     * @property dotSize Size of dots in the underline (for dotted style)
     * @property gapSize Size of gaps between dots
     * @property strokeWidth Width of the underline
     * @property color Color of the underline (defaults to text color if not specified)
     */
    data class Underline(
        val dotSize: Dp? = null,
        val gapSize: Dp? = null,
        val strokeWidth: Dp? = null,
        val color: ColorSpec? = null
    ) : SushiTextDecoration

    /**
     * Strikethrough decoration for text.
     *
     * @property dotSize Size of dots in the line (for dotted style)
     * @property gapSize Size of gaps between dots
     * @property strokeWidth Width of the line
     * @property color Color of the line (defaults to text color if not specified)
     */
    data class LineThrough(
        val dotSize: Dp? = null,
        val gapSize: Dp? = null,
        val strokeWidth: Dp? = null,
        val color: ColorSpec? = null
    ) : SushiTextDecoration
}
