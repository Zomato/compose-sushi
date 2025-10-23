package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.atoms.textfield.SushiTextField
import com.zomato.sushi.compose.atoms.textfield.SushiTextFieldColors
import com.zomato.sushi.compose.atoms.textfield.SushiTextFieldProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.serialization.Serializable

@Serializable
object TextFieldShowcaseScreen

@Composable
fun TextFieldShowcaseScreen(
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
                    title = "TextField Showcase",
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
                        .padding(horizontal = SushiTheme.dimens.spacing.base)
                ) {

                    // 1. Basic TextField
                    SectionTitle("Basic TextFields")

                    var basicText by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = basicText,
                            placeholder = SushiTextProps(text = "1. Basic TextField")
                        ),
                        onTextFieldValueChange = { basicText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 2. TextField with Label
                    var labeledText by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = labeledText,
                            placeholder = SushiTextProps(text = "Enter your name"),
                            label = SushiTextProps(text = "2. TextField with Label")
                        ),
                        onTextFieldValueChange = { labeledText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 3. TextField with Support Text
                    var supportText by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = supportText,
                            placeholder = SushiTextProps(text = "Enter email"),
                            label = SushiTextProps(text = "Email"),
                            supportText = SushiTextProps(text = "3. We'll never share your email with anyone else.")
                        ),
                        onTextFieldValueChange = { supportText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 4. Disabled TextField
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = TextFieldValue("4. This field is disabled"),
                            enabled = false
                        ),
                        onTextFieldValueChange = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 5. Read-only TextField
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = TextFieldValue("This field is read-only"),
                            label = SushiTextProps(text = "5. Read-only TextField"),
                            readOnly = true
                        ),
                        onTextFieldValueChange = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // TextField with Icons
                    SectionTitle("TextFields with Icons")

                    // 6. TextField with Prefix Icon
                    var prefixIconText by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = prefixIconText,
                            label = SushiTextProps(text = "6. Prefix Icon"),
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconSearch)
                        ),
                        onTextFieldValueChange = { prefixIconText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 7. TextField with Suffix Icon
                    var suffixIconText by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = suffixIconText,
                            label = SushiTextProps(text = "7. Suffix Icon"),
                            suffixIcon = SushiIconProps(code = SushiIconCodes.IconCross)
                        ),
                        onTextFieldValueChange = { suffixIconText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 8. TextField with Both Icons
                    var bothIconsText by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = bothIconsText,
                            label = SushiTextProps(text = "8. Both Icons"),
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconSearch),
                            suffixIcon = SushiIconProps(code = SushiIconCodes.IconCross)
                        ),
                        onTextFieldValueChange = { bothIconsText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 9. TextField with Prefix Text
                    var prefixTextValue by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = prefixTextValue,
                            label = SushiTextProps(text = "9. Prefix Text"),
                            prefixText = SushiTextProps(text = "₹")
                        ),
                        onTextFieldValueChange = { prefixTextValue = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 10. TextField with Suffix Text
                    var suffixTextValue by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = suffixTextValue,
                            label = SushiTextProps(text = "10. Suffix Text"),
                            suffixText = SushiTextProps(text = "kg")
                        ),
                        onTextFieldValueChange = { suffixTextValue = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 11. TextField with Phone Country Code
                    var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = phoneNumber,
                            label = SushiTextProps(text = "11. Phone Number"),
                            prefixText = SushiTextProps(text = "+91"),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                        ),
                        onTextFieldValueChange = { phoneNumber = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Error States
                    SectionTitle("Error States")

                    // 12. TextField with Error State
                    var errorText by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = errorText,
                            label = SushiTextProps(text = "12. Error State"),
                            isError = true,
                            supportText = SushiTextProps(
                                text = "This field has an error",
                                color = SushiTheme.colors.text.error
                            )
                        ),
                        onTextFieldValueChange = { errorText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 13. Email Validation (Simple)
                    var email by remember { mutableStateOf(TextFieldValue("")) }
                    val isValidEmail = email.text.isEmpty() || email.text.contains("@")
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = email,
                            label = SushiTextProps(text = "13. Email Validation"),
                            isError = !isValidEmail,
                            supportText = if (!isValidEmail)
                                SushiTextProps(
                                    text = "Please enter a valid email address",
                                    color = SushiTheme.colors.text.error
                                ) else null
                        ),
                        onTextFieldValueChange = { email = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Password Fields
                    SectionTitle("Password Fields")

                    // 14. Basic Password Field
                    var password by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = password,
                            label = SushiTextProps(text = "14. Password"),
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                        ),
                        onTextFieldValueChange = { password = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 15. Password Field with Visibility Toggle
                    var passwordVisible by remember { mutableStateOf(false) }
                    var passwordToggle by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = passwordToggle,
                            label = SushiTextProps(text = "15. Password with Toggle"),
                            visualTransformation = if (passwordVisible)
                                VisualTransformation.None
                            else PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            suffixIcon = SushiIconProps(
                                code = if (passwordVisible)
                                    SushiIconCodes.IconEyeOpen
                                else SushiIconCodes.IconEyeClose
                            )
                        ),
                        onTextFieldValueChange = { passwordToggle = it },
                        suffix = {
                            SushiIcon(
                                props = SushiIconProps(
                                    code = if (passwordVisible)
                                        SushiIconCodes.IconEyeOpen
                                    else SushiIconCodes.IconEyeClose
                                ),
                                onClick = { passwordVisible = !passwordVisible }
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Keyboard Options
                    SectionTitle("Keyboard Options")

                    // 16. Number Input
                    var numberInput by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = numberInput,
                            label = SushiTextProps(text = "16. Number Input"),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        ),
                        onTextFieldValueChange = { numberInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 17. Phone Input
                    var phoneInput by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = phoneInput,
                            label = SushiTextProps(text = "17. Phone Input"),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                        ),
                        onTextFieldValueChange = { phoneInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 18. Email Input
                    var emailInput by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = emailInput,
                            label = SushiTextProps(text = "18. Email Input"),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                        ),
                        onTextFieldValueChange = { emailInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 19. URL Input
                    var urlInput by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = urlInput,
                            label = SushiTextProps(text = "19. URL Input"),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri)
                        ),
                        onTextFieldValueChange = { urlInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 20. All Caps Input
                    var allCapsInput by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = allCapsInput,
                            label = SushiTextProps(text = "20. All Caps Input"),
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.Characters
                            )
                        ),
                        onTextFieldValueChange = { allCapsInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 21. Words Capitalized Input
                    var wordsCapsInput by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = wordsCapsInput,
                            label = SushiTextProps(text = "21. Words Capitalized"),
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.Words
                            )
                        ),
                        onTextFieldValueChange = { wordsCapsInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Keyboard Actions
                    SectionTitle("Keyboard Actions")

                    // 22. Done Action
                    var doneActionInput by remember { mutableStateOf(TextFieldValue("")) }
                    val focusManager = LocalFocusManager.current
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = doneActionInput,
                            label = SushiTextProps(text = "22. Done Action"),
                            keyboardOptions = KeyboardOptions(
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = { focusManager.clearFocus() }
                            )
                        ),
                        onTextFieldValueChange = { doneActionInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 23. Next Action
                    var nextActionInput by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = nextActionInput,
                            label = SushiTextProps(text = "23. Next Action"),
                            keyboardOptions = KeyboardOptions(
                                imeAction = ImeAction.Next
                            )
                        ),
                        onTextFieldValueChange = { nextActionInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 24. Search Action
                    var searchActionInput by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = searchActionInput,
                            label = SushiTextProps(text = "24. Search Action"),
                            keyboardOptions = KeyboardOptions(
                                imeAction = ImeAction.Search
                            ),
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconSearch)
                        ),
                        onTextFieldValueChange = { searchActionInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Multi-line Input
                    SectionTitle("Multi-line Input")

                    // 25. Single Line Field
                    var singleLineInput by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = singleLineInput,
                            label = SushiTextProps(text = "25. Single Line Field"),
                            singleLine = true,
                            placeholder = SushiTextProps(
                                text = "This field cannot have multiple lines"
                            )
                        ),
                        onTextFieldValueChange = { singleLineInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 26. Multi-line Field
                    var multiLineInput by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = multiLineInput,
                            label = SushiTextProps(text = "26. Multi-line Field (3 lines)"),
                            maxLines = 3,
                            placeholder = SushiTextProps(
                                text = "This field can have multiple lines (max 3)"
                            )
                        ),
                        onTextFieldValueChange = { multiLineInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 27. Minimum Lines Field
                    var minLinesInput by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = minLinesInput,
                            label = SushiTextProps(text = "27. Minimum Lines Field"),
                            minLines = 3,
                            maxLines = 5,
                            placeholder = SushiTextProps(
                                text = "This field has a minimum of 3 lines and max of 5"
                            )
                        ),
                        onTextFieldValueChange = { minLinesInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Custom Shapes
                    SectionTitle("Custom Shapes")

                    // 28. Rounded Corners
                    var roundedCornerInput by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = roundedCornerInput,
                            label = SushiTextProps(text = "28. Rounded Corners"),
                            shape = RoundedCornerShape(16.dp)
                        ),
                        onTextFieldValueChange = { roundedCornerInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 29. Circular Shape
                    var circularInput by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = circularInput,
                            label = SushiTextProps(text = "29. Circular Shape"),
                            shape = CircleShape
                        ),
                        onTextFieldValueChange = { circularInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 30. Cut Corners Shape
                    var cutCornerInput by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = cutCornerInput,
                            label = SushiTextProps(text = "30. Cut Corners"),
                            shape = CutCornerShape(12.dp)
                        ),
                        onTextFieldValueChange = { cutCornerInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Custom Colors
                    SectionTitle("Custom Colors")

                    // 31. Custom Colors
                    var customColorInput by remember { mutableStateOf(TextFieldValue("")) }
                    val customColors = SushiTextFieldColors(
                        focusedTextColor = SushiColorData(ColorName.Blue, ColorVariation.Variation900),
                        unfocusedTextColor = SushiColorData(ColorName.Blue, ColorVariation.Variation700),
                        disabledTextColor = SushiTheme.colors.text.disabled,
                        errorTextColor = SushiTheme.colors.text.error,
                        focusedContainerColor = SushiColorData(ColorName.Blue, ColorVariation.Variation100),
                        unfocusedContainerColor = SushiColorData(ColorName.Blue, ColorVariation.Variation50),
                        disabledContainerColor = SushiTheme.colors.surface.disabled,
                        errorContainerColor = SushiTheme.colors.surface.disabled,
                        cursorColor = SushiColorData(ColorName.Blue, ColorVariation.Variation700),
                        errorCursorColor = SushiTheme.colors.text.primary,
                        textSelectionColors = androidx.compose.foundation.text.selection.TextSelectionColors(
                            handleColor = SushiTheme.colors.blue.v500.value,
                            backgroundColor = SushiTheme.colors.blue.v200.value.copy(alpha = 0.4f)
                        ),
                        focusedIndicatorColor = SushiColorData(ColorName.Blue, ColorVariation.Variation700),
                        unfocusedIndicatorColor = SushiColorData(ColorName.Blue, ColorVariation.Variation300),
                        disabledIndicatorColor = SushiTheme.colors.surface.disabled,
                        errorIndicatorColor = SushiTheme.colors.surface.error,
                        focusedLeadingIconColor = SushiColorData(ColorName.Blue, ColorVariation.Variation700),
                        unfocusedLeadingIconColor = SushiColorData(ColorName.Blue, ColorVariation.Variation500),
                        disabledLeadingIconColor = SushiTheme.colors.text.disabled,
                        errorLeadingIconColor = SushiTheme.colors.text.error,
                        focusedTrailingIconColor = SushiColorData(ColorName.Blue, ColorVariation.Variation700),
                        unfocusedTrailingIconColor = SushiColorData(ColorName.Blue, ColorVariation.Variation500),
                        disabledTrailingIconColor = SushiTheme.colors.text.disabled,
                        errorTrailingIconColor = SushiTheme.colors.text.error,
                        focusedLabelColor = SushiColorData(ColorName.Blue, ColorVariation.Variation700),
                        unfocusedLabelColor = SushiColorData(ColorName.Blue, ColorVariation.Variation500),
                        disabledLabelColor = SushiTheme.colors.text.disabled,
                        errorLabelColor = SushiTheme.colors.text.error,
                        focusedPlaceholderColor = SushiColorData(ColorName.Blue, ColorVariation.Variation400),
                        unfocusedPlaceholderColor = SushiColorData(ColorName.Blue, ColorVariation.Variation300),
                        disabledPlaceholderColor = SushiTheme.colors.text.disabled,
                        errorPlaceholderColor = SushiTheme.colors.text.error,
                        focusedSupportingTextColor = SushiColorData(ColorName.Blue, ColorVariation.Variation700),
                        unfocusedSupportingTextColor = SushiColorData(ColorName.Blue, ColorVariation.Variation500),
                        disabledSupportingTextColor = SushiTheme.colors.text.disabled,
                        errorSupportingTextColor = SushiTheme.colors.text.error,
                        focusedPrefixColor = SushiColorData(ColorName.Blue, ColorVariation.Variation700),
                        unfocusedPrefixColor = SushiColorData(ColorName.Blue, ColorVariation.Variation500),
                        disabledPrefixColor = SushiTheme.colors.text.disabled,
                        errorPrefixColor = SushiTheme.colors.text.error,
                        focusedSuffixColor = SushiColorData(ColorName.Blue, ColorVariation.Variation700),
                        unfocusedSuffixColor = SushiColorData(ColorName.Blue, ColorVariation.Variation500),
                        disabledSuffixColor = SushiTheme.colors.text.disabled,
                        errorSuffixColor = SushiTheme.colors.text.error
                    )

                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = customColorInput,
                            label = SushiTextProps(text = "31. Custom Colors"),
                            colors = customColors
                        ),
                        onTextFieldValueChange = { customColorInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 32. Custom Text Style
                    var styledTextInput by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = styledTextInput,
                            label = SushiTextProps(text = "32. Custom Text Style"),
                            textStyle = SushiTextType.Medium500
                        ),
                        onTextFieldValueChange = { styledTextInput = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Real-world Examples
                    SectionTitle("Real-world Examples")

                    // 33. Credit Card Number
                    var cardNumber by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = cardNumber,
                            label = SushiTextProps(text = "33. Credit Card Number"),
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconPaymentCard),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            supportText = SushiTextProps(text = "Enter 16-digit card number")
                        ),
                        onTextFieldValueChange = {
                            if (it.text.length <= 16 && it.text.all { char -> char.isDigit() }) {
                                cardNumber = it
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 34. Search Field
                    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = searchQuery,
                            placeholder = SushiTextProps(text = "34. Search restaurants, cuisines..."),
                            singleLine = true,
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconSearch),
                            suffixIcon = if (searchQuery.text.isNotEmpty())
                                SushiIconProps(code = SushiIconCodes.IconCross) else null,
                            shape = RoundedCornerShape(24.dp),
                            keyboardOptions = KeyboardOptions(
                                imeAction = ImeAction.Search
                            )
                        ),
                        onTextFieldValueChange = { searchQuery = it },
                        suffix = if (searchQuery.text.isNotEmpty()) {
                            {
                                SushiIcon(
                                    props = SushiIconProps(
                                        code = SushiIconCodes.IconCross
                                    ),
                                    onClick = { searchQuery = TextFieldValue("") }
                                )
                            }
                        } else null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 35. Address Field
                    var address by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = address,
                            label = SushiTextProps(text = "35. Address"),
                            maxLines = 3,
                            prefixIcon = SushiIconProps(code = SushiIconCodes.IconLocation)
                        ),
                        onTextFieldValueChange = { address = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    // 36. OTP Field
                    var otp by remember { mutableStateOf(TextFieldValue("")) }
                    SushiTextField(
                        props = SushiTextFieldProps(
                            textFieldValue = otp,
                            label = SushiTextProps(text = "36. OTP Code"),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            textStyle = SushiTextType.SemiBold600,
                            supportText = SushiTextProps(text = "Enter 6-digit verification code")
                        ),
                        onTextFieldValueChange = {
                            if (it.text.length <= 6 && it.text.all { char -> char.isDigit() }) {
                                otp = it
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Composite Examples
                    SectionTitle("Composite Examples")

                    // 37. Contact Form
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = SushiTheme.colors.surface.secondary.value
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "37. Contact Information Form",
                                    type = SushiTextType.SemiBold600
                                ),
                                modifier = Modifier.padding(bottom = 16.dp)
                            )

                            var fullName by remember { mutableStateOf(TextFieldValue("")) }
                            var contactEmail by remember { mutableStateOf(TextFieldValue("")) }
                            var contactPhone by remember { mutableStateOf(TextFieldValue("")) }

                            // Name Field
                            SushiTextField(
                                props = SushiTextFieldProps(
                                    textFieldValue = fullName,
                                    label = SushiTextProps(text = "Full Name"),
                                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconUserFill),
                                    keyboardOptions = KeyboardOptions(
                                        capitalization = KeyboardCapitalization.Words,
                                        imeAction = ImeAction.Next
                                    )
                                ),
                                onTextFieldValueChange = { fullName = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp)
                            )

                            // Email Field
                            SushiTextField(
                                props = SushiTextFieldProps(
                                    textFieldValue = contactEmail,
                                    label = SushiTextProps(text = "Email"),
                                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconEnvelope),
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Email,
                                        imeAction = ImeAction.Next
                                    )
                                ),
                                onTextFieldValueChange = { contactEmail = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp)
                            )

                            // Phone Field
                            SushiTextField(
                                props = SushiTextFieldProps(
                                    textFieldValue = contactPhone,
                                    label = SushiTextProps(text = "Phone"),
                                    prefixText = SushiTextProps(text = "+1"),
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Phone,
                                        imeAction = ImeAction.Done
                                    )
                                ),
                                onTextFieldValueChange = { contactPhone = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp)
                            )
                        }
                    }

                    // 38. Login Form
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = SushiTheme.colors.surface.secondary.value
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "38. Login Form",
                                    type = SushiTextType.SemiBold600
                                ),
                                modifier = Modifier.padding(bottom = 16.dp)
                            )

                            var username by remember { mutableStateOf(TextFieldValue("")) }
                            var passwordInput by remember { mutableStateOf(TextFieldValue("")) }
                            var passwordVisible by remember { mutableStateOf(false) }

                            // Username Field
                            SushiTextField(
                                props = SushiTextFieldProps(
                                    textFieldValue = username,
                                    label = SushiTextProps(text = "Username or Email"),
                                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconUserFill),
                                    keyboardOptions = KeyboardOptions(
                                        imeAction = ImeAction.Next
                                    )
                                ),
                                onTextFieldValueChange = { username = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp)
                            )

                            // Password Field
                            SushiTextField(
                                props = SushiTextFieldProps(
                                    textFieldValue = passwordInput,
                                    label = SushiTextProps(text = "Password"),
                                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconLock),
                                    visualTransformation = if (passwordVisible)
                                        VisualTransformation.None
                                    else PasswordVisualTransformation(),
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Password,
                                        imeAction = ImeAction.Done
                                    )
                                ),
                                onTextFieldValueChange = { passwordInput = it },
                                suffix = {
                                    SushiIcon(
                                        props = SushiIconProps(
                                            code = if (passwordVisible)
                                                SushiIconCodes.IconEyeOpen
                                            else SushiIconCodes.IconEyeClose
                                        ),
                                        onClick = { passwordVisible = !passwordVisible }
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp)
                            )
                        }
                    }

                    // 39. Payment Form
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = SushiTheme.colors.surface.secondary.value
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "39. Payment Form",
                                    type = SushiTextType.SemiBold600
                                ),
                                modifier = Modifier.padding(bottom = 16.dp)
                            )

                            var cardName by remember { mutableStateOf(TextFieldValue("")) }
                            var cardNum by remember { mutableStateOf(TextFieldValue("")) }
                            var expiry by remember { mutableStateOf(TextFieldValue("")) }
                            var cvv by remember { mutableStateOf(TextFieldValue("")) }

                            // Card Name Field
                            SushiTextField(
                                props = SushiTextFieldProps(
                                    textFieldValue = cardName,
                                    label = SushiTextProps(text = "Cardholder Name"),
                                    keyboardOptions = KeyboardOptions(
                                        capitalization = KeyboardCapitalization.Words,
                                        imeAction = ImeAction.Next
                                    )
                                ),
                                onTextFieldValueChange = { cardName = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp)
                            )

                            // Card Number Field
                            SushiTextField(
                                props = SushiTextFieldProps(
                                    textFieldValue = cardNum,
                                    label = SushiTextProps(text = "Card Number"),
                                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconPaymentCard),
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    supportText = SushiTextProps(text = "16-digit number without spaces")
                                ),
                                onTextFieldValueChange = {
                                    if (it.text.length <= 16 && it.text.all { char -> char.isDigit() }) {
                                        cardNum = it
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp)
                            )

                            // Expiry and CVV in a row
                            Row(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                // Expiry Field
                                SushiTextField(
                                    props = SushiTextFieldProps(
                                        textFieldValue = expiry,
                                        label = SushiTextProps(text = "MM/YY"),
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.Number,
                                            imeAction = ImeAction.Next
                                        )
                                    ),
                                    onTextFieldValueChange = {
                                        if (it.text.length <= 5 && (it.text.isEmpty() || it.text.matches(Regex("^\\d{0,2}(/\\d{0,2})?$")))) {
                                            expiry = if (it.text.length == 2 && expiry.text.length == 1 && !it.text.contains("/")) {
                                                    TextFieldValue("${it.text}/")
                                                } else {
                                                    it
                                                }
                                        }
                                    },
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 8.dp)
                                )

                                // CVV Field
                                SushiTextField(
                                    props = SushiTextFieldProps(
                                        textFieldValue = cvv,
                                        label = SushiTextProps(text = "CVV"),
                                        keyboardOptions = KeyboardOptions(
                                            keyboardType = KeyboardType.NumberPassword,
                                            imeAction = ImeAction.Done
                                        )
                                    ),
                                    onTextFieldValueChange = {
                                        if (it.text.length <= 4 && it.text.all { char -> char.isDigit() }) {
                                            cvv = it
                                        }
                                    },
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 8.dp)
                                )
                            }
                        }
                    }

                    // 40. Comment Field
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .padding(bottom = 24.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = SushiTheme.colors.surface.secondary.value
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "40. Comment Field",
                                    type = SushiTextType.SemiBold600
                                ),
                                modifier = Modifier.padding(bottom = 16.dp)
                            )

                            var comment by remember { mutableStateOf(TextFieldValue("")) }

                            SushiTextField(
                                props = SushiTextFieldProps(
                                    textFieldValue = comment,
                                    label = SushiTextProps(text = "Leave a Comment"),
                                    minLines = 4,
                                    maxLines = 6,
                                    placeholder = SushiTextProps(
                                        text = "Share your thoughts about this restaurant..."
                                    ),
                                    supportText = SushiTextProps(
                                        text = "${comment.text.length}/500 characters"
                                    )
                                ),
                                onTextFieldValueChange = {
                                    if (it.text.length <= 500) {
                                        comment = it
                                    }
                                },
                                modifier = Modifier.fillMaxWidth()
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
private fun TextFieldShowcaseScreenPreview() {
    AppTheme {
        TextFieldShowcaseScreen()
    }
}