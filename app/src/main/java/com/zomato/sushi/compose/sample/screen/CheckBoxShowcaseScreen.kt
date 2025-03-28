package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.checkbox.CheckBoxDirection
import com.zomato.sushi.compose.atoms.checkbox.SushiCheckBox
import com.zomato.sushi.compose.atoms.checkbox.SushiCheckBoxProps
import com.zomato.sushi.compose.atoms.checkbox.SushiCheckboxSize
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.BaseScreen
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.serialization.Serializable

@Serializable
object CheckBoxShowcaseScreen

@Composable
fun CheckBoxShowcaseScreen(
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

            ) {
                AppTopBar(
                    title = "CheckBox Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxWidth()
                        .padding(SushiTheme.dimens.spacing.base)
                ) {
                    // 1. Basic Checkbox
                    SectionTitle("Basic CheckBoxes")
                    
                    var checked1 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked1,
                            text = SushiTextProps(text = "1. Basic Checkbox")
                        ),
                        onCheckedChange = { checked1 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 2. Initially Checked Checkbox
                    var checked2 by remember { mutableStateOf(true) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked2,
                            text = SushiTextProps(text = "2. Initially Checked Checkbox")
                        ),
                        onCheckedChange = { checked2 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 3. Disabled Checkbox (Unchecked)
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = false,
                            enabled = false,
                            text = SushiTextProps(text = "3. Disabled Checkbox (Unchecked)")
                        ),
                        onCheckedChange = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 4. Disabled Checkbox (Checked)
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = true,
                            enabled = false,
                            text = SushiTextProps(text = "4. Disabled Checkbox (Checked)")
                        ),
                        onCheckedChange = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Checkbox Sizes
                    SectionTitle("Checkbox Sizes")
                    
                    // 5. Default Size Checkbox
                    var checked5 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked5,
                            text = SushiTextProps(text = "5. Default Size Checkbox"),
                            size = SushiCheckboxSize.Default
                        ),
                        onCheckedChange = { checked5 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 6. Mini Size Checkbox
                    var checked6 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked6,
                            text = SushiTextProps(text = "6. Mini Size Checkbox"),
                            size = SushiCheckboxSize.Mini
                        ),
                        onCheckedChange = { checked6 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Checkbox Directions
                    SectionTitle("Checkbox Directions")
                    
                    // 7. Checkbox at Start (Default)
                    var checked7 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked7,
                            text = SushiTextProps(text = "7. Checkbox at Start (Default)"),
                            direction = CheckBoxDirection.Start
                        ),
                        onCheckedChange = { checked7 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 8. Checkbox at End
                    var checked8 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked8,
                            text = SushiTextProps(text = "8. Checkbox at End"),
                            direction = CheckBoxDirection.End
                        ),
                        onCheckedChange = { checked8 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Text Customization
                    SectionTitle("Text Customization")
                    
                    // 9. Custom Text Style
                    var checked9 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked9,
                            text = SushiTextProps(
                                text = "9. Custom Text Style",
                                type = SushiTextType.Bold700,
                                color = SushiTheme.colors.blue.v700
                            )
                        ),
                        onCheckedChange = { checked9 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 10. With SubText
                    var checked10 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked10,
                            text = SushiTextProps(text = "10. With SubText"),
                            subText = SushiTextProps(
                                text = "This is additional descriptive text that appears below the main text",
                                type = SushiTextType.Regular300,
                                color = SushiTheme.colors.text.secondary
                            )
                        ),
                        onCheckedChange = { checked10 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 11. Multiline Text
                    var checked11 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked11,
                            text = SushiTextProps(
                                text = "11. Multiline Text\nThis checkbox demonstrates how text wraps when it spans multiple lines. The text will wrap automatically when it reaches the end of the available space."
                            )
                        ),
                        onCheckedChange = { checked11 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 12. Multiline Text with SubText
                    var checked12 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked12,
                            text = SushiTextProps(
                                text = "12. Multiline Text with SubText\nThis is the primary text that spans multiple lines"
                            ),
                            subText = SushiTextProps(
                                text = "This is the subtext that provides additional information and can also span multiple lines if needed",
                                type = SushiTextType.Regular300
                            )
                        ),
                        onCheckedChange = { checked12 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Color Customization
                    SectionTitle("Color Customization")
                    
                    // 13. Custom Checkbox Color
                    var checked13 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked13,
                            text = SushiTextProps(text = "13. Custom Checkbox Color"),
                            color = SushiColorData(ColorName.Red, ColorVariation.Variation600)
                        ),
                        onCheckedChange = { checked13 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 14. Custom Checkbox Color (Green)
                    var checked14 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked14,
                            text = SushiTextProps(text = "14. Green Checkbox Color"),
                            color = SushiColorData(ColorName.Green, ColorVariation.Variation600)
                        ),
                        onCheckedChange = { checked14 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 15. Custom Checkbox Color (Blue)
                    var checked15 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked15,
                            text = SushiTextProps(text = "15. Blue Checkbox Color"),
                            color = SushiColorData(ColorName.Blue, ColorVariation.Variation600)
                        ),
                        onCheckedChange = { checked15 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Vertical Alignment
                    SectionTitle("Vertical Alignment")
                    
                    // 16. Top Alignment
                    var checked16 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked16,
                            text = SushiTextProps(
                                text = "16. Top Alignment\nThis shows the checkbox aligned to the top of a multi-line text. Notice how the checkbox stays at the top regardless of how many lines of text there are."
                            ),
                            verticalAlignment = Alignment.Top
                        ),
                        onCheckedChange = { checked16 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 17. Center Alignment (Default)
                    var checked17 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked17,
                            text = SushiTextProps(
                                text = "17. Center Alignment (Default)\nThis shows the checkbox aligned to the center of a multi-line text. This is the default alignment behavior."
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ),
                        onCheckedChange = { checked17 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 18. Bottom Alignment
                    var checked18 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked18,
                            text = SushiTextProps(
                                text = "18. Bottom Alignment\nThis shows the checkbox aligned to the bottom of a multi-line text. Notice how the checkbox stays at the bottom regardless of how many lines of text there are."
                            ),
                            verticalAlignment = Alignment.Bottom
                        ),
                        onCheckedChange = { checked18 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Box Padding
                    SectionTitle("Box Padding")
                    
                    // 19. Custom Box Padding
                    var checked19 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked19,
                            text = SushiTextProps(text = "19. Custom Box Padding (16dp)"),
                            boxPadding = 16.dp
                        ),
                        onCheckedChange = { checked19 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 20. No Box Padding
                    var checked20 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            checked = checked20,
                            text = SushiTextProps(text = "20. No Box Padding"),
                            boxPadding = 0.dp
                        ),
                        onCheckedChange = { checked20 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Real-world Examples
                    SectionTitle("Real-world Examples")
                    
                    // 21. Terms and Conditions
                    var checked21 by remember { mutableStateOf(false) }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = SushiTheme.colors.surface.secondary.value
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "Terms and Conditions",
                                    type = SushiTextType.SemiBold600
                                )
                            )
                            
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            SushiCheckBox(
                                props = SushiCheckBoxProps(
                                    checked = checked21,
                                    text = SushiTextProps(
                                        text = "21. I accept the terms and conditions"
                                    ),
                                    subText = SushiTextProps(
                                        text = "By checking this box, you agree to our Terms of Service and Privacy Policy",
                                        type = SushiTextType.Regular300,
                                        color = SushiTheme.colors.text.secondary
                                    ),
                                    color = SushiTheme.colors.green.v600
                                ),
                                onCheckedChange = { checked21 = it },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                    
                    // 22. Filter Options
                    SectionTitle("22. Filter Options")
                    val filterOptions = listOf(
                        "Vegetarian" to remember { mutableStateOf(false) },
                        "Vegan" to remember { mutableStateOf(false) },
                        "Gluten Free" to remember { mutableStateOf(true) }
                    )
                    
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        color = SushiTheme.colors.surface.primary.value,
                        shape = RoundedCornerShape(8.dp),
                        border = androidx.compose.foundation.BorderStroke(
                            width = 1.dp,
                            color = SushiTheme.colors.grey.v200.value
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "Dietary Preferences",
                                    type = SushiTextType.Medium500
                                ),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            
                            filterOptions.forEachIndexed { index, option ->
                                SushiCheckBox(
                                    props = SushiCheckBoxProps(
                                        checked = option.second.value,
                                        text = SushiTextProps(
                                            text = option.first
                                        ),
                                        size = SushiCheckboxSize.Mini
                                    ),
                                    onCheckedChange = { option.second.value = it },
                                    modifier = Modifier.padding(vertical = 4.dp)
                                )
                            }
                        }
                    }
                    
                    // 23. Checkbox with ID
                    var checked23 by remember { mutableStateOf(false) }
                    SushiCheckBox(
                        props = SushiCheckBoxProps(
                            id = "notification_prefs",
                            checked = checked23,
                            text = SushiTextProps(text = "23. Checkbox with ID ('notification_prefs')")
                        ),
                        onCheckedChange = { checked23 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                    
                    // 24. Side-by-Side Comparison
                    SectionTitle("24. Side-by-Side Comparison")
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Left: Direction Start, Mini Size
                        var checkedLeft by remember { mutableStateOf(false) }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, SushiTheme.colors.grey.v200.value, RoundedCornerShape(8.dp))
                                .padding(8.dp)
                        ) {
                            SushiCheckBox(
                                props = SushiCheckBoxProps(
                                    checked = checkedLeft,
                                    text = SushiTextProps(text = "Start, Mini"),
                                    direction = CheckBoxDirection.Start,
                                    size = SushiCheckboxSize.Mini
                                ),
                                onCheckedChange = { checkedLeft = it }
                            )
                        }
                        
                        // Right: Direction End, Default Size
                        var checkedRight by remember { mutableStateOf(false) }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, SushiTheme.colors.grey.v200.value, RoundedCornerShape(8.dp))
                                .padding(8.dp)
                        ) {
                            SushiCheckBox(
                                props = SushiCheckBoxProps(
                                    checked = checkedRight,
                                    text = SushiTextProps(text = "End, Default"),
                                    direction = CheckBoxDirection.End,
                                    size = SushiCheckboxSize.Default
                                ),
                                onCheckedChange = { checkedRight = it }
                            )
                        }
                    }
                    
                    // 25. Custom Layout with CheckBoxes
                    SectionTitle("25. Custom Layout with CheckBoxes")
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = SushiTheme.colors.surface.secondary.value
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "Select Toppings",
                                    type = SushiTextType.SemiBold600
                                )
                            )
                            
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            // Two columns of checkboxes
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    val leftOptions = listOf(
                                        "Cheese" to remember { mutableStateOf(true) },
                                        "Onions" to remember { mutableStateOf(false) },
                                        "Mushrooms" to remember { mutableStateOf(false) }
                                    )
                                    
                                    leftOptions.forEach { option ->
                                        SushiCheckBox(
                                            props = SushiCheckBoxProps(
                                                checked = option.second.value,
                                                text = SushiTextProps(text = option.first),
                                                size = SushiCheckboxSize.Mini
                                            ),
                                            onCheckedChange = { option.second.value = it },
                                            modifier = Modifier.padding(vertical = 2.dp)
                                        )
                                    }
                                }
                                
                                Column(modifier = Modifier.weight(1f)) {
                                    val rightOptions = listOf(
                                        "Peppers" to remember { mutableStateOf(false) },
                                        "Olives" to remember { mutableStateOf(true) },
                                        "Tomatoes" to remember { mutableStateOf(false) }
                                    )
                                    
                                    rightOptions.forEach { option ->
                                        SushiCheckBox(
                                            props = SushiCheckBoxProps(
                                                checked = option.second.value,
                                                text = SushiTextProps(text = option.first),
                                                size = SushiCheckboxSize.Mini
                                            ),
                                            onCheckedChange = { option.second.value = it },
                                            modifier = Modifier.padding(vertical = 2.dp)
                                        )
                                    }
                                }
                            }
                            
                            // Extra options with different styles
                            var extraCheese by remember { mutableStateOf(false) }
                            SushiCheckBox(
                                props = SushiCheckBoxProps(
                                    checked = extraCheese,
                                    text = SushiTextProps(
                                        text = "Extra Cheese",
                                        type = SushiTextType.Medium500
                                    ),
                                    subText = SushiTextProps(
                                        text = "Additional $1.50",
                                        type = SushiTextType.Regular300,
                                        color = SushiTheme.colors.text.secondary
                                    ),
                                    color = SushiColorData(ColorName.Yellow, ColorVariation.Variation600),
                                    direction = CheckBoxDirection.End
                                ),
                                onCheckedChange = { extraCheese = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    SushiText(
        props = SushiTextProps(
            text = title,
            type = SushiTextType.SemiBold600,
            color = SushiTheme.colors.text.primary
        ),
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
@SushiPreview
private fun CheckBoxShowcaseScreenPreview() {
    AppTheme {
        CheckBoxShowcaseScreen()
    }
}