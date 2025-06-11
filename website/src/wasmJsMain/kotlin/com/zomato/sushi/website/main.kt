package com.zomato.sushi.website

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import androidx.navigation.ExperimentalBrowserHistoryApi
import com.zomato.sushi.compose.foundation.FontLoader.preloadFonts
import kotlinx.browser.document
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private val scope = CoroutineScope(Dispatchers.Default)

@OptIn(ExperimentalComposeUiApi::class, ExperimentalBrowserHistoryApi::class)
fun main() {
    val job = scope.launch {
        preloadFonts()
        val body = document.body!!
        ComposeViewport(body) {
            App()
        }
    }
}