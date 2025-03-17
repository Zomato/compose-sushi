package com.zomato.sushi.compose.components.stepper

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.icon.SushiIconSize
import com.zomato.sushi.compose.atoms.text.SushiTextType

/**
 * Provides default values and utility functions for SushiStepper components.
 * These defaults determine the dimensions, text styles, and icon sizes for different stepper sizes.
 *
 * Created by Nitin Kumar on 09/01/25
 * Zomato, Gurgaon, India.
 */

object StepperDefaults {
    internal data class Dimensions(val width: Dp, val height: Dp)

    private val stepperDimensions = hashMapOf(
        SushiStepperSize.Small to Dimensions(72.dp, 26.dp),
        SushiStepperSize.SmallV2 to Dimensions(82.dp, 30.dp),
        SushiStepperSize.Medium to Dimensions(90.dp, 32.dp),
        SushiStepperSize.Normal to Dimensions(120.dp, 40.dp),
        SushiStepperSize.Large to Dimensions(104.dp, 48.dp)
    )

    internal fun getDimensions(size: SushiStepperSize): Dimensions {
        return stepperDimensions[size] ?: Dimensions(120.dp, 40.dp)
    }

    /**
     * Gets the appropriate icon size for the specified stepper size.
     *
     * @param size The stepper size variant
     * @return The icon size specification for the stepper
     */
    fun getStepperIconSize(size: SushiStepperSize): SushiIconSize {
        return when (size) {
            SushiStepperSize.Small -> SushiIconSize.Size100
            SushiStepperSize.SmallV2 -> SushiIconSize.Size100
            SushiStepperSize.Medium -> SushiIconSize.Size100
            SushiStepperSize.Large -> SushiIconSize.Size500
            else -> SushiIconSize.Size300
        }
    }

    /**
     * Gets the appropriate text font type for the specified stepper size.
     *
     * @param size The stepper size variant
     * @return The text type specification for the stepper
     */
    fun getStepperTextFontType(size: SushiStepperSize): SushiTextType {
        return when (size) {
            SushiStepperSize.Small -> SushiTextType.SemiBold300
            SushiStepperSize.SmallV2 -> SushiTextType.SemiBold400
            SushiStepperSize.Medium -> SushiTextType.SemiBold400
            SushiStepperSize.Large -> SushiTextType.SemiBold600
            else -> SushiTextType.Bold600
        }
    }

    internal fun getStepperTextFontSizeInDp(size: SushiStepperSize): Dp {
        return when (size) {
            SushiStepperSize.Small -> 13.dp
            SushiStepperSize.SmallV2 -> 15.dp
            SushiStepperSize.Medium -> 15.dp
            SushiStepperSize.Large -> 19.dp
            else -> 19.dp
        }
    }

    /**
     * Gets the default text to display in a stepper, using the provided text or "ADD" as fallback.
     *
     * @param text The text to use if not null
     * @return The text to display in the stepper
     */
    fun getDefaultTextForStepper(text: String?): String = text ?: "ADD"
}
