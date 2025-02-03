package com.zomato.sushi.compose.atoms.checkbox

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme

/**
 * @author gupta.anirudh@zomato.com
 */
object SushiCheckBoxDefaults {
    public val checkBoxSize = 21.dp
    public val padding @Composable get() = SushiTheme.dimens.spacing.macro
    public val SushiCheckBoxProps.textType get() = when(this.size) {
        SushiCheckboxSize.Mini -> SushiTextType.Regular100
        SushiCheckboxSize.Default -> SushiTextType.Regular300
        else -> SushiTextType.Regular300
    }

    internal const val isChecked = false
    internal const val isEnabled = true
    internal val verticalAlignment = Alignment.Top
    internal val direction = CheckBoxDirection.Start
}