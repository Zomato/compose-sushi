package com.zomato.sushi.compose.toast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert
import platform.UIKit.UIApplication
import platform.UIKit.endEditing
import platform.darwin.DISPATCH_TIME_NOW
import platform.darwin.dispatch_after
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_time
import platform.posix.int64_t

actual class ToastController{

    actual fun show(
        message: String,
        duration: ToastDuration
    ) {
        // Dismiss the keyboard if it's open
        dismissKeyboard()

        val alert = UIAlertController.alertControllerWithTitle(
            title = null,
            message = message,
            preferredStyle = UIAlertControllerStyleAlert
        )

        val rootViewController = UIApplication.sharedApplication.keyWindow?.rootViewController
        rootViewController?.presentViewController(alert, animated = true, completion = null)

        // Dismiss the alert after 2 seconds to mimic a toast
        val delay = dispatch_time(DISPATCH_TIME_NOW, toastDuration(duration))
        dispatch_after(delay, dispatch_get_main_queue()) {
            alert.dismissViewControllerAnimated(true, completion = null)
        }
    }

    //Function to dismiss the keyboard
    private fun dismissKeyboard() {
        val keyWindow = UIApplication.sharedApplication.keyWindow
        keyWindow?.endEditing(true)
    }

    private fun toastDuration(duration: ToastDuration): int64_t {
        return when (duration) {
            ToastDuration.Short -> 60
            ToastDuration.Long -> 120
        }
    }
}

@Composable
actual fun rememberToastController(): ToastController {
    return remember { ToastController() }
}