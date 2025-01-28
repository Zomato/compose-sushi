package com.zomato.sushi.compose.atoms.icon

import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiIconProps(
    val code: SushiIconCode? = null,
    val size: IconSizeSpec? = null,
    val color: ColorSpec = SushiUnspecified.asColorSpec()
) {
    val parsedIcon: String? = code?.let { parseIcon(it) }

    companion object {

        fun parseIcon(code: SushiIconCode): String? {
            return code.value.takeIf { it.isNotEmpty() && !it.startsWith("&#x") }
                ?.runCatching { Integer.parseInt(this, 16).toChar().toString() }
                ?.getOrNull()
        }
    }
}
