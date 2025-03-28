package com.zomato.sushi.compose.components.pager

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.TargetedFlingBehavior
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * A horizontal pager component for the Sushi design system.
 *
 * Use this component to create horizontal carousels, image galleries, onboarding flows,
 * or any UI that requires paging through content in a horizontal direction.
 *
 * @param state The state object to control and observe the pager's state
 * @param modifier The modifier to be applied to the pager
 * @param contentPadding Padding to be applied to the pager content
 * @param pageSize Strategy defining how pages should be sized
 * @param beyondViewportPageCount The number of pages to keep loaded beyond the visible viewport
 * @param pageSpacing Spacing between each page
 * @param verticalAlignment Vertical alignment of each page within the pager
 * @param flingBehavior The fling behavior that defines how the pager should handle fling gestures
 * @param userScrollEnabled Whether user scrolling is enabled
 * @param reverseLayout Whether the layout should be reversed (right to left instead of left to right)
 * @param key Optional lambda to provide a unique key for each page, improving performance for dynamic content
 * @param pageNestedScrollConnection Nested scroll connection to be applied to each page
 * @param snapPosition Position to which the pages should snap
 * @param pageContent Content to be displayed for each page
 *
 * @author gupta.anirudh@zomato.com
 */
@Composable
fun SushiHorizontalPager(
    state: PagerState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    pageSize: PageSize = PageSize.Fill,
    beyondViewportPageCount: Int = PagerDefaults.BeyondViewportPageCount,
    pageSpacing: Dp = 0.dp,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    flingBehavior: TargetedFlingBehavior = PagerDefaults.flingBehavior(state = state),
    userScrollEnabled: Boolean = true,
    reverseLayout: Boolean = false,
    key: ((index: Int) -> Any)? = null,
    pageNestedScrollConnection: NestedScrollConnection = PagerDefaults.pageNestedScrollConnection(
        state,
        Orientation.Horizontal
    ),
    snapPosition: SnapPosition = SnapPosition.Start,
    pageContent: @Composable PagerScope.(page: Int) -> Unit
) {
    HorizontalPager(
        state = state,
        modifier = modifier.testTag("SushiHorizontalPager"),
        contentPadding = contentPadding,
        pageSize = pageSize,
        beyondViewportPageCount = beyondViewportPageCount,
        pageSpacing = pageSpacing,
        verticalAlignment = verticalAlignment,
        flingBehavior = flingBehavior,
        userScrollEnabled = userScrollEnabled,
        reverseLayout = reverseLayout,
        key = key,
        pageNestedScrollConnection = pageNestedScrollConnection,
        snapPosition = snapPosition,
        pageContent = pageContent
    )
}