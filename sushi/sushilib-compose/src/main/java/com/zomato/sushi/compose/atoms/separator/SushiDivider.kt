@file:OptIn(ExperimentalSushiApi::class)

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
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.internal.Base
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.takeIfSpecified
import com.zomato.sushi.compose.utils.toPx

@ExperimentalSushiApi
@Composable
fun SushiDivider(
    props: SushiDividerProps,
    modifier: Modifier = Modifier
) {
    Base(
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
    val leftPadding =
        if (props.isLeftIndented == true || props.isBothIndented == true) 12.dp.toPx() else 0.dp.toPx()
    val rightPadding =
        if (props.isRightIndented == true || props.isBothIndented == true) 12.dp.toPx() else 0.dp.toPx()
    val color = (props.color?.takeIfSpecified() ?: SushiTheme.colors.grey.v300).value

    when (val type = props.type) {
        SushiDividerType.Straight, SushiDividerType.Dashed, SushiDividerType.StraightThick, null -> {
            Canvas(modifier) {
                val canvasWidth = size.width
                val canvasHeight = size.height
                val strokeWidth = if (props.type == SushiDividerType.StraightThick) {
                    8f.dp.toPx()
                } else 1f.dp.toPx()
                val pathEffect = if (props.type == SushiDividerType.Dashed)
                    PathEffect.dashPathEffect(
                        intervals = floatArrayOf(3f.dp.toPx(), 2.5f.dp.toPx()), // Length of dash and gap (since rounded we need to compensate gap Length by add it with stroke Width)
                        phase = 0f
                    )
                else null
                drawLine(
                    color = color,
                    start = androidx.compose.ui.geometry.Offset(leftPadding, canvasHeight / 2),
                    end = androidx.compose.ui.geometry.Offset(canvasWidth - rightPadding, canvasHeight / 2),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round,
                    pathEffect = pathEffect
                )
            }
        }

        SushiDividerType.Dotted -> {
            Canvas(modifier) {
                val canvasWidth = size.width
                val canvasHeight = size.height
                val strokeWidth = 3f.dp.toPx()
                // need to revisit this
                val pathEffect = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(0.2f.dp.toPx(), 4.5f.dp.toPx()),
                    phase = 0f
                )
                drawLine(
                    color = color,
                    start = androidx.compose.ui.geometry.Offset(leftPadding, canvasHeight / 2),
                    end = androidx.compose.ui.geometry.Offset(canvasWidth - rightPadding, canvasHeight / 2),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round,
                    pathEffect = pathEffect
                )
            }
        }

        SushiDividerType.DottedSpaced -> {
            Canvas(modifier) {
                val canvasWidth = size.width // Canvas width
                val canvasHeight = size.height // Canvas height
                val strokeWidth = 0.8f.dp.toPx()
                // need to revisit
                val pathEffect = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(0.4f.dp.toPx(), 4f.dp.toPx()),
                    phase = 0f
                )
                drawLine(
                    color = color,
                    start = androidx.compose.ui.geometry.Offset(leftPadding, canvasHeight / 2),
                    end = androidx.compose.ui.geometry.Offset(canvasWidth - rightPadding, canvasHeight / 2),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round,
                    pathEffect = pathEffect
                )
            }
        }

        SushiDividerType.Pink -> {
            val pinkColor = SushiTheme.colors.pink.v300.value
            Canvas(modifier) {
                val canvasWidth = leftPadding + rightPadding + 50f.dp.toPx()
                val canvasHeight = size.height
                val strokeWidth = 3f.dp.toPx()
                drawLine(
                    color = pinkColor,
                    start = androidx.compose.ui.geometry.Offset(leftPadding, canvasHeight / 2),
                    end = androidx.compose.ui.geometry.Offset(canvasWidth - rightPadding, canvasHeight / 2),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
            }
        }

        SushiDividerType.VerticalDotted -> {
            Canvas(modifier.fillMaxHeight()) {
                val canvasWidth = size.width
                val canvasHeight = size.height
                val strokeWidth = 3f.dp.toPx()
                val pathEffect = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(0.2f.dp.toPx(), 4.5f.dp.toPx()),
                    phase = 0f
                )
                drawLine(
                    color = color,
                    start = androidx.compose.ui.geometry.Offset(canvasWidth / 2, 0f),
                    end = androidx.compose.ui.geometry.Offset(canvasWidth / 2, canvasHeight),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round,
                    pathEffect = pathEffect
                )
            }
        }

        SushiDividerType.Vertical -> {
            Canvas(modifier.fillMaxHeight()) {
                val canvasWidth = size.width
                val canvasHeight = size.height
                val strokeWidth = 1f.dp.toPx()
                drawLine(
                    color = color,
                    start = androidx.compose.ui.geometry.Offset(canvasWidth / 2, 0f),
                    end = androidx.compose.ui.geometry.Offset(canvasWidth / 2, canvasHeight),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
            }
        }

        SushiDividerType.Menu -> {
            val leftLength = 12f.dp.toPx()
            val triangleTopX = leftLength + 6f.dp.toPx()
            val lineY = 8f.dp.toPx()
            val triangleEndX = triangleTopX + 6f.dp.toPx()
            val menuColor = SushiTheme.colors.grey.v300.value
            val strokeWidth = 2f.dp.toPx()
            Canvas(modifier = modifier) {
                val path = Path().apply {
                    moveTo(0f, lineY)
                    lineTo(leftLength, lineY)
                    lineTo(triangleTopX, 0f)
                    lineTo(triangleEndX, lineY)
                    lineTo(size.width, lineY)
                }
                drawPath(
                    path = path,
                    color = menuColor,
                    style = Stroke(
                        width = strokeWidth,
                        cap = StrokeCap.Round
                    )
                )
            }
        }

        is SushiDividerType.ZigZag -> {
            Canvas(modifier) {
                val strokeWidth = 3f
                val width = size.width
                val radius = type?.radius?.dp?.toPx() ?: 4.dp.toPx()
                val zigZagWidth = type?.width?.dp?.toPx() ?: 12.dp.toPx()
                val zigZagHeight = type?.height?.dp?.toPx() ?: 24.dp.toPx()
                var startX = 0f
                val path = Path()
                when (type.direction) {
                    Direction.Top -> {
                        val startY = size.height
                        while (startX < width) {
                            path.moveTo(startX, startY)

                            val midX = startX + zigZagWidth / 2
                            val endX = startX + zigZagWidth

                            path.cubicTo(
                                startX + radius,
                                startY,
                                midX - radius,
                                startY - zigZagHeight,
                                midX,
                                startY - zigZagHeight
                            )

                            path.cubicTo(
                                midX + radius,
                                startY - zigZagHeight,
                                endX - radius,
                                startY,
                                endX,
                                startY
                            )

                            startX = endX
                        }
                    }
                    Direction.Bottom -> {
                        val startY = 0f
                        while (startX < width) {
                            path.moveTo(startX, startY)

                            val midX = startX + zigZagWidth / 2
                            val endX = startX + zigZagWidth

                            path.cubicTo(
                                startX + radius,
                                startY,
                                midX - radius,
                                startY + zigZagHeight,
                                midX,
                                startY + zigZagHeight
                            )

                            path.cubicTo(
                                midX + radius,
                                startY + zigZagHeight,
                                endX - radius,
                                startY,
                                endX,
                                startY
                            )

                            startX = endX
                        }
                    }
                }
                drawPath(
                    path = path,
                    color = color,
                    style = Stroke(
                        width = strokeWidth,
                        cap = StrokeCap.Round
                    )
                )
            }
        }
    }
}

