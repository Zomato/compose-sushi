package com.zomato.sushi.compose

import androidx.compose.ui.window.ComposeUIViewController
import com.zomato.sushi.compose.foundation.FontLoader
import com.zomato.sushi.compose.sample.screen.MainActivityContent
import kotlinx.coroutines.runBlocking
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    // Sushi fonts are loaded into FontLoader's cache before any text renders.
    // iOS supports blocking, so we preload synchronously at view-controller
    // creation (mirrors the desktop entry point) to avoid a missing-font first
    // frame. Done outside the content lambda so it runs once, not per recomposition.
    runBlocking { FontLoader.preloadFonts() }
    return ComposeUIViewController { MainActivityContent() }
}
