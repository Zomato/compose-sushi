package com.zomato.sushi.compose.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.internal.SushiPreview

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
    alignment: Alignment = Alignment.TopStart,
    content: @Composable PassThroughBoxScope.() -> Unit
) {
    Layout(
        modifier = modifier,
        content = { PassThroughBoxScopeImpl.content() }
    ) { measurables, constraints ->

        val placeables = measurables.map { it.measure(constraints) }

        val width = placeables.maxOfOrNull { it.width } ?: constraints.minWidth
        val height = placeables.maxOfOrNull { it.height } ?: constraints.minHeight

        layout(width, height) {
            measurables.zip(placeables).forEach { (measurable, placeable) ->

                val childData =
                    measurable.parentData as? PassThroughBoxChildData

                val childAlignment =
                    childData?.alignment ?: alignment

                val position = childAlignment.align(
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

/**
 * A PassThroughBoxScope provides a scope for the children of [PassThroughBox].
 */
interface PassThroughBoxScope {

    /**
     * Pull the content element to a specific [Alignment] within the [PassThroughBox]. This alignment will have
     * priority over the [PassThroughBox]'s `alignment` parameter.
     */
    fun Modifier.align(alignment: Alignment): Modifier
}

private class PassThroughBoxChildData(
    val alignment: Alignment?
)

private class PassThroughBoxAlignModifier(
    val alignment: Alignment
) : ParentDataModifier {

    override fun Density.modifyParentData(parentData: Any?): Any {
        val existing = parentData as? PassThroughBoxChildData
        return PassThroughBoxChildData(
            alignment = alignment
        )
    }
}

private object PassThroughBoxScopeImpl : PassThroughBoxScope {
    override fun Modifier.align(alignment: Alignment): Modifier {
        return this.then(
            PassThroughBoxAlignModifier(alignment)
        )
    }
}

@SushiPreview
@Composable
private fun PassThroughBoxPreview() {
    SushiPreview {
        PassThroughBox(
            modifier = Modifier
                .sizeIn(
                    minWidth = 20.dp,
                    minHeight = 20.dp,
                    maxWidth = 200.dp,
                    maxHeight = 200.dp
                )
                .background(Color(0xFFE0E0E0))
        ) {
            Spacer(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Gray)
            )
            Spacer(
                modifier = Modifier
                    .size(120.dp)
                    .background(Color.Blue)
            )
            Spacer(
                modifier = Modifier
                    .size(120.dp)
                    .background(Color.Green)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}