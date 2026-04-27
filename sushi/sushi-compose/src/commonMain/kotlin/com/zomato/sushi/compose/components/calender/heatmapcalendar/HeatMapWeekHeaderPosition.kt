package com.zomato.sushi.compose.components.calender.heatmapcalendar

import com.zomato.sushi.compose.components.calender.HeatMapCalendar

/**
 * Determines the position of the week header
 * composable (Mon, Tue, Wed...) in the [HeatMapCalendar]
 */
public enum class HeatMapWeekHeaderPosition {
    /**
     * The header is positioned at the start of the calendar.
     */
    Start,

    /**
     * The header is positioned at the end of the calendar.
     */
    End,
}
