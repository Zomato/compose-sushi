package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase

/**
 * @author gupta.anirudh@zomato.com
 */
@Composable
fun SushiButton(
    props: SushiButtonProps,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: (@Composable SushiButtonContentScope.() -> Unit)? = null
) {
    SushiComponentBase(
        modifier
            .testTag("SushiButton")
            .width(IntrinsicSize.Max)
            .height(IntrinsicSize.Max)
    ) {
        SushiButtonImpl(
            props,
            onClick = onClick,
            Modifier.fillMaxSize(),
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
    val type = with(SushiButtonDefaults) { props.typeOrDefault }
    Box(modifier) {
        when (type) {
            SushiButtonType.Text -> {
                SushiTextButton(
                    props = props,
                    onClick = onClick,
                    Modifier.fillMaxSize(),
                    content = content
                )
            }
            SushiButtonType.Solid -> {
                SushiSolidButton(
                    props = props,
                    onClick = onClick,
                    Modifier.fillMaxSize(),
                    content = content
                )
            }
            SushiButtonType.Outline -> {
                SushiOutlineButton(
                    props = props,
                    onClick = onClick,
                    Modifier.fillMaxSize(),
                    content = content
                )
            }
        }
    }
}