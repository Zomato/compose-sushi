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
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.switch.SushiSwitch
import com.zomato.sushi.compose.atoms.switch.SushiSwitchProps
import com.zomato.sushi.compose.atoms.switch.SwitchDirection
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.serialization.Serializable

@Serializable
object SwitchShowcaseScreen

@Composable
fun SwitchShowcaseScreen(
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
            ) {
                AppTopBar(
                    title = "Switch Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(SushiTheme.dimens.spacing.base)
                ) {
                    // 1. Basic Switch (Unchecked)
                    SectionTitle("Basic Switches")

                    var checked1 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked1,
                            text = SushiTextProps(text = "1. Basic Switch (Unchecked)")
                        ),
                        onCheckedChange = { checked1 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 2. Checked Switch
                    var checked2 by remember { mutableStateOf(true) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked2,
                            text = SushiTextProps(text = "2. Initially Checked Switch")
                        ),
                        onCheckedChange = { checked2 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 3. Disabled Switch (Unchecked)
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = false,
                            isEnabled = false,
                            text = SushiTextProps(text = "3. Disabled Switch (Unchecked)")
                        ),
                        onCheckedChange = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 4. Disabled Switch (Checked)
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = true,
                            isEnabled = false,
                            text = SushiTextProps(text = "4. Disabled Switch (Checked)")
                        ),
                        onCheckedChange = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Switch Directions
                    SectionTitle("Switch Directions")

                    // 5. Switch at Start (Default)
                    var checked5 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked5,
                            text = SushiTextProps(text = "5. Switch at Start (Default)"),
                            direction = SwitchDirection.Start
                        ),
                        onCheckedChange = { checked5 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 6. Switch at End
                    var checked6 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked6,
                            text = SushiTextProps(text = "6. Switch at End"),
                            direction = SwitchDirection.End
                        ),
                        onCheckedChange = { checked6 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Text Customization
                    SectionTitle("Text Customization")

                    // 7. Custom Text Style
                    var checked7 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked7,
                            text = SushiTextProps(
                                text = "7. Custom Text Style",
                                type = SushiTextType.Bold700,
                                color = SushiTheme.colors.blue.v700
                            )
                        ),
                        onCheckedChange = { checked7 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 8. With SubText
                    var checked8 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked8,
                            text = SushiTextProps(text = "8. With SubText"),
                            subText = SushiTextProps(
                                text = "This is additional descriptive text that appears below the main text",
                                type = SushiTextType.Regular300,
                                color = SushiTheme.colors.text.secondary
                            )
                        ),
                        onCheckedChange = { checked8 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 9. Multiline Text
                    var checked9 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked9,
                            text = SushiTextProps(
                                text = "9. Multiline Text\nThis switch demonstrates how text wraps when it spans multiple lines. The text will wrap automatically when it reaches the end of the available space."
                            )
                        ),
                        onCheckedChange = { checked9 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 10. Multiline Text with SubText
                    var checked10 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked10,
                            text = SushiTextProps(
                                text = "10. Multiline Text with SubText\nThis is the primary text that spans multiple lines"
                            ),
                            subText = SushiTextProps(
                                text = "This is the subtext that provides additional information and can also span multiple lines if needed",
                                type = SushiTextType.Regular300
                            )
                        ),
                        onCheckedChange = { checked10 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Color Customization
                    SectionTitle("Color Customization")

                    // 11. Custom Switch Color (Red)
                    var checked11 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked11,
                            text = SushiTextProps(text = "11. Custom Switch Color (Red)"),
                            color = SushiColorData(ColorName.Red, ColorVariation.Variation600)
                        ),
                        onCheckedChange = { checked11 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 12. Custom Switch Color (Green)
                    var checked12 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked12,
                            text = SushiTextProps(text = "12. Custom Switch Color (Green)"),
                            color = SushiColorData(ColorName.Green, ColorVariation.Variation600)
                        ),
                        onCheckedChange = { checked12 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 13. Custom Switch Color (Blue)
                    var checked13 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked13,
                            text = SushiTextProps(text = "13. Custom Switch Color (Blue)"),
                            color = SushiColorData(ColorName.Blue, ColorVariation.Variation600)
                        ),
                        onCheckedChange = { checked13 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Vertical Alignment
                    SectionTitle("Vertical Alignment")

                    // 14. Top Alignment
                    var checked14 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked14,
                            text = SushiTextProps(
                                text = "14. Top Alignment\nThis shows the switch aligned to the top of a multi-line text. Notice how the switch stays at the top regardless of how many lines of text there are."
                            ),
                            verticalAlignment = Alignment.Top
                        ),
                        onCheckedChange = { checked14 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 15. Center Alignment (Default)
                    var checked15 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked15,
                            text = SushiTextProps(
                                text = "15. Center Alignment (Default)\nThis shows the switch aligned to the center of a multi-line text. This is the default alignment behavior."
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ),
                        onCheckedChange = { checked15 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 16. Bottom Alignment
                    var checked16 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked16,
                            text = SushiTextProps(
                                text = "16. Bottom Alignment\nThis shows the switch aligned to the bottom of a multi-line text. Notice how the switch stays at the bottom regardless of how many lines of text there are."
                            ),
                            verticalAlignment = Alignment.Bottom
                        ),
                        onCheckedChange = { checked16 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Custom Padding
                    SectionTitle("Custom Padding")

                    // 17. Custom Padding (Large)
                    var checked17 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked17,
                            text = SushiTextProps(text = "17. Large Padding (16dp)"),
                            padding = 16.dp
                        ),
                        onCheckedChange = { checked17 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    // 18. No Padding
                    var checked18 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            isChecked = checked18,
                            text = SushiTextProps(text = "18. No Padding"),
                            padding = 0.dp
                        ),
                        onCheckedChange = { checked18 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Real-world Use Cases
                    SectionTitle("Real-world Use Cases")

                    // 19. Settings Page Example
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
                                    text = "19. App Settings",
                                    type = SushiTextType.SemiBold600
                                )
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            // Notifications
                            var notificationsEnabled by remember { mutableStateOf(true) }
                            SushiSwitch(
                                props = SushiSwitchProps(
                                    isChecked = notificationsEnabled,
                                    text = SushiTextProps(
                                        text = "Push Notifications",
                                        type = SushiTextType.Medium500
                                    ),
                                    subText = SushiTextProps(
                                        text = "Receive alerts about new offers and updates",
                                        type = SushiTextType.Regular300,
                                        color = SushiTheme.colors.text.secondary
                                    )
                                ),
                                onCheckedChange = { notificationsEnabled = it },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )

                            // Location Services
                            var locationEnabled by remember { mutableStateOf(false) }
                            SushiSwitch(
                                props = SushiSwitchProps(
                                    isChecked = locationEnabled,
                                    text = SushiTextProps(
                                        text = "Location Services",
                                        type = SushiTextType.Medium500
                                    ),
                                    subText = SushiTextProps(
                                        text = "Allow app to access your location",
                                        type = SushiTextType.Regular300,
                                        color = SushiTheme.colors.text.secondary
                                    )
                                ),
                                onCheckedChange = { locationEnabled = it },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )

                            // Dark Mode
                            var darkModeEnabled by remember { mutableStateOf(false) }
                            SushiSwitch(
                                props = SushiSwitchProps(
                                    isChecked = darkModeEnabled,
                                    text = SushiTextProps(
                                        text = "Dark Mode",
                                        type = SushiTextType.Medium500
                                    ),
                                    color = SushiColorData(ColorName.Blue, ColorVariation.Variation600)
                                ),
                                onCheckedChange = { darkModeEnabled = it },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )
                        }
                    }

                    // 20. Preferences Example with Switch at End
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
                                    text = "20. Email Preferences",
                                    type = SushiTextType.SemiBold600
                                )
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            // Marketing Emails
                            var marketingEnabled by remember { mutableStateOf(true) }
                            SushiSwitch(
                                props = SushiSwitchProps(
                                    isChecked = marketingEnabled,
                                    text = SushiTextProps(
                                        text = "Marketing Emails",
                                        type = SushiTextType.Medium500
                                    ),
                                    subText = SushiTextProps(
                                        text = "Receive promotional emails and special offers",
                                        type = SushiTextType.Regular300,
                                        color = SushiTheme.colors.text.secondary
                                    ),
                                    direction = SwitchDirection.End
                                ),
                                onCheckedChange = { marketingEnabled = it },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )

                            // Newsletter
                            var newsletterEnabled by remember { mutableStateOf(false) }
                            SushiSwitch(
                                props = SushiSwitchProps(
                                    isChecked = newsletterEnabled,
                                    text = SushiTextProps(
                                        text = "Weekly Newsletter",
                                        type = SushiTextType.Medium500
                                    ),
                                    subText = SushiTextProps(
                                        text = "Get weekly updates about new features and content",
                                        type = SushiTextType.Regular300,
                                        color = SushiTheme.colors.text.secondary
                                    ),
                                    direction = SwitchDirection.End
                                ),
                                onCheckedChange = { newsletterEnabled = it },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )

                            // Order Updates
                            var orderUpdatesEnabled by remember { mutableStateOf(true) }
                            SushiSwitch(
                                props = SushiSwitchProps(
                                    isChecked = orderUpdatesEnabled,
                                    text = SushiTextProps(
                                        text = "Order Updates",
                                        type = SushiTextType.Medium500
                                    ),
                                    subText = SushiTextProps(
                                        text = "Receive emails about your orders",
                                        type = SushiTextType.Regular300,
                                        color = SushiTheme.colors.text.secondary
                                    ),
                                    direction = SwitchDirection.End
                                ),
                                onCheckedChange = { orderUpdatesEnabled = it },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Special Examples
                    SectionTitle("Special Examples")

                    // 21. Switch with ID
                    var checked21 by remember { mutableStateOf(false) }
                    SushiSwitch(
                        props = SushiSwitchProps(
                            id = "notifications_toggle",
                            isChecked = checked21,
                            text = SushiTextProps(text = "21. Switch with ID ('notifications_toggle')")
                        ),
                        onCheckedChange = { checked21 = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 22. Side-by-Side Comparison
                    SectionTitle("22. Side-by-Side Comparison")
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Left: Direction Start
                        var leftChecked by remember { mutableStateOf(false) }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, SushiTheme.colors.grey.v200.value, RoundedCornerShape(8.dp))
                                .padding(8.dp)
                        ) {
                            SushiSwitch(
                                props = SushiSwitchProps(
                                    isChecked = leftChecked,
                                    text = SushiTextProps(text = "Start Direction"),
                                    direction = SwitchDirection.Start
                                ),
                                onCheckedChange = { leftChecked = it },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        // Right: Direction End
                        var rightChecked by remember { mutableStateOf(false) }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, SushiTheme.colors.grey.v200.value, RoundedCornerShape(8.dp))
                                .padding(8.dp)
                        ) {
                            SushiSwitch(
                                props = SushiSwitchProps(
                                    isChecked = rightChecked,
                                    text = SushiTextProps(text = "End Direction"),
                                    direction = SwitchDirection.End
                                ),
                                onCheckedChange = { rightChecked = it },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                    // 23. Privacy and Data Options
                    SectionTitle("23. Privacy Options")
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
                                    text = "Privacy Settings",
                                    type = SushiTextType.SemiBold600
                                )
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            var analyticsSharingEnabled by remember { mutableStateOf(true) }
                            SushiSwitch(
                                props = SushiSwitchProps(
                                    isChecked = analyticsSharingEnabled,
                                    text = SushiTextProps(
                                        text = "Anonymous Analytics",
                                        type = SushiTextType.Medium500
                                    ),
                                    subText = SushiTextProps(
                                        text = "Help us improve by sharing anonymous usage data",
                                        type = SushiTextType.Regular300,
                                        color = SushiTheme.colors.text.secondary
                                    ),
                                    color = SushiColorData(ColorName.Purple, ColorVariation.Variation600)
                                ),
                                onCheckedChange = { analyticsSharingEnabled = it },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )

                            var personalizationEnabled by remember { mutableStateOf(false) }
                            SushiSwitch(
                                props = SushiSwitchProps(
                                    isChecked = personalizationEnabled,
                                    text = SushiTextProps(
                                        text = "Personalization",
                                        type = SushiTextType.Medium500
                                    ),
                                    subText = SushiTextProps(
                                        text = "Allow us to personalize your experience based on your activity",
                                        type = SushiTextType.Regular300,
                                        color = SushiTheme.colors.text.secondary
                                    ),
                                    color = SushiColorData(ColorName.Purple, ColorVariation.Variation600)
                                ),
                                onCheckedChange = { personalizationEnabled = it },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )
                        }
                    }

                    // 24. Feature Toggles
                    SectionTitle("24. Feature Toggles")
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(8.dp),
                        color = SushiTheme.colors.surface.secondary.value
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "Experimental Features",
                                    type = SushiTextType.Medium500
                                ),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                var betaFeaturesEnabled by remember { mutableStateOf(false) }

                                SushiText(
                                    props = SushiTextProps(
                                        text = "Beta Features",
                                        type = SushiTextType.Regular400
                                    )
                                )

                                SushiSwitch(
                                    props = SushiSwitchProps(
                                        isChecked = betaFeaturesEnabled,
                                        color = SushiColorData(ColorName.Orange, ColorVariation.Variation600)
                                    ),
                                    onCheckedChange = { betaFeaturesEnabled = it }
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                var darkThemeEnabled by remember { mutableStateOf(false) }

                                SushiText(
                                    props = SushiTextProps(
                                        text = "Dark Theme (Alpha)",
                                        type = SushiTextType.Regular400
                                    )
                                )

                                SushiSwitch(
                                    props = SushiSwitchProps(
                                        isChecked = darkThemeEnabled,
                                        color = SushiColorData(ColorName.Orange, ColorVariation.Variation600)
                                    ),
                                    onCheckedChange = { darkThemeEnabled = it }
                                )
                            }
                        }
                    }

                    // 25. Accessibility Options
                    SectionTitle("25. Accessibility Options")
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
                                    text = "Accessibility",
                                    type = SushiTextType.SemiBold600
                                )
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            var largeTextEnabled by remember { mutableStateOf(false) }
                            SushiSwitch(
                                props = SushiSwitchProps(
                                    isChecked = largeTextEnabled,
                                    text = SushiTextProps(
                                        text = "Large Text",
                                        type = SushiTextType.Medium500
                                    ),
                                    color = SushiColorData(ColorName.Teal, ColorVariation.Variation600)
                                ),
                                onCheckedChange = { largeTextEnabled = it },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )

                            var highContrastEnabled by remember { mutableStateOf(false) }
                            SushiSwitch(
                                props = SushiSwitchProps(
                                    isChecked = highContrastEnabled,
                                    text = SushiTextProps(
                                        text = "High Contrast",
                                        type = SushiTextType.Medium500
                                    ),
                                    subText = SushiTextProps(
                                        text = "Increase contrast for better readability",
                                        type = SushiTextType.Regular300,
                                        color = SushiTheme.colors.text.secondary
                                    ),
                                    color = SushiColorData(ColorName.Teal, ColorVariation.Variation600)
                                ),
                                onCheckedChange = { highContrastEnabled = it },
                                modifier = Modifier.padding(vertical = 4.dp)
                            )

                            var screenReaderEnabled by remember { mutableStateOf(false) }
                            SushiSwitch(
                                props = SushiSwitchProps(
                                    isChecked = screenReaderEnabled,
                                    text = SushiTextProps(
                                        text = "Screen Reader Optimization",
                                        type = SushiTextType.Medium500
                                    ),
                                    subText = SushiTextProps(
                                        text = "Optimize UI for screen readers",
                                        type = SushiTextType.Regular300,
                                        color = SushiTheme.colors.text.secondary
                                    ),
                                    color = SushiColorData(ColorName.Teal, ColorVariation.Variation600)
                                ),
                                onCheckedChange = { screenReaderEnabled = it },
                                modifier = Modifier.padding(vertical = 4.dp)
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
private fun SwitchShowcaseScreenPreview() {
    AppTheme {
        SwitchShowcaseScreen()
    }
}