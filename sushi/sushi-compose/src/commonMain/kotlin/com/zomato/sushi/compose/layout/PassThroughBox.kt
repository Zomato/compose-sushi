package com.zomato.sushi.compose.layout

import androidx.collection.MutableScatterMap
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
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
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
 *
 * @author gupta.anirudh@zomato.com
 */

@Composable
fun PassThroughBox(
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.TopStart,
    content: @Composable PassThroughBoxScope.() -> Unit
) {
    val measurePolicy = Cache[alignment] ?: PassThroughBoxMeasurePolicy(alignment)
    Layout(
        content = { PassThroughBoxScopeImpl.content() },
        measurePolicy = measurePolicy,
        modifier = modifier,
    )
}

private val Cache = MutableScatterMap<Alignment, MeasurePolicy>(9).apply {
    this[Alignment.TopStart] = PassThroughBoxMeasurePolicy(Alignment.TopStart)
    this[Alignment.TopCenter] = PassThroughBoxMeasurePolicy(Alignment.TopCenter)
    this[Alignment.TopEnd] = PassThroughBoxMeasurePolicy(Alignment.TopEnd)
    this[Alignment.CenterStart] = PassThroughBoxMeasurePolicy(Alignment.CenterStart)
    this[Alignment.Center] = PassThroughBoxMeasurePolicy(Alignment.Center)
    this[Alignment.CenterEnd] = PassThroughBoxMeasurePolicy(Alignment.CenterEnd)
    this[Alignment.BottomStart] = PassThroughBoxMeasurePolicy(Alignment.BottomStart)
    this[Alignment.BottomCenter] = PassThroughBoxMeasurePolicy(Alignment.BottomCenter)
    this[Alignment.BottomEnd] = PassThroughBoxMeasurePolicy(Alignment.BottomEnd)
}

private class PassThroughBoxMeasurePolicy(
    private val defaultAlignment: Alignment
) : MeasurePolicy {

    override fun MeasureScope.measure(
        measurables: List<Measurable>,
        constraints: Constraints
    ): MeasureResult {

        val hasMatchParentSize = measurables.any {
            (it.parentData as? PassThroughBoxChildData)?.matchParentSize == true
        }

        if (!hasMatchParentSize) {
            // Fast path: no matchParentSize children
            val placeables = measurables.map { it.measure(constraints) }
            val width = placeables.maxOfOrNull { it.width } ?: constraints.minWidth
            val height = placeables.maxOfOrNull { it.height } ?: constraints.minHeight

            return layout(width, height) {
                placeWith(measurables, placeables, width, height, layoutDirection)
            }
        }

        // Slow path: separate matchParentSize children
        val placeables = arrayOfNulls<Placeable>(measurables.size)

        // First pass: measure non-matchParentSize children
        measurables.forEachIndexed { index, measurable ->
            val childData = measurable.parentData as? PassThroughBoxChildData
            if (childData?.matchParentSize != true) {
                placeables[index] = measurable.measure(constraints)
            }
        }

        val width = placeables.mapNotNull { it?.width }.maxOrNull() ?: constraints.minWidth
        val height = placeables.mapNotNull { it?.height }.maxOrNull() ?: constraints.minHeight

        // Second pass: measure matchParentSize children with tight constraints
        val matchParentConstraints = Constraints.fixed(width, height)
        measurables.forEachIndexed { index, measurable ->
            if (placeables[index] == null) {
                placeables[index] = measurable.measure(matchParentConstraints)
            }
        }

        @Suppress("UNCHECKED_CAST")
        val resolvedPlaceables = placeables as Array<Placeable>

        return layout(width, height) {
            placeWith(measurables, resolvedPlaceables.toList(), width, height, layoutDirection)
        }
    }

    private fun Placeable.PlacementScope.placeWith(
        measurables: List<Measurable>,
        placeables: List<Placeable>,
        width: Int,
        height: Int,
        layoutDirection: LayoutDirection
    ) {
        measurables.zip(placeables).forEach { (measurable, placeable) ->
            val childData = measurable.parentData as? PassThroughBoxChildData
            val alignment = childData?.alignment ?: defaultAlignment
            val position = alignment.align(
                size = IntSize(placeable.width, placeable.height),
                space = IntSize(width, height),
                layoutDirection = layoutDirection
            )
            placeable.place(position.x, position.y)
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

    /**
     * Size the element to match the size of the [PassThroughBox] after all other children
     * have been measured.
     *
     * The element using this modifier does **not** influence the size of the
     * [PassThroughBox] itself. Instead, it is measured with tight constraints
     * equal to the size determined by the remaining (non-match-parent) children.
     *
     * This is useful for backgrounds, overlays, or decoration layers that should
     * fill the parent without affecting layout sizing.
     *
     * @see align
     */
    fun Modifier.matchParentSize(): Modifier
}

private class PassThroughBoxChildData(
    val alignment: Alignment?,
    val matchParentSize: Boolean = false
)

private class PassThroughBoxAlignModifier(
    val alignment: Alignment
) : ParentDataModifier {

    override fun Density.modifyParentData(parentData: Any?): Any {
        val existing = parentData as? PassThroughBoxChildData
        return PassThroughBoxChildData(
            alignment = alignment,
            matchParentSize = existing?.matchParentSize ?: false
        )
    }
}

/**
 * [ParentDataModifier] that marks a child to be measured with tight constraints
 * matching the resolved size of the [PassThroughBox].
 */
private class PassThroughBoxMatchParentSizeModifier : ParentDataModifier {

    override fun Density.modifyParentData(parentData: Any?): Any {
        val existing = parentData as? PassThroughBoxChildData
        return PassThroughBoxChildData(
            alignment = existing?.alignment,
            matchParentSize = true
        )
    }
}

private object PassThroughBoxScopeImpl : PassThroughBoxScope {
    override fun Modifier.align(alignment: Alignment): Modifier {
        return this.then(
            PassThroughBoxAlignModifier(alignment)
        )
    }

    override fun Modifier.matchParentSize(): Modifier {
        return this.then(
            PassThroughBoxMatchParentSizeModifier()
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