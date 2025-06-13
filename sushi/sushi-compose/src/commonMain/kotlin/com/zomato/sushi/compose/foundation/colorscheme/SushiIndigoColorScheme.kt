package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed indigo colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiIndigoColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiIndigoLightColorScheme()
        SushiColorSchemeType.Dark -> sushiIndigoDarkColorScheme()
    }
}

/**
 * Creates a dark-themed indigo colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiIndigoDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Indigo900.asColorSpec(),
            v100 = SushiRawColorTokens.Indigo800.asColorSpec(),
            v200 = SushiRawColorTokens.Indigo700.asColorSpec(),
            v300 = SushiRawColorTokens.Indigo600.asColorSpec(),
            v400 = SushiRawColorTokens.Indigo500.asColorSpec(),
            v500 = SushiRawColorTokens.Indigo600.asColorSpec(),
            v600 = SushiRawColorTokens.Indigo300.asColorSpec(),
            v700 = SushiRawColorTokens.Indigo200.asColorSpec(),
            v800 = SushiRawColorTokens.Indigo100.asColorSpec(),
            v900 = SushiRawColorTokens.Indigo050.asColorSpec(),
            accentColor = SushiRawColorTokens.Indigo600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Indigo050.asColorSpec(),
                v100 = SushiRawColorTokens.Indigo100.asColorSpec(),
                v200 = SushiRawColorTokens.Indigo200.asColorSpec(),
                v300 = SushiRawColorTokens.Indigo300.asColorSpec(),
                v400 = SushiRawColorTokens.Indigo400.asColorSpec(),
                v500 = SushiRawColorTokens.Indigo600.asColorSpec(),
                v600 = SushiRawColorTokens.Indigo600.asColorSpec(),
                v700 = SushiRawColorTokens.Indigo700.asColorSpec(),
                v800 = SushiRawColorTokens.Indigo800.asColorSpec(),
                v900 = SushiRawColorTokens.Indigo900.asColorSpec(),
                accentColor = SushiRawColorTokens.Indigo600.asColorSpec()
            )
        )
    )
}

fun sushiIndigoLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Indigo050.asColorSpec(),
            v100 = SushiRawColorTokens.Indigo100.asColorSpec(),
            v200 = SushiRawColorTokens.Indigo200.asColorSpec(),
            v300 = SushiRawColorTokens.Indigo300.asColorSpec(),
            v400 = SushiRawColorTokens.Indigo400.asColorSpec(),
            v500 = SushiRawColorTokens.Indigo600.asColorSpec(),
            v600 = SushiRawColorTokens.Indigo600.asColorSpec(),
            v700 = SushiRawColorTokens.Indigo700.asColorSpec(),
            v800 = SushiRawColorTokens.Indigo800.asColorSpec(),
            v900 = SushiRawColorTokens.Indigo900.asColorSpec(),
            accentColor = SushiRawColorTokens.Indigo600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Indigo050.asColorSpec(),
                v100 = SushiRawColorTokens.Indigo100.asColorSpec(),
                v200 = SushiRawColorTokens.Indigo200.asColorSpec(),
                v300 = SushiRawColorTokens.Indigo300.asColorSpec(),
                v400 = SushiRawColorTokens.Indigo400.asColorSpec(),
                v500 = SushiRawColorTokens.Indigo600.asColorSpec(),
                v600 = SushiRawColorTokens.Indigo600.asColorSpec(),
                v700 = SushiRawColorTokens.Indigo700.asColorSpec(),
                v800 = SushiRawColorTokens.Indigo800.asColorSpec(),
                v900 = SushiRawColorTokens.Indigo900.asColorSpec(),
                accentColor = SushiRawColorTokens.Indigo600.asColorSpec()
            )
        )
    )
}