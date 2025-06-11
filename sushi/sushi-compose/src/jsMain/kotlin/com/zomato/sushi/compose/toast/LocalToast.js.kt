package com.zomato.sushi.compose.toast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

actual class ToastController{

    actual fun show(
        message: String,
        duration: ToastDuration
    ) {
        // todox:
    }
}

@Composable
actual fun rememberToastController(): ToastController {
    return remember { ToastController() }
}