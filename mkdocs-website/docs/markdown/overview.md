# Sushi Markdown Overview

Sushi Compose UI includes out-of-the-box support for rendering Markdown content inside Composables.

## Color and Weight
```kotlin
SushiText(
    props = SushiTextProps(
        text = "Hi <bold-700|{red-700|Kotlin User}>",
        color = SushiTheme.colors.text.success,
        type = SushiTextType.Regular200
    )
)
```

## Italic
```kotlin
SushiText(
    props = SushiTextProps(
        text = "This is an _italic_ text",
        color = SushiTheme.colors.text.success,
        type = SushiTextType.Regular200
    )
)
```

## Cut through
```kotlin
SushiText(
    props = SushiTextProps(
        text = "This is an ~~cutthrough~~ text",
        color = SushiTheme.colors.text.success,
        type = SushiTextType.Regular200
    )
)
```

## Clickable Links
```kotlin
SushiText(
    props = SushiTextProps(
        text = "This is an [Clickable](https://google.com) text",
        color = SushiTheme.colors.text.success,
        type = SushiTextType.Regular200
    )
)
```

## Bold
```kotlin
SushiText(
    props = SushiTextProps(
        text = "This is an **bold** text",
        color = SushiTheme.colors.text.success,
        type = SushiTextType.Regular900,
        textDecoration = SushiTextDecoration.Underline()
    )
)
```