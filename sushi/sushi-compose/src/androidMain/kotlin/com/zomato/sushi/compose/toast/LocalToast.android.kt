package com.zomato.sushi.compose.toast

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

actual class ToastController internal actual constructor() {
    private var context: Context? = null
    internal constructor(context: Context) : this() {
        this.context = context
    }

    actual fun show(
        message: String,
        duration: ToastDuration
    ) {
        Toast.makeText(context, message, toastDuration(duration)).show()
    }

    private fun toastDuration(duration: ToastDuration): Int {
        return when (duration) {
            ToastDuration.Short -> Toast.LENGTH_SHORT
            ToastDuration.Long -> Toast.LENGTH_LONG
        }
    }
}

@Composable
actual fun rememberToastController(): ToastController {
    val context = LocalContext.current
    return remember(context) {
        ToastController(context)
    }
}