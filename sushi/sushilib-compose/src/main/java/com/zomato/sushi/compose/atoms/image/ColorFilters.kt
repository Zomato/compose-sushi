package com.zomato.sushi.compose.atoms.image

import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix

/**
 * @author gupta.anirudh@zomato.com
 *
 * @param percentage from 0 to 100, 0 means identity, 100 means entirely greyscale
 */
fun ColorFilter.Companion.grayscale(percentage: Int = 100): ColorFilter {
    val saturationPercentage = 100 - percentage.coerceIn(0, 100)
    val grayscaleMatrix = ColorMatrix().apply {
        setToSaturation(saturationPercentage.toFloat() / 100)
    }
    return ColorFilter.colorMatrix(grayscaleMatrix)
}