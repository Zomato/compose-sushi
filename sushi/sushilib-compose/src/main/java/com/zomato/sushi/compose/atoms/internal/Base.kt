package com.zomato.sushi.compose.atoms.internal

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun Base(
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    Box(modifier) {
        content()
    }
}
