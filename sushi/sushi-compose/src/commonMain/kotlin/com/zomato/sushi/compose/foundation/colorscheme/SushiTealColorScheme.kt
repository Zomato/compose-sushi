package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed teal colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiTealColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiTealLightColorScheme()
        SushiColorSchemeType.Dark -> sushiTealDarkColorScheme()
    }
}

/**
 * Creates a dark-themed teal colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiTealDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Teal900.asColorSpec(),
            v100 = SushiRawColorTokens.Teal800.asColorSpec(),
            v200 = SushiRawColorTokens.Teal700.asColorSpec(),
            v300 = SushiRawColorTokens.Teal600.asColorSpec(),
            v400 = SushiRawColorTokens.Teal500.asColorSpec(),
            v500 = SushiRawColorTokens.Teal600.asColorSpec(),
            v600 = SushiRawColorTokens.Teal300.asColorSpec(),
            v700 = SushiRawColorTokens.Teal200.asColorSpec(),
            v800 = SushiRawColorTokens.Teal100.asColorSpec(),
            v900 = SushiRawColorTokens.Teal050.asColorSpec(),
            accentColor = SushiRawColorTokens.Teal600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Teal050.asColorSpec(),
                v100 = SushiRawColorTokens.Teal100.asColorSpec(),
                v200 = SushiRawColorTokens.Teal200.asColorSpec(),
                v300 = SushiRawColorTokens.Teal300.asColorSpec(),
                v400 = SushiRawColorTokens.Teal400.asColorSpec(),
                v500 = SushiRawColorTokens.Teal600.asColorSpec(),
                v600 = SushiRawColorTokens.Teal600.asColorSpec(),
                v700 = SushiRawColorTokens.Teal700.asColorSpec(),
                v800 = SushiRawColorTokens.Teal800.asColorSpec(),
                v900 = SushiRawColorTokens.Teal900.asColorSpec(),
                accentColor = SushiRawColorTokens.Teal600.asColorSpec()
            )
        )
    )
}

fun sushiTealLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Teal050.asColorSpec(),
            v100 = SushiRawColorTokens.Teal100.asColorSpec(),
            v200 = SushiRawColorTokens.Teal200.asColorSpec(),
            v300 = SushiRawColorTokens.Teal300.asColorSpec(),
            v400 = SushiRawColorTokens.Teal400.asColorSpec(),
            v500 = SushiRawColorTokens.Teal600.asColorSpec(),
            v600 = SushiRawColorTokens.Teal600.asColorSpec(),
            v700 = SushiRawColorTokens.Teal700.asColorSpec(),
            v800 = SushiRawColorTokens.Teal800.asColorSpec(),
            v900 = SushiRawColorTokens.Teal900.asColorSpec(),
            accentColor = SushiRawColorTokens.Teal600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Teal050.asColorSpec(),
                v100 = SushiRawColorTokens.Teal100.asColorSpec(),
                v200 = SushiRawColorTokens.Teal200.asColorSpec(),
                v300 = SushiRawColorTokens.Teal300.asColorSpec(),
                v400 = SushiRawColorTokens.Teal400.asColorSpec(),
                v500 = SushiRawColorTokens.Teal600.asColorSpec(),
                v600 = SushiRawColorTokens.Teal600.asColorSpec(),
                v700 = SushiRawColorTokens.Teal700.asColorSpec(),
                v800 = SushiRawColorTokens.Teal800.asColorSpec(),
                v900 = SushiRawColorTokens.Teal900.asColorSpec(),
                accentColor = SushiRawColorTokens.Teal600.asColorSpec()
            )
        )
    )
}