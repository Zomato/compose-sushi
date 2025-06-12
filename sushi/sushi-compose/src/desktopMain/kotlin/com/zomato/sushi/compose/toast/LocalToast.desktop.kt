package com.zomato.sushi.compose.toast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

actual class ToastController internal actual constructor() {
    actual fun show(message: String, duration: ToastDuration) {
        // TODO: desktop implementation to be added
    }
}

@Composable
actual fun rememberToastController(): ToastController {
    return remember { ToastController() }
}