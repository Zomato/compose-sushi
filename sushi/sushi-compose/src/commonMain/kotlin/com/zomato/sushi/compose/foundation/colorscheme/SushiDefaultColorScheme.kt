package com.zomato.sushi.compose.foundation.colorscheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiColorScheme
import com.zomato.sushi.compose.foundation.SushiColorSchemeType
import com.zomato.sushi.compose.foundation.SushiRawColorTokens


/**
 * Returns the default color scheme for the Sushi design system.
 *
 * @param type The type of color scheme to return
 * @return The default color scheme for the Sushi design system
 */
fun sushiDefaultColorScheme(type: SushiColorSchemeType): SushiColorScheme {
    return when (type) {
        SushiColorSchemeType.Light -> sushiRedLightColorScheme()
        SushiColorSchemeType.Dark -> sushiRedDarkColorScheme()
    }
}

/**
 * Returns the default color scheme for the Sushi design system (dark mode).
 *
 * @return The default color scheme for the Sushi design system (dark mode)
 */
fun sushiDefaultDarkColorScheme() = sushiRedDarkColorScheme()

/**
 * Returns the default color scheme for the Sushi design system (light mode).
 *
 * Currently, the light color scheme is used as the default. This function provides a way to retrieve the default color scheme.
 *
 * @return The default color scheme for the Sushi design system (light mode)
 */
fun sushiDefaultLightColorScheme() = sushiRedLightColorScheme()