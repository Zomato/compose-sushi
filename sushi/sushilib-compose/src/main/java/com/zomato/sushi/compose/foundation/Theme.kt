@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.foundation

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
 * @author gupta.anirudh@zomato.com
 */
typealias SushiColorTokenMapper = (colorToken: SushiColorToken) -> ColorSpec
typealias SushiFontSizeMultiplier = (TextUnit) -> TextUnit

fun sushiDimension(
    spacing: SushiDimension.Spacing = SushiDimension.Spacing(),
    cornerRadius: Dp = SushiCornerRadius
): SushiDimension = SushiDimension(
    spacing = spacing,
    cornerRadius = cornerRadius
)

@JvmSynthetic
fun sushiDefaultColorScheme() = sushiLightColorScheme()

internal val LocalSushiColorScheme = staticCompositionLocalOf<SushiColorScheme> { sushiDefaultColorScheme() }
internal val LocalSushiTypography = staticCompositionLocalOf<SushiTypography> { sushiTypography() }
internal val LocalSushiDimension = staticCompositionLocalOf<SushiDimension> { sushiDimension() }
internal val LocalSushiFontSizeMultiplier = staticCompositionLocalOf<SushiFontSizeMultiplier> { { it } }
internal val LocalSushiColorTokenMapper = staticCompositionLocalOf<SushiColorTokenMapper> {
    { SushiUnspecified.asColorSpec() }
}

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
object SushiTheme {
    /**
     * Retrieves the current [SushiColorScheme] at the call site's position in the hierarchy.
     */
    val colors: SushiColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalSushiColorScheme.current

    /**
     * Retrieves the current [SushiTypography] at the call site's position in the hierarchy.
     */
    val typography: SushiTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalSushiTypography.current

    /**
     * Retrieves the current [SushiColorScheme] at the call site's position in the hierarchy.
     */
    val dimens: SushiDimension
        @Composable
        @ReadOnlyComposable
        get() = LocalSushiDimension.current

    /**
     * Retrieves the current font size multiplier at the call site's position in the hierarchy.
     * This font size multiplier is applied on top of platform's font scaling logic.
     */
    val fontSizeMultiplier: SushiFontSizeMultiplier
        @Composable
        @ReadOnlyComposable
        get() = LocalSushiFontSizeMultiplier.current

    /**
     * Retrieves the current [SushiColorTokenMapper] at the call site's position in the hierarchy.
     */
    val colorTokenMapper: SushiColorTokenMapper
        @Composable
        @ReadOnlyComposable
        get() = LocalSushiColorTokenMapper.current


}

/**
 * Retrieves if dark mode is enabled at the call site's position in the hierarchy.
 */
val SushiTheme.isDarkMode: Boolean
    @Composable
    @ReadOnlyComposable
    get() = SushiTheme.colorSchemeType == SushiColorSchemeType.Dark

/**
 * Retrieves the current [SushiColorSchemeType] at the call site's position in the hierarchy.
 */
val SushiTheme.colorSchemeType: SushiColorSchemeType
    @Composable
    @ReadOnlyComposable
    get() = SushiTheme.colors.schemeType

/**
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
    CompositionLocalProvider(
        LocalSushiColorScheme provides colorScheme,
        LocalSushiTypography provides typography,
        LocalSushiDimension provides dimens,
        LocalSushiFontSizeMultiplier provides fontSizeMultiplier,
        LocalSushiColorTokenMapper provides colorTokenMapper
    ) {
        MaterialTheme(
            colorScheme = colorScheme.material,
            shapes = MaterialTheme.shapes,
            typography = typography.materialTypography,
            content = content
        )
    }
}