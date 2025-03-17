package com.zomato.sushi.compose.atoms.checkbox

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme

/**
 * Provides default values and utility functions for SushiCheckBox components.
 * These defaults are used when specific properties are not provided in SushiCheckBoxProps.
 *
 * @author gupta.anirudh@zomato.com
 */
object SushiCheckBoxDefaults {
    /**
     * Default size for the checkbox component in DP.
     */
    public val checkBoxSize = 21.dp
    
    /**
     * Default padding around the checkbox component.
     * Uses theme spacing for consistency.
     */
    public val padding @Composable get() = SushiTheme.dimens.spacing.macro
    
    /**
     * Extension property to get the appropriate text style based on checkbox size.
     * Mini checkboxes use smaller text, while Default size uses standard text.
     */
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