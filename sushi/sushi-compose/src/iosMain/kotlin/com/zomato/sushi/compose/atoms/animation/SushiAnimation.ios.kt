package com.zomato.sushi.compose.atoms.animation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.UIKitView
import platform.UIKit.UIView

// TODO: ios implementation to be added
@Composable
actual fun SushiAnimation(
    props: SushiAnimationProps,
    modifier: Modifier,
    state: SushiAnimationState,
    onClick: (() -> Unit)?
) {
    UIKitView(
        modifier = modifier,
        factory = {
            null as UIView
        }
    )
}