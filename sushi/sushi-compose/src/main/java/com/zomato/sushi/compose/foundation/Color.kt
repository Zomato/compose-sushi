package com.zomato.sushi.compose.foundation

import androidx.compose.ui.graphics.Color
import com.zomato.sushi.compose.atoms.color.ColorSchemeTypeAdaptedColorSpec
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec

/**
 * Theme-aware color declarations for the Sushi design system.
 *
 * This file defines ColorSpec instances for all the color families in the design system.
 * Unlike the raw color tokens, these ColorSpec instances automatically adapt to the
 * current theme (light or dark) through the [ColorSchemeTypeAdaptedColorSpec] implementation.
 *
 * In dark mode, these values are typically inverted (e.g., Grey050 in light mode becomes
 * Grey900 in dark mode) to maintain proper contrast and visual hierarchy.
 *
 * @author gupta.anirudh@zomato.com
 */

val Black = SushiRawColorTokens.Black.asColorSpec()
val White = SushiRawColorTokens.White.asColorSpec()
val Transparent = SushiRawColorTokens.Transparent.asColorSpec()

val Grey050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Grey050, SushiRawColorTokens.Slate900)
val Grey100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Grey100, SushiRawColorTokens.Slate800)
val Grey200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Grey200, SushiRawColorTokens.Slate700)
val Grey300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Grey300, SushiRawColorTokens.Slate600)
val Grey400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Grey400, SushiRawColorTokens.Slate500)
val Grey500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Grey500, SushiRawColorTokens.Slate400)
val Grey600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Grey600, SushiRawColorTokens.Slate300)
val Grey700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Grey700, SushiRawColorTokens.Slate200)
val Grey800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Grey800, SushiRawColorTokens.Slate100)
val Grey900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Grey900, SushiRawColorTokens.Slate050)

val Red050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Red050, SushiRawColorTokens.Red900)
val Red100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Red100, SushiRawColorTokens.Red800)
val Red200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Red200, SushiRawColorTokens.Red700)
val Red300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Red300, Color(0xFFD04D5A))
val Red400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Red400, SushiRawColorTokens.Red500)
val Red500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Red500, SushiRawColorTokens.Red500)
val Red600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Red600, SushiRawColorTokens.Red300)
val Red700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Red700, SushiRawColorTokens.Red200)
val Red800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Red800, SushiRawColorTokens.Red100)
val Red900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Red900, Color(0xFFFFF5F6))

val Green050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Green050, SushiRawColorTokens.Green900)
val Green100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Green100, SushiRawColorTokens.Green800)
val Green200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Green200, SushiRawColorTokens.Green700)
val Green300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Green300, SushiRawColorTokens.Green600)
val Green400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Green400, SushiRawColorTokens.Green500)
val Green500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Green500, SushiRawColorTokens.Green400)
val Green600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Green600, SushiRawColorTokens.Green300)
val Green700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Green700, SushiRawColorTokens.Green200)
val Green800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Green800, SushiRawColorTokens.Green100)
val Green900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Green900, SushiRawColorTokens.Green050)

val Blue050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Blue050, SushiRawColorTokens.Blue900)
val Blue100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Blue100, SushiRawColorTokens.Blue800)
val Blue200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Blue200, SushiRawColorTokens.Blue700)
val Blue300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Blue300, SushiRawColorTokens.Blue600)
val Blue400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Blue400, SushiRawColorTokens.Blue500)
val Blue500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Blue500, SushiRawColorTokens.Blue400)
val Blue600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Blue600, SushiRawColorTokens.Blue300)
val Blue700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Blue700, SushiRawColorTokens.Blue200)
val Blue800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Blue800, SushiRawColorTokens.Blue100)
val Blue900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Blue900, SushiRawColorTokens.Blue050)

val Yellow050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Yellow050, SushiRawColorTokens.Yellow900)
val Yellow100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Yellow100, SushiRawColorTokens.Yellow800)
val Yellow200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Yellow200, SushiRawColorTokens.Yellow700)
val Yellow300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Yellow300, SushiRawColorTokens.Yellow600)
val Yellow400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Yellow400, SushiRawColorTokens.Yellow500)
val Yellow500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Yellow500, SushiRawColorTokens.Yellow400)
val Yellow600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Yellow600, SushiRawColorTokens.Yellow300)
val Yellow700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Yellow700, SushiRawColorTokens.Yellow200)
val Yellow800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Yellow800, SushiRawColorTokens.Yellow100)
val Yellow900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Yellow900, SushiRawColorTokens.Yellow050)

