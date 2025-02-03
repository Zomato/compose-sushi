package com.zomato.sushi.compose.atoms.separator

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.atoms.separator.SushiDividerType.ZigZag
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.takeIfSpecified
import com.zomato.sushi.compose.utils.toPx

@Composable
fun SushiDivider(
    props: SushiDividerProps,
    modifier: Modifier = Modifier
) {
    SushiComponentBase(
        modifier
            .width(IntrinsicSize.Max)
            .height(IntrinsicSize.Max)
    ) {
        SushiDividerImpl(
            props,
            Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun SushiDividerImpl(
    props: SushiDividerProps,
    modifier: Modifier = Modifier
) {
    val color = (props.color?.takeIfSpecified() ?: SushiTheme.colors.grey.v300).value

    val pink = SushiTheme.colors.pink.v300.value

    val defaultHeight = SushiDividerDefaults.getDividerHeight(props.type ?: SushiDividerDefaults.type)

    when (val type = props.type) {
        SushiDividerType.Straight,
        SushiDividerType.Dashed,
        SushiDividerType.StraightThick,
        SushiDividerType.Dotted,
        SushiDividerType.DottedSpaced,
        SushiDividerType.Pink,
        null -> {
            Canvas(modifier) {
                val canvasWidth = size.width
                val centerY = size.height / 2

                val (strokeWidth, pathEffect, lineColor, endX) = when (type) {
                    SushiDividerType.StraightThick -> Quartet(
                        props.height ?: defaultHeight,
                        null,
                        color,
                        canvasWidth
                    )
                    SushiDividerType.Dashed -> Quartet(
                        props.height ?: defaultHeight,
                        PathEffect.dashPathEffect(floatArrayOf(3f.dp.toPx(), 2.5f.dp.toPx()), 0f),
                        color,
                        canvasWidth
                    )
                    SushiDividerType.Dotted -> Quartet(
                        props.height ?: defaultHeight,
                        PathEffect.dashPathEffect(floatArrayOf(0.2f.dp.toPx(), 4.5f.dp.toPx()), 0f),
                        color,
                        canvasWidth
                    )
                    SushiDividerType.DottedSpaced -> Quartet(
                        props.height ?: defaultHeight,
                        PathEffect.dashPathEffect(floatArrayOf(0.4f.dp.toPx(), 4f.dp.toPx()), 0f),
                        color,
                        canvasWidth
                    )
                    SushiDividerType.Pink -> Quartet(
                        props.height ?: defaultHeight,
                        null,
                        pink,
                        50f.dp.toPx()
                    )
                    else -> Quartet( // Handles Straight, null
                        props.height ?: defaultHeight,
                        null,
                        color,
                        canvasWidth
                    )
                }

                drawLine(
                    color = lineColor,
                    start = Offset(0f, centerY),
                    end = Offset(endX, centerY),
                    strokeWidth = strokeWidth.toPx(),
                    cap = StrokeCap.Round,
                    pathEffect = pathEffect
                )
            }
        }

        SushiDividerType.VerticalDotted,
        SushiDividerType.Vertical -> {
            Canvas(modifier.fillMaxHeight()) {
                val strokeWidth = props.height ?: defaultHeight
                val pathEffect = if (type == SushiDividerType.VerticalDotted) {
                    PathEffect.dashPathEffect(floatArrayOf(0.2f.dp.toPx(), 4.5f.dp.toPx()), 0f)
                } else null

                drawLine(
                    color = color,
                    start = Offset(size.width / 2, 0f),
                    end = Offset(size.width / 2, size.height),
                    strokeWidth = strokeWidth.toPx(),
                    cap = StrokeCap.Round,
                    pathEffect = pathEffect
                )
            }
        }

        SushiDividerType.Menu -> {
            val menuColor = SushiTheme.colors.grey.v300.value
            val strokeWidth = props.height ?: defaultHeight
            Canvas(modifier) {
                val leftLength = 12f.dp.toPx()
                val triangleTopX = leftLength + 6f.dp.toPx()
                val lineY = 8f.dp.toPx()

                Path().apply {
                    moveTo(0f, lineY)
                    lineTo(leftLength, lineY)
                    lineTo(triangleTopX, 0f)
                    lineTo(triangleTopX + 6f.dp.toPx(), lineY)
                    lineTo(size.width, lineY)
                }.let { path ->
                    drawPath(
                        path = path,
                        color = menuColor,
                        style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
                    )
                }
            }
        }

        is ZigZag -> {
            Canvas(modifier) {
                val radius = type.radius?.toPx() ?: 4.dp.toPx()
                val zigZagWidth = type.width?.toPx() ?: 12.dp.toPx()
                val zigZagHeight = type.height?.toPx() ?: 24.dp.toPx()

                val path = Path().apply {
                    var startX = 0f
                    val width = size.width

                    while (startX < width) {
                        moveTo(startX, if (type.direction == ZigZag.Direction.Top) size.height else 0f)

                        val midX = startX + zigZagWidth / 2
                        val endX = startX + zigZagWidth
                        val yOffset = if (type.direction == ZigZag.Direction.Top) -zigZagHeight else zigZagHeight

                        cubicTo(
                            startX + radius,
                            if (type.direction == ZigZag.Direction.Top) size.height else 0f,
                            midX - radius,
                            yOffset,
                            midX,
                            yOffset
                        )

                        cubicTo(
                            midX + radius,
                            yOffset,
                            endX - radius,
                            if (type.direction == ZigZag.Direction.Top) size.height else 0f,
                            endX,
                            if (type.direction == ZigZag.Direction.Top) size.height else 0f
                        )

                        startX = endX
                    }
                }

                drawPath(
                    path = path,
                    color = color,
                    style = Stroke(width = 3f.dp.toPx(), cap = StrokeCap.Round)
                )
            }
        }
    }
}

private data class Quartet<T1, T2, T3, T4>(
    val first: T1,
    val second: T2,
    val third: T3,
    val fourth: T4
)

@Composable
@SushiPreview
private fun SushiDividerPreview() {
    SushiPreview {
        Column(Modifier.fillMaxSize().background(SushiTheme.colors.surface.primary.value).padding(vertical = 16.dp)) {
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.Straight,
                    color = SushiColorData(ColorName.Red, ColorVariation.Variation500)
                ),
                Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.Straight,
                    color = SushiColorData(ColorName.Red, ColorVariation.Variation500)
                ),
                Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.Dotted,
                    color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)
                ),
                Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.Dashed,
                    color = SushiColorData(ColorName.Red, ColorVariation.Variation500)
                ),
                Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.StraightThick,
                    color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)
                ),
                Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.DottedSpaced,
                    color = SushiColorData(ColorName.White, ColorVariation.Variation500)
                ),
                Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.Vertical,
                    color = SushiColorData(ColorName.White, ColorVariation.Variation500)
                ),
                Modifier.fillMaxWidth().fillMaxHeight(0.1f).padding(vertical = 16.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.VerticalDotted,
                    color = SushiColorData(ColorName.White, ColorVariation.Variation500)
                ),
                Modifier.fillMaxWidth().fillMaxHeight(0.1f).padding(vertical = 16.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.Pink,
                    color = SushiColorData(ColorName.White, ColorVariation.Variation500)
                ),
                Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.Menu,
                    color = SushiColorData(ColorName.Yellow, ColorVariation.Variation500)
                ),
                Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = ZigZag(ZigZag.Direction.Top, 2.dp, 24.dp, 12.dp),
                    color = SushiColorData(ColorName.Green, ColorVariation.Variation500),
                ),
                Modifier.fillMaxWidth().padding(vertical = 28.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = ZigZag(ZigZag.Direction.Bottom),
                    color = SushiColorData(ColorName.Orange, ColorVariation.Variation500)
                ),
                Modifier.widthIn(150.dp).padding(vertical = 16.dp)
            )
        }
    }
}
