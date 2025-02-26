package com.zomato.sushi.compose.atoms.indicators

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.indicators.type.BalloonIndicator
import com.zomato.sushi.compose.atoms.indicators.type.ShiftIndicator
import com.zomato.sushi.compose.atoms.indicators.type.SpringIndicator
import com.zomato.sushi.compose.atoms.indicators.type.SushiIndicatorType
import com.zomato.sushi.compose.atoms.indicators.type.WormIndicator
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import kotlinx.coroutines.launch

@Composable
fun SushiDotsIndicator(
    dotCount: Int,
    type: SushiIndicatorType,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    dotSpacing: Dp = SushiTheme.dimens.spacing.base
) {
    val coroutineScope = rememberCoroutineScope()
    SushiDotsIndicator(
        dotCount = dotCount,
        type = type,
        currentPage = pagerState.currentPage,
        currentPageOffsetFraction = { pagerState.currentPageOffsetFraction },
        modifier = modifier,
        dotSpacing = dotSpacing,
        onDotClicked = { dotIndex ->
            coroutineScope.launch { pagerState.animateScrollToPage(dotIndex) }
        }
    )
}

@Composable
fun SushiDotsIndicator(
    dotCount: Int,
    type: SushiIndicatorType,
    currentPage: Int,
    currentPageOffsetFraction: () -> Float,
    modifier: Modifier = Modifier,
    dotSpacing: Dp = SushiTheme.dimens.spacing.base,
    onDotClicked: ((index: Int) -> Unit)? = null
) {
    SushiComponentBase(
        Modifier
            .testTag("SushiDotsIndicator")
    ) {
        val globalOffset by remember(dotCount, currentPage, currentPageOffsetFraction()) {
            derivedStateOf {
                computeGlobalScrollOffset(currentPage, currentPageOffsetFraction(), dotCount)
            }
        }

        when (type) {
            is SushiIndicatorType.Balloon -> {
                BalloonIndicator(
                    globalOffsetProvider = { globalOffset },
                    dotCount = dotCount,
                    dotSpacing = dotSpacing,
                    onDotClicked = onDotClicked,
                    modifier = modifier,
                    dotsGraphic = type.dotsGraphic,
                    balloonSizeFactor = type.balloonSizeFactor,
                )
            }
            is SushiIndicatorType.Shift -> {
                ShiftIndicator(
                    globalOffsetProvider = { globalOffset },
                    dotCount = dotCount,
                    dotSpacing = dotSpacing,
                    onDotClicked = onDotClicked,
                    modifier = modifier,
                    dotsGraphic = type.dotsGraphic,
                    shiftSizeFactor = type.shiftSizeFactor,
                )
            }
            is SushiIndicatorType.Spring -> {
                SpringIndicator(
                    globalOffsetProvider = { globalOffset },
                    dotCount = dotCount,
                    dotSpacing = dotSpacing,
                    onDotClicked = onDotClicked,
                    modifier = modifier,
                    dotsGraphic = type.dotsGraphic,
                    selectorDotGraphic = type.selectorDotGraphic,
                )
            }
            is SushiIndicatorType.Worm -> {
                WormIndicator(
                    globalOffsetProvider = { globalOffset },
                    dotCount = dotCount,
                    dotSpacing = dotSpacing,
                    onDotClicked = onDotClicked,
                    modifier = modifier,
                    dotsGraphic = type.dotsGraphic,
                    wormDotGraphic = type.wormDotGraphic,
                )
            }
        }
    }
}

private fun computeGlobalScrollOffset(position: Int, positionOffset: Float, totalCount: Int): Float {
    var offset = (position + positionOffset)
    val lastPageIndex = (totalCount - 1).toFloat()
    if (offset == lastPageIndex) {
        offset = lastPageIndex - .0001f
    }
    val leftPosition = offset.toInt()
    val rightPosition = leftPosition + 1
    if (rightPosition > lastPageIndex || leftPosition < 0) {
        return 0f
    }

    return leftPosition + offset % 1
}

@SushiPreview
@Composable
private fun SushiDotsIndicatorBalloonPreview() {
    val dotCount = 5
    val animatedProgress = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        animatedProgress.animateTo(
            targetValue = (dotCount - 1).toFloat(),
            animationSpec = infiniteRepeatable(tween(durationMillis = 1000, easing = LinearEasing), repeatMode = RepeatMode.Reverse)
        )
    }

    val currentPage by remember {
        derivedStateOf { animatedProgress.value.toInt() }
    }

    SushiPreview {
        SushiDotsIndicator(
            dotCount = dotCount,
            dotSpacing = 8.dp,
            type = SushiIndicatorType.Balloon(),
            currentPage = currentPage,
            currentPageOffsetFraction = {
                val value = animatedProgress.value
                value - value.toInt()
            }
        )
    }
}

@SushiPreview
@Composable
private fun SushiDotsIndicatorShiftPreview() {
    val dotCount = 5
    val animatedProgress = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        animatedProgress.animateTo(
            targetValue = (dotCount - 1).toFloat(),
            animationSpec = infiniteRepeatable(tween(durationMillis = 1000, easing = LinearEasing), repeatMode = RepeatMode.Reverse)
        )
    }

    val currentPage by remember {
        derivedStateOf { animatedProgress.value.toInt() }
    }

    SushiPreview {
        SushiDotsIndicator(
            dotCount = dotCount,
            dotSpacing = 8.dp,
            type = SushiIndicatorType.Shift(),
            currentPage = currentPage,
            currentPageOffsetFraction = {
                val value = animatedProgress.value
                value - value.toInt()
            }
        )
    }
}

@SushiPreview
@Composable
private fun SushiDotsIndicatorSpringPreview() {
    val dotCount = 5
    val animatedProgress = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        animatedProgress.animateTo(
            targetValue = (dotCount - 1).toFloat(),
            animationSpec = infiniteRepeatable(tween(durationMillis = 1000, easing = LinearEasing), repeatMode = RepeatMode.Reverse)
        )
    }

    val currentPage by remember {
        derivedStateOf { animatedProgress.value.toInt() }
    }

    SushiPreview {
        SushiDotsIndicator(
            dotCount = dotCount,
            dotSpacing = 8.dp,
            type = SushiIndicatorType.Shift(),
            currentPage = currentPage,
            currentPageOffsetFraction = {
                val value = animatedProgress.value
                value - value.toInt()
            }
        )
    }
}


@SushiPreview
@Composable
private fun SushiDotsIndicatorWormPreview() {
    val dotCount = 5
    val animatedProgress = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        animatedProgress.animateTo(
            targetValue = (dotCount - 1).toFloat(),
            animationSpec = infiniteRepeatable(tween(durationMillis = 1000, easing = LinearEasing), repeatMode = RepeatMode.Reverse)
        )
    }

    val currentPage by remember {
        derivedStateOf { animatedProgress.value.toInt() }
    }

    SushiPreview {
        SushiDotsIndicator(
            dotCount = dotCount,
            dotSpacing = 8.dp,
            type = SushiIndicatorType.Worm(),
            currentPage = currentPage,
            currentPageOffsetFraction = {
                val value = animatedProgress.value
                value - value.toInt()
            }
        )
    }
}