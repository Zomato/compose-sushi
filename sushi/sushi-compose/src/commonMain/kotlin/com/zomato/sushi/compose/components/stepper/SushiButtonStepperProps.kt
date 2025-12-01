
package com.zomato.sushi.compose.components.stepper

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import com.zomato.sushi.compose.atoms.icon.SushiIconCode
import com.zomato.sushi.compose.atoms.icon.SushiIconSize
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.text.SushiTextProps

/**
 * Properties for configuring a SushiButtonStepper component.
 *
 * SushiButtonStepper is a component that starts as an icon button and transforms
 * into a stepper when clicked. When the quantity reaches 0, it transforms back to
 * an icon button.
 *
 * @property count The current value of the stepper
 * @property maxCount The maximum allowed value
 * @property stepperSize The size variant of the stepper
 * @property stepperEnabledState Whether the stepper is enabled
 * @property colorConfig Custom color configuration for the stepper
 * @property shape Custom shape for the stepper container
 * @property disabledMessage Message to display when the stepper is disabled
 * @property iconCode The icon code to display in button mode (when count is 0)
 * @property iconSize The size of the icon in button mode
 * @property iconColor The color of the icon in button mode
 * @property buttonBackgroundColor The background color of the button
 * @property buttonBorderColor The border color of the button
 * @property buttonShape Custom shape for the button
 *
 * Created by AI Assistant
 */
@Immutable
data class SushiButtonStepperProps(
    val count: Int? = null,
    val maxCount: Int? = null,
    val stepperSize: SushiStepperSize? = null,
    val stepperEnabledState: Boolean? = null,
    val colorConfig: SushiStepperColorConfig? = null,
    val shape: Shape? = null,
    val disabledMessage: SushiTextProps? = null,
    val iconCode: SushiIconCode? = null,
    val iconSize: SushiIconSize? = null,
    val iconColor: ColorSpec? = null,
    val buttonBackgroundColor: ColorSpec? = null,
    val buttonBorderColor: ColorSpec? = null,
    val buttonShape: Shape? = null,
)
