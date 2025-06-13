package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed orange colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiOrangeColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiOrangeLightColorScheme()
        SushiColorSchemeType.Dark -> sushiOrangeDarkColorScheme()
    }
}

/**
 * Creates a dark-themed orange colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiOrangeDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Orange900.asColorSpec(),
            v100 = SushiRawColorTokens.Orange800.asColorSpec(),
            v200 = SushiRawColorTokens.Orange700.asColorSpec(),
            v300 = SushiRawColorTokens.Orange600.asColorSpec(),
            v400 = SushiRawColorTokens.Orange500.asColorSpec(),
            v500 = SushiRawColorTokens.Orange600.asColorSpec(),
            v600 = SushiRawColorTokens.Orange300.asColorSpec(),
            v700 = SushiRawColorTokens.Orange200.asColorSpec(),
            v800 = SushiRawColorTokens.Orange100.asColorSpec(),
            v900 = SushiRawColorTokens.Orange050.asColorSpec(),
            accentColor = SushiRawColorTokens.Orange600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Orange050.asColorSpec(),
                v100 = SushiRawColorTokens.Orange100.asColorSpec(),
                v200 = SushiRawColorTokens.Orange200.asColorSpec(),
                v300 = SushiRawColorTokens.Orange300.asColorSpec(),
                v400 = SushiRawColorTokens.Orange400.asColorSpec(),
                v500 = SushiRawColorTokens.Orange600.asColorSpec(),
                v600 = SushiRawColorTokens.Orange600.asColorSpec(),
                v700 = SushiRawColorTokens.Orange700.asColorSpec(),
                v800 = SushiRawColorTokens.Orange800.asColorSpec(),
                v900 = SushiRawColorTokens.Orange900.asColorSpec(),
                accentColor = SushiRawColorTokens.Orange600.asColorSpec()
            )
        )
    )
}

fun sushiOrangeLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Orange050.asColorSpec(),
            v100 = SushiRawColorTokens.Orange100.asColorSpec(),
            v200 = SushiRawColorTokens.Orange200.asColorSpec(),
            v300 = SushiRawColorTokens.Orange300.asColorSpec(),
            v400 = SushiRawColorTokens.Orange400.asColorSpec(),
            v500 = SushiRawColorTokens.Orange600.asColorSpec(),
            v600 = SushiRawColorTokens.Orange600.asColorSpec(),
            v700 = SushiRawColorTokens.Orange700.asColorSpec(),
            v800 = SushiRawColorTokens.Orange800.asColorSpec(),
            v900 = SushiRawColorTokens.Orange900.asColorSpec(),
            accentColor = SushiRawColorTokens.Orange600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Orange050.asColorSpec(),
                v100 = SushiRawColorTokens.Orange100.asColorSpec(),
                v200 = SushiRawColorTokens.Orange200.asColorSpec(),
                v300 = SushiRawColorTokens.Orange300.asColorSpec(),
                v400 = SushiRawColorTokens.Orange400.asColorSpec(),
                v500 = SushiRawColorTokens.Orange600.asColorSpec(),
                v600 = SushiRawColorTokens.Orange600.asColorSpec(),
                v700 = SushiRawColorTokens.Orange700.asColorSpec(),
                v800 = SushiRawColorTokens.Orange800.asColorSpec(),
                v900 = SushiRawColorTokens.Orange900.asColorSpec(),
                accentColor = SushiRawColorTokens.Orange600.asColorSpec()
            )
        )
    )
}