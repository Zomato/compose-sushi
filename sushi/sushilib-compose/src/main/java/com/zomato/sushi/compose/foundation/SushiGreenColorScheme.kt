@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.foundation

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec

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
            v050 = SushiGreen900.asColorSpec(),
            v100 = SushiGreen800.asColorSpec(),
            v200 = SushiGreen700.asColorSpec(),
            v300 = SushiGreen600.asColorSpec(),
            v400 = SushiGreen500.asColorSpec(),
            v500 = SushiGreen600.asColorSpec(),
            v600 = SushiGreen300.asColorSpec(),
            v700 = SushiGreen200.asColorSpec(),
            v800 = SushiGreen100.asColorSpec(),
            v900 = SushiGreen050.asColorSpec(),
            accentColor = SushiGreen600.asColorSpec()
        )
    )
}

fun sushiGreenLightColorScheme(
    materialColorScheme: ColorScheme = lightColorScheme()
): SushiColorScheme {
    return sushiLightColorScheme(
        materialColorScheme = materialColorScheme,
        themeColorScheme = SushiColorScheme.ThemeColorScheme(
            v050 = SushiGreen050.asColorSpec(),
            v100 = SushiGreen100.asColorSpec(),
            v200 = SushiGreen200.asColorSpec(),
            v300 = SushiGreen300.asColorSpec(),
            v400 = SushiGreen400.asColorSpec(),
            v500 = SushiGreen600.asColorSpec(),
            v600 = SushiGreen600.asColorSpec(),
            v700 = SushiGreen700.asColorSpec(),
            v800 = SushiGreen800.asColorSpec(),
            v900 = SushiGreen900.asColorSpec(),
            accentColor = SushiGreen600.asColorSpec()
        )
    )
}