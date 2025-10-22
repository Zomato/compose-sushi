package com.zomato.sushi.compose.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun rememberWindowMetrics(): WindowMetrics {
    val windowInfo = LocalWindowInfo.current
    return remember {
        object : WindowMetrics {
            override val windowWidthPx: Int = windowInfo.containerSize.width
            override val windowHeightPx: Int = windowInfo.containerSize.height
        }
    }
}
