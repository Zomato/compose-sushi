package com.zomato.sushi.compose.components.bottomsheet

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * Properties for configuring a SushiBottomSheet component.
 *
 * This class defines the customization options available for bottom sheets in the Sushi design system,
 * including appearance properties like shape, colors, and elevation, as well as behavior properties
 * through the Material 3 ModalBottomSheetProperties.
 *
 * @property shape The shape of the bottom sheet, typically defining rounded corners at the top
 * @property containerColor The background color of the bottom sheet
 * @property contentColor The color of the text and other content in the bottom sheet
 * @property tonalElevation The elevation of the bottom sheet that affects its shadow and surface tint
 * @property properties Additional properties controlling the bottom sheet behavior,
 *                      such as scrim opacity and whether it's dismissible
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiBottomSheetProps @ExperimentalMaterial3Api constructor(
    val shape: Shape? = null,
    val containerColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val contentColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val tonalElevation: Dp? = null,
    val properties: ModalBottomSheetProperties? = null
)