// Purple

val Purple050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Purple050, SushiRawColorTokens.Purple900)
val Purple100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Purple100, SushiRawColorTokens.Purple800)
val Purple200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Purple200, SushiRawColorTokens.Purple700)
val Purple300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Purple300, SushiRawColorTokens.Purple600)
val Purple400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Purple400, SushiRawColorTokens.Purple500)
val Purple500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Purple500, SushiRawColorTokens.Purple400)
val Purple600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Purple600, SushiRawColorTokens.Purple300)
val Purple700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Purple700, SushiRawColorTokens.Purple200)
val Purple800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Purple800, SushiRawColorTokens.Purple100)
val Purple900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Purple900, Color(0xFFFAF8FE))

// Indigo
val Indigo050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Indigo050, SushiRawColorTokens.Indigo900)
val Indigo100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Indigo100, SushiRawColorTokens.Indigo800)
val Indigo200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Indigo200, SushiRawColorTokens.Indigo700)
val Indigo300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Indigo300, SushiRawColorTokens.Indigo600)
val Indigo400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Indigo400, SushiRawColorTokens.Indigo500)
val Indigo500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Indigo500, SushiRawColorTokens.Indigo400)
val Indigo600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Indigo600, SushiRawColorTokens.Indigo300)
val Indigo700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Indigo700, SushiRawColorTokens.Indigo200)
val Indigo800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Indigo800, SushiRawColorTokens.Indigo100)
val Indigo900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Indigo900, SushiRawColorTokens.Indigo050)

// Brown
val Brown050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Brown050, SushiRawColorTokens.Brown900)
val Brown100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Brown100, SushiRawColorTokens.Brown800)
val Brown200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Brown200, SushiRawColorTokens.Brown700)
val Brown300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Brown300, SushiRawColorTokens.Brown600)
val Brown400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Brown400, SushiRawColorTokens.Brown500)
val Brown500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Brown500, SushiRawColorTokens.Brown400)
val Brown600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Brown600, SushiRawColorTokens.Brown300)
val Brown700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Brown700, SushiRawColorTokens.Brown200)
val Brown800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Brown800, SushiRawColorTokens.Brown100)
val Brown900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Brown900, SushiRawColorTokens.Brown050)

// Cider
val Cider050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Cider050, Color(0xFF492E06))
val Cider100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Cider100, SushiRawColorTokens.Cider800)
val Cider200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Cider200, SushiRawColorTokens.Cider700)
val Cider300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Cider300, SushiRawColorTokens.Cider600)
val Cider400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Cider400, SushiRawColorTokens.Cider500)
val Cider500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Cider500, SushiRawColorTokens.Cider400)
val Cider600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Cider600, SushiRawColorTokens.Cider300)
val Cider700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Cider700, SushiRawColorTokens.Cider200)
val Cider800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Cider800, SushiRawColorTokens.Cider100)
val Cider900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Cider900, SushiRawColorTokens.Cider050)

// Teal
val Teal050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Teal050, SushiRawColorTokens.Teal900)
val Teal100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Teal100, SushiRawColorTokens.Teal800)
val Teal200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Teal200, SushiRawColorTokens.Teal700)
val Teal300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Teal300, SushiRawColorTokens.Teal600)
val Teal400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Teal400, SushiRawColorTokens.Teal500)
val Teal500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Teal500, SushiRawColorTokens.Teal400)
val Teal600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Teal600, SushiRawColorTokens.Teal300)
val Teal700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Teal700, SushiRawColorTokens.Teal200)
val Teal800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Teal800, SushiRawColorTokens.Teal100)
val Teal900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Teal900, SushiRawColorTokens.Teal050)

// Orange
val Orange050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Orange050, SushiRawColorTokens.Orange900)
val Orange100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Orange100, SushiRawColorTokens.Orange800)
val Orange200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Orange200, SushiRawColorTokens.Orange700)
val Orange300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Orange300, SushiRawColorTokens.Orange600)
val Orange400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Orange400, SushiRawColorTokens.Orange500)
val Orange500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Orange500, SushiRawColorTokens.Orange400)
val Orange600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Orange600, SushiRawColorTokens.Orange300)
val Orange700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Orange700, SushiRawColorTokens.Orange200)
val Orange800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Orange800, SushiRawColorTokens.Orange100)
val Orange900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Orange900, SushiRawColorTokens.Orange050)

