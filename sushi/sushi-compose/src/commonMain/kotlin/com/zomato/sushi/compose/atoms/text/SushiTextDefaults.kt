package com.zomato.sushi.compose.atoms.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.text.style.TextAlign.Companion.End
import androidx.compose.ui.text.style.TextAlign.Companion.Justify
import androidx.compose.ui.text.style.TextAlign.Companion.Left
import androidx.compose.ui.text.style.TextAlign.Companion.Right
import androidx.compose.ui.text.style.TextAlign.Companion.Start
import androidx.compose.ui.text.style.TextAlign.Companion.Unspecified
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

    internal fun horizontalArrangementFromAlignment(textAlign: TextAlign?): Arrangement.Horizontal {
        return when (textAlign) {
            Left -> Arrangement.Start
            Right -> Arrangement.End
            Center -> Arrangement.Center
            Justify -> Arrangement.Start
            Start -> Arrangement.Start
            End -> Arrangement.End
            Unspecified -> Arrangement.Start
            else -> Arrangement.Start
        }
    }

    internal const val isMarkDown: Boolean = true
    internal val maxLines: Int = Int.MAX_VALUE
    internal val overflow: TextOverflow = TextOverflow.Clip
    internal val softWrap: Boolean = true
    internal val minLines: Int = 1
}