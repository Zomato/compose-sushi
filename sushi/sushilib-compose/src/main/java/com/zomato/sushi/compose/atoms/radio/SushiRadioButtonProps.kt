package com.zomato.sushi.compose.atoms.radio

import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.text.SushiTextProps

@ExperimentalSushiApi
@Immutable
data class SushiRadioButtonProps(
    val id: String? = Default.id,
    val isSelected: Boolean? = Default.isSelected,
    val text: SushiTextProps? = Default.text,
    val isEnabled: Boolean? = Default.isEnabled,
    val unselectedColor: ColorSpec? = Default.unselectedColor,
    val selectedColor: ColorSpec? = Default.selectedColor,
    val padding: Dp? = Default.padding,
    val alignment: Alignment.Vertical? = Default.alignment,
    val direction: RadioButtonDirection? = Default.direction
) {
    companion object {
        val Default = SushiRadioButtonProps(
            id = null,
            isSelected = null,
            text = null,
            isEnabled = null,
            unselectedColor = null,
            selectedColor = null,
            padding = null,
            alignment = null,
            direction = null
        )
    }
}