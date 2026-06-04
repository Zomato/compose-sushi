package com.zomato.sushi.compose.components.calender

import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.lazy.LazyListLayoutInfo
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.zomato.sushi.compose.components.calender.core.CalendarDay
import com.zomato.sushi.compose.components.calender.core.DayPosition
import com.zomato.sushi.compose.components.calender.core.OutDateStyle
import com.zomato.sushi.compose.components.calender.core.firstDayOfWeekFromLocale
import com.zomato.sushi.compose.components.calender.core.format.fromIso8601YearMonth
import com.zomato.sushi.compose.components.calender.core.format.toIso8601String
import com.zomato.sushi.compose.components.calender.core.now
import com.zomato.sushi.compose.components.calender.data.DataStore
import com.zomato.sushi.compose.components.calender.data.VisibleItemState
import com.zomato.sushi.compose.components.calender.data.checkRange
import com.zomato.sushi.compose.components.calender.data.daysUntil
import com.zomato.sushi.compose.components.calender.data.getCalendarMonthData
import com.zomato.sushi.compose.components.calender.data.getMonthIndex
import com.zomato.sushi.compose.components.calender.data.getMonthIndicesCount
import com.zomato.sushi.compose.components.calender.data.indexOfFirstOrNull
import com.zomato.sushi.compose.components.calender.data.log
import com.zomato.sushi.compose.components.calender.data.positionYearMonth
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.YearMonth
import kotlin.time.ExperimentalTime

/**
 * Creates a [CalendarState] that is remembered across compositions.
 *
 * @param startMonth the initial value for [CalendarState.startMonth]
 * @param endMonth the initial value for [CalendarState.endMonth]
 * @param firstDayOfWeek the initial value for [CalendarState.firstDayOfWeek]
 * @param firstVisibleMonth the initial value for [CalendarState.firstVisibleMonth]
 * @param outDateStyle the initial value for [CalendarState.outDateStyle]
 */
@OptIn(ExperimentalTime::class)
@Composable
public fun rememberCalendarState(
    startMonth: YearMonth = YearMonth.now(),
    endMonth: YearMonth = startMonth,
    firstVisibleMonth: YearMonth = startMonth,
    firstDayOfWeek: DayOfWeek = firstDayOfWeekFromLocale(),
    outDateStyle: OutDateStyle = OutDateStyle.EndOfRow,
): CalendarState {
    return rememberSaveable(
        inputs = arrayOf<Any>(
            startMonth,
            endMonth,
            firstVisibleMonth,
            firstDayOfWeek,
            outDateStyle,
        ),
        saver = CalendarState.Saver,
    ) {
        CalendarState(
            startMonth = startMonth,
            endMonth = endMonth,
            firstDayOfWeek = firstDayOfWeek,
            firstVisibleMonth = firstVisibleMonth,
            outDateStyle = outDateStyle,
            visibleItemState = null,
        )
    }
}

/**
 * A state object that can be hoisted to control and observe calendar properties.
 *
 * This should be created via [rememberCalendarState].
 *
 * @param startMonth the first month on the calendar.
 * @param endMonth the last month on the calendar.
 * @param firstDayOfWeek the first day of week on the calendar.
 * @param firstVisibleMonth the initial value for [CalendarState.firstVisibleMonth]
 * @param outDateStyle the preferred style for out date generation.
 */
