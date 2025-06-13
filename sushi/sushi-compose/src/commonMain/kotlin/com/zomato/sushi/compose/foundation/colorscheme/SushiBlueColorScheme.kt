package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed blue colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiBlueColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiBlueLightColorScheme()
        SushiColorSchemeType.Dark -> sushiBlueDarkColorScheme()
    }
}

/**
 * Creates a dark-themed blue colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiBlueDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Blue900.asColorSpec(),
            v100 = SushiRawColorTokens.Blue800.asColorSpec(),
            v200 = SushiRawColorTokens.Blue700.asColorSpec(),
            v300 = SushiRawColorTokens.Blue600.asColorSpec(),
            v400 = SushiRawColorTokens.Blue500.asColorSpec(),
            v500 = SushiRawColorTokens.Blue600.asColorSpec(),
            v600 = SushiRawColorTokens.Blue300.asColorSpec(),
            v700 = SushiRawColorTokens.Blue200.asColorSpec(),
            v800 = SushiRawColorTokens.Blue100.asColorSpec(),
            v900 = SushiRawColorTokens.Blue050.asColorSpec(),
            accentColor = SushiRawColorTokens.Blue600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Blue050.asColorSpec(),
                v100 = SushiRawColorTokens.Blue100.asColorSpec(),
                v200 = SushiRawColorTokens.Blue200.asColorSpec(),
                v300 = SushiRawColorTokens.Blue300.asColorSpec(),
                v400 = SushiRawColorTokens.Blue400.asColorSpec(),
                v500 = SushiRawColorTokens.Blue600.asColorSpec(),
                v600 = SushiRawColorTokens.Blue600.asColorSpec(),
                v700 = SushiRawColorTokens.Blue700.asColorSpec(),
                v800 = SushiRawColorTokens.Blue800.asColorSpec(),
                v900 = SushiRawColorTokens.Blue900.asColorSpec(),
                accentColor = SushiRawColorTokens.Blue600.asColorSpec()
            )
        )
    )
}

fun sushiBlueLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Blue050.asColorSpec(),
            v100 = SushiRawColorTokens.Blue100.asColorSpec(),
            v200 = SushiRawColorTokens.Blue200.asColorSpec(),
            v300 = SushiRawColorTokens.Blue300.asColorSpec(),
            v400 = SushiRawColorTokens.Blue400.asColorSpec(),
            v500 = SushiRawColorTokens.Blue600.asColorSpec(),
            v600 = SushiRawColorTokens.Blue600.asColorSpec(),
            v700 = SushiRawColorTokens.Blue700.asColorSpec(),
            v800 = SushiRawColorTokens.Blue800.asColorSpec(),
            v900 = SushiRawColorTokens.Blue900.asColorSpec(),
            accentColor = SushiRawColorTokens.Blue600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Blue050.asColorSpec(),
                v100 = SushiRawColorTokens.Blue100.asColorSpec(),
                v200 = SushiRawColorTokens.Blue200.asColorSpec(),
                v300 = SushiRawColorTokens.Blue300.asColorSpec(),
                v400 = SushiRawColorTokens.Blue400.asColorSpec(),
                v500 = SushiRawColorTokens.Blue600.asColorSpec(),
                v600 = SushiRawColorTokens.Blue600.asColorSpec(),
                v700 = SushiRawColorTokens.Blue700.asColorSpec(),
                v800 = SushiRawColorTokens.Blue800.asColorSpec(),
                v900 = SushiRawColorTokens.Blue900.asColorSpec(),
                accentColor = SushiRawColorTokens.Blue600.asColorSpec()
            )
        )
    )
}