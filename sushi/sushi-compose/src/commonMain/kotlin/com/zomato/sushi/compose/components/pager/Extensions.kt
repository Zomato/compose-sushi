package com.zomato.sushi.compose.components.pager

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.pager.PagerState

/**
 * Smoothly scroll to a page with a pager. This version will not pre-jump to a nearer page if the
 * target page is far away, but will instead animate the entire distance in one go.
 *
 * @param targetPage The destination page to scroll to
 * @param durationMillis The duration of the animation in milliseconds
 * @param easing The easing curve for the animation
 */
suspend fun PagerState.smoothAnimateScrollToPage(
    targetPage: Int,
    durationMillis: Int = 600,
    easing: Easing = FastOutSlowInEasing,
) {
    // Clamp target to valid range
    val target = targetPage.coerceIn(0, pageCount - 1)

    // Full size of one page slot (px): rendered width/height + spacing
    val pageSize = layoutInfo.pageSize + layoutInfo.pageSpacing

    // Total pixel distance we need to travel, accounting for any current fractional offset
    val totalScrollPx =
        (target - currentPage) * pageSize - (currentPageOffsetFraction * pageSize)

    if (totalScrollPx == 0f) return

    val animatable = Animatable(initialValue = 0f)
    var prevAnimatedValue = 0f

    // scroll{} acquires the scroll mutex — prevents user touch from interrupting
    scroll(scrollPriority = MutatePriority.PreventUserInput) {
        animatable.animateTo(
            targetValue = totalScrollPx,
            animationSpec = tween(durationMillis = durationMillis, easing = easing),
        ) {
            // Called every animation frame with the latest `value`
            val delta = value - prevAnimatedValue
            scrollBy(delta)
            prevAnimatedValue = value
        }
    }
}