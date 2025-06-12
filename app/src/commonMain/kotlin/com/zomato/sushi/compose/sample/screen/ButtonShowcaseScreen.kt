package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.button.SushiButtonSize
import com.zomato.sushi.compose.atoms.button.SushiButtonType
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.icon.asIconSizeSpec
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.serialization.Serializable

@Serializable
object ButtonShowcaseScreen

@Composable
fun ButtonShowcaseScreen(
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
                    title = "Button Showcase",
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
                    // 1. Basic Button Types
                    SectionTitle("Button Types")
                    
                    // 1. Text Button
                    SushiButton(
                        props = SushiButtonProps(
                            text = "1. Text Button",
                            type = SushiButtonType.Text
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 2. Solid Button
                    SushiButton(
                        props = SushiButtonProps(
                            text = "2. Solid Button",
                            type = SushiButtonType.Solid
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 3. Outline Button
                    SushiButton(
                        props = SushiButtonProps(
                            text = "3. Outline Button",
                            type = SushiButtonType.Outline
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Button Sizes
                    SectionTitle("Button Sizes")
                    
                    // 4. Small Button
                    SushiButton(
                        props = SushiButtonProps(
                            text = "4. Small Button",
                            type = SushiButtonType.Solid,
                            size = SushiButtonSize.Small
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 5. Medium Button
                    SushiButton(
                        props = SushiButtonProps(
                            text = "5. Medium Button",
                            type = SushiButtonType.Solid,
                            size = SushiButtonSize.Medium
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 6. Large Button
                    SushiButton(
                        props = SushiButtonProps(
                            text = "6. Large Button",
                            type = SushiButtonType.Solid,
                            size = SushiButtonSize.Large
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Button with Icons
                    SectionTitle("Buttons with Icons")
                    
                    // 7. Button with Prefix Icon
                    SushiButton(
                        props = SushiButtonProps(
                            text = "7. Prefix Icon",
                            type = SushiButtonType.Solid,
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconStarFill)
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 8. Button with Suffix Icon
                    SushiButton(
                        props = SushiButtonProps(
                            text = "8. Suffix Icon",
                            type = SushiButtonType.Solid,
                            suffixIcon = SushiIconProps(code = SushiIconCodes.IconChevronRight)
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 9. Button with Both Icons
                    SushiButton(
                        props = SushiButtonProps(
                            text = "9. Both Icons",
                            type = SushiButtonType.Solid,
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                            suffixIcon = SushiIconProps(code = SushiIconCodes.IconChevronRight)
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 10. Only Icon Button
                    SushiButton(
                        props = SushiButtonProps(
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconPlus),
                            type = SushiButtonType.Solid,
                        ),
                        onClick = {},
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .size(48.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Custom Colors
                    SectionTitle("Custom Colors")
                    
                    // 11. Custom Background Color
                    SushiButton(
                        props = SushiButtonProps(
                            text = "11. Custom Background",
                            type = SushiButtonType.Solid,
                            color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 12. Custom Text Color
                    SushiButton(
                        props = SushiButtonProps(
                            text = "12. Custom Text Color",
                            type = SushiButtonType.Text,
                            fontColor = SushiColorData(ColorName.Red, ColorVariation.Variation500)
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 13. Custom Border Color
                    SushiButton(
                        props = SushiButtonProps(
                            text = "13. Custom Border",
                            type = SushiButtonType.Outline,
                            borderColor = SushiColorData(ColorName.Green, ColorVariation.Variation500)
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 14. Combined Custom Colors
                    SushiButton(
                        props = SushiButtonProps(
                            text = "14. Combined Colors",
                            type = SushiButtonType.Solid,
                            color = SushiColorData(ColorName.Yellow, ColorVariation.Variation200),
                            fontColor = SushiColorData(ColorName.Black, ColorVariation.Variation900)
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Button States
                    SectionTitle("Button States")
                    
                    // 15. Enabled Button (default)
                    SushiButton(
                        props = SushiButtonProps(
                            text = "15. Enabled Button",
                            type = SushiButtonType.Solid,
                            enabled = true
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 16. Disabled Button
                    SushiButton(
                        props = SushiButtonProps(
                            text = "16. Disabled Button",
                            type = SushiButtonType.Solid,
                            enabled = false
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 17. Disabled Text Button
                    SushiButton(
                        props = SushiButtonProps(
                            text = "17. Disabled Text Button",
                            type = SushiButtonType.Text,
                            enabled = false
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 18. Disabled Outline Button
                    SushiButton(
                        props = SushiButtonProps(
                            text = "18. Disabled Outline Button",
                            type = SushiButtonType.Outline,
                            enabled = false
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Text Alignment and Arrangement
                    SectionTitle("Alignment & Arrangement")
                    
                    // 19. Center Aligned Text
                    SushiButton(
                        props = SushiButtonProps(
                            text = "19. Center Aligned",
                            type = SushiButtonType.Solid,
                            textAlignment = Alignment.CenterHorizontally
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 20. Start Aligned Text
                    SushiButton(
                        props = SushiButtonProps(
                            text = "20. Start Aligned",
                            type = SushiButtonType.Solid,
                            textAlignment = Alignment.Start
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 21. End Aligned Text
                    SushiButton(
                        props = SushiButtonProps(
                            text = "21. End Aligned",
                            type = SushiButtonType.Solid,
                            textAlignment = Alignment.End
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 22. Space Between Content
                    SushiButton(
                        props = SushiButtonProps(
                            text = "22. Space Between",
                            type = SushiButtonType.Solid,
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconBack),
                            suffixIcon = SushiIconProps(code = SushiIconCodes.IconForward),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 23. Space Around Content
                    SushiButton(
                        props = SushiButtonProps(
                            text = "23. Space Around",
                            type = SushiButtonType.Solid,
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconBack),
                            suffixIcon = SushiIconProps(code = SushiIconCodes.IconForward),
                            horizontalArrangement = Arrangement.SpaceAround
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 24. Custom Icon Spacing
                    SushiButton(
                        props = SushiButtonProps(
                            text = "24. Custom Icon Spacing",
                            type = SushiButtonType.Solid,
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconCheck),
                            iconSpacing = 16.dp
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Custom Shapes
                    SectionTitle("Custom Shapes")
                    
                    // 25. Rounded Corner Shape
                    SushiButton(
                        props = SushiButtonProps(
                            text = "25. Rounded Corners",
                            type = SushiButtonType.Solid,
                            shape = RoundedCornerShape(16.dp)
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 26. Circular Button
                    SushiButton(
                        props = SushiButtonProps(
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconPlus),
                            type = SushiButtonType.Solid,
                            shape = CircleShape
                        ),
                        onClick = {},
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .size(56.dp)
                    )
                    
                    // 27. Pill Shape Button
                    SushiButton(
                        props = SushiButtonProps(
                            text = "27. Pill Shape",
                            type = SushiButtonType.Solid,
                            shape = RoundedCornerShape(50)
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 28. Custom Top Corners
                    SushiButton(
                        props = SushiButtonProps(
                            text = "28. Custom Top Corners",
                            type = SushiButtonType.Solid,
                            shape = RoundedCornerShape(
                                topStart = 16.dp, 
                                topEnd = 16.dp, 
                                bottomStart = 0.dp, 
                                bottomEnd = 0.dp
                            )
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Font Types
                    SectionTitle("Font Types")
                    
                    // 29. Regular Font
                    SushiButton(
                        props = SushiButtonProps(
                            text = "29. Regular Font",
                            type = SushiButtonType.Solid,
                            fontType = SushiTextType.Regular400
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 30. Bold Font
                    SushiButton(
                        props = SushiButtonProps(
                            text = "30. Bold Font",
                            type = SushiButtonType.Solid,
                            fontType = SushiTextType.Bold700
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 31. Light Font
                    SushiButton(
                        props = SushiButtonProps(
                            text = "31. Light Font",
                            type = SushiButtonType.Solid,
                            fontType = SushiTextType.Light300
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 32. ExtraBold Font
                    SushiButton(
                        props = SushiButtonProps(
                            text = "32. ExtraBold Font",
                            type = SushiButtonType.Solid,
                            fontType = SushiTextType.ExtraBold900
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Advanced Usage
                    SectionTitle("Advanced Usage")
                    
                    // 33. Button with Markdown
                    SushiButton(
                        props = SushiButtonProps(
                            text = "33. With **Bold** and _Italic_ text",
                            type = SushiButtonType.Solid,
                            markdown = true
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 34. Button with SubText
                    SushiButton(
                        props = SushiButtonProps(
                            text = "34. Main Text",
                            subText = "Secondary description here",
                            type = SushiButtonType.Solid
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 35. Colored Icon Button
                    SushiButton(
                        props = SushiButtonProps(
                            text = "35. Colored Icon",
                            type = SushiButtonType.Solid,
                            prefixIcon = SushiIconProps(
                                code = SushiIconCodes.IconStarFill,
                                color = SushiColorData(ColorName.Yellow, ColorVariation.Variation500)
                            )
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 36. Different Icon Sizes
                    SushiButton(
                        props = SushiButtonProps(
                            text = "36. Different Icon Sizes",
                            type = SushiButtonType.Solid,
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon, size = 24.dp.asIconSizeSpec()),
                            suffixIcon = SushiIconProps(code = SushiIconCodes.IconMoon, size = 16.dp.asIconSizeSpec())
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 37. Loading State Button (Simulated)
                    var isLoading by remember { mutableStateOf(false) }
                    SushiButton(
                        props = SushiButtonProps(
                            text = if (isLoading) "Loading..." else "37. Click to Load",
                            type = SushiButtonType.Solid,
                            enabled = !isLoading,
                            prefixIcon = if (isLoading) 
                                SushiIconProps(code = SushiIconCodes.IconRefresh) 
                                else null
                        ),
                        onClick = { 
                            isLoading = true
                            // In real app, you'd reset this after loading completes
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 38. Toggle Button (Simulated)
                    var isToggled by remember { mutableStateOf(false) }
                    SushiButton(
                        props = SushiButtonProps(
                            text = if (isToggled) "38. Turn Off" else "38. Turn On",
                            type = SushiButtonType.Solid,
                            color = if (isToggled) 
                                SushiColorData(ColorName.Green, ColorVariation.Variation500) 
                                else SushiColorData(ColorName.Grey, ColorVariation.Variation400),
                            prefixIcon = if (isToggled)
                                SushiIconProps(code = SushiIconCodes.IconCheck)
                                else SushiIconProps(code = SushiIconCodes.IconCross)
                        ),
                        onClick = { isToggled = !isToggled },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                    
                    // 39. Counter Button (Simulated)
                    var count by remember { mutableStateOf(0) }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        SushiButton(
                            props = SushiButtonProps(
                                prefixIcon = SushiIconProps(code = SushiIconCodes.IconMinus),
                                type = SushiButtonType.Outline,
                                shape = CircleShape
                            ),
                            onClick = { if (count > 0) count-- },
                            modifier = Modifier.size(40.dp)
                        )
                        
                        SushiText(
                            props = SushiTextProps(
                                text = "39. Count: $count",
                                type = SushiTextType.Medium500
                            ),
                            modifier = Modifier.padding(horizontal = 16.dp)
                                .align(Alignment.CenterVertically)
                        )
                        
                        SushiButton(
                            props = SushiButtonProps(
                                prefixIcon = SushiIconProps(code = SushiIconCodes.IconPlus),
                                type = SushiButtonType.Solid,
                                shape = CircleShape
                            ),
                            onClick = { count++ },
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    
                    // 40. Button Group
                    SectionTitle("40. Button Group")
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        SushiButton(
                            props = SushiButtonProps(
                                text = "Cancel",
                                type = SushiButtonType.Outline
                            ),
                            onClick = { },
                            modifier = Modifier.weight(1f)
                        )
                        
                        SushiButton(
                            props = SushiButtonProps(
                                text = "Save",
                                type = SushiButtonType.Solid
                            ),
                            onClick = { },
                            modifier = Modifier.weight(1f)
                        )
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
private fun ButtonShowcaseScreenPreview() {
    AppTheme {
        ButtonShowcaseScreen()
    }
}