package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.foundation.SushiTextSize200
import com.zomato.sushi.compose.foundation.SushiTextSize300
import com.zomato.sushi.compose.foundation.SushiTextSize500
import com.zomato.sushi.compose.foundation.SushiTheme

/**
 * @author gupta.anirudh@zomato.com
 */
object SushiButtonDefaults {
    public val shape = RoundedCornerShape(8.dp)

    private val size = SushiButtonSize.Medium
    private val type = SushiButtonType.Solid
    private val horizontalArrangement = Arrangement.Center
    private val verticalAlignment = Alignment.CenterVertically
    private const val subTextSizePercentage = 0.75f

    internal val SushiButtonProps.typeOrDefault get() = this.type ?: SushiButtonDefaults.type
    internal val SushiButtonProps.sizeOrDefault get() = this.size ?: SushiButtonDefaults.size
    internal val SushiButtonProps.horizontalArrangementOrDefault get() = this.horizontalArrangement ?: SushiButtonDefaults.horizontalArrangement
    internal val SushiButtonProps.verticalAlignmentOrDefault get() = this.verticalAlignment ?: SushiButtonDefaults.verticalAlignment
    internal val SushiButtonProps.shapeOrDefault get() = this.shape ?: SushiButtonDefaults.shape

    @Composable
    public fun getSubtextTextStyle(textStyle: TextStyle) = textStyle.copy(
        fontSize = textStyle.fontSize * SushiButtonDefaults.subTextSizePercentage
    )

    @Composable
    public fun getButtonTextType(size: SushiButtonSize): TextStyle = when (size) {
        SushiButtonSize.Small -> SushiTheme.typography.regular200
        SushiButtonSize.Medium -> SushiTheme.typography.regular300
        SushiButtonSize.Large -> SushiTheme.typography.regular400
    }

    public fun getButtonIconSize(size: SushiButtonSize): TextUnit = when (size) {
        SushiButtonSize.Small -> SushiTextSize200
        SushiButtonSize.Medium -> SushiTextSize300
        SushiButtonSize.Large -> SushiTextSize500
    }

    @Composable
    public fun getButtonIconPadding(size: SushiButtonSize): Dp = when (size) {
        SushiButtonSize.Small -> SushiTheme.dimens.spacing.pico
        SushiButtonSize.Medium -> SushiTheme.dimens.spacing.nano
        SushiButtonSize.Large -> SushiTheme.dimens.spacing.micro
    }

    internal fun getButtonMinHeight(size: SushiButtonSize): Dp = when (size) {
        SushiButtonSize.Small -> 25.dp
        SushiButtonSize.Medium -> 32.dp
        SushiButtonSize.Large -> 48.dp
    }
}