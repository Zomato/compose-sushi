package com.zomato.sushi.compose.components.calender.data

internal actual fun log(tag: String, message: String) =
    consoleLog("$tag : $message")

@JsFun("(output) => console.log(output)")
private external fun consoleLog(vararg output: String?)