package com.zomato.sushi.compose.components.calender.data

import platform.Foundation.NSLog

internal actual fun log(tag: String, message: String) =
    NSLog("$tag : $message")