package com.zomato.sushi.compose.components.tooltip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipScope
import androidx.compose.material3.TooltipState
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupPositionProvider
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.image.SushiImage
import com.zomato.sushi.compose.atoms.image.SushiImageProps
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.components.tooltip.base.PlainTooltip
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.utils.takeIfSpecified
import composesushi.sushi_compose.generated.resources.Res
import composesushi.sushi_compose.generated.resources.sushi_rating_star
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource

/**
 * A wrapper around Material 3's TooltipBox that provides a consistent interface
 * for tooltip functionality within the Sushi design system.
 *
 * This composable handles the positioning and input behavior of tooltips, while
 * delegating visual appearance to SushiTooltip.
 *
 * @param positionProvider Provider that determines tooltip position relative to anchor
 * @param tooltip Tooltip content to be displayed when triggered
 * @param state State object that controls when the tooltip is shown or hidden
 * @param modifier Modifier to be applied to the tooltip container
 * @param focusable Whether the tooltip can receive focus
 * @param enableUserInput Whether user interactions can trigger the tooltip
 * @param content The anchor content that the tooltip will be attached to
 *
 * @author gupta.anirudh@zomato.com
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SushiTooltipBox(
    positionProvider: PopupPositionProvider,
    tooltip: @Composable TooltipScope.() -> Unit,
    state: TooltipState,
    modifier: Modifier = Modifier,
    focusable: Boolean = true,
    enableUserInput: Boolean = true,
    content: @Composable () -> Unit
) {
    TooltipBox(
        positionProvider = positionProvider,
        tooltip = tooltip,
        state = state,
        modifier = modifier,
        focusable = focusable,
        enableUserInput = enableUserInput,
        content = content,
    )
}

internal val SpacingBetweenTooltipAndAnchor = 4.dp
private val ContainerElevation = 3.dp

/**
 * A composable that displays a tooltip with customizable content, caret (pointer),
 * and styling based on the Sushi design system.
 *
 * The tooltip can contain text, prefix/suffix images, and supports a caret that
 * points to the anchor element. The tooltip's position is automatically adjusted
 * based on available screen space.
 *
 * This component must be used within a TooltipScope, typically provided by SushiTooltipBox.
 *
 * @param props The properties to configure the tooltip appearance and content
 * @param modifier The modifier to be applied to the tooltip
 * @param content Optional custom content to display inside the tooltip instead of the default
 *
 * @author gupta.anirudh@zomato.com
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TooltipScope.SushiTooltip(
    props: SushiTooltipProps,
    modifier: Modifier = Modifier,
    content: (@Composable () -> Unit)? = null,
) {
    val containerColor = props.containerColor?.takeIfSpecified()?.value ?: SushiTheme.colors.surface.inverse.value
    val shape = props.shape ?: RoundedCornerShape(12.dp)
    val caretShape = props.caretShape ?: SushiTooltipDefaults.caretShape()
    val shadowElevation = props.shadowElevation ?: ContainerElevation

    PlainTooltip(
        modifier = modifier,
        caretShape = caretShape,
        shape = shape,
        containerColor = containerColor,
        shadowElevation = shadowElevation
    ) {
        if (content != null) {
            content()
        } else {
            SushiTooltipDefaultContent(
                props = props
            )
        }
    }
}

@Composable
private fun SushiTooltipDefaultContent(
    props: SushiTooltipProps
) {
    Row(
        Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        if (props.prefixImage != null) {
            SushiImage(props.prefixImage)
        }
        if (props.text != null) {
            SushiText(props.text)
        }
        if (props.suffixImage != null) {
            SushiImage(props.suffixImage)
        }
    }
}

@SushiPreview
@Composable
private fun SushiToolTipPreview1() {
    SushiPreview {
        Box(Modifier
            .background(SushiTheme.colors.surface.primary.value)
            .fillMaxSize()
        ) {
            SushiToolTipButtonWithTooltipForPreview(
                Modifier.align(Alignment.TopStart)
            )
            SushiToolTipButtonWithTooltipForPreview(
                Modifier.align(Alignment.TopCenter)
            )
            SushiToolTipButtonWithTooltipForPreview(
                Modifier.align(Alignment.TopEnd)
            )
            SushiToolTipButtonWithTooltipForPreview(
                Modifier.align(Alignment.CenterStart)
            )
            SushiToolTipButtonWithTooltipForPreview(
                Modifier.align(Alignment.Center)
            )
            SushiToolTipButtonWithTooltipForPreview(
                Modifier.align(Alignment.CenterEnd)
            )
            SushiToolTipButtonWithTooltipForPreview(
                Modifier.align(Alignment.BottomStart)
            )
            SushiToolTipButtonWithTooltipForPreview(
                Modifier.align(Alignment.BottomCenter)
            )
            SushiToolTipButtonWithTooltipForPreview(
                Modifier.align(Alignment.BottomEnd)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SushiToolTipButtonWithTooltipForPreview(
    modifier: Modifier = Modifier
) {
    val state = rememberTooltipState(isPersistent = true)
    val scope = rememberCoroutineScope()
    Box(modifier) {
        SushiTooltipBox(
            positionProvider = SushiTooltipDefaults.rememberTooltipPositionProvider(
                TooltipAnchorPosition.Below
            ),
            tooltip = {
                SushiTooltip(
                    props = SushiTooltipProps(
                        text = SushiTextProps(
                            text = "Heya",
                            color = SushiTheme.colors.text.inverse
                        ),
                        prefixImage = SushiImageProps(
                            painterResource(Res.drawable.sushi_rating_star),
                            width = 25.dp,
                            contentDescription = "star",
                            contentScale = ContentScale.Fit,
                            aspectRatio = 1f,
                        ),
                        suffixImage = SushiImageProps(
                            painterResource(Res.drawable.sushi_rating_star),
                            width = 25.dp,
                            contentDescription = "star",
                            contentScale = ContentScale.Fit,
                            aspectRatio = 1f
                        )
                    )
                )
            },
            state = state
        ) {
            SushiButton(
                SushiButtonProps(text = "Button"),
                onClick = {
                    scope.launch {
                        state.show()
                    }
                }
            )
        }
    }
}