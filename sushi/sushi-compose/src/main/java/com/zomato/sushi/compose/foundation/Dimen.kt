package com.zomato.sushi.compose.foundation

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Defines the standard text size constants used throughout the Sushi design system.
 * 
 * These constants follow a numeric scale from smallest (050) to largest (900) and
 * are used to ensure typographic consistency across the application.
 *
 * @author gupta.anirudh@zomato.com
 */

val SushiTextSize050 = 10.sp
val SushiTextSize100 = 12.sp
val SushiTextSize200 = 13.sp
val SushiTextSize300 = 14.sp
val SushiTextSize400 = 16.sp
val SushiTextSize500 = 18.sp
val SushiTextSize600 = 20.sp
val SushiTextSize700 = 22.sp
val SushiTextSize800 = 25.sp
val SushiTextSize900 = 28.sp

/**
 * Defines the standard spacing constants used throughout the Sushi design system.
 * 
 * These spacing values follow a naming convention from smallest (Femto) to largest (Alone)
 * and are used to ensure consistent spacing throughout the application.
 */
val SushiSpacingFemto = 0.dp
val SushiSpacingPico = 1.dp
val SushiSpacingNano = 2.dp
val SushiSpacingMicro = 4.dp
val SushiSpacingMini = 6.dp
val SushiSpacingMacro = 8.dp
val SushiSpacingLarge = 10.dp
val SushiSpacingBase = 12.dp
val SushiSpacingExtra = 16.dp
val SushiSpacingLoose = 24.dp
val SushiSpacingAlone = 32.dp

/**
 * Common application-level dimensional constants used for layout construction.
 */
val SushiCornerRadius = 8.dp
val SushiSpacingPageSide = SushiSpacingBase
val SushiSpacingBetween = SushiSpacingMicro
val SushiSpacingBetweenLarge = SushiSpacingMini
val SushiSpacingBetweenSmall = SushiSpacingNano