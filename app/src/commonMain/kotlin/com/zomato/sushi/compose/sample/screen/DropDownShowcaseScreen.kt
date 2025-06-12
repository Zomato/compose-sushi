package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.checkbox.SushiCheckBoxProps
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCode
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.radio.SushiRadioButtonProps
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.components.dropdown.SushiDropDown
import com.zomato.sushi.compose.components.dropdown.SushiDropDownItem
import com.zomato.sushi.compose.components.dropdown.SushiDropDownProps
import com.zomato.sushi.compose.components.dropdown.SushiDropDownProps.DropDownItem
import com.zomato.sushi.compose.components.dropdown.SushiDropDownProps.DropDownEvent
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.serialization.Serializable

@Serializable
object DropDownShowcaseScreen

@Composable
fun DropDownShowcaseScreen(
    modifier: Modifier = Modifier
) {
    BaseScreen(modifier) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = SushiTheme.colors.surface.primary.value
        ) { innerPadding ->
            Column(
                Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {
                AppTopBar(
                    title = "DropDown Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                // 1. Basic Text Items Dropdown
                DropdownExample(
                    title = "1. Basic Text Items Dropdown",
                    description = "A simple dropdown with text items"
                ) { isExpanded, onDismiss ->
                    val items = remember {
                        persistentListOf(
                            DropDownItem.TextItem(SushiTextProps(text = "Option 1")),
                            DropDownItem.TextItem(SushiTextProps(text = "Option 2")),
                            DropDownItem.TextItem(SushiTextProps(text = "Option 3"))
                        )
                    }

                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            items = items
                        ),
                        onDismissRequest = onDismiss,
                        onEvent = { index, event ->
                            if (event is DropDownEvent.OnTextItemClicked) {
                                onDismiss()
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 2. Custom Offset Positioning
                DropdownExample(
                    title = "2. Custom Offset Positioning",
                    description = "Dropdown positioned with a custom offset"
                ) { isExpanded, onDismiss ->
                    val items = remember {
                        persistentListOf(
                            DropDownItem.TextItem(SushiTextProps(text = "Offset Option 1")),
                            DropDownItem.TextItem(SushiTextProps(text = "Offset Option 2")),
                            DropDownItem.TextItem(SushiTextProps(text = "Offset Option 3"))
                        )
                    }

                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            offset = DpOffset(20.dp, 10.dp), // Custom offset
                            items = items
                        ),
                        onDismissRequest = onDismiss,
                        onEvent = { _, _ -> onDismiss() }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 3. Non-Focusable Dropdown
                DropdownExample(
                    title = "3. Non-Focusable Dropdown",
                    description = "A dropdown that doesn't take focus"
                ) { isExpanded, onDismiss ->
                    val items = remember {
                        persistentListOf(
                            DropDownItem.TextItem(SushiTextProps(text = "Non-Focusable Item 1")),
                            DropDownItem.TextItem(SushiTextProps(text = "Non-Focusable Item 2")),
                            DropDownItem.TextItem(SushiTextProps(text = "Non-Focusable Item 3"))
                        )
                    }

                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            properties = PopupProperties(focusable = false),
                            items = items
                        ),
                        onDismissRequest = onDismiss,
                        onEvent = { _, _ -> onDismiss() }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 4. Custom Shape
                DropdownExample(
                    title = "4. Custom Shape",
                    description = "Dropdown with rounded corners"
                ) { isExpanded, onDismiss ->
                    val items = remember {
                        persistentListOf(
                            DropDownItem.TextItem(SushiTextProps(text = "Custom Shape Item 1")),
                            DropDownItem.TextItem(SushiTextProps(text = "Custom Shape Item 2")),
                            DropDownItem.TextItem(SushiTextProps(text = "Custom Shape Item 3"))
                        )
                    }

                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            shape = RoundedCornerShape(16.dp),
                            items = items
                        ),
                        onDismissRequest = onDismiss,
                        onEvent = { _, _ -> onDismiss() }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 5. Cut Corner Shape
                DropdownExample(
                    title = "5. Cut Corner Shape",
                    description = "Dropdown with cut corners"
                ) { isExpanded, onDismiss ->
                    val items = remember {
                        persistentListOf(
                            DropDownItem.TextItem(SushiTextProps(text = "Cut Corner Item 1")),
                            DropDownItem.TextItem(SushiTextProps(text = "Cut Corner Item 2")),
                            DropDownItem.TextItem(SushiTextProps(text = "Cut Corner Item 3"))
                        )
                    }

                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            shape = CutCornerShape(12.dp),
                            items = items
                        ),
                        onDismissRequest = onDismiss,
                        onEvent = { _, _ -> onDismiss() }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 6. Custom Container Color
                DropdownExample(
                    title = "6. Custom Container Color",
                    description = "Dropdown with a custom background color"
                ) { isExpanded, onDismiss ->
                    val items = remember {
                        persistentListOf(
                            DropDownItem.TextItem(SushiTextProps(
                                text = "Blue Background Item 1",
//                                color = Color.White
                            )),
                            DropDownItem.TextItem(SushiTextProps(
                                text = "Blue Background Item 2",
//                                color = Color.White
                            )),
                            DropDownItem.TextItem(SushiTextProps(
                                text = "Blue Background Item 3",
//                                color = Color.White
                            ))
                        )
                    }

                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            containerColor = SushiTheme.colors.blue.v700.value,
                            items = items
                        ),
                        onDismissRequest = onDismiss,
                        onEvent = { _, _ -> onDismiss() }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 7. Custom Elevation
                DropdownExample(
                    title = "7. Custom Elevation",
                    description = "Dropdown with custom shadow elevation"
                ) { isExpanded, onDismiss ->
                    val items = remember {
                        persistentListOf(
                            DropDownItem.TextItem(SushiTextProps(text = "Elevated Item 1")),
                            DropDownItem.TextItem(SushiTextProps(text = "Elevated Item 2")),
                            DropDownItem.TextItem(SushiTextProps(text = "Elevated Item 3"))
                        )
                    }

                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            tonalElevation = 8.dp,
                            shadowElevation = 12.dp,
                            items = items
                        ),
                        onDismissRequest = onDismiss,
                        onEvent = { _, _ -> onDismiss() }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 8. Dropdown with Border
                DropdownExample(
                    title = "8. Dropdown with Border",
                    description = "Dropdown with a custom border"
                ) { isExpanded, onDismiss ->
                    val items = remember {
                        persistentListOf(
                            DropDownItem.TextItem(SushiTextProps(text = "Bordered Item 1")),
                            DropDownItem.TextItem(SushiTextProps(text = "Bordered Item 2")),
                            DropDownItem.TextItem(SushiTextProps(text = "Bordered Item 3"))
                        )
                    }

                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            border = BorderStroke(
                                width = 2.dp,
                                color = SushiTheme.colors.base.theme.v500.value
                            ),
                            items = items
                        ),
                        onDismissRequest = onDismiss,
                        onEvent = { _, _ -> onDismiss() }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 9. Checkbox Items
                DropdownExample(
                    title = "9. Checkbox Items",
                    description = "Dropdown with checkbox items"
                ) { isExpanded, onDismiss ->
                    var checkboxItems by remember {
                        mutableStateOf(
                            listOf(
                                DropDownItem.CheckBoxItem(SushiCheckBoxProps(
                                    text = SushiTextProps(text = "Checkbox Option 1"),
                                    checked = false
                                )),
                                DropDownItem.CheckBoxItem(SushiCheckBoxProps(
                                    text = SushiTextProps(text = "Checkbox Option 2"),
                                    checked = true
                                )),
                                DropDownItem.CheckBoxItem(SushiCheckBoxProps(
                                    text = SushiTextProps(text = "Checkbox Option 3"),
                                    checked = false
                                ))
                            ).toImmutableList()
                        )
                    }

                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            items = checkboxItems
                        ),
                        onDismissRequest = onDismiss,
                        onEvent = { index, event ->
                            if (event is DropDownEvent.OnCheckChanged) {
                                val mutableList = checkboxItems.toMutableList()
                                val item = event.props.copy(checked = !(event.props.checked ?: false))
                                mutableList[index] = DropDownItem.CheckBoxItem(item)
                                checkboxItems = mutableList.toImmutableList()
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 10. Radio Button Items
                DropdownExample(
                    title = "10. Radio Button Items",
                    description = "Dropdown with radio button items"
                ) { isExpanded, onDismiss ->
                    var radioItems by remember {
                        mutableStateOf(
                            listOf(
                                DropDownItem.RadioButtonItem(SushiRadioButtonProps(
                                    text = SushiTextProps(text = "Radio Option 1"),
                                    selected = true
                                )),
                                DropDownItem.RadioButtonItem(SushiRadioButtonProps(
                                    text = SushiTextProps(text = "Radio Option 2"),
                                    selected = false
                                )),
                                DropDownItem.RadioButtonItem(SushiRadioButtonProps(
                                    text = SushiTextProps(text = "Radio Option 3"),
                                    selected = false
                                ))
                            ).toImmutableList()
                        )
                    }

                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            items = radioItems
                        ),
                        onDismissRequest = onDismiss,
                        onEvent = { index, event ->
                            if (event is DropDownEvent.OnRadioButtonCheckChanged) {
                                val mutableList = radioItems.toMutableList()
                                for (i in mutableList.indices) {
                                    val currentItem = mutableList[i]
                                    if (currentItem is DropDownItem.RadioButtonItem) {
                                        val newSelected = i == index
                                        mutableList[i] = DropDownItem.RadioButtonItem(
                                            currentItem.props.copy(selected = newSelected)
                                        )
                                    }
                                }
                                radioItems = mutableList.toImmutableList()
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 11. Mixed Item Types
                DropdownExample(
                    title = "11. Mixed Item Types",
                    description = "Dropdown with text, checkbox, and radio button items"
                ) { isExpanded, onDismiss ->
                    val mixedItems = remember {
                        persistentListOf(
                            DropDownItem.TextItem(SushiTextProps(text = "Text Header")),
                            DropDownItem.CheckBoxItem(SushiCheckBoxProps(
                                text = SushiTextProps(text = "Option 1"),
                                checked = false
                            )),
                            DropDownItem.CheckBoxItem(SushiCheckBoxProps(
                                text = SushiTextProps(text = "Option 2"),
                                checked = true
                            )),
                            DropDownItem.TextItem(SushiTextProps(text = "Select One:")),
                            DropDownItem.RadioButtonItem(SushiRadioButtonProps(
                                text = SushiTextProps(text = "Choice A"),
                                selected = true
                            )),
                            DropDownItem.RadioButtonItem(SushiRadioButtonProps(
                                text = SushiTextProps(text = "Choice B"),
                                selected = false
                            ))
                        )
                    }

                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            items = mixedItems
                        ),
                        onDismissRequest = onDismiss,
                        onEvent = { _, _ -> /* Handle events */ }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 12. Styled Text Items
                DropdownExample(
                    title = "12. Styled Text Items",
                    description = "Dropdown with styled text items"
                ) { isExpanded, onDismiss ->
                    val styledItems = persistentListOf(
                        DropDownItem.TextItem(SushiTextProps(
                            text = "Bold Red Item",
                            type = SushiTextType.Bold700,
                            color = SushiTheme.colors.red.v500
                        )),
                        DropDownItem.TextItem(SushiTextProps(
                            text = "Medium Blue Item",
                            type = SushiTextType.Medium500,
                            color = SushiTheme.colors.blue.v500
                        )),
                        DropDownItem.TextItem(SushiTextProps(
                            text = "Light Green Item",
                            type = SushiTextType.Light300,
                            color = SushiTheme.colors.green.v500
                        ))
                    )

                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            items = styledItems
                        ),
                        onDismissRequest = onDismiss,
                        onEvent = { _, _ -> onDismiss() }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 13. Custom Content Dropdown
                DropdownExample(
                    title = "13. Custom Content Dropdown",
                    description = "Dropdown with fully custom content"
                ) { isExpanded, onDismiss ->
                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded
                        ),
                        onDismissRequest = onDismiss,
                        content = {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                SushiText(
                                    props = SushiTextProps(
                                        text = "Custom Header",
                                        type = SushiTextType.Bold600
                                    )
                                )

                                HorizontalDivider(
                                    modifier = Modifier.padding(vertical = 8.dp),
                                    thickness = 1.dp,
                                    color = SushiTheme.colors.border.moderate.value
                                )

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(36.dp)
                                            .background(SushiTheme.colors.green.v200.value, CircleShape),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        SushiIcon(
                                            props = SushiIconProps(
                                                code = SushiIconCodes.IconCheck,
                                                color = SushiTheme.colors.green.v700
                                            )
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(8.dp))

                                    SushiText(
                                        props = SushiTextProps(
                                            text = "Custom Option 1",
                                            type = SushiTextType.Medium500
                                        )
                                    )
                                }

                                Spacer(modifier = Modifier.height(12.dp))

                                SushiButton(
                                    props = SushiButtonProps(text = "Close"),
                                    onClick = onDismiss,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 14. Large Item List with Scroll State
                DropdownExample(
                    title = "14. Large Item List with Scroll State",
                    description = "Dropdown with many items and custom scroll state"
                ) { isExpanded, onDismiss ->
                    val scrollState = rememberScrollState()
                    val largeItemList = remember {
                        (1..15).map {
                            DropDownItem.TextItem(SushiTextProps(text = "Item $it"))
                        }.toImmutableList()
                    }

                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            items = largeItemList
                        ),
                        scrollState = scrollState,
                        onDismissRequest = onDismiss,
                        onEvent = { _, _ -> onDismiss() }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 15. Color Swatch Dropdown
                DropdownExample(
                    title = "15. Color Swatch Dropdown",
                    description = "Dropdown for selecting colors"
                ) { isExpanded, onDismiss ->
                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded
                        ),
                        onDismissRequest = onDismiss,
                        content = {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                SushiText(
                                    props = SushiTextProps(
                                        text = "Select Color",
                                        type = SushiTextType.SemiBold600,
                                        textAlign = TextAlign.Center
                                    ),
                                    modifier = Modifier.fillMaxWidth()
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                val colors = listOf(
                                    "Red" to SushiTheme.colors.red.v500.value,
                                    "Blue" to SushiTheme.colors.blue.v500.value,
                                    "Green" to SushiTheme.colors.green.v500.value,
                                    "Yellow" to SushiTheme.colors.yellow.v500.value,
                                    "Purple" to SushiTheme.colors.purple.v500.value
                                )

                                colors.forEach { (name, color) ->
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable { onDismiss() }
                                            .padding(vertical = 8.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(24.dp)
                                                .background(color, CircleShape)
                                        )

                                        Spacer(modifier = Modifier.width(12.dp))

                                        SushiText(
                                            props = SushiTextProps(
                                                text = name,
                                                type = SushiTextType.Regular400
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 16. Dropdown with Gradient Background
                DropdownExample(
                    title = "16. Dropdown with Gradient Background",
                    description = "Dropdown with a gradient background using custom content"
                ) { isExpanded, onDismiss ->
                    val items = remember {
                        persistentListOf(
                            DropDownItem.TextItem(SushiTextProps(
                                text = "Gradient Item 1",
//                                color = Color.White
                            )),
                            DropDownItem.TextItem(SushiTextProps(
                                text = "Gradient Item 2",
//                                color = Color.White
                            )),
                            DropDownItem.TextItem(SushiTextProps(
                                text = "Gradient Item 3",
//                                color = Color.White
                            ))
                        )
                    }

                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded
                        ),
                        onDismissRequest = onDismiss,
                        content = {
                            Box(
                                modifier = Modifier
                                    .background(
                                        Brush.verticalGradient(
                                            colors = listOf(
                                                SushiTheme.colors.blue.v700.value,
                                                SushiTheme.colors.blue.v300.value
                                            )
                                        )
                                    )
                            ) {
                                Column {
                                    items.forEachIndexed { index, item ->
                                        SushiDropDownItem(
                                            item = item,
                                            onEvent = { event ->
                                                if (event is DropDownEvent.OnTextItemClicked) {
                                                    onDismiss()
                                                }
                                            },
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)
                                        )
                                    }
                                }
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 17. Non-Dismissible on Click Outside
                DropdownExample(
                    title = "17. Non-Dismissible on Click Outside",
                    description = "Dropdown that only dismisses with explicit action"
                ) { isExpanded, onDismiss ->
                    val items = remember {
                        persistentListOf(
                            DropDownItem.TextItem(SushiTextProps(text = "You must click an option")),
                            DropDownItem.TextItem(SushiTextProps(text = "Option 1")),
                            DropDownItem.TextItem(SushiTextProps(text = "Option 2")),
                            DropDownItem.TextItem(SushiTextProps(text = "Option 3"))
                        )
                    }

                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            properties = PopupProperties(
                                dismissOnClickOutside = false,
                                focusable = true
                            ),
                            items = items
                        ),
                        onDismissRequest = { /* Do nothing - can't dismiss by clicking outside */ },
                        onEvent = { index, event ->
                            if (event is DropDownEvent.OnTextItemClicked && index > 0) {
                                onDismiss()
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 18. Categorized Dropdown with Dividers
                DropdownExample(
                    title = "18. Categorized Dropdown with Dividers",
                    description = "Dropdown with categorized items and dividers"
                ) { isExpanded, onDismiss ->
                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded
                        ),
                        onDismissRequest = onDismiss,
                        content = {
                            Column(
                                modifier = Modifier.padding(vertical = 8.dp)
                            ) {
                                // Category 1
                                SushiText(
                                    props = SushiTextProps(
                                        text = "Sort By",
                                        type = SushiTextType.SemiBold600
                                    ),
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                                )

                                SushiDropDownItem(
                                    item = DropDownItem.TextItem(SushiTextProps(text = "Relevance")),
                                    onEvent = { onDismiss() }
                                )

                                SushiDropDownItem(
                                    item = DropDownItem.TextItem(SushiTextProps(text = "Rating")),
                                    onEvent = { onDismiss() }
                                )

                                HorizontalDivider(
                                    modifier = Modifier.padding(vertical = 8.dp),
                                    thickness = 1.dp,
                                    color = SushiTheme.colors.border.moderate.value
                                )

                                // Category 2
                                SushiText(
                                    props = SushiTextProps(
                                        text = "Price Range",
                                        type = SushiTextType.SemiBold600
                                    ),
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                                )

                                SushiDropDownItem(
                                    item = DropDownItem.TextItem(SushiTextProps(text = "Low to High")),
                                    onEvent = { onDismiss() }
                                )

                                SushiDropDownItem(
                                    item = DropDownItem.TextItem(SushiTextProps(text = "High to Low")),
                                    onEvent = { onDismiss() }
                                )

                                HorizontalDivider(
                                    modifier = Modifier.padding(vertical = 8.dp),
                                    thickness = 1.dp,
                                    color = SushiTheme.colors.border.moderate.value
                                )

                                // Category 3
                                SushiText(
                                    props = SushiTextProps(
                                        text = "Cuisines",
                                        type = SushiTextType.SemiBold600
                                    ),
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                                )

                                SushiDropDownItem(
                                    item = DropDownItem.TextItem(SushiTextProps(text = "Italian")),
                                    onEvent = { onDismiss() }
                                )

                                SushiDropDownItem(
                                    item = DropDownItem.TextItem(SushiTextProps(text = "Chinese")),
                                    onEvent = { onDismiss() }
                                )
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 19. Language Selection Dropdown
                DropdownExample(
                    title = "19. Language Selection Dropdown",
                    description = "Dropdown with language options and icons"
                ) { isExpanded, onDismiss ->
                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            shape = RoundedCornerShape(8.dp)
                        ),
                        onDismissRequest = onDismiss,
                        content = {
                            Column(
                                modifier = Modifier.padding(vertical = 8.dp)
                            ) {
                                SushiText(
                                    props = SushiTextProps(
                                        text = "Select Language",
                                        type = SushiTextType.SemiBold600,
                                        textAlign = TextAlign.Center
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 8.dp)
                                )

                                // Language options with flags
                                LanguageOption("English", SushiIconCodes.IconLanguageGlobe) { onDismiss() }
                                LanguageOption("Hindi", SushiIconCodes.IconLanguageHindi) { onDismiss() }
                                LanguageOption("Spanish", SushiIconCodes.IconLanguageGlobe) { onDismiss() }
                                LanguageOption("French", SushiIconCodes.IconLanguageGlobe) { onDismiss() }
                                LanguageOption("German", SushiIconCodes.IconLanguageGlobe) { onDismiss() }
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // 20. Feedback Rating Dropdown
                DropdownExample(
                    title = "20. Feedback Rating Dropdown",
                    description = "Dropdown with interactive rating options"
                ) { isExpanded, onDismiss ->
                    SushiDropDown(
                        props = SushiDropDownProps(
                            expanded = isExpanded,
                            shape = RoundedCornerShape(16.dp),
                            containerColor = SushiTheme.colors.surface.elevated.value
                        ),
                        onDismissRequest = onDismiss,
                        content = {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .width(250.dp)
                            ) {
                                SushiText(
                                    props = SushiTextProps(
                                        text = "Rate Your Experience",
                                        type = SushiTextType.Bold600,
                                        textAlign = TextAlign.Center
                                    ),
                                    modifier = Modifier.fillMaxWidth()
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                // Star rating options
                                val ratings = listOf("Excellent", "Good", "Average", "Poor", "Terrible")
                                val colors = listOf(
                                    SushiTheme.colors.green.v500,
                                    SushiTheme.colors.green.v400,
                                    SushiTheme.colors.yellow.v500,
                                    SushiTheme.colors.orange.v500,
                                    SushiTheme.colors.red.v500
                                )

                                ratings.forEachIndexed { index, rating ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable { onDismiss() }
                                            .padding(vertical = 12.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        // Stars
                                        Row {
                                            repeat(5 - index) {
                                                SushiIcon(
                                                    props = SushiIconProps(
                                                        code = SushiIconCodes.IconStarFill,
                                                        color = SushiColorData.fromColorName(
                                                            colorName = ColorName.Yellow,
                                                            tint = ColorVariation.Variation500
                                                        )
                                                    ),
                                                    modifier = Modifier.padding(end = 2.dp)
                                                )
                                            }

                                            repeat(index) {
                                                SushiIcon(
                                                    props = SushiIconProps(
                                                        code = SushiIconCodes.IconStarEmpty,
                                                        color = SushiTheme.colors.grey.v400
                                                    ),
                                                    modifier = Modifier.padding(end = 2.dp)
                                                )
                                            }
                                        }

                                        Spacer(modifier = Modifier.width(12.dp))

                                        SushiText(
                                            props = SushiTextProps(
                                                text = rating,
                                                type = SushiTextType.Medium500,
                                                color = colors[index]
                                            )
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(16.dp))

                                SushiButton(
                                    props = SushiButtonProps(
                                        text = "Submit Feedback"
                                    ),
                                    onClick = onDismiss,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
                    )
                }

                // Add a spacer at the bottom for better scrolling experience
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Composable
private fun DropdownExample(
    title: String,
    description: String,
    content: @Composable (Boolean, () -> Unit) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Title
        SushiText(
            props = SushiTextProps(
                text = title,
                type = SushiTextType.Bold600,
                color = SushiTheme.colors.text.primary
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Description
        SushiText(
            props = SushiTextProps(
                text = description,
                type = SushiTextType.Regular400,
                color = SushiTheme.colors.text.secondary
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Example button
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            SushiButton(
                props = SushiButtonProps(
                    text = "Show Dropdown",
                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconChevronDown)
                ),
                onClick = { isExpanded = true },
                modifier = Modifier.fillMaxWidth()
            )

            // Dropdown content
            content(isExpanded) { isExpanded = false }
        }
    }
}

@Composable
private fun LanguageOption(language: String, iconCode: SushiIconCode, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        SushiIcon(
            props = SushiIconProps(
                code = iconCode
            )
        )

        Spacer(modifier = Modifier.width(16.dp))

        SushiText(
            props = SushiTextProps(
                text = language,
                type = SushiTextType.Regular400
            )
        )
    }
}

@Composable
@SushiPreview
private fun DropDownShowcaseScreenPreview() {
    AppTheme {
        DropDownShowcaseScreen()
    }
}