@Composable
@SushiPreview
private fun SushiDividerPreview() {
    Preview {
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
                    color = SushiColorData(ColorName.Red, ColorVariation.Variation500),
                    isLeftIndented = true
                ),
                Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.Dotted,
                    color = SushiColorData(ColorName.Blue, ColorVariation.Variation500),
                    isRightIndented = true
                ),
                Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.Dashed,
                    color = SushiColorData(ColorName.Red, ColorVariation.Variation500),
                    isBothIndented = true
                ),
                Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.StraightThick,
                    color = SushiColorData(ColorName.Blue, ColorVariation.Variation500),
                    isRightIndented = true,
                    isLeftIndented = true
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
                    color = SushiColorData(ColorName.White, ColorVariation.Variation500),
                    isRightIndented = true
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
                    color = SushiColorData(ColorName.Yellow, ColorVariation.Variation500),
                    isRightIndented = true
                ),
                Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.ZigZag(Direction.Top, 2f, 24f, 12f),
                    color = SushiColorData(ColorName.Green, ColorVariation.Variation500),
                    isRightIndented = true
                ),
                Modifier.fillMaxWidth().padding(vertical = 28.dp)
            )
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.ZigZag(Direction.Bottom),
                    color = SushiColorData(ColorName.Orange, ColorVariation.Variation500),
                    isRightIndented = true
                ),
                Modifier.widthIn(150.dp).padding(vertical = 16.dp)
            )
        }
    }
}
