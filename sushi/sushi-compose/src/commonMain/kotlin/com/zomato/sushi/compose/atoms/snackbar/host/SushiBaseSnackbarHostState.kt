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

/**
 * Base class for snackbar host state that manages displaying and dismissing snackbars.
 *
 * This abstract class provides the core logic for showing snackbars with different
 * durations and managing their visibility. It's designed to be extended for specific
 * snackbar host implementations.
 *
 * @param T The type of data to be displayed in the snackbar, must implement SnackbarHostData
 */
abstract class SushiBaseSnackbarHostState<T : SnackbarHostData> {

    private val snackbarData: MutableState<T?> = mutableStateOf(null)

    /**
     * The currently visible snackbar data, or null if no snackbar is visible.
     */
    val currentSnackbar: State<T?> = snackbarData
    
    /**
     * Whether a snackbar is currently being shown.
     */
    val isShowing: Boolean get() = currentSnackbar.value != null

    /**
     * Shows a snackbar with the given data and duration.
     *
     * This suspending function displays a snackbar and automatically dismisses it
     * after a period determined by the snackbar duration, unless the duration is set
     * to Indefinite, in which case the snackbar remains visible until explicitly dismissed.
     *
     * @param data The data to display in the snackbar
     * @param defaultDuration The default duration to use if not specified in the data
     */
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

    /**
     * Cancels the current snackbar and removes it from the screen.
     */
    suspend fun cancelSnackbar() {
        snackbarData.value = null
    }
}

/**
 * Interface for data that can be displayed in a snackbar host.
 *
 * This interface defines the minimum requirements for any data class 
 * that needs to be displayed in a SushiSnackbarHost. Implementations
 * should provide a duration value or accept the default.
 */
interface SnackbarHostData {
    /**
     * The duration for which the snackbar should be visible.
     * If null, the default duration provided to showSnackbar will be used.
     */
    val snackbarDuration: SushiSnackbarDuration?
}

/**
 * A generic snackbar host component that animates snackbars in and out of view.
 *
 * This composable manages the visibility of snackbars and ensures smooth transitions
 * between different snackbar states.
 *
 * @param hostState The state object that tracks which snackbar is currently visible
 * @param modifier The modifier to be applied to the snackbar host
 * @param snackbar A composable function that renders a specific snackbar given its data
 * @param T The type of data to be displayed in snackbars
 */
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