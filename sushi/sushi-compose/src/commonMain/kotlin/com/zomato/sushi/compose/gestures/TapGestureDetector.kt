package com.zomato.sushi.compose.gestures

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.changedToUpIgnoreConsumed
import kotlinx.coroutines.coroutineScope

/**
 * Detects tap gestures and calls [onTap] when detected.
 * This does not consume any events, and [onTap] will be called even if the event has been consumed
 * by someone else.
 *
 * After the initial press event, if the pointer moves out of the input area, the gestures are considered
 * canceled. That means [onTap] will not be called after a gesture has been canceled.
 */
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