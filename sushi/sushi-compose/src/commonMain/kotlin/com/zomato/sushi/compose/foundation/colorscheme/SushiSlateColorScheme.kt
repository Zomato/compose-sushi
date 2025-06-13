package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed slate colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiSlateColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiSlateLightColorScheme()
        SushiColorSchemeType.Dark -> sushiSlateDarkColorScheme()
    }
}

/**
 * Creates a dark-themed slate colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiSlateDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Slate900.asColorSpec(),
            v100 = SushiRawColorTokens.Slate800.asColorSpec(),
            v200 = SushiRawColorTokens.Slate700.asColorSpec(),
            v300 = SushiRawColorTokens.Slate600.asColorSpec(),
            v400 = SushiRawColorTokens.Slate500.asColorSpec(),
            v500 = SushiRawColorTokens.Slate600.asColorSpec(),
            v600 = SushiRawColorTokens.Slate300.asColorSpec(),
            v700 = SushiRawColorTokens.Slate200.asColorSpec(),
            v800 = SushiRawColorTokens.Slate100.asColorSpec(),
            v900 = SushiRawColorTokens.Slate050.asColorSpec(),
            accentColor = SushiRawColorTokens.Slate600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Slate050.asColorSpec(),
                v100 = SushiRawColorTokens.Slate100.asColorSpec(),
                v200 = SushiRawColorTokens.Slate200.asColorSpec(),
                v300 = SushiRawColorTokens.Slate300.asColorSpec(),
                v400 = SushiRawColorTokens.Slate400.asColorSpec(),
                v500 = SushiRawColorTokens.Slate600.asColorSpec(),
                v600 = SushiRawColorTokens.Slate600.asColorSpec(),
                v700 = SushiRawColorTokens.Slate700.asColorSpec(),
                v800 = SushiRawColorTokens.Slate800.asColorSpec(),
                v900 = SushiRawColorTokens.Slate900.asColorSpec(),
                accentColor = SushiRawColorTokens.Slate600.asColorSpec()
            )
        )
    )
}

fun sushiSlateLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Slate050.asColorSpec(),
            v100 = SushiRawColorTokens.Slate100.asColorSpec(),
            v200 = SushiRawColorTokens.Slate200.asColorSpec(),
            v300 = SushiRawColorTokens.Slate300.asColorSpec(),
            v400 = SushiRawColorTokens.Slate400.asColorSpec(),
            v500 = SushiRawColorTokens.Slate600.asColorSpec(),
            v600 = SushiRawColorTokens.Slate600.asColorSpec(),
            v700 = SushiRawColorTokens.Slate700.asColorSpec(),
            v800 = SushiRawColorTokens.Slate800.asColorSpec(),
            v900 = SushiRawColorTokens.Slate900.asColorSpec(),
            accentColor = SushiRawColorTokens.Slate600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Slate050.asColorSpec(),
                v100 = SushiRawColorTokens.Slate100.asColorSpec(),
                v200 = SushiRawColorTokens.Slate200.asColorSpec(),
                v300 = SushiRawColorTokens.Slate300.asColorSpec(),
                v400 = SushiRawColorTokens.Slate400.asColorSpec(),
                v500 = SushiRawColorTokens.Slate600.asColorSpec(),
                v600 = SushiRawColorTokens.Slate600.asColorSpec(),
                v700 = SushiRawColorTokens.Slate700.asColorSpec(),
                v800 = SushiRawColorTokens.Slate800.asColorSpec(),
                v900 = SushiRawColorTokens.Slate900.asColorSpec(),
                accentColor = SushiRawColorTokens.Slate600.asColorSpec()
            )
        )
    )
}