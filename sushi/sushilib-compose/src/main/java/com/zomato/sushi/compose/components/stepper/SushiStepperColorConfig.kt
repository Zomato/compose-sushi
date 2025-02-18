package com.zomato.sushi.compose.components.stepper

import androidx.compose.runtime.Composable
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * Created by Nitin Kumar on 09/01/25.
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
