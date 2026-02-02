package com.zomato.sushi.compose.atoms.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zomato.sushi.compose.layout.PassThroughBox

/**
 * @author gupta.anirudh@zomato.com
 */
@Composable
internal fun SushiComponentBase(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    PassThroughBox(modifier) {
        content()
    }
}
