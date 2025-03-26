package com.zomato.sushi.compose.atoms.image

import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix

/**
 * Extension function to create a grayscale color filter with adjustable intensity.
 * 
 * This filter can be used to convert images to grayscale (black and white) with
 * control over how much of the original color is preserved.
 *
 * @param percentage The grayscale intensity from 0 to 100:
 *  - 0: Original colors (no grayscale effect)
 *  - 100: Complete grayscale (fully black and white)
 * Values between 0-100 create a blend between color and grayscale
 * 
 * @return A ColorFilter that applies the grayscale effect
 *
 * @author gupta.anirudh@zomato.com
 */
fun ColorFilter.Companion.grayscale(percentage: Int = 100): ColorFilter {
    val saturationPercentage = 100 - percentage.coerceIn(0, 100)
    val grayscaleMatrix = ColorMatrix().apply {
        setToSaturation(saturationPercentage.toFloat() / 100)
    }
    return ColorFilter.colorMatrix(grayscaleMatrix)
}