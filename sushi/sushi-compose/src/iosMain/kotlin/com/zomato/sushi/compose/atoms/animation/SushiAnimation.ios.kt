package com.zomato.sushi.compose.atoms.animation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// TODO: ios implementation to be added
@Composable
actual fun SushiAnimation(
    props: SushiAnimationProps,
    modifier: Modifier,
    state: SushiAnimationState,
    onClick: (() -> Unit)?
) {
    Box(modifier = modifier)
}
