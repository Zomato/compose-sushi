package com.zomato.sushi.compose.components.stepper

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import com.zomato.sushi.compose.atoms.text.SushiTextProps

/**
 * Properties for configuring a SushiStepper component.
 *
 * SushiStepper is a component that allows users to increment or decrement a value
 * through plus and minus buttons. These properties control its appearance and behavior.
 *
 * @property text The text to display in the stepper (usually a number)
 * @property count The current value of the stepper
 * @property maxCount The maximum allowed value
 * @property stepperSize The size variant of the stepper
 * @property stepperEnabledState Whether the stepper is enabled
 * @property colorConfig Custom color configuration for the stepper
 * @property shape Custom shape for the stepper container
 * @property disabledMessage Message to display when the stepper is disabled
 *
 * Created by Nitin Kumar on 08/01/25
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