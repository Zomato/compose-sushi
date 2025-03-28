package com.zomato.sushi.compose.components.dialogs

import androidx.compose.runtime.Immutable
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.image.SushiImageProps
import com.zomato.sushi.compose.atoms.text.SushiTextProps

/**
 * Properties for configuring a SushiAlertDialog component.
 *
 * SushiAlertDialog is a modal dialog that appears in front of app content to provide
 * critical information or ask for a decision. These properties control its appearance
 * and behavior.
 *
 * @property id Optional identifier for the dialog
 * @property image Optional image to display at the top of the dialog
 * @property title Optional title text displayed at the top of the dialog
 * @property subtitle Optional subtitle text displayed below the title
 * @property positiveButton Optional properties for the primary action button
 * @property negativeButton Optional properties for the secondary action button
 * @property neutralButton Optional properties for the tertiary action button
 * @property alignment How the buttons should be arranged (vertically or horizontally)
 * @property dismissOnBackPress Whether the dialog should dismiss when the back button is pressed
 * @property dismissOnClickOutside Whether the dialog should dismiss when clicked outside its bounds
 *
 * Created by Piyush Maheswari on 07/01/25
 * Zomato, Gurgaon, India.
 */
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
    /**
     * Defines how buttons should be arranged in the dialog.
     */
    enum class ButtonAlignment {
        /**
         * Buttons are arranged vertically (stacked), each taking the full width of the dialog.
         */
        Vertical,
        
        /**
         * Buttons are arranged horizontally (side by side) at the bottom of the dialog.
         */
        Horizontal
    }
}
