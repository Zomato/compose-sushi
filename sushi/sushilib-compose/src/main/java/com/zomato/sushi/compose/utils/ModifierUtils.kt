package com.zomato.sushi.compose.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

/**
 * @author gupta.anirudh@zomato.com
 */

@Composable
inline fun Modifier.ifTrue(condition: Boolean, crossinline transform: @Composable Modifier.() -> Modifier): Modifier {
    return if (condition) {
        this.transform()
    } else {
        this
    }
}

@Composable
inline fun <T> Modifier.ifNonNull(data: T?, crossinline transform: @Composable Modifier.(it: T) -> Modifier): Modifier {
    return if (data != null) {
        this.transform(data)
    } else {
        this
    }
}

inline fun Modifier.invisible(isInvisible: Boolean = true) = if (isInvisible) this.then(Modifier.drawWithContent {  }) else this

internal val LocalDebounceEventHandler = staticCompositionLocalOf<DebouncedEventHandler> { DebouncedEventHandler(1000) }

open class DebouncedEventHandler(private val debounceDurationMs: Long) {
    protected var lastEventTimeMs: Long = 0
        private set

    fun processEvent(event: () -> Unit) {
        val now = System.currentTimeMillis()
        if (now - lastEventTimeMs >= debounceDurationMs) {
            event.invoke()
        }
        lastEventTimeMs = now
    }
}

@SuppressLint("ComposeModifierComposed")
fun Modifier.atomClickable(
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    showIndication: Boolean? = false,
    debounced: Boolean? = false,
    onClick: () -> Unit
) = composed(inspectorInfo = debugInspectorInfo {
    name = "clickable"
    properties["enabled"] = enabled
    properties["onClickLabel"] = onClickLabel
    properties["role"] = role
    properties["onClick"] = onClick
}) {
    val eventDebouncer = LocalDebounceEventHandler.current
    Modifier.clickable(
        enabled = enabled,
        onClickLabel = onClickLabel,
        onClick = { if (debounced == true) eventDebouncer.processEvent { onClick() } else onClick() },
        role = role,
        indication = if (showIndication == true) LocalIndication.current else null,
        interactionSource = remember { MutableInteractionSource() }
    )
}

@OptIn(ExperimentalSushiApi::class)
@Composable
fun Modifier.dashedBorder(
    strokeWidth: Dp,
    color: Color,
    cornerRadiusDp: Dp,
    dashOnWidth: Float = 10f,
    dashOffWidth: Float = 10f
): Modifier {
    val density = LocalDensity.current
    val strokeWidthPx = density.run { strokeWidth.toPx() }
    val cornerRadiusPx = density.run { cornerRadiusDp.toPx() }

    return this.then(
        Modifier.drawWithCache {
            onDrawBehind {
                val stroke = Stroke(
                    width = strokeWidthPx,
                    pathEffect = PathEffect.dashPathEffect(
                        floatArrayOf(dashOnWidth, dashOffWidth),
                        0f
                    )
                )

                drawRoundRect(
                    color = color,
                    style = stroke,
                    cornerRadius = CornerRadius(cornerRadiusPx)
                )
            }
        }
    )
}