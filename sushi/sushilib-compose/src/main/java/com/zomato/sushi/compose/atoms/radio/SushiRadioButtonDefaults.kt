package com.zomato.sushi.compose.atoms.radio

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme

/**
 * Provides default values and utility functions for SushiRadioButton components.
 * These defaults are used when specific properties are not provided in SushiRadioButtonProps.
 *
 * @author gupta.anirudh@zomato.com
 */
object SushiRadioButtonDefaults {
    /**
     * Default size for the radio button component in DP.
     */
    public val radioButtonSize = 21.dp
    
    /**
     * Default padding around the radio button component.
     * Uses theme spacing for consistency.
     */
    public val padding @Composable get() = SushiTheme.dimens.spacing.macro
    
    /**
     * Default text style for labels associated with radio buttons.
     */
    public val textType = SushiTextType.Regular300

    internal const val isSelected = false
    internal const val isEnabled = true
    internal val verticalAlignment = Alignment.Top
    internal val direction = RadioButtonDirection.Start
}