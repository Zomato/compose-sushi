package com.zomato.sushi.compose.atoms.stepper

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import com.zomato.sushi.compose.atoms.text.SushiTextProps

/**
 * Created by Nitin Kumar on 08/01/25.
 * Zomato, Gurgaon, India.
 */
@Immutable
data class SushiStepperProps(
    val text: String? = null,
    val count: Int? = null,
    val maxCount: Int? = null,
    val stepperSize: SushiStepperSize? = null,
    val stepperEnabledState: Boolean? = null,
    val colorConfig: SushiStepperColorConfig? = null,
    val shape: Shape? = null,
    val disabledMessage: SushiTextProps? = null,
)