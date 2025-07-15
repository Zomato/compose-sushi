# SushiTheme & App Theming

SushiTheme brings together your color scheme, typography, and shapes into a unified design system
for your app. Always wrap your app or screen content in `SushiTheme`.

## Basic Usage

```kotlin
import com.zomato.sushi.compose.theme.SushiTheme

SushiTheme {
    MyAppContent()
}
```

## Customizing the Theme

Override any of the color scheme, typography, or shapes:

```kotlin
SushiTheme(
    colorScheme = CustomScheme,
    typography = CustomTypography,
    shapes = CustomShapes
) {
    // App content here
}
```

## Wrapping SushiTheme in Your Own AppTheme

Create a custom theme for global logic or to enforce branding:

```kotlin
@Composable
fun AppTheme(content: @Composable () -> Unit) {
    SushiTheme(
        colorScheme = AppColorScheme,
        typography = AppTypography,
        shapes = AppShapes
    ) {
        content()
    }
}
```

Usage:

```kotlin
AppTheme { MyAppContent() }
```

## Accessing Theme Tokens

Inside a composable, access design tokens like so:

```kotlin
val primaryBackground = SushiTheme.colors.background.primary
val headingStyle = SushiTheme.typography.bold900
```

## Material3 Compatibility

SushiTheme ensures all Material3 components use your custom Sushi settings. `MaterialTypography`
ensures Okra fonts are auto-applied.