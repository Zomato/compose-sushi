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

    val black: ColorSpec = SushiBlack.asColorSpec(),
    val white: ColorSpec = SushiWhite.asColorSpec(),
    val transparent: ColorSpec = SushiTransparent.asColorSpec(),

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
        val v050: ColorSpec = SushiGrey050.asColorSpec(),
        val v100: ColorSpec = SushiGrey100.asColorSpec(),
        val v200: ColorSpec = SushiGrey200.asColorSpec(),
        val v300: ColorSpec = SushiGrey300.asColorSpec(),
        val v400: ColorSpec = SushiGrey400.asColorSpec(),
        val v500: ColorSpec = SushiGrey500.asColorSpec(),
        val v600: ColorSpec = SushiGrey600.asColorSpec(),
        val v700: ColorSpec = SushiGrey700.asColorSpec(),
        val v800: ColorSpec = SushiGrey800.asColorSpec(),
        val v900: ColorSpec = SushiGrey900.asColorSpec(),
    )

    // Red
    @Immutable
    data class RedColorScheme(
        val v050: ColorSpec = SushiRed050.asColorSpec(),
        val v100: ColorSpec = SushiRed100.asColorSpec(),
        val v200: ColorSpec = SushiRed200.asColorSpec(),
        val v300: ColorSpec = SushiRed300.asColorSpec(),
        val v400: ColorSpec = SushiRed400.asColorSpec(),
        val v500: ColorSpec = SushiRed500.asColorSpec(),
        val v600: ColorSpec = SushiRed600.asColorSpec(),
        val v700: ColorSpec = SushiRed700.asColorSpec(),
        val v800: ColorSpec = SushiRed800.asColorSpec(),
        val v900: ColorSpec = SushiRed900.asColorSpec(),
    )

    // Green
    @Immutable
    data class GreenColorScheme(
        val v050: ColorSpec = SushiGreen050.asColorSpec(),
        val v100: ColorSpec = SushiGreen100.asColorSpec(),
        val v200: ColorSpec = SushiGreen200.asColorSpec(),
        val v300: ColorSpec = SushiGreen300.asColorSpec(),
        val v400: ColorSpec = SushiGreen400.asColorSpec(),
        val v500: ColorSpec = SushiGreen500.asColorSpec(),
        val v600: ColorSpec = SushiGreen600.asColorSpec(),
        val v700: ColorSpec = SushiGreen700.asColorSpec(),
        val v800: ColorSpec = SushiGreen800.asColorSpec(),
        val v900: ColorSpec = SushiGreen900.asColorSpec(),
    )

    // Blue
    @Immutable
    data class BlueColorScheme(
        val v050: ColorSpec = SushiBlue050.asColorSpec(),
        val v100: ColorSpec = SushiBlue100.asColorSpec(),
        val v200: ColorSpec = SushiBlue200.asColorSpec(),
        val v300: ColorSpec = SushiBlue300.asColorSpec(),
        val v400: ColorSpec = SushiBlue400.asColorSpec(),
        val v500: ColorSpec = SushiBlue500.asColorSpec(),
        val v600: ColorSpec = SushiBlue600.asColorSpec(),
        val v700: ColorSpec = SushiBlue700.asColorSpec(),
        val v800: ColorSpec = SushiBlue800.asColorSpec(),
        val v900: ColorSpec = SushiBlue900.asColorSpec(),
    )

    // Yellow
    @Immutable
    data class YellowColorScheme(
        val v050: ColorSpec = SushiYellow050.asColorSpec(),
        val v100: ColorSpec = SushiYellow100.asColorSpec(),
        val v200: ColorSpec = SushiYellow200.asColorSpec(),
        val v300: ColorSpec = SushiYellow300.asColorSpec(),
        val v400: ColorSpec = SushiYellow400.asColorSpec(),
        val v500: ColorSpec = SushiYellow500.asColorSpec(),
        val v600: ColorSpec = SushiYellow600.asColorSpec(),
        val v700: ColorSpec = SushiYellow700.asColorSpec(),
        val v800: ColorSpec = SushiYellow800.asColorSpec(),
        val v900: ColorSpec = SushiYellow900.asColorSpec(),
    )

    // Purple
    @Immutable
    data class PurpleColorScheme(
        val v050: ColorSpec = SushiPurple050.asColorSpec(),
        val v100: ColorSpec = SushiPurple100.asColorSpec(),
        val v200: ColorSpec = SushiPurple200.asColorSpec(),
        val v300: ColorSpec = SushiPurple300.asColorSpec(),
        val v400: ColorSpec = SushiPurple400.asColorSpec(),
        val v500: ColorSpec = SushiPurple500.asColorSpec(),
        val v600: ColorSpec = SushiPurple600.asColorSpec(),
        val v700: ColorSpec = SushiPurple700.asColorSpec(),
        val v800: ColorSpec = SushiPurple800.asColorSpec(),
        val v900: ColorSpec = SushiPurple900.asColorSpec(),
    )

    // Indigo
    @Immutable
    data class IndigoColorScheme(
        val v050: ColorSpec = SushiIndigo050.asColorSpec(),
        val v100: ColorSpec = SushiIndigo100.asColorSpec(),
        val v200: ColorSpec = SushiIndigo200.asColorSpec(),
        val v300: ColorSpec = SushiIndigo300.asColorSpec(),
        val v400: ColorSpec = SushiIndigo400.asColorSpec(),
        val v500: ColorSpec = SushiIndigo500.asColorSpec(),
        val v600: ColorSpec = SushiIndigo600.asColorSpec(),
        val v700: ColorSpec = SushiIndigo700.asColorSpec(),
        val v800: ColorSpec = SushiIndigo800.asColorSpec(),
        val v900: ColorSpec = SushiIndigo900.asColorSpec(),
    )

    // Brown
    @Immutable
    data class BrownColorScheme(
        val v050: ColorSpec = SushiBrown050.asColorSpec(),
        val v100: ColorSpec = SushiBrown100.asColorSpec(),
        val v200: ColorSpec = SushiBrown200.asColorSpec(),
        val v300: ColorSpec = SushiBrown300.asColorSpec(),
        val v400: ColorSpec = SushiBrown400.asColorSpec(),
        val v500: ColorSpec = SushiBrown500.asColorSpec(),
        val v600: ColorSpec = SushiBrown600.asColorSpec(),
        val v700: ColorSpec = SushiBrown700.asColorSpec(),
        val v800: ColorSpec = SushiBrown800.asColorSpec(),
        val v900: ColorSpec = SushiBrown900.asColorSpec(),
    )

    // Cider
    @Immutable
    data class CiderColorScheme(
        val v050: ColorSpec = SushiCider050.asColorSpec(),
        val v100: ColorSpec = SushiCider100.asColorSpec(),
        val v200: ColorSpec = SushiCider200.asColorSpec(),
        val v300: ColorSpec = SushiCider300.asColorSpec(),
        val v400: ColorSpec = SushiCider400.asColorSpec(),
        val v500: ColorSpec = SushiCider500.asColorSpec(),
        val v600: ColorSpec = SushiCider600.asColorSpec(),
        val v700: ColorSpec = SushiCider700.asColorSpec(),
        val v800: ColorSpec = SushiCider800.asColorSpec(),
        val v900: ColorSpec = SushiCider900.asColorSpec(),
    )

    // Teal
    @Immutable
    data class TealColorScheme(
        val v050: ColorSpec = SushiTeal050.asColorSpec(),
        val v100: ColorSpec = SushiTeal100.asColorSpec(),
        val v200: ColorSpec = SushiTeal200.asColorSpec(),
        val v300: ColorSpec = SushiTeal300.asColorSpec(),
        val v400: ColorSpec = SushiTeal400.asColorSpec(),
        val v500: ColorSpec = SushiTeal500.asColorSpec(),
        val v600: ColorSpec = SushiTeal600.asColorSpec(),
        val v700: ColorSpec = SushiTeal700.asColorSpec(),
        val v800: ColorSpec = SushiTeal800.asColorSpec(),
        val v900: ColorSpec = SushiTeal900.asColorSpec(),
    )

    // Orange
    @Immutable
    data class OrangeColorScheme(
        val v050: ColorSpec = SushiOrange050.asColorSpec(),
        val v100: ColorSpec = SushiOrange100.asColorSpec(),
        val v200: ColorSpec = SushiOrange200.asColorSpec(),
        val v300: ColorSpec = SushiOrange300.asColorSpec(),
        val v400: ColorSpec = SushiOrange400.asColorSpec(),
        val v500: ColorSpec = SushiOrange500.asColorSpec(),
        val v600: ColorSpec = SushiOrange600.asColorSpec(),
        val v700: ColorSpec = SushiOrange700.asColorSpec(),
        val v800: ColorSpec = SushiOrange800.asColorSpec(),
        val v900: ColorSpec = SushiOrange900.asColorSpec(),
    )

    // Pink
    @Immutable
    data class PinkColorScheme(
        val v050: ColorSpec = SushiPink050.asColorSpec(),
        val v100: ColorSpec = SushiPink100.asColorSpec(),
        val v200: ColorSpec = SushiPink200.asColorSpec(),
        val v300: ColorSpec = SushiPink300.asColorSpec(),
        val v400: ColorSpec = SushiPink400.asColorSpec(),
        val v500: ColorSpec = SushiPink500.asColorSpec(),
        val v600: ColorSpec = SushiPink600.asColorSpec(),
        val v700: ColorSpec = SushiPink700.asColorSpec(),
        val v800: ColorSpec = SushiPink800.asColorSpec(),
        val v900: ColorSpec = SushiPink900.asColorSpec(),
    )

    // Lime
    @Immutable
    data class LimeColorScheme(
        val v050: ColorSpec = SushiLime050.asColorSpec(),
        val v100: ColorSpec = SushiLime100.asColorSpec(),
        val v200: ColorSpec = SushiLime200.asColorSpec(),
        val v300: ColorSpec = SushiLime300.asColorSpec(),
        val v400: ColorSpec = SushiLime400.asColorSpec(),
        val v500: ColorSpec = SushiLime500.asColorSpec(),
        val v600: ColorSpec = SushiLime600.asColorSpec(),
        val v700: ColorSpec = SushiLime700.asColorSpec(),
        val v800: ColorSpec = SushiLime800.asColorSpec(),
        val v900: ColorSpec = SushiLime900.asColorSpec(),
    )

    // Corn
    @Immutable
    data class CornColorScheme(
        val v050: ColorSpec = SushiCorn050.asColorSpec(),
        val v100: ColorSpec = SushiCorn100.asColorSpec(),
        val v200: ColorSpec = SushiCorn200.asColorSpec(),
        val v300: ColorSpec = SushiCorn300.asColorSpec(),
        val v400: ColorSpec = SushiCorn400.asColorSpec(),
        val v500: ColorSpec = SushiCorn500.asColorSpec(),
        val v600: ColorSpec = SushiCorn600.asColorSpec(),
        val v700: ColorSpec = SushiCorn700.asColorSpec(),
        val v800: ColorSpec = SushiCorn800.asColorSpec(),
        val v900: ColorSpec = SushiCorn900.asColorSpec(),
    )

    // Avacado
    @Immutable
    data class AvacadoColorScheme(
        val v050: ColorSpec = SushiAvacado050.asColorSpec(),
        val v100: ColorSpec = SushiAvacado100.asColorSpec(),
        val v200: ColorSpec = SushiAvacado200.asColorSpec(),
        val v300: ColorSpec = SushiAvacado300.asColorSpec(),
        val v400: ColorSpec = SushiAvacado400.asColorSpec(),
        val v500: ColorSpec = SushiAvacado500.asColorSpec(),
        val v600: ColorSpec = SushiAvacado600.asColorSpec(),
        val v700: ColorSpec = SushiAvacado700.asColorSpec(),
        val v800: ColorSpec = SushiAvacado800.asColorSpec(),
        val v900: ColorSpec = SushiAvacado900.asColorSpec(),
    )

    // Gold
    @Immutable
    data class GoldColorScheme(
        val v050: ColorSpec = SushiGold050.asColorSpec(),
        val v100: ColorSpec = SushiGold100.asColorSpec(),
        val v200: ColorSpec = SushiGold200.asColorSpec(),
        val v300: ColorSpec = SushiGold300.asColorSpec(),
        val v400: ColorSpec = SushiGold400.asColorSpec(),
        val v500: ColorSpec = SushiGold500.asColorSpec(),
        val v600: ColorSpec = SushiGold600.asColorSpec(),
        val v700: ColorSpec = SushiGold700.asColorSpec(),
        val v800: ColorSpec = SushiGold800.asColorSpec(),
        val v900: ColorSpec = SushiGold900.asColorSpec(),
    )

    // Onion
    @Immutable
    data class OnionColorScheme(
        val v050: ColorSpec = SushiOnion050.asColorSpec(),
        val v100: ColorSpec = SushiOnion100.asColorSpec(),
        val v200: ColorSpec = SushiOnion200.asColorSpec(),
        val v300: ColorSpec = SushiOnion300.asColorSpec(),
        val v400: ColorSpec = SushiOnion400.asColorSpec(),
        val v500: ColorSpec = SushiOnion500.asColorSpec(),
        val v600: ColorSpec = SushiOnion600.asColorSpec(),
        val v700: ColorSpec = SushiOnion700.asColorSpec(),
        val v800: ColorSpec = SushiOnion800.asColorSpec(),
        val v900: ColorSpec = SushiOnion900.asColorSpec(),
    )

    // Charcoal
    @Immutable
    data class CharcoalColorScheme(
        val v050: ColorSpec = SushiCharcoal050.asColorSpec(),
        val v100: ColorSpec = SushiCharcoal100.asColorSpec(),
        val v200: ColorSpec = SushiCharcoal200.asColorSpec(),
        val v300: ColorSpec = SushiCharcoal300.asColorSpec(),
        val v400: ColorSpec = SushiCharcoal400.asColorSpec(),
        val v500: ColorSpec = SushiCharcoal500.asColorSpec(),
        val v600: ColorSpec = SushiCharcoal600.asColorSpec(),
        val v700: ColorSpec = SushiCharcoal700.asColorSpec(),
        val v800: ColorSpec = SushiCharcoal800.asColorSpec(),
        val v900: ColorSpec = SushiCharcoal900.asColorSpec(),
    )

    // Honey
    @Immutable
    data class HoneyColorScheme(
        val v050: ColorSpec = SushiHoney050.asColorSpec(),
        val v100: ColorSpec = SushiHoney100.asColorSpec(),
        val v200: ColorSpec = SushiHoney200.asColorSpec(),
        val v300: ColorSpec = SushiHoney300.asColorSpec(),
        val v400: ColorSpec = SushiHoney400.asColorSpec(),
        val v500: ColorSpec = SushiHoney500.asColorSpec(),
        val v600: ColorSpec = SushiHoney600.asColorSpec(),
        val v700: ColorSpec = SushiHoney700.asColorSpec(),
        val v800: ColorSpec = SushiHoney800.asColorSpec(),
        val v900: ColorSpec = SushiHoney900.asColorSpec(),
    )

    // Tangerine
    @Immutable
    data class TangerineColorScheme(
        val v050: ColorSpec = SushiTangerine050.asColorSpec(),
        val v100: ColorSpec = SushiTangerine100.asColorSpec(),
        val v200: ColorSpec = SushiTangerine200.asColorSpec(),
        val v300: ColorSpec = SushiTangerine300.asColorSpec(),
        val v400: ColorSpec = SushiTangerine400.asColorSpec(),
        val v500: ColorSpec = SushiTangerine500.asColorSpec(),
        val v600: ColorSpec = SushiTangerine600.asColorSpec(),
        val v700: ColorSpec = SushiTangerine700.asColorSpec(),
        val v800: ColorSpec = SushiTangerine800.asColorSpec(),
        val v900: ColorSpec = SushiTangerine900.asColorSpec(),
    )

    // Slate
    @Immutable
    data class SlateColorScheme(
        val v050: ColorSpec = SushiSlate050.asColorSpec(),
        val v100: ColorSpec = SushiSlate100.asColorSpec(),
        val v200: ColorSpec = SushiSlate200.asColorSpec(),
        val v300: ColorSpec = SushiSlate300.asColorSpec(),
        val v400: ColorSpec = SushiSlate400.asColorSpec(),
        val v500: ColorSpec = SushiSlate500.asColorSpec(),
        val v600: ColorSpec = SushiSlate600.asColorSpec(),
        val v700: ColorSpec = SushiSlate700.asColorSpec(),
        val v800: ColorSpec = SushiSlate800.asColorSpec(),
        val v900: ColorSpec = SushiSlate900.asColorSpec(),
    )

    // Rating
    @Immutable
    data class RatingColorScheme(
        val one: ColorSpec = SushiRating1.asColorSpec(),
        val two: ColorSpec = SushiRating2.asColorSpec(),
        val three: ColorSpec = SushiRating3.asColorSpec(),
        val four: ColorSpec = SushiRating4.asColorSpec(),
        val five: ColorSpec = SushiRating5.asColorSpec(),
        val unchecked: ColorSpec = SushiRatingUnchecked.asColorSpec(),
    )

    // Theme
    @Immutable
    data class ThemeColorScheme(
        val v050: ColorSpec = SushiRed050.asColorSpec(),
        val v100: ColorSpec = SushiRed100.asColorSpec(),
        val v200: ColorSpec = SushiRed200.asColorSpec(),
        val v300: ColorSpec = SushiRed300.asColorSpec(),
        val v400: ColorSpec = SushiRed400.asColorSpec(),
        val v500: ColorSpec = SushiRed500.asColorSpec(),
        val v600: ColorSpec = SushiRed600.asColorSpec(),
        val v700: ColorSpec = SushiRed700.asColorSpec(),
        val v800: ColorSpec = SushiRed800.asColorSpec(),
        val v900: ColorSpec = SushiRed900.asColorSpec(),

        val accentColor: ColorSpec = SushiRed600.asColorSpec(),
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