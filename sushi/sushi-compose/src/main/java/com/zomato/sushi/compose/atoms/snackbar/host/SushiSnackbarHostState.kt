package com.zomato.sushi.compose.atoms.snackbar.host

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zomato.sushi.compose.atoms.snackbar.SushiSnackbar
import com.zomato.sushi.compose.atoms.snackbar.SushiSnackbarProps

/**
 * State holder for SushiSnackbar components.
 *
 * This class extends the base snackbar host state with specific support for
 * SushiSnackbarProps, allowing the display and management of SushiSnackbar instances.
 */
class SushiSnackbarHostState : SushiBaseSnackbarHostState<SushiSnackbarProps>()

/**
 * A snackbar host component specifically designed for SushiSnackbar components.
 *
 * This composable provides a convenient wrapper around the generic SushiSnackbarHost
 * with defaults appropriate for SushiSnackbar components.
 *
 * @param hostState The state object that tracks which snackbar is currently visible
 * @param modifier The modifier to be applied to the snackbar host
 * @param snackbar A composable function that renders a snackbar given its properties.
 *                 Defaults to the standard SushiSnackbar implementation.
 */
@Composable
fun SushiSnackbarHost(
    hostState: SushiSnackbarHostState,
    modifier: Modifier = Modifier,
    snackbar: @Composable (SushiSnackbarProps) -> Unit = { SushiSnackbar(it) }
) {
    SushiSnackbarHost<SushiSnackbarProps>(
        hostState = hostState,
        modifier = modifier,
        snackbar = snackbar
    )
}