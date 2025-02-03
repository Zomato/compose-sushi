package com.zomato.sushi.compose.atoms.radio

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme

/**
 * @author gupta.anirudh@zomato.com
 */
object SushiRadioButtonDefaults {
    public val radioButtonSize = 21.dp
    public val padding @Composable get() = SushiTheme.dimens.spacing.macro
    public val textType = SushiTextType.Regular300

    internal const val isSelected = false
    internal const val isEnabled = true
    internal val verticalAlignment = Alignment.Top
    internal val direction = RadioButtonDirection.Start
}