package com.zomato.sushi.compose.sample.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.zomato.sushi.compose.sample.modifiers.CircularReveal
import com.zomato.sushi.compose.sample.ui.theme.AppColorMode
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import com.zomato.sushi.compose.sample.ui.theme.ThemeController

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val themeController = AppTheme.themeController
    CircularReveal(
        themeController.colorMode.value to themeController.darkMode.value,
        modifier
    ) { theme ->
        AppTheme(
            themeController = remember {
                object : ThemeController(theme.first, theme.second) {
                    override fun updateDarkMode(newDarkMode: Boolean) {
                        themeController.updateDarkMode(newDarkMode)
                    }

                    override fun updateColorMode(newColorMode: AppColorMode) {
                        themeController.updateColorMode(newColorMode)
                    }
                }
            }
        ) {
            content()
        }
    }
}