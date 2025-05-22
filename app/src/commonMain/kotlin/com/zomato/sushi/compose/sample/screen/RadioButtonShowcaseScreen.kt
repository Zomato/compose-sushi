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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.radio.RadioButtonDirection
import com.zomato.sushi.compose.atoms.radio.SushiRadioButton
import com.zomato.sushi.compose.atoms.radio.SushiRadioButtonProps
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.serialization.Serializable

@Serializable
object RadioButtonShowcaseScreen

@Composable
fun RadioButtonShowcaseScreen(
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
                    title = "RadioButton Showcase",
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
                    // 1-2. Basic Radio Buttons (Selected/Unselected)
                    SectionTitle("Basic Radio Buttons")

                    var selectedBasic by remember { mutableIntStateOf(1) }

                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedBasic == 1,
                            text = SushiTextProps(text = "1. Selected Radio Button")
                        ),
                        onClick = { selectedBasic = 1 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedBasic == 2,
                            text = SushiTextProps(text = "2. Unselected Radio Button")
                        ),
                        onClick = { selectedBasic = 2 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // 3-4. Enabled/Disabled States
                    SectionTitle("Enabled/Disabled States")

                    var selectedEnabledDisabled by remember { mutableIntStateOf(3) }

                    // 3. Enabled Radio Button
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedEnabledDisabled == 3,
                            enabled = true,
                            text = SushiTextProps(text = "3. Enabled Radio Button")
                        ),
                        onClick = { selectedEnabledDisabled = 3 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 4. Disabled Radio Button (Selected)
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = true,
                            enabled = false,
                            text = SushiTextProps(text = "4. Disabled Radio Button (Selected)")
                        ),
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 5. Disabled Radio Button (Unselected)
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = false,
                            enabled = false,
                            text = SushiTextProps(text = "5. Disabled Radio Button (Unselected)")
                        ),
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Radio Button Directions
                    SectionTitle("Radio Button Directions")

                    var selectedDirection by remember { mutableIntStateOf(6) }

                    // 6. Start Direction (Default)
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedDirection == 6,
                            text = SushiTextProps(text = "6. Start Direction (Default)"),
                            direction = RadioButtonDirection.Start
                        ),
                        onClick = { selectedDirection = 6 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 7. End Direction
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedDirection == 7,
                            text = SushiTextProps(text = "7. End Direction"),
                            direction = RadioButtonDirection.End
                        ),
                        onClick = { selectedDirection = 7 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Text Customization
                    SectionTitle("Text Customization")

                    var selectedTextCustom by remember { mutableIntStateOf(8) }

                    // 8. Custom Text Style
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedTextCustom == 8,
                            text = SushiTextProps(
                                text = "8. Custom Text Style",
                                type = SushiTextType.Bold700,
                                color = SushiTheme.colors.blue.v700
                            )
                        ),
                        onClick = { selectedTextCustom = 8 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 9. With SubText
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedTextCustom == 9,
                            text = SushiTextProps(text = "9. With SubText"),
                            subText = SushiTextProps(
                                text = "This is additional descriptive text that appears below the main text",
                                type = SushiTextType.Regular300,
                                color = SushiTheme.colors.text.secondary
                            )
                        ),
                        onClick = { selectedTextCustom = 9 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 10. Multiline Text
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedTextCustom == 10,
                            text = SushiTextProps(
                                text = "10. Multiline Text\nThis radio button demonstrates how text wraps when it spans multiple lines. The text will wrap automatically when it reaches the end of the available space."
                            )
                        ),
                        onClick = { selectedTextCustom = 10 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 11. Multiline Text with SubText
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedTextCustom == 11,
                            text = SushiTextProps(
                                text = "11. Multiline Text with SubText\nThis is the primary text that spans multiple lines"
                            ),
                            subText = SushiTextProps(
                                text = "This is the subtext that provides additional information and can also span multiple lines if needed",
                                type = SushiTextType.Regular300
                            )
                        ),
                        onClick = { selectedTextCustom = 11 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Color Customization
                    SectionTitle("Color Customization")

                    var selectedColorCustom by remember { mutableIntStateOf(12) }

                    // 12. Custom Selected Color
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedColorCustom == 12,
                            text = SushiTextProps(text = "12. Custom Selected Color (Red)"),
                            selectedColor = SushiColorData(ColorName.Red, ColorVariation.Variation600)
                        ),
                        onClick = { selectedColorCustom = 12 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 13. Custom Unselected Color
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedColorCustom == 13,
                            text = SushiTextProps(text = "13. Custom Unselected Color (Blue)"),
                            unselectedColor = SushiColorData(ColorName.Blue, ColorVariation.Variation600)
                        ),
                        onClick = { selectedColorCustom = 13 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 14. Both Selected & Unselected Colors
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedColorCustom == 14,
                            text = SushiTextProps(text = "14. Both Colors Customized"),
                            selectedColor = SushiColorData(ColorName.Green, ColorVariation.Variation600),
                            unselectedColor = SushiColorData(ColorName.Green, ColorVariation.Variation300)
                        ),
                        onClick = { selectedColorCustom = 14 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Vertical Alignment
                    SectionTitle("Vertical Alignment")

                    var selectedVerticalAlign by remember { mutableIntStateOf(15) }

                    // 15. Top Alignment
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedVerticalAlign == 15,
                            text = SushiTextProps(
                                text = "15. Top Alignment\nThis shows the radio button aligned to the top of a multi-line text. Notice how the radio button stays at the top regardless of how many lines of text there are."
                            ),
                            verticalAlignment = Alignment.Top
                        ),
                        onClick = { selectedVerticalAlign = 15 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 16. Center Alignment (Default)
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedVerticalAlign == 16,
                            text = SushiTextProps(
                                text = "16. Center Alignment (Default)\nThis shows the radio button aligned to the center of a multi-line text. This is the default alignment behavior."
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ),
                        onClick = { selectedVerticalAlign = 16 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 17. Bottom Alignment
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedVerticalAlign == 17,
                            text = SushiTextProps(
                                text = "17. Bottom Alignment\nThis shows the radio button aligned to the bottom of a multi-line text. Notice how the radio button stays at the bottom regardless of how many lines of text there are."
                            ),
                            verticalAlignment = Alignment.Bottom
                        ),
                        onClick = { selectedVerticalAlign = 17 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Custom Padding
                    SectionTitle("Custom Padding")

                    var selectedPadding by remember { mutableIntStateOf(18) }

                    // 18. Custom Padding (Large)
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedPadding == 18,
                            text = SushiTextProps(text = "18. Large Padding (16dp)"),
                            padding = 16.dp
                        ),
                        onClick = { selectedPadding = 18 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 19. No Padding
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            selected = selectedPadding == 19,
                            text = SushiTextProps(text = "19. No Padding"),
                            padding = 0.dp
                        ),
                        onClick = { selectedPadding = 19 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Real-world Use Cases
                    SectionTitle("Radio Button Groups")

                    // 20. Radio Button Group - Delivery Options
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
                                    text = "20. Choose Delivery Option",
                                    type = SushiTextType.SemiBold600
                                )
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            var selectedDelivery by remember { mutableIntStateOf(1) }

                            // Standard Delivery
                            SushiRadioButton(
                                props = SushiRadioButtonProps(
                                    selected = selectedDelivery == 1,
                                    text = SushiTextProps(
                                        text = "Standard Delivery",
                                        type = SushiTextType.Medium500
                                    ),
                                    subText = SushiTextProps(
                                        text = "Free • 3-5 business days",
                                        type = SushiTextType.Regular300,
                                        color = SushiTheme.colors.text.secondary
                                    )
                                ),
                                onClick = { selectedDelivery = 1 },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )

                            // Express Delivery
                            SushiRadioButton(
                                props = SushiRadioButtonProps(
                                    selected = selectedDelivery == 2,
                                    text = SushiTextProps(
                                        text = "Express Delivery",
                                        type = SushiTextType.Medium500
                                    ),
                                    subText = SushiTextProps(
                                        text = "$5.99 • 1-2 business days",
                                        type = SushiTextType.Regular300,
                                        color = SushiTheme.colors.text.secondary
                                    )
                                ),
                                onClick = { selectedDelivery = 2 },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )

                            // Same Day Delivery
                            SushiRadioButton(
                                props = SushiRadioButtonProps(
                                    selected = selectedDelivery == 3,
                                    text = SushiTextProps(
                                        text = "Same Day Delivery",
                                        type = SushiTextType.Medium500
                                    ),
                                    subText = SushiTextProps(
                                        text = "$9.99 • Delivered today",
                                        type = SushiTextType.Regular300,
                                        color = SushiTheme.colors.text.secondary
                                    )
                                ),
                                onClick = { selectedDelivery = 3 },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )
                        }
                    }

                    // 21. Radio Button Group - Payment Methods
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
                                    text = "21. Select Payment Method",
                                    type = SushiTextType.SemiBold600
                                )
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            var selectedPayment by remember { mutableIntStateOf(1) }

                            // Credit Card
                            SushiRadioButton(
                                props = SushiRadioButtonProps(
                                    selected = selectedPayment == 1,
                                    text = SushiTextProps(
                                        text = "Credit Card",
                                        type = SushiTextType.Medium500
                                    ),
                                    direction = RadioButtonDirection.End
                                ),
                                onClick = { selectedPayment = 1 },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )

                            // PayPal
                            SushiRadioButton(
                                props = SushiRadioButtonProps(
                                    selected = selectedPayment == 2,
                                    text = SushiTextProps(
                                        text = "PayPal",
                                        type = SushiTextType.Medium500
                                    ),
                                    direction = RadioButtonDirection.End
                                ),
                                onClick = { selectedPayment = 2 },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )

                            // Bank Transfer
                            SushiRadioButton(
                                props = SushiRadioButtonProps(
                                    selected = selectedPayment == 3,
                                    text = SushiTextProps(
                                        text = "Bank Transfer",
                                        type = SushiTextType.Medium500
                                    ),
                                    direction = RadioButtonDirection.End
                                ),
                                onClick = { selectedPayment = 3 },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Special Examples
                    SectionTitle("Special Examples")

                    // 22. Radio Button with ID
                    var selectedWithId by remember { mutableIntStateOf(22) }
                    SushiRadioButton(
                        props = SushiRadioButtonProps(
                            id = "option_standard",
                            selected = selectedWithId == 22,
                            text = SushiTextProps(text = "22. Radio Button with ID ('option_standard')")
                        ),
                        onClick = { selectedWithId = 22 },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 23. Side-by-Side Comparison
                    SectionTitle("23. Side-by-Side Comparison")
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Left: Direction Start
                        var leftSelected by remember { mutableStateOf(true) }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, SushiTheme.colors.grey.v200.value, RoundedCornerShape(8.dp))
                                .padding(8.dp)
                        ) {
                            SushiRadioButton(
                                props = SushiRadioButtonProps(
                                    selected = leftSelected,
                                    text = SushiTextProps(text = "Start Direction"),
                                    direction = RadioButtonDirection.Start
                                ),
                                onClick = { leftSelected = true },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        // Right: Direction End
                        var rightSelected by remember { mutableStateOf(false) }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, SushiTheme.colors.grey.v200.value, RoundedCornerShape(8.dp))
                                .padding(8.dp)
                        ) {
                            SushiRadioButton(
                                props = SushiRadioButtonProps(
                                    selected = rightSelected,
                                    text = SushiTextProps(text = "End Direction"),
                                    direction = RadioButtonDirection.End
                                ),
                                onClick = { rightSelected = true },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                    // 24. Rating Scale
                    SectionTitle("24. Rating Scale")
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
                                    text = "How was your experience?",
                                    type = SushiTextType.SemiBold600
                                )
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            var selectedRating by remember { mutableIntStateOf(3) }
                            val ratings = listOf("Poor", "Fair", "Good", "Very Good", "Excellent")

                            ratings.forEachIndexed { index, rating ->
                                SushiRadioButton(
                                    props = SushiRadioButtonProps(
                                        selected = selectedRating == index + 1,
                                        text = SushiTextProps(
                                            text = rating,
                                            type = SushiTextType.Medium500
                                        ),
                                        selectedColor = when (index) {
                                            0 -> SushiColorData(ColorName.Red, ColorVariation.Variation500)
                                            1 -> SushiColorData(ColorName.Orange, ColorVariation.Variation500)
                                            2 -> SushiColorData(ColorName.Yellow, ColorVariation.Variation500)
                                            3 -> SushiColorData(ColorName.Green, ColorVariation.Variation500)
                                            else -> SushiColorData(ColorName.Blue, ColorVariation.Variation500)
                                        }
                                    ),
                                    onClick = { selectedRating = index + 1 },
                                    modifier = Modifier.padding(vertical = 4.dp)
                                )
                            }
                        }
                    }

                    // 25. Custom Layout with RadioButtons - Size Selection
                    SectionTitle("25. Custom Layout Example")
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
                                    text = "Select Pizza Size",
                                    type = SushiTextType.SemiBold600
                                )
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            var selectedSize by remember { mutableIntStateOf(2) }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                // Small
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.padding(8.dp)
                                ) {
                                    SushiRadioButton(
                                        props = SushiRadioButtonProps(
                                            selected = selectedSize == 1,
                                            id = "size_small"
                                        ),
                                        onClick = { selectedSize = 1 }
                                    )
                                    SushiText(
                                        props = SushiTextProps(
                                            text = "Small",
                                            type = SushiTextType.Regular400
                                        ),
                                        modifier = Modifier.padding(top = 4.dp)
                                    )
                                    SushiText(
                                        props = SushiTextProps(
                                            text = "$9.99",
                                            type = SushiTextType.Regular300,
                                            color = SushiTheme.colors.text.secondary
                                        )
                                    )
                                }

                                // Medium
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.padding(8.dp)
                                ) {
                                    SushiRadioButton(
                                        props = SushiRadioButtonProps(
                                            selected = selectedSize == 2,
                                            id = "size_medium",
                                            selectedColor = SushiTheme.colors.green.v600
                                        ),
                                        onClick = { selectedSize = 2 }
                                    )
                                    SushiText(
                                        props = SushiTextProps(
                                            text = "Medium",
                                            type = SushiTextType.Regular400
                                        ),
                                        modifier = Modifier.padding(top = 4.dp)
                                    )
                                    SushiText(
                                        props = SushiTextProps(
                                            text = "$12.99",
                                            type = SushiTextType.Regular300,
                                            color = SushiTheme.colors.text.secondary
                                        )
                                    )
                                }

                                // Large
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.padding(8.dp)
                                ) {
                                    SushiRadioButton(
                                        props = SushiRadioButtonProps(
                                            selected = selectedSize == 3,
                                            id = "size_large"
                                        ),
                                        onClick = { selectedSize = 3 }
                                    )
                                    SushiText(
                                        props = SushiTextProps(
                                            text = "Large",
                                            type = SushiTextType.Regular400
                                        ),
                                        modifier = Modifier.padding(top = 4.dp)
                                    )
                                    SushiText(
                                        props = SushiTextProps(
                                            text = "$15.99",
                                            type = SushiTextType.Regular300,
                                            color = SushiTheme.colors.text.secondary
                                        )
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            // Additional message below size selection
                            val messageColor = when (selectedSize) {
                                1 -> SushiTheme.colors.text.secondary
                                2 -> SushiTheme.colors.green.v600
                                else -> SushiTheme.colors.blue.v600
                            }

                            val sizeMessage = when (selectedSize) {
                                1 -> "Small: Perfect for 1 person"
                                2 -> "Medium: Recommended for 2-3 people"
                                else -> "Large: Great for 3-4 people"
                            }

                            SushiText(
                                props = SushiTextProps(
                                    text = sizeMessage,
                                    type = SushiTextType.Medium500,
                                    color = messageColor
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))
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
private fun RadioButtonShowcaseScreenPreview() {
    AppTheme {
        RadioButtonShowcaseScreen()
    }
}