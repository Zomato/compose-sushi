package com.zomato.sushi.compose.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

/**
 * @author gupta.anirudh@zomato.com
 */

@Composable
inline fun Dp.toSp() = with(LocalDensity.current) { remember(this@with) { this@toSp.toSp() } }

@Composable
inline fun TextUnit.toDp() = with(LocalDensity.current) { remember(this@with) { this@toDp.toDp() } }

@Composable
inline fun TextUnit.toPx() = with(LocalDensity.current) { remember(this@with) { this@toPx.toPx() } }

@Composable
inline fun Dp.toPx() = with(LocalDensity.current) { remember(this@with) { this@toPx.toPx() } }

@Composable
inline fun Float.toDp() = with(LocalDensity.current) { remember(this@with) { this@toDp.toDp() } }

@Composable
inline fun Int.toDp() = with(LocalDensity.current) { remember(this@with) { this@toDp.toDp() } }