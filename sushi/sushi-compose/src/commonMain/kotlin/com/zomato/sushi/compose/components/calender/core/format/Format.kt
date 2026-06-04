package com.zomato.sushi.compose.components.calender.core.format

import com.zomato.sushi.compose.components.calender.core.Year
import com.zomato.sushi.compose.components.calender.core.onMonth
import kotlinx.datetime.LocalDate
import kotlinx.datetime.YearMonth

private val ISO_YEAR_MONTH by lazy {
    YearMonth.Formats.ISO
}

private val ISO_YEAR by lazy {
    LocalDate.Format { year() }
}

private val ISO_LOCAL_DATE by lazy {
    LocalDate.Formats.ISO
}

internal fun LocalDate.toIso8601String() = ISO_LOCAL_DATE.format(this)

internal fun YearMonth.toIso8601String() = ISO_YEAR_MONTH.format(this)

internal fun Year.toIso8601String() = ISO_YEAR.format(onMonth(1).firstDay)

internal fun String.fromIso8601LocalDate(): LocalDate =
    LocalDate.parse(this, ISO_LOCAL_DATE)

internal fun String.fromIso8601YearMonth(): YearMonth =
    YearMonth.parse(this, ISO_YEAR_MONTH)

internal fun String.fromIso8601Year(): Year =
    Year(LocalDate.parse("$this-01-01", ISO_LOCAL_DATE).year)
