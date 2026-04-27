package com.zomato.sushi.compose.components.calender.data

import com.zomato.sushi.compose.components.calender.core.CalendarYear
import com.zomato.sushi.compose.components.calender.core.OutDateStyle
import com.zomato.sushi.compose.components.calender.core.Year
import com.zomato.sushi.compose.components.calender.core.onMonth
import com.zomato.sushi.compose.components.calender.core.plusYears
import com.zomato.sushi.compose.components.calender.core.yearsUntil
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.Month

internal fun getCalendarYearData(
    startYear: Year,
    offset: Int,
    firstDayOfWeek: DayOfWeek,
    outDateStyle: OutDateStyle,
): CalendarYear {
    val year = startYear.plusYears(offset)
    val months = List(Month.entries.size) { index ->
        getCalendarMonthData(
            startMonth = year.onMonth(Month.JANUARY),
            offset = index,
            firstDayOfWeek = firstDayOfWeek,
            outDateStyle = outDateStyle,
        ).calendarMonth
    }
    return CalendarYear(year, months)
}

internal fun getYearIndex(startYear: Year, targetYear: Year): Int {
    return startYear.yearsUntil(targetYear)
}

internal fun getYearIndicesCount(startYear: Year, endYear: Year): Int {
    // Add one to include the start year itself!
    return getYearIndex(startYear, endYear) + 1
}
