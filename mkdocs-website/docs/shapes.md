# Sushi Custom Shapes

Sushi Compose UI offers a variety of ready-made shapes for avatars, cards, buttons, and more, making
your UI feel both playful and branded.

## Built-in Shapes

Common Sushi shapes include:

- **Ticket Shape**
- **Squircle Shape**.

Example usage:

```kotlin
Box(
    Modifier
        .clip(SquircleShape(radius = SushiTheme.dimens.spacing.base))
) {
    // Content
}
```
