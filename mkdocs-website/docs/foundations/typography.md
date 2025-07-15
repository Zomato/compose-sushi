# Sushi Typography

Typography in Sushi Compose UI is flexible and highly structured for consistent, beautiful text
styling across your app.

## Font Families

- **OkraFontFamily:** The main UI typeface used throughout Sushi.
- **WasabiFontFamily:** Special font for icon glyphs (Wasabicons), enables scalable
  color-controllable icons as font chars.

Example:

```kotlin
TextStyle(fontFamily = OkraFontFamily, fontWeight = FontWeight.Normal)
```

## SushiTypography System

SushiTypography defines styles for every relevant font weight and size combination:

- **Weights:** light, regular, medium, semiBold, bold, extraBold
- **Sizes:** 050 to 900 (increments, see code for details)
- **Naming:** `weightSize` (e.g., bold400, regular300)

Access with:

```kotlin
val heading = SushiTheme.typography.bold700
val body = SushiTheme.typography.regular400
```

## Usage Example

```kotlin
Text(
    text = "Welcome to Sushi!",
    style = SushiTheme.typography.semiBold500
)
```

## Customizing Typography

Create your own `SushiTypography` instance:

```kotlin
val customTypography = SushiTypography(
    materialTypography = MaterialTypography,
    bold400 = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp, fontFamily = OkraFontFamily),
    // ...fill every required style (see Type.kt)
)
```

And inject it into your theme:

```kotlin
SushiTheme(typography = customTypography) { YourUI() }
```

## Integration with Material Typography

Sushi also exposes a `MaterialTypography` object that applies the Okra font to all standard Material
components for seamless integration.