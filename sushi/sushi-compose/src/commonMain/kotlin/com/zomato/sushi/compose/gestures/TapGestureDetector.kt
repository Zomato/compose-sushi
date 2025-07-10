package com.zomato.sushi.compose.gestures

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.changedToUpIgnoreConsumed
import kotlinx.coroutines.coroutineScope

suspend fun PointerInputScope.detectTapGestureWithoutConsuming(
    onTap: () -> Unit
) = coroutineScope {
    awaitEachGesture {
        awaitFirstDown(requireUnconsumed = false)
        val changedToUp = awaitPointerEvent().changes.all { it.changedToUpIgnoreConsumed() }
        if (changedToUp) {
            onTap()
        }
    }
}