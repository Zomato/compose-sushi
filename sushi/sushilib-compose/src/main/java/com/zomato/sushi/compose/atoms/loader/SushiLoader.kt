@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.loader

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.internal.Base
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.takeIfSpecified
import kotlin.math.roundToInt

private object Defaults {
    val innerAngleOffset = 0f
    val animationSpeedMultiplier = 1f
}

@Composable
fun SushiLoader(
    props: SushiLoaderProps,
    modifier: Modifier = Modifier
) {
    Base(
        modifier
            .size(50.dp)
            .defaultMinSize(50.dp, 50.dp)
    ) {
        SushiLoaderImpl(
            props,
            Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun SushiLoaderImpl(
    props: SushiLoaderProps,
    modifier: Modifier = Modifier
) {
    val animationSpeedMultiplier = props.animationSpeedMultiplier ?: Defaults.animationSpeedMultiplier
    val innerAngleOffset = props.innerAngleOffset ?: Defaults.innerAngleOffset
    val innerColor = props.innerColor.value.takeIfSpecified() ?: SushiTheme.colors.red.v500.value
    val outerColor = props.outerColor.value.takeIfSpecified() ?: SushiTheme.colors.red.v500.value

    val infiniteTransition = rememberInfiniteTransition(label = "transition")
    val outerStartAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = (1000 / animationSpeedMultiplier).roundToInt(),
                easing = LinearEasing
            )
        ), label = "rotation"
    )
    Canvas(modifier) {
        val actualSize = Math.min(size.width, size.height)
        val borderStrokeSize = actualSize / 10
        val outerSize = actualSize - borderStrokeSize
        val baseOffset = Offset(borderStrokeSize / 2, borderStrokeSize / 2)
        val innerSize = (outerSize / 1.4).toFloat()
        val innerStartAngle = 360f - outerStartAngle - innerAngleOffset

        drawArc(
            color = innerColor,
            topLeft = Offset(outerSize / 2 - innerSize / 2 + baseOffset.x, outerSize / 2 - innerSize / 2 + baseOffset.y),
            startAngle = innerStartAngle,
            sweepAngle = 90f,
            useCenter = false,
            style = Stroke(borderStrokeSize, cap = StrokeCap.Round),
            size = Size(innerSize, innerSize)
        )
        drawArc(
            color = outerColor,
            topLeft = baseOffset,
            startAngle = outerStartAngle,
            sweepAngle = 310f,
            useCenter = false,
            style = Stroke(borderStrokeSize, cap = StrokeCap.Round),
            size = Size(outerSize, outerSize)
        )
    }
}

@SushiPreview
@Composable
fun SushiLoaderPreview() {
    Preview {
        SushiLoader(
            SushiLoaderProps(

            ),
            Modifier.size(100.dp)
        )
    }
}