// Pink
val Pink050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Pink050, SushiRawColorTokens.Pink900)
val Pink100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Pink100, SushiRawColorTokens.Pink800)
val Pink200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Pink200, SushiRawColorTokens.Pink700)
val Pink300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Pink300, SushiRawColorTokens.Pink600)
val Pink400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Pink400, SushiRawColorTokens.Pink500)
val Pink500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Pink500, SushiRawColorTokens.Pink400)
val Pink600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Pink600, SushiRawColorTokens.Pink300)
val Pink700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Pink700, SushiRawColorTokens.Pink200)
val Pink800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Pink800, SushiRawColorTokens.Pink100)
val Pink900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Pink900, SushiRawColorTokens.Pink050)

// Lime
val Lime050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Lime050, SushiRawColorTokens.Lime900)
val Lime100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Lime100, SushiRawColorTokens.Lime800)
val Lime200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Lime200, SushiRawColorTokens.Lime700)
val Lime300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Lime300, SushiRawColorTokens.Lime600)
val Lime400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Lime400, SushiRawColorTokens.Lime500)
val Lime500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Lime500, SushiRawColorTokens.Lime400)
val Lime600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Lime600, SushiRawColorTokens.Lime300)
val Lime700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Lime700, SushiRawColorTokens.Lime200)
val Lime800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Lime800, SushiRawColorTokens.Lime100)
val Lime900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Lime900, SushiRawColorTokens.Lime050)

// Corn
val Corn050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Corn050, SushiRawColorTokens.Corn050)
val Corn100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Corn100, SushiRawColorTokens.Corn100)
val Corn200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Corn200, SushiRawColorTokens.Corn200)
val Corn300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Corn300, SushiRawColorTokens.Corn300)
val Corn400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Corn400, SushiRawColorTokens.Corn400)
val Corn500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Corn500, SushiRawColorTokens.Corn500)
val Corn600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Corn600, SushiRawColorTokens.Corn600)
val Corn700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Corn700, SushiRawColorTokens.Corn700)
val Corn800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Corn800, SushiRawColorTokens.Corn800)
val Corn900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Corn900, SushiRawColorTokens.Corn900)

// Avacado
val Avacado050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Avacado050, SushiRawColorTokens.Avacado050)
val Avacado100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Avacado100, SushiRawColorTokens.Avacado100)
val Avacado200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Avacado200, SushiRawColorTokens.Avacado200)
val Avacado300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Avacado300, SushiRawColorTokens.Avacado300)
val Avacado400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Avacado400, SushiRawColorTokens.Avacado400)
val Avacado500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Avacado500, SushiRawColorTokens.Avacado500)
val Avacado600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Avacado600, SushiRawColorTokens.Avacado600)
val Avacado700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Avacado700, SushiRawColorTokens.Avacado700)
val Avacado800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Avacado800, SushiRawColorTokens.Avacado800)
val Avacado900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Avacado900, SushiRawColorTokens.Avacado900)

// Gold Colors
val Gold050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Gold050, SushiRawColorTokens.Gold050)
val Gold100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Gold100, SushiRawColorTokens.Gold100)
val Gold200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Gold200, SushiRawColorTokens.Gold200)
val Gold300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Gold300, SushiRawColorTokens.Gold300)
val Gold400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Gold400, SushiRawColorTokens.Gold400)
val Gold500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Gold500, SushiRawColorTokens.Gold500)
val Gold600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Gold600, SushiRawColorTokens.Gold600)
val Gold700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Gold700, SushiRawColorTokens.Gold700)
val Gold800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Gold800, SushiRawColorTokens.Gold800)
val Gold900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Gold900, SushiRawColorTokens.Gold900)

