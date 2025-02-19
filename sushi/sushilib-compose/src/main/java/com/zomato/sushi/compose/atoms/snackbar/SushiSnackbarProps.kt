package com.zomato.sushi.compose.atoms.snackbar

import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.snackbar.host.SnackbarHostData
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.SushiUnspecified

/**
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

enum class SushiSnackbarDuration {
    Short,
    Long,
    Indefinite
}