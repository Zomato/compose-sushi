package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed lime colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiLimeColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiLimeLightColorScheme()
        SushiColorSchemeType.Dark -> sushiLimeDarkColorScheme()
    }
}

/**
 * Creates a dark-themed lime colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiLimeDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Lime900.asColorSpec(),
            v100 = SushiRawColorTokens.Lime800.asColorSpec(),
            v200 = SushiRawColorTokens.Lime700.asColorSpec(),
            v300 = SushiRawColorTokens.Lime600.asColorSpec(),
            v400 = SushiRawColorTokens.Lime500.asColorSpec(),
            v500 = SushiRawColorTokens.Lime600.asColorSpec(),
            v600 = SushiRawColorTokens.Lime300.asColorSpec(),
            v700 = SushiRawColorTokens.Lime200.asColorSpec(),
            v800 = SushiRawColorTokens.Lime100.asColorSpec(),
            v900 = SushiRawColorTokens.Lime050.asColorSpec(),
            accentColor = SushiRawColorTokens.Lime600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Lime050.asColorSpec(),
                v100 = SushiRawColorTokens.Lime100.asColorSpec(),
                v200 = SushiRawColorTokens.Lime200.asColorSpec(),
                v300 = SushiRawColorTokens.Lime300.asColorSpec(),
                v400 = SushiRawColorTokens.Lime400.asColorSpec(),
                v500 = SushiRawColorTokens.Lime600.asColorSpec(),
                v600 = SushiRawColorTokens.Lime600.asColorSpec(),
                v700 = SushiRawColorTokens.Lime700.asColorSpec(),
                v800 = SushiRawColorTokens.Lime800.asColorSpec(),
                v900 = SushiRawColorTokens.Lime900.asColorSpec(),
                accentColor = SushiRawColorTokens.Lime600.asColorSpec()
            )
        )
    )
}

fun sushiLimeLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Lime050.asColorSpec(),
            v100 = SushiRawColorTokens.Lime100.asColorSpec(),
            v200 = SushiRawColorTokens.Lime200.asColorSpec(),
            v300 = SushiRawColorTokens.Lime300.asColorSpec(),
            v400 = SushiRawColorTokens.Lime400.asColorSpec(),
            v500 = SushiRawColorTokens.Lime600.asColorSpec(),
            v600 = SushiRawColorTokens.Lime600.asColorSpec(),
            v700 = SushiRawColorTokens.Lime700.asColorSpec(),
            v800 = SushiRawColorTokens.Lime800.asColorSpec(),
            v900 = SushiRawColorTokens.Lime900.asColorSpec(),
            accentColor = SushiRawColorTokens.Lime600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Lime050.asColorSpec(),
                v100 = SushiRawColorTokens.Lime100.asColorSpec(),
                v200 = SushiRawColorTokens.Lime200.asColorSpec(),
                v300 = SushiRawColorTokens.Lime300.asColorSpec(),
                v400 = SushiRawColorTokens.Lime400.asColorSpec(),
                v500 = SushiRawColorTokens.Lime600.asColorSpec(),
                v600 = SushiRawColorTokens.Lime600.asColorSpec(),
                v700 = SushiRawColorTokens.Lime700.asColorSpec(),
                v800 = SushiRawColorTokens.Lime800.asColorSpec(),
                v900 = SushiRawColorTokens.Lime900.asColorSpec(),
                accentColor = SushiRawColorTokens.Lime600.asColorSpec()
            )
        )
    )
}