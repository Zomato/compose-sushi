package com.zomato.sushi.compose.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.window.rememberWindowState

@Composable
actual fun rememberWindowMetrics(): WindowMetrics {
    val windowState = rememberWindowState()

    return remember(windowState) {
        object : WindowMetrics {
            override val windowWidthPx: Int = windowState.size.width.value.toInt()
            override val windowHeightPx: Int = windowState.size.height.value.toInt()
        }
    }
}