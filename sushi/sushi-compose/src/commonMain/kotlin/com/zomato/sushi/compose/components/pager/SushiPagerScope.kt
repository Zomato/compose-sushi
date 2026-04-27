package com.zomato.sushi.compose.components.pager

import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Receiver scope for [SushiVerticalPager], [SushiHorizontalPager]
 */
@Stable
interface SushiPagerScope {
    /**
     * Pager Scope of underlying Compose pager
     */
    val pagerScope: PagerScope

    /**
     * Pager State
     */
    val pagerState: PagerState

    /**
     * Current page index
     */
    val page: Int
}

/**
 * Composition local for [SushiPagerScope]
 */
val LocalSushiPagerScope = staticCompositionLocalOf<SushiPagerScope?> { null }

@Stable
private class SushiPagerScopeImpl(
    override val pagerScope: PagerScope,
    override val pagerState: PagerState,
    override val page: Int
) : SushiPagerScope

@Composable
internal fun rememberSushiPagerScope(
    pagerScope: PagerScope,
    pagerState: PagerState,
    page: Int
): SushiPagerScope {
    return remember(pagerScope, pagerState, page) {
        SushiPagerScopeImpl(pagerScope, pagerState, page)
    }
}