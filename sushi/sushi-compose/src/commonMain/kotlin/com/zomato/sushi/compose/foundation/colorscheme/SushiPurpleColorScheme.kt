package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed purple colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiPurpleColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiPurpleLightColorScheme()
        SushiColorSchemeType.Dark -> sushiPurpleDarkColorScheme()
    }
}

/**
 * Creates a dark-themed purple colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiPurpleDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Purple900.asColorSpec(),
            v100 = SushiRawColorTokens.Purple800.asColorSpec(),
            v200 = SushiRawColorTokens.Purple700.asColorSpec(),
            v300 = SushiRawColorTokens.Purple600.asColorSpec(),
            v400 = SushiRawColorTokens.Purple500.asColorSpec(),
            v500 = SushiRawColorTokens.Purple600.asColorSpec(),
            v600 = SushiRawColorTokens.Purple300.asColorSpec(),
            v700 = SushiRawColorTokens.Purple200.asColorSpec(),
            v800 = SushiRawColorTokens.Purple100.asColorSpec(),
            v900 = SushiRawColorTokens.Purple050.asColorSpec(),
            accentColor = SushiRawColorTokens.Purple600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Purple050.asColorSpec(),
                v100 = SushiRawColorTokens.Purple100.asColorSpec(),
                v200 = SushiRawColorTokens.Purple200.asColorSpec(),
                v300 = SushiRawColorTokens.Purple300.asColorSpec(),
                v400 = SushiRawColorTokens.Purple400.asColorSpec(),
                v500 = SushiRawColorTokens.Purple600.asColorSpec(),
                v600 = SushiRawColorTokens.Purple600.asColorSpec(),
                v700 = SushiRawColorTokens.Purple700.asColorSpec(),
                v800 = SushiRawColorTokens.Purple800.asColorSpec(),
                v900 = SushiRawColorTokens.Purple900.asColorSpec(),
                accentColor = SushiRawColorTokens.Purple600.asColorSpec()
            )
        )
    )
}

fun sushiPurpleLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Purple050.asColorSpec(),
            v100 = SushiRawColorTokens.Purple100.asColorSpec(),
            v200 = SushiRawColorTokens.Purple200.asColorSpec(),
            v300 = SushiRawColorTokens.Purple300.asColorSpec(),
            v400 = SushiRawColorTokens.Purple400.asColorSpec(),
            v500 = SushiRawColorTokens.Purple600.asColorSpec(),
            v600 = SushiRawColorTokens.Purple600.asColorSpec(),
            v700 = SushiRawColorTokens.Purple700.asColorSpec(),
            v800 = SushiRawColorTokens.Purple800.asColorSpec(),
            v900 = SushiRawColorTokens.Purple900.asColorSpec(),
            accentColor = SushiRawColorTokens.Purple600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Purple050.asColorSpec(),
                v100 = SushiRawColorTokens.Purple100.asColorSpec(),
                v200 = SushiRawColorTokens.Purple200.asColorSpec(),
                v300 = SushiRawColorTokens.Purple300.asColorSpec(),
                v400 = SushiRawColorTokens.Purple400.asColorSpec(),
                v500 = SushiRawColorTokens.Purple600.asColorSpec(),
                v600 = SushiRawColorTokens.Purple600.asColorSpec(),
                v700 = SushiRawColorTokens.Purple700.asColorSpec(),
                v800 = SushiRawColorTokens.Purple800.asColorSpec(),
                v900 = SushiRawColorTokens.Purple900.asColorSpec(),
                accentColor = SushiRawColorTokens.Purple600.asColorSpec()
            )
        )
    )
}