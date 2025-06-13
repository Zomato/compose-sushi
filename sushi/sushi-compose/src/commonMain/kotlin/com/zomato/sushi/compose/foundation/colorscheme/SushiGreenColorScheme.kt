package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed green colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiGreenColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiGreenLightColorScheme()
        SushiColorSchemeType.Dark -> sushiGreenDarkColorScheme()
    }
}

/**
 * Creates a dark-themed green colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiGreenDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Green900.asColorSpec(),
            v100 = SushiRawColorTokens.Green800.asColorSpec(),
            v200 = SushiRawColorTokens.Green700.asColorSpec(),
            v300 = SushiRawColorTokens.Green600.asColorSpec(),
            v400 = SushiRawColorTokens.Green500.asColorSpec(),
            v500 = SushiRawColorTokens.Green600.asColorSpec(),
            v600 = SushiRawColorTokens.Green300.asColorSpec(),
            v700 = SushiRawColorTokens.Green200.asColorSpec(),
            v800 = SushiRawColorTokens.Green100.asColorSpec(),
            v900 = SushiRawColorTokens.Green050.asColorSpec(),
            accentColor = SushiRawColorTokens.Green600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Green050.asColorSpec(),
                v100 = SushiRawColorTokens.Green100.asColorSpec(),
                v200 = SushiRawColorTokens.Green200.asColorSpec(),
                v300 = SushiRawColorTokens.Green300.asColorSpec(),
                v400 = SushiRawColorTokens.Green400.asColorSpec(),
                v500 = SushiRawColorTokens.Green600.asColorSpec(),
                v600 = SushiRawColorTokens.Green600.asColorSpec(),
                v700 = SushiRawColorTokens.Green700.asColorSpec(),
                v800 = SushiRawColorTokens.Green800.asColorSpec(),
                v900 = SushiRawColorTokens.Green900.asColorSpec(),
                accentColor = SushiRawColorTokens.Green600.asColorSpec()
            )
        )
    )
}

fun sushiGreenLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Green050.asColorSpec(),
            v100 = SushiRawColorTokens.Green100.asColorSpec(),
            v200 = SushiRawColorTokens.Green200.asColorSpec(),
            v300 = SushiRawColorTokens.Green300.asColorSpec(),
            v400 = SushiRawColorTokens.Green400.asColorSpec(),
            v500 = SushiRawColorTokens.Green600.asColorSpec(),
            v600 = SushiRawColorTokens.Green600.asColorSpec(),
            v700 = SushiRawColorTokens.Green700.asColorSpec(),
            v800 = SushiRawColorTokens.Green800.asColorSpec(),
            v900 = SushiRawColorTokens.Green900.asColorSpec(),
            accentColor = SushiRawColorTokens.Green600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Green050.asColorSpec(),
                v100 = SushiRawColorTokens.Green100.asColorSpec(),
                v200 = SushiRawColorTokens.Green200.asColorSpec(),
                v300 = SushiRawColorTokens.Green300.asColorSpec(),
                v400 = SushiRawColorTokens.Green400.asColorSpec(),
                v500 = SushiRawColorTokens.Green600.asColorSpec(),
                v600 = SushiRawColorTokens.Green600.asColorSpec(),
                v700 = SushiRawColorTokens.Green700.asColorSpec(),
                v800 = SushiRawColorTokens.Green800.asColorSpec(),
                v900 = SushiRawColorTokens.Green900.asColorSpec(),
                accentColor = SushiRawColorTokens.Green600.asColorSpec()
            )
        )
    )
}