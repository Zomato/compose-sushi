---
title: Media
description: A unified component for displaying different types of media content
---

# SushiMedia

A unified media component for the Sushi design system that can display different types of media.

SushiMedia provides a single interface for displaying various types of visual content,
currently supporting static images and animations. It automatically renders the appropriate
component based on the type of media specified in the properties.

This abstraction allows for easier transitions between different media types and
provides a consistent API for displaying visual content.

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img class="component-preview" src="../preview_media.png" alt="Media Preview">
</div>

## Example

The `SushiMedia` component is used to display different types of media content:

```kotlin
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
```

### Toggling Between Media Types

```kotlin
// State to track current media type
var mediaProps by remember { 
    mutableStateOf<SushiMediaProps>(
        SushiMediaProps.Image(imageProps)
    ) 
}

// Button to toggle between image and animation
SushiButton(
    props = SushiButtonProps(text = "Toggle Media Type"),
    onClick = {
        mediaProps = if (mediaProps is SushiMediaProps.Image) {
            SushiMediaProps.Animation(animationProps)
        } else {
            SushiMediaProps.Image(imageProps)
        }
    }
)

// Display the current media
SushiMedia(
    props = mediaProps,
    modifier = Modifier.size(200.dp)
)
```

## Component API

### SushiMediaProps

SushiMediaProps is a sealed class with two implementations:

| Type                                   | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`Image`</div>| Configuration for displaying a static image |
| <div class='parameter'>`Animation`</div>| Configuration for displaying an animation |

### Image Properties

When using `SushiMediaProps.Image`, you provide a `SushiImageProps` object with the following key
properties:

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`painter`</div>| The painter that will draw the image |
| <div class='parameter'>`contentDescription`</div>| Accessibility description of the image |
| <div class='parameter'>`width`</div>| The desired width of the image |
| <div class='parameter'>`height`</div>| The desired height of the image |
| <div class='parameter'>`aspectRatio`</div>| The aspect ratio to maintain |
| <div class='parameter'>`shape`</div>| The shape to clip the image to |
| <div class='parameter'>`contentScale`</div>| How the image should be scaled |
| <div class='parameter'>`alpha`</div>| The opacity of the image |
| <div class='parameter'>`colorFilter`</div>| Optional color filter to apply to the image |

### Animation Properties

When using `SushiMediaProps.Animation`, you provide a `SushiAnimationProps` object with the
following key properties:

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`source`</div>| The animation source (asset, file, URL, etc.) |
| <div class='parameter'>`playback`</div>| Controls how the animation plays |
| <div class='parameter'>`width`</div>| The desired width of the animation |
| <div class='parameter'>`height`</div>| The desired height of the animation |
| <div class='parameter'>`aspectRatio`</div>| The aspect ratio to maintain |