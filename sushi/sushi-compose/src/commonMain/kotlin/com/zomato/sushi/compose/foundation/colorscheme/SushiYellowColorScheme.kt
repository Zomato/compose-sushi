package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed yellow colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiYellowColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiYellowLightColorScheme()
        SushiColorSchemeType.Dark -> sushiYellowDarkColorScheme()
    }
}

/**
 * Creates a dark-themed yellow colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiYellowDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Yellow900.asColorSpec(),
            v100 = SushiRawColorTokens.Yellow800.asColorSpec(),
            v200 = SushiRawColorTokens.Yellow700.asColorSpec(),
            v300 = SushiRawColorTokens.Yellow600.asColorSpec(),
            v400 = SushiRawColorTokens.Yellow500.asColorSpec(),
            v500 = SushiRawColorTokens.Yellow600.asColorSpec(),
            v600 = SushiRawColorTokens.Yellow300.asColorSpec(),
            v700 = SushiRawColorTokens.Yellow200.asColorSpec(),
            v800 = SushiRawColorTokens.Yellow100.asColorSpec(),
            v900 = SushiRawColorTokens.Yellow050.asColorSpec(),
            accentColor = SushiRawColorTokens.Yellow600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Yellow050.asColorSpec(),
                v100 = SushiRawColorTokens.Yellow100.asColorSpec(),
                v200 = SushiRawColorTokens.Yellow200.asColorSpec(),
                v300 = SushiRawColorTokens.Yellow300.asColorSpec(),
                v400 = SushiRawColorTokens.Yellow400.asColorSpec(),
                v500 = SushiRawColorTokens.Yellow600.asColorSpec(),
                v600 = SushiRawColorTokens.Yellow600.asColorSpec(),
                v700 = SushiRawColorTokens.Yellow700.asColorSpec(),
                v800 = SushiRawColorTokens.Yellow800.asColorSpec(),
                v900 = SushiRawColorTokens.Yellow900.asColorSpec(),
                accentColor = SushiRawColorTokens.Yellow600.asColorSpec()
            )
        )
    )
}

fun sushiYellowLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Yellow050.asColorSpec(),
            v100 = SushiRawColorTokens.Yellow100.asColorSpec(),
            v200 = SushiRawColorTokens.Yellow200.asColorSpec(),
            v300 = SushiRawColorTokens.Yellow300.asColorSpec(),
            v400 = SushiRawColorTokens.Yellow400.asColorSpec(),
            v500 = SushiRawColorTokens.Yellow600.asColorSpec(),
            v600 = SushiRawColorTokens.Yellow600.asColorSpec(),
            v700 = SushiRawColorTokens.Yellow700.asColorSpec(),
            v800 = SushiRawColorTokens.Yellow800.asColorSpec(),
            v900 = SushiRawColorTokens.Yellow900.asColorSpec(),
            accentColor = SushiRawColorTokens.Yellow600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Yellow050.asColorSpec(),
                v100 = SushiRawColorTokens.Yellow100.asColorSpec(),
                v200 = SushiRawColorTokens.Yellow200.asColorSpec(),
                v300 = SushiRawColorTokens.Yellow300.asColorSpec(),
                v400 = SushiRawColorTokens.Yellow400.asColorSpec(),
                v500 = SushiRawColorTokens.Yellow600.asColorSpec(),
                v600 = SushiRawColorTokens.Yellow600.asColorSpec(),
                v700 = SushiRawColorTokens.Yellow700.asColorSpec(),
                v800 = SushiRawColorTokens.Yellow800.asColorSpec(),
                v900 = SushiRawColorTokens.Yellow900.asColorSpec(),
                accentColor = SushiRawColorTokens.Yellow600.asColorSpec()
            )
        )
    )
}