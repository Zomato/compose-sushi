# 🍣 Sushi: The Compose Multiplatform Design System by Zomato

---

## Picture This: One Design, Many Worlds 🌏

Imagine this: You’ve just crafted a stunning UI for your app. It looks perfect on Android. But on iPad, the fonts are off, buttons are squished, and your carefully chosen color palette feels completely off. On the desktop, the responsive layout falls apart. On the web? It’s chaos.

Sounds familiar? Welcome to the complex world of Compose Multiplatform UI, where your design system isn’t a standardized model, it needs to be an adaptive powerhouse, elegant on Android, sharp on iOS, pixel-perfect on desktop, and snappy on the web.

This is the story of how Zomato built Sushi: a design system as adaptable and consistent as your favourite dish from your go-to restaurant and as efficient as your food delivery order time. 🍛

---

## The Problem: One Design, Infinite Screens 🤹‍♂️

Building a design system for Compose Multiplatform goes beyond choosing color schemes or rounding button corners. It’s about:

- **Device Fragmentation:** Phones, tablets, desktops, foldables, TVs and smartwatches, all with varying screen sizes, DPIs, aspect ratios, and input methods.
- **Platform Quirks:** Android relies on Material Design, iOS follows Cupertino guidelines, and the web adheres to no single standard. A good design system must feel perfect on each platform while still retaining a consistent brand identity.
- **Consistency vs. Flexibility:** Your design should reflect your brand’s personality, but also allow teams to customize, iterate, and move quickly.
- **Performance:** Visual flourishes like animations, gradients and shadows are appealing, until they start affecting performance on low-end devices or browsers.

The traditional approaches, simply don’t  cut the modern requirements:
- **Copy-paste design:** Leads to a Frankenstein’s monster of styles.
- **Platform-only libraries:** Great for one OS, but a pain everywhere else.
- **One-size-fits-none:** The “average” device is a myth.

We needed something better. Something delicious. 🍣

---

## Introducing: Sushi! 🍣

What if your design system could:
- **Look and feel amazing everywhere**—from Android to iOS, desktop to web?
- **Let you theme, customize, and extend** with just a few lines of code?
- **Ship with a buffet of ready-to-use components**—all beautiful, all consistent?
- **Scale from MVP to millions of users** (like we do at Zomato, and all ETERNAL apps)?

That’s Sushi, a Compose Multiplatform superpower. And today, we’re open-sourcing it for everyone. 🎉

