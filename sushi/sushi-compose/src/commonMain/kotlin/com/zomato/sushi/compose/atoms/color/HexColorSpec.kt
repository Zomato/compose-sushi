package com.zomato.sushi.compose.atoms.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import kotlin.jvm.JvmInline

/**
 * @author gupta.anirudh@zomato.com
 */
@JvmInline
@Stable
internal value class HexColorSpec(
    private val hexCode: String
) : ColorSpec {
    override val value: Color
        @Composable @Stable get() {
            val cleanedHex = hexCode.removePrefix("#")
            val colorLong = cleanedHex.toLong(16)

            return if (cleanedHex.length == 6) {
                // if alpha is excluded
                Color(colorLong or 0xFF000000) // Add full opacity (alpha = 255)
            } else {
                // if alpha is included
                Color(colorLong) // Assume alpha is already part of the hex code
            }
        }
}
