package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed cider colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiCiderColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiCiderLightColorScheme()
        SushiColorSchemeType.Dark -> sushiCiderDarkColorScheme()
    }
}

/**
 * Creates a dark-themed cider colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiCiderDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Cider900.asColorSpec(),
            v100 = SushiRawColorTokens.Cider800.asColorSpec(),
            v200 = SushiRawColorTokens.Cider700.asColorSpec(),
            v300 = SushiRawColorTokens.Cider600.asColorSpec(),
            v400 = SushiRawColorTokens.Cider500.asColorSpec(),
            v500 = SushiRawColorTokens.Cider600.asColorSpec(),
            v600 = SushiRawColorTokens.Cider300.asColorSpec(),
            v700 = SushiRawColorTokens.Cider200.asColorSpec(),
            v800 = SushiRawColorTokens.Cider100.asColorSpec(),
            v900 = SushiRawColorTokens.Cider050.asColorSpec(),
            accentColor = SushiRawColorTokens.Cider600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Cider050.asColorSpec(),
                v100 = SushiRawColorTokens.Cider100.asColorSpec(),
                v200 = SushiRawColorTokens.Cider200.asColorSpec(),
                v300 = SushiRawColorTokens.Cider300.asColorSpec(),
                v400 = SushiRawColorTokens.Cider400.asColorSpec(),
                v500 = SushiRawColorTokens.Cider600.asColorSpec(),
                v600 = SushiRawColorTokens.Cider600.asColorSpec(),
                v700 = SushiRawColorTokens.Cider700.asColorSpec(),
                v800 = SushiRawColorTokens.Cider800.asColorSpec(),
                v900 = SushiRawColorTokens.Cider900.asColorSpec(),
                accentColor = SushiRawColorTokens.Cider600.asColorSpec()
            )
        )
    )
}

fun sushiCiderLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Cider050.asColorSpec(),
            v100 = SushiRawColorTokens.Cider100.asColorSpec(),
            v200 = SushiRawColorTokens.Cider200.asColorSpec(),
            v300 = SushiRawColorTokens.Cider300.asColorSpec(),
            v400 = SushiRawColorTokens.Cider400.asColorSpec(),
            v500 = SushiRawColorTokens.Cider600.asColorSpec(),
            v600 = SushiRawColorTokens.Cider600.asColorSpec(),
            v700 = SushiRawColorTokens.Cider700.asColorSpec(),
            v800 = SushiRawColorTokens.Cider800.asColorSpec(),
            v900 = SushiRawColorTokens.Cider900.asColorSpec(),
            accentColor = SushiRawColorTokens.Cider600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Cider050.asColorSpec(),
                v100 = SushiRawColorTokens.Cider100.asColorSpec(),
                v200 = SushiRawColorTokens.Cider200.asColorSpec(),
                v300 = SushiRawColorTokens.Cider300.asColorSpec(),
                v400 = SushiRawColorTokens.Cider400.asColorSpec(),
                v500 = SushiRawColorTokens.Cider600.asColorSpec(),
                v600 = SushiRawColorTokens.Cider600.asColorSpec(),
                v700 = SushiRawColorTokens.Cider700.asColorSpec(),
                v800 = SushiRawColorTokens.Cider800.asColorSpec(),
                v900 = SushiRawColorTokens.Cider900.asColorSpec(),
                accentColor = SushiRawColorTokens.Cider600.asColorSpec()
            )
        )
    )
}