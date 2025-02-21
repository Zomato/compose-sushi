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
 *
 *  @param expanded whether the menu is expanded or not
 *  @param onDismissRequest called when the user requests to dismiss the menu, such as by tapping
 *    outside the menu's bounds
 *  @param modifier [Modifier] to be applied to the menu's content
 *  @param offset [DpOffset] from the original position of the menu. The offset respects the
 *    [LayoutDirection], so the offset's x position will be added in LTR and subtracted in RTL.
 *  @param scrollState a [ScrollState] to used by the menu's content for items vertical scrolling
 *  @param properties [PopupProperties] for further customization of this popup's behavior
 *  @param shape the shape of the menu
 *  @param containerColor the container color of the menu
 *  @param tonalElevation when [containerColor] is [ColorScheme.surface], a translucent primary color
 *    overlay is applied on top of the container. A higher tonal elevation value will result in a
 *    darker color in light theme and lighter color in dark theme. See also: [Surface].
 *  @param shadowElevation the elevation for the shadow below the menu
 *  @param border the border to draw around the container of the menu. Pass `null` for no border.
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
    @Immutable
    sealed interface DropDownItem {
        @Immutable
        data class TextItem(
            val props: SushiTextProps
        ) : DropDownItem

        @Immutable
        data class CheckBoxItem(
            val props: SushiCheckBoxProps
        ) : DropDownItem

        @Immutable
        data class RadioButtonItem(
            val props: SushiRadioButtonProps
        ) : DropDownItem
    }

    sealed interface DropDownEvent {
        data class OnCheckChanged(
            val props: SushiCheckBoxProps
        ) : DropDownEvent

        data class OnRadioButtonCheckChanged(
            val props: SushiRadioButtonProps
        ) : DropDownEvent

        data class OnTextItemClicked(
            val props: SushiTextProps
        ) : DropDownEvent
    }
}