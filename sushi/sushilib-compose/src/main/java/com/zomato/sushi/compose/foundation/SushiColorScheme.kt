package com.zomato.sushi.compose.foundation

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec

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
    val base: BaseColorScheme = BaseColorScheme(),
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
    val aerobar: AerobarColorScheme,
    val tag: TagColorScheme,
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

    // Base
    @Immutable
    data class BaseColorScheme(
        val grey: GreyColorScheme = GreyColorScheme(
            v050 = SushiRawColorTokens.Grey050.asColorSpec(),
            v100 = SushiRawColorTokens.Grey100.asColorSpec(),
            v200 = SushiRawColorTokens.Grey200.asColorSpec(),
            v300 = SushiRawColorTokens.Grey300.asColorSpec(),
            v400 = SushiRawColorTokens.Grey400.asColorSpec(),
            v500 = SushiRawColorTokens.Grey500.asColorSpec(),
            v600 = SushiRawColorTokens.Grey600.asColorSpec(),
            v700 = SushiRawColorTokens.Grey700.asColorSpec(),
            v800 = SushiRawColorTokens.Grey800.asColorSpec(),
            v900 = SushiRawColorTokens.Grey900.asColorSpec(),
        ),
        val red: RedColorScheme = RedColorScheme(
            v050 = SushiRawColorTokens.Red050.asColorSpec(),
            v100 = SushiRawColorTokens.Red100.asColorSpec(),
            v200 = SushiRawColorTokens.Red200.asColorSpec(),
            v300 = SushiRawColorTokens.Red300.asColorSpec(),
            v400 = SushiRawColorTokens.Red400.asColorSpec(),
            v500 = SushiRawColorTokens.Red500.asColorSpec(),
            v600 = SushiRawColorTokens.Red600.asColorSpec(),
            v700 = SushiRawColorTokens.Red700.asColorSpec(),
            v800 = SushiRawColorTokens.Red800.asColorSpec(),
            v900 = SushiRawColorTokens.Red900.asColorSpec(),
        ),
        val green: GreenColorScheme = GreenColorScheme(
            v050 = SushiRawColorTokens.Green050.asColorSpec(),
            v100 = SushiRawColorTokens.Green100.asColorSpec(),
            v200 = SushiRawColorTokens.Green200.asColorSpec(),
            v300 = SushiRawColorTokens.Green300.asColorSpec(),
            v400 = SushiRawColorTokens.Green400.asColorSpec(),
            v500 = SushiRawColorTokens.Green500.asColorSpec(),
            v600 = SushiRawColorTokens.Green600.asColorSpec(),
            v700 = SushiRawColorTokens.Green700.asColorSpec(),
            v800 = SushiRawColorTokens.Green800.asColorSpec(),
            v900 = SushiRawColorTokens.Green900.asColorSpec(),
        ),
        val blue: BlueColorScheme = BlueColorScheme(
            v050 = SushiRawColorTokens.Blue050.asColorSpec(),
            v100 = SushiRawColorTokens.Blue100.asColorSpec(),
            v200 = SushiRawColorTokens.Blue200.asColorSpec(),
            v300 = SushiRawColorTokens.Blue300.asColorSpec(),
            v400 = SushiRawColorTokens.Blue400.asColorSpec(),
            v500 = SushiRawColorTokens.Blue500.asColorSpec(),
            v600 = SushiRawColorTokens.Blue600.asColorSpec(),
            v700 = SushiRawColorTokens.Blue700.asColorSpec(),
            v800 = SushiRawColorTokens.Blue800.asColorSpec(),
            v900 = SushiRawColorTokens.Blue900.asColorSpec(),
        ),
        val yellow: YellowColorScheme = YellowColorScheme(
            v050 = SushiRawColorTokens.Yellow050.asColorSpec(),
            v100 = SushiRawColorTokens.Yellow100.asColorSpec(),
            v200 = SushiRawColorTokens.Yellow200.asColorSpec(),
            v300 = SushiRawColorTokens.Yellow300.asColorSpec(),
            v400 = SushiRawColorTokens.Yellow400.asColorSpec(),
            v500 = SushiRawColorTokens.Yellow500.asColorSpec(),
            v600 = SushiRawColorTokens.Yellow600.asColorSpec(),
            v700 = SushiRawColorTokens.Yellow700.asColorSpec(),
            v800 = SushiRawColorTokens.Yellow800.asColorSpec(),
            v900 = SushiRawColorTokens.Yellow900.asColorSpec(),
        ),
        val purple: PurpleColorScheme = PurpleColorScheme(
            v050 = SushiRawColorTokens.Purple050.asColorSpec(),
            v100 = SushiRawColorTokens.Purple100.asColorSpec(),
            v200 = SushiRawColorTokens.Purple200.asColorSpec(),
            v300 = SushiRawColorTokens.Purple300.asColorSpec(),
            v400 = SushiRawColorTokens.Purple400.asColorSpec(),
            v500 = SushiRawColorTokens.Purple500.asColorSpec(),
            v600 = SushiRawColorTokens.Purple600.asColorSpec(),
            v700 = SushiRawColorTokens.Purple700.asColorSpec(),
            v800 = SushiRawColorTokens.Purple800.asColorSpec(),
            v900 = SushiRawColorTokens.Purple900.asColorSpec(),
        ),
        val indigo: IndigoColorScheme = IndigoColorScheme(
            v050 = SushiRawColorTokens.Indigo050.asColorSpec(),
            v100 = SushiRawColorTokens.Indigo100.asColorSpec(),
            v200 = SushiRawColorTokens.Indigo200.asColorSpec(),
            v300 = SushiRawColorTokens.Indigo300.asColorSpec(),
            v400 = SushiRawColorTokens.Indigo400.asColorSpec(),
            v500 = SushiRawColorTokens.Indigo500.asColorSpec(),
            v600 = SushiRawColorTokens.Indigo600.asColorSpec(),
            v700 = SushiRawColorTokens.Indigo700.asColorSpec(),
            v800 = SushiRawColorTokens.Indigo800.asColorSpec(),
            v900 = SushiRawColorTokens.Indigo900.asColorSpec(),
        ),
        val brown: BrownColorScheme = BrownColorScheme(
            v050 = SushiRawColorTokens.Brown050.asColorSpec(),
            v100 = SushiRawColorTokens.Brown100.asColorSpec(),
            v200 = SushiRawColorTokens.Brown200.asColorSpec(),
            v300 = SushiRawColorTokens.Brown300.asColorSpec(),
            v400 = SushiRawColorTokens.Brown400.asColorSpec(),
            v500 = SushiRawColorTokens.Brown500.asColorSpec(),
            v600 = SushiRawColorTokens.Brown600.asColorSpec(),
            v700 = SushiRawColorTokens.Brown700.asColorSpec(),
            v800 = SushiRawColorTokens.Brown800.asColorSpec(),
            v900 = SushiRawColorTokens.Brown900.asColorSpec(),
        ),
        val cider: CiderColorScheme = CiderColorScheme(
            v050 = SushiRawColorTokens.Cider050.asColorSpec(),
            v100 = SushiRawColorTokens.Cider100.asColorSpec(),
            v200 = SushiRawColorTokens.Cider200.asColorSpec(),
            v300 = SushiRawColorTokens.Cider300.asColorSpec(),
            v400 = SushiRawColorTokens.Cider400.asColorSpec(),
            v500 = SushiRawColorTokens.Cider500.asColorSpec(),
            v600 = SushiRawColorTokens.Cider600.asColorSpec(),
            v700 = SushiRawColorTokens.Cider700.asColorSpec(),
            v800 = SushiRawColorTokens.Cider800.asColorSpec(),
            v900 = SushiRawColorTokens.Cider900.asColorSpec(),
        ),
        val teal: TealColorScheme = TealColorScheme(
            v050 = SushiRawColorTokens.Teal050.asColorSpec(),
            v100 = SushiRawColorTokens.Teal100.asColorSpec(),
            v200 = SushiRawColorTokens.Teal200.asColorSpec(),
            v300 = SushiRawColorTokens.Teal300.asColorSpec(),
            v400 = SushiRawColorTokens.Teal400.asColorSpec(),
            v500 = SushiRawColorTokens.Teal500.asColorSpec(),
            v600 = SushiRawColorTokens.Teal600.asColorSpec(),
            v700 = SushiRawColorTokens.Teal700.asColorSpec(),
            v800 = SushiRawColorTokens.Teal800.asColorSpec(),
            v900 = SushiRawColorTokens.Teal900.asColorSpec(),
        ),
        val orange: OrangeColorScheme = OrangeColorScheme(
            v050 = SushiRawColorTokens.Orange050.asColorSpec(),
            v100 = SushiRawColorTokens.Orange100.asColorSpec(),
            v200 = SushiRawColorTokens.Orange200.asColorSpec(),
            v300 = SushiRawColorTokens.Orange300.asColorSpec(),
            v400 = SushiRawColorTokens.Orange400.asColorSpec(),
            v500 = SushiRawColorTokens.Orange500.asColorSpec(),
            v600 = SushiRawColorTokens.Orange600.asColorSpec(),
            v700 = SushiRawColorTokens.Orange700.asColorSpec(),
            v800 = SushiRawColorTokens.Orange800.asColorSpec(),
            v900 = SushiRawColorTokens.Orange900.asColorSpec(),
        ),
        val pink: PinkColorScheme = PinkColorScheme(
            v050 = SushiRawColorTokens.Pink050.asColorSpec(),
            v100 = SushiRawColorTokens.Pink100.asColorSpec(),
            v200 = SushiRawColorTokens.Pink200.asColorSpec(),
            v300 = SushiRawColorTokens.Pink300.asColorSpec(),
            v400 = SushiRawColorTokens.Pink400.asColorSpec(),
            v500 = SushiRawColorTokens.Pink500.asColorSpec(),
            v600 = SushiRawColorTokens.Pink600.asColorSpec(),
            v700 = SushiRawColorTokens.Pink700.asColorSpec(),
            v800 = SushiRawColorTokens.Pink800.asColorSpec(),
            v900 = SushiRawColorTokens.Pink900.asColorSpec(),
        ),
        val lime: LimeColorScheme = LimeColorScheme(
            v050 = SushiRawColorTokens.Lime050.asColorSpec(),
            v100 = SushiRawColorTokens.Lime100.asColorSpec(),
            v200 = SushiRawColorTokens.Lime200.asColorSpec(),
            v300 = SushiRawColorTokens.Lime300.asColorSpec(),
            v400 = SushiRawColorTokens.Lime400.asColorSpec(),
            v500 = SushiRawColorTokens.Lime500.asColorSpec(),
            v600 = SushiRawColorTokens.Lime600.asColorSpec(),
            v700 = SushiRawColorTokens.Lime700.asColorSpec(),
            v800 = SushiRawColorTokens.Lime800.asColorSpec(),
            v900 = SushiRawColorTokens.Lime900.asColorSpec(),
        ),
        val corn: CornColorScheme = CornColorScheme(
            v050 = SushiRawColorTokens.Corn050.asColorSpec(),
            v100 = SushiRawColorTokens.Corn100.asColorSpec(),
            v200 = SushiRawColorTokens.Corn200.asColorSpec(),
            v300 = SushiRawColorTokens.Corn300.asColorSpec(),
            v400 = SushiRawColorTokens.Corn400.asColorSpec(),
            v500 = SushiRawColorTokens.Corn500.asColorSpec(),
            v600 = SushiRawColorTokens.Corn600.asColorSpec(),
            v700 = SushiRawColorTokens.Corn700.asColorSpec(),
            v800 = SushiRawColorTokens.Corn800.asColorSpec(),
            v900 = SushiRawColorTokens.Corn900.asColorSpec(),
        ),
        val avacado: AvacadoColorScheme = AvacadoColorScheme(
            v050 = SushiRawColorTokens.Avacado050.asColorSpec(),
            v100 = SushiRawColorTokens.Avacado100.asColorSpec(),
            v200 = SushiRawColorTokens.Avacado200.asColorSpec(),
            v300 = SushiRawColorTokens.Avacado300.asColorSpec(),
            v400 = SushiRawColorTokens.Avacado400.asColorSpec(),
            v500 = SushiRawColorTokens.Avacado500.asColorSpec(),
            v600 = SushiRawColorTokens.Avacado600.asColorSpec(),
            v700 = SushiRawColorTokens.Avacado700.asColorSpec(),
            v800 = SushiRawColorTokens.Avacado800.asColorSpec(),
            v900 = SushiRawColorTokens.Avacado900.asColorSpec(),
        ),
        val gold: GoldColorScheme = GoldColorScheme(
            v050 = SushiRawColorTokens.Gold050.asColorSpec(),
            v100 = SushiRawColorTokens.Gold100.asColorSpec(),
            v200 = SushiRawColorTokens.Gold200.asColorSpec(),
            v300 = SushiRawColorTokens.Gold300.asColorSpec(),
            v400 = SushiRawColorTokens.Gold400.asColorSpec(),
            v500 = SushiRawColorTokens.Gold500.asColorSpec(),
            v600 = SushiRawColorTokens.Gold600.asColorSpec(),
            v700 = SushiRawColorTokens.Gold700.asColorSpec(),
            v800 = SushiRawColorTokens.Gold800.asColorSpec(),
            v900 = SushiRawColorTokens.Gold900.asColorSpec(),
        ),
        val onion: OnionColorScheme = OnionColorScheme(
            v050 = SushiRawColorTokens.Onion050.asColorSpec(),
            v100 = SushiRawColorTokens.Onion100.asColorSpec(),
            v200 = SushiRawColorTokens.Onion200.asColorSpec(),
            v300 = SushiRawColorTokens.Onion300.asColorSpec(),
            v400 = SushiRawColorTokens.Onion400.asColorSpec(),
            v500 = SushiRawColorTokens.Onion500.asColorSpec(),
            v600 = SushiRawColorTokens.Onion600.asColorSpec(),
            v700 = SushiRawColorTokens.Onion700.asColorSpec(),
            v800 = SushiRawColorTokens.Onion800.asColorSpec(),
            v900 = SushiRawColorTokens.Onion900.asColorSpec(),
        ),
        val charcoal: CharcoalColorScheme = CharcoalColorScheme(
            v050 = SushiRawColorTokens.Charcoal050.asColorSpec(),
            v100 = SushiRawColorTokens.Charcoal100.asColorSpec(),
            v200 = SushiRawColorTokens.Charcoal200.asColorSpec(),
            v300 = SushiRawColorTokens.Charcoal300.asColorSpec(),
            v400 = SushiRawColorTokens.Charcoal400.asColorSpec(),
            v500 = SushiRawColorTokens.Charcoal500.asColorSpec(),
            v600 = SushiRawColorTokens.Charcoal600.asColorSpec(),
            v700 = SushiRawColorTokens.Charcoal700.asColorSpec(),
            v800 = SushiRawColorTokens.Charcoal800.asColorSpec(),
            v900 = SushiRawColorTokens.Charcoal900.asColorSpec(),
        ),
        val honey: HoneyColorScheme = HoneyColorScheme(
            v050 = SushiRawColorTokens.Honey050.asColorSpec(),
            v100 = SushiRawColorTokens.Honey100.asColorSpec(),
            v200 = SushiRawColorTokens.Honey200.asColorSpec(),
            v300 = SushiRawColorTokens.Honey300.asColorSpec(),
            v400 = SushiRawColorTokens.Honey400.asColorSpec(),
            v500 = SushiRawColorTokens.Honey500.asColorSpec(),
            v600 = SushiRawColorTokens.Honey600.asColorSpec(),
            v700 = SushiRawColorTokens.Honey700.asColorSpec(),
            v800 = SushiRawColorTokens.Honey800.asColorSpec(),
            v900 = SushiRawColorTokens.Honey900.asColorSpec(),
        ),
        val tangerine: TangerineColorScheme = TangerineColorScheme(
            v050 = SushiRawColorTokens.Tangerine050.asColorSpec(),
            v100 = SushiRawColorTokens.Tangerine100.asColorSpec(),
            v200 = SushiRawColorTokens.Tangerine200.asColorSpec(),
            v300 = SushiRawColorTokens.Tangerine300.asColorSpec(),
            v400 = SushiRawColorTokens.Tangerine400.asColorSpec(),
            v500 = SushiRawColorTokens.Tangerine500.asColorSpec(),
            v600 = SushiRawColorTokens.Tangerine600.asColorSpec(),
            v700 = SushiRawColorTokens.Tangerine700.asColorSpec(),
            v800 = SushiRawColorTokens.Tangerine800.asColorSpec(),
            v900 = SushiRawColorTokens.Tangerine900.asColorSpec(),
        ),
        val slate: SlateColorScheme = SlateColorScheme(
            v050 = SushiRawColorTokens.Slate050.asColorSpec(),
            v100 = SushiRawColorTokens.Slate100.asColorSpec(),
            v200 = SushiRawColorTokens.Slate200.asColorSpec(),
            v300 = SushiRawColorTokens.Slate300.asColorSpec(),
            v400 = SushiRawColorTokens.Slate400.asColorSpec(),
            v500 = SushiRawColorTokens.Slate500.asColorSpec(),
            v600 = SushiRawColorTokens.Slate600.asColorSpec(),
            v700 = SushiRawColorTokens.Slate700.asColorSpec(),
            v800 = SushiRawColorTokens.Slate800.asColorSpec(),
            v900 = SushiRawColorTokens.Slate900.asColorSpec(),
        )
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
        val accentHoney: ColorSpec
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
        val tertiary: ColorSpec,
        val quaternary: ColorSpec,
        val accentBlueOnly: ColorSpec,
        val accentBlueInverse: ColorSpec,
        val accentGreyInverse: ColorSpec,
        val accentTangerineIntense: ColorSpec,
        val accentTangerineInverse: ColorSpec,
        val accentIndigo: ColorSpec,
        val accentIndigoIntense: ColorSpec,
        val accentIndigoInverse: ColorSpec,
        val darkIntense: ColorSpec,
        val accentTeal: ColorSpec,
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
        val accentPink: ColorSpec,
        val accentPurpleIntense: ColorSpec,
        val accentGreen: ColorSpec,
        val accentGreenIntense: ColorSpec,
        val accentOrange: ColorSpec,
        val accentOrangeIntense: ColorSpec,
        val accentBlue: ColorSpec,
        val accentBlueIntense: ColorSpec,
        val dark: ColorSpec,
        val accentWhite: ColorSpec,
        val accentHoney: ColorSpec,
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

    @Immutable
    data class AerobarColorScheme(
        val default: ColorSpec,
        val success: ColorSpec,
        val error: ColorSpec,
        val warning: ColorSpec,
        val discover: ColorSpec,
        val accentDefault: ColorSpec,
        val accentSuccess: ColorSpec,
        val accentWarning: ColorSpec,
        val accentError: ColorSpec,
        val accentDiscover: ColorSpec,
    )

    @Immutable
    data class TagColorScheme(
        val primaryBlack: ColorSpec,
        val primaryGrey: ColorSpec,
        val primaryGreen: ColorSpec,
        val primaryPurple: ColorSpec,
        val primaryTeal: ColorSpec,
        val primaryPink: ColorSpec,
        val primaryYellow: ColorSpec,
        val primaryOrange: ColorSpec,
        val primaryBlue: ColorSpec,
        val secondaryGrey: ColorSpec,
        val secondaryGreen: ColorSpec,
        val secondaryPurple: ColorSpec,
        val secondaryTeal: ColorSpec,
        val secondaryPink: ColorSpec,
        val secondaryYellow: ColorSpec,
        val secondaryOrange: ColorSpec,
        val secondaryBlue: ColorSpec,
    )
}