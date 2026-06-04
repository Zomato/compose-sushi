package com.zomato.sushi.compose.components.calender

import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.components.calender.core.OutDateStyle
import kotlinx.datetime.DayOfWeek

@Immutable
internal data class CalendarInfo(
    val indexCount: Int,
    private val firstDayOfWeek: DayOfWeek? = null,
    private val outDateStyle: OutDateStyle? = null,
)
