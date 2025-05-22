package com.zomato.sushi.compose.atoms.icon

import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * Properties for configuring a SushiIcon component.
 *
 * SushiIconProps encapsulates the configuration needed to render an icon
 * in the Sushi design system, including its code, size, and color.
 *
 * @property code The SushiIconCode representing the specific icon to display
 * @property size The size specification for the icon
 * @property color The color specification for the icon
 * @property parsedIcon The parsed Unicode character derived from the icon code
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiIconProps(
    val code: SushiIconCode? = null,
    val size: IconSizeSpec? = null,
    val color: ColorSpec = SushiUnspecified.asColorSpec()
) {
    /**
     * The parsed Unicode character derived from the icon code.
     * This is computed automatically from the provided code.
     */
    val parsedIcon: String? = code?.let { parseIcon(it) }

    companion object {
        /**
         * Parses a SushiIconCode into a string representation that can be rendered.
         * 
         * This function converts the hexadecimal code into the corresponding Unicode character
         * that represents the icon in the Wasabi icon font.
         *
         * @param code The SushiIconCode to parse
         * @return The string representation of the icon or null if parsing fails
         */
        fun parseIcon(code: SushiIconCode): String? {
            return code.value.takeIf { it.isNotEmpty() && !it.startsWith("&#x") }
                ?.runCatching { this.toIntOrNull(16)?.toChar().toString() }
                ?.getOrNull()
        }
    }
}