@Stable
public class CalendarState internal constructor(
    startMonth: YearMonth,
    endMonth: YearMonth,
    firstDayOfWeek: DayOfWeek,
    firstVisibleMonth: YearMonth,
    outDateStyle: OutDateStyle,
    visibleItemState: VisibleItemState?,
) : ScrollableState {
    /** Backing state for [startMonth] */
    private var _startMonth by mutableStateOf(startMonth)

    /** The first month on the calendar. */
    public var startMonth: YearMonth
        get() = _startMonth
        set(value) {
            if (value != startMonth) {
                _startMonth = value
                monthDataChanged()
            }
        }

    /** Backing state for [endMonth] */
    private var _endMonth by mutableStateOf(endMonth)

    /** The last month on the calendar. */
    public var endMonth: YearMonth
        get() = _endMonth
        set(value) {
            if (value != endMonth) {
                _endMonth = value
                monthDataChanged()
            }
        }

    /** Backing state for [firstDayOfWeek] */
    private var _firstDayOfWeek by mutableStateOf(firstDayOfWeek)

    /** The first day of week on the calendar. */
    public var firstDayOfWeek: DayOfWeek
        get() = _firstDayOfWeek
        set(value) {
            if (value != firstDayOfWeek) {
                _firstDayOfWeek = value
                monthDataChanged()
            }
        }

    /** Backing state for [outDateStyle] */
    private var _outDateStyle by mutableStateOf(outDateStyle)

    /** The preferred style for out date generation. */
    public var outDateStyle: OutDateStyle
        get() = _outDateStyle
        set(value) {
            if (value != outDateStyle) {
                _outDateStyle = value
                monthDataChanged()
            }
        }

    /**
     * The first month that is visible.
     *
     * @see [lastVisibleMonth]
     */
    public val firstVisibleMonth: com.zomato.sushi.compose.components.calender.core.CalendarMonth by derivedStateOf {
        store[listState.firstVisibleItemIndex]
    }

    /**
     * The last month that is visible.
     *
     * @see [firstVisibleMonth]
     */
    public val lastVisibleMonth: com.zomato.sushi.compose.components.calender.core.CalendarMonth by derivedStateOf {
        store[listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0]
    }

    /**
     * The object of [CalendarLayoutInfo] calculated during the last layout pass. For example,
     * you can use it to calculate what items are currently visible.
     *
     * Note that this property is observable and is updated after every scroll or remeasure.
     * If you use it in the composable function it will be recomposed on every change causing
     * potential performance issues including infinity recomposition loop.
     * Therefore, avoid using it in the composition.
     *
     * If you need to use it in the composition then consider wrapping the calculation into a
     * derived state in order to only have recompositions when the derived value changes.
     * See Example6Page in the sample app for usage.
     *
     * If you want to run some side effects like sending an analytics event or updating a state
     * based on this value consider using "snapshotFlow".
     *
     * see [LazyListLayoutInfo]
     */
    public val layoutInfo: CalendarLayoutInfo
        get() = CalendarLayoutInfo(listState.layoutInfo) { index -> store[index] }

    /**
     * [InteractionSource] that will be used to dispatch drag events when this
     * calendar is being dragged. If you want to know whether the fling (or animated scroll) is in
     * progress, use [isScrollInProgress].
     */
    public val interactionSource: InteractionSource
        get() = listState.interactionSource

    internal val listState = LazyListState(
        firstVisibleItemIndex = visibleItemState?.firstVisibleItemIndex
            ?: getScrollIndex(firstVisibleMonth) ?: 0,
        firstVisibleItemScrollOffset = visibleItemState?.firstVisibleItemScrollOffset ?: 0,
    )

    internal val placementInfo = ItemPlacementInfo()

    internal var calendarInfo by mutableStateOf(CalendarInfo(indexCount = 0))

    internal val store = DataStore { offset ->
        getCalendarMonthData(
            startMonth = this.startMonth,
            offset = offset,
            firstDayOfWeek = this.firstDayOfWeek,
            outDateStyle = this.outDateStyle,
        ).calendarMonth
    }

    init {
        monthDataChanged() // Update indexCount initially.
    }

    private fun monthDataChanged() {
        store.clear()
        checkRange(startMonth, endMonth)
        // Read the firstDayOfWeek and outDateStyle properties to ensure recomposition
        // even though they are unused in the CalendarInfo. Alternatively, we could use
        // mutableStateMapOf() as the backing store for DataStore() to ensure recomposition
        // but not sure how compose handles recomposition of a lazy list that reads from
        // such map when an entry unrelated to the visible indices changes.
        calendarInfo = CalendarInfo(
            indexCount = getMonthIndicesCount(startMonth, endMonth),
            firstDayOfWeek = firstDayOfWeek,
            outDateStyle = outDateStyle,
        )
    }

    /**
     * Instantly brings the [month] to the top of the viewport.
     *
     * @param month the month to which to scroll. Must be within the
     * range of [startMonth] and [endMonth].
     *
     * @see [animateScrollToMonth]
     */
    public suspend fun scrollToMonth(month: YearMonth) {
        listState.scrollToItem(getScrollIndex(month) ?: return)
    }

    /**
     * Animate (smooth scroll) to the given [month].
     *
     * @param month the month to which to scroll. Must be within the
     * range of [startMonth] and [endMonth].
     *
     * @see [scrollToMonth]
     */
    public suspend fun animateScrollToMonth(month: YearMonth) {
        listState.animateScrollToItem(getScrollIndex(month) ?: return)
    }

    /**
     * Instantly brings the [date] to the top of the viewport.
     *
     * @param date the date to which to scroll. Must be within the
     * range of [startMonth] and [endMonth].
     * @param position the position of the date in the month.
     *
     * @see [animateScrollToDate]
     */
    public suspend fun scrollToDate(
        date: LocalDate,
        position: DayPosition = DayPosition.MonthDate,
    ): Unit = scrollToDay(CalendarDay(date, position))

    /**
     * Animate (smooth scroll) to the given [date].
     *
     * @param date the date to which to scroll. Must be within the
     * range of [startMonth] and [endMonth].
     * @param position the position of the date in the month.
     *
     * @see [scrollToDate]
     */
    public suspend fun animateScrollToDate(
        date: LocalDate,
        position: DayPosition = DayPosition.MonthDate,
    ): Unit = animateScrollToDay(CalendarDay(date, position))

    /**
     * Instantly brings the [day] to the top of the viewport.
     *
     * @param day the day to which to scroll. Must be within the
     * range of [startMonth] and [endMonth].
     *
     * @see [animateScrollToDay]
     */
    public suspend fun scrollToDay(day: CalendarDay): Unit =
        scrollToDay(day, animate = false)

    /**
     * Animate (smooth scroll) to the given [day].
     *
     * @param day the day to which to scroll. Must be within the
     * range of [startMonth] and [endMonth].
     *
     * @see [scrollToDay]
     */
    public suspend fun animateScrollToDay(day: CalendarDay): Unit =
        scrollToDay(day, animate = true)

    private suspend fun scrollToDay(day: CalendarDay, animate: Boolean) {
        val monthIndex = getScrollIndex(day.positionYearMonth) ?: return
        val weeksOfMonth = store[monthIndex].weekDays
        val dayIndex = when (layoutInfo.orientation) {
            Orientation.Vertical -> weeksOfMonth.indexOfFirstOrNull { it.contains(day) }
            Orientation.Horizontal -> firstDayOfWeek.daysUntil(day.date.dayOfWeek)
        } ?: return
        val dayInfo = placementInfo.awaitFistDayOffsetAndSize(layoutInfo.orientation) ?: return
        val scrollOffset = dayInfo.offset + dayInfo.size * dayIndex
        if (animate) {
            listState.animateScrollToItem(monthIndex, scrollOffset)
        } else {
            listState.scrollToItem(monthIndex, scrollOffset)
        }
    }

    private fun getScrollIndex(month: YearMonth): Int? {
        if (month !in startMonth..endMonth) {
            log("CalendarState", "Attempting to scroll out of range: $month")
            return null
        }
        return getMonthIndex(startMonth, month)
    }

    /**
     * Whether this [ScrollableState] is currently scrolling by gesture, fling or programmatically.
     */
    override val isScrollInProgress: Boolean
        get() = listState.isScrollInProgress

    override fun dispatchRawDelta(delta: Float): Float = listState.dispatchRawDelta(delta)

    override suspend fun scroll(
        scrollPriority: MutatePriority,
        block: suspend ScrollScope.() -> Unit,
    ): Unit = listState.scroll(scrollPriority, block)

    public companion object {
        internal val Saver: Saver<CalendarState, Any> = listSaver(
            save = {
                listOf(
                    it.startMonth.toIso8601String(),
                    it.endMonth.toIso8601String(),
                    it.firstVisibleMonth.yearMonth.toIso8601String(),
                    it.firstDayOfWeek,
                    it.outDateStyle,
                    it.listState.firstVisibleItemIndex,
                    it.listState.firstVisibleItemScrollOffset,
                )
            },
            restore = {
                CalendarState(
                    startMonth = (it[0] as String).fromIso8601YearMonth(),
                    endMonth = (it[1] as String).fromIso8601YearMonth(),
                    firstVisibleMonth = (it[2] as String).fromIso8601YearMonth(),
                    firstDayOfWeek = it[3] as DayOfWeek,
                    outDateStyle = it[4] as OutDateStyle,
                    visibleItemState = VisibleItemState(
                        firstVisibleItemIndex = it[5] as Int,
                        firstVisibleItemScrollOffset = it[6] as Int,
                    ),
                )
            },
        )
    }
}
