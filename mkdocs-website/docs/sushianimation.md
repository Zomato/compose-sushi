---
title: SushiAnimation
description: A composable component for displaying Lottie animations in the Sushi design system.
---

# SushiAnimation

A composable component for displaying animations in the Sushi design system.
Supports Lottie animations from various sources with customizable playback behavior.

SushiAnimation provides a convenient way to integrate Lottie animations into your application,
with support for animations from different sources:

- Assets directory
- File system
- JSON strings
- Android resources
- URLs
- Pre-loaded Lottie compositions

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img class="component-preview" src="../preview_animation.png" alt="Animation Preview">
</div>

## Example

The `SushiAnimation` component is used to display Lottie animations with various configurations.

```kotlin
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

// Manual control of animation progress
val composition = rememberLottieComposition(LottieCompositionSpec.Asset("animation.json"))
var progress by remember { mutableStateOf(0f) }

val manualControlProps by rememberSushiAnimationProps(
    source = LottieCompositionSource(composition.value),
    playback = SushiAnimationPlayback.Progress { progress }
)

SushiAnimation(props = manualControlProps)

// Update progress with a slider
Slider(
    value = progress,
    onValueChange = { progress = it },
    valueRange = 0f..1f
)
```

## Component API

### SushiAnimation

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`source`</div>| The animation source to be displayed |
| <div class='parameter'>`playback`</div>| The playback configuration controlling how the animation plays |
| <div class='parameter'>`width`</div>| Optional explicit width for the animation |
| <div class='parameter'>`height`</div>| Optional explicit height for the animation |
| <div class='parameter'>`aspectRatio`</div>| Optional aspect ratio to maintain (width:height) |
| <div class='parameter'>`bgColor`</div>| Background color for the animation container |

### Animation Sources

The component supports various sources for Lottie animations:

| Source Type                     | Description                      |
|----------------------------------|----------------------------------|
| <div class='parameter'>`LottieAssetSource`</div>| Animation from the app's assets directory |
| <div class='parameter'>`LottieFileSource`</div>| Animation from a file in the file system |
| <div class='parameter'>`LottieJsonSource`</div>| Animation from a JSON string |
| <div class='parameter'>`LottieResourceIdSource`</div>| Animation from an Android resource |
| <div class='parameter'>`LottieUrlSource`</div>| Animation loaded from a URL |
| <div class='parameter'>`LottieCompositionSource`</div>| Pre-loaded Lottie composition |

### Animation Playback

Controls how the animation plays:

| Playback Type                   | Description                      |
|----------------------------------|----------------------------------|
| <div class='parameter'>`AutoPlay`</div>| Automatically plays the animation with options for looping, speed, etc. |
| <div class='parameter'>`Progress`</div>| Manually control animation progress with a value provider function |