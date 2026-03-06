package com.zomato.sushi.compose.components.calender.data

internal actual fun log(tag: String, message: String) =
    console.log("$tag : $message")