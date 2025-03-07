package com.zomato.sushi.compose.atoms.indicators

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zomato.sushi.compose.atoms.indicators.model.DotGraphic
import com.zomato.sushi.compose.modifiers.ifNonNull

/**
 * @author gupta.anirudh@zomato.com
 */
@Composable
internal fun Dot(
    graphic: DotGraphic,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(
                color = graphic.color,
                shape = graphic.shape,
            )
            .size(graphic.size)
            .ifNonNull(graphic.borderWidth) {
                this.border(
                    width = it,
                    color = graphic.borderColor,
                    shape = graphic.shape
                )
            }
    )
}