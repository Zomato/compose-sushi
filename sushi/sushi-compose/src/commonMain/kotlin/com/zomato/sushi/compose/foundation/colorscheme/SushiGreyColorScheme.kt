package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed grey colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiGreyColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiGreyLightColorScheme()
        SushiColorSchemeType.Dark -> sushiGreyDarkColorScheme()
    }
}

/**
 * Creates a dark-themed grey colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiGreyDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Grey900.asColorSpec(),
            v100 = SushiRawColorTokens.Grey800.asColorSpec(),
            v200 = SushiRawColorTokens.Grey700.asColorSpec(),
            v300 = SushiRawColorTokens.Grey600.asColorSpec(),
            v400 = SushiRawColorTokens.Grey500.asColorSpec(),
            v500 = SushiRawColorTokens.Grey600.asColorSpec(),
            v600 = SushiRawColorTokens.Grey300.asColorSpec(),
            v700 = SushiRawColorTokens.Grey200.asColorSpec(),
            v800 = SushiRawColorTokens.Grey100.asColorSpec(),
            v900 = SushiRawColorTokens.Grey050.asColorSpec(),
            accentColor = SushiRawColorTokens.Grey600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Grey050.asColorSpec(),
                v100 = SushiRawColorTokens.Grey100.asColorSpec(),
                v200 = SushiRawColorTokens.Grey200.asColorSpec(),
                v300 = SushiRawColorTokens.Grey300.asColorSpec(),
                v400 = SushiRawColorTokens.Grey400.asColorSpec(),
                v500 = SushiRawColorTokens.Grey600.asColorSpec(),
                v600 = SushiRawColorTokens.Grey600.asColorSpec(),
                v700 = SushiRawColorTokens.Grey700.asColorSpec(),
                v800 = SushiRawColorTokens.Grey800.asColorSpec(),
                v900 = SushiRawColorTokens.Grey900.asColorSpec(),
                accentColor = SushiRawColorTokens.Grey600.asColorSpec()
            )
        )
    )
}

fun sushiGreyLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Grey050.asColorSpec(),
            v100 = SushiRawColorTokens.Grey100.asColorSpec(),
            v200 = SushiRawColorTokens.Grey200.asColorSpec(),
            v300 = SushiRawColorTokens.Grey300.asColorSpec(),
            v400 = SushiRawColorTokens.Grey400.asColorSpec(),
            v500 = SushiRawColorTokens.Grey600.asColorSpec(),
            v600 = SushiRawColorTokens.Grey600.asColorSpec(),
            v700 = SushiRawColorTokens.Grey700.asColorSpec(),
            v800 = SushiRawColorTokens.Grey800.asColorSpec(),
            v900 = SushiRawColorTokens.Grey900.asColorSpec(),
            accentColor = SushiRawColorTokens.Grey600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Grey050.asColorSpec(),
                v100 = SushiRawColorTokens.Grey100.asColorSpec(),
                v200 = SushiRawColorTokens.Grey200.asColorSpec(),
                v300 = SushiRawColorTokens.Grey300.asColorSpec(),
                v400 = SushiRawColorTokens.Grey400.asColorSpec(),
                v500 = SushiRawColorTokens.Grey600.asColorSpec(),
                v600 = SushiRawColorTokens.Grey600.asColorSpec(),
                v700 = SushiRawColorTokens.Grey700.asColorSpec(),
                v800 = SushiRawColorTokens.Grey800.asColorSpec(),
                v900 = SushiRawColorTokens.Grey900.asColorSpec(),
                accentColor = SushiRawColorTokens.Grey600.asColorSpec()
            )
        )
    )
}