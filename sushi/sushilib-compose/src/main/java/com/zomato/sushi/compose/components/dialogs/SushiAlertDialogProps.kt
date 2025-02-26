@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.components.dialogs

import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.image.SushiImageProps
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi

/**
 * Created by Piyush Maheswari on 07/01/25
 * Zomato, Gurgaon, India.
 **/
@Immutable
data class SushiAlertDialogProps(
    val id: String? = null,
    val image: SushiImageProps? = null,
    val title: SushiTextProps? = null,
    val subtitle: SushiTextProps? = null,
    val positiveButton: SushiButtonProps? = null,
    val negativeButton: SushiButtonProps? = null,
    val neutralButton: SushiButtonProps? = null,
    val alignment: ButtonAlignment? = null,
    val dismissOnBackPress: Boolean? = null,
    val dismissOnClickOutside: Boolean? = null
) {
    enum class ButtonAlignment {
        Vertical, Horizontal
    }
}
