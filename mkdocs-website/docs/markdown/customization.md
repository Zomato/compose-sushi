# Customizing Markdown Processing

Sushi's markdown engine is flexible and developer-friendly. You can extend it with custom processors
or override its styling as needed.

## Extending the Processor

To support custom syntax or behaviors, provide your own processors or transformers:

```kotlin
val customMdProcessor = remember(Unit) {
    MarkdownParser.Builder()
        .processor(EmojiMarkdownProcessor())
        .build()
}
val customEmojiText = customMdProcessor.parse("I love sushi! :sushi:")

SushiText(
    props = SushiTextProps(
        text = customEmojiText
    )
)
```