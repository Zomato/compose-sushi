package com.zomato.sushi.compose.atoms.snackbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.atoms.snackbar.host.SushiSnackbarHost
import com.zomato.sushi.compose.atoms.snackbar.host.SushiSnackbarHostState
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.toast.ToastDuration
import com.zomato.sushi.compose.toast.rememberToastController
import com.zomato.sushi.compose.utils.takeIfSpecified
import kotlinx.coroutines.launch

/**
 * A composable that displays a snackbar message with an optional action.
 *
 * SushiSnackbar provides brief feedback about operations through a message at the
 * bottom of the screen. It can include an action button and customizable styling.
 * Snackbars are typically used to inform users of a process that an app has performed
 * or will perform, and provide an opportunity to respond or undo that action.
 *
 * @param props The properties to configure the snackbar's appearance and content
 * @param modifier The modifier to be applied to the component
 * @param onActionTap Callback invoked when the action button is clicked
 * @param content Optional custom content to replace the default snackbar layout
 *
 * @author gupta.anirudh@zomato.com
 */

@Composable
fun SushiSnackbar(
    props: SushiSnackbarProps,
    modifier: Modifier = Modifier,
    onActionTap: () -> Unit = {},
    content: (@Composable () -> Unit)? = null
) {
    if (props.message != null || content != null) {
        SushiComponentBase(
            modifier
                .testTag("SushiSnackbar")
                .width(IntrinsicSize.Max)
                .height(IntrinsicSize.Max)
        ) {
            SushiSnackbarImpl(
                props = props,
                Modifier.fillMaxSize(),
                onActionTap = onActionTap,
                content = content
            )
        }
    }
}

@Composable
private fun SushiSnackbarImpl(
    props: SushiSnackbarProps,
    modifier: Modifier = Modifier,
    onActionTap: () -> Unit = {},
    content: (@Composable () -> Unit)? = null
) {
    val message = props.message ?: SushiTextProps("")
    val containerColor = props.containerColor.takeIfSpecified() ?: SushiTheme.colors.surface.inverse
    val contentColor = props.contentColor.takeIfSpecified() ?: SushiTheme.colors.text.inverse

    val action = props.actionText?.let {
        it.copy(
            color = it.color.takeIfSpecified() ?: SushiTheme.colors.base.theme.v600
        )
    }

    Snackbar(
        modifier = modifier
            .clip(RoundedCornerShape(SushiTheme.dimens.spacing.large))
            .fillMaxSize(),
        containerColor = containerColor.value,
        contentColor = contentColor.value
    ) {
        if (content != null) {
            content()
        } else {
            SushiSnackbarContent(
                message = message.copy(color = message.color.takeIfSpecified() ?: contentColor),
                action = action,
                onActionTap = onActionTap
            )
        }
    }
}

@Composable
private fun SushiSnackbarContent(
    message: SushiTextProps,
    action: SushiTextProps?,
    onActionTap: () -> Unit
) {
    Row(
        Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SushiText(props = message)
        if (action != null) {
            SushiText(
                props = action,
                Modifier
                    .clickable {
                        onActionTap()
                    }
                    .padding(SushiTheme.dimens.spacing.mini)
            )
        }
    }
}

@SushiPreview
@Composable
private fun SushiSnackbarPreview1() {
    SushiPreview {
        val toastController = rememberToastController()
        val snackbarHostState: SushiSnackbarHostState by remember { mutableStateOf(SushiSnackbarHostState()) }
        val scope = rememberCoroutineScope()

        Scaffold(
            Modifier.fillMaxSize(),
            snackbarHost = {
                SushiSnackbarHost(
                    snackbarHostState,
                    snackbar = {
                        SushiSnackbar(
                            it,
                            Modifier.padding(10.dp),
                            onActionTap = {
                                scope.launch {
                                    toastController.show("hehe", ToastDuration.Long)
                                    snackbarHostState.cancelSnackbar()
                                }
                            },
                        )
                    }
                )
            }
        ) { innerPadding ->
            Surface(Modifier.padding(innerPadding)) {
                val snackBarData = SushiSnackbarProps(
                    message = SushiTextProps(text = "Item added to cart", color = SushiTheme.colors.text.inverse),
                    actionText = SushiTextProps("ActionX")
                )
                Button(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(snackBarData, SushiSnackbarDuration.Indefinite)
                        }
                    }
                ) {
                    Text("Click to Show Snackbar")
                }
            }
        }
    }
}