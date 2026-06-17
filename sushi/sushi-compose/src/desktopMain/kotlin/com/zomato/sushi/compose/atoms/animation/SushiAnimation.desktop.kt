package com.zomato.sushi.compose.atoms.animation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// Desktop implementation - no animation support yet
@Composable
actual fun SushiAnimation(
    props: SushiAnimationProps,
    modifier: Modifier,
    state: SushiAnimationState,
    onClick: (() -> Unit)?
) {
    // TODO: desktop implementation to be added
}