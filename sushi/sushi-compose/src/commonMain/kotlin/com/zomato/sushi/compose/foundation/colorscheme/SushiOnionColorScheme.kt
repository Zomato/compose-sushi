package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed onion colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiOnionColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiOnionLightColorScheme()
        SushiColorSchemeType.Dark -> sushiOnionDarkColorScheme()
    }
}

/**
 * Creates a dark-themed onion colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiOnionDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Onion900.asColorSpec(),
            v100 = SushiRawColorTokens.Onion800.asColorSpec(),
            v200 = SushiRawColorTokens.Onion700.asColorSpec(),
            v300 = SushiRawColorTokens.Onion600.asColorSpec(),
            v400 = SushiRawColorTokens.Onion500.asColorSpec(),
            v500 = SushiRawColorTokens.Onion600.asColorSpec(),
            v600 = SushiRawColorTokens.Onion300.asColorSpec(),
            v700 = SushiRawColorTokens.Onion200.asColorSpec(),
            v800 = SushiRawColorTokens.Onion100.asColorSpec(),
            v900 = SushiRawColorTokens.Onion050.asColorSpec(),
            accentColor = SushiRawColorTokens.Onion600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Onion050.asColorSpec(),
                v100 = SushiRawColorTokens.Onion100.asColorSpec(),
                v200 = SushiRawColorTokens.Onion200.asColorSpec(),
                v300 = SushiRawColorTokens.Onion300.asColorSpec(),
                v400 = SushiRawColorTokens.Onion400.asColorSpec(),
                v500 = SushiRawColorTokens.Onion600.asColorSpec(),
                v600 = SushiRawColorTokens.Onion600.asColorSpec(),
                v700 = SushiRawColorTokens.Onion700.asColorSpec(),
                v800 = SushiRawColorTokens.Onion800.asColorSpec(),
                v900 = SushiRawColorTokens.Onion900.asColorSpec(),
                accentColor = SushiRawColorTokens.Onion600.asColorSpec()
            )
        )
    )
}

fun sushiOnionLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Onion050.asColorSpec(),
            v100 = SushiRawColorTokens.Onion100.asColorSpec(),
            v200 = SushiRawColorTokens.Onion200.asColorSpec(),
            v300 = SushiRawColorTokens.Onion300.asColorSpec(),
            v400 = SushiRawColorTokens.Onion400.asColorSpec(),
            v500 = SushiRawColorTokens.Onion600.asColorSpec(),
            v600 = SushiRawColorTokens.Onion600.asColorSpec(),
            v700 = SushiRawColorTokens.Onion700.asColorSpec(),
            v800 = SushiRawColorTokens.Onion800.asColorSpec(),
            v900 = SushiRawColorTokens.Onion900.asColorSpec(),
            accentColor = SushiRawColorTokens.Onion600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Onion050.asColorSpec(),
                v100 = SushiRawColorTokens.Onion100.asColorSpec(),
                v200 = SushiRawColorTokens.Onion200.asColorSpec(),
                v300 = SushiRawColorTokens.Onion300.asColorSpec(),
                v400 = SushiRawColorTokens.Onion400.asColorSpec(),
                v500 = SushiRawColorTokens.Onion600.asColorSpec(),
                v600 = SushiRawColorTokens.Onion600.asColorSpec(),
                v700 = SushiRawColorTokens.Onion700.asColorSpec(),
                v800 = SushiRawColorTokens.Onion800.asColorSpec(),
                v900 = SushiRawColorTokens.Onion900.asColorSpec(),
                accentColor = SushiRawColorTokens.Onion600.asColorSpec()
            )
        )
    )
}