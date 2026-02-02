package com.zomato.sushi.compose.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import kotlinx.collections.immutable.PersistentList

@Stable
data class ThemedProps<T>(
    val colorSchemeType: SushiColorSchemeType,
    val props: T
)

interface ThemedPropsProvider<T> {
    val themedPropsList: PersistentList<ThemedProps<T>>?

    fun findThemedProps(colorSchemeType: SushiColorSchemeType): T? {
        return themedPropsList?.find { it.colorSchemeType == colorSchemeType }?.props
    }

    fun getThemedProps(colorSchemeType: SushiColorSchemeType): T
}

@Composable
fun <T> ThemedPropsProvider<T>.getThemedProps(): T {
    return getThemedProps(colorSchemeType = SushiTheme.colorSchemeType)
}