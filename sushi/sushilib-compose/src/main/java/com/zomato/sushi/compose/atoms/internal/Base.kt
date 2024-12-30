package com.zomato.sushi.compose.atoms.internal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * @author gupta.anirudh@zomato.com
 */
@Composable
internal fun Base(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(modifier) {
        content()
    }
}
