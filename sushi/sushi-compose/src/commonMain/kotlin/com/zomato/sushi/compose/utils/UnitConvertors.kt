package com.zomato.sushi.compose.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import kotlin.math.roundToInt

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
fun Dp.toSp(): TextUnit = with(LocalDensity.current) { toSp() }

/**
 * Converts a TextUnit (Sp) value to a Dp value.
 * @return The equivalent Dp value based on the current screen density
 */
@Composable
fun TextUnit.toDp(): Dp = with(LocalDensity.current) { toDp() }

/**
 * Converts a TextUnit (Sp) value to raw pixels.
 * @return The equivalent pixel value based on the current screen density
 */
@Composable
fun TextUnit.toPx(): Float = with(LocalDensity.current) { toPx() }

/**
 * Converts a Dp value to raw pixels.
 * @return The equivalent pixel value based on the current screen density
 */
@Composable
fun Dp.toPx(): Float = with(LocalDensity.current) { toPx() }

/**
 * Converts a Dp value to raw pixels (rounded to nearest integer value).
 * @return The equivalent pixel value (rounded to nearest integer value)
 * based on the current screen density
 */
@Composable
fun Dp.roundToPx(): Int = with(LocalDensity.current) { toPx() }.roundToInt()

/**
 * Converts a Float value (assumed to be in raw pixels) to a Dp value.
 * @return The equivalent Dp value based on the current screen density
 */
@Composable
fun Float.toDp(): Dp = with(LocalDensity.current) { toDp() }

/**
 * Converts an Int value (assumed to be in raw pixels) to a Dp value.
 * @return The equivalent Dp value based on the current screen density
 */
@Composable
fun Int.toDp(): Dp = with(LocalDensity.current) { toDp() }