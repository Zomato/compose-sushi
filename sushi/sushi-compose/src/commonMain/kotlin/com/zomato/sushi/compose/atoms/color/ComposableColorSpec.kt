package com.zomato.sushi.compose.atoms.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import kotlin.jvm.JvmInline

/**
 * @author gupta.anirudh@zomato.com
 */
@JvmInline
private value class ComposableColorSpec(
    val provider: @Composable () -> ColorSpec
) : ColorSpec {
    override val value: Color
        @Composable @Stable get() {
            return provider().value
        }
}

/**
 * Creates a [ColorSpec] backed by a composable provider.
 *
 * This is useful when a [ColorSpec] is required in a non-composable context,
 * but its value depends on composable state.
 *
 * @author gupta.anirudh@zomato.com
 */
fun colorSpecProvider(provider: @Composable () -> ColorSpec): ColorSpec {
    return ComposableColorSpec(provider)
}