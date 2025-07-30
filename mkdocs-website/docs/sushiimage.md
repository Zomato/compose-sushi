---
title: SushiImage
description: A customizable component for displaying images in the Sushi design system.
---

# SushiImage

A composable component that displays images in the Sushi design system.

SushiImage provides a consistent way to display images with various customization options
like shapes, sizing, scaling, filters, and more. It supports both fixed dimensions and
aspect ratio-based sizing, as well as click interactions.

The component intelligently handles different combinations of width, height, and aspect ratio:

- If width and height are provided, both are applied
- If width and aspect ratio are provided, height is calculated automatically
- If height and aspect ratio are provided, width is calculated automatically

<div style="max-width: 800px; max-height: 340px; border-radius: 20px; overflow: hidden; border: 1px solid #777;">
    <img class="component-preview" src="../preview_image.png" alt="Image Preview">
</div>

## Example

The `SushiImage` component is used to display images with various customization options.

```kotlin
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

// Network image with aspect ratio
val foodImagePainter = rememberAsyncImagePainter(
    model = "https://example.com/food.jpg"
)

SushiImage(
    props = SushiImageProps(
        painter = foodImagePainter,
        aspectRatio = 16f/9f,
        contentScale = ContentScale.Crop,
        shape = RoundedCornerShape(12.dp),
        contentDescription = "Food image with aspect ratio"
    ),
    modifier = Modifier.fillMaxWidth()
)
```

## Component API

### SushiImage

| Parameter                               | Description                      |
|-----------------------------------------|----------------------------------|
| <div class='parameter'>`painter`</div>| The painter responsible for drawing the image content |
| <div class='parameter'>`bgColor`</div>| The background color behind the image |
| <div class='parameter'>`aspectRatio`</div>| The width to height ratio to maintain (e.g., 16/9 = 1.78) |
| <div class='parameter'>`height`</div>| The explicit height for the image (optional) |
| <div class='parameter'>`width`</div>| The explicit width for the image (optional) |
| <div class='parameter'>`shape`</div>| The shape to clip the image to (e.g., RoundedCornerShape) |
| <div class='parameter'>`contentDescription`</div>| Accessibility description of the image for screen readers |
| <div class='parameter'>`contentScale`</div>| How the image should be scaled within its bounds (e.g., Fit, Crop) |
| <div class='parameter'>`alpha`</div>| Opacity level from 0.0 (transparent) to 1.0 (opaque) |
| <div class='parameter'>`scaleFactor`</div>| Additional scaling factor applied to the image size |
| <div class='parameter'>`alignment`</div>| How the image should be aligned within its bounds |
| <div class='parameter'>`colorFilter`</div>| Optional filter to apply color transformations to the image |