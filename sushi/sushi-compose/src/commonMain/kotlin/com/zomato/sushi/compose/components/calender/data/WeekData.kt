package com.zomato.sushi.compose.components.calender.data

import com.zomato.sushi.compose.components.calender.core.Week
import com.zomato.sushi.compose.components.calender.core.WeekDay
import com.zomato.sushi.compose.components.calender.core.WeekDayPosition
import com.zomato.sushi.compose.components.calender.core.minusDays
import com.zomato.sushi.compose.components.calender.core.plusDays
import com.zomato.sushi.compose.components.calender.core.plusWeeks
import com.zomato.sushi.compose.components.calender.core.weeksUntil
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate

internal data class WeekDateRange(
    val startDateAdjusted: LocalDate,
    val endDateAdjusted: LocalDate,
)

internal fun getWeekCalendarAdjustedRange(
    startDate: LocalDate,
    endDate: LocalDate,
    firstDayOfWeek: DayOfWeek,
): WeekDateRange {
    val inDays = firstDayOfWeek.daysUntil(startDate.dayOfWeek)
    val startDateAdjusted = startDate.minusDays(inDays)
    val weeksBetween = startDateAdjusted.weeksUntil(endDate)
    val endDateAdjusted = startDateAdjusted.plusWeeks(weeksBetween).plusDays(6)
    return WeekDateRange(startDateAdjusted = startDateAdjusted, endDateAdjusted = endDateAdjusted)
}

internal fun getWeekCalendarData(
    startDateAdjusted: LocalDate,
    offset: Int,
    desiredStartDate: LocalDate,
    desiredEndDate: LocalDate,
): WeekData {
    val firstDayInWeek = startDateAdjusted.plusWeeks(offset)
    return WeekData(firstDayInWeek, desiredStartDate, desiredEndDate)
}

internal data class WeekData(
    private val firstDayInWeek: LocalDate,
    private val desiredStartDate: LocalDate,
    private val desiredEndDate: LocalDate,
) {
    val week: Week = Week((0 until 7).map { dayOffset -> getDay(dayOffset) })

    private fun getDay(dayOffset: Int): WeekDay {
        val date = firstDayInWeek.plusDays(dayOffset)
        val position = when {
            date < desiredStartDate -> WeekDayPosition.InDate
            date > desiredEndDate -> WeekDayPosition.OutDate
            else -> WeekDayPosition.RangeDate
        }
        return WeekDay(date, position)
    }
}

internal fun getWeekIndex(startDateAdjusted: LocalDate, date: LocalDate): Int {
    return startDateAdjusted.weeksUntil(date)
}

internal fun getWeekIndicesCount(startDateAdjusted: LocalDate, endDateAdjusted: LocalDate): Int {
    // Add one to include the start week itself!
    return getWeekIndex(startDateAdjusted, endDateAdjusted) + 1
}
