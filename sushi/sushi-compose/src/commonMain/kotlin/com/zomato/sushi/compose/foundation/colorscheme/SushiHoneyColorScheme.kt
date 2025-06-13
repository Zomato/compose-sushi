package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed honey colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiHoneyColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiHoneyLightColorScheme()
        SushiColorSchemeType.Dark -> sushiHoneyDarkColorScheme()
    }
}

/**
 * Creates a dark-themed honey colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiHoneyDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Honey900.asColorSpec(),
            v100 = SushiRawColorTokens.Honey800.asColorSpec(),
            v200 = SushiRawColorTokens.Honey700.asColorSpec(),
            v300 = SushiRawColorTokens.Honey600.asColorSpec(),
            v400 = SushiRawColorTokens.Honey500.asColorSpec(),
            v500 = SushiRawColorTokens.Honey600.asColorSpec(),
            v600 = SushiRawColorTokens.Honey300.asColorSpec(),
            v700 = SushiRawColorTokens.Honey200.asColorSpec(),
            v800 = SushiRawColorTokens.Honey100.asColorSpec(),
            v900 = SushiRawColorTokens.Honey050.asColorSpec(),
            accentColor = SushiRawColorTokens.Honey600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Honey050.asColorSpec(),
                v100 = SushiRawColorTokens.Honey100.asColorSpec(),
                v200 = SushiRawColorTokens.Honey200.asColorSpec(),
                v300 = SushiRawColorTokens.Honey300.asColorSpec(),
                v400 = SushiRawColorTokens.Honey400.asColorSpec(),
                v500 = SushiRawColorTokens.Honey600.asColorSpec(),
                v600 = SushiRawColorTokens.Honey600.asColorSpec(),
                v700 = SushiRawColorTokens.Honey700.asColorSpec(),
                v800 = SushiRawColorTokens.Honey800.asColorSpec(),
                v900 = SushiRawColorTokens.Honey900.asColorSpec(),
                accentColor = SushiRawColorTokens.Honey600.asColorSpec()
            )
        )
    )
}

fun sushiHoneyLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Honey050.asColorSpec(),
            v100 = SushiRawColorTokens.Honey100.asColorSpec(),
            v200 = SushiRawColorTokens.Honey200.asColorSpec(),
            v300 = SushiRawColorTokens.Honey300.asColorSpec(),
            v400 = SushiRawColorTokens.Honey400.asColorSpec(),
            v500 = SushiRawColorTokens.Honey600.asColorSpec(),
            v600 = SushiRawColorTokens.Honey600.asColorSpec(),
            v700 = SushiRawColorTokens.Honey700.asColorSpec(),
            v800 = SushiRawColorTokens.Honey800.asColorSpec(),
            v900 = SushiRawColorTokens.Honey900.asColorSpec(),
            accentColor = SushiRawColorTokens.Honey600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Honey050.asColorSpec(),
                v100 = SushiRawColorTokens.Honey100.asColorSpec(),
                v200 = SushiRawColorTokens.Honey200.asColorSpec(),
                v300 = SushiRawColorTokens.Honey300.asColorSpec(),
                v400 = SushiRawColorTokens.Honey400.asColorSpec(),
                v500 = SushiRawColorTokens.Honey600.asColorSpec(),
                v600 = SushiRawColorTokens.Honey600.asColorSpec(),
                v700 = SushiRawColorTokens.Honey700.asColorSpec(),
                v800 = SushiRawColorTokens.Honey800.asColorSpec(),
                v900 = SushiRawColorTokens.Honey900.asColorSpec(),
                accentColor = SushiRawColorTokens.Honey600.asColorSpec()
            )
        )
    )
}