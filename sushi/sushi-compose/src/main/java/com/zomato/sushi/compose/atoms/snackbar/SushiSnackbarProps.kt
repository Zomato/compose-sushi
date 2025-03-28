package com.zomato.sushi.compose.atoms.snackbar

import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.snackbar.host.SnackbarHostData
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
 * Properties for configuring a SushiSnackbar component.
 *
 * SushiSnackbar is a brief message shown at the bottom of the screen that provides feedback
 * about an operation, with optional action. These properties control the appearance
 * and behavior of the snackbar.
 *
 * @property message The main text message to display in the snackbar
 * @property containerColor The background color of the snackbar
 * @property contentColor The color of the text content
 * @property actionText The text for the optional action button
 * @property snackbarDuration Controls how long the snackbar remains visible
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiSnackbarProps(
    val message: SushiTextProps? = null,
    val containerColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val contentColor: ColorSpec = SushiUnspecified.asColorSpec(),
    val actionText: SushiTextProps? = null,
    override val snackbarDuration: SushiSnackbarDuration? = null
) : SnackbarHostData

/**
 * Defines the duration for which a snackbar should be displayed.
 * 
 * - Short: Displayed for a brief period (1500ms)
 * - Long: Displayed for a longer period (3500ms)
 * - Indefinite: Displayed until explicitly dismissed
 */
enum class SushiSnackbarDuration {
    Short,
    Long,
    Indefinite
}