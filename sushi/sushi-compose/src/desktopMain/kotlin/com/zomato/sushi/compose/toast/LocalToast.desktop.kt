package com.zomato.sushi.compose.toast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

actual class ToastController internal actual constructor() {
    actual fun show(message: String, duration: ToastDuration) {
        // Desktop implementation - could log to console or show a system notification
        println("Toast: $message")
    }
}

@Composable
actual fun rememberToastController(): ToastController {
    return remember { ToastController() }
}