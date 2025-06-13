package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed tangerine colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiTangerineColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiTangerineLightColorScheme()
        SushiColorSchemeType.Dark -> sushiTangerineDarkColorScheme()
    }
}

/**
 * Creates a dark-themed tangerine colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiTangerineDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Tangerine900.asColorSpec(),
            v100 = SushiRawColorTokens.Tangerine800.asColorSpec(),
            v200 = SushiRawColorTokens.Tangerine700.asColorSpec(),
            v300 = SushiRawColorTokens.Tangerine600.asColorSpec(),
            v400 = SushiRawColorTokens.Tangerine500.asColorSpec(),
            v500 = SushiRawColorTokens.Tangerine600.asColorSpec(),
            v600 = SushiRawColorTokens.Tangerine300.asColorSpec(),
            v700 = SushiRawColorTokens.Tangerine200.asColorSpec(),
            v800 = SushiRawColorTokens.Tangerine100.asColorSpec(),
            v900 = SushiRawColorTokens.Tangerine050.asColorSpec(),
            accentColor = SushiRawColorTokens.Tangerine600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Tangerine050.asColorSpec(),
                v100 = SushiRawColorTokens.Tangerine100.asColorSpec(),
                v200 = SushiRawColorTokens.Tangerine200.asColorSpec(),
                v300 = SushiRawColorTokens.Tangerine300.asColorSpec(),
                v400 = SushiRawColorTokens.Tangerine400.asColorSpec(),
                v500 = SushiRawColorTokens.Tangerine600.asColorSpec(),
                v600 = SushiRawColorTokens.Tangerine600.asColorSpec(),
                v700 = SushiRawColorTokens.Tangerine700.asColorSpec(),
                v800 = SushiRawColorTokens.Tangerine800.asColorSpec(),
                v900 = SushiRawColorTokens.Tangerine900.asColorSpec(),
                accentColor = SushiRawColorTokens.Tangerine600.asColorSpec()
            )
        )
    )
}

fun sushiTangerineLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Tangerine050.asColorSpec(),
            v100 = SushiRawColorTokens.Tangerine100.asColorSpec(),
            v200 = SushiRawColorTokens.Tangerine200.asColorSpec(),
            v300 = SushiRawColorTokens.Tangerine300.asColorSpec(),
            v400 = SushiRawColorTokens.Tangerine400.asColorSpec(),
            v500 = SushiRawColorTokens.Tangerine600.asColorSpec(),
            v600 = SushiRawColorTokens.Tangerine600.asColorSpec(),
            v700 = SushiRawColorTokens.Tangerine700.asColorSpec(),
            v800 = SushiRawColorTokens.Tangerine800.asColorSpec(),
            v900 = SushiRawColorTokens.Tangerine900.asColorSpec(),
            accentColor = SushiRawColorTokens.Tangerine600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Tangerine050.asColorSpec(),
                v100 = SushiRawColorTokens.Tangerine100.asColorSpec(),
                v200 = SushiRawColorTokens.Tangerine200.asColorSpec(),
                v300 = SushiRawColorTokens.Tangerine300.asColorSpec(),
                v400 = SushiRawColorTokens.Tangerine400.asColorSpec(),
                v500 = SushiRawColorTokens.Tangerine600.asColorSpec(),
                v600 = SushiRawColorTokens.Tangerine600.asColorSpec(),
                v700 = SushiRawColorTokens.Tangerine700.asColorSpec(),
                v800 = SushiRawColorTokens.Tangerine800.asColorSpec(),
                v900 = SushiRawColorTokens.Tangerine900.asColorSpec(),
                accentColor = SushiRawColorTokens.Tangerine600.asColorSpec()
            )
        )
    )
}