package com.zomato.sushi.website

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.zomato.sushi.compose.foundation.FontLoader.preloadFonts
import kotlinx.coroutines.runBlocking

fun main() = application {
    runBlocking {
        preloadFonts()
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "Sushi UI Components"
    ) {
        App()
    }
}