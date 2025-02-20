package com.zomato.sushi.compose.atoms.stepper

import androidx.compose.runtime.Composable
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiTheme

/**
 * Created by Nitin Kumar on 09/01/25.
 * Zomato, Gurgaon, India.
 */

@OptIn(ExperimentalSushiApi::class)
data class SushiStepperColorConfig(
    val textColor: ColorSpec,
    val positiveActionButtonColor: ColorSpec,
    val negativeActionButtonColor: ColorSpec,
    val borderColor: ColorSpec,
    val bgColor: ColorSpec,
    val maxCountPositiveActionButtonColor: ColorSpec? = null
) {
    companion object {
        @Composable
        fun defaults(): SushiStepperColorConfig {
            return SushiStepperColorConfig(
                textColor = SushiTheme.colors.red.v500,
                positiveActionButtonColor = SushiTheme.colors.red.v500,
                negativeActionButtonColor = SushiTheme.colors.red.v500,
                borderColor = SushiTheme.colors.red.v500,
                bgColor = SushiTheme.colors.red.v050
            )
        }

        @Composable
        fun disabled(): SushiStepperColorConfig {
            return SushiStepperColorConfig(
                textColor = SushiTheme.colors.grey.v500,
                positiveActionButtonColor = SushiTheme.colors.grey.v400,
                negativeActionButtonColor = SushiTheme.colors.grey.v400,
                borderColor = SushiTheme.colors.grey.v300,
                bgColor = SushiTheme.colors.grey.v100
            )
        }

        @Composable
        fun enabledNonZero(): SushiStepperColorConfig {
            return SushiStepperColorConfig(
                textColor = SushiTheme.colors.white,
                positiveActionButtonColor = SushiTheme.colors.white,
                negativeActionButtonColor = SushiTheme.colors.white,
                borderColor = SushiTheme.colors.stepper.primaryBackground,
                bgColor = SushiTheme.colors.stepper.primaryBackground
            )
        }

        @Composable
        fun enabledZero(): SushiStepperColorConfig {
            return SushiStepperColorConfig(
                textColor = SushiTheme.colors.stepper.primaryBackground,
                positiveActionButtonColor = SushiTheme.colors.stepper.primaryBackground,
                negativeActionButtonColor = SushiTheme.colors.stepper.primaryBackground,
                borderColor = SushiTheme.colors.stepper.primaryBackground,
                bgColor = SushiTheme.colors.stepper.secondaryBackground
            )
        }
    }
}
