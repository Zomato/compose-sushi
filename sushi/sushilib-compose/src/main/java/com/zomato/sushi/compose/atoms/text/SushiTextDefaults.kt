package com.zomato.sushi.compose.atoms.text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.foundation.SushiTheme

@Immutable
object SushiTextDefaults {
    public val textType: TextTypeSpec = SushiTextType.Regular100
    public val textColor: ColorSpec @Composable get() = SushiTheme.colors.text.default
    public val prefixSpacing: Dp @Composable get() = SushiTheme.dimens.spacing.micro
    public val suffixSpacing: Dp @Composable get() = SushiTheme.dimens.spacing.micro

    internal const val isMarkDown: Boolean = true
    internal val maxLines: Int = Int.MAX_VALUE
    internal val overflow: TextOverflow = TextOverflow.Clip
    internal val softWrap: Boolean = true
    internal val minLines: Int = 1
}