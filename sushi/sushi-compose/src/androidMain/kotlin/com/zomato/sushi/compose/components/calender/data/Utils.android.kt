package com.zomato.sushi.compose.components.calender.data

import android.util.Log

internal actual fun log(tag: String, message: String) {
    Log.w(tag, message)
}