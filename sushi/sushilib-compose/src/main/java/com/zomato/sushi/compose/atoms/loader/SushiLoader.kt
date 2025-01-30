package com.zomato.sushi.compose.atoms.loader

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.takeIfSpecified
import kotlin.math.roundToInt

/**
 * @author gupta.anirudh@zomato.com
 */
@Composable
fun SushiLoader(
    props: SushiLoaderProps,
    modifier: Modifier = Modifier
) {
    SushiComponentBase(
        modifier
            .testTag("SushiLoader")
            .width(IntrinsicSize.Max)
            .height(IntrinsicSize.Max)
            .defaultMinSize(SushiLoaderDefaults.minSize, SushiLoaderDefaults.minSize)
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
    val animationSpeedMultiplier = props.animationSpeedMultiplier ?: SushiLoaderDefaults.animationSpeedMultiplier
    val innerAngleOffset = props.innerAngleOffset ?: SushiLoaderDefaults.innerAngleOffset
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
    val innerStartAngle = 360f - outerStartAngle - innerAngleOffset

    Canvas(modifier) {
        val drawAreaSize = Math.min(size.width, size.height)
        val borderStrokeSize = drawAreaSize / 10
        val outerSize = drawAreaSize - borderStrokeSize / 2 - borderStrokeSize / 2
        val innerSize = (outerSize * 0.71).toFloat()

        val center = Offset(size.width / 2, size.height / 2)

        val outerArcTopLeft = center - Offset(outerSize / 2, outerSize / 2)
        val innerArcTopLeft = center - Offset(innerSize / 2, innerSize / 2)

        drawArc(
            color = outerColor,
            topLeft = outerArcTopLeft,
            startAngle = outerStartAngle,
            sweepAngle = 310f,
            useCenter = false,
            style = Stroke(borderStrokeSize, cap = StrokeCap.Round),
            size = Size(outerSize, outerSize)
        )
        drawArc(
            color = innerColor,
            topLeft = innerArcTopLeft,
            startAngle = innerStartAngle,
            sweepAngle = 90f,
            useCenter = false,
            style = Stroke(borderStrokeSize, cap = StrokeCap.Round),
            size = Size(innerSize, innerSize)
        )
    }
}

@SushiPreview
@Composable
private fun SushiLoaderPreview1() {
    SushiPreview {
        SushiLoader(
            SushiLoaderProps(

            )
        )
    }
}

@SushiPreview
@Composable
private fun SushiLoaderPreview2() {
    SushiPreview {
        SushiLoader(
            SushiLoaderProps(

            ),
            Modifier.size(100.dp)
        )
    }
}

@SushiPreview
@Composable
private fun SushiLoaderPreview3() {
    SushiPreview {
        SushiLoader(
            SushiLoaderProps(

            ),
            Modifier.width(100.dp)
        )
    }
}
