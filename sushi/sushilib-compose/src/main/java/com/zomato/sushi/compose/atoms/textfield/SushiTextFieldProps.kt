package com.zomato.sushi.compose.atoms.textfield

import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

// todox: implement sushi text field
@ExperimentalSushiApi
@Immutable
data class SushiTextFieldProps(
    val d: Int = Default.d
) {
    companion object {
        val Default = SushiTextFieldProps(
            d = 1
        )
    }
}