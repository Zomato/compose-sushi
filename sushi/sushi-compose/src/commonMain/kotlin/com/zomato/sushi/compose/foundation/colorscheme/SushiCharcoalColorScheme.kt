package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed charcoal colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiCharcoalColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiCharcoalLightColorScheme()
        SushiColorSchemeType.Dark -> sushiCharcoalDarkColorScheme()
    }
}

/**
 * Creates a dark-themed charcoal colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiCharcoalDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Charcoal900.asColorSpec(),
            v100 = SushiRawColorTokens.Charcoal800.asColorSpec(),
            v200 = SushiRawColorTokens.Charcoal700.asColorSpec(),
            v300 = SushiRawColorTokens.Charcoal600.asColorSpec(),
            v400 = SushiRawColorTokens.Charcoal500.asColorSpec(),
            v500 = SushiRawColorTokens.Charcoal600.asColorSpec(),
            v600 = SushiRawColorTokens.Charcoal300.asColorSpec(),
            v700 = SushiRawColorTokens.Charcoal200.asColorSpec(),
            v800 = SushiRawColorTokens.Charcoal100.asColorSpec(),
            v900 = SushiRawColorTokens.Charcoal050.asColorSpec(),
            accentColor = SushiRawColorTokens.Charcoal600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Charcoal050.asColorSpec(),
                v100 = SushiRawColorTokens.Charcoal100.asColorSpec(),
                v200 = SushiRawColorTokens.Charcoal200.asColorSpec(),
                v300 = SushiRawColorTokens.Charcoal300.asColorSpec(),
                v400 = SushiRawColorTokens.Charcoal400.asColorSpec(),
                v500 = SushiRawColorTokens.Charcoal600.asColorSpec(),
                v600 = SushiRawColorTokens.Charcoal600.asColorSpec(),
                v700 = SushiRawColorTokens.Charcoal700.asColorSpec(),
                v800 = SushiRawColorTokens.Charcoal800.asColorSpec(),
                v900 = SushiRawColorTokens.Charcoal900.asColorSpec(),
                accentColor = SushiRawColorTokens.Charcoal600.asColorSpec()
            )
        )
    )
}

fun sushiCharcoalLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Charcoal050.asColorSpec(),
            v100 = SushiRawColorTokens.Charcoal100.asColorSpec(),
            v200 = SushiRawColorTokens.Charcoal200.asColorSpec(),
            v300 = SushiRawColorTokens.Charcoal300.asColorSpec(),
            v400 = SushiRawColorTokens.Charcoal400.asColorSpec(),
            v500 = SushiRawColorTokens.Charcoal600.asColorSpec(),
            v600 = SushiRawColorTokens.Charcoal600.asColorSpec(),
            v700 = SushiRawColorTokens.Charcoal700.asColorSpec(),
            v800 = SushiRawColorTokens.Charcoal800.asColorSpec(),
            v900 = SushiRawColorTokens.Charcoal900.asColorSpec(),
            accentColor = SushiRawColorTokens.Charcoal600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Charcoal050.asColorSpec(),
                v100 = SushiRawColorTokens.Charcoal100.asColorSpec(),
                v200 = SushiRawColorTokens.Charcoal200.asColorSpec(),
                v300 = SushiRawColorTokens.Charcoal300.asColorSpec(),
                v400 = SushiRawColorTokens.Charcoal400.asColorSpec(),
                v500 = SushiRawColorTokens.Charcoal600.asColorSpec(),
                v600 = SushiRawColorTokens.Charcoal600.asColorSpec(),
                v700 = SushiRawColorTokens.Charcoal700.asColorSpec(),
                v800 = SushiRawColorTokens.Charcoal800.asColorSpec(),
                v900 = SushiRawColorTokens.Charcoal900.asColorSpec(),
                accentColor = SushiRawColorTokens.Charcoal600.asColorSpec()
            )
        )
    )
}