@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.stepper

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.icon.SushiIconSize
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

/**
 * Created by Nitin Kumar on 09/01/25.
 * Zomato, Gurgaon, India.
 */

internal class StepperDefaults {
    data class Dimensions(val width: Dp, val height: Dp)

    companion object {
        private val stepperDimensions = hashMapOf(
            SushiStepperSize.Small to Dimensions(72.dp, 26.dp),
            SushiStepperSize.SmallV2 to Dimensions(82.dp, 30.dp),
            SushiStepperSize.Medium to Dimensions(90.dp, 32.dp),
            SushiStepperSize.Normal to Dimensions(120.dp, 40.dp),
            SushiStepperSize.Large to Dimensions(104.dp, 48.dp)
        )

        fun getDimensions(size: SushiStepperSize): Dimensions {
            return stepperDimensions[size] ?: Dimensions(120.dp, 40.dp)
        }

        fun getStepperIconSize(size: SushiStepperSize): SushiIconSize {
            return when (size) {
                SushiStepperSize.Small -> SushiIconSize.Size100
                SushiStepperSize.SmallV2 -> SushiIconSize.Size100
                SushiStepperSize.Medium -> SushiIconSize.Size100
                SushiStepperSize.Large -> SushiIconSize.Size500
                else -> SushiIconSize.Size300
            }
        }

        fun getStepperTextFontType(size: SushiStepperSize): SushiTextType {
            return when (size) {
                SushiStepperSize.Small -> SushiTextType.SemiBold300
                SushiStepperSize.SmallV2 -> SushiTextType.SemiBold400
                SushiStepperSize.Medium -> SushiTextType.SemiBold400
                SushiStepperSize.Large -> SushiTextType.SemiBold600
                else -> SushiTextType.Bold600
            }
        }

        fun getStepperTextFontSizeInDp(size: SushiStepperSize): Dp {
            return when (size) {
                SushiStepperSize.Small -> 13.dp
                SushiStepperSize.SmallV2 -> 15.dp
                SushiStepperSize.Medium -> 15.dp
                SushiStepperSize.Large -> 19.dp
                else -> 19.dp
            }
        }

        fun getDefaultTextForStepper(text: String?): String = text ?: "ADD"
    }
}
