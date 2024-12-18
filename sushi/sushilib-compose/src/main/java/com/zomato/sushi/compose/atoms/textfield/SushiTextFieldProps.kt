package com.zomato.sushi.compose.atoms.textfield

import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

/**
 * @author gupta.anirudh@zomato.com
 */
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