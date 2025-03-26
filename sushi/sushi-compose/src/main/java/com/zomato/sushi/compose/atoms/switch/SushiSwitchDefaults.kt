package com.zomato.sushi.compose.atoms.switch

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme

/**
 * Provides default values and utility functions for SushiSwitch components.
 * These defaults are used when specific properties are not provided in SushiSwitchProps.
 *
 * @author gupta.anirudh@zomato.com
 */
object SushiSwitchDefaults {
    /**
     * Default size for the switch component in DP.
     */
    public val switchSize = 21.dp
    
    /**
     * Default padding around the switch component.
     * Uses theme spacing for consistency.
     */
    public val padding @Composable get() = SushiTheme.dimens.spacing.extra
    
    /**
     * Default text style for labels associated with switches.
     */
    public val textType = SushiTextType.Regular300

    internal const val isChecked = false
    internal const val isEnabled = true
    internal val verticalAlignment = Alignment.Top
    internal val direction = SwitchDirection.Start
}