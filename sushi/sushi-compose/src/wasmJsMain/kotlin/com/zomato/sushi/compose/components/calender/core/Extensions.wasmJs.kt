package com.zomato.sushi.compose.components.calender.core

import androidx.compose.ui.text.intl.Locale
import kotlinx.datetime.DayOfWeek

/**
 * wasmJs has no portable locale-aware first-day-of-week API, so default to the ISO-8601
 * first day of week (Monday).
 */
public actual fun firstDayOfWeekFromLocale(locale: Locale): DayOfWeek = DayOfWeek.MONDAY
