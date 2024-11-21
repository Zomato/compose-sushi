@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.animation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zomato.sushi.compose.atoms.internal.Base
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

@ExperimentalSushiApi
@Composable
fun SushiAnimation(
    data: SushiAnimationData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Base(modifier) {
        SushiAnimationImpl(
            data,
            onClick = onClick,
            modifier = modifier
        )
    }
}

@Composable
private fun SushiAnimationImpl(
    data: SushiAnimationData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

}

@Preview
@Composable
fun SushiAnimationPreview1() {
    Column {
        SushiAnimation(
            SushiAnimationData(
                text = "Asdf"
            ),
            onClick = {}
        )
    }
}