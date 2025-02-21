package com.zomato.sushi.compose.components.dropdown

import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.zomato.sushi.compose.atoms.checkbox.SushiCheckBox
import com.zomato.sushi.compose.atoms.checkbox.SushiCheckBoxProps
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.atoms.radio.SushiRadioButton
import com.zomato.sushi.compose.atoms.radio.SushiRadioButtonProps
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.components.dropdown.SushiDropDownProps.DropDownEvent.OnCheckChanged
import com.zomato.sushi.compose.components.dropdown.SushiDropDownProps.DropDownEvent.OnRadioButtonCheckChanged
import com.zomato.sushi.compose.components.dropdown.SushiDropDownProps.DropDownEvent.OnTextItemClicked
import com.zomato.sushi.compose.components.dropdown.SushiDropDownProps.DropDownItem.CheckBoxItem
import com.zomato.sushi.compose.components.dropdown.SushiDropDownProps.DropDownItem.RadioButtonItem
import com.zomato.sushi.compose.components.dropdown.SushiDropDownProps.DropDownItem.TextItem
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.foundation.isDarkMode
import com.zomato.sushi.compose.internal.SushiPreview
import kotlinx.collections.immutable.persistentListOf

/**
 * @author gupta.anirudh@zomato.com
 */
@Composable
fun SushiDropDown(
    props: SushiDropDownProps,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
    onEvent: (index: Int, event: SushiDropDownProps.DropDownEvent) -> Unit = { _, _ -> },
    content: (@Composable ColumnScope.() -> Unit)? = null
) {
    if ((!props.items.isNullOrEmpty() || content != null)) {
        SushiComponentBase(
            modifier
                .testTag("SushiDropDown")
        ) {
            SushiDropDownImpl(
                props = props,
                onDismissRequest = onDismissRequest,
                scrollState = scrollState,
                modifier = Modifier,
                onEvent = onEvent,
                content = content
            )
        }
    }
}

@Composable
private fun SushiDropDownImpl(
    props: SushiDropDownProps,
    onDismissRequest: () -> Unit,
    scrollState: ScrollState,
    modifier: Modifier = Modifier,
    onEvent: (index: Int, event: SushiDropDownProps.DropDownEvent) -> Unit = { _, _ -> },
    content: (@Composable ColumnScope.() -> Unit)? = null
) {
    val expanded = props.expanded ?: true
    val offset = props.offset ?: DpOffset.Zero
    val popupProperties = props.properties ?: PopupProperties(focusable = true)
    val shape = props.shape ?: RoundedCornerShape(4.0.dp)
    val containerColor = props.containerColor ?: SushiTheme.colors.surface.primary.value
    val tonalElevation = props.tonalElevation ?: 0.dp
    val shadowElevation = props.tonalElevation ?: 3.dp
    val border = props.border

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        offset = offset,
        scrollState = scrollState,
        properties = popupProperties,
        shape = shape,
        containerColor = containerColor,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
        border = border
    ) {
        if (content != null) {
            content()
        } else {
            props.items?.forEachIndexed { idx, dropDownItem ->
                SushiDropDownItem(
                    item = dropDownItem,
                    onEvent = { event ->
                        onEvent(idx, event)
                    }
                )
            }
        }
    }
}

@Composable
fun SushiDropDownItem(
    item: SushiDropDownProps.DropDownItem,
    modifier: Modifier = Modifier,
    onEvent: (event: SushiDropDownProps.DropDownEvent) -> Unit
) {
    Box(modifier) {
        when (item) {
            is CheckBoxItem -> {
                SushiCheckBox(
                    item.props,
                    onCheckedChange = {
                        onEvent(
                            OnCheckChanged(
                                item.props
                            )
                        )
                    },
                    Modifier.padding(horizontal = 10.dp)
                )
            }
            is RadioButtonItem -> {
                SushiRadioButton(
                    item.props,
                    onClick = {
                        onEvent(
                            OnRadioButtonCheckChanged(
                                item.props
                            )
                        )
                    },
                    Modifier.padding(horizontal = 10.dp)
                )
            }
            is TextItem -> {
                SushiText(
                    item.props,
                    Modifier.clickable {
                        onEvent(
                            OnTextItemClicked(
                                item.props
                            )
                        )
                    }.padding(10.dp)
                )
            }
        }
    }
}

