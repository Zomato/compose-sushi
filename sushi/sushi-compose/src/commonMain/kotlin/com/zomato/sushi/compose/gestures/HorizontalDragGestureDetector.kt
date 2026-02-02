package com.zomato.sushi.compose.gestures

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.horizontalDrag
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.AwaitPointerEventScope
import androidx.compose.ui.input.pointer.PointerEvent
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerId
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.PointerType
import androidx.compose.ui.input.pointer.changedToUpIgnoreConsumed
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.platform.ViewConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastFirstOrNull
import kotlin.math.abs
import kotlin.math.sign

/**
 * Detects horizontal drag gestures similar to [detectHorizontalDragGestures] but does not consume any events
 */
suspend fun PointerInputScope.detectHorizontalDragGesturesWithoutConsuming(
    onDragStart: (Offset) -> Unit = { },
    onDragEnd: () -> Unit = { },
    onDragCancel: () -> Unit = { },
    onHorizontalDrag: (change: PointerInputChange, dragAmount: Float) -> Unit
) {
    awaitEachGesture {
        val down = awaitFirstDown(requireUnconsumed = false)
        var overSlop = 0f
        val drag = awaitHorizontalPointerSlopOrCancellation(
            down.id,
            down.type
        ) { change, over ->
            overSlop = over
        }
        if (drag != null) {
            onDragStart.invoke(drag.position)
            onHorizontalDrag(drag, overSlop)
            if (
                horizontalDrag(drag.id) {
                    onHorizontalDrag(it, it.positionChange().x)
                    it.consume()
                }
            ) {
                onDragEnd()
            } else {
                onDragCancel()
            }
        }
    }
}

private suspend fun AwaitPointerEventScope.awaitHorizontalPointerSlopOrCancellation(
    pointerId: PointerId,
    pointerType: PointerType,
    onPointerSlopReached: (change: PointerInputChange, overSlop: Float) -> Unit
) = awaitPointerSlopOrCancellation(
    pointerId = pointerId,
    pointerType = pointerType,
    onPointerSlopReached = { change, overSlop -> onPointerSlopReached(change, overSlop.x) },
    pointerDirectionConfig = HorizontalPointerDirectionConfig
)

private suspend inline fun AwaitPointerEventScope.awaitPointerSlopOrCancellation(
    pointerId: PointerId,
    pointerType: PointerType,
    pointerDirectionConfig: PointerDirectionConfig,
    onPointerSlopReached: (PointerInputChange, Offset) -> Unit
): PointerInputChange? {
    if (currentEvent.isPointerUp(pointerId)) {
        return null // The pointer has already been lifted, so the gesture is canceled
    }
    val touchSlop = viewConfiguration.pointerSlop(pointerType)
    var pointer: PointerId = pointerId
    var totalPositionChange = Offset.Zero

    while (true) {
        val event = awaitPointerEvent()
        val dragEvent = event.changes.fastFirstOrNull { it.id == pointer } ?: return null
        if (false && dragEvent.isConsumed) {
            return null
        } else if (dragEvent.changedToUpIgnoreConsumed()) {
            val otherDown = event.changes.fastFirstOrNull { it.pressed }
            if (otherDown == null) {
                // This is the last "up"
                return null
            } else {
                pointer = otherDown.id
            }
        } else {
            val currentPosition = dragEvent.position
            val previousPosition = dragEvent.previousPosition

            val positionChange = currentPosition - previousPosition

            totalPositionChange += positionChange

            val inDirection = pointerDirectionConfig.calculateDeltaChange(
                totalPositionChange
            )

            if (inDirection < touchSlop) {
                // verify that nothing else consumed the drag event
                awaitPointerEvent(PointerEventPass.Final)
                if (dragEvent.isConsumed) {
                    return null
                }
            } else {
                val postSlopOffset = pointerDirectionConfig.calculatePostSlopOffset(
                    totalPositionChange,
                    touchSlop
                )

                onPointerSlopReached(
                    dragEvent,
                    postSlopOffset
                )
                if (dragEvent.isConsumed) {
                    return dragEvent
                } else {
                    totalPositionChange = Offset.Zero
                }
            }
        }
    }
}

private val HorizontalPointerDirectionConfig = object : PointerDirectionConfig {
    override fun calculateDeltaChange(offset: Offset): Float = abs(offset.x)

    override fun calculatePostSlopOffset(
        totalPositionChange: Offset,
        touchSlop: Float
    ): Offset {
        val finalMainPositionChange = totalPositionChange.x -
                (sign(totalPositionChange.x) * touchSlop)
        return Offset(finalMainPositionChange, totalPositionChange.y)
    }
}

private interface PointerDirectionConfig {
    fun calculateDeltaChange(offset: Offset): Float
    fun calculatePostSlopOffset(
        totalPositionChange: Offset,
        touchSlop: Float
    ): Offset
}

private fun PointerEvent.isPointerUp(pointerId: PointerId): Boolean =
    changes.fastFirstOrNull { it.id == pointerId }?.pressed != true

private fun ViewConfiguration.pointerSlop(pointerType: PointerType): Float {
    return when (pointerType) {
        PointerType.Mouse -> touchSlop * mouseToTouchSlopRatio
        else -> touchSlop
    }
}

private val mouseSlop = 0.125.dp

private val defaultTouchSlop = 18.dp // The default touch slop on Android devices

private val mouseToTouchSlopRatio = mouseSlop / defaultTouchSlop