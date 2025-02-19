package com.zomato.sushi.compose.atoms.snackbar.host

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.zomato.sushi.compose.atoms.snackbar.SushiSnackbarDuration
import kotlinx.coroutines.delay

abstract class SushiBaseSnackbarHostState<T : SnackbarHostData> {

    private val snackbarData: MutableState<T?> = mutableStateOf(null)

    val currentSnackbar: State<T?> = snackbarData
    val isShowing: Boolean get() = currentSnackbar.value != null

    suspend fun showSnackbar(data: T, defaultDuration: SushiSnackbarDuration = SushiSnackbarDuration.Short) {
        snackbarData.value = data
        when (data.snackbarDuration ?: defaultDuration) {
            SushiSnackbarDuration.Short -> {
                delay(1500)
                if (isShowing) {
                    snackbarData.value = null
                }
            }
            SushiSnackbarDuration.Long -> {
                delay(3500)
                if (isShowing) {
                    snackbarData.value = null
                }
            }
            SushiSnackbarDuration.Indefinite -> {
                Unit
            }
        }
    }

    suspend fun cancelSnackbar() {
        snackbarData.value = null
    }
}

interface SnackbarHostData {
    val snackbarDuration: SushiSnackbarDuration?
}

@Composable
fun <T : SnackbarHostData> SushiSnackbarHost(
    hostState: SushiBaseSnackbarHostState<T>,
    modifier: Modifier = Modifier,
    snackbar: @Composable (T) -> Unit
) {
    val snackbarData by hostState.currentSnackbar
    Box(modifier) {
        AnimatedVisibility(snackbarData != null) {
            var dataToDisplay by remember { mutableStateOf(snackbarData) }
            LaunchedEffect(snackbarData) {
                dataToDisplay = snackbarData ?: dataToDisplay
            }
            dataToDisplay?.let { snackbar(it) }
        }
    }
}