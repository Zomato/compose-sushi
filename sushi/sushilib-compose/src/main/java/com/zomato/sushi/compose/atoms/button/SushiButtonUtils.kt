@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.text.TextUnitTextType
import com.zomato.sushi.compose.foundation.SushiTextSize200
import com.zomato.sushi.compose.foundation.SushiTextSize300
import com.zomato.sushi.compose.foundation.SushiTextSize500
import com.zomato.sushi.compose.foundation.SushiTheme

internal object SushiButtonDefaults {
    val size = SushiButtonSize.Medium
    val type = SushiButtonType.Solid
    val alignment = Alignment.CenterHorizontally
    val shape = RoundedCornerShape(8.dp)
    const val subTextSizePercentage = 0.75f
}

internal fun SushiButtonProps.getButtonTypeWithDefaults() = this.type ?: SushiButtonDefaults.type
internal fun SushiButtonProps.getButtonSizeWithDefaults() = this.size ?: SushiButtonDefaults.size
internal fun SushiButtonProps.getButtonAlignmentWithDefaults() = this.textAlignment ?: SushiButtonDefaults.alignment
internal fun SushiButtonProps.getButtonShapeWithDefaults() = this.shape ?: SushiButtonDefaults.shape
internal fun SushiButtonProps.getSubtextTextType(textSize: TextUnit) = TextUnitTextType(TextStyle(fontSize = textSize  * SushiButtonDefaults.subTextSizePercentage))

fun getButtonTextSize(size: SushiButtonSize): TextUnit = when (size) {
    SushiButtonSize.Small -> SushiTextSize200
    SushiButtonSize.Medium -> SushiTextSize300
    SushiButtonSize.Large -> SushiTextSize500
}

@Composable
internal fun getButtonTextType(size: SushiButtonSize): TextStyle = when (size) {
    SushiButtonSize.Small -> SushiTheme.typography.regular200
    SushiButtonSize.Medium -> SushiTheme.typography.regular300
    SushiButtonSize.Large -> SushiTheme.typography.regular500
}

fun getButtonIconSize(size: SushiButtonSize): TextUnit = when (size) {
    SushiButtonSize.Small -> SushiTextSize200
    SushiButtonSize.Medium -> SushiTextSize300
    SushiButtonSize.Large -> SushiTextSize500
}

@Composable
fun getButtonIconPadding(size: SushiButtonSize): Dp = when (size) {
    SushiButtonSize.Small -> SushiTheme.dimens.spacing.pico
    SushiButtonSize.Medium -> SushiTheme.dimens.spacing.nano
    SushiButtonSize.Large -> SushiTheme.dimens.spacing.micro
}

internal fun getButtonMinHeight(size: SushiButtonSize): Dp = when (size) {
    SushiButtonSize.Small -> 25.dp
    SushiButtonSize.Medium -> 32.dp
    SushiButtonSize.Large -> 48.dp
}