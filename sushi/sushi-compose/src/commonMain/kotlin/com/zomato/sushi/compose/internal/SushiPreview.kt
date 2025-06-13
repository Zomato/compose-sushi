package com.zomato.sushi.compose.internal

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalInspectionMode
import com.zomato.sushi.compose.foundation.SushiColorTokenMapper
import com.zomato.sushi.compose.foundation.SushiDimension
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.foundation.SushiTypography
import com.zomato.sushi.compose.foundation.colorscheme.sushiDefaultDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiDefaultLightColorScheme
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * A wrapper composable that provides Sushi theming for component previews.
 * 
 * SushiPreview sets up the necessary theme environment including colors, typography,
 * and dimensions for accurately previewing Sushi components in Android Studio's
 * preview panel. It ensures that components are rendered with the correct theming
 * context, matching how they would appear in a real application.
 *
 * This composable also enables inspection mode to simulate preview rendering.
 *
 * @param typography The typography configuration to apply (defaults to current theme)
 * @param dimens The dimension configuration to apply (defaults to current theme)
 * @param colorTokenMapper Function to map color tokens to their visual representations
 * @param content The composable content to preview with Sushi theming
 *
 * @author gupta.anirudh@zomato.com
 */
@Composable
fun SushiPreview(
    typography: SushiTypography = SushiTheme.typography,
    dimens: SushiDimension = SushiTheme.dimens,
    colorTokenMapper: SushiColorTokenMapper = SushiTheme.colorTokenMapper,
    content: @Composable () -> Unit
) {
    val colorScheme = if (isSystemInDarkTheme()) {
        sushiDefaultDarkColorScheme()
    } else {
        sushiDefaultLightColorScheme()
    }
    CompositionLocalProvider(
        LocalInspectionMode provides true
    ) {
        SushiTheme(
            colorScheme = colorScheme,
            typography = typography,
            dimens = dimens,
            colorTokenMapper = colorTokenMapper,
            content = content
        )
    }
}

/**
 * Annotation for Sushi component previews.
 * 
 * This annotation combines multiple Preview annotations to generate both light and dark mode
 * previews of a component. It's designed to be used on @Composable functions that showcase
 * Sushi components, providing a standardized way to preview components across the design system.
 *
 * Components annotated with @SushiPreview will appear in Android Studio's preview panel
 * with both light and dark themes, allowing designers and developers to validate appearance
 * in both modes.
 *
 * @author gupta.anirudh@zomato.com
 */
@Suppress("ComposePreviewNaming")
// TODO: Use Multi Preview when its supported in CMP.
//@Preview(
//    showBackground = true,
//    backgroundColor = 0xFFFFFFFF,
//    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
//    name = "LightMode",
//    apiLevel = 34
//)
//@Preview(
//    showBackground = true,
//    backgroundColor = 0xFF17171C,
//    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
//    name = "DarkMode",
//    apiLevel = 34
//)
@Preview
annotation class SushiPreview