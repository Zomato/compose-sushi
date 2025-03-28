package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.components.otptextfield.SushiOTPState
import com.zomato.sushi.compose.components.otptextfield.SushiOTPTextField
import com.zomato.sushi.compose.components.otptextfield.SushiOTPTextFieldColors
import com.zomato.sushi.compose.components.otptextfield.SushiOTPTextFieldDefaults
import com.zomato.sushi.compose.components.otptextfield.SushiOTPTextFieldType
import com.zomato.sushi.compose.components.otptextfield.SushiOutlinedOTPTextField
import com.zomato.sushi.compose.components.otptextfield.SushiUnderlinedOTPTextField
import com.zomato.sushi.compose.components.otptextfield.rememberOtpState
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.sample.BaseScreen
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import kotlinx.serialization.Serializable

@Serializable
object OTPInputShowcaseScreen

@Composable
fun OTPInputShowcaseScreen(
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
                    title = "OTP Input Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                // 1. Basic Filled OTP TextField (Default style)
                SectionTitle("1. Basic Filled OTP TextField")
                SectionDescription("Default style with 6 digits")

                val otpState1 = rememberOtpState(6)
                SushiOTPTextField(
                    state = otpState1,
                    autoFocus = false,
                    onComplete = { code ->
                        // Handle the completed OTP
                    }
                )

                OtpStatus(otpState1)

                Spacer(modifier = Modifier.height(24.dp))

                // 2. Outlined OTP TextField
                SectionTitle("2. Outlined OTP TextField")
                SectionDescription("Outlined style with 6 digits")

                val otpState2 = rememberOtpState(6)
                SushiOutlinedOTPTextField(
                    state = otpState2,
                    autoFocus = false,
                    onComplete = { code ->
                        // Handle the completed OTP
                    }
                )

                OtpStatus(otpState2)

                Spacer(modifier = Modifier.height(24.dp))

                // 3. Underlined OTP TextField
                SectionTitle("3. Underlined OTP TextField")
                SectionDescription("Underlined style with 6 digits")

                val otpState3 = rememberOtpState(6)
                SushiUnderlinedOTPTextField(
                    state = otpState3,
                    autoFocus = false,
                    onComplete = { code ->
                        // Handle the completed OTP
                    }
                )

                OtpStatus(otpState3)

                Spacer(modifier = Modifier.height(24.dp))

                // 4. Custom Length OTP (4 digits)
                SectionTitle("4. Custom Length OTP (4 digits)")
                SectionDescription("Filled OTP with 4 digits instead of 6")

                val otpState4 = rememberOtpState(4)
                SushiOTPTextField(
                    state = otpState4,
                    autoFocus = false,
                    onComplete = { code ->
                        // Handle the completed OTP
                    }
                )

                OtpStatus(otpState4)

                Spacer(modifier = Modifier.height(24.dp))

                // 5. Custom Text Style
                SectionTitle("5. Custom Text Style")
                SectionDescription("OTP field with custom text styling")

                val otpState5 = rememberOtpState(6)
                SushiOTPTextField(
                    state = otpState5,
                    autoFocus = false,
                    textStyle = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = SushiTheme.colors.blue.v700.value
                    ),
                    onComplete = { code ->
                        // Handle the completed OTP
                    }
                )

                OtpStatus(otpState5)

                Spacer(modifier = Modifier.height(24.dp))

                // 6. Password Transformation
                SectionTitle("6. Password Transformation")
                SectionDescription("Masked OTP input for sensitive codes")

                val otpState6 = rememberOtpState(6)
                SushiOTPTextField(
                    state = otpState6,
                    autoFocus = false,
                    visualTransformation = PasswordVisualTransformation(),
                    onComplete = { code ->
                        // Handle the completed OTP
                    }
                )

                OtpStatus(otpState6)

                Spacer(modifier = Modifier.height(24.dp))

                // 7. Custom Colors with Filled Style
                SectionTitle("7. Custom Colors (Filled Style)")
                SectionDescription("Filled OTP with custom colors")

                val otpState7 = rememberOtpState(6)
                val customFilledColors = SushiOTPTextFieldDefaults.filledColors().copy(
                    focusedContainerColor = SushiTheme.colors.blue.v100,
                    unfocusedContainerColor = SushiTheme.colors.blue.v050,
                    focusedTextColor = SushiTheme.colors.blue.v900,
                    unfocusedTextColor = SushiTheme.colors.blue.v700,
                    cursorColor = SushiTheme.colors.blue.v600
                )

                SushiOTPTextField(
                    state = otpState7,
                    autoFocus = false,
                    colors = customFilledColors,
                    onComplete = { code ->
                        // Handle the completed OTP
                    }
                )

                OtpStatus(otpState7)

                Spacer(modifier = Modifier.height(24.dp))

                // 8. Custom Colors with Outlined Style
                SectionTitle("8. Custom Colors (Outlined Style)")
                SectionDescription("Outlined OTP with custom colors")

                val otpState8 = rememberOtpState(6)
                val customOutlinedColors = SushiOTPTextFieldDefaults.outlinedColors().copy(
                    focusedOutlineColor = SushiTheme.colors.orange.v600,
                    unfocusedOutlineColor = SushiTheme.colors.orange.v400,
                    focusedTextColor = SushiTheme.colors.orange.v900,
                    unfocusedTextColor = SushiTheme.colors.orange.v700,
                    cursorColor = SushiTheme.colors.orange.v600
                )

                SushiOutlinedOTPTextField(
                    state = otpState8,
                    autoFocus = false,
                    colors = customOutlinedColors,
                    onComplete = { code ->
                        // Handle the completed OTP
                    }
                )

                OtpStatus(otpState8)

                Spacer(modifier = Modifier.height(24.dp))

                // 9. Custom Colors with Underlined Style
                SectionTitle("9. Custom Colors (Underlined Style)")
                SectionDescription("Underlined OTP with custom colors")

                val otpState9 = rememberOtpState(6)
                val customUnderlinedColors = SushiOTPTextFieldDefaults.underlinedColors().copy(
                    focusedOutlineColor = SushiTheme.colors.green.v600,
                    unfocusedOutlineColor = SushiTheme.colors.green.v400,
                    focusedTextColor = SushiTheme.colors.green.v900,
                    unfocusedTextColor = SushiTheme.colors.green.v700,
                    cursorColor = SushiTheme.colors.green.v600
                )

                SushiUnderlinedOTPTextField(
                    state = otpState9,
                    autoFocus = false,
                    colors = customUnderlinedColors,
                    onComplete = { code ->
                        // Handle the completed OTP
                    }
                )

                OtpStatus(otpState9)

                Spacer(modifier = Modifier.height(24.dp))

                // 10. Error State
                SectionTitle("10. Error State")
                SectionDescription("OTP field in error state")

                val otpState10 = rememberOtpState(6)
                SushiOTPTextField(
                    state = otpState10,
                    autoFocus = false,
                    isError = true,
                    onComplete = { code ->
                        // Handle the completed OTP
                    }
                )

                OtpStatus(otpState10)

                Spacer(modifier = Modifier.height(24.dp))

                // 11. Error State with Outlined Style
                SectionTitle("11. Error State (Outlined Style)")
                SectionDescription("Outlined OTP field in error state")

                val otpState11 = rememberOtpState(6)
                SushiOutlinedOTPTextField(
                    state = otpState11,
                    autoFocus = false,
                    isError = true,
                    onComplete = { code ->
                        // Handle the completed OTP
                    }
                )

                OtpStatus(otpState11)

                Spacer(modifier = Modifier.height(24.dp))

                // 12. Disabled State
                SectionTitle("12. Disabled State")
                SectionDescription("Disabled OTP field")

                val otpState12 = rememberOtpState(6)
                SushiOTPTextField(
                    state = otpState12,
                    autoFocus = false,
                    enabled = false,
                    onComplete = { code ->
                        // Handle the completed OTP
                    }
                )

                OtpStatus(otpState12)

                Spacer(modifier = Modifier.height(24.dp))

                // 13. Read-Only State
                SectionTitle("13. Read-Only State")
                SectionDescription("Read-only OTP field (pre-filled)")

                val otpState13 = rememberOtpState(6)
                otpState13.onDigitEntered(0, '1')
                otpState13.onDigitEntered(1, '2')
                otpState13.onDigitEntered(2, '3')
                otpState13.onDigitEntered(3, '4')
                otpState13.onDigitEntered(4, '5')
                otpState13.onDigitEntered(5, '6')

                SushiOTPTextField(
                    state = otpState13,
                    autoFocus = false,
                    readOnly = true,
                    onComplete = { code ->
                        // Handle the completed OTP
                    }
                )

                OtpStatus(otpState13)

                Spacer(modifier = Modifier.height(24.dp))

                // 14. Alphanumeric Keyboard
                SectionTitle("14. Alphanumeric Keyboard")
                SectionDescription("OTP field that accepts letters and numbers")

                val otpState14 = rememberOtpState(6)
                SushiOTPTextField(
                    state = otpState14,
                    autoFocus = false,
                    keyboardType = KeyboardType.Text,
                    onComplete = { code ->
                        // Handle the completed OTP
                    }
                )

                OtpStatus(otpState14)

                Spacer(modifier = Modifier.height(24.dp))

                // 15. Email Verification Code (with Auto-Complete Handler)
                SectionTitle("15. Email Verification Code")
                SectionDescription("OTP field with auto-complete handler")

                val otpState15 = rememberOtpState(6)
                var verificationStatus by remember { mutableStateOf("Waiting for code...") }

                SushiOTPTextField(
                    state = otpState15,
                    autoFocus = false,
                    onComplete = { code ->
                        verificationStatus = "Verifying code: $code..."
                        // Simulate verification
                        if (code == "123456") {
                            verificationStatus = "Code verified successfully!"
                        } else {
                            verificationStatus = "Invalid verification code"
                        }
                    }
                )

                SushiText(
                    props = SushiTextProps(
                        text = verificationStatus,
                        type = SushiTextType.Medium400,
                        color = if (verificationStatus.contains("successfully"))
                            SushiTheme.colors.green.v600
                        else if (verificationStatus.contains("Invalid"))
                            SushiTheme.colors.red.v600
                        else
                            SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(top = 8.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SushiButton(
                        props = SushiButtonProps(text = "Try correct code"),
                        onClick = {
                            otpState15.onDigitEntered(0, '1')
                            otpState15.onDigitEntered(1, '2')
                            otpState15.onDigitEntered(2, '3')
                            otpState15.onDigitEntered(3, '4')
                            otpState15.onDigitEntered(4, '5')
                            otpState15.onDigitEntered(5, '6')
                        },
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    SushiButton(
                        props = SushiButtonProps(text = "Try wrong code"),
                        onClick = {
                            otpState15.onDigitEntered(0, '9')
                            otpState15.onDigitEntered(1, '8')
                            otpState15.onDigitEntered(2, '7')
                            otpState15.onDigitEntered(3, '6')
                            otpState15.onDigitEntered(4, '5')
                            otpState15.onDigitEntered(5, '4')
                        },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // 16. OTP with Card Background
                SectionTitle("16. OTP with Card Background")
                SectionDescription("OTP field inside a card container")

                val otpState16 = rememberOtpState(6)
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = SushiTheme.colors.surface.secondary.value
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        SushiText(
                            props = SushiTextProps(
                                text = "Enter verification code",
                                type = SushiTextType.Medium500
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        SushiOTPTextField(
                            state = otpState16,
                            autoFocus = false,
                            onComplete = { code ->
                                // Handle the completed OTP
                            }
                        )
                    }
                }

                OtpStatus(otpState16)

                Spacer(modifier = Modifier.height(24.dp))

                // 18. Circular OTP Fields
                SectionTitle("18. Styled OTP with Custom Container")
                SectionDescription("OTP with custom container styling")

                val otpState18 = rememberOtpState(6)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .background(SushiTheme.colors.blue.v050.value, RoundedCornerShape(16.dp))
                        .border(2.dp, SushiTheme.colors.blue.v200.value, RoundedCornerShape(16.dp))
                        .padding(16.dp)
                ) {
                    Column {
                        SushiText(
                            props = SushiTextProps(
                                text = "Enter OTP sent to +1 (555) 123-4567",
                                type = SushiTextType.Medium500,
                                color = SushiTheme.colors.blue.v900
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        SushiOTPTextField(
                            state = otpState18,
                            autoFocus = false,
                            colors = SushiOTPTextFieldDefaults.filledColors().copy(
                                focusedContainerColor = SushiTheme.colors.blue.v200,
                                unfocusedContainerColor = SushiTheme.colors.blue.v100,
                                focusedTextColor = SushiTheme.colors.blue.v900,
                                unfocusedTextColor = SushiTheme.colors.blue.v700
                            ),
                            onComplete = { code ->
                                // Handle the completed OTP
                            }
                        )
                    }
                }

                OtpStatus(otpState18)

                Spacer(modifier = Modifier.height(24.dp))

                // 19. Reset OTP Button
                SectionTitle("19. OTP with Reset Button")
                SectionDescription("OTP field with a button to clear/reset input")

                val otpState19 = rememberOtpState(6)
                Column {
                    SushiOTPTextField(
                        state = otpState19,
                        autoFocus = false,
                        onComplete = { code ->
                            // Handle the completed OTP
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    SushiButton(
                        props = SushiButtonProps(text = "Reset OTP"),
                        onClick = {
                            // Reset OTP by clearing all digits
                            for (i in 0 until 6) {
                                otpState19.onDigitDeleted(i)
                            }
                        },
                        modifier = Modifier.align(Alignment.End)
                    )
                }

                OtpStatus(otpState19)

                Spacer(modifier = Modifier.height(24.dp))

                // 20. OTP with Pre-filled Value
                SectionTitle("20. OTP with Pre-filled Value")
                SectionDescription("OTP field with a partially pre-filled value")

                val otpState20 = rememberOtpState(6)

                // Pre-fill first 3 digits
                otpState20.onDigitEntered(0, '1')
                otpState20.onDigitEntered(1, '2')
                otpState20.onDigitEntered(2, '3')

                SushiOTPTextField(
                    state = otpState20,
                    autoFocus = false,
                    onComplete = { code ->
                        // Handle the completed OTP
                    }
                )

                OtpStatus(otpState20)

                // Add a spacer at the bottom for better scrolling experience
                Spacer(modifier = Modifier.height(40.dp))
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
        modifier = Modifier.padding(bottom = 4.dp)
    )
}

@Composable
private fun SectionDescription(description: String) {
    SushiText(
        props = SushiTextProps(
            text = description,
            type = SushiTextType.Regular400,
            color = SushiTheme.colors.text.secondary
        ),
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
private fun OtpStatus(state: SushiOTPState) {
    val currentCode = state.code.trim()
    val isComplete = state.isComplete()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 8.dp)
    ) {
        SushiText(
            props = SushiTextProps(
                text = "Current value: ",
                type = SushiTextType.Regular400,
                color = SushiTheme.colors.text.secondary
            )
        )

        SushiText(
            props = SushiTextProps(
                text = if (currentCode.isEmpty()) "[Empty]" else currentCode,
                type = SushiTextType.Medium500,
                color = if (isComplete) SushiTheme.colors.green.v600 else SushiTheme.colors.text.primary
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OTPInputShowcaseScreenPreview() {
    SushiTheme {
        OTPInputShowcaseScreen()
    }
}