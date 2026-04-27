package com.zomato.sushi.compose.components.calender

import androidx.compose.foundation.lazy.LazyListItemInfo
import androidx.compose.foundation.lazy.LazyListLayoutInfo
import com.zomato.sushi.compose.components.calender.core.CalendarMonth

/**
 * Contains useful information about the currently displayed layout state of the calendar.
 * For example you can get the list of currently displayed months.
 *
 * Use [CalendarState.layoutInfo] to retrieve this.
 * @see LazyListLayoutInfo
 */
public class CalendarLayoutInfo(info: LazyListLayoutInfo, private val month: (Int) -> CalendarMonth) :
    LazyListLayoutInfo by info {
    /**
     * The list of [CalendarItemInfo] representing all the currently visible months.
     */
    public val visibleMonthsInfo: List<CalendarItemInfo>
        get() = visibleItemsInfo.map {
            CalendarItemInfo(it, month(it.index))
        }
}

/**
 * Contains useful information about an individual [CalendarMonth] on the calendar.
 *
 * @param month The month in the list.
 *
 * @see CalendarLayoutInfo
 * @see LazyListItemInfo
 */
public class CalendarItemInfo(info: LazyListItemInfo, public val month: CalendarMonth) : LazyListItemInfo by info
