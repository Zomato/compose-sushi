package com.zomato.sushi.compose.atoms.animation

import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

@ExperimentalSushiApi
@Immutable
data class SushiAnimationData(
    val text: String = Default.text,
) {
    companion object {
        val Default = SushiAnimationData(
            text = "abc"
        )
    }
}