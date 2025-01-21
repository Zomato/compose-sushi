@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.foundation.colorSchemeType

/**
 * @author gupta.anirudh@zomato.com
 *
 * Implementation of a ColorSpec that holds value in light and dark mode.
 * This is an efficient implementation involving a single masked long
 * (so that inline value class can be used).
 *
 * Limitations: Will only work with [Color] which are in sRGB space.
 * This is because [Color] in sRGB space ensures that Color::value uses 32-bits.
 * Other spaces does not guarantee this.
 *
 * This class packs two long values (which has utilized only 32 of its bits, on the higher side)
 * into a single long (64 bit).
 *
 * If in future [SushiColorSchemeType] introduces more than two entries, we would
 * have to give away this efficient implementation and fallback to a normal data class.
 */
@JvmInline
@Stable
internal value class ColorSchemeTypeAdaptedColorSpec(
    private val maskedLong: ULong
) : ColorSpec {

    companion object {

        private const val MASK = 0xFFFFFFFF00000000u

        private inline fun mask(value1: ULong, value2: ULong): ULong {
            return (value1 and MASK) or (value2 shr 32)
        }

        private inline fun unmaskValue1(maskedLong: ULong): ULong {
            return maskedLong and MASK
        }

        private inline fun unmaskValue2(maskedLong: ULong): ULong {
            return maskedLong shl 32
        }

        internal inline fun fromColors(light: Color, dark: Color): ColorSchemeTypeAdaptedColorSpec {
            return ColorSchemeTypeAdaptedColorSpec(mask(light.value, dark.value))
        }
    }

    override val value: Color
        @Composable @Stable get() {
            return when (SushiTheme.colorSchemeType) {
                SushiColorSchemeType.Light -> Color(unmaskValue1(maskedLong))
                SushiColorSchemeType.Dark -> Color(unmaskValue2(maskedLong))
            }
        }
}