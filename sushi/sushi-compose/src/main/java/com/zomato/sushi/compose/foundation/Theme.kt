@file:SuppressLint("ComposeCompositionLocalUsage")

package com.zomato.sushi.compose.foundation

import android.annotation.SuppressLint
import androidx.compose.foundation.LocalIndication
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.core.SushiColorToken

/**
 * Function type that maps color tokens to ColorSpec values
 *
 * @author gupta.anirudh@zomato.com
 */
typealias SushiColorTokenMapper = (colorToken: SushiColorToken) -> ColorSpec

/** Function type that applies font size scaling */
typealias SushiFontSizeMultiplier = (TextUnit) -> TextUnit

/**
 * Creates a SushiDimension instance with the provided spacing and corner radius or defaults.
 * 
 * This function allows for customization of the dimension system used throughout the Sushi design system.
 * It takes in a spacing configuration and a corner radius, returning a fully configured SushiDimension instance.
 *
 * @param spacing Spacing configuration for the dimension system
 * @param cornerRadius Standard corner radius for rounded shapes
 * @return A configured SushiDimension instance
 */
fun sushiDimension(
    spacing: SushiDimension.Spacing = SushiDimension.Spacing(),
    cornerRadius: Dp = SushiCornerRadius
): SushiDimension = SushiDimension(
    spacing = spacing,
    cornerRadius = cornerRadius
)

/**
 * Returns the default color scheme for the Sushi design system.
 * 
 * Currently, the light color scheme is used as the default. This function provides a way to retrieve the default color scheme.
 *
 * @return The default color scheme for the Sushi design system
 */
@JvmSynthetic
fun sushiDefaultColorScheme() = sushiLightColorScheme()

/**
 * Provides the current Sushi color scheme.
 */
internal val LocalSushiColorScheme = staticCompositionLocalOf<SushiColorScheme> { sushiDefaultColorScheme() }

/**
 * Provides the current Sushi typography.
 */
internal val LocalSushiTypography = staticCompositionLocalOf<SushiTypography> { sushiTypography() }

/**
 * Provides the current Sushi dimension system.
 */
internal val LocalSushiDimension = staticCompositionLocalOf<SushiDimension> { sushiDimension() }

/**
 * Provides the current font size multiplier.
 */
internal val LocalSushiFontSizeMultiplier = staticCompositionLocalOf<SushiFontSizeMultiplier> { { it } }

/**
 * Provides the current color token mapper.
 */
internal val LocalSushiColorTokenMapper = staticCompositionLocalOf<SushiColorTokenMapper> {
    { SushiUnspecified.asColorSpec() }
}

/**
 * Provides access to the current theme properties in the Sushi design system.
 * 
 * The SushiTheme object serves as a gateway to access colors, typography, dimensions, and other theming properties throughout the application.
 * It uses CompositionLocal under the hood to provide theme values based on the current composition hierarchy.
 *
 * @author gupta.anirudh@zomato.com
 */
object SushiTheme {
    /**
     * Retrieves the current [SushiColorScheme] at the call site's position in the hierarchy.
     * 
     * This property provides access to the current color scheme, allowing components to adapt their appearance based on the active color scheme.
     */
    val colors: SushiColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalSushiColorScheme.current

    /**
     * Retrieves the current [SushiTypography] at the call site's position in the hierarchy.
     * 
     * This property provides access to the current typography configuration, enabling consistent typography across the application.
     */
    val typography: SushiTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalSushiTypography.current

    /**
     * Retrieves the current [SushiDimension] at the call site's position in the hierarchy.
     * 
     * This property provides access to the current dimension system, which defines standard spacing and corner radius values for the application.
     */
    val dimens: SushiDimension
        @Composable
        @ReadOnlyComposable
        get() = LocalSushiDimension.current

    /**
     * Retrieves the current font size multiplier at the call site's position in the hierarchy.
     * 
     * This property provides access to the current font size multiplier, which is applied on top of the platform's font scaling logic.
     */
    val fontSizeMultiplier: SushiFontSizeMultiplier
        @Composable
        @ReadOnlyComposable
        get() = LocalSushiFontSizeMultiplier.current

    /**
     * Retrieves the current [SushiColorTokenMapper] at the call site's position in the hierarchy.
     * 
     * This property provides access to the current color token mapper, which maps color tokens to ColorSpec values.
     */
    val colorTokenMapper: SushiColorTokenMapper
        @Composable
        @ReadOnlyComposable
        get() = LocalSushiColorTokenMapper.current
}

/**
 * Retrieves if dark mode is enabled at the call site's position in the hierarchy.
 * 
 * This property provides a way to check if dark mode is currently enabled, allowing components to adapt their appearance accordingly.
 */
val SushiTheme.isDarkMode: Boolean
    @Composable
    @ReadOnlyComposable
    get() = SushiTheme.colorSchemeType == SushiColorSchemeType.Dark

/**
 * Retrieves the current SushiColorSchemeType at the call site's position in the hierarchy.
 * 
 * This property provides access to the current color scheme type, which differentiates between light and dark mode color schemes.
 */
val SushiTheme.colorSchemeType: SushiColorSchemeType
    @Composable
    @ReadOnlyComposable
    get() = SushiTheme.colors.schemeType

/**
 * Composable function that provides Sushi theming to its content.
 * 
 * This function sets up Sushi-specific theming (for Sushi design system components).
 * It allows customization of colors, typography, dimensions, and other theme attributes.
 *
 * @param colorScheme Color scheme to apply to the content
 * @param typography Typography configuration to apply to the content
 * @param dimens Dimension system to apply to the content
 * @param fontSizeMultiplier Function to scale font sizes
 * @param colorTokenMapper Function to map color tokens to ColorSpec values
 * @param content Content to which the theming will be applied
 *
 * @author gupta.anirudh@zomato.com
 */
@Composable
fun SushiTheme(
    colorScheme: SushiColorScheme = SushiTheme.colors,
    typography: SushiTypography = SushiTheme.typography,
    dimens: SushiDimension = SushiTheme.dimens,
    fontSizeMultiplier: SushiFontSizeMultiplier = SushiTheme.fontSizeMultiplier,
    colorTokenMapper: SushiColorTokenMapper = SushiTheme.colorTokenMapper,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = colorScheme.material,
        shapes = MaterialTheme.shapes,
        typography = typography.materialTypography
    ) {
        CompositionLocalProvider(
            LocalSushiColorScheme provides colorScheme,
            LocalSushiTypography provides typography,
            LocalSushiDimension provides dimens,
            LocalSushiFontSizeMultiplier provides fontSizeMultiplier,
            LocalSushiColorTokenMapper provides colorTokenMapper,
            LocalIndication provides noIndication(),
            content = content
        )
    }
}