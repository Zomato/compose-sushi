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
 * Provides default values and utility functions for SushiButton components.
 * Contains constants and extension properties that determine the default appearance
 * and behavior of buttons when specific properties are not provided.
 *
 * @author gupta.anirudh@zomato.com
 */
object SushiButtonDefaults {
    /**
     * Default shape for buttons with rounded corners
     */
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

    /**
     * Creates a text style for the button's subtext based on the main text style.
     * The subtext is typically smaller than the main text.
     * 
     * @param textStyle The base text style to modify
     * @return A modified TextStyle with reduced font size
     */
    @Composable
    public fun getSubtextTextStyle(textStyle: TextStyle) = textStyle.copy(
        fontSize = textStyle.fontSize * SushiButtonDefaults.subTextSizePercentage
    )

    /**
     * Gets the appropriate text style based on button size.
     * 
     * @param size The size variant of the button
     * @return The TextStyle corresponding to the given button size
     */
    @Composable
    public fun getButtonTextType(size: SushiButtonSize): TextStyle = when (size) {
        SushiButtonSize.Small -> SushiTheme.typography.regular200
        SushiButtonSize.Medium -> SushiTheme.typography.regular300
        SushiButtonSize.Large -> SushiTheme.typography.regular400
    }

    /**
     * Gets the appropriate icon size based on button size.
     * 
     * @param size The size variant of the button
     * @return The TextUnit representing the icon size for the given button size
     */
    public fun getButtonIconSize(size: SushiButtonSize): TextUnit = when (size) {
        SushiButtonSize.Small -> SushiTextSize200
        SushiButtonSize.Medium -> SushiTextSize300
        SushiButtonSize.Large -> SushiTextSize500
    }

    /**
     * Gets the appropriate padding between icon and text based on button size.
     * 
     * @param size The size variant of the button
     * @return The spacing dimension between icon and text
     */
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