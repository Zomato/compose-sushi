package com.zomato.sushi.compose.atoms.switch

import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiSwitchProps(
    val id: String? = null,
    val isChecked: Boolean? = null,
    val text: SushiTextProps? = null,
    val subText: SushiTextProps? = null,
    val isEnabled: Boolean? = null,
    val color: ColorSpec = SushiUnspecified.asColorSpec(),
    val padding: Dp? = null,
    val verticalAlignment: Alignment.Vertical? = null,
    val direction: SwitchDirection? = null,
)