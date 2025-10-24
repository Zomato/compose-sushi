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
 *
 * A customizable button component that supports different visual styles, sizes,
 * and content configurations.
 *
 * SushiButton provides a standardized button implementation with support for:
 * - Different visual styles (Text, Solid, Outline)
 * - Various sizes (Small, Medium, Large)
 * - Prefix and suffix icons
 * - Custom content through the content parameter
 * - Accessibility through semantic properties
 *
 * @param props The properties to configure the button appearance and behavior
 * @param onClick Callback to be invoked when the button is clicked
 * @param modifier The modifier to be applied to the component
 * @param content Optional custom content to override the default button content rendering.
 *                When provided, gives access to the SushiButtonContentScope which includes
 *                layout information and the interaction state
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
            SushiButtonType.Underline -> {
                SushiTextButton(
                    props = props,
                    onClick = onClick,
                    Modifier.fillMaxSize(),
                    content = content
                )
            }
        }
    }
}