🌐 [Website: zomato.github.io/compose-sushi](https://zomato.github.io/compose-sushi)  
💻 [GitHub: github.com/Zomato/compose-sushi](https://github.com/Zomato/compose-sushi)  
📲 **Try the demo app directly from the GitHub page!**

---

## 🥢 Why Sushi?

- **Multiplatform First:** Write once, run everywhere Compose runs (Android, iOS, Desktop, Web, and more).
- **Production Proven:** Sushi powers Zomato, serving millions of users daily (currently being used on Android).
- **Composable & Extensible:** Built on Jetpack Compose idioms, with a focus on flexibility and customizability at its core.
- **Beautiful by Default:** Carefully crafted color schemes, typography, and components.
- **Open Source:** Open, accessible and available for everyone! 🎉

---

## 🚀 Getting Started

Add Sushi to your Compose Multiplatform project:

```kotlin
dependencies {
    implementation("com.eternal.kits:sushi-compose:<version>")
}
```

---

## 🏗️ Foundation Layer: Theming, Colors, and Typography

### 🎨 Theming with `SushiTheme`

Inspired by MaterialTheme, Sushi provides a powerful theming system tailored for Sushi's design language. Use SushiTheme to wrap your app or screen and provide consistent colors, typography, and dimensions throughout your UI.

```kotlin
SushiTheme(
    colorScheme = SushiColorScheme, // Choose from many built-in schemes!
    typography = SushiTypography,   // Customize or use defaults
    dimens = SushiDimension(),      // Spacing, corner radius, etc.
    fontSizeMultiplier = { it },    // For accessibility/font scaling
    colorTokenMapper = { SushiUnspecified.asColorSpec() } // Advanced: map tokens to colors
) {
    // Your UI here
}
```

#### `SushiTheme` Parameters
- `colorScheme`: The active color palette (see below for options!)
- `typography`: The font styles and weights
- `dimens`: Spacing and corner radius system
- `fontSizeMultiplier`: Function to scale font sizes (for accessibility)
- `colorTokenMapper`: Mapping for custom color tokens

Access theme values anywhere in your composables:
```kotlin
val colors = SushiTheme.colors
val typography = SushiTheme.typography
val dimens = SushiTheme.dimens
```

---

### 🌈 Color Schemes

Sushi offers extensive customisation with diverse color schemes each with light and dark variants. Some of the built-in schemes include **Red, Pink, Purple, Blue, Teal, Green, Yellow, Orange, Tangerine, Charcoal, Slate, Cider, Gold, Grey, Honey, Indigo, Lime, Onion, Avacado, Brown**

Each scheme is defined in `foundation/colorscheme/` and can be used like:
```kotlin
SushiTheme(colorScheme = sushiRedColorScheme()) { ... }
```

---

### 🖌️ ColorSpec: Flexible Color Abstraction

Sushi introduces `ColorSpec`, a sealed interface that abstracts how colors are defined and accessed. This allows you to:
- Use Compose `Color` objects
- Use ARGB `Int` or `Long` values
- Use hex strings (e.g., `"#FF0000"`)
- Apply alpha transformations

#### Example Usage
```kotlin
val color1: ColorSpec = Color.Red.asColorSpec()
val color2: ColorSpec = 0xFFFF0000.toInt().asIntColorSpec()
val color3: ColorSpec = "#00FF00".asHexColorSpec()
val colorWithAlpha = color1.withAlpha(0.5f)
```

This makes it easy to theme and customize components, and to support dynamic or token-based color systems.

---

### 🔤 TextTypeSpec: Powerful Typography

Typography in Sushi is handled via `TextTypeSpec`, a sealed interface that lets you:
- Use predefined text types (e.g., `SushiTextType.Regular400`)
- Wrap any Compose `TextStyle` as a spec
- Transform styles on the fly

#### Example Usage
```kotlin
val type: TextTypeSpec = SushiTextType.Bold700
val customType: TextTypeSpec = TextStyle(fontSize = 20.sp).asTextTypeSpec()
val modifiedType = type.transform { it.copy(letterSpacing = 1.sp) }
```

All text types are mapped to the theme’s typography, ensuring consistency across your app.

---

## 🧩 Sushi Components

### SushiText
A highly customizable text component supporting:
- All Sushi typography and color options
- Markdown formatting
- Prefix/suffix icons or custom composables
- Text decorations (underline, strikethrough)
- Expandable text with "Read More"
- Alignment, arrangement, and more

**Example:**
```kotlin
SushiText(
    props = SushiTextProps(
        text = "Hello, Sushi!",
        type = SushiTextType.Bold700,
        color = SushiTheme.colors.text.primary,
        prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
        suffixIcon = SushiIconProps(code = SushiIconCodes.IconContactlessDining),
        maxLines = 2,
        overflowText = "Read More"
    )
)
```

---

### SushiIcon
A composable for rendering icons from the Sushi (Wasabi) icon font. Supports:
- Hundreds of icons (see `SushiIconCodes`)
- Custom size and color
- Clickable icons

**Example:**
```kotlin
SushiIcon(
    props = SushiIconProps(
        code = SushiIconCodes.IconMoon,
        size = SushiIconSize.Size300,
        color = SushiTheme.colors.icon.primary
    )
)
```

---

### SushiButton
A flexible button supporting multiple styles and sizes:
- Types: `Text`, `Solid`, `Outline`
- Sizes: `Small`, `Medium`, `Large`
- Prefix/suffix icons, subtext, custom content
- Disabled/enabled states

**Example:**
```kotlin
SushiButton(
    props = SushiButtonProps(
        text = "Order Now",
        type = SushiButtonType.Solid,
        size = SushiButtonSize.Large,
        prefixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp)
    ),
    onClick = { /* handle click */ }
)
```

---

### 📚 More Components

- **SushiImage:** Display images with Sushi theming and shapes
- **SushiCheckBox:** Customizable checkbox with Sushi styles
- **SushiRadioButton:** Radio button with text, icons and custom alignment
- **SushiSwitch:** Toggle switch with Sushi colors
- **SushiTag:** Pill-shaped tag for status or categories
- **SushiTextField:** Text input with labels, error states and icons
- **SushiAnimation:** Lottie/animated asset support
- **SushiLoader:** Loading spinner/indicator
- **SushiCard:** Card container with elevation and shape
- **SushiIndicator:** Progress or status indicator
- **SushiDivider:** Themed divider line
- **SushiShimmer:** Shimmer effect for loading placeholders
- **SushiSnackbar:** Snackbar/toast for brief messages
- **SushiBottomSheet:** Modal bottom sheet
- **SushiDialog:** Dialog/modal window
- **SushiDropDown:** Dropdown menu
- **SushiMedia:** Media (image/video) display
- **SushiOTPInput:** OTP/pin input field
- **SushiHorizontalPager:** Horizontal paging (carousel)
- **SushiVerticalPager:** Vertical paging
- **SushiRatingBar:** Star rating input
- **SushiTooltip:** Tooltip for hints
- **SushiViewFlipper:** Animated view switcher

---

## 🥳 Final Thoughts & Links

We’re excited to share Sushi with the world and can’t wait to see what you build! For more details, docs, and updates:
- Website: [zomato.github.io/compose-sushi](https://zomato.github.io/compose-sushi)
- Github: [github.com/Zomato/compose-sushi](https://github.com/Zomato/compose-sushi)

Feel free to open issues, contribute, or just say hi! 🍣

---
⚠️ Note: At the time of writing, Sushi is stable and production-ready for Android. Support for iOS, Desktop, and Web is coming soon - stay tuned!