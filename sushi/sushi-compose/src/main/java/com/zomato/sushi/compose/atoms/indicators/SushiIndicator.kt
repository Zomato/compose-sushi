package com.zomato.sushi.compose.atoms.indicators

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.indicators.model.DotGraphic
import com.zomato.sushi.compose.atoms.indicators.type.BalloonIndicator
import com.zomato.sushi.compose.atoms.indicators.type.ShiftIndicator
import com.zomato.sushi.compose.atoms.indicators.type.SpringIndicator
import com.zomato.sushi.compose.atoms.indicators.type.SushiIndicatorType
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * A composable that displays page indicators for carousel or pager components.
 * 
 * SushiIndicator integrates with Compose's PagerState to automatically reflect
 * the current page and animate transitions between pages.
 *
 * @param dotCount The total number of pages to display indicators for
 * @param type The visual style of the indicators (Balloon, Shift, or Spring)
 * @param pagerState The state of the associated pager component
 * @param modifier Additional modifiers to apply to the indicator
 * @param dotSpacing Spacing between adjacent dots
 *
 * @author gupta.anirudh@zomato.com
 */

@Composable
fun SushiIndicator(
    dotCount: Int,
    type: SushiIndicatorType,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    dotSpacing: Dp = SushiTheme.dimens.spacing.base
) {
    val coroutineScope = rememberCoroutineScope()
    SushiIndicator(
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

/**
 * A composable that displays page indicators with manual control over page state.
 * 
 * This version of SushiIndicator accepts direct input for the current page and offset,
 * which is useful when integrating with custom paging solutions or for animation previews.
 *
 * @param dotCount The total number of pages to display indicators for
 * @param type The visual style of the indicators (Balloon, Shift, or Spring)
 * @param currentPage The current page index (integer value)
 * @param currentPageOffsetFraction Provider function for the fractional offset of the current page
 * @param modifier Additional modifiers to apply to the indicator
 * @param dotSpacing Spacing between adjacent dots
 * @param onDotClicked Optional callback for when a dot is clicked
 */
@Composable
fun SushiIndicator(
    dotCount: Int,
    type: SushiIndicatorType,
    currentPage: Int,
    currentPageOffsetFraction: () -> Float,
    modifier: Modifier = Modifier,
    dotSpacing: Dp = SushiTheme.dimens.spacing.base,
    onDotClicked: ((index: Int) -> Unit)? = null
) {
    SushiComponentBase(
        modifier
            .height(IntrinsicSize.Max)
            .width(IntrinsicSize.Max)
            .testTag("SushiIndicator")
    ) {
        val currentPageOffset by remember(dotCount, currentPage, currentPageOffsetFraction()) {
            derivedStateOf {
                (currentPage + currentPageOffsetFraction()).coerceIn(0f, (dotCount - 1).toFloat())
            }
        }

        when (type) {
            is SushiIndicatorType.Balloon -> {
                BalloonIndicator(
                    offsetProvider = { currentPageOffset },
                    dotCount = dotCount,
                    dotSpacing = dotSpacing,
                    onDotClicked = onDotClicked,
                    modifier = Modifier.fillMaxSize(),
                    dotsGraphic = type.dotsGraphic,
                    balloonSizeFactor = type.balloonSizeFactor,
                )
            }
            is SushiIndicatorType.Shift -> {
                ShiftIndicator(
                    offsetProvider = { currentPageOffset },
                    dotCount = dotCount,
                    dotSpacing = dotSpacing,
                    onDotClicked = onDotClicked,
                    modifier = Modifier,
                    dotsGraphic = type.dotsGraphic,
                    shiftSizeFactor = type.shiftSizeFactor,
                )
            }
            is SushiIndicatorType.Spring -> {
                SpringIndicator(
                    offsetProvider = { currentPageOffset },
                    dotCount = dotCount,
                    dotSpacing = dotSpacing,
                    onDotClicked = onDotClicked,
                    modifier = Modifier.fillMaxSize(),
                    dotsGraphic = type.dotsGraphic,
                    selectorDotGraphic = type.selectorDotGraphic,
                )
            }
        }
    }
}

@SushiPreview
@Composable
private fun SushiIndicatorBalloonPreview() {
    val dotCount = 5
    val animatedProgress = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(300)
            val newValue = (animatedProgress.value + 1) % dotCount.toFloat()
            if (newValue == 0f) {
                animatedProgress.snapTo(newValue)
            } else {
                animatedProgress.animateTo(
                    targetValue = (animatedProgress.value + 1) % dotCount.toFloat(),
                    animationSpec = tween(durationMillis = 100, easing = LinearEasing)
                )
            }
        }
    }

    val currentPage by remember {
        derivedStateOf { animatedProgress.value.toInt() }
    }

    SushiPreview {
        SushiIndicator(
            dotCount = dotCount,
            dotSpacing = 8.dp,
            type = SushiIndicatorType.Balloon(
                dotsGraphic = DotGraphic(
                    color = SushiTheme.colors.base.theme.v500.value,
                    size = 8.dp
                ),
                balloonSizeFactor = 2f
            ),
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
private fun SushiIndicatorShiftPreview() {
    val dotCount = 5
    val animatedProgress = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(300)
            val newValue = (animatedProgress.value + 1) % dotCount.toFloat()
            if (newValue == 0f) {
                animatedProgress.snapTo(newValue)
            } else {
                animatedProgress.animateTo(
                    targetValue = (animatedProgress.value + 1) % dotCount.toFloat(),
                    animationSpec = tween(durationMillis = 100, easing = LinearEasing)
                )
            }
        }
    }

    val currentPage by remember {
        derivedStateOf { animatedProgress.value.toInt() }
    }

    SushiPreview {
        SushiIndicator(
            dotCount = dotCount,
            dotSpacing = 8.dp,
            type = SushiIndicatorType.Shift(
                dotsGraphic = DotGraphic(
                    color = SushiTheme.colors.base.theme.v500.value
                )
            ),
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
private fun SushiIndicatorSpringPreview() {
    val dotCount = 5
    val animatedProgress = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(300)
            val newValue = (animatedProgress.value + 1) % dotCount.toFloat()
            if (newValue == 0f) {
                animatedProgress.snapTo(newValue)
            } else {
                animatedProgress.animateTo(
                    targetValue = (animatedProgress.value + 1) % dotCount.toFloat(),
                    animationSpec = tween(durationMillis = 100, easing = LinearEasing)
                )
            }
        }
    }

    val currentPage by remember {
        derivedStateOf { animatedProgress.value.toInt() }
    }

    SushiPreview {
        SushiIndicator(
            dotCount = dotCount,
            dotSpacing = 8.dp,
            type = SushiIndicatorType.Spring(
                dotsGraphic = DotGraphic(
                    16.dp,
                    borderWidth = 2.dp,
                    borderColor = SushiTheme.colors.base.theme.v500.value,
                    color = Color.Transparent
                ),
                selectorDotGraphic = DotGraphic(
                    14.dp,
                    color = SushiTheme.colors.base.theme.v500.value
                )
            ),
            currentPage = currentPage,
            currentPageOffsetFraction = {
                val value = animatedProgress.value
                value - value.toInt()
            }
        )
    }
}