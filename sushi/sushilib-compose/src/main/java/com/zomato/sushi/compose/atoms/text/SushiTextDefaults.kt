package com.zomato.sushi.compose.atoms.text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.foundation.SushiTheme

/**
 * Default values for SushiText component properties.
 * These values are used when specific properties are not provided in SushiTextProps.
 */
@Immutable
object SushiTextDefaults {
    /**
     * Default text type (typography style).
     */
    public val textType: TextTypeSpec = SushiTextType.Regular100
    
    /**
     * Default text color from the theme.
     */
    public val textColor: ColorSpec @Composable get() = SushiTheme.colors.text.default
    
    /**
     * Default spacing between prefix icon and text.
     */
    public val prefixSpacing: Dp @Composable get() = SushiTheme.dimens.spacing.micro
    
    /**
     * Default spacing between text and suffix icon.
     */
    public val suffixSpacing: Dp @Composable get() = SushiTheme.dimens.spacing.micro

    /**
     * Whether to interpret text as markdown by default.
     */
    internal const val isMarkDown: Boolean = true
    
    /**
     * Default maximum number of lines.
     */
    internal val maxLines: Int = Int.MAX_VALUE
    
    /**
     * Default text overflow handling.
     */
    internal val overflow: TextOverflow = TextOverflow.Clip
    
    /**
     * Whether text should wrap to the next line by default.
     */
    internal val softWrap: Boolean = true
    
    /**
     * Default minimum number of lines.
     */
    internal val minLines: Int = 1
}