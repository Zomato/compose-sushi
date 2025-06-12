package com.zomato.sushi.compose.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

/**
 * Utility extension functions for converting between different measurement units in Compose.
 *
 * @author gupta.anirudh@zomato.com
 */

/**
 * Converts a Dp value to a TextUnit (Sp) value.
 * @return The equivalent TextUnit (Sp) value based on the current screen density
 */
@Composable
inline fun Dp.toSp() = with(LocalDensity.current) { remember(this@with) { this@toSp.toSp() } }

/**
 * Converts a TextUnit (Sp) value to a Dp value.
 * @return The equivalent Dp value based on the current screen density
 */
@Composable
inline fun TextUnit.toDp() = with(LocalDensity.current) { remember(this@with) { this@toDp.toDp() } }

/**
 * Converts a TextUnit (Sp) value to raw pixels.
 * @return The equivalent pixel value based on the current screen density
 */
@Composable
inline fun TextUnit.toPx() = with(LocalDensity.current) { remember(this@with) { this@toPx.toPx() } }

/**
 * Converts a Dp value to raw pixels.
 * @return The equivalent pixel value based on the current screen density
 */
@Composable
inline fun Dp.toPx() = with(LocalDensity.current) { remember(this@with) { this@toPx.toPx() } }

/**
 * Converts a Float value (assumed to be in raw pixels) to a Dp value.
 * @return The equivalent Dp value based on the current screen density
 */
@Composable
inline fun Float.toDp() = with(LocalDensity.current) { remember(this@with) { this@toDp.toDp() } }

/**
 * Converts an Int value (assumed to be in raw pixels) to a Dp value.
 * @return The equivalent Dp value based on the current screen density
 */
@Composable
inline fun Int.toDp() = with(LocalDensity.current) { remember(this@with) { this@toDp.toDp() } }