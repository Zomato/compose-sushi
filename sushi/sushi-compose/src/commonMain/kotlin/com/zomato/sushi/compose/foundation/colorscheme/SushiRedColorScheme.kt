package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.Red050
import com.zomato.sushi.compose.foundation.Red100
import com.zomato.sushi.compose.foundation.Red200
import com.zomato.sushi.compose.foundation.Red300
import com.zomato.sushi.compose.foundation.Red400
import com.zomato.sushi.compose.foundation.Red500
import com.zomato.sushi.compose.foundation.Red600
import com.zomato.sushi.compose.foundation.Red700
import com.zomato.sushi.compose.foundation.Red800
import com.zomato.sushi.compose.foundation.Red900
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed red colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiRedColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiRedLightColorScheme()
        SushiColorSchemeType.Dark -> sushiRedDarkColorScheme()
    }
}

/**
 * Creates a dark-themed red colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiRedDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = Red050,
            v100 = Red100,
            v200 = Red200,
            v300 = Red300,
            v400 = Red400,
            v500 = SushiRawColorTokens.Red600.asColorSpec(),
            v600 = Red600,
            v700 = Red700,
            v800 = Red800,
            v900 = Red900,
            accentColor = SushiRawColorTokens.Red600.asColorSpec(),
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Red050.asColorSpec(),
                v100 = SushiRawColorTokens.Red100.asColorSpec(),
                v200 = SushiRawColorTokens.Red200.asColorSpec(),
                v300 = SushiRawColorTokens.Red300.asColorSpec(),
                v400 = SushiRawColorTokens.Red400.asColorSpec(),
                v500 = SushiRawColorTokens.Red600.asColorSpec(),
                v600 = SushiRawColorTokens.Red600.asColorSpec(),
                v700 = SushiRawColorTokens.Red700.asColorSpec(),
                v800 = SushiRawColorTokens.Red800.asColorSpec(),
                v900 = SushiRawColorTokens.Red900.asColorSpec(),
                accentColor = SushiRawColorTokens.Red600.asColorSpec(),
            )
        )
    )
}

fun sushiRedLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = Red050,
            v100 = Red100,
            v200 = Red200,
            v300 = Red300,
            v400 = Red400,
            v500 = Red500,
            v600 = Red600,
            v700 = Red700,
            v800 = Red800,
            v900 = Red900,
            accentColor = Red500,
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Red050.asColorSpec(),
                v100 = SushiRawColorTokens.Red100.asColorSpec(),
                v200 = SushiRawColorTokens.Red200.asColorSpec(),
                v300 = SushiRawColorTokens.Red300.asColorSpec(),
                v400 = SushiRawColorTokens.Red400.asColorSpec(),
                v500 = SushiRawColorTokens.Red500.asColorSpec(),
                v600 = SushiRawColorTokens.Red600.asColorSpec(),
                v700 = SushiRawColorTokens.Red700.asColorSpec(),
                v800 = SushiRawColorTokens.Red800.asColorSpec(),
                v900 = SushiRawColorTokens.Red900.asColorSpec(),
                accentColor = SushiRawColorTokens.Red600.asColorSpec(),
            )
        )
    )
}