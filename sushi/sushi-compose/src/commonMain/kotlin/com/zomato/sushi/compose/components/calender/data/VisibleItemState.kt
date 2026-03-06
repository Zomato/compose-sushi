package com.zomato.sushi.compose.components.calender.data

import androidx.compose.runtime.Immutable

@Immutable
internal class VisibleItemState(
    val firstVisibleItemIndex: Int = 0,
    val firstVisibleItemScrollOffset: Int = 0,
)
