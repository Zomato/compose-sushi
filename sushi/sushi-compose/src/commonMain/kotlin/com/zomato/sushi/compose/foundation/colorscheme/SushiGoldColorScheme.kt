package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens

/**
 * Creates a light-themed gold colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiGoldColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiGoldLightColorScheme()
        SushiColorSchemeType.Dark -> sushiGoldDarkColorScheme()
    }
}

/**
 * Creates a dark-themed gold colored scheme for the Sushi design system.
 *
 * The function is designed to be used directly or as a base for more specialized theme variants.
 *
 * @author gupta.anirudh@zomato.com
 */
fun sushiGoldDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Gold900.asColorSpec(),
            v100 = SushiRawColorTokens.Gold800.asColorSpec(),
            v200 = SushiRawColorTokens.Gold700.asColorSpec(),
            v300 = SushiRawColorTokens.Gold600.asColorSpec(),
            v400 = SushiRawColorTokens.Gold500.asColorSpec(),
            v500 = SushiRawColorTokens.Gold600.asColorSpec(),
            v600 = SushiRawColorTokens.Gold300.asColorSpec(),
            v700 = SushiRawColorTokens.Gold200.asColorSpec(),
            v800 = SushiRawColorTokens.Gold100.asColorSpec(),
            v900 = SushiRawColorTokens.Gold050.asColorSpec(),
            accentColor = SushiRawColorTokens.Gold600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Gold050.asColorSpec(),
                v100 = SushiRawColorTokens.Gold100.asColorSpec(),
                v200 = SushiRawColorTokens.Gold200.asColorSpec(),
                v300 = SushiRawColorTokens.Gold300.asColorSpec(),
                v400 = SushiRawColorTokens.Gold400.asColorSpec(),
                v500 = SushiRawColorTokens.Gold600.asColorSpec(),
                v600 = SushiRawColorTokens.Gold600.asColorSpec(),
                v700 = SushiRawColorTokens.Gold700.asColorSpec(),
                v800 = SushiRawColorTokens.Gold800.asColorSpec(),
                v900 = SushiRawColorTokens.Gold900.asColorSpec(),
                accentColor = SushiRawColorTokens.Gold600.asColorSpec()
            )
        )
    )
}

fun sushiGoldLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiRawColorTokens.Gold050.asColorSpec(),
            v100 = SushiRawColorTokens.Gold100.asColorSpec(),
            v200 = SushiRawColorTokens.Gold200.asColorSpec(),
            v300 = SushiRawColorTokens.Gold300.asColorSpec(),
            v400 = SushiRawColorTokens.Gold400.asColorSpec(),
            v500 = SushiRawColorTokens.Gold600.asColorSpec(),
            v600 = SushiRawColorTokens.Gold600.asColorSpec(),
            v700 = SushiRawColorTokens.Gold700.asColorSpec(),
            v800 = SushiRawColorTokens.Gold800.asColorSpec(),
            v900 = SushiRawColorTokens.Gold900.asColorSpec(),
            accentColor = SushiRawColorTokens.Gold600.asColorSpec()
        ),
        baseColorScheme = SushiColorScheme.BaseColorScheme(
            theme = SushiColorScheme.ThemeColorScheme(
                v050 = SushiRawColorTokens.Gold050.asColorSpec(),
                v100 = SushiRawColorTokens.Gold100.asColorSpec(),
                v200 = SushiRawColorTokens.Gold200.asColorSpec(),
                v300 = SushiRawColorTokens.Gold300.asColorSpec(),
                v400 = SushiRawColorTokens.Gold400.asColorSpec(),
                v500 = SushiRawColorTokens.Gold600.asColorSpec(),
                v600 = SushiRawColorTokens.Gold600.asColorSpec(),
                v700 = SushiRawColorTokens.Gold700.asColorSpec(),
                v800 = SushiRawColorTokens.Gold800.asColorSpec(),
                v900 = SushiRawColorTokens.Gold900.asColorSpec(),
                accentColor = SushiRawColorTokens.Gold600.asColorSpec()
            )
        )
    )
}