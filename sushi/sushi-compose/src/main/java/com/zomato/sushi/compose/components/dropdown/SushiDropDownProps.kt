package com.zomato.sushi.compose.components.dropdown

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.window.PopupProperties
import com.zomato.sushi.compose.atoms.checkbox.SushiCheckBoxProps
import com.zomato.sushi.compose.atoms.radio.SushiRadioButtonProps
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import kotlinx.collections.immutable.ImmutableList

/**
 * @author gupta.anirudh@zomato.com
 *
 * SushiDropDown provides a dropdown menu that can display a list of items with various
 * representations (text, checkbox, radio button). These properties control the appearance
 * and behavior of the dropdown.
 *
 * @property expanded Whether the dropdown menu is currently shown
 * @property offset Position offset from the anchor position
 * @property properties Additional popup properties (e.g., focusability, dismiss behavior)
 * @property shape The shape of the dropdown menu container
 * @property containerColor The background color of the dropdown menu
 * @property tonalElevation When using surface color, this affects the overlay color intensity
 * @property shadowElevation The elevation that determines the size of the shadow
 * @property border Optional border to draw around the dropdown
 * @property items List of items to display in the dropdown menu
 *
 * @author gupta.anirudh@zomato.com
 */
@Immutable
data class SushiDropDownProps(
    val expanded: Boolean? = null,
    val offset: DpOffset? = null,
    val properties: PopupProperties? = null,
    val shape: Shape? = null,
    val containerColor: Color? = null,
    val tonalElevation: Dp? = null,
    val shadowElevation: Dp? = null,
    val border: BorderStroke? = null,
    val items: ImmutableList<DropDownItem>? = null,
) {
    /**
     * Represents the different types of items that can be displayed in a dropdown menu.
     * 
     * This sealed interface allows for a type-safe way to define dropdown items with
     * different appearances and behaviors.
     */
    @Immutable
    sealed interface DropDownItem {
        /**
         * A simple text item in the dropdown menu.
         * 
         * @property props The text properties for the item
         */
        @Immutable
        data class TextItem(
            val props: SushiTextProps
        ) : DropDownItem

        /**
         * A checkbox item in the dropdown menu.
         * 
         * @property props The checkbox properties for the item
         */
        @Immutable
        data class CheckBoxItem(
            val props: SushiCheckBoxProps
        ) : DropDownItem

        /**
         * A radio button item in the dropdown menu.
         * 
         * @property props The radio button properties for the item
         */
        @Immutable
        data class RadioButtonItem(
            val props: SushiRadioButtonProps
        ) : DropDownItem
    }

    /**
     * Represents the different events that can occur when interacting with dropdown items.
     * 
     * These events are dispatched when users interact with different types of dropdown items,
     * allowing for appropriate handling of each interaction type.
     */
    sealed interface DropDownEvent {
        /**
         * Event fired when a checkbox item's checked state changes.
         * 
         * @property props The checkbox properties associated with the event
         */
        data class OnCheckChanged(
            val props: SushiCheckBoxProps
        ) : DropDownEvent

        /**
         * Event fired when a radio button item's selected state changes.
         * 
         * @property props The radio button properties associated with the event
         */
        data class OnRadioButtonCheckChanged(
            val props: SushiRadioButtonProps
        ) : DropDownEvent

        /**
         * Event fired when a text item is clicked.
         * 
         * @property props The text properties associated with the event
         */
        data class OnTextItemClicked(
            val props: SushiTextProps
        ) : DropDownEvent
    }
}