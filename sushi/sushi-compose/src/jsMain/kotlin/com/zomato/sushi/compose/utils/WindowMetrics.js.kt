package com.zomato.sushi.compose.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.browser.window

@Composable
actual fun rememberWindowMetrics(): WindowMetrics {
    return remember {
        object : WindowMetrics {
            override val windowWidthPx: Int = window.innerWidth
            override val windowHeightPx: Int = window.innerHeight
        }
    }
}