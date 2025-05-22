package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.button.SushiButtonType
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCode
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.icon.SushiIconSize
import com.zomato.sushi.compose.atoms.image.SushiImageProps
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.components.dialogs.SushiAlertDialog
import com.zomato.sushi.compose.components.dialogs.SushiAlertDialogProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import composesushi.sushi_compose.generated.resources.Res
import composesushi.sushi_compose.generated.resources.sushi_rating_star
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.painterResource

@Serializable
object DialogShowcaseScreen

@Composable
fun DialogShowcaseScreen(
    modifier: Modifier = Modifier
) {
    BaseScreen(modifier) {
        // States to control dialog visibility
        var showBasicDialog by remember { mutableStateOf(false) }
        var showImageDialog by remember { mutableStateOf(false) }
        var showVerticalButtonsDialog by remember { mutableStateOf(false) }
        var showNonDismissibleDialog by remember { mutableStateOf(false) }
        var showCustomContentDialog by remember { mutableStateOf(false) }

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
                    title = "Dialog Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                // 1. Basic Dialog Example
                SectionTitle("1. Basic Dialog")
                SushiText(
                    props = SushiTextProps(
                        text = "A simple dialog with title, subtitle and basic actions",
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                SushiButton(
                    props = SushiButtonProps(
                        text = "Show Basic Dialog"
                    ),
                    onClick = { showBasicDialog = true },
                    modifier = Modifier.fillMaxWidth()
                )

                if (showBasicDialog) {
                    SushiAlertDialog(
                        props = SushiAlertDialogProps(
                            title = SushiTextProps(
                                text = "Confirm Action",
                                type = SushiTextType.Bold600,
                                textAlign = TextAlign.Center
                            ),
                            subtitle = SushiTextProps(
                                text = "Are you sure you want to proceed with this action?",
                                type = SushiTextType.Regular400,
                                textAlign = TextAlign.Center
                            ),
                            positiveButton = SushiButtonProps(
                                text = "Confirm",
                                type = SushiButtonType.Text,
                                horizontalArrangement = Arrangement.Center
                            ),
                            negativeButton = SushiButtonProps(
                                text = "Cancel",
                                type = SushiButtonType.Text,
                                horizontalArrangement = Arrangement.Center
                            )
                        ),
                        onDismissRequest = { showBasicDialog = false },
                        onPositiveButtonClick = { showBasicDialog = false },
                        onNegativeButtonClick = { showBasicDialog = false }
                    ) {
                        // Empty content for basic dialog
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Dialog with Image Example
                SectionTitle("2. Dialog with Image")
                SushiText(
                    props = SushiTextProps(
                        text = "A dialog with a header image and custom styling",
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                SushiButton(
                    props = SushiButtonProps(
                        text = "Show Dialog with Image"
                    ),
                    onClick = { showImageDialog = true },
                    modifier = Modifier.fillMaxWidth()
                )

                if (showImageDialog) {
                    SushiAlertDialog(
                        props = SushiAlertDialogProps(
                            image = SushiImageProps(
                                painter = painterResource(Res.drawable.sushi_rating_star),
                                contentScale = ContentScale.Fit,
                                bgColor = SushiTheme.colors.green.v100,
                                width = 80.dp,
                                height = 80.dp,
                                shape = CircleShape,
                                contentDescription = "Success",
                                colorFilter = ColorFilter.tint(
                                    SushiTheme.colors.green.v600.value,
                                    BlendMode.SrcIn
                                )
                            ),
                            title = SushiTextProps(
                                text = "Success!",
                                type = SushiTextType.Bold700,
                                color = SushiTheme.colors.green.v700,
                                textAlign = TextAlign.Center
                            ),
                            subtitle = SushiTextProps(
                                text = "Your order has been placed successfully. You will receive a confirmation shortly.",
                                type = SushiTextType.Regular400,
                                textAlign = TextAlign.Center
                            ),
                            positiveButton = SushiButtonProps(
                                text = "OK",
                                type = SushiButtonType.Text,
                                horizontalArrangement = Arrangement.Center,
                                fontColor = SushiTheme.colors.green.v700
                            )
                        ),
                        onDismissRequest = { showImageDialog = false },
                        onPositiveButtonClick = { showImageDialog = false }
                    ) {
                        // No additional content
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Dialog with Vertical Buttons Example
                SectionTitle("3. Dialog with Vertical Buttons")
                SushiText(
                    props = SushiTextProps(
                        text = "A dialog with buttons arranged vertically instead of horizontally",
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                SushiButton(
                    props = SushiButtonProps(
                        text = "Show Dialog with Vertical Buttons"
                    ),
                    onClick = { showVerticalButtonsDialog = true },
                    modifier = Modifier.fillMaxWidth()
                )

                if (showVerticalButtonsDialog) {
                    SushiAlertDialog(
                        props = SushiAlertDialogProps(
                            title = SushiTextProps(
                                text = "Rate Your Experience",
                                type = SushiTextType.Bold600,
                                textAlign = TextAlign.Center
                            ),
                            subtitle = SushiTextProps(
                                text = "How would you rate your food delivery experience?",
                                type = SushiTextType.Regular400,
                                textAlign = TextAlign.Center
                            ),
                            alignment = SushiAlertDialogProps.ButtonAlignment.Vertical,
                            positiveButton = SushiButtonProps(
                                text = "Excellent",
                                type = SushiButtonType.Text,
                                horizontalArrangement = Arrangement.Center
                            ),
                            negativeButton = SushiButtonProps(
                                text = "Average",
                                type = SushiButtonType.Text,
                                horizontalArrangement = Arrangement.Center
                            ),
                            neutralButton = SushiButtonProps(
                                text = "Poor",
                                type = SushiButtonType.Text,
                                horizontalArrangement = Arrangement.Center
                            )
                        ),
                        onDismissRequest = { showVerticalButtonsDialog = false },
                        onPositiveButtonClick = { showVerticalButtonsDialog = false },
                        onNegativeButtonClick = { showVerticalButtonsDialog = false },
                        onNeutralButtonClick = { showVerticalButtonsDialog = false }
                    ) {
                        // Rating content could go here
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Non-Dismissible Dialog Example
                SectionTitle("4. Non-Dismissible Dialog")
                SushiText(
                    props = SushiTextProps(
                        text = "A dialog that can't be dismissed by clicking outside or pressing back",
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                SushiButton(
                    props = SushiButtonProps(
                        text = "Show Non-Dismissible Dialog"
                    ),
                    onClick = { showNonDismissibleDialog = true },
                    modifier = Modifier.fillMaxWidth()
                )

                if (showNonDismissibleDialog) {
                    SushiAlertDialog(
                        props = SushiAlertDialogProps(
                            title = SushiTextProps(
                                text = "Important Notice",
                                type = SushiTextType.Bold600,
                                color = SushiTheme.colors.red.v600,
                                textAlign = TextAlign.Center
                            ),
                            subtitle = SushiTextProps(
                                text = "This action is important and requires your explicit confirmation. You must press the 'I Understand' button to continue.",
                                type = SushiTextType.Regular400,
                                textAlign = TextAlign.Center
                            ),
                            positiveButton = SushiButtonProps(
                                text = "I Understand",
                                type = SushiButtonType.Text,
                                horizontalArrangement = Arrangement.Center
                            ),
                            dismissOnBackPress = false,
                            dismissOnClickOutside = false
                        ),
                        onDismissRequest = { /* Cannot dismiss except by button */ },
                        onPositiveButtonClick = { showNonDismissibleDialog = false }
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            SushiIcon(
                                props = SushiIconProps(
                                    code = SushiIconCodes.IconExclamation,
                                    size = SushiIconSize.Size700,
                                    color = SushiTheme.colors.red.v500
                                )
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 5. Dialog with Custom Content Example
                SectionTitle("5. Dialog with Rich Custom Content")
                SushiText(
                    props = SushiTextProps(
                        text = "A dialog with rich custom content and styling",
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                SushiButton(
                    props = SushiButtonProps(
                        text = "Show Custom Content Dialog"
                    ),
                    onClick = { showCustomContentDialog = true },
                    modifier = Modifier.fillMaxWidth()
                )

                if (showCustomContentDialog) {
                    SushiAlertDialog(
                        props = SushiAlertDialogProps(
                            title = SushiTextProps(
                                text = "Delivery Options",
                                type = SushiTextType.Bold600,
                                textAlign = TextAlign.Center
                            ),
                            positiveButton = SushiButtonProps(
                                text = "Confirm",
                                type = SushiButtonType.Text,
                                horizontalArrangement = Arrangement.Center
                            ),
                            negativeButton = SushiButtonProps(
                                text = "Cancel",
                                type = SushiButtonType.Text,
                                horizontalArrangement = Arrangement.Center
                            )
                        ),
                        onDismissRequest = { showCustomContentDialog = false },
                        onPositiveButtonClick = { showCustomContentDialog = false },
                        onNegativeButtonClick = { showCustomContentDialog = false }
                    ) {
                        // Rich custom content
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp, vertical = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            // Option 1
                            DeliveryOption(
                                icon = SushiIconCodes.IconDelivery,
                                title = "Standard Delivery",
                                description = "Will arrive in 30-45 minutes",
                                price = "₹40",
                                color = SushiTheme.colors.blue.v500
                            )

                            // Option 2
                            DeliveryOption(
                                icon = SushiIconCodes.IconScooterSharp,
                                title = "Express Delivery",
                                description = "Will arrive in 15-20 minutes",
                                price = "₹60",
                                color = SushiTheme.colors.green.v600
                            )

                            // Option 3
                            DeliveryOption(
                                icon = SushiIconCodes.IconDinning,
                                title = "Self Pickup",
                                description = "Ready in 15 minutes",
                                price = "Free",
                                color = SushiTheme.colors.orange.v500
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DeliveryOption(
    icon: SushiIconCode,
    title: String,
    description: String,
    price: String,
    color: ColorSpec
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Icon
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                SushiIcon(
                    props = SushiIconProps(
                        code = icon,
                        size = SushiIconSize.Size500,
                        color = color
                    )
                )
            }

            // Content
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                SushiText(
                    props = SushiTextProps(
                        text = title,
                        type = SushiTextType.Medium500
                    )
                )

                SushiText(
                    props = SushiTextProps(
                        text = description,
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    )
                )
            }

            // Price
            SushiText(
                props = SushiTextProps(
                    text = price,
                    type = SushiTextType.SemiBold600,
                    color = color
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
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
@SushiPreview
private fun DialogShowcaseScreenPreview() {
    AppTheme {
        DialogShowcaseScreen()
    }
}