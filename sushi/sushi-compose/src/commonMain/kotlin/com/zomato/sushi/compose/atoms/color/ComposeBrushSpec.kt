package com.zomato.sushi.compose.atoms.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import kotlin.jvm.JvmInline

/**
 * @author gupta.anirudh@zomato.com
 */
@Immutable
@Stable
internal class ComposeBrushSpec(
    private val composeBrush: Brush,
    private val composeColor: Color,
) : BrushSpec {

    override val brush: Brush
        @Composable @Stable get() = composeBrush

    override val value: Color
        @Composable @Stable get() = composeColor
}
