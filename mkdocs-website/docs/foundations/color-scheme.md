# Sushi Color Scheme

Sushi Compose UI provides a flexible and expressive color system for building visually unified and
accessible apps. The color scheme defines a range of roles such as primary, secondary, error,
background, surface, and their respective variants.

## Structure and Philosophy

- **Palette Roles:** Sushi groups colors by semantic purpose (primary, surface, error, etc).

## Customisations:
- **Color Schemes:** Sushi provides light and dark mode mappings for color tokens, which you can customise as needed.
- **Color Modes:** Sushi supports various color modes (accessed via `sushi*LightColorScheme()`) to choose from, based on the primary colors of your app.

## Using Sushi Colors

Access theme colors with `SushiTheme.colors` inside composables:

```kotlin

SushiText(
  SushiTextProps(
    text = "Welcome!",
    color = SushiTheme.colors.text.primary
  )
)
```

You can use these in any Compose element, including backgrounds or content:

```kotlin
Box(
    modifier = Modifier.background(SushiTheme.colors.background.primary)
) {
   // Content
}
```

## Creating a Custom Color Scheme

To personalize your app, create a `SushiColorScheme`:

```kotlin
val CustomScheme = sushiLightColorScheme(
    materialColorScheme = ...,
    themeColorScheme = ...,
    baseColorScheme = ...,
    textColorScheme = ...,
    iconColorScheme = ...,
    ...
)
```

Similarly, other options can be customised:

```kotlin
SushiTheme(
  colorScheme = CustomScheme,
  typography = SushiTheme.typography,
  dimens = SushiTheme.dimens,
  fontSizeMultiplier = SushiTheme.fontSizeMultiplier,
  colorTokenMapper = SushiTheme.colorTokenMapper
) {
  // Your app content
}
```

## Best Practices

- Ensure high contrast for text accessibility
- Stick to your brand palette throughout
- Override all required roles for full control