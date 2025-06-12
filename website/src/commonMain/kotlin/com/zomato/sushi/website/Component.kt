package com.zomato.sushi.website

import composesushi.website.generated.resources.Res
import composesushi.website.generated.resources.sushi_button_banner
import composesushi.website.generated.resources.sushi_icon_banner
import composesushi.website.generated.resources.sushi_text_banner
import org.jetbrains.compose.resources.DrawableResource

data class Component(
    val id: String,
    val name: String,
    val title: String,
    val shortDescription: String,
    val longDescription: String,
    val sampleCode: String,
    val sampleCodeDescription: String,
    val apiParameters: List<ApiParameter>,
    val banner: DrawableResource
) {
    data class ApiParameter(
        val name: String,
        val items: List<Pair<String, String>>
    )
}

val listOfComponents = listOf(
    Component(
        id = "sushi-text",
        name = "SushiText",
        title = "Text",
        shortDescription =  "Text component with styling options, decorations, prefix/suffix icons, expandable support, etc.",
        longDescription =  """
            A customizable text component that supports various styling options, decorations, prefix/suffix icons, and expandable text functionality.
            
            Features:
             * Text styling with different typography styles
             * Optional prefix and suffix icons or custom composables
             * Text decorations like underline and strikethrough
             * Support for markdown formatting
             * Expandable text with "read more" functionality
             * Text alignment and arrangement customization
        """.trimIndent(),
        sampleCode = """
            SushiText(
                props = SushiTextProps(
                    text = "Hello World!",
                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                    suffixIcon = SushiIconProps(code = SushiIconCodes.IconContactlessDining, color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)),
                    color = SushiColorData(ColorName.Red, ColorVariation.Variation500),
                    type = SushiTextType.Regular300,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    textDecoration = SushiTextDecoration.Underline()
                ),
                Modifier.fillMaxWidth()
            )
        """.trimIndent(),
        sampleCodeDescription = "The SushiText component is used to display text with various styles and properties.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiTextProps",
                items = listOf(
                    "text" to "The text content to display",
                    "color" to "The color specification for the text",
                    "type" to "The typography style to apply to the text",
                    "maxLines" to "Maximum number of lines to display before truncating",
                    "prefixIcon" to "Optional icon to display before the text",
                    "suffixIcon" to "Optional icon to display after the text",
                    "letterSpacing" to "Spacing between letters in the text",
                    "markdown" to "Whether to interpret the text as markdown",
                    "textDecoration" to "Optional decoration to apply to the text (underline or strikethrough)",
                    "textAlign" to "Text alignment within its container",
                    "overflow" to "How to handle text that doesn't fit within maxLines",
                    "overflowText" to "Text to show as part of the \"read more\" functionality",
                    "overflowTextColor" to "Color for the overflow text",
                    "softWrap" to "Whether text should wrap to the next line",
                    "minLines" to "Minimum number of lines to display",
                    "prefixSpacing" to "Space between the prefix icon and the text",
                    "suffixSpacing" to "Space between the text and the suffix icon",
                    "horizontalArrangement" to "How to arrange content horizontally",
                    "verticalAlignment" to "How to align content vertically",
                    "textBrush" to "Optional brush for creating gradient or other effects on text"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-icon",
        name = "SushiIcon",
        title = "Icon",
        shortDescription = "A composable component that displays an icon from the Sushi design system.",
        longDescription = """
            A composable component that displays an icon from the Sushi design system.

            SushiIcon renders icons from the Wasabi icon font based on the provided properties. It supports customization of size, color, and click interactions.
        """.trimIndent(),
        sampleCode = """
            SushiIcon(
                SushiIconProps(
                    code = SushiIconCodes.IconMStarfilled,
                    size = SushiIconSize.Size900
                )
            )
        """.trimIndent(),
        sampleCodeDescription = "The SushiIcon component is used to display an icon from the Sushi design system.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiIconProps",
                items = listOf(
                    "code" to "The SushiIconCode representing the specific icon to display",
                    "size" to "The size specification for the icon",
                    "color" to "The color specification for the icon",
                    "parsedIcon" to "The parsed Unicode character derived from the icon code"
                )
            )
        ),
        banner = Res.drawable.sushi_icon_banner
    ),
    Component(
        id = "sushi-button",
        name = "SushiButton",
        title = "Button",
        shortDescription = "A customizable button component that supports different visual styles, sizes, and content configurations.",
        longDescription = """
            A customizable button component that supports different visual styles, sizes, and content configurations.

            SushiButton provides a standardized button implementation with support for:

            - Different visual styles (Text, Solid, or Outline)
            - Various sizes (Small, Medium, or Large)
            - Prefix and suffix icons
            - Custom content through the content parameter
            - Accessibility through semantic properties
        """.trimIndent(),
        sampleCode = """
            SushiButton(
                props = SushiButtonProps(
                    text = "Solid Button",
                    type = SushiButtonType.Solid,
                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconStarFill)
                ),
                onClick = { /* Handle click */ },
                modifier = Modifier.fillMaxWidth()
            )
        """.trimIndent(),
        sampleCodeDescription = "The SushiButton component is used to create buttons with various styles and configurations.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiButtonProps",
                items = listOf(
                    "text" to "Primary text to display in the button",
                    "subText" to "Optional secondary text below the primary text",
                    "type" to "Button style type (Text, Solid, or Outline)",
                    "size" to "Button size variant (Small, Medium, or Large)",
                    "fontColor" to "Color for the button text",
                    "fontType" to "Typography style for the button text",
                    "color" to "Background color of the button",
                    "borderColor" to "Color of the button border (for Outline type)",
                    "suffixIcon" to "Optional icon to display after the button text",
                    "prefixIcon" to "Optional icon to display before the button text",
                    "enabled" to "Whether the button is enabled and can be interacted with",
                    "horizontalArrangement" to "How to arrange content horizontally in the button",
                    "verticalAlignment" to "How to align content vertically in the button",
                    "textAlignment" to "Horizontal alignment of text within the button",
                    "markdown" to "Whether to interpret text as markdown",
                    "shape" to "The shape of the button",
                    "iconSpacing" to "Spacing between icons and text"
                )
            )
        ),
        banner = Res.drawable.sushi_button_banner
    ),
    Component(
        id = "sushi-image",
        name = "SushiImage",
        title = "Image",
        shortDescription = "A composable component that displays images in the Sushi design system.",
        longDescription = """
            A composable component that displays images in the Sushi design system.

            SushiImage provides a consistent way to display images with various customization options like shapes, sizing, scaling, filters, and more. It supports both fixed dimensions and aspect ratio-based sizing, as well as click interactions.

            The component intelligently handles different combinations of width, height, and aspect ratio:

            - If width and height are provided, both are applied
            - If width and aspect ratio are provided, height is calculated automatically
            - If height and aspect ratio are provided, width is calculated automatically
        """.trimIndent(),
        sampleCode = """
            // Basic image from resource
            SushiImage(
                props = SushiImageProps(
                    painter = painterResource(id = R.drawable.food_image),
                    width = 200.dp,
                    height = 150.dp,
                    contentDescription = "Food image",
                    shape = RoundedCornerShape(8.dp),
                    contentScale = ContentScale.Crop
                ),
                modifier = Modifier.padding(8.dp)
            )
        """.trimIndent(),
        sampleCodeDescription = "The SushiImage component is used to display images with various customization options.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiImageProps",
                items = listOf(
                    "painter" to "The painter responsible for drawing the image content",
                    "bgColor" to "The background color behind the image",
                    "aspectRatio" to "The width to height ratio to maintain (e.g., 16/9 = 1.78)",
                    "height" to "The explicit height for the image (optional)",
                    "width" to "The explicit width for the image (optional)",
                    "shape" to "The shape to clip the image to (e.g., RoundedCornerShape)",
                    "contentDescription" to "Accessibility description of the image for screen readers",
                    "contentScale" to "How the image should be scaled within its bounds (e.g., Fit, Crop)",
                    "alpha" to "Opacity level from 0.0 (transparent) to 1.0 (opaque)",
                    "scaleFactor" to "Additional scaling factor applied to the image size",
                    "alignment" to "How the image should be aligned within its bounds",
                    "colorFilter" to "Optional filter to apply color transformations to the image"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-checkbox",
        name = "SushiCheckBox",
        title = "CheckBox",
        shortDescription = "A customizable checkbox component for the Sushi design system.",
        longDescription = """
            A customizable checkbox component for the Sushi design system.

            SushiCheckBox provides a standard checkbox implementation with support for:

            - Different sizes (Mini, Default)
            - Primary and secondary text labels
            - Custom positioning (checkbox at start or end)
            - Vertical alignment control
            - Custom content through the infoContent parameter
            - Consistent styling with the design system
        """.trimIndent(),
        sampleCode = """
            var checked by remember { mutableStateOf(false) }

            SushiCheckBox(
                props = SushiCheckBoxProps(
                    checked = checked,
                    text = SushiTextProps(text = "I accept the terms and conditions"),
                    subText = SushiTextProps(
                        text = "By checking this box, you agree to our Terms of Service",
                        type = SushiTextType.Regular300,
                        color = SushiTheme.colors.text.secondary
                    ),
                    color = SushiTheme.colors.green.v600
                ),
                onCheckedChange = { checked = it },
                modifier = Modifier.fillMaxWidth()
            )
        """.trimIndent(),
        sampleCodeDescription = "The SushiCheckBox component is used to create checkboxes with different configurations.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiCheckBoxProps",
                items = listOf(
                    "id" to "Optional identifier for the checkbox",
                    "checked" to "Whether the checkbox is checked (true) or unchecked (false)",
                    "text" to "Primary text properties to display alongside the checkbox",
                    "subText" to "Secondary text properties to display below the primary text",
                    "enabled" to "Whether the checkbox is interactive (true) or disabled (false)",
                    "color" to "The color for the checkbox when checked",
                    "size" to "The size variant of the checkbox (Mini or Default)",
                    "boxPadding" to "The padding around the checkbox component",
                    "verticalAlignment" to "The vertical alignment of the checkbox relative to its text",
                    "direction" to "The position of the checkbox relative to its text (Start or End)"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-radiobutton",
        name = "SushiRadioButton",
        title = "RadioButton",
        shortDescription = "A customizable radio button component for the Sushi design system.",
        longDescription = """
            A customizable radio button component for the Sushi design system.

            SushiRadioButton provides a standard radio button implementation with support for:

            - Primary and secondary text labels
            - Custom positioning (radio button at start or end)
            - Vertical alignment control
            - Custom colors for selected and unselected states
            - Custom content through the infoContent parameter
            - Accessibility through semantic properties

            Radio buttons are typically used in groups where only one option can be selected at a time, though this component doesn't enforce that behavior - it's up to the parent component to manage the selected state across a group of radio buttons.
        """.trimIndent(),
        sampleCode = """
            var selectedOption by remember { mutableIntStateOf(1) }

            SushiRadioButton(
                props = SushiRadioButtonProps(
                    selected = selectedOption == 1,
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
                onClick = { selectedOption = 1 },
                modifier = Modifier.padding(vertical = 4.dp)
            )
        """.trimIndent(),
        sampleCodeDescription = "The SushiRadioButton component is used to create radio button groups where only one option can be selected.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiRadioButtonProps",
                items = listOf(
                    "id" to "Optional identifier for the radio button",
                    "selected" to "Whether the radio button is selected (true) or unselected (false)",
                    "text" to "Primary text properties to display alongside the radio button",
                    "subText" to "Secondary text properties to display below the primary text",
                    "enabled" to "Whether the radio button is interactive (true) or disabled (false)",
                    "unselectedColor" to "The color for the radio button when unselected",
                    "selectedColor" to "The color for the radio button when selected",
                    "padding" to "The padding around the radio button component",
                    "verticalAlignment" to "The vertical alignment of the radio button relative to its text",
                    "direction" to "The position of the radio button relative to its text (Start or End)"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-switch",
        name = "SushiSwitch",
        title = "Switch",
        shortDescription = "A customizable toggle switch component for the Sushi design system.",
        longDescription = """
            A customizable toggle switch component for the Sushi design system.

            SushiSwitch provides a standard switch component with support for:

            - Primary and secondary text labels
            - Custom positioning (switch at start or end)
            - Vertical alignment control
            - Customizable colors
            - Custom content through the infoContent parameter
            - Accessibility through semantic properties

            Switches are typically used to toggle between two states (on/off) for a single option.
        """.trimIndent(),
        sampleCode = """
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
        """.trimIndent(),
        sampleCodeDescription = "The SushiSwitch component is used to create toggle switches for settings and preferences.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiSwitchProps",
                items = listOf(
                    "id" to "Optional identifier for the switch",
                    "isChecked" to "Whether the switch is checked (on) or unchecked (off)",
                    "text" to "Primary text properties to display alongside the switch",
                    "subText" to "Secondary text properties to display below the primary text",
                    "isEnabled" to "Whether the switch is interactive (true) or disabled (false)",
                    "color" to "The color for the switch when checked",
                    "padding" to "The padding around the switch component",
                    "verticalAlignment" to "The vertical alignment of the switch relative to its text",
                    "direction" to "The position of the switch relative to its text (Start or End)"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-tag",
        name = "SushiTag",
        title = "Tag",
        shortDescription = "A customizable tag component for displaying categories, attributes, or status information.",
        longDescription = """
            A customizable tag component for the Sushi design system.

            SushiTag is a small, compact component typically used to display categories, attributes, or status information. It supports various visual styles (rounded, capsule, outlined, dashed), sizes, and optional prefix/suffix icons.

            Tags can be interactive (clickable) or static, and can contain custom content or use the standard text and icon layout.
        """.trimIndent(),
        sampleCode = """
            // Basic tag
            SushiTag(
                props = SushiTagProps(
                    text = "Capsule",
                    type = SushiTagType.Capsule,
                    size = SushiTagSize.Medium
                )
            )

            // Tag with icon and custom colors
            SushiTag(
                props = SushiTagProps(
                    text = "Vegetarian",
                    type = SushiTagType.RoundedOutline,
                    size = SushiTagSize.Small,
                    prefixIcon = SushiIconProps(
                        code = SushiIconCodes.IconCheck,
                        color = SushiTheme.colors.green.v600
                    ),
                    borderColor = SushiTheme.colors.green.v600,
                    fontColor = SushiTheme.colors.green.v600
                )
            )
        """.trimIndent(),
        sampleCodeDescription = "The SushiTag component is used to create compact, visual indicators for various attributes and categories.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiTagProps",
                items = listOf(
                    "text" to "The text content to display in the tag",
                    "size" to "The size variant of the tag (affects padding and text size)",
                    "type" to "The visual style of the tag (affects shape and border)",
                    "color" to "The background color of the tag",
                    "fontColor" to "The color of the text and icons in the tag",
                    "borderColor" to "The color of the border (for outline and dashed types)",
                    "suffixIcon" to "Optional icon to display after the text",
                    "prefixIcon" to "Optional icon to display before the text",
                    "iconSpacing" to "Custom spacing between icons and text",
                    "shape" to "Optional custom shape to override the default shape from the type",
                    "markdown" to "Whether to interpret the text content as markdown"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-textfield",
        name = "SushiTextField",
        title = "TextField",
        shortDescription = "A customizable text input field component for the Sushi design system.",
        longDescription = """
            A customizable text input field component for the Sushi design system.

            SushiTextField provides a standard text field with support for:

            - Labels and placeholder text
            - Error states and support text
            - Prefix and suffix text/icons
            - Custom styling via colors and shapes
            - Keyboard options and actions
            - Accessibility features

            This component wraps the Material3 OutlinedTextField to maintain consistency with the design system while leveraging the functionality of the standard component.
        """.trimIndent(),
        sampleCode = """
            var text by remember { mutableStateOf("") }

            SushiTextField(
                props = SushiTextFieldProps(
                    text = text,
                    label = SushiTextProps(text = "Phone Number"),
                    prefixText = SushiTextProps(text = "+91"),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    supportText = SushiTextProps(text = "Enter your mobile number")
                ),
                onValueChange = { text = it },
                modifier = Modifier.fillMaxWidth()
            )
        """.trimIndent(),
        sampleCodeDescription = "The SushiTextField component is used to create text input fields with various configurations.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiTextFieldProps",
                items = listOf(
                    "id" to "Optional identifier for the text field",
                    "text" to "Current text value displayed in the field",
                    "textStyle" to "Typography style for the input text",
                    "placeholder" to "Text displayed when the field is empty",
                    "enabled" to "Whether the text field is interactive (true) or disabled (false)",
                    "readOnly" to "Whether the text field allows user input (false) or is read-only (true)",
                    "isError" to "Whether to display the text field in an error state",
                    "label" to "Optional label text displayed above the text field",
                    "keyboardOptions" to "Options controlling the behavior of the software keyboard",
                    "keyboardActions" to "Actions to perform based on keyboard input",
                    "singleLine" to "Whether the text field should be limited to a single line",
                    "showResetButton" to "Show a reset button to clear the text field's input",
                    "maxLines" to "Maximum number of lines to display when not in single line mode",
                    "minLines" to "Minimum number of lines to display",
                    "shape" to "The shape of the text field container",
                    "visualTransformation" to "Optional transformation for displaying the text (e.g., password masking)",
                    "supportText" to "Optional supporting text displayed below the text field",
                    "prefixIcon" to "Optional icon displayed at the start of the text field",
                    "leadingIcon" to "Optional icon displayed at the start of the text field (always visible)",
                    "suffixIcon" to "Optional icon displayed at the end of the text field",
                    "trailingIcon" to "Optional icon displayed at the end of the text field (always visible)",
                    "prefixText" to "Optional text displayed at the start of the text field",
                    "suffixText" to "Optional text displayed at the end of the text field",
                    "colors" to "Color scheme for the text field's various states"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-animation",
        name = "SushiAnimation",
        title = "Animation",
        shortDescription = "A composable component for displaying Lottie animations in the Sushi design system.",
        longDescription = """
            A composable component for displaying animations in the Sushi design system. Supports Lottie animations from various sources with customizable playback behavior.

            SushiAnimation provides a convenient way to integrate Lottie animations into your application, with support for animations from different sources:

            - Assets directory
            - File system
            - JSON strings
            - Android resources
            - URLs
            - Pre-loaded Lottie compositions
        """.trimIndent(),
        sampleCode = """
            // Auto-play animation from asset file
            val autoPlayProps by rememberSushiAnimationProps(
                source = LottieAssetSource("animation.json"),
                playback = SushiAnimationPlayback.AutoPlay(
                    isPlaying = true,
                    restartOnPlay = true,
                    reverseOnRepeat = false,
                    speed = 1f,
                    iterations = -1  // Infinite loop
                )
            )

            SushiAnimation(
                props = autoPlayProps,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
            )
        """.trimIndent(),
        sampleCodeDescription = "The SushiAnimation component is used to display Lottie animations with various configurations.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiAnimationProps",
                items = listOf(
                    "source" to "The animation source to be displayed",
                    "playback" to "The playback configuration controlling how the animation plays",
                    "width" to "Optional explicit width for the animation",
                    "height" to "Optional explicit height for the animation",
                    "aspectRatio" to "Optional aspect ratio to maintain (width:height)",
                    "bgColor" to "Background color for the animation container"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-loader",
        name = "SushiLoader",
        title = "Loader",
        shortDescription = "An animated loading indicator with two concentric rotating arcs.",
        longDescription = """
            A composable that displays an animated loading indicator with two concentric arcs that rotate at different angles. The component adapts to the available space while maintaining a minimum size to ensure visibility. The animation, colors, and angular relationship between arcs can be customized through props.

            The loader automatically scales to fill its container while maintaining proper proportions, making it suitable for various use cases from small inline loaders to large centered spinners.
        """.trimIndent(),
        sampleCode = """
            // Default loader
            SushiLoader(
                props = SushiLoaderProps()
            )

            // Custom colors
            SushiLoader(
                props = SushiLoaderProps(
                    outerColor = SushiColorData(ColorName.Blue, ColorVariation.Variation500),
                    innerColor = SushiColorData(ColorName.Green, ColorVariation.Variation500)
                )
            )

            // Custom animation speed and angle
            SushiLoader(
                props = SushiLoaderProps(
                    animationSpeedMultiplier = 2.0f,
                    innerAngleOffset = 90f
                )
            )
        """.trimIndent(),
        sampleCodeDescription = "The SushiLoader component is used to display loading indicators with various customizations.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiLoaderProps",
                items = listOf(
                    "innerAngleOffset" to "The angular offset between the inner and outer arcs in degrees",
                    "outerColor" to "The color of the outer arc",
                    "innerColor" to "The color of the inner arc",
                    "animationSpeedMultiplier" to "Factor that controls animation speed (higher values = faster)"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-card",
        name = "SushiCard",
        title = "Card",
        shortDescription = "A customizable card component for displaying related content in a contained unit.",
        longDescription = """
            A customizable card component for the Sushi design system.

            SushiCard provides a surface for displaying related content in a contained unit. It supports:

            - Custom shapes including rounded corners and ticket shapes
            - Solid and dashed borders
            - Elevation control
            - Custom background colors
            - Content composition through ColumnScope
        """.trimIndent(),
        sampleCode = """
            // Basic card with rounded corners
            SushiCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    SushiText(
                        props = SushiTextProps(
                            text = "Card Title",
                            type = SushiTextType.SemiBold600
                        )
                    )
                    
                    SushiText(
                        props = SushiTextProps(
                            text = "Card content goes here with any composable content",
                            type = SushiTextType.Regular400
                        ),
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        """.trimIndent(),
        sampleCodeDescription = "The SushiCard component is used to create cards with various styles and configurations.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiCardProps",
                items = listOf(
                    "modifier" to "The modifier to be applied to the card",
                    "borderConfig" to "Optional configuration for custom borders (e.g., dashed borders)",
                    "shape" to "The shape of the card (defaults to rounded corners)",
                    "containerColor" to "The background color of the card",
                    "border" to "Optional border stroke for the card (for solid borders)",
                    "elevation" to "The elevation of the card which determines its shadow",
                    "content" to "The composable content to be displayed inside the card"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-indicator",
        name = "SushiIndicator",
        title = "Indicator",
        shortDescription = "A customizable page indicator component for carousels and pagers.",
        longDescription = """
            A composable that displays page indicators for carousel or pager components.

            SushiIndicator integrates with Compose's PagerState to automatically reflect the current page and animate transitions between pages. It offers three distinct visual styles:

            - **Balloon**: Dots expand like a balloon when active
            - **Shift**: Active dots expand horizontally into a pill shape
            - **Spring**: A separate selector dot moves between fixed position dots
        """.trimIndent(),
        sampleCode = """
            // Create a pager state
            val pagerState = rememberPagerState { 5 }

            // Basic Balloon Indicator
            SushiIndicator(
                dotCount = 5,
                type = SushiIndicatorType.Balloon(),
                pagerState = pagerState,
                modifier = Modifier.padding(16.dp)
            )
        """.trimIndent(),
        sampleCodeDescription = "The SushiIndicator component is used to display page indicators that integrate with pagers.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiIndicatorProps",
                items = listOf(
                    "dotCount" to "The total number of pages to display indicators for",
                    "type" to "The visual style of the indicators (Balloon, Shift, or Spring)",
                    "pagerState" to "The state of the associated pager component",
                    "currentPage" to "The current page index (for manual control version)",
                    "currentPageOffsetFraction" to "Function providing fractional offset (for manual control)",
                    "dotSpacing" to "Spacing between adjacent dots",
                    "onDotClicked" to "Optional callback for when a dot is clicked"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-divider",
        name = "SushiDivider",
        title = "Divider",
        shortDescription = "A composable that displays a divider with various customizable styles.",
        longDescription = """
            A composable that displays a divider with various customizable styles.

            SushiDivider provides visual separation between content sections using different line styles such as solid, dotted, dashed, and decorative patterns like zigzags. It supports both horizontal and vertical orientations as well as customizable colors and thicknesses.
        """.trimIndent(),
        sampleCode = """
            // Basic straight divider
            SushiDivider(
                props = SushiDividerProps(
                    type = SushiDividerType.Straight,
                    color = SushiColorData(ColorName.Red, ColorVariation.Variation500)
                ),
                Modifier.fillMaxWidth().padding(vertical = 16.dp)
            )
        """.trimIndent(),
        sampleCodeDescription = "The SushiDivider component is used to create visual separation between content elements.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiDividerProps",
                items = listOf(
                    "type" to "The visual style of the divider (default is SushiDividerType.Straight)",
                    "color" to "The color of the divider (default is determined by theme)",
                    "height" to "The thickness of the divider (default varies by type)"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-shimmer",
        name = "SushiShimmer",
        title = "Shimmer",
        shortDescription = "A composable that displays a shimmer loading effect over placeholder content.",
        longDescription = """
            A composable that displays a shimmer loading effect over placeholder content.

            SushiShimmer creates a shimmering animation effect typically used to indicate loading states in UI. It provides a scope that allows creating shimmer effects over custom shapes and text elements.
        """.trimIndent(),
        sampleCode = """
            // Basic shimmer with default properties
            SushiShimmer(
                props = SushiShimmerProps(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Header with circle and text
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        ShimmerItem(
                            Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                        )
                        Column {
                            ShimmerItem(
                                Modifier
                                    .height(16.dp)
                                    .width(150.dp)
                                    .clip(RoundedCornerShape(4.dp))
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            ShimmerItem(
                                Modifier
                                    .height(12.dp)
                                    .width(100.dp)
                                    .clip(RoundedCornerShape(4.dp))
                            )
                        }
                    }
                    
                    // Content
                    ShimmerItem(
                        Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                }
            }
        """.trimIndent(),
        sampleCodeDescription = "The SushiShimmer component is used to create loading state indicators with customizable animations.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiShimmerProps",
                items = listOf(
                    "bgColor" to "The background color of the shimmer effect",
                    "animationColor" to "The highlight color that moves across the shimmer",
                    "animationWidth" to "The width of the highlight gradient in dp",
                    "angleOffset" to "The angle offset of the gradient to create diagonal effects",
                    "animationDuration" to "The duration of one complete animation cycle in milliseconds",
                    "animationDelay" to "The delay between animation cycles in milliseconds"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-snackbar",
        name = "SushiSnackbar",
        title = "Snackbar",
        shortDescription = "A composable that displays a snackbar message with an optional action.",
        longDescription = """
            A composable that displays a snackbar message with an optional action.

            SushiSnackbar provides brief feedback about operations through a message at the bottom of the screen. It can include an action button and customizable styling. Snackbars are typically used to inform users of a process that an app has performed or will perform, and provide an opportunity to respond or undo that action.
        """.trimIndent(),
        sampleCode = """
            // First, create and remember a snackbar host state
            val snackbarHostState = remember { SushiSnackbarHostState() }
            val scope = rememberCoroutineScope()

            // Then, add the snackbar host to your Scaffold
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                snackbarHost = {
                    SushiSnackbarHost(
                        hostState = snackbarHostState,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            ) { innerPadding ->
                // Button to trigger the snackbar
                SushiButton(
                    props = SushiButtonProps(text = "Show Snackbar"),
                    onClick = {
                        scope.launch {
                            val props = SushiSnackbarProps(
                                message = SushiTextProps(
                                    text = "This is a basic snackbar message",
                                    type = SushiTextType.Regular400
                                ),
                                snackbarDuration = SushiSnackbarDuration.Short
                            )
                            snackbarHostState.showSnackbar(props)
                        }
                    }
                )
            }
        """.trimIndent(),
        sampleCodeDescription = "The SushiSnackbar component is typically used with a SushiSnackbarHostState to show messages.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiSnackbarProps",
                items = listOf(
                    "message" to "The main text message to display in the snackbar",
                    "containerColor" to "The background color of the snackbar",
                    "contentColor" to "The color of the text content",
                    "actionText" to "The text for the optional action button",
                    "snackbarDuration" to "Controls how long the snackbar remains visible"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-bottomsheet",
        name = "SushiBottomSheet",
        title = "BottomSheet",
        shortDescription = "A customizable bottom sheet component for the Sushi design system.",
        longDescription = """
            A customizable bottom sheet component for the Sushi design system.

            SushiBottomSheet provides a modal bottom sheet that slides up from the bottom of the screen to display additional content. The component is built on top of Material 3's ModalBottomSheet with Sushi-specific styling and integration with the Sushi design system.
        """.trimIndent(),
        sampleCode = """
            // First, create state variables to control the bottom sheet visibility
            var showBottomSheet by remember { mutableStateOf(false) }
            val sheetState = rememberModalBottomSheetState()
            val scope = rememberCoroutineScope()

            // Button to show the bottom sheet
            SushiButton(
                props = SushiButtonProps(text = "Show Bottom Sheet"),
                onClick = { showBottomSheet = true },
                modifier = Modifier.fillMaxWidth()
            )

            // Display the bottom sheet when triggered
            if (showBottomSheet) {
                SushiBottomSheet(
                    props = SushiBottomSheetProps(),  // Using default props
                    onDismissRequest = { showBottomSheet = false },
                    sheetState = sheetState
                ) {
                    // Bottom sheet content
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SushiText(
                            props = SushiTextProps(
                                text = "Bottom Sheet Title",
                                type = SushiTextType.Bold700
                            )
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        SushiText(
                            props = SushiTextProps(
                                text = "This is the content of the bottom sheet.",
                                type = SushiTextType.Regular400
                            )
                        )
                        
                        Spacer(modifier = Modifier.height(24.dp))
                        
                        SushiButton(
                            props = SushiButtonProps(text = "Close"),
                            onClick = {
                                scope.launch {
                                    sheetState.hide()
                                    showBottomSheet = false
                                }
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        """.trimIndent(),
        sampleCodeDescription = "The SushiBottomSheet component is used to display content in a modal sheet that slides up from the bottom of the screen.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiBottomSheetProps",
                items = listOf(
                    "shape" to "The shape of the bottom sheet, typically defining rounded corners at the top",
                    "containerColor" to "The background color of the bottom sheet",
                    "contentColor" to "The color of the text and other content in the bottom sheet",
                    "tonalElevation" to "The elevation of the bottom sheet that affects its shadow and surface tint",
                    "properties" to "Additional properties controlling the bottom sheet behavior, such as scrim opacity and whether it's dismissible"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-dialog",
        name = "SushiDialog",
        title = "Dialog",
        shortDescription = "A customizable alert dialog component for the Sushi design system.",
        longDescription = """
            A customizable alert dialog component for the Sushi design system.

            SushiAlertDialog provides a modal dialog for displaying important information or requesting user decisions. It supports an optional header image, title, subtitle, custom content, and up to three action buttons. The dialog can be configured with different button layouts (vertical or horizontal) and dismissal behaviors.
        """.trimIndent(),
        sampleCode = """
            // First, create state to control the dialog's visibility
            var showDialog by remember { mutableStateOf(false) }

            // Button to show the dialog
            SushiButton(
                props = SushiButtonProps(text = "Show Dialog"),
                onClick = { showDialog = true },
                modifier = Modifier.fillMaxWidth()
            )

            // Display the dialog when needed
            if (showDialog) {
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
                    onDismissRequest = { showDialog = false },
                    onPositiveButtonClick = { 
                        // Handle positive action
                        showDialog = false 
                    },
                    onNegativeButtonClick = { showDialog = false }
                ) {
                    // Optional additional content
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        """.trimIndent(),
        sampleCodeDescription = "The SushiAlertDialog component is used to create modal dialogs for important interactions.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiAlertDialogProps",
                items = listOf(
                    "id" to "Optional identifier for the dialog",
                    "image" to "Optional image to display at the top of the dialog",
                    "title" to "Optional title text displayed at the top of the dialog",
                    "subtitle" to "Optional subtitle text displayed below the title",
                    "positiveButton" to "Optional properties for the primary action button",
                    "negativeButton" to "Optional properties for the secondary action button",
                    "neutralButton" to "Optional properties for the tertiary action button",
                    "alignment" to "How the buttons should be arranged (vertically or horizontally)",
                    "dismissOnBackPress" to "Whether the dialog should dismiss when the back button is pressed",
                    "dismissOnClickOutside" to "Whether the dialog should dismiss when clicked outside its bounds"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-dropdown",
        name = "SushiDropDown",
        title = "DropDown",
        shortDescription = "A customizable dropdown menu component for displaying options.",
        longDescription = """
            A customizable dropdown menu component for the Sushi design system.

            SushiDropDown provides a popup menu that can contain various types of items including text items, checkboxes, and radio buttons. The dropdown can be anchored to any component and supports custom content or predefined item types.
        """.trimIndent(),
        sampleCode = """
            // First, create state variables to control the dropdown visibility
            var isExpanded by remember { mutableStateOf(false) }

            // Create a trigger element (like a button)
            SushiButton(
                props = SushiButtonProps(
                    text = "Show Dropdown",
                    prefixIcon = SushiIconProps(code = SushiIconCodes.IconChevronDown)
                ),
                onClick = { isExpanded = true }
            )

            // Create the dropdown items
            val items = persistentListOf(
                // Text items
                DropDownItem.TextItem(SushiTextProps(text = "Option 1")),
                DropDownItem.TextItem(SushiTextProps(text = "Option 2")),
                
                // Checkbox items
                DropDownItem.CheckBoxItem(SushiCheckBoxProps(
                    text = SushiTextProps(text = "Checkbox Option"),
                    checked = false
                )),
                
                // Radio button items
                DropDownItem.RadioButtonItem(SushiRadioButtonProps(
                    text = SushiTextProps(text = "Radio Option"),
                    selected = true
                ))
            )

            // Show the dropdown when expanded
            if (isExpanded) {
                SushiDropDown(
                    props = SushiDropDownProps(
                        expanded = true,
                        items = items
                    ),
                    onDismissRequest = { isExpanded = false },
                    onEvent = { index, event ->
                        when (event) {
                            is DropDownEvent.OnTextItemClicked -> {
                                // Handle text item click
                                isExpanded = false
                            }
                            is DropDownEvent.OnCheckChanged -> {
                                // Handle checkbox state change
                            }
                            is DropDownEvent.OnRadioButtonCheckChanged -> {
                                // Handle radio button selection
                            }
                        }
                    }
                )
            }
        """.trimIndent(),
        sampleCodeDescription = "The SushiDropDown component is used to create dropdown menus with various types of items.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiDropDownProps",
                items = listOf(
                    "expanded" to "Whether the dropdown menu is currently shown",
                    "offset" to "Position offset from the anchor position",
                    "properties" to "Additional popup properties (e.g., focusability, dismiss behavior)",
                    "shape" to "The shape of the dropdown menu container",
                    "containerColor" to "The background color of the dropdown menu",
                    "tonalElevation" to "When using surface color, this affects the overlay color intensity",
                    "shadowElevation" to "The elevation that determines the size of the shadow",
                    "border" to "Optional border to draw around the dropdown",
                    "items" to "List of items to display in the dropdown menu"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-media",
        name = "SushiMedia",
        title = "Media",
        shortDescription = "A unified media component for the Sushi design system that can display different types of media.",
        longDescription = """
            A unified media component for the Sushi design system that can display different types of media.

            SushiMedia provides a single interface for displaying various types of visual content, currently supporting static images and animations. It automatically renders the appropriate component based on the type of media specified in the properties.

            This abstraction allows for easier transitions between different media types and provides a consistent API for displaying visual content.
        """.trimIndent(),
        sampleCode = """
            // Display an image
            val imageProps = SushiImageProps(
                painter = painterResource(R.drawable.my_image),
                contentDescription = "My Image",
                width = 200.dp,
                height = 150.dp,
                contentScale = ContentScale.Crop
            )

            SushiMedia(
                props = SushiMediaProps.Image(imageProps),
                modifier = Modifier.padding(16.dp)
            )

            // Display an animation (Lottie)
            val animationProps by rememberSushiAnimationProps(
                source = LottieAssetSource("animation.json"),
                playback = SushiAnimationPlayback.AutoPlay(
                    isPlaying = true,
                    restartOnPlay = true,
                    iterations = 3
                )
            )

            SushiMedia(
                props = SushiMediaProps.Animation(animationProps),
                modifier = Modifier.size(200.dp)
            )
        """.trimIndent(),
        sampleCodeDescription = "The SushiMedia component is used to display different types of media content.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiMediaProps",
                items = listOf(
                    "Image" to "Configuration for displaying a static image",
                    "Animation" to "Configuration for displaying an animation"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-otpinput",
        name = "SushiOTPInput",
        title = "OTPInput",
        shortDescription = "A customizable OTP (One-Time Password) input field component.",
        longDescription = """
            A customizable OTP (One-Time Password) input field component for the Sushi design system.

            SushiOTPTextField provides a series of individual input fields for entering verification codes, with automatic focus management and styling consistent with the Sushi design system. It comes in three visual styles: filled, outlined, and underlined.
        """.trimIndent(),
        sampleCode = """
            // Create an OTP state for 6 digits
            val otpState = rememberOtpState(6)

            // Use the filled style (default)
            SushiOTPTextField(
                state = otpState,
                autoFocus = true, // Automatically focus the first field
                onComplete = { 
                    // Handle the completed 6-digit code
                    println("OTP completed")
                }
            )

            // Or use the outlined style
            SushiOutlinedOTPTextField(
                state = otpState,
                autoFocus = true,
                onComplete = { 
                    // Handle the completed 6-digit code
                }
            )
        """.trimIndent(),
        sampleCodeDescription = "The SushiOTPTextField component is used to create OTP input fields for verification codes.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiOTPTextFieldProps",
                items = listOf(
                    "state" to "State controlling the OTP value and behavior",
                    "enabled" to "Whether the input fields are enabled",
                    "readOnly" to "Whether the input fields are read-only",
                    "isError" to "Whether to display the component in an error state",
                    "autoFocus" to "Whether to automatically focus the first input field when displayed",
                    "textStyle" to "The style to apply to the input text",
                    "colors" to "Colors configuration for different states of the component",
                    "visualTransformation" to "Transformation to apply to the input text (e.g., for masking)",
                    "keyboardType" to "The type of keyboard to show for input",
                    "onComplete" to "Callback invoked when all fields are filled"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-horizontalpager",
        name = "SushiHorizontalPager",
        title = "HorizontalPager",
        shortDescription = "A component that allows users to swipe between pages of content horizontally.",
        longDescription = """
            SushiHorizontalPager allows users to swipe between pages of content. It provides a way to create carousels, image galleries, onboarding flows, or any UI that requires paging through content, and enables horizontal swiping.
        """.trimIndent(),
        sampleCode = """
            // First, create a PagerState that manages the paging behavior
            val pagerState = rememberPagerState(pageCount = { 5 }) // 5 pages

            // Create the pager with default settings
            SushiHorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) { 
                // Content for each page
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    SushiText(
                        props = SushiTextProps(
                            text = "Page Content",
                            type = SushiTextType.Bold700
                        )
                    )
                }
            }
        """.trimIndent(),
        sampleCodeDescription = "The SushiHorizontalPager component allows users to swipe between pages of content horizontally.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiHorizontalPagerProps",
                items = listOf(
                    "state" to "The state object to control and observe the pager's state",
                    "modifier" to "The modifier to be applied to the pager",
                    "contentPadding" to "Padding to be applied to the pager content",
                    "pageSize" to "Strategy defining how pages should be sized",
                    "beyondViewportPageCount" to "The number of pages to keep loaded beyond the visible viewport",
                    "pageSpacing" to "Spacing between each page",
                    "flingBehavior" to "The fling behavior that defines how the pager should handle fling gestures",
                    "userScrollEnabled" to "Whether user scrolling is enabled",
                    "reverseLayout" to "Whether the layout should be reversed",
                    "key" to "Optional lambda to provide a unique key for each page",
                    "pageNestedScrollConnection" to "Nested scroll connection to be applied to each page",
                    "snapPosition" to "Position to which the pages should snap",
                    "verticalAlignment" to "Vertical alignment of each page within the pager"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-verticalpager",
        name = "SushiVerticalPager",
        title = "VerticalPager",
        shortDescription = "A component that allows users to swipe between pages of content vertically.",
        longDescription = """
            SushiVerticalPager allows users to swipe between pages of content. It provides a way to create carousels, image galleries, onboarding flows, or any UI that requires paging through content, and enables vertical swiping.
        """.trimIndent(),
        sampleCode = """
            // Create a PagerState for vertical paging
            val pagerState = rememberPagerState(pageCount = { 5 })

            // Create a vertical pager
            SushiVerticalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) { 
                // Content for each page
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    SushiText(
                        props = SushiTextProps(
                            text = "Vertical Page Content",
                            type = SushiTextType.Bold700
                        )
                    )
                }
            }
        """.trimIndent(),
        sampleCodeDescription = "The SushiVerticalPager component allows users to swipe between pages of content vertically.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiVerticalPagerProps",
                items = listOf(
                    "state" to "The state object to control and observe the pager's state",
                    "modifier" to "The modifier to be applied to the pager",
                    "contentPadding" to "Padding to be applied to the pager content",
                    "pageSize" to "Strategy defining how pages should be sized",
                    "beyondViewportPageCount" to "The number of pages to keep loaded beyond the visible viewport",
                    "pageSpacing" to "Spacing between each page",
                    "flingBehavior" to "The fling behavior that defines how the pager should handle fling gestures",
                    "userScrollEnabled" to "Whether user scrolling is enabled",
                    "reverseLayout" to "Whether the layout should be reversed",
                    "key" to "Optional lambda to provide a unique key for each page",
                    "pageNestedScrollConnection" to "Nested scroll connection to be applied to each page",
                    "snapPosition" to "Position to which the pages should snap",
                    "horizontalAlignment" to "Horizontal alignment of each page within the pager"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-ratingbar",
        name = "SushiRatingBar",
        title = "RatingBar",
        shortDescription = "A customizable star-based rating component for user input and display.",
        longDescription = """
            A customizable rating bar component for the Sushi design system.

            SushiRatingBar displays a row of stars that can be partially or fully filled to represent a rating value. Users can interact with the rating bar to select a rating by tapping on the stars. The component provides visual feedback through scaling animations when pressed.

            Use this component to collect user ratings or display rating information for items like restaurants, products, or services.
        """.trimIndent(),
        sampleCode = """
            // Create state to track rating value
            var rating by remember { mutableFloatStateOf(3.5f) }

            // Basic usage with default settings (5 stars)
            SushiRatingBar(
                props = SushiRatingBarProps(
                    rating = rating
                ),
                onRatingChange = {
                    rating = it
                    // Handle the rating change
                }
            )

            // Custom configuration
            SushiRatingBar(
                props = SushiRatingBarProps(
                    rating = rating,
                    starCount = 4,                  // Show 4 stars instead of 5
                    betweenSpacing = 12.dp,         // Custom spacing between stars
                    tintColor = SushiTheme.colors.yellow.v600  // Custom star color
                ),
                onRatingChange = {
                    rating = it
                },
                modifier = Modifier.height(32.dp)   // Custom height
            )
        """.trimIndent(),
        sampleCodeDescription = "The SushiRatingBar component is used to display and collect star ratings.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiRatingBarProps",
                items = listOf(
                    "rating" to "The current rating value, representing the number of filled stars. Can be a fractional value for partial star filling.",
                    "betweenSpacing" to "The spacing between each star in the rating bar",
                    "starCount" to "The total number of stars to display in the rating bar (default is 5)",
                    "tintColor" to "Optional color to apply to the stars"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-tooltip",
        name = "SushiTooltip",
        title = "Tooltip",
        shortDescription = "A customizable tooltip component for displaying contextual information.",
        longDescription = """
            A customizable tooltip component for the Sushi design system.

            SushiTooltip displays contextual information or hints when users hover over or interact with UI elements. The component supports customizable content, including text, images, and custom layouts, with configurable appearance options like color, shape, and pointer position.
        """.trimIndent(),
        sampleCode = """
            // First, create a tooltip state and remember a coroutine scope
            val tooltipState = rememberTooltipState()
            val scope = rememberCoroutineScope()

            // Basic text tooltip
            SushiTooltipBox(
                positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
                tooltip = {
                    SushiTooltip(
                        props = SushiTooltipProps(
                            text = SushiTextProps(
                                text = "This is a basic tooltip with text only",
                                color = SushiTheme.colors.text.inverse
                            )
                        )
                    )
                },
                state = tooltipState
            ) {
                // Anchor element - the tooltip will be positioned relative to this
                SushiButton(
                    props = SushiButtonProps(text = "Hover or Click Me"),
                    onClick = {
                        scope.launch {
                            tooltipState.show()
                        }
                    }
                )
            }
        """.trimIndent(),
        sampleCodeDescription = "The SushiTooltip component is used within a SushiTooltipBox to create tooltips.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiTooltipProps",
                items = listOf(
                    "text" to "Properties for configuring the tooltip's text content",
                    "prefixImage" to "Optional image to display before the text",
                    "suffixImage" to "Optional image to display after the text",
                    "containerColor" to "Background color of the tooltip (defaults to inverse surface color)",
                    "caretSize" to "Size of the tooltip's pointer/caret (width and height)",
                    "shape" to "Shape of the tooltip container (defaults to rounded corners)",
                    "shadowElevation" to "Shadow depth for the tooltip to create visual hierarchy"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    ),
    Component(
        id = "sushi-viewflipper",
        name = "SushiViewFlipper",
        title = "ViewFlipper",
        shortDescription = "A component that automatically cycles through multiple content items with animated transitions.",
        longDescription = """
            A composable that automatically cycles through multiple content items with animated transitions.

            SushiViewFlipper provides a way to display a sequence of items in the same space, automatically transitioning between them with customizable animation. This is useful for displaying rotating promotions, suggestions, or other content that should cycle through multiple options.
        """.trimIndent(),
        sampleCode = """
            // Basic usage with a list of items
            val searchSuggestions = listOf(
                "Search for \"Pizza\"",
                "Search for \"Burger\"",
                "Search for \"Pasta\"",
                "Search for \"Sushi\"",
                "Search for \"Salad\""
            )

            // Create a ViewFlipper that cycles through the suggestions
            SushiViewFlipper(
                props = SushiViewFlipperProps(
                    count = searchSuggestions.size  // Number of items to display
                ),
                modifier = Modifier.fillMaxWidth()
            ) { index ->
                // Content for each item based on index
                SushiText(
                    props = SushiTextProps(
                        text = searchSuggestions[index],
                        color = SushiTheme.colors.text.secondary
                    ),
                    modifier = Modifier.padding(16.dp)
                )
            }
        """.trimIndent(),
        sampleCodeDescription = "The SushiViewFlipper component is used to automatically cycle through different content items.",
        apiParameters = listOf(
            Component.ApiParameter(
                name = "SushiViewFlipperProps",
                items = listOf(
                    "flipInterval" to "Time in milliseconds between content flips (default: 3000ms)",
                    "animationDuration" to "Duration of the flip animation in milliseconds (default: 600ms)",
                    "animationDirection" to "Direction for the flip animation (FlipToTop or FlipToBottom)",
                    "isPlaying" to "Whether the flipper should be actively cycling (default: true)",
                    "count" to "Number of items to display in the flipper (default: 1)"
                )
            )
        ),
        banner = Res.drawable.sushi_text_banner
    )
)