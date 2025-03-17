package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.State

/**
 * @author gupta.anirudh@zomato.com
 *
 * Scope interface for custom button content.
 * Extends RowScope to allow using Row-based layout components,
 * and provides information about the button's interaction state.
 *
 * @property isTapped State tracking whether the button is currently pressed
 */
interface SushiButtonContentScope : RowScope {
    val isTapped: State<Boolean>
}