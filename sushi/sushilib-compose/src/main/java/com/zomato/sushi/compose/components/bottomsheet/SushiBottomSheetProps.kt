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