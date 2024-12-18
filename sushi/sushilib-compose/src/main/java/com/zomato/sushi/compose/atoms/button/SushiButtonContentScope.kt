package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.State
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
interface SushiButtonContentScope : RowScope {
    val isTapped: State<Boolean>
}