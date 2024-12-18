package com.zomato.sushi.compose.foundation

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.zomato.sushi.compose.R

/**
 * @author gupta.anirudh@zomato.com
 */
val OkraFontFamily = FontFamily(
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

val WasabiFontFamily = FontFamily(
    Font(R.font.wasabicons)
)

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
data class SushiTypography(
    val materialTypography: Typography,
    val light050: TextStyle,
    val light100: TextStyle,
    val light200: TextStyle,
    val light300: TextStyle,
    val light400: TextStyle,
    val light500: TextStyle,
    val light600: TextStyle,
    val light700: TextStyle,
    val light800: TextStyle,
    val light900: TextStyle,
    val regular050: TextStyle,
    val regular100: TextStyle,
    val regular200: TextStyle,
    val regular300: TextStyle,
    val regular400: TextStyle,
    val regular500: TextStyle,
    val regular600: TextStyle,
    val regular700: TextStyle,
    val regular800: TextStyle,
    val regular900: TextStyle,
    val medium050: TextStyle,
    val medium100: TextStyle,
    val medium200: TextStyle,
    val medium300: TextStyle,
    val medium400: TextStyle,
    val medium500: TextStyle,
    val medium600: TextStyle,
    val medium700: TextStyle,
    val medium800: TextStyle,
    val medium900: TextStyle,
    val semiBold050: TextStyle,
    val semiBold100: TextStyle,
    val semiBold200: TextStyle,
    val semiBold300: TextStyle,
    val semiBold400: TextStyle,
    val semiBold500: TextStyle,
    val semiBold600: TextStyle,
    val semiBold700: TextStyle,
    val semiBold800: TextStyle,
    val semiBold900: TextStyle,
    val bold050: TextStyle,
    val bold100: TextStyle,
    val bold200: TextStyle,
    val bold300: TextStyle,
    val bold400: TextStyle,
    val bold500: TextStyle,
    val bold600: TextStyle,
    val bold700: TextStyle,
    val bold800: TextStyle,
    val bold900: TextStyle,
    val extraBold050: TextStyle,
    val extraBold100: TextStyle,
    val extraBold200: TextStyle,
    val extraBold300: TextStyle,
    val extraBold400: TextStyle,
    val extraBold500: TextStyle,
    val extraBold600: TextStyle,
    val extraBold700: TextStyle,
    val extraBold800: TextStyle,
    val extraBold900: TextStyle
)

internal val MaterialTypography = Typography().let {
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
