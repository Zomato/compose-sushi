package com.zomato.sushi.compose.sample.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiRedDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiRedLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiGreenDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiGreenLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiGreyDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiGreyLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiBlueDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiBlueLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiYellowDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiYellowLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiPurpleDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiPurpleLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiIndigoDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiIndigoLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiBrownDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiBrownLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiCiderDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiCiderLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiTealDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiTealLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiOrangeDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiOrangeLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiPinkDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiPinkLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiLimeDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiLimeLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiAvacadoDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiAvacadoLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiGoldDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiGoldLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiOnionDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiOnionLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiCharcoalDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiCharcoalLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiHoneyDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiHoneyLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiTangerineDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiTangerineLightColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiSlateDarkColorScheme
import com.zomato.sushi.compose.foundation.colorscheme.sushiSlateLightColorScheme

private val LocalThemeController = staticCompositionLocalOf<ThemeController> {
    error("ThemeController not provided")
}

object AppTheme {
    val themeController: ThemeController
        @Composable
        @ReadOnlyComposable
        get() = LocalThemeController.current
}

open class ThemeController(
    colorMode: AppColorMode = AppColorMode.Red,
    darkMode: Boolean = false
) {
    
    private val _colorMode: MutableState<AppColorMode> = mutableStateOf(colorMode)
    val colorMode: State<AppColorMode> = _colorMode
    
    private val _darkMode: MutableState<Boolean> = mutableStateOf(darkMode)
    val darkMode: State<Boolean> = _darkMode
    
    open fun updateColorMode(newColorMode: AppColorMode) {
        _colorMode.value = newColorMode
    }
    
    open fun updateDarkMode(newDarkMode: Boolean) {
        _darkMode.value = newDarkMode
    }
}

@Composable
fun AppTheme(
    themeController: ThemeController = defaultThemeController(),
    content: @Composable () -> Unit
) {
    val colorMode by themeController.colorMode
    val darkMode by themeController.darkMode

    val colorScheme = when(colorMode) {
        AppColorMode.Red -> {
            if (darkMode) sushiRedDarkColorScheme() else sushiRedLightColorScheme()
        }
        AppColorMode.Green -> {
            if (darkMode) sushiGreenDarkColorScheme() else sushiGreenLightColorScheme()
        }
        AppColorMode.Grey -> {
            if (darkMode) sushiGreyDarkColorScheme() else sushiGreyLightColorScheme()
        }
        AppColorMode.Blue -> {
            if (darkMode) sushiBlueDarkColorScheme() else sushiBlueLightColorScheme()
        }
        AppColorMode.Yellow -> {
            if (darkMode) sushiYellowDarkColorScheme() else sushiYellowLightColorScheme()
        }
        AppColorMode.Purple -> {
            if (darkMode) sushiPurpleDarkColorScheme() else sushiPurpleLightColorScheme()
        }
        AppColorMode.Indigo -> {
            if (darkMode) sushiIndigoDarkColorScheme() else sushiIndigoLightColorScheme()
        }
        AppColorMode.Brown -> {
            if (darkMode) sushiBrownDarkColorScheme() else sushiBrownLightColorScheme()
        }
        AppColorMode.Cider -> {
            if (darkMode) sushiCiderDarkColorScheme() else sushiCiderLightColorScheme()
        }
        AppColorMode.Teal -> {
            if (darkMode) sushiTealDarkColorScheme() else sushiTealLightColorScheme()
        }
        AppColorMode.Orange -> {
            if (darkMode) sushiOrangeDarkColorScheme() else sushiOrangeLightColorScheme()
        }
        AppColorMode.Pink -> {
            if (darkMode) sushiPinkDarkColorScheme() else sushiPinkLightColorScheme()
        }
        AppColorMode.Lime -> {
            if (darkMode) sushiLimeDarkColorScheme() else sushiLimeLightColorScheme()
        }
        AppColorMode.Avacado -> {
            if (darkMode) sushiAvacadoDarkColorScheme() else sushiAvacadoLightColorScheme()
        }
        AppColorMode.Gold -> {
            if (darkMode) sushiGoldDarkColorScheme() else sushiGoldLightColorScheme()
        }
        AppColorMode.Onion -> {
            if (darkMode) sushiOnionDarkColorScheme() else sushiOnionLightColorScheme()
        }
        AppColorMode.Charcoal -> {
            if (darkMode) sushiCharcoalDarkColorScheme() else sushiCharcoalLightColorScheme()
        }
        AppColorMode.Honey -> {
            if (darkMode) sushiHoneyDarkColorScheme() else sushiHoneyLightColorScheme()
        }
        AppColorMode.Tangerine -> {
            if (darkMode) sushiTangerineDarkColorScheme() else sushiTangerineLightColorScheme()
        }
        AppColorMode.Slate -> {
            if (darkMode) sushiSlateDarkColorScheme() else sushiSlateLightColorScheme()
        }

    }

    CompositionLocalProvider(
        LocalThemeController provides themeController
    ) {
        SushiTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}

enum class AppColorMode {
    Red,
    Green,
    Grey,
    Blue,
    Yellow,
    Purple,
    Indigo,
    Brown,
    Cider,
    Teal,
    Orange,
    Pink,
    Lime,
    Avacado,
    Gold,
    Onion,
    Charcoal,
    Honey,
    Tangerine,
    Slate
}

@Composable
fun defaultThemeController(): ThemeController {
    val isSystemInDarkTheme = isSystemInDarkTheme()
    val themeController = remember {
        ThemeController(
            darkMode = isSystemInDarkTheme
        )
    }
    return themeController
}