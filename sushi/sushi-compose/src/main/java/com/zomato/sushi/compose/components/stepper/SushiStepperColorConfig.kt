package com.zomato.sushi.compose.components.stepper

import androidx.compose.runtime.Composable
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * Defines the color configuration for a SushiStepper component.
 *
 * This class provides comprehensive control over all color aspects of the stepper,
 * including text, buttons, border, and background colors.
 *
 * @property textColor Color of the text in the stepper
 * @property positiveActionButtonColor Color of the increment (plus) button
 * @property negativeActionButtonColor Color of the decrement (minus) button
 * @property borderColor Color of the stepper's border
 * @property bgColor Background color of the stepper
 * @property maxCountPositiveActionButtonColor Color of the increment button when at maximum count
 *
 * Created by Nitin Kumar on 09/01/25
 * Zomato, Gurgaon, India.
 */

data class SushiStepperColorConfig(
    val textColor: ColorSpec,
    val positiveActionButtonColor: ColorSpec,
    val negativeActionButtonColor: ColorSpec,
    val borderColor: ColorSpec,
    val bgColor: ColorSpec,
    val maxCountPositiveActionButtonColor: ColorSpec
) {
    companion object {
        /**
         * Creates a default color configuration with red accent colors.
         * 
         * @return Default color configuration for steppers
         */
        @Composable
        fun defaults(): SushiStepperColorConfig {
            return SushiStepperColorConfig(
                textColor = SushiTheme.colors.red.v500,
                positiveActionButtonColor = SushiTheme.colors.red.v500,
                negativeActionButtonColor = SushiTheme.colors.red.v500,
                borderColor = SushiTheme.colors.red.v500,
                bgColor = SushiTheme.colors.red.v050,
                maxCountPositiveActionButtonColor = SushiUnspecified.asColorSpec()
            )
        }

        /**
         * Creates a color configuration for disabled steppers with gray tones.
         * 
         * @return Color configuration for disabled steppers
         */
        @Composable
        fun disabled(): SushiStepperColorConfig {
            return SushiStepperColorConfig(
                textColor = SushiTheme.colors.grey.v500,
                positiveActionButtonColor = SushiTheme.colors.grey.v400,
                negativeActionButtonColor = SushiTheme.colors.grey.v400,
                borderColor = SushiTheme.colors.grey.v300,
                bgColor = SushiTheme.colors.grey.v100,
                maxCountPositiveActionButtonColor = SushiUnspecified.asColorSpec()
            )
        }

        /**
         * Creates a color configuration for enabled steppers with non-zero values.
         * Uses inverted colors with white text on colored background.
         * 
         * @return Color configuration for enabled steppers with count > 0
         */
        @Composable
        fun enabledNonZero(): SushiStepperColorConfig {
            return SushiStepperColorConfig(
                textColor = SushiTheme.colors.white,
                positiveActionButtonColor = SushiTheme.colors.white,
                negativeActionButtonColor = SushiTheme.colors.white,
                borderColor = SushiTheme.colors.stepper.primaryBackground,
                bgColor = SushiTheme.colors.stepper.primaryBackground,
                maxCountPositiveActionButtonColor = SushiUnspecified.asColorSpec()
            )
        }

        /**
         * Creates a color configuration for enabled steppers with zero value.
         * Uses a lighter appearance with colored text on light background.
         * 
         * @return Color configuration for enabled steppers with count = 0
         */
        @Composable
        fun enabledZero(): SushiStepperColorConfig {
            return SushiStepperColorConfig(
                textColor = SushiTheme.colors.stepper.primaryBackground,
                positiveActionButtonColor = SushiTheme.colors.stepper.primaryBackground,
                negativeActionButtonColor = SushiTheme.colors.stepper.primaryBackground,
                borderColor = SushiTheme.colors.stepper.primaryBackground,
                bgColor = SushiTheme.colors.stepper.secondaryBackground,
                maxCountPositiveActionButtonColor = SushiUnspecified.asColorSpec()
            )
        }
    }
}