@Composable
@SushiPreview
private fun SushiDropDownPreview1() {
    SushiPreview {
        Column {
            val context = LocalContext.current
            var isShowing by remember { mutableStateOf(false) }
            SushiText(
                SushiTextProps("Click for DropDown (Is Dark Mode: ${SushiTheme.isDarkMode})"),
                Modifier
                    .clickable {
                        isShowing = !isShowing
                    }
            )
            var items by remember {
                mutableStateOf(
                    persistentListOf(
                        TextItem(SushiTextProps(text = "Text Option 1")),
                        TextItem(SushiTextProps(text = "Text Option 2")),
                        TextItem(SushiTextProps(text = "Text Option 3")),
                        TextItem(SushiTextProps(text = "Text Option 4")),
                        TextItem(SushiTextProps(text = "Text Option 5")),
                        RadioButtonItem(SushiRadioButtonProps(text = SushiTextProps(text = "Radio Option 1"))),
                        RadioButtonItem(SushiRadioButtonProps(text = SushiTextProps(text = "Radio Option 2"))),
                        RadioButtonItem(SushiRadioButtonProps(text = SushiTextProps(text = "Radio Option 3"))),
                        CheckBoxItem(SushiCheckBoxProps(text = SushiTextProps(text = "Checkbox Option 1"))),
                        CheckBoxItem(SushiCheckBoxProps(text = SushiTextProps(text = "Checkbox Option 2"))),
                        CheckBoxItem(SushiCheckBoxProps(text = SushiTextProps(text = "Checkbox Option 3")))
                    )
                )
            }
            if (isShowing) {
                SushiDropDown(
                    SushiDropDownProps(
                        expanded = true,
                        offset = DpOffset.Zero,
                        properties = PopupProperties(focusable = true),
                        shape = RoundedCornerShape(4.0.dp),
                        containerColor = SushiTheme.colors.surface.primary.value,
                        tonalElevation = 0.dp,
                        shadowElevation = 3.dp,
                        items = items,
                    ),
                    onDismissRequest = {
                        Toast.makeText(context, "onDismissRequest", Toast.LENGTH_SHORT).show()
                        isShowing = false
                    },
                    onEvent = { idx, event ->
                        when (event) {
                            is OnCheckChanged -> {
                                Toast.makeText(context, "checkbox event at idx: $idx", Toast.LENGTH_SHORT).show()
                                items = items.set(idx, CheckBoxItem(event.props.copy(checked = event.props.checked?.not() ?: true)))
                            }
                            is OnRadioButtonCheckChanged -> {
                                Toast.makeText(context, "radiobutton event at idx: $idx", Toast.LENGTH_SHORT).show()
                                items = items.set(idx, RadioButtonItem(event.props.copy(selected = event.props.selected?.not() ?: true)))
                            }
                            is OnTextItemClicked -> {
                                Toast.makeText(context, "text event at idx: $idx", Toast.LENGTH_SHORT).show()
                                isShowing = false
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
@SushiPreview
private fun SushiDropDownPreview2() {
    SushiPreview {
        Column {
            val context = LocalContext.current
            var isShowing by remember { mutableStateOf(false) }
            SushiText(
                SushiTextProps("Click for DropDown (Is Dark Mode: ${SushiTheme.isDarkMode})"),
                Modifier
                    .clickable {
                        isShowing = !isShowing
                    }
            )
            var items by remember {
                mutableStateOf(
                    persistentListOf(
                        TextItem(SushiTextProps(text = "Text Option 1")),
                        TextItem(SushiTextProps(text = "Text Option 2")),
                        TextItem(SushiTextProps(text = "Text Option 3")),
                        TextItem(SushiTextProps(text = "Text Option 4")),
                        TextItem(SushiTextProps(text = "Text Option 5")),
                        RadioButtonItem(SushiRadioButtonProps(text = SushiTextProps(text = "Radio Option 1"))),
                        RadioButtonItem(SushiRadioButtonProps(text = SushiTextProps(text = "Radio Option 2"))),
                        RadioButtonItem(SushiRadioButtonProps(text = SushiTextProps(text = "Radio Option 3"))),
                        CheckBoxItem(SushiCheckBoxProps(text = SushiTextProps(text = "Checkbox Option 1"))),
                        CheckBoxItem(SushiCheckBoxProps(text = SushiTextProps(text = "Checkbox Option 2"))),
                        CheckBoxItem(SushiCheckBoxProps(text = SushiTextProps(text = "Checkbox Option 3")))
                    )
                )
            }
            if (isShowing) {
                SushiDropDown(
                    SushiDropDownProps(
                        expanded = true,
                        offset = DpOffset.Zero,
                        properties = PopupProperties(focusable = true),
                        shape = RoundedCornerShape(4.0.dp),
                        containerColor = SushiTheme.colors.surface.primary.value,
                        tonalElevation = 0.dp,
                        shadowElevation = 3.dp,
                        items = items,
                    ),
                    onDismissRequest = {
                        Toast.makeText(context, "onDismissRequest", Toast.LENGTH_SHORT).show()
                        isShowing = false
                    }
                ) {
                    Column(
                        Modifier.background(Brush.linearGradient(listOf(Color.Red, Color.Blue, Color.Green).map { it.copy(alpha = 0.6f) }))
                    ) {
                        items.forEachIndexed { idx, dropDownItem ->
                            SushiDropDownItem(
                                dropDownItem,
                                onEvent = { event ->
                                    when (event) {
                                        is OnCheckChanged -> {
                                            Toast.makeText(context, "checkbox event at idx: $idx", Toast.LENGTH_SHORT).show()
                                            items = items.set(idx, CheckBoxItem(event.props.copy(checked = event.props.checked?.not() ?: true)))
                                        }
                                        is OnRadioButtonCheckChanged -> {
                                            Toast.makeText(context, "radiobutton event at idx: $idx", Toast.LENGTH_SHORT).show()
                                            items = items.set(idx, RadioButtonItem(event.props.copy(selected = event.props.selected?.not() ?: true)))
                                        }
                                        is OnTextItemClicked -> {
                                            Toast.makeText(context, "text event at idx: $idx", Toast.LENGTH_SHORT).show()
                                            isShowing = false
                                        }
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}