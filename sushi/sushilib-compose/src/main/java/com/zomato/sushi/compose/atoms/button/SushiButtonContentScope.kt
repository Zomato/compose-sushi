package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.layout.RowScope
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

@ExperimentalSushiApi
interface SushiButtonContentScope : RowScope {
    val isTapped: Boolean
    val isDisabled: Boolean
}