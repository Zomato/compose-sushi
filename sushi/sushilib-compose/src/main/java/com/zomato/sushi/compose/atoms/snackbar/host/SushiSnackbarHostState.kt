package com.zomato.sushi.compose.atoms.snackbar.host

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zomato.sushi.compose.atoms.snackbar.SushiSnackbar
import com.zomato.sushi.compose.atoms.snackbar.SushiSnackbarProps

class SushiSnackbarHostState : SushiBaseSnackbarHostState<SushiSnackbarProps>()

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