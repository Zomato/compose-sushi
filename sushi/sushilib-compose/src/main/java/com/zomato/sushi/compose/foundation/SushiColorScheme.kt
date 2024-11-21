package com.zomato.sushi.compose.foundation

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@ExperimentalSushiApi
@Immutable
data class SushiColorScheme(
    val schemeType: SushiColorSchemeType,
    val material: ColorScheme,

    val black: Color = SushiBlack,
    val white: Color = SushiWhite,
    val transparent: Color = SushiTransparent,

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
        val v050: Color = SushiGrey050,
        val v100: Color = SushiGrey100,
        val v200: Color = SushiGrey200,
        val v300: Color = SushiGrey300,
        val v400: Color = SushiGrey400,
        val v500: Color = SushiGrey500,
        val v600: Color = SushiGrey600,
        val v700: Color = SushiGrey700,
        val v800: Color = SushiGrey800,
        val v900: Color = SushiGrey900,
    )

    // Red
    @Immutable
    data class RedColorScheme(
        val v050: Color = SushiRed050,
        val v100: Color = SushiRed100,
        val v200: Color = SushiRed200,
        val v300: Color = SushiRed300,
        val v400: Color = SushiRed400,
        val v500: Color = SushiRed500,
        val v600: Color = SushiRed600,
        val v700: Color = SushiRed700,
        val v800: Color = SushiRed800,
        val v900: Color = SushiRed900,
    )

    // Green
    @Immutable
    data class GreenColorScheme(
        val v050: Color = SushiGreen050,
        val v100: Color = SushiGreen100,
        val v200: Color = SushiGreen200,
        val v300: Color = SushiGreen300,
        val v400: Color = SushiGreen400,
        val v500: Color = SushiGreen500,
        val v600: Color = SushiGreen600,
        val v700: Color = SushiGreen700,
        val v800: Color = SushiGreen800,
        val v900: Color = SushiGreen900,
    )

    // Blue
    @Immutable
    data class BlueColorScheme(
        val v050: Color = SushiBlue050,
        val v100: Color = SushiBlue100,
        val v200: Color = SushiBlue200,
        val v300: Color = SushiBlue300,
        val v400: Color = SushiBlue400,
        val v500: Color = SushiBlue500,
        val v600: Color = SushiBlue600,
        val v700: Color = SushiBlue700,
        val v800: Color = SushiBlue800,
        val v900: Color = SushiBlue900,
    )

    // Yellow
    @Immutable
    data class YellowColorScheme(
        val v050: Color = SushiYellow050,
        val v100: Color = SushiYellow100,
        val v200: Color = SushiYellow200,
        val v300: Color = SushiYellow300,
        val v400: Color = SushiYellow400,
        val v500: Color = SushiYellow500,
        val v600: Color = SushiYellow600,
        val v700: Color = SushiYellow700,
        val v800: Color = SushiYellow800,
        val v900: Color = SushiYellow900,
    )

    // Purple
    @Immutable
    data class PurpleColorScheme(
        val v050: Color = SushiPurple050,
        val v100: Color = SushiPurple100,
        val v200: Color = SushiPurple200,
        val v300: Color = SushiPurple300,
        val v400: Color = SushiPurple400,
        val v500: Color = SushiPurple500,
        val v600: Color = SushiPurple600,
        val v700: Color = SushiPurple700,
        val v800: Color = SushiPurple800,
        val v900: Color = SushiPurple900,
    )

    // Indigo
    @Immutable
    data class IndigoColorScheme(
        val v050: Color = SushiIndigo050,
        val v100: Color = SushiIndigo100,
        val v200: Color = SushiIndigo200,
        val v300: Color = SushiIndigo300,
        val v400: Color = SushiIndigo400,
        val v500: Color = SushiIndigo500,
        val v600: Color = SushiIndigo600,
        val v700: Color = SushiIndigo700,
        val v800: Color = SushiIndigo800,
        val v900: Color = SushiIndigo900,
    )

    // Brown
    @Immutable
    data class BrownColorScheme(
        val v050: Color = SushiBrown050,
        val v100: Color = SushiBrown100,
        val v200: Color = SushiBrown200,
        val v300: Color = SushiBrown300,
        val v400: Color = SushiBrown400,
        val v500: Color = SushiBrown500,
        val v600: Color = SushiBrown600,
        val v700: Color = SushiBrown700,
        val v800: Color = SushiBrown800,
        val v900: Color = SushiBrown900,
    )

    // Cider
    @Immutable
    data class CiderColorScheme(
        val v050: Color = SushiCider050,
        val v100: Color = SushiCider100,
        val v200: Color = SushiCider200,
        val v300: Color = SushiCider300,
        val v400: Color = SushiCider400,
        val v500: Color = SushiCider500,
        val v600: Color = SushiCider600,
        val v700: Color = SushiCider700,
        val v800: Color = SushiCider800,
        val v900: Color = SushiCider900,
    )

    // Teal
    @Immutable
    data class TealColorScheme(
        val v050: Color = SushiTeal050,
        val v100: Color = SushiTeal100,
        val v200: Color = SushiTeal200,
        val v300: Color = SushiTeal300,
        val v400: Color = SushiTeal400,
        val v500: Color = SushiTeal500,
        val v600: Color = SushiTeal600,
        val v700: Color = SushiTeal700,
        val v800: Color = SushiTeal800,
        val v900: Color = SushiTeal900,
    )

    // Orange
    @Immutable
    data class OrangeColorScheme(
        val v050: Color = SushiOrange050,
        val v100: Color = SushiOrange100,
        val v200: Color = SushiOrange200,
        val v300: Color = SushiOrange300,
        val v400: Color = SushiOrange400,
        val v500: Color = SushiOrange500,
        val v600: Color = SushiOrange600,
        val v700: Color = SushiOrange700,
        val v800: Color = SushiOrange800,
        val v900: Color = SushiOrange900,
    )

    // Pink
    @Immutable
    data class PinkColorScheme(
        val v050: Color = SushiPink050,
        val v100: Color = SushiPink100,
        val v200: Color = SushiPink200,
        val v300: Color = SushiPink300,
        val v400: Color = SushiPink400,
        val v500: Color = SushiPink500,
        val v600: Color = SushiPink600,
        val v700: Color = SushiPink700,
        val v800: Color = SushiPink800,
        val v900: Color = SushiPink900,
    )

    // Lime
    @Immutable
    data class LimeColorScheme(
        val v050: Color = SushiLime050,
        val v100: Color = SushiLime100,
        val v200: Color = SushiLime200,
        val v300: Color = SushiLime300,
        val v400: Color = SushiLime400,
        val v500: Color = SushiLime500,
        val v600: Color = SushiLime600,
        val v700: Color = SushiLime700,
        val v800: Color = SushiLime800,
        val v900: Color = SushiLime900,
    )

    // Corn
    @Immutable
    data class CornColorScheme(
        val v050: Color = SushiCorn050,
        val v100: Color = SushiCorn100,
        val v200: Color = SushiCorn200,
        val v300: Color = SushiCorn300,
        val v400: Color = SushiCorn400,
        val v500: Color = SushiCorn500,
        val v600: Color = SushiCorn600,
        val v700: Color = SushiCorn700,
        val v800: Color = SushiCorn800,
        val v900: Color = SushiCorn900,
    )

    // Avacado
    @Immutable
    data class AvacadoColorScheme(
        val v050: Color = SushiAvacado050,
        val v100: Color = SushiAvacado100,
        val v200: Color = SushiAvacado200,
        val v300: Color = SushiAvacado300,
        val v400: Color = SushiAvacado400,
        val v500: Color = SushiAvacado500,
        val v600: Color = SushiAvacado600,
        val v700: Color = SushiAvacado700,
        val v800: Color = SushiAvacado800,
        val v900: Color = SushiAvacado900,
    )

    // Gold
    @Immutable
    data class GoldColorScheme(
        val v050: Color = SushiGold050,
        val v100: Color = SushiGold100,
        val v200: Color = SushiGold200,
        val v300: Color = SushiGold300,
        val v400: Color = SushiGold400,
        val v500: Color = SushiGold500,
        val v600: Color = SushiGold600,
        val v700: Color = SushiGold700,
        val v800: Color = SushiGold800,
        val v900: Color = SushiGold900,
    )

    // Onion
    @Immutable
    data class OnionColorScheme(
        val v050: Color = SushiOnion050,
        val v100: Color = SushiOnion100,
        val v200: Color = SushiOnion200,
        val v300: Color = SushiOnion300,
        val v400: Color = SushiOnion400,
        val v500: Color = SushiOnion500,
        val v600: Color = SushiOnion600,
        val v700: Color = SushiOnion700,
        val v800: Color = SushiOnion800,
        val v900: Color = SushiOnion900,
    )

    // Charcoal
    @Immutable
    data class CharcoalColorScheme(
        val v050: Color = SushiCharcoal050,
        val v100: Color = SushiCharcoal100,
        val v200: Color = SushiCharcoal200,
        val v300: Color = SushiCharcoal300,
        val v400: Color = SushiCharcoal400,
        val v500: Color = SushiCharcoal500,
        val v600: Color = SushiCharcoal600,
        val v700: Color = SushiCharcoal700,
        val v800: Color = SushiCharcoal800,
        val v900: Color = SushiCharcoal900,
    )

    // Honey
    @Immutable
    data class HoneyColorScheme(
        val v050: Color = SushiHoney050,
        val v100: Color = SushiHoney100,
        val v200: Color = SushiHoney200,
        val v300: Color = SushiHoney300,
        val v400: Color = SushiHoney400,
        val v500: Color = SushiHoney500,
        val v600: Color = SushiHoney600,
        val v700: Color = SushiHoney700,
        val v800: Color = SushiHoney800,
        val v900: Color = SushiHoney900,
    )

    // Tangerine
    @Immutable
    data class TangerineColorScheme(
        val v050: Color = SushiTangerine050,
        val v100: Color = SushiTangerine100,
        val v200: Color = SushiTangerine200,
        val v300: Color = SushiTangerine300,
        val v400: Color = SushiTangerine400,
        val v500: Color = SushiTangerine500,
        val v600: Color = SushiTangerine600,
        val v700: Color = SushiTangerine700,
        val v800: Color = SushiTangerine800,
        val v900: Color = SushiTangerine900,
    )

    // Slate
    @Immutable
    data class SlateColorScheme(
        val v050: Color = SushiSlate050,
        val v100: Color = SushiSlate100,
        val v200: Color = SushiSlate200,
        val v300: Color = SushiSlate300,
        val v400: Color = SushiSlate400,
        val v500: Color = SushiSlate500,
        val v600: Color = SushiSlate600,
        val v700: Color = SushiSlate700,
        val v800: Color = SushiSlate800,
        val v900: Color = SushiSlate900,
    )

    // Rating
    @Immutable
    data class RatingColorScheme(
        val one: Color = SushiRating1,
        val two: Color = SushiRating2,
        val three: Color = SushiRating3,
        val four: Color = SushiRating4,
        val five: Color = SushiRating5,
        val unchecked: Color = SushiRatingUnchecked,
    )

    // Theme
    @Immutable
    data class ThemeColorScheme(
        val v050: Color = SushiRed050,
        val v100: Color = SushiRed100,
        val v200: Color = SushiRed200,
        val v300: Color = SushiRed300,
        val v400: Color = SushiRed400,
        val v500: Color = SushiRed500,
        val v600: Color = SushiRed600,
        val v700: Color = SushiRed700,
        val v800: Color = SushiRed800,
        val v900: Color = SushiRed900,

        val accentColor: Color = SushiRed600,
    )

    // Text color tokens
    @Immutable
    data class TextColorScheme(
        val default: Color,
        val primary: Color,
        val secondary: Color,
        val tertiary: Color,
        val quaternary: Color,
        val disabled: Color,
        val inverse: Color,
        val brand: Color,
        val brandOnlyLight: Color,
        val offer: Color,
        val success: Color,
        val warning: Color,
        val error: Color,
        val accentRed: Color,
        val accentRedIntense: Color,
        val accentOrange: Color,
        val accentOrangeIntense: Color,
        val accentGreen: Color,
        val accentGreenIntense: Color,
        val accentBlue: Color,
        val accentBlueIntense: Color,
        val accentPurple: Color,
        val accentPurpleIntense: Color,
        val accentYellow: Color,
        val accentYellowIntense: Color,
        val accentTeal: Color,
        val accentTealIntense: Color,
        val accentCider: Color,
        val accentCiderIntense: Color,
        val accentBrown: Color,
        val accentBrownIntense: Color,
        val light: Color,
        val accentPink: Color,
        val discover: Color,
    )

    // Icon color tokens
    @Immutable
    data class IconColorScheme(
        val default: Color,
        val primary: Color,
        val secondary: Color,
        val tertiary: Color,
        val quaternary: Color,
        val offer: Color,
        val warning: Color,
        val error: Color,
        val success: Color,
        val inverse: Color,
        val brand: Color,
        val disabled: Color,
        val brandOnlyLight: Color,
        val accentOrange: Color,
        val accentRed: Color,
        val accentGreen: Color,
        val accentBlue: Color,
        val accentPurple: Color,
        val accentYellow: Color,
        val light: Color,
        val enable: Color,
        val accentPink: Color,
        val accentTeal: Color,
        val discover: Color,
    )

    // Surface color tokens
    @Immutable
    data class SurfaceColorScheme(
        val backgroundPrimary: Color,
        val backgroundSecondary: Color,
        val primary: Color,
        val secondary: Color,
        val elevated: Color,
        val inverse: Color,
        val inset: Color,
        val insetIntense: Color,
        val accentBlue: Color,
        val accentBlueIntense: Color,
        val accentCider: Color,
        val accentCiderIntense: Color,
        val disabled: Color,
        val accentGreen: Color,
        val accentGreenIntense: Color,
        val accentYellow: Color,
        val accentYellowIntense: Color,
        val accentRed: Color,
        val accentRedIntense: Color,
        val accentOrange: Color,
        val accentOrangeIntense: Color,
        val accentPurple: Color,
        val accentPurpleIntense: Color,
        val accentBrown: Color,
        val accentBrownIntense: Color,
        val accentPink: Color,
        val accentPinkIntense: Color,
        val brandOnlylight: Color,
        val brand: Color,
        val selection: Color,
        val success: Color,
        val warning: Color,
        val error: Color,
        val offer: Color,
        val shimmer: Color,
        val shimmerInset: Color,
        val backgroundDark: Color,
        val default: Color,
        val deepened: Color,
        val errorDark: Color,
        val brandOnlyLight: Color,
        val successDark: Color,
        val accentGrey: Color,
        val accentTangerine: Color,
        val discover: Color,
    )

    // Border color tokens
    @Immutable
    data class BorderColorScheme(
        val subtle: Color,
        val moderate: Color,
        val intense: Color,
        val inverse: Color,
        val selection: Color,
        val brand: Color,
        val success: Color,
        val warning: Color,
        val error: Color,
        val accentRed: Color,
        val accentRedIntense: Color,
        val accentYellow: Color,
        val accentYellowIntense: Color,
        val accentCider: Color,
        val accentCiderIntense: Color,
        val accentPurple: Color,
        val accentPurpleIntense: Color,
        val accentGreen: Color,
        val accentGreenIntense: Color,
        val accentOrange: Color,
        val accentOrangeIntense: Color,
        val accentBlue: Color,
        val accentBlueIntense: Color,
        val dark: Color,
    )

    // Crystal color tokens
    @Immutable
    data class CrystalColorScheme(
        val ontime: Color,
        val delay: Color,
        val rain: Color,
        val polylineAerialCurved: Color,
    )

    // Dish rating color tokens
    @Immutable
    data class DishColorScheme(
        val background: Color,
        val border: Color,
        val icon: Color,
    )

    // Res Rating color tokens
    @Immutable
    data class ResColorScheme(
        val background50: Color,
        val background45: Color,
        val background40: Color,
        val background35: Color,
        val background30: Color,
        val background25: Color,
        val background20: Color,
        val background15: Color,
        val background00: Color,
        val backgroundNew: Color,
        val borderNew: Color,
        val label: Color,
        val labelNew: Color,
    )

    // Button color tokens
    @Immutable
    data class ButtonColorScheme(
        val primaryBackground: Color,
        val primaryBackgroundPressed: Color,
        val backgroundDisabled: Color,
        val primaryLabel: Color,
        val primaryLabelPressed: Color,
        val primaryLabelDisabled: Color,
        val primaryIcon: Color,
        val primaryIconPressed: Color,
        val primaryIconDisabled: Color,

        val secondaryBackground: Color,
        val secondaryBackgroundPressed: Color,
        val secondaryLabel: Color,
        val secondaryLabelPressed: Color,
        val secondaryLabelDisabled: Color,
        val secondaryIcon: Color,
        val secondaryIconPressed: Color,
        val secondaryIconDisabled: Color,
        val secondaryBorder: Color,
        val secondaryBorderPressed: Color,
        val secondaryBorderDisabled: Color,

        val ghostBackground: Color,
        val ghostBackgroundPressed: Color,
        val ghostLabel: Color,
        val ghostLabelPressed: Color,
        val ghostLabelDisabled: Color,
        val ghostIcon: Color,
        val ghostIconPressed: Color,
        val ghostIconDisabled: Color,
        val tertiaryBackground: Color,
        val tertiaryBackgroundPressed: Color,
        val tertiaryLabel: Color,
        val tertiaryLabelPressed: Color,
        val tertiaryLabelDisabled: Color,
        val tertiaryIcon: Color,
        val tertiaryIconPressed: Color,
        val tertiaryIconDisabled: Color,
        val tertiaryStroke: Color,
        val tertiaryStrokePressed: Color,
        val tertiaryStrokeDisabled: Color,
    )

    // Stepper color tokens
    @Immutable
    data class StepperColorScheme(
        val primaryBackground: Color,
        val primaryBackgroundDisabled: Color,
        val primaryIcon: Color,
        val primaryIconDisabled: Color,
        val primaryLabel: Color,
        val primaryLabelDisabled: Color,
        val primaryLabelCustomisable: Color,

        val secondaryBackground: Color,
        val secondaryBackgroundDisabled: Color,
        val secondaryIcon: Color,
        val secondaryIconDisabled: Color,
        val secondaryLabelNumber: Color,
        val secondaryLabel: Color,
        val secondaryLabelDisabled: Color,
        val secondaryLabelCustomisable: Color,
        val secondaryBorder: Color,
        val secondaryBorderDisabled: Color,
    )

    // Shimmer color tokens
    @Immutable
    data class ShimmerColorScheme(
        val start: Color,
        val end: Color
    )

    // Slider color tokens
    @Immutable
    data class SliderColorScheme(
        val background: Color,
        val backgroundPressed: Color,
        val backgroundDisabled: Color,
        val label: Color,
        val labelPressed: Color,
        val labelDisabled: Color,
        val labelComplete: Color,
        val icon: Color,
        val iconPressed: Color,
        val iconDisabled: Color,
    )

    // Filter color tokens
    @Immutable
    data class FilterColorScheme(
        val backgroundSuccess: Color,
        val stroke: Color,
        val strokeSuccess: Color,
        val strokeDisabled: Color,
        val label: Color,
        val labelDisabled: Color,
        val icon: Color,
        val iconDisabled: Color,
    )
}