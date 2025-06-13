package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed pink colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiPinkColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiPinkLightColorScheme()
        SushiColorSchemeType.Dark -> sushiPinkDarkColorScheme()
    }
}

/**
 * Creates a dark-themed pink colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiPinkDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Pink900.asColorSpec(),
            v100 = SushiRawColorTokens.Pink800.asColorSpec(),
            v200 = SushiRawColorTokens.Pink700.asColorSpec(),
            v300 = SushiRawColorTokens.Pink600.asColorSpec(),
            v400 = SushiRawColorTokens.Pink500.asColorSpec(),
            v500 = SushiRawColorTokens.Pink600.asColorSpec(),
            v600 = SushiRawColorTokens.Pink300.asColorSpec(),
            v700 = SushiRawColorTokens.Pink200.asColorSpec(),
            v800 = SushiRawColorTokens.Pink100.asColorSpec(),
            v900 = SushiRawColorTokens.Pink050.asColorSpec(),
            accentColor = SushiRawColorTokens.Pink600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Pink050.asColorSpec(),
                v100 = SushiRawColorTokens.Pink100.asColorSpec(),
                v200 = SushiRawColorTokens.Pink200.asColorSpec(),
                v300 = SushiRawColorTokens.Pink300.asColorSpec(),
                v400 = SushiRawColorTokens.Pink400.asColorSpec(),
                v500 = SushiRawColorTokens.Pink600.asColorSpec(),
                v600 = SushiRawColorTokens.Pink600.asColorSpec(),
                v700 = SushiRawColorTokens.Pink700.asColorSpec(),
                v800 = SushiRawColorTokens.Pink800.asColorSpec(),
                v900 = SushiRawColorTokens.Pink900.asColorSpec(),
                accentColor = SushiRawColorTokens.Pink600.asColorSpec()
            )
        )
    )
}

fun sushiPinkLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Pink050.asColorSpec(),
            v100 = SushiRawColorTokens.Pink100.asColorSpec(),
            v200 = SushiRawColorTokens.Pink200.asColorSpec(),
            v300 = SushiRawColorTokens.Pink300.asColorSpec(),
            v400 = SushiRawColorTokens.Pink400.asColorSpec(),
            v500 = SushiRawColorTokens.Pink600.asColorSpec(),
            v600 = SushiRawColorTokens.Pink600.asColorSpec(),
            v700 = SushiRawColorTokens.Pink700.asColorSpec(),
            v800 = SushiRawColorTokens.Pink800.asColorSpec(),
            v900 = SushiRawColorTokens.Pink900.asColorSpec(),
            accentColor = SushiRawColorTokens.Pink600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Pink050.asColorSpec(),
                v100 = SushiRawColorTokens.Pink100.asColorSpec(),
                v200 = SushiRawColorTokens.Pink200.asColorSpec(),
                v300 = SushiRawColorTokens.Pink300.asColorSpec(),
                v400 = SushiRawColorTokens.Pink400.asColorSpec(),
                v500 = SushiRawColorTokens.Pink600.asColorSpec(),
                v600 = SushiRawColorTokens.Pink600.asColorSpec(),
                v700 = SushiRawColorTokens.Pink700.asColorSpec(),
                v800 = SushiRawColorTokens.Pink800.asColorSpec(),
                v900 = SushiRawColorTokens.Pink900.asColorSpec(),
                accentColor = SushiRawColorTokens.Pink600.asColorSpec()
            )
        )
    )
}