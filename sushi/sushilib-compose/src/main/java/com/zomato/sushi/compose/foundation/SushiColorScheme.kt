package com.zomato.sushi.compose.foundation

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.atoms.color.ColorSpec

/**
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiColorScheme(
    val schemeType: SushiColorSchemeType,
    val material: ColorScheme,

    val black: ColorSpec = Black,
    val white: ColorSpec = White,
    val transparent: ColorSpec = Transparent,

    val grey: GreyColorScheme = GreyColorScheme(),
    val red: RedColorScheme = RedColorScheme(),
    val green: GreenColorScheme = GreenColorScheme(),
    val blue: BlueColorScheme = BlueColorScheme(),
    val yellow: YellowColorScheme = YellowColorScheme(),
    val purple: PurpleColorScheme = PurpleColorScheme(),
    val indigo: IndigoColorScheme = IndigoColorScheme(),
    val brown: BrownColorScheme = BrownColorScheme(),
    val cider: CiderColorScheme = CiderColorScheme(),
    val teal: TealColorScheme = TealColorScheme(),
    val orange: OrangeColorScheme = OrangeColorScheme(),
    val pink: PinkColorScheme = PinkColorScheme(),
    val lime: LimeColorScheme = LimeColorScheme(),
    val corn: CornColorScheme = CornColorScheme(),
    val avacado: AvacadoColorScheme = AvacadoColorScheme(),
    val gold: GoldColorScheme = GoldColorScheme(),
    val onion: OnionColorScheme = OnionColorScheme(),
    val charcoal: CharcoalColorScheme = CharcoalColorScheme(),
    val honey: HoneyColorScheme = HoneyColorScheme(),
    val tangerine: TangerineColorScheme = TangerineColorScheme(),
    val slate: SlateColorScheme = SlateColorScheme(),
    val rating: RatingColorScheme = RatingColorScheme(),
    val theme: ThemeColorScheme = ThemeColorScheme(),
    val text: TextColorScheme,
    val icon: IconColorScheme,
    val surface: SurfaceColorScheme,
    val border: BorderColorScheme,
    val crystal: CrystalColorScheme,
    val dish: DishColorScheme,
    val res: ResColorScheme,
    val button: ButtonColorScheme,
    val stepper: StepperColorScheme,
    val shimmer: ShimmerColorScheme,
    val slider: SliderColorScheme,
    val filter: FilterColorScheme,
) {
    // Grey
    @Immutable
    data class GreyColorScheme(
        val v050: ColorSpec = Grey050,
        val v100: ColorSpec = Grey100,
        val v200: ColorSpec = Grey200,
        val v300: ColorSpec = Grey300,
        val v400: ColorSpec = Grey400,
        val v500: ColorSpec = Grey500,
        val v600: ColorSpec = Grey600,
        val v700: ColorSpec = Grey700,
        val v800: ColorSpec = Grey800,
        val v900: ColorSpec = Grey900,
    )

    // Red
    @Immutable
    data class RedColorScheme(
        val v050: ColorSpec = Red050,
        val v100: ColorSpec = Red100,
        val v200: ColorSpec = Red200,
        val v300: ColorSpec = Red300,
        val v400: ColorSpec = Red400,
        val v500: ColorSpec = Red500,
        val v600: ColorSpec = Red600,
        val v700: ColorSpec = Red700,
        val v800: ColorSpec = Red800,
        val v900: ColorSpec = Red900,
    )

    // Green
    @Immutable
    data class GreenColorScheme(
        val v050: ColorSpec = Green050,
        val v100: ColorSpec = Green100,
        val v200: ColorSpec = Green200,
        val v300: ColorSpec = Green300,
        val v400: ColorSpec = Green400,
        val v500: ColorSpec = Green500,
        val v600: ColorSpec = Green600,
        val v700: ColorSpec = Green700,
        val v800: ColorSpec = Green800,
        val v900: ColorSpec = Green900,
    )

    // Blue
    @Immutable
    data class BlueColorScheme(
        val v050: ColorSpec = Blue050,
        val v100: ColorSpec = Blue100,
        val v200: ColorSpec = Blue200,
        val v300: ColorSpec = Blue300,
        val v400: ColorSpec = Blue400,
        val v500: ColorSpec = Blue500,
        val v600: ColorSpec = Blue600,
        val v700: ColorSpec = Blue700,
        val v800: ColorSpec = Blue800,
        val v900: ColorSpec = Blue900,
    )

    // Yellow
    @Immutable
    data class YellowColorScheme(
        val v050: ColorSpec = Yellow050,
        val v100: ColorSpec = Yellow100,
        val v200: ColorSpec = Yellow200,
        val v300: ColorSpec = Yellow300,
        val v400: ColorSpec = Yellow400,
        val v500: ColorSpec = Yellow500,
        val v600: ColorSpec = Yellow600,
        val v700: ColorSpec = Yellow700,
        val v800: ColorSpec = Yellow800,
        val v900: ColorSpec = Yellow900,
    )

    // Purple
    @Immutable
    data class PurpleColorScheme(
        val v050: ColorSpec = Purple050,
        val v100: ColorSpec = Purple100,
        val v200: ColorSpec = Purple200,
        val v300: ColorSpec = Purple300,
        val v400: ColorSpec = Purple400,
        val v500: ColorSpec = Purple500,
        val v600: ColorSpec = Purple600,
        val v700: ColorSpec = Purple700,
        val v800: ColorSpec = Purple800,
        val v900: ColorSpec = Purple900,
    )

    // Indigo
    @Immutable
    data class IndigoColorScheme(
        val v050: ColorSpec = Indigo050,
        val v100: ColorSpec = Indigo100,
        val v200: ColorSpec = Indigo200,
        val v300: ColorSpec = Indigo300,
        val v400: ColorSpec = Indigo400,
        val v500: ColorSpec = Indigo500,
        val v600: ColorSpec = Indigo600,
        val v700: ColorSpec = Indigo700,
        val v800: ColorSpec = Indigo800,
        val v900: ColorSpec = Indigo900,
    )

    // Brown
    @Immutable
    data class BrownColorScheme(
        val v050: ColorSpec = Brown050,
        val v100: ColorSpec = Brown100,
        val v200: ColorSpec = Brown200,
        val v300: ColorSpec = Brown300,
        val v400: ColorSpec = Brown400,
        val v500: ColorSpec = Brown500,
        val v600: ColorSpec = Brown600,
        val v700: ColorSpec = Brown700,
        val v800: ColorSpec = Brown800,
        val v900: ColorSpec = Brown900,
    )

    // Cider
    @Immutable
    data class CiderColorScheme(
        val v050: ColorSpec = Cider050,
        val v100: ColorSpec = Cider100,
        val v200: ColorSpec = Cider200,
        val v300: ColorSpec = Cider300,
        val v400: ColorSpec = Cider400,
        val v500: ColorSpec = Cider500,
        val v600: ColorSpec = Cider600,
        val v700: ColorSpec = Cider700,
        val v800: ColorSpec = Cider800,
        val v900: ColorSpec = Cider900,
    )

    // Teal
    @Immutable
    data class TealColorScheme(
        val v050: ColorSpec = Teal050,
        val v100: ColorSpec = Teal100,
        val v200: ColorSpec = Teal200,
        val v300: ColorSpec = Teal300,
        val v400: ColorSpec = Teal400,
        val v500: ColorSpec = Teal500,
        val v600: ColorSpec = Teal600,
        val v700: ColorSpec = Teal700,
        val v800: ColorSpec = Teal800,
        val v900: ColorSpec = Teal900,
    )

    // Orange
    @Immutable
    data class OrangeColorScheme(
        val v050: ColorSpec = Orange050,
        val v100: ColorSpec = Orange100,
        val v200: ColorSpec = Orange200,
        val v300: ColorSpec = Orange300,
        val v400: ColorSpec = Orange400,
        val v500: ColorSpec = Orange500,
        val v600: ColorSpec = Orange600,
        val v700: ColorSpec = Orange700,
        val v800: ColorSpec = Orange800,
        val v900: ColorSpec = Orange900,
    )

    // Pink
    @Immutable
    data class PinkColorScheme(
        val v050: ColorSpec = Pink050,
        val v100: ColorSpec = Pink100,
        val v200: ColorSpec = Pink200,
        val v300: ColorSpec = Pink300,
        val v400: ColorSpec = Pink400,
        val v500: ColorSpec = Pink500,
        val v600: ColorSpec = Pink600,
        val v700: ColorSpec = Pink700,
        val v800: ColorSpec = Pink800,
        val v900: ColorSpec = Pink900,
    )

    // Lime
    @Immutable
    data class LimeColorScheme(
        val v050: ColorSpec = Lime050,
        val v100: ColorSpec = Lime100,
        val v200: ColorSpec = Lime200,
        val v300: ColorSpec = Lime300,
        val v400: ColorSpec = Lime400,
        val v500: ColorSpec = Lime500,
        val v600: ColorSpec = Lime600,
        val v700: ColorSpec = Lime700,
        val v800: ColorSpec = Lime800,
        val v900: ColorSpec = Lime900,
    )

    // Corn
    @Immutable
    data class CornColorScheme(
        val v050: ColorSpec = Corn050,
        val v100: ColorSpec = Corn100,
        val v200: ColorSpec = Corn200,
        val v300: ColorSpec = Corn300,
        val v400: ColorSpec = Corn400,
        val v500: ColorSpec = Corn500,
        val v600: ColorSpec = Corn600,
        val v700: ColorSpec = Corn700,
        val v800: ColorSpec = Corn800,
        val v900: ColorSpec = Corn900,
    )

    // Avacado
    @Immutable
    data class AvacadoColorScheme(
        val v050: ColorSpec = Avacado050,
        val v100: ColorSpec = Avacado100,
        val v200: ColorSpec = Avacado200,
        val v300: ColorSpec = Avacado300,
        val v400: ColorSpec = Avacado400,
        val v500: ColorSpec = Avacado500,
        val v600: ColorSpec = Avacado600,
        val v700: ColorSpec = Avacado700,
        val v800: ColorSpec = Avacado800,
        val v900: ColorSpec = Avacado900,
    )

    // Gold
    @Immutable
    data class GoldColorScheme(
        val v050: ColorSpec = Gold050,
        val v100: ColorSpec = Gold100,
        val v200: ColorSpec = Gold200,
        val v300: ColorSpec = Gold300,
        val v400: ColorSpec = Gold400,
        val v500: ColorSpec = Gold500,
        val v600: ColorSpec = Gold600,
        val v700: ColorSpec = Gold700,
        val v800: ColorSpec = Gold800,
        val v900: ColorSpec = Gold900,
    )

    // Onion
    @Immutable
    data class OnionColorScheme(
        val v050: ColorSpec = Onion050,
        val v100: ColorSpec = Onion100,
        val v200: ColorSpec = Onion200,
        val v300: ColorSpec = Onion300,
        val v400: ColorSpec = Onion400,
        val v500: ColorSpec = Onion500,
        val v600: ColorSpec = Onion600,
        val v700: ColorSpec = Onion700,
        val v800: ColorSpec = Onion800,
        val v900: ColorSpec = Onion900,
    )

    // Charcoal
    @Immutable
    data class CharcoalColorScheme(
        val v050: ColorSpec = Charcoal050,
        val v100: ColorSpec = Charcoal100,
        val v200: ColorSpec = Charcoal200,
        val v300: ColorSpec = Charcoal300,
        val v400: ColorSpec = Charcoal400,
        val v500: ColorSpec = Charcoal500,
        val v600: ColorSpec = Charcoal600,
        val v700: ColorSpec = Charcoal700,
        val v800: ColorSpec = Charcoal800,
        val v900: ColorSpec = Charcoal900,
    )

    // Honey
    @Immutable
    data class HoneyColorScheme(
        val v050: ColorSpec = Honey050,
        val v100: ColorSpec = Honey100,
        val v200: ColorSpec = Honey200,
        val v300: ColorSpec = Honey300,
        val v400: ColorSpec = Honey400,
        val v500: ColorSpec = Honey500,
        val v600: ColorSpec = Honey600,
        val v700: ColorSpec = Honey700,
        val v800: ColorSpec = Honey800,
        val v900: ColorSpec = Honey900,
    )

    // Tangerine
    @Immutable
    data class TangerineColorScheme(
        val v050: ColorSpec = Tangerine050,
        val v100: ColorSpec = Tangerine100,
        val v200: ColorSpec = Tangerine200,
        val v300: ColorSpec = Tangerine300,
        val v400: ColorSpec = Tangerine400,
        val v500: ColorSpec = Tangerine500,
        val v600: ColorSpec = Tangerine600,
        val v700: ColorSpec = Tangerine700,
        val v800: ColorSpec = Tangerine800,
        val v900: ColorSpec = Tangerine900,
    )

    // Slate
    @Immutable
    data class SlateColorScheme(
        val v050: ColorSpec = Slate050,
        val v100: ColorSpec = Slate100,
        val v200: ColorSpec = Slate200,
        val v300: ColorSpec = Slate300,
        val v400: ColorSpec = Slate400,
        val v500: ColorSpec = Slate500,
        val v600: ColorSpec = Slate600,
        val v700: ColorSpec = Slate700,
        val v800: ColorSpec = Slate800,
        val v900: ColorSpec = Slate900,
    )

    // Rating
    @Immutable
    data class RatingColorScheme(
        val one: ColorSpec = Rating1,
        val two: ColorSpec = Rating2,
        val three: ColorSpec = Rating3,
        val four: ColorSpec = Rating4,
        val five: ColorSpec = Rating5,
        val unchecked: ColorSpec = RatingUnchecked,
    )

    // Theme
    @Immutable
    data class ThemeColorScheme(
        val v050: ColorSpec = Red050,
        val v100: ColorSpec = Red100,
        val v200: ColorSpec = Red200,
        val v300: ColorSpec = Red300,
        val v400: ColorSpec = Red400,
        val v500: ColorSpec = Red500,
        val v600: ColorSpec = Red600,
        val v700: ColorSpec = Red700,
        val v800: ColorSpec = Red800,
        val v900: ColorSpec = Red900,

        val accentColor: ColorSpec = Red600,
    )

    // Text color tokens
    @Immutable
    data class TextColorScheme(
        val default: ColorSpec,
        val primary: ColorSpec,
        val secondary: ColorSpec,
        val tertiary: ColorSpec,
        val quaternary: ColorSpec,
        val disabled: ColorSpec,
        val inverse: ColorSpec,
        val brand: ColorSpec,
        val brandOnlyLight: ColorSpec,
        val offer: ColorSpec,
        val success: ColorSpec,
        val warning: ColorSpec,
        val error: ColorSpec,
        val accentRed: ColorSpec,
        val accentRedIntense: ColorSpec,
        val accentOrange: ColorSpec,
        val accentOrangeIntense: ColorSpec,
        val accentGreen: ColorSpec,
        val accentGreenIntense: ColorSpec,
        val accentBlue: ColorSpec,
        val accentBlueIntense: ColorSpec,
        val accentPurple: ColorSpec,
        val accentPurpleIntense: ColorSpec,
        val accentYellow: ColorSpec,
        val accentYellowIntense: ColorSpec,
        val accentTeal: ColorSpec,
        val accentTealIntense: ColorSpec,
        val accentCider: ColorSpec,
        val accentCiderIntense: ColorSpec,
        val accentBrown: ColorSpec,
        val accentBrownIntense: ColorSpec,
        val light: ColorSpec,
        val accentPink: ColorSpec,
        val discover: ColorSpec,
    )

    // Icon color tokens
    @Immutable
    data class IconColorScheme(
        val default: ColorSpec,
        val primary: ColorSpec,
        val secondary: ColorSpec,
        val tertiary: ColorSpec,
        val quaternary: ColorSpec,
        val offer: ColorSpec,
        val warning: ColorSpec,
        val error: ColorSpec,
        val success: ColorSpec,
        val inverse: ColorSpec,
        val brand: ColorSpec,
        val disabled: ColorSpec,
        val brandOnlyLight: ColorSpec,
        val accentOrange: ColorSpec,
        val accentRed: ColorSpec,
        val accentGreen: ColorSpec,
        val accentBlue: ColorSpec,
        val accentPurple: ColorSpec,
        val accentYellow: ColorSpec,
        val light: ColorSpec,
        val enable: ColorSpec,
        val accentPink: ColorSpec,
        val accentTeal: ColorSpec,
        val discover: ColorSpec,
    )

    // Surface color tokens
    @Immutable
    data class SurfaceColorScheme(
        val backgroundPrimary: ColorSpec,
        val backgroundSecondary: ColorSpec,
        val primary: ColorSpec,
        val secondary: ColorSpec,
        val elevated: ColorSpec,
        val inverse: ColorSpec,
        val inset: ColorSpec,
        val insetIntense: ColorSpec,
        val accentBlue: ColorSpec,
        val accentBlueIntense: ColorSpec,
        val accentCider: ColorSpec,
        val accentCiderIntense: ColorSpec,
        val disabled: ColorSpec,
        val accentGreen: ColorSpec,
        val accentGreenIntense: ColorSpec,
        val accentYellow: ColorSpec,
        val accentYellowIntense: ColorSpec,
        val accentRed: ColorSpec,
        val accentRedIntense: ColorSpec,
        val accentOrange: ColorSpec,
        val accentOrangeIntense: ColorSpec,
        val accentPurple: ColorSpec,
        val accentPurpleIntense: ColorSpec,
        val accentBrown: ColorSpec,
        val accentBrownIntense: ColorSpec,
        val accentPink: ColorSpec,
        val accentPinkIntense: ColorSpec,
        val brandOnlylight: ColorSpec,
        val brand: ColorSpec,
        val selection: ColorSpec,
        val success: ColorSpec,
        val warning: ColorSpec,
        val error: ColorSpec,
        val offer: ColorSpec,
        val shimmer: ColorSpec,
        val backgroundDark: ColorSpec,
        val default: ColorSpec,
        val deepened: ColorSpec,
        val errorDark: ColorSpec,
        val brandOnlyLight: ColorSpec,
        val successDark: ColorSpec,
        val accentGrey: ColorSpec,
        val accentTangerine: ColorSpec,
        val discover: ColorSpec,
    )

    // Border color tokens
    @Immutable
    data class BorderColorScheme(
        val subtle: ColorSpec,
        val moderate: ColorSpec,
        val intense: ColorSpec,
        val inverse: ColorSpec,
        val selection: ColorSpec,
        val brand: ColorSpec,
        val success: ColorSpec,
        val warning: ColorSpec,
        val error: ColorSpec,
        val accentRed: ColorSpec,
        val accentRedIntense: ColorSpec,
        val accentYellow: ColorSpec,
        val accentYellowIntense: ColorSpec,
        val accentCider: ColorSpec,
        val accentCiderIntense: ColorSpec,
        val accentPurple: ColorSpec,
        val accentPurpleIntense: ColorSpec,
        val accentGreen: ColorSpec,
        val accentGreenIntense: ColorSpec,
        val accentOrange: ColorSpec,
        val accentOrangeIntense: ColorSpec,
        val accentBlue: ColorSpec,
        val accentBlueIntense: ColorSpec,
        val dark: ColorSpec,
    )

    // Crystal color tokens
    @Immutable
    data class CrystalColorScheme(
        val ontime: ColorSpec,
        val delay: ColorSpec,
        val rain: ColorSpec,
        val polylineAerialCurved: ColorSpec,
    )

    // Dish rating color tokens
    @Immutable
    data class DishColorScheme(
        val background: ColorSpec,
        val border: ColorSpec,
        val icon: ColorSpec,
    )

    // Res Rating color tokens
    @Immutable
    data class ResColorScheme(
        val background50: ColorSpec,
        val background45: ColorSpec,
        val background40: ColorSpec,
        val background35: ColorSpec,
        val background30: ColorSpec,
        val background25: ColorSpec,
        val background20: ColorSpec,
        val background15: ColorSpec,
        val background00: ColorSpec,
        val backgroundNew: ColorSpec,
        val borderNew: ColorSpec,
        val label: ColorSpec,
        val labelNew: ColorSpec,
    )

    // Button color tokens
    @Immutable
    data class ButtonColorScheme(
        val primaryBackground: ColorSpec,
        val primaryBackgroundPressed: ColorSpec,
        val backgroundDisabled: ColorSpec,
        val primaryLabel: ColorSpec,
        val primaryLabelPressed: ColorSpec,
        val primaryLabelDisabled: ColorSpec,
        val primaryIcon: ColorSpec,
        val primaryIconPressed: ColorSpec,
        val primaryIconDisabled: ColorSpec,

        val secondaryBackground: ColorSpec,
        val secondaryBackgroundPressed: ColorSpec,
        val secondaryLabel: ColorSpec,
        val secondaryLabelPressed: ColorSpec,
        val secondaryLabelDisabled: ColorSpec,
        val secondaryIcon: ColorSpec,
        val secondaryIconPressed: ColorSpec,
        val secondaryIconDisabled: ColorSpec,
        val secondaryBorder: ColorSpec,
        val secondaryBorderPressed: ColorSpec,
        val secondaryBorderDisabled: ColorSpec,

        val ghostBackground: ColorSpec,
        val ghostBackgroundPressed: ColorSpec,
        val ghostLabel: ColorSpec,
        val ghostLabelPressed: ColorSpec,
        val ghostLabelDisabled: ColorSpec,
        val ghostIcon: ColorSpec,
        val ghostIconPressed: ColorSpec,
        val ghostIconDisabled: ColorSpec,
        val tertiaryBackground: ColorSpec,
        val tertiaryBackgroundPressed: ColorSpec,
        val tertiaryLabel: ColorSpec,
        val tertiaryLabelPressed: ColorSpec,
        val tertiaryLabelDisabled: ColorSpec,
        val tertiaryIcon: ColorSpec,
        val tertiaryIconPressed: ColorSpec,
        val tertiaryIconDisabled: ColorSpec,
        val tertiaryStroke: ColorSpec,
        val tertiaryStrokePressed: ColorSpec,
        val tertiaryStrokeDisabled: ColorSpec,
    )

    // Stepper color tokens
    @Immutable
    data class StepperColorScheme(
        val primaryBackground: ColorSpec,
        val primaryBackgroundDisabled: ColorSpec,
        val primaryIcon: ColorSpec,
        val primaryIconDisabled: ColorSpec,
        val primaryLabel: ColorSpec,
        val primaryLabelDisabled: ColorSpec,
        val primaryLabelCustomisable: ColorSpec,

        val secondaryBackground: ColorSpec,
        val secondaryBackgroundDisabled: ColorSpec,
        val secondaryIcon: ColorSpec,
        val secondaryIconDisabled: ColorSpec,
        val secondaryLabelNumber: ColorSpec,
        val secondaryLabel: ColorSpec,
        val secondaryLabelDisabled: ColorSpec,
        val secondaryLabelCustomisable: ColorSpec,
        val secondaryBorder: ColorSpec,
        val secondaryBorderDisabled: ColorSpec,
    )

    // Shimmer color tokens
    @Immutable
    data class ShimmerColorScheme(
        val start: ColorSpec,
        val end: ColorSpec
    )

    // Slider color tokens
    @Immutable
    data class SliderColorScheme(
        val background: ColorSpec,
        val backgroundPressed: ColorSpec,
        val backgroundDisabled: ColorSpec,
        val label: ColorSpec,
        val labelPressed: ColorSpec,
        val labelDisabled: ColorSpec,
        val labelComplete: ColorSpec,
        val icon: ColorSpec,
        val iconPressed: ColorSpec,
        val iconDisabled: ColorSpec,
    )

    // Filter color tokens
    @Immutable
    data class FilterColorScheme(
        val backgroundSuccess: ColorSpec,
        val stroke: ColorSpec,
        val strokeSuccess: ColorSpec,
        val strokeDisabled: ColorSpec,
        val label: ColorSpec,
        val labelDisabled: ColorSpec,
        val icon: ColorSpec,
        val iconDisabled: ColorSpec,
    )
}