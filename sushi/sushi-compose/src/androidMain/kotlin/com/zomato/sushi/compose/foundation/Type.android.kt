package com.zomato.sushi.compose.foundation

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.zomato.sushi.compose.R

/**
 * Defines the Okra font family used as the primary typeface in the Sushi design system.
 *
 * @author gupta.anirudh@zomato.com
 */
actual val OkraFontFamily: FontFamily = FontFamily(
    Font(R.font.okra_thin, FontWeight(50)),
    Font(R.font.okra_thin, FontWeight.W100),
    Font(R.font.okra_extralight, FontWeight.W200),
    Font(R.font.okra_light, FontWeight.W300),
    Font(R.font.okra_regular, FontWeight.W400),
    Font(R.font.okra_regular, FontWeight.W500),
    Font(R.font.okra_medium, FontWeight.W600),
    Font(R.font.okra_semibold, FontWeight.W700),
    Font(R.font.okra_bold, FontWeight.W800),
    Font(R.font.okra_bold, FontWeight.W900)
)

/**
 * Defines the Wasabicons font family used for icons in the Sushi design system.
 *
 * This custom icon font allows rendering vector icons as text characters,
 * enabling efficient icon display with color and size control through text styling.
 */
actual val WasabiFontFamily = FontFamily(
    Font(R.font.wasabicons)
)

/**
 * Default Material Typography with Okra font family applied to all text styles.
 *
 * This ensures that standard Material components will use the Sushi design system's
 * primary font family while maintaining Material's typography scale.
 */
internal actual val MaterialTypography = Typography().let {
    it.copy(
        displayLarge = it.displayLarge.copy(fontFamily = OkraFontFamily),
        displayMedium = it.displayMedium.copy(fontFamily = OkraFontFamily),
        displaySmall = it.displaySmall.copy(fontFamily = OkraFontFamily),
        headlineLarge = it.headlineLarge.copy(fontFamily = OkraFontFamily),
        headlineMedium = it.headlineMedium.copy(fontFamily = OkraFontFamily),
        headlineSmall = it.headlineSmall.copy(fontFamily = OkraFontFamily),
        titleLarge = it.titleLarge.copy(fontFamily = OkraFontFamily),
        titleMedium = it.titleMedium.copy(fontFamily = OkraFontFamily),
        titleSmall = it.titleSmall.copy(fontFamily = OkraFontFamily),
        bodyLarge = it.bodyLarge.copy(fontFamily = OkraFontFamily),
        bodyMedium = it.bodyMedium.copy(fontFamily = OkraFontFamily),
        bodySmall = it.bodySmall.copy(fontFamily = OkraFontFamily),
        labelLarge = it.labelLarge.copy(fontFamily = OkraFontFamily),
        labelMedium = it.labelMedium.copy(fontFamily = OkraFontFamily),
        labelSmall = it.labelSmall.copy(fontFamily = OkraFontFamily)
    )
}