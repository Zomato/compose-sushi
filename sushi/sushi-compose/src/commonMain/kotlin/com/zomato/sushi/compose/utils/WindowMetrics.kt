package com.zomato.sushi.compose.utils

import androidx.compose.runtime.Composable

interface WindowMetrics {
    val windowWidthPx: Int
    val windowHeightPx: Int
}

@Composable
expect fun rememberWindowMetrics(): WindowMetrics
