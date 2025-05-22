package com.zomato.sushi.compose.toast

import androidx.compose.runtime.Composable

enum class ToastDuration {
    Short, Long
}

expect class ToastController internal constructor() {
    fun show(message: String, duration: ToastDuration = ToastDuration.Short)
}

@Composable
expect fun rememberToastController(): ToastController