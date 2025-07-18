package com.zomato.sushi.compose.atoms.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

/**
 * @author gupta.anirudh@zomato.com
 */
@Composable
internal fun SushiComponentBase(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val placeable = measurables.firstOrNull()?.measure(constraints)

        val width = placeable?.width ?: constraints.minWidth
        val height = placeable?.height ?: constraints.minHeight

        layout(width, height) {
            placeable?.place(0, 0)
        }
    }
}
