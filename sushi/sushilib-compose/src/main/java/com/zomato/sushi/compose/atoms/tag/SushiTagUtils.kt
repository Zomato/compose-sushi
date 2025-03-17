package com.zomato.sushi.compose.atoms.tag

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.tag.SushiTagDefaults.sizeOrDefault
import com.zomato.sushi.compose.atoms.tag.SushiTagDefaults.typeOrDefault
import com.zomato.sushi.compose.foundation.SushiTextSize050
import com.zomato.sushi.compose.foundation.SushiTextSize100
import com.zomato.sushi.compose.foundation.SushiTextSize200
import com.zomato.sushi.compose.foundation.SushiTextSize300
import com.zomato.sushi.compose.foundation.SushiTextSize400
import com.zomato.sushi.compose.foundation.SushiTheme

/**
 * Utility functions for SushiTag components.
 * These functions determine appropriate styles, sizes, and other properties
 * based on tag configuration.
 *
 * Created by Kashish on 10,January,2025
 * Zomato, Gurgaon, India.
 */

/**
 * Returns the appropriate text style for a tag based on its size.
 * Larger tag sizes use larger text styles.
 *
 * @return The TextStyle to use for the tag text
 */
@Composable
fun SushiTagProps.getTagTextType(): TextStyle = when (sizeOrDefault) {
    SushiTagSize.Nano -> SushiTheme.typography.semiBold050
    SushiTagSize.Tiny -> SushiTheme.typography.semiBold100
    SushiTagSize.Small -> SushiTheme.typography.semiBold200
    SushiTagSize.Medium -> SushiTheme.typography.semiBold300
    SushiTagSize.Large -> SushiTheme.typography.semiBold400
    SushiTagSize.ExtraLarge -> SushiTheme.typography.semiBold400
}

/**
 * Returns the appropriate icon size for a tag based on its size.
 * Larger tag sizes use larger icons.
 *
 * @return The TextUnit size to use for the tag icons
 */
@Composable
fun SushiTagProps.getTagIconSize(): TextUnit = when (sizeOrDefault) {
    SushiTagSize.Nano -> SushiTextSize050
    SushiTagSize.Tiny -> SushiTextSize100
    SushiTagSize.Small -> SushiTextSize200
    SushiTagSize.Medium -> SushiTextSize300
    SushiTagSize.Large -> SushiTextSize400
    SushiTagSize.ExtraLarge -> SushiTextSize400
}

/**
 * Returns the appropriate padding values for a tag based on its size and type.
 * Capsule types receive extra horizontal padding to ensure proper pill shape.
 *
 * @return The PaddingValues to use for the tag content
 */
@Composable
fun SushiTagProps.getTagPaddingForSize(): PaddingValues {
    val padding = when (sizeOrDefault) {
        SushiTagSize.ExtraLarge -> PaddingValues(
            vertical = SushiTheme.dimens.spacing.base,
            horizontal = SushiTheme.dimens.spacing.extra
        )
        SushiTagSize.Large -> PaddingValues(all = SushiTheme.dimens.spacing.macro)
        SushiTagSize.Medium -> PaddingValues(all = SushiTheme.dimens.spacing.mini)
        SushiTagSize.Small -> PaddingValues(all = SushiTheme.dimens.spacing.micro)
        SushiTagSize.Tiny, SushiTagSize.Nano -> PaddingValues(
            vertical = SushiTheme.dimens.spacing.femto,
            horizontal = SushiTheme.dimens.spacing.nano
        )
    }
    return if (type == SushiTagType.Capsule || type == SushiTagType.CapsuleOutline) {
        PaddingValues(
            top = padding.calculateTopPadding(),
            bottom = padding.calculateBottomPadding(),
            start = padding.calculateLeftPadding(LayoutDirection.Ltr).times(1.5f),
            end = padding.calculateRightPadding(LayoutDirection.Ltr).times(1.5f),
        )
    }
    else padding
}

/**
 * Returns the appropriate shape for a tag based on its type.
 * Creates a RoundedCornerShape with the appropriate corner radius.
 *
 * @return The Shape to use for the tag
 */
@Composable
fun SushiTagProps.getTagShapeForType(): Shape {
    return RoundedCornerShape(getTagCornerRadiusForType())
}

/**
 * Returns the appropriate corner radius for a tag based on its type.
 * Capsule types use a large radius for pill shapes, while rounded types
 * use a smaller radius.
 *
 * @return The corner radius Dp value
 */
@Composable
fun SushiTagProps.getTagCornerRadiusForType(): Dp {

    val circularRadius = 30.dp
    val roundedRadius = if (size == SushiTagSize.Nano) 4.dp
    else 3.dp

    return when(typeOrDefault) {
        SushiTagType.Rounded -> roundedRadius
        SushiTagType.Capsule -> circularRadius
        SushiTagType.RoundedOutline -> roundedRadius
        SushiTagType.CapsuleOutline -> circularRadius
        SushiTagType.RoundedDashed -> roundedRadius
        SushiTagType.CapsuleDashed -> circularRadius
    }

}

/**
 * Returns the appropriate border for a tag based on its type.
 * Only outline types receive a border.
 *
 * @return The BorderStroke to use for the tag, or null if no border is needed
 */
@Composable
fun SushiTagProps.getBorderForType(): BorderStroke? {

    val outlinesTypes = listOf(SushiTagType.CapsuleOutline, SushiTagType.RoundedOutline)

    return if (typeOrDefault in outlinesTypes) BorderStroke(
        width = SushiTheme.dimens.spacing.pico,
        color = borderColor?.value ?: SushiTheme.colors.theme.accentColor.value
    )
    else return null

}

/**
 * Determines whether a dashed border is needed for the given tag type.
 * Only dashed types should use a dashed border.
 *
 * @param type The tag type to check
 * @return True if a dashed border is needed, false otherwise
 */
fun dashedBorderNeededForTag(type: SushiTagType): Boolean {
    val dashedTypes = listOf(SushiTagType.CapsuleDashed, SushiTagType.RoundedDashed)
    return type in dashedTypes
}
