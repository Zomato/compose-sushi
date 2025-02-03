package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.State

/**
 * @author gupta.anirudh@zomato.com
 */
interface SushiButtonContentScope : RowScope {
    val isTapped: State<Boolean>
}