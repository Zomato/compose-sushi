@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zomato.sushi.compose.atoms.internal.Base
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

@ExperimentalSushiApi
@Composable
fun SushiButton(
    props: SushiButtonProps,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: (@Composable SushiButtonContentScope.() -> Unit)? = null
) {
    Base(modifier) {
        SushiButtonImpl(
            props,
            onClick = onClick,
            content = content
        )
    }
}

@Composable
private fun SushiButtonImpl(
    props: SushiButtonProps,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: (@Composable SushiButtonContentScope.() -> Unit)? = null
) {
    val type = props.getButtonTypeWithDefaults()
    Box(modifier) {
        when (type) {
            SushiButtonType.Text -> {
                SushiTextButton(
                    props = props,
                    onClick = onClick,
                    content = content
                )
            }
            SushiButtonType.Solid -> {
                SushiSolidButton(
                    props = props,
                    onClick = onClick,
                    content = content
                )
            }
            SushiButtonType.Outline -> {
                SushiOutlineButton(
                    props = props,
                    onClick = onClick,
                    content = content
                )
            }
        }
    }
}