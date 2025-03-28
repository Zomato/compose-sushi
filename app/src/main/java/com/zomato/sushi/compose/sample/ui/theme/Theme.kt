package com.zomato.sushi.compose.sample.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.foundation.sushiDarkColorScheme
import com.zomato.sushi.compose.foundation.sushiGreenDarkColorScheme
import com.zomato.sushi.compose.foundation.sushiGreenLightColorScheme
import com.zomato.sushi.compose.foundation.sushiLightColorScheme
import androidx.compose.runtime.getValue

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
            if (darkMode) sushiDarkColorScheme() else sushiLightColorScheme()
        }
        AppColorMode.Green -> {
            if (darkMode) sushiGreenDarkColorScheme() else sushiGreenLightColorScheme()
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
    Red, Green
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