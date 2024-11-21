@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.foundation

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

fun sushiGreenColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiGreenLightColorScheme()
        SushiColorSchemeType.Dark -> sushiGreenDarkColorScheme()
    }
}

fun sushiGreenDarkColorScheme(
    materialColorScheme: ColorScheme = darkColorScheme()
): SushiColorScheme {
    return sushiDarkColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiGreen900,
            v100 = SushiGreen800,
            v200 = SushiGreen700,
            v300 = SushiGreen600,
            v400 = SushiGreen500,
            v500 = SushiGreen600,
            v600 = SushiGreen300,
            v700 = SushiGreen200,
            v800 = SushiGreen100,
            v900 = SushiGreen050,
            accentColor = SushiGreen600
        )
    )
}

fun sushiGreenLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiGreen050,
            v100 = SushiGreen100,
            v200 = SushiGreen200,
            v300 = SushiGreen300,
            v400 = SushiGreen400,
            v500 = SushiGreen600,
            v600 = SushiGreen600,
            v700 = SushiGreen700,
            v800 = SushiGreen800,
            v900 = SushiGreen900,
            accentColor = SushiGreen600
        )
    )
}