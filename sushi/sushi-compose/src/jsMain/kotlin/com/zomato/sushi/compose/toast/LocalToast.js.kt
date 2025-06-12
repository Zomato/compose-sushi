package com.zomato.sushi.compose.toast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

// TODO: js implementation to be added
actual class ToastController {

    actual fun show(
        message: String,
        duration: ToastDuration
    ) {

    }
}

@Composable
actual fun rememberToastController(): ToastController {
    return remember { ToastController() }
}