package com.zomato.sushi.compose.foundation

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec

@ExperimentalSushiApi
@Immutable
data class SushiColorScheme(
    val schemeType: SushiColorSchemeType,
    val material: ColorScheme,

    val black: ColorSpec = SushiRawColorTokens.Black.asColorSpec(),
    val white: ColorSpec = SushiRawColorTokens.White.asColorSpec(),
    val transparent: ColorSpec = SushiRawColorTokens.Transparent.asColorSpec(),

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
        val v050: ColorSpec = SushiRawColorTokens.Grey050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Grey100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Grey200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Grey300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Grey400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Grey500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Grey600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Grey700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Grey800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Grey900.asColorSpec(),
    )

    // Red
    @Immutable
    data class RedColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Red050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Red100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Red200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Red300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Red400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Red500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Red600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Red700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Red800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Red900.asColorSpec(),
    )

    // Green
    @Immutable
    data class GreenColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Green050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Green100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Green200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Green300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Green400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Green500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Green600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Green700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Green800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Green900.asColorSpec(),
    )

    // Blue
    @Immutable
    data class BlueColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Blue050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Blue100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Blue200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Blue300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Blue400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Blue500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Blue600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Blue700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Blue800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Blue900.asColorSpec(),
    )

    // Yellow
    @Immutable
    data class YellowColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Yellow050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Yellow100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Yellow200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Yellow300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Yellow400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Yellow500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Yellow600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Yellow700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Yellow800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Yellow900.asColorSpec(),
    )

    // Purple
    @Immutable
    data class PurpleColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Purple050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Purple100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Purple200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Purple300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Purple400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Purple500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Purple600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Purple700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Purple800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Purple900.asColorSpec(),
    )

    // Indigo
    @Immutable
    data class IndigoColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Indigo050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Indigo100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Indigo200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Indigo300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Indigo400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Indigo500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Indigo600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Indigo700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Indigo800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Indigo900.asColorSpec(),
    )

    // Brown
    @Immutable
    data class BrownColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Brown050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Brown100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Brown200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Brown300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Brown400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Brown500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Brown600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Brown700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Brown800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Brown900.asColorSpec(),
    )

    // Cider
    @Immutable
    data class CiderColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Cider050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Cider100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Cider200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Cider300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Cider400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Cider500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Cider600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Cider700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Cider800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Cider900.asColorSpec(),
    )

    // Teal
    @Immutable
    data class TealColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Teal050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Teal100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Teal200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Teal300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Teal400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Teal500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Teal600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Teal700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Teal800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Teal900.asColorSpec(),
    )

    // Orange
    @Immutable
    data class OrangeColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Orange050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Orange100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Orange200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Orange300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Orange400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Orange500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Orange600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Orange700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Orange800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Orange900.asColorSpec(),
    )

    // Pink
    @Immutable
    data class PinkColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Pink050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Pink100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Pink200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Pink300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Pink400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Pink500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Pink600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Pink700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Pink800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Pink900.asColorSpec(),
    )

    // Lime
    @Immutable
    data class LimeColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Lime050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Lime100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Lime200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Lime300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Lime400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Lime500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Lime600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Lime700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Lime800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Lime900.asColorSpec(),
    )

    // Corn
    @Immutable
    data class CornColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Corn050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Corn100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Corn200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Corn300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Corn400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Corn500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Corn600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Corn700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Corn800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Corn900.asColorSpec(),
    )

    // Avacado
    @Immutable
    data class AvacadoColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Avacado050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Avacado100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Avacado200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Avacado300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Avacado400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Avacado500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Avacado600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Avacado700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Avacado800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Avacado900.asColorSpec(),
    )

    // Gold
    @Immutable
    data class GoldColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Gold050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Gold100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Gold200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Gold300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Gold400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Gold500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Gold600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Gold700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Gold800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Gold900.asColorSpec(),
    )

    // Onion
    @Immutable
    data class OnionColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Onion050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Onion100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Onion200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Onion300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Onion400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Onion500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Onion600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Onion700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Onion800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Onion900.asColorSpec(),
    )

    // Charcoal
    @Immutable
    data class CharcoalColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Charcoal050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Charcoal100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Charcoal200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Charcoal300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Charcoal400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Charcoal500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Charcoal600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Charcoal700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Charcoal800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Charcoal900.asColorSpec(),
    )

    // Honey
    @Immutable
    data class HoneyColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Honey050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Honey100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Honey200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Honey300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Honey400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Honey500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Honey600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Honey700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Honey800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Honey900.asColorSpec(),
    )

    // Tangerine
    @Immutable
    data class TangerineColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Tangerine050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Tangerine100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Tangerine200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Tangerine300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Tangerine400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Tangerine500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Tangerine600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Tangerine700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Tangerine800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Tangerine900.asColorSpec(),
    )

    // Slate
    @Immutable
    data class SlateColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Slate050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Slate100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Slate200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Slate300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Slate400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Slate500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Slate600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Slate700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Slate800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Slate900.asColorSpec(),
    )

    // Rating
    @Immutable
    data class RatingColorScheme(
        val one: ColorSpec = SushiRawColorTokens.Rating1.asColorSpec(),
        val two: ColorSpec = SushiRawColorTokens.Rating2.asColorSpec(),
        val three: ColorSpec = SushiRawColorTokens.Rating3.asColorSpec(),
        val four: ColorSpec = SushiRawColorTokens.Rating4.asColorSpec(),
        val five: ColorSpec = SushiRawColorTokens.Rating5.asColorSpec(),
        val unchecked: ColorSpec = SushiRawColorTokens.RatingUnchecked.asColorSpec(),
    )

    // Theme
    @Immutable
    data class ThemeColorScheme(
        val v050: ColorSpec = SushiRawColorTokens.Red050.asColorSpec(),
        val v100: ColorSpec = SushiRawColorTokens.Red100.asColorSpec(),
        val v200: ColorSpec = SushiRawColorTokens.Red200.asColorSpec(),
        val v300: ColorSpec = SushiRawColorTokens.Red300.asColorSpec(),
        val v400: ColorSpec = SushiRawColorTokens.Red400.asColorSpec(),
        val v500: ColorSpec = SushiRawColorTokens.Red500.asColorSpec(),
        val v600: ColorSpec = SushiRawColorTokens.Red600.asColorSpec(),
        val v700: ColorSpec = SushiRawColorTokens.Red700.asColorSpec(),
        val v800: ColorSpec = SushiRawColorTokens.Red800.asColorSpec(),
        val v900: ColorSpec = SushiRawColorTokens.Red900.asColorSpec(),

        val accentColor: ColorSpec = SushiRawColorTokens.Red600.asColorSpec(),
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