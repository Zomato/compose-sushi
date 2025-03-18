package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.icon.SushiIconSize
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.components.bottomsheet.SushiBottomSheet
import com.zomato.sushi.compose.components.bottomsheet.SushiBottomSheetProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.BaseScreen
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
object BottomSheetShowcaseScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetShowcaseScreen(
    modifier: Modifier = Modifier
) {
    BaseScreen(modifier) {
        // States for controlling bottom sheet visibility
        var showBasicBottomSheet by remember { mutableStateOf(false) }
        var showColoredBottomSheet by remember { mutableStateOf(false) }
        var showCustomShapeBottomSheet by remember { mutableStateOf(false) }
        var showNonDismissibleBottomSheet by remember { mutableStateOf(false) }

        // Sheet states
        val basicSheetState = rememberModalBottomSheetState()
        val coloredSheetState = rememberModalBottomSheetState()
        val customShapeSheetState = rememberModalBottomSheetState()
        val nonDismissibleSheetState = rememberModalBottomSheetState(confirmValueChange = { false}, skipPartiallyExpanded = true)

        val scope = rememberCoroutineScope()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = SushiTheme.colors.surface.primary.value
        ) { innerPadding ->
            Column(
                Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 24.dp)
            ) {
                AppTopBar(
                    title = "BottomSheet Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                // 1. Basic Bottom Sheet Example
                SectionTitle("1. Basic Bottom Sheet")
                SushiText(
                    props = SushiTextProps(
                        text = "A simple bottom sheet with default properties",
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                SushiButton(
                    props = SushiButtonProps(
                        text = "Show Basic Bottom Sheet",
                        prefixIcon = SushiIconProps(code = SushiIconCodes.IconMerCancel)
                    ),
                    onClick = { showBasicBottomSheet = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )

                // Display the basic bottom sheet when triggered
                if (showBasicBottomSheet) {
                    SushiBottomSheet(
                        props = SushiBottomSheetProps(),  // Using default props
                        onDismissRequest = { showBasicBottomSheet = false },
                        sheetState = basicSheetState
                    ) {
                        BasicSheetContent(
                            title = "Basic Bottom Sheet",
                            description = "This is a basic bottom sheet with default properties. It uses the default shape, colors, and elevation.",
                            onDismiss = {
                                scope.launch {
                                    basicSheetState.hide()
                                    showBasicBottomSheet = false
                                }
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Colored Bottom Sheet Example
                SectionTitle("2. Custom Colored Bottom Sheet")
                SushiText(
                    props = SushiTextProps(
                        text = "A bottom sheet with custom container and content colors",
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                SushiButton(
                    props = SushiButtonProps(
                        text = "Show Colored Bottom Sheet",
                        prefixIcon = SushiIconProps(code = SushiIconCodes.IconCloudRain)
                    ),
                    onClick = { showColoredBottomSheet = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )

                // Display the colored bottom sheet when triggered
                if (showColoredBottomSheet) {
                    SushiBottomSheet(
                        props = SushiBottomSheetProps(
                            containerColor = SushiTheme.colors.blue.v050,  // Light blue background
                            contentColor = SushiTheme.colors.blue.v900    // Dark blue text
                        ),
                        onDismissRequest = { showColoredBottomSheet = false },
                        sheetState = coloredSheetState
                    ) {
                        BasicSheetContent(
                            title = "Colored Bottom Sheet",
                            description = "This bottom sheet uses custom containerColor and contentColor properties. The container has a light blue background, and the text content uses dark blue color.",
                            onDismiss = {
                                scope.launch {
                                    coloredSheetState.hide()
                                    showColoredBottomSheet = false
                                }
                            },
                            isDarkTheme = false
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Custom Shape Bottom Sheet Example
                SectionTitle("3. Custom Shape Bottom Sheet")
                SushiText(
                    props = SushiTextProps(
                        text = "A bottom sheet with a custom rounded corner shape",
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                SushiButton(
                    props = SushiButtonProps(
                        text = "Show Custom Shape Bottom Sheet",
                        prefixIcon = SushiIconProps(code = SushiIconCodes.IconBell)
                    ),
                    onClick = { showCustomShapeBottomSheet = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )

                // Display the custom shape bottom sheet when triggered
                if (showCustomShapeBottomSheet) {
                    SushiBottomSheet(
                        props = SushiBottomSheetProps(
                            shape = RoundedCornerShape(
                                topStart = 48.dp,
                                topEnd = 48.dp
                            )
                        ),
                        onDismissRequest = { showCustomShapeBottomSheet = false },
                        sheetState = customShapeSheetState
                    ) {
                        BasicSheetContent(
                            title = "Custom Shape Bottom Sheet",
                            description = "This bottom sheet uses a custom shape with much more rounded corners (48dp radius). The default is 28dp.",
                            onDismiss = {
                                scope.launch {
                                    customShapeSheetState.hide()
                                    showCustomShapeBottomSheet = false
                                }
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Non-Dismissible Bottom Sheet Example
                SectionTitle("4. Non-Dismissible Bottom Sheet")
                SushiText(
                    props = SushiTextProps(
                        text = "A bottom sheet that can't be dismissed by tapping outside or swiping",
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                SushiButton(
                    props = SushiButtonProps(
                        text = "Show Non-Dismissible Bottom Sheet",
                        prefixIcon = SushiIconProps(code = SushiIconCodes.IconLockLine)
                    ),
                    onClick = { showNonDismissibleBottomSheet = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )

                // Display the non-dismissible bottom sheet when triggered
                if (showNonDismissibleBottomSheet) {
                    SushiBottomSheet(
                        props = SushiBottomSheetProps(
                            properties = ModalBottomSheetProperties(
                                shouldDismissOnBackPress = false
                            )
                        ),
                        onDismissRequest = { /* No-op, user can't dismiss directly */ },
                        sheetState = nonDismissibleSheetState
                    ) {
                        BasicSheetContent(
                            title = "Non-Dismissible Bottom Sheet",
                            description = "This bottom sheet cannot be dismissed by tapping outside or swiping down. You must explicitly press the 'Close' button to dismiss it.",
                            onDismiss = {
                                scope.launch {
                                    nonDismissibleSheetState.hide()
                                    showNonDismissibleBottomSheet = false
                                }
                            },
                            buttonText = "Close (Only Way Out)"
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ColumnScope.BasicSheetContent(
    title: String,
    description: String,
    onDismiss: () -> Unit,
    buttonText: String = "Close",
    isDarkTheme: Boolean = true
) {
    val textColor = if (isDarkTheme)
        SushiTheme.colors.text.primary
    else
        SushiTheme.colors.blue.v900

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SushiText(
            props = SushiTextProps(
                text = title,
                type = SushiTextType.Bold700,
                color = textColor
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        SushiText(
            props = SushiTextProps(
                text = description,
                type = SushiTextType.Regular400,
                color = textColor,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Example content: sample items
        repeat(2) { index ->
            BottomSheetItemRow(index, isDarkTheme)

            if (index < 2) {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        SushiButton(
            props = SushiButtonProps(text = buttonText),
            onClick = onDismiss,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun BottomSheetItemRow(
    index: Int,
    isDarkTheme: Boolean = true
) {
    val icons = listOf(
        SushiIconCodes.IconDelivery,
        SushiIconCodes.IconDinning
    )

    val titles = listOf(
        "Delivery",
        "Dine In"
    )

    val descriptions = listOf(
        "Food delivered to your doorstep",
        "Reserve a table at the restaurant",
        "Order ahead and pick up your food"
    )

    val textColor = if (isDarkTheme)
        SushiTheme.colors.text.primary
    else
        SushiTheme.colors.blue.v900

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(
                    if (isDarkTheme) SushiTheme.colors.surface.secondary.value
                    else SushiTheme.colors.blue.v100.value
                ),
            contentAlignment = Alignment.Center
        ) {
            SushiIcon(
                props = SushiIconProps(
                    code = icons[index],
                    size = SushiIconSize.Size400,
                    color = if (isDarkTheme)
                        SushiTheme.colors.text.primary
                    else
                        SushiTheme.colors.blue.v600
                )
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Text content
        Column(modifier = Modifier.weight(1f)) {
            SushiText(
                props = SushiTextProps(
                    text = titles[index],
                    type = SushiTextType.SemiBold600,
                    color = textColor
                )
            )

            SushiText(
                props = SushiTextProps(
                    text = descriptions[index],
                    type = SushiTextType.Regular400,
                    color = textColor
                )
            )
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    SushiText(
        props = SushiTextProps(
            text = title,
            type = SushiTextType.Bold600,
            color = SushiTheme.colors.text.primary
        ),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
@SushiPreview
private fun BottomSheetShowcaseScreenPreview() {
    AppTheme {
        BottomSheetShowcaseScreen()
    }
}