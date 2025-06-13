package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed brown colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiBrownColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiBrownLightColorScheme()
        SushiColorSchemeType.Dark -> sushiBrownDarkColorScheme()
    }
}

/**
 * Creates a dark-themed brown colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiBrownDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Brown900.asColorSpec(),
            v100 = SushiRawColorTokens.Brown800.asColorSpec(),
            v200 = SushiRawColorTokens.Brown700.asColorSpec(),
            v300 = SushiRawColorTokens.Brown600.asColorSpec(),
            v400 = SushiRawColorTokens.Brown500.asColorSpec(),
            v500 = SushiRawColorTokens.Brown600.asColorSpec(),
            v600 = SushiRawColorTokens.Brown300.asColorSpec(),
            v700 = SushiRawColorTokens.Brown200.asColorSpec(),
            v800 = SushiRawColorTokens.Brown100.asColorSpec(),
            v900 = SushiRawColorTokens.Brown050.asColorSpec(),
            accentColor = SushiRawColorTokens.Brown600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Brown050.asColorSpec(),
                v100 = SushiRawColorTokens.Brown100.asColorSpec(),
                v200 = SushiRawColorTokens.Brown200.asColorSpec(),
                v300 = SushiRawColorTokens.Brown300.asColorSpec(),
                v400 = SushiRawColorTokens.Brown400.asColorSpec(),
                v500 = SushiRawColorTokens.Brown600.asColorSpec(),
                v600 = SushiRawColorTokens.Brown600.asColorSpec(),
                v700 = SushiRawColorTokens.Brown700.asColorSpec(),
                v800 = SushiRawColorTokens.Brown800.asColorSpec(),
                v900 = SushiRawColorTokens.Brown900.asColorSpec(),
                accentColor = SushiRawColorTokens.Brown600.asColorSpec()
            )
        )
    )
}

fun sushiBrownLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Brown050.asColorSpec(),
            v100 = SushiRawColorTokens.Brown100.asColorSpec(),
            v200 = SushiRawColorTokens.Brown200.asColorSpec(),
            v300 = SushiRawColorTokens.Brown300.asColorSpec(),
            v400 = SushiRawColorTokens.Brown400.asColorSpec(),
            v500 = SushiRawColorTokens.Brown600.asColorSpec(),
            v600 = SushiRawColorTokens.Brown600.asColorSpec(),
            v700 = SushiRawColorTokens.Brown700.asColorSpec(),
            v800 = SushiRawColorTokens.Brown800.asColorSpec(),
            v900 = SushiRawColorTokens.Brown900.asColorSpec(),
            accentColor = SushiRawColorTokens.Brown600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Brown050.asColorSpec(),
                v100 = SushiRawColorTokens.Brown100.asColorSpec(),
                v200 = SushiRawColorTokens.Brown200.asColorSpec(),
                v300 = SushiRawColorTokens.Brown300.asColorSpec(),
                v400 = SushiRawColorTokens.Brown400.asColorSpec(),
                v500 = SushiRawColorTokens.Brown600.asColorSpec(),
                v600 = SushiRawColorTokens.Brown600.asColorSpec(),
                v700 = SushiRawColorTokens.Brown700.asColorSpec(),
                v800 = SushiRawColorTokens.Brown800.asColorSpec(),
                v900 = SushiRawColorTokens.Brown900.asColorSpec(),
                accentColor = SushiRawColorTokens.Brown600.asColorSpec()
            )
        )
    )
}