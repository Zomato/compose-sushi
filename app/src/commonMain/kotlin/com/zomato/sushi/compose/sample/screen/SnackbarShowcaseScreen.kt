package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.snackbar.SushiSnackbarDuration
import com.zomato.sushi.compose.atoms.snackbar.SushiSnackbarProps
import com.zomato.sushi.compose.atoms.snackbar.host.SushiSnackbarHost
import com.zomato.sushi.compose.atoms.snackbar.host.SushiSnackbarHostState
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
object SnackbarShowcaseScreen

@Composable
fun SnackbarShowcaseScreen(
    modifier: Modifier = Modifier
) {
    BaseScreen(modifier) {
        val snackbarHostState = remember { SushiSnackbarHostState() }
        val scope = rememberCoroutineScope()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = SushiTheme.colors.surface.primary.value,
            snackbarHost = {
                SushiSnackbarHost(
                    hostState = snackbarHostState,
                    modifier = Modifier.padding(16.dp)
                )
            }
        ) { innerPadding ->
            Column(
                Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {
                AppTopBar(
                    title = "Snackbar Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                // Example 1: Basic Snackbar
                SectionTitle("1. Basic Snackbar")
                SushiText(
                    props = SushiTextProps(
                        text = "A simple snackbar with default styling and short duration",
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                SushiButton(
                    props = SushiButtonProps(
                        text = "Show Basic Snackbar",
                        prefixIcon = SushiIconProps(code = SushiIconCodes.IconNotificationLine)
                    ),
                    onClick = {
                        scope.launch {
                            val snackbarProps = SushiSnackbarProps(
                                message = SushiTextProps(
                                    text = "This is a basic snackbar message",
                                    type = SushiTextType.Regular400
                                ),
                                snackbarDuration = SushiSnackbarDuration.Short
                            )
                            snackbarHostState.showSnackbar(snackbarProps)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Example 2: Snackbar with Action
                SectionTitle("2. Snackbar with Action")
                SushiText(
                    props = SushiTextProps(
                        text = "A snackbar with an action button that can be pressed to dismiss the snackbar",
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                SushiButton(
                    props = SushiButtonProps(
                        text = "Show Snackbar with Action",
                        prefixIcon = SushiIconProps(code = SushiIconCodes.IconReturn)
                    ),
                    onClick = {
                        scope.launch {
                            val snackbarProps = SushiSnackbarProps(
                                message = SushiTextProps(
                                    text = "Item removed from cart",
                                    type = SushiTextType.Regular400
                                ),
                                actionText = SushiTextProps(
                                    text = "UNDO",
                                    type = SushiTextType.SemiBold600
                                ),
                                snackbarDuration = SushiSnackbarDuration.Long
                            )
                            snackbarHostState.showSnackbar(snackbarProps)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Example 3: Custom colored Snackbar
                SectionTitle("3. Custom Colored Snackbar")
                SushiText(
                    props = SushiTextProps(
                        text = "A snackbar with custom background and text colors",
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                val white = SushiTheme.colors.white
                val success = SushiTheme.colors.surface.success
                SushiButton(
                    props = SushiButtonProps(
                        text = "Show Success Snackbar",
                        prefixIcon = SushiIconProps(code = SushiIconCodes.IconCheckCircle)
                    ),
                    onClick = {
                        scope.launch {
                            val snackbarProps = SushiSnackbarProps(
                                message = SushiTextProps(
                                    text = "Payment successful!",
                                    type = SushiTextType.Medium500,
                                    color = white
                                ),
                                containerColor = success,
                                contentColor = white,
                                snackbarDuration = SushiSnackbarDuration.Short
                            )
                            snackbarHostState.showSnackbar(snackbarProps)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                SushiButton(
                    props = SushiButtonProps(
                        text = "Show Error Snackbar",
                        prefixIcon = SushiIconProps(code = SushiIconCodes.IconExclamationTriangle)
                    ),
                    onClick = {
                        scope.launch {
                            val snackbarProps = SushiSnackbarProps(
                                message = SushiTextProps(
                                    text = "Network error occurred",
                                    type = SushiTextType.Medium500,
                                    color = white
                                ),
                                containerColor = SushiColorData(
                                    ColorName.Red,
                                    ColorVariation.Variation600
                                ),
                                contentColor = white,
                                snackbarDuration = SushiSnackbarDuration.Short
                            )
                            snackbarHostState.showSnackbar(snackbarProps)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Example 4: Indefinite Duration Snackbar
                SectionTitle("4. Indefinite Duration Snackbar")
                SushiText(
                    props = SushiTextProps(
                        text = "A snackbar that stays visible until explicitly dismissed",
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                val blue500 = SushiTheme.colors.blue.v500
                SushiButton(
                    props = SushiButtonProps(
                        text = "Show Indefinite Snackbar",
                        prefixIcon = SushiIconProps(code = SushiIconCodes.IconInfo)
                    ),
                    onClick = {
                        scope.launch {
                            val snackbarProps = SushiSnackbarProps(
                                message = SushiTextProps(
                                    text = "This message won't disappear automatically",
                                    type = SushiTextType.Regular400
                                ),
                                actionText = SushiTextProps(
                                    text = "DISMISS",
                                    type = SushiTextType.SemiBold600,
                                    color = blue500
                                ),
                                snackbarDuration = SushiSnackbarDuration.Indefinite
                            )
                            snackbarHostState.showSnackbar(snackbarProps)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                SushiButton(
                    props = SushiButtonProps(
                        text = "Cancel Current Snackbar",
                        prefixIcon = SushiIconProps(code = SushiIconCodes.IconCross)
                    ),
                    onClick = {
                        scope.launch {
                            snackbarHostState.cancelSnackbar()
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Example 5: Custom Content Snackbar
                SectionTitle("5. Custom Content Snackbar")
                SushiText(
                    props = SushiTextProps(
                        text = "A snackbar with custom layout and content",
                        type = SushiTextType.Regular400,
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                val theme500 = SushiTheme.colors.base.theme.v500
                val surfaceSecondary = SushiTheme.colors.surface.secondary
                SushiButton(
                    props = SushiButtonProps(
                        text = "Show Custom Content Snackbar",
                        prefixIcon = SushiIconProps(code = SushiIconCodes.IconPackaging)
                    ),
                    onClick = {
                        scope.launch {
//                            // For custom content, we'll just use a simple props object but
//                            // when the snackbar is shown, we'll provide a custom content function
//                            val snackbarProps = SushiSnackbarProps(
//                                snackbarDuration = SushiSnackbarDuration.Long
//                            )
//
//                            // We'll use showCustomSnackbar, a hypothetical extension function
//                            // that allows passing a custom content composable
//                            snackbarHostState.showSnackbar(snackbarProps)

                            // In a real implementation, you'd use the SushiSnackbarHost to show
                            // a custom snackbar directly, but for this example we'll just show
                            // a regular snackbar with more complex content
                            val customProps = SushiSnackbarProps(
                                message = SushiTextProps(
                                    text = "Order #12345 is out for delivery",
                                    type = SushiTextType.SemiBold600
                                ),
                                actionText = SushiTextProps(
                                    text = "TRACK",
                                    type = SushiTextType.Bold700,
                                    color = theme500
                                ),
                                snackbarDuration = SushiSnackbarDuration.Long,
                                containerColor = surfaceSecondary
                            )
                            snackbarHostState.showSnackbar(customProps)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                // Add a tall spacer at the bottom to ensure all content is visible
                // when a snackbar is displayed
                Spacer(modifier = Modifier.height(80.dp))
            }
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
private fun SnackbarShowcaseScreenPreview() {
    AppTheme {
        SnackbarShowcaseScreen()
    }
}
