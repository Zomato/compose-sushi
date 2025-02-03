package com.zomato.sushi.compose.atoms.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

/**
 * @author gupta.anirudh@zomato.com
 */
@Immutable
@JvmInline
@Stable
internal value class ComposeColorSpec(private val composeColor: Color) : ColorSpec {
    override val value: Color
        @Composable @Stable get() = composeColor
}
