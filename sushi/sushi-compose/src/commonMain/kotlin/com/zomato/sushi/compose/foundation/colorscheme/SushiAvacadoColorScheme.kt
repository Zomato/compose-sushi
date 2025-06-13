package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed avacado colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiAvacadoColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiAvacadoLightColorScheme()
        SushiColorSchemeType.Dark -> sushiAvacadoDarkColorScheme()
    }
}

/**
 * Creates a dark-themed avacado colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiAvacadoDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Avacado900.asColorSpec(),
            v100 = SushiRawColorTokens.Avacado800.asColorSpec(),
            v200 = SushiRawColorTokens.Avacado700.asColorSpec(),
            v300 = SushiRawColorTokens.Avacado600.asColorSpec(),
            v400 = SushiRawColorTokens.Avacado500.asColorSpec(),
            v500 = SushiRawColorTokens.Avacado600.asColorSpec(),
            v600 = SushiRawColorTokens.Avacado300.asColorSpec(),
            v700 = SushiRawColorTokens.Avacado200.asColorSpec(),
            v800 = SushiRawColorTokens.Avacado100.asColorSpec(),
            v900 = SushiRawColorTokens.Avacado050.asColorSpec(),
            accentColor = SushiRawColorTokens.Avacado600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Avacado050.asColorSpec(),
                v100 = SushiRawColorTokens.Avacado100.asColorSpec(),
                v200 = SushiRawColorTokens.Avacado200.asColorSpec(),
                v300 = SushiRawColorTokens.Avacado300.asColorSpec(),
                v400 = SushiRawColorTokens.Avacado400.asColorSpec(),
                v500 = SushiRawColorTokens.Avacado600.asColorSpec(),
                v600 = SushiRawColorTokens.Avacado600.asColorSpec(),
                v700 = SushiRawColorTokens.Avacado700.asColorSpec(),
                v800 = SushiRawColorTokens.Avacado800.asColorSpec(),
                v900 = SushiRawColorTokens.Avacado900.asColorSpec(),
                accentColor = SushiRawColorTokens.Avacado600.asColorSpec()
            )
        )
    )
}

fun sushiAvacadoLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Avacado050.asColorSpec(),
            v100 = SushiRawColorTokens.Avacado100.asColorSpec(),
            v200 = SushiRawColorTokens.Avacado200.asColorSpec(),
            v300 = SushiRawColorTokens.Avacado300.asColorSpec(),
            v400 = SushiRawColorTokens.Avacado400.asColorSpec(),
            v500 = SushiRawColorTokens.Avacado600.asColorSpec(),
            v600 = SushiRawColorTokens.Avacado600.asColorSpec(),
            v700 = SushiRawColorTokens.Avacado700.asColorSpec(),
            v800 = SushiRawColorTokens.Avacado800.asColorSpec(),
            v900 = SushiRawColorTokens.Avacado900.asColorSpec(),
            accentColor = SushiRawColorTokens.Avacado600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Avacado050.asColorSpec(),
                v100 = SushiRawColorTokens.Avacado100.asColorSpec(),
                v200 = SushiRawColorTokens.Avacado200.asColorSpec(),
                v300 = SushiRawColorTokens.Avacado300.asColorSpec(),
                v400 = SushiRawColorTokens.Avacado400.asColorSpec(),
                v500 = SushiRawColorTokens.Avacado600.asColorSpec(),
                v600 = SushiRawColorTokens.Avacado600.asColorSpec(),
                v700 = SushiRawColorTokens.Avacado700.asColorSpec(),
                v800 = SushiRawColorTokens.Avacado800.asColorSpec(),
                v900 = SushiRawColorTokens.Avacado900.asColorSpec(),
                accentColor = SushiRawColorTokens.Avacado600.asColorSpec()
            )
        )
    )
}