// Onion Colors
val Onion050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Onion050, SushiRawColorTokens.Onion900)
val Onion100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Onion100, SushiRawColorTokens.Onion800)
val Onion200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Onion200, SushiRawColorTokens.Onion700)
val Onion300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Onion300, SushiRawColorTokens.Onion600)
val Onion400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Onion400, SushiRawColorTokens.Onion500)
val Onion500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Onion500, SushiRawColorTokens.Onion400)
val Onion600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Onion600, SushiRawColorTokens.Onion300)
val Onion700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Onion700, SushiRawColorTokens.Onion200)
val Onion800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Onion800, SushiRawColorTokens.Onion100)
val Onion900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Onion900, SushiRawColorTokens.Onion050)

// Charcoal Colors
val Charcoal050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Charcoal050, SushiRawColorTokens.Charcoal900)
val Charcoal100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Charcoal100, SushiRawColorTokens.Charcoal800)
val Charcoal200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Charcoal200, SushiRawColorTokens.Charcoal700)
val Charcoal300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Charcoal300, SushiRawColorTokens.Charcoal600)
val Charcoal400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Charcoal400, SushiRawColorTokens.Charcoal500)
val Charcoal500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Charcoal500, SushiRawColorTokens.Charcoal400)
val Charcoal600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Charcoal600, SushiRawColorTokens.Charcoal300)
val Charcoal700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Charcoal700, SushiRawColorTokens.Charcoal200)
val Charcoal800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Charcoal800, SushiRawColorTokens.Charcoal100)
val Charcoal900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Charcoal900, SushiRawColorTokens.Charcoal050)

// Honey Colors
val Honey050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Honey050, SushiRawColorTokens.Honey900)
val Honey100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Honey100, SushiRawColorTokens.Honey800)
val Honey200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Honey200, SushiRawColorTokens.Honey700)
val Honey300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Honey300, SushiRawColorTokens.Honey600)
val Honey400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Honey400, SushiRawColorTokens.Honey500)
val Honey500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Honey500, SushiRawColorTokens.Honey400)
val Honey600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Honey600, SushiRawColorTokens.Honey300)
val Honey700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Honey700, SushiRawColorTokens.Honey200)
val Honey800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Honey800, SushiRawColorTokens.Honey100)
val Honey900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Honey900, SushiRawColorTokens.Honey050)

// Tangerine Colors
val Tangerine050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Tangerine050, SushiRawColorTokens.Tangerine900)
val Tangerine100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Tangerine100, SushiRawColorTokens.Tangerine800)
val Tangerine200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Tangerine200, SushiRawColorTokens.Tangerine700)
val Tangerine300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Tangerine300, SushiRawColorTokens.Tangerine600)
val Tangerine400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Tangerine400, SushiRawColorTokens.Tangerine500)
val Tangerine500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Tangerine500, SushiRawColorTokens.Tangerine400)
val Tangerine600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Tangerine600, SushiRawColorTokens.Tangerine300)
val Tangerine700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Tangerine700, SushiRawColorTokens.Tangerine200)
val Tangerine800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Tangerine800, SushiRawColorTokens.Tangerine100)
val Tangerine900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Tangerine900, SushiRawColorTokens.Tangerine050)

// Slate Colors
val Slate050: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Slate050, SushiRawColorTokens.Slate900)
val Slate100: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Slate100, SushiRawColorTokens.Slate800)
val Slate200: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Slate200, SushiRawColorTokens.Slate700)
val Slate300: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Slate300, SushiRawColorTokens.Slate600)
val Slate400: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Slate400, SushiRawColorTokens.Slate500)
val Slate500: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Slate500, SushiRawColorTokens.Slate400)
val Slate600: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Slate600, SushiRawColorTokens.Slate300)
val Slate700: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Slate700, SushiRawColorTokens.Slate200)
val Slate800: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Slate800, SushiRawColorTokens.Slate100)
val Slate900: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Slate900, SushiRawColorTokens.Slate050)

// Rating Colors
val Rating1: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Red600, SushiRawColorTokens.Red300)
val Rating2: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Yellow500, SushiRawColorTokens.Yellow200)
val Rating3: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Lime500, SushiRawColorTokens.Lime400)
val Rating4: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Lime700, SushiRawColorTokens.Lime200)
val Rating5: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Lime900, SushiRawColorTokens.Lime050)
val RatingUnchecked: ColorSpec = ColorSchemeTypeAdaptedColorSpec.fromColors(SushiRawColorTokens.Grey500, SushiRawColorTokens.Slate400)