package com.zomato.sushi.compose.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.IntSize

/**
 * A Box-like layout that **passes incoming constraints directly to all children**.
 *
 * ### Key difference from [androidx.compose.foundation.layout.Box]
 * Unlike [Box], this layout **does not loosen or modify** the parent constraints
 * before measuring its children.
 *
 * - `Box` resets `minWidth` / `minHeight` to `0` for children
 * - **This layout forwards the exact constraints it receives**
 *
 * This makes it suitable for:
 * - Design-system primitives where constraint fidelity matters
 * - Measurement-sensitive components
 * - Overlay / decoration layers that must respect parent sizing contracts
 *
 * ### Measurement behavior
 * - All children are measured with the **same incoming constraints**
 * - The layout size is the **maximum width and height** of its children
 * - Multiple children are allowed and may overlap
 *
 * @param modifier Modifier applied to the layout.
 * @param alignment Alignment used to position children within the layout.
 * @param content Composable children to be measured and placed.
 */

@Composable
fun PassThroughBox(
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val placeables = measurables.map { it.measure(constraints) }

        val width = placeables.maxOfOrNull { it.width } ?: constraints.minWidth
        val height = placeables.maxOfOrNull { it.height } ?: constraints.minHeight

        layout(width, height) {
            placeables.forEach { placeable ->

                val position = alignment.align(
                    size = IntSize(placeable.width, placeable.height),
                    space = IntSize(width, height),
                    layoutDirection = layoutDirection
                )

                placeable.place(
                    x = position.x,
                    y = position.y
                )
            }
        }
    }
}