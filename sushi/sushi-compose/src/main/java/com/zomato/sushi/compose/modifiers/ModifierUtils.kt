package com.zomato.sushi.compose.modifiers

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

/**
 * Collection of utility modifier extensions to enhance composable behavior and appearance.
 * 
 * These extension functions provide common modifier functionality used across the Sushi design system,
 * such as conditional modifiers, debounceable click handling, and specialized visual effects.
 *
 * @author gupta.anirudh@zomato.com
 */

/**
 * Conditionally applies a transform to the modifier if the condition is true.
 * 
 * This allows for cleaner conditional modifier chaining compared to if/else statements.
 *
 * @param condition The boolean condition to evaluate
 * @param transform The transformation to apply if the condition is true
 * @return The transformed modifier if the condition is true, otherwise the original modifier
 */
@Composable
inline fun Modifier.ifTrue(condition: Boolean, crossinline transform: @Composable Modifier.() -> Modifier): Modifier {
    return if (condition) {
        this.transform()
    } else {
        this
    }
}

/**
 * Conditionally applies a transform to the modifier if the data is not null.
 * 
 * This is particularly useful for applying modifiers based on optional parameters.
 *
 * @param data The data to check for null
 * @param transform The transformation to apply if the data is not null, receiving the data as a parameter
 * @return The transformed modifier if the data is not null, otherwise the original modifier
 */
@Composable
inline fun <T> Modifier.ifNonNull(data: T?, crossinline transform: @Composable Modifier.(it: T) -> Modifier): Modifier {
    return if (data != null) {
        this.transform(data)
    } else {
        this
    }
}

/**
 * Makes a component invisible (but still taking up space).
 *
 * Unlike Modifier.visible() which affects the layout, this only affects rendering.
 *
 * @return A modifier that makes the component invisible when the condition is true
 */
inline fun Modifier.invisible() = this.invisibleIf(true)

/**
 * Makes a component invisible (but still taking up space) if the condition is true.
 * 
 * Unlike Modifier.visible() which affects the layout, this only affects rendering.
 *
 * @param isInvisible Whether the component should be invisible
 * @return A modifier that makes the component invisible when the condition is true
 */
inline fun Modifier.invisibleIf(isInvisible: Boolean) = if (isInvisible) this.then(Modifier.drawWithContent {  }) else this

/**
 * A CompositionLocal for accessing the current debounce handler.
 */
internal val LocalDebounceEventHandler = staticCompositionLocalOf<DebouncedEventHandler> { DebouncedEventHandler(1000) }

/**
 * Handler class for debouncing events to prevent rapid repeated triggers.
 * 
 * This is useful for preventing double-clicks or rapid successive actions that might
 * cause undesirable behavior.
 *
 * @property debounceDurationMs The minimum time in milliseconds between event processing
 */
open class DebouncedEventHandler(private val debounceDurationMs: Long) {
    protected var lastEventTimeMs: Long = 0
        private set

    /**
     * Processes an event if enough time has passed since the last processed event.
     *
     * @param event The action to execute if the debounce criteria are met
     */
    fun processEvent(event: () -> Unit) {
        val now = System.currentTimeMillis()
        if (now - lastEventTimeMs >= debounceDurationMs) {
            event.invoke()
        }
        lastEventTimeMs = now
    }
}

/**
 * Enhanced clickable modifier that provides additional features for Sushi components.
 * 
 * This modifier extends the standard clickable with features like:
 * - Optional visual indication
 * - Click debouncing to prevent double-clicks
 * - Accessibility support
 *
 * @param enabled Whether the click interaction is enabled
 * @param onClickLabel Accessibility label for the click action
 * @param role Semantic role for accessibility services
 * @param showIndication Whether to show the visual indication when pressed
 * @param debounced Whether to debounce the click event to prevent rapid successive clicks
 * @param onClick The action to perform when clicked
 * @return A modified Modifier with enhanced click handling
 */
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

/**
 * Applies a dashed border to a composable with customizable properties.
 * 
 * This modifier draws a dashed border around the composable with specified stroke width,
 * color, corner radius, and dash pattern.
 *
 * @param strokeWidth Width of the border stroke
 * @param color Color of the border
 * @param cornerRadiusDp Corner radius for rounding the border corners
 * @param dashOnWidth Length of each dash in the pattern
 * @param dashOffWidth Length of each gap in the pattern
 * @return A modifier with the dashed border applied
 */
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