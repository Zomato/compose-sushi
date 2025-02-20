package com.zomato.sushi.compose.atoms.stepper.normal

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import com.zomato.sushi.compose.atoms.stepper.SushiStepperColorConfig
import com.zomato.sushi.compose.atoms.stepper.SushiStepperSize
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

/**
 * Created by Nitin Kumar on 08/01/25.
 * Zomato, Gurgaon, India.
 */
@ExperimentalSushiApi
@Immutable
data class SushiStepperProps(
    val text: String? = Default.text,
    val count: Int? = Default.count,
    val maxCount: Int? = Default.maxCount,
    val stepperSize: SushiStepperSize? = Default.stepperSize,
    val stepperEnabledState: Boolean? = Default.stepperEnabledState,
    val colorConfig: SushiStepperColorConfig? = Default.colorConfig,
    val shape: Shape? = Default.shape,
    val disabledMessage: SushiTextProps? = Default.disabledMessage
) {
    companion object {
        val Default = SushiStepperProps(
            text = null,
            count = null,
            maxCount = null,
            stepperSize = null,
            stepperEnabledState = null,
            colorConfig = null,
            shape = null,
            disabledMessage = null
        )
    }
}
