@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiRawColorTokens
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.toPx

@Composable
internal fun Modifier.textDecoration(
    textDecoration: SushiTextDecoration,
    textLayoutResult: TextLayoutResult?,
    defaultColor: ColorSpec,
    fontSize: TextUnit,
    fontWeight: FontWeight? = null,
) : Modifier {
    if (textLayoutResult == null) {
        return this
    }
    return this.then(
        when (textDecoration) {
            is SushiTextDecoration.LineThrough -> {
                val dotSize = textDecoration.dotSize?.toPx() ?: defaultDotSize(fontWeight, fontSize)
                val gapSize = textDecoration.gapSize?.toPx() ?: defaultGapSize(fontWeight, fontSize)
                val strokeWidth = textDecoration.strokeWidth?.toPx() ?: defaultStrokeWidth(fontWeight, fontSize)
                val color = textDecoration.color?.value ?: defaultColor.value

                Modifier.textStrikeThrough(
                    layoutResult = textLayoutResult,
                    dotSize = dotSize,
                    gapSize = gapSize,
                    strokeWidth = strokeWidth,
                    color = color
                )
            }
            is SushiTextDecoration.Underline -> {
                val dotSize = textDecoration.dotSize?.toPx() ?: defaultDotSize(fontWeight, fontSize)
                val gapSize = textDecoration.gapSize?.toPx() ?: defaultGapSize(fontWeight, fontSize)
                val strokeWidth = textDecoration.strokeWidth?.toPx() ?: defaultStrokeWidth(fontWeight, fontSize)
                val color = textDecoration.color?.value ?: defaultColor.value

                Modifier.textUnderline(
                    layoutResult = textLayoutResult,
                    dotSize = dotSize,
                    gapSize = gapSize,
                    strokeWidth = strokeWidth,
                    color = color
                )
            }
        }
    )
}

private fun Modifier.textUnderline(
    layoutResult: TextLayoutResult,
    dotSize: Float = 4f,
    gapSize: Float = 4f,
    strokeWidth: Float = 2f,
    color: Color = Color.Black
): Modifier = this.then(
    Modifier.drawBehind {
        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(dotSize, gapSize), 0f)
        val lineCount = layoutResult.lineCount

        for (lineIndex in 0 until lineCount) {
            val lineBottom = layoutResult.getLineBottom(lineIndex)
            val lineStart = layoutResult.getLineLeft(lineIndex)
            val lineEnd = layoutResult.getLineRight(lineIndex)

            drawLine(
                color = color,
                start = Offset(lineStart, lineBottom - strokeWidth / 2),
                end = Offset(lineEnd, lineBottom - strokeWidth / 2),
                strokeWidth = strokeWidth,
                pathEffect = pathEffect
            )
        }
    }
)

private fun Modifier.textStrikeThrough(
    layoutResult: TextLayoutResult,
    dotSize: Float = 4f,
    gapSize: Float = 4f,
    strokeWidth: Float = 2f,
    color: Color = Color.Black
): Modifier = this.then(
    Modifier.drawBehind {
        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(dotSize, gapSize), 0f)
        val lineCount = layoutResult.lineCount

        for (lineIndex in 0 until lineCount) {
            val lineTop = layoutResult.getLineTop(lineIndex)
            val lineBottom = layoutResult.getLineBottom(lineIndex)
            val lineCenter = (lineTop + lineBottom) / 2
            val lineStart = layoutResult.getLineLeft(lineIndex)
            val lineEnd = layoutResult.getLineRight(lineIndex)

            drawLine(
                color = color,
                start = Offset(lineStart, lineCenter),
                end = Offset(lineEnd, lineCenter),
                strokeWidth = strokeWidth,
                pathEffect = pathEffect
            )
        }
    }
)

@Composable
private fun defaultDotSize(fontWeight: FontWeight?, fontSize: TextUnit): Float {
    return fontSize.value / 3 * fontWeight?.weight?.let { it / 1000 + 1 }.let { it ?: 1 }
}

@Composable
private fun defaultGapSize(fontWeight: FontWeight?, fontSize: TextUnit): Float {
    return fontSize.value / 3 * fontWeight?.weight?.let { it / 1000 + 1 }.let { it ?: 1 }
}

@Composable
private fun defaultStrokeWidth(fontWeight: FontWeight?, fontSize: TextUnit): Float {
    return fontSize.value / 3 * fontWeight?.weight?.let { it / 1000 + 1 }.let { it ?: 1 }
}

@SushiPreview
@Composable
private fun MultilineDottedUnderlineSushiTextPreview() {
    Preview {
        var layoutResult: TextLayoutResult? by remember { mutableStateOf(null) }

        val type = SushiTextType.Bold900
        val color = SushiRawColorTokens.Red500.asColorSpec()

        SushiText(
            props = SushiTextProps(
                text = "This is a multiline\n example with a\n custom dotted underline.",
                type = type,
                color = color
            ),
            modifier = Modifier.textDecoration(
                textDecoration = SushiTextDecoration.Underline(
                    color = color
                ),
                textLayoutResult = layoutResult,
                fontWeight = type.typeStyle.fontWeight!!,
                fontSize = type.typeStyle.fontSize,
                defaultColor = color
            ),
            onTextLayout = { layoutResult = it }
        )
    }
}