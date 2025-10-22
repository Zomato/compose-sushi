package com.zomato.sushi.compose.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
actual fun rememberWindowMetrics(): WindowMetrics {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current

    return remember(configuration, density) {
        object : WindowMetrics {
            override val windowWidthPx: Int = with(density) { configuration.screenWidthDp.dp.roundToPx() }
            override val windowHeightPx: Int = with(density) { configuration.screenHeightDp.dp.roundToPx() }
        }
    }
}
