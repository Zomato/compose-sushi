package com.zomato.sushi.compose.components.calender.core

import androidx.compose.ui.text.intl.Locale
import kotlinx.datetime.DayOfWeek
import java.util.Calendar

actual fun firstDayOfWeekFromLocale(locale: Locale): DayOfWeek {
    val javaLocale = java.util.Locale(locale.language, locale.region)

    val firstDay = Calendar.getInstance(javaLocale).firstDayOfWeek

    return when (firstDay) {
        Calendar.MONDAY -> DayOfWeek.MONDAY
        Calendar.TUESDAY -> DayOfWeek.TUESDAY
        Calendar.WEDNESDAY -> DayOfWeek.WEDNESDAY
        Calendar.THURSDAY -> DayOfWeek.THURSDAY
        Calendar.FRIDAY -> DayOfWeek.FRIDAY
        Calendar.SATURDAY -> DayOfWeek.SATURDAY
        Calendar.SUNDAY -> DayOfWeek.SUNDAY
        else -> DayOfWeek.MONDAY
    }
}