package com.zomato.sushi.compose.sample.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.zomato.sushi.compose.R
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.image.SushiImage
import com.zomato.sushi.compose.atoms.image.SushiImageProps
import com.zomato.sushi.compose.atoms.image.grayscale
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.BaseScreen
import com.zomato.sushi.compose.sample.snippets.AppTopBar
import com.zomato.sushi.compose.sample.ui.theme.AppTheme
import kotlinx.serialization.Serializable

@Serializable
object ImageShowcaseScreen

@Composable
fun ImageShowcaseScreen(
    modifier: Modifier = Modifier
) {
    BaseScreen(modifier) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = SushiTheme.colors.surface.primary.value
        ) { innerPadding ->
            Column(
                Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                AppTopBar(
                    title = "Image Showcase",
                    Modifier.padding(
                        top = SushiTheme.dimens.spacing.base,
                        start = SushiTheme.dimens.spacing.base,
                        end = SushiTheme.dimens.spacing.base,
                        bottom = SushiTheme.dimens.spacing.base
                    )
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(SushiTheme.dimens.spacing.base)
                ) {
                    // 1. Basic Image from Resource
                    SectionTitle("Basic Usage")
                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = painterResource(id = R.drawable.sushi_rating_star),
                            width = 100.dp,
                            height = 100.dp,
                            contentDescription = "Star icon"
                        ),
                        description = "1. Basic Image from Resource"
                    )

                    // 2. Network Image with Coil
                    val foodImagePainter = rememberAsyncImagePainter(
                        model = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?w=500"
                    )
                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = foodImagePainter,
                            width = 200.dp,
                            height = 150.dp,
                            contentDescription = "Food image"
                        ),
                        description = "2. Network Image with Coil"
                    )

                    // 3. Image with AspectRatio
                    val landscapePainter = rememberAsyncImagePainter(
                        model = "https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=500"
                    )
                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = landscapePainter,
                            width = 200.dp,
                            aspectRatio = 16f/9f,
                            contentDescription = "Landscape food image"
                        ),
                        description = "3. Image with AspectRatio (16:9)"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Image Shapes
                    SectionTitle("Image Shapes")

                    // 4. Rounded Corner Shape
                    val portraitPainter = rememberAsyncImagePainter(
                        model = "https://images.unsplash.com/photo-1555939594-58d7cb561ad1?w=500"
                    )
                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = portraitPainter,
                            width = 150.dp,
                            height = 200.dp,
                            shape = RoundedCornerShape(16.dp),
                            contentDescription = "Rounded corner image"
                        ),
                        description = "4. Rounded Corner Shape"
                    )

                    // 5. Circular Shape
                    val profilePainter = rememberAsyncImagePainter(
                        model = "https://images.unsplash.com/photo-1494790108377-be9c29b29330?w=500"
                    )
                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = profilePainter,
                            width = 120.dp,
                            height = 120.dp,
                            shape = CircleShape,
                            contentDescription = "Circular profile image"
                        ),
                        description = "5. Circular Shape"
                    )

                    // 6. Custom Corner Shape
                    val customShapePainter = rememberAsyncImagePainter(
                        model = "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=500"
                    )
                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = customShapePainter,
                            width = 180.dp,
                            height = 120.dp,
                            shape = RoundedCornerShape(
                                topStart = 24.dp,
                                topEnd = 0.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 24.dp
                            ),
                            contentDescription = "Custom corner shape image"
                        ),
                        description = "6. Custom Corner Shape"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Content Scale
                    SectionTitle("Content Scale")

                    // Create a row of images with different content scales
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        val contentScalePainter = rememberAsyncImagePainter(
                            model = "https://images.unsplash.com/photo-1567620905732-2d1ec7ab7445?w=500"
                        )

                        // 7. ContentScale.Crop
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = contentScalePainter,
                                    width = 100.dp,
                                    height = 100.dp,
                                    contentScale = ContentScale.Crop,
                                    shape = RoundedCornerShape(8.dp),
                                    contentDescription = "Crop scale"
                                )
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "7. Crop",
                                    type = SushiTextType.Regular200
                                ),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }

                        // 8. ContentScale.Fit
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = contentScalePainter,
                                    width = 100.dp,
                                    height = 100.dp,
                                    contentScale = ContentScale.Fit,
                                    shape = RoundedCornerShape(8.dp),
                                    contentDescription = "Fit scale"
                                )
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "8. Fit",
                                    type = SushiTextType.Regular200
                                ),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }

                        // 9. ContentScale.FillBounds
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = contentScalePainter,
                                    width = 100.dp,
                                    height = 100.dp,
                                    contentScale = ContentScale.FillBounds,
                                    shape = RoundedCornerShape(8.dp),
                                    contentDescription = "FillBounds scale"
                                )
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "9. FillBounds",
                                    type = SushiTextType.Regular200
                                ),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }

                    // Second row of content scales
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        val contentScalePainter = rememberAsyncImagePainter(
                            model = "https://images.unsplash.com/photo-1567620905732-2d1ec7ab7445?w=500"
                        )

                        // 10. ContentScale.Inside
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = contentScalePainter,
                                    width = 100.dp,
                                    height = 100.dp,
                                    contentScale = ContentScale.Inside,
                                    shape = RoundedCornerShape(8.dp),
                                    contentDescription = "Inside scale"
                                )
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "10. Inside",
                                    type = SushiTextType.Regular200
                                ),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }

                        // 11. ContentScale.FillHeight
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = contentScalePainter,
                                    width = 100.dp,
                                    height = 100.dp,
                                    contentScale = ContentScale.FillHeight,
                                    shape = RoundedCornerShape(8.dp),
                                    contentDescription = "FillHeight scale"
                                )
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "11. FillHeight",
                                    type = SushiTextType.Regular200
                                ),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }

                        // 12. ContentScale.FillWidth
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = contentScalePainter,
                                    width = 100.dp,
                                    height = 100.dp,
                                    contentScale = ContentScale.FillWidth,
                                    shape = RoundedCornerShape(8.dp),
                                    contentDescription = "FillWidth scale"
                                )
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "12. FillWidth",
                                    type = SushiTextType.Regular200
                                ),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Alignment
                    SectionTitle("Alignment")

                    // 13. TopStart Alignment
                    val alignmentPainter = rememberAsyncImagePainter(
                        model = "https://images.unsplash.com/photo-1484723091739-30a097e8f929?w=500"
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // 13. TopStart Alignment
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = alignmentPainter,
                                    width = 100.dp,
                                    height = 100.dp,
                                    contentScale = ContentScale.None,
                                    alignment = Alignment.TopStart,
                                    shape = RoundedCornerShape(8.dp),
                                    contentDescription = "TopStart alignment"
                                )
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "13. TopStart",
                                    type = SushiTextType.Regular200
                                ),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }

                        // 14. Center Alignment
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = alignmentPainter,
                                    width = 100.dp,
                                    height = 100.dp,
                                    contentScale = ContentScale.None,
                                    alignment = Alignment.Center,
                                    shape = RoundedCornerShape(8.dp),
                                    contentDescription = "Center alignment"
                                )
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "14. Center",
                                    type = SushiTextType.Regular200
                                ),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }

                        // 15. BottomEnd Alignment
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = alignmentPainter,
                                    width = 100.dp,
                                    height = 100.dp,
                                    contentScale = ContentScale.None,
                                    alignment = Alignment.BottomEnd,
                                    shape = RoundedCornerShape(8.dp),
                                    contentDescription = "BottomEnd alignment"
                                )
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "15. BottomEnd",
                                    type = SushiTextType.Regular200
                                ),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Color Effects
                    SectionTitle("Color Effects")

                    val colorEffectsPainter = rememberAsyncImagePainter(
                        model = "https://images.unsplash.com/photo-1551782450-a2132b4ba21d?w=500"
                    )

                    // 16. Alpha Transparency
                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = colorEffectsPainter,
                            width = 200.dp,
                            height = 150.dp,
                            alpha = 0.5f,
                            shape = RoundedCornerShape(8.dp),
                            contentDescription = "Semi-transparent image"
                        ),
                        description = "16. Alpha Transparency (50%)"
                    )

                    // 17. Grayscale Filter
                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = colorEffectsPainter,
                            width = 200.dp,
                            height = 150.dp,
                            colorFilter = ColorFilter.grayscale(),
                            shape = RoundedCornerShape(8.dp),
                            contentDescription = "Grayscale image"
                        ),
                        description = "17. Grayscale Filter"
                    )

                    // 18. Partial Grayscale
                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = colorEffectsPainter,
                            width = 200.dp,
                            height = 150.dp,
                            colorFilter = ColorFilter.grayscale(percentage = 50),
                            shape = RoundedCornerShape(8.dp),
                            contentDescription = "Partial grayscale image"
                        ),
                        description = "18. Partial Grayscale (50%)"
                    )

                    // 19. Tint Color Filter
                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = colorEffectsPainter,
                            width = 200.dp,
                            height = 150.dp,
                            colorFilter = ColorFilter.tint(
                                SushiTheme.colors.blue.v500.value,
                                BlendMode.SrcAtop
                            ),
                            shape = RoundedCornerShape(8.dp),
                            contentDescription = "Blue tinted image"
                        ),
                        description = "19. Blue Tint Filter"
                    )

                    // 20. Sepia Effect (Color Matrix)
                    val sepiaMatrix = ColorMatrix(
                        floatArrayOf(
                            0.393f, 0.769f, 0.189f, 0f, 0f,
                            0.349f, 0.686f, 0.168f, 0f, 0f,
                            0.272f, 0.534f, 0.131f, 0f, 0f,
                            0f, 0f, 0f, 1f, 0f
                        )
                    )
                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = colorEffectsPainter,
                            width = 200.dp,
                            height = 150.dp,
                            colorFilter = ColorFilter.colorMatrix(sepiaMatrix),
                            shape = RoundedCornerShape(8.dp),
                            contentDescription = "Sepia image"
                        ),
                        description = "20. Sepia Effect"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Background Colors
                    SectionTitle("Background Colors")

                    // 21. Solid Background Color
                    val transparentImagePainter = rememberAsyncImagePainter(
                        model = R.drawable.sushi_rating_star
                    )
                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = transparentImagePainter,
                            width = 120.dp,
                            height = 120.dp,
                            bgColor = SushiColorData(ColorName.Blue, ColorVariation.Variation100),
                            contentDescription = "Image with background color"
                        ),
                        description = "21. Solid Background Color"
                    )

                    // 22. Background Color with Shape
                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = transparentImagePainter,
                            width = 120.dp,
                            height = 120.dp,
                            bgColor = SushiColorData(ColorName.Red, ColorVariation.Variation100),
                            shape = CircleShape,
                            contentDescription = "Image with shaped background"
                        ),
                        description = "22. Background Color with Shape"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Scaling and Transformations
                    SectionTitle("Scaling & Transformations")

                    // 23. Scale Factor
                    val transformPainter = rememberAsyncImagePainter(
                        model = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=500"
                    )
                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = transformPainter,
                            width = 150.dp,
                            height = 150.dp,
                            scaleFactor = 0.8f,
                            shape = RoundedCornerShape(8.dp),
                            contentDescription = "Scaled down image"
                        ),
                        description = "23. Scale Factor (0.8x)"
                    )

                    // 24. Scale Factor (Enlarged)
                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = transformPainter,
                            width = 150.dp,
                            height = 150.dp,
                            scaleFactor = 1.2f,
                            shape = RoundedCornerShape(8.dp),
                            contentDescription = "Scaled up image"
                        ),
                        description = "24. Scale Factor (1.2x)"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Common Use Cases
                    SectionTitle("Common Use Cases")

                    // 25. Card with Image
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        val cardImagePainter = rememberAsyncImagePainter(
                            model = "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=500"
                        )
                        Column {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = cardImagePainter,
                                    contentScale = ContentScale.Crop,
                                    aspectRatio = 16f/9f,
                                    contentDescription = "Card header image"
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                            Column(modifier = Modifier.padding(16.dp)) {
                                SushiText(
                                    props = SushiTextProps(
                                        text = "25. Card with Image",
                                        type = SushiTextType.Medium500
                                    )
                                )
                                SushiText(
                                    props = SushiTextProps(
                                        text = "Images work well as card headers with fixed aspect ratios",
                                        type = SushiTextType.Regular300
                                    ),
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                        }
                    }

                    // 26. Avatar Image
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val avatarPainter = rememberAsyncImagePainter(
                            model = "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?w=500"
                        )
                        SushiImage(
                            props = SushiImageProps(
                                painter = avatarPainter,
                                width = 60.dp,
                                height = 60.dp,
                                shape = CircleShape,
                                contentScale = ContentScale.Crop,
                                contentDescription = "User avatar"
                            )
                        )
                        Column(modifier = Modifier.padding(start = 16.dp)) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "Jane Doe",
                                    type = SushiTextType.Medium500
                                )
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "26. Circular Avatar Image",
                                    type = SushiTextType.Regular300
                                )
                            )
                        }
                    }

                    // 27. Banner Image
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        val bannerPainter = rememberAsyncImagePainter(
                            model = "https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=800"
                        )
                        SushiImage(
                            props = SushiImageProps(
                                painter = bannerPainter,
                                aspectRatio = 3f,
                                contentScale = ContentScale.Crop,
                                shape = RoundedCornerShape(8.dp),
                                contentDescription = "Banner image"
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .align(Alignment.BottomStart)
                        ) {
                            SushiText(
                                props = SushiTextProps(
                                    text = "27. Banner Image with Text Overlay",
                                    type = SushiTextType.SemiBold600,
                                    color = SushiColorData(ColorName.White, ColorVariation.Variation900)
                                )
                            )
                        }
                    }

                    // 28. Gallery Grid
                    SushiText(
                        props = SushiTextProps(
                            text = "28. Image Gallery Grid",
                            type = SushiTextType.Medium500
                        ),
                        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        val imageUrls = listOf(
                            "https://images.unsplash.com/photo-1467003909585-2f8a72700288?w=300",
                            "https://images.unsplash.com/photo-1484980972926-edee96e0960d?w=300",
                            "https://images.unsplash.com/photo-1476224203421-9ac39bcb3327?w=300"
                        )

                        imageUrls.forEach { url ->
                            SushiImage(
                                props = SushiImageProps(
                                    painter = rememberAsyncImagePainter(model = url),
                                    contentScale = ContentScale.Crop,
                                    shape = RoundedCornerShape(4.dp),
                                    contentDescription = "Gallery image"
                                ),
                                modifier = Modifier
                                    .weight(1f)
                                    .aspectRatio(1f)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Advanced Examples
                    SectionTitle("Advanced Examples")

                    // 29-32. Different Aspect Ratios
                    SushiText(
                        props = SushiTextProps(
                            text = "29-32. Different Aspect Ratios",
                            type = SushiTextType.Medium500
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    val aspectRatioPainter = rememberAsyncImagePainter(
                        model = "https://images.unsplash.com/photo-1540189549336-e6e99c3679fe?w=500"
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // 29. Square (1:1)
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(1f)
                        ) {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = aspectRatioPainter,
                                    aspectRatio = 1f,
                                    contentScale = ContentScale.Crop,
                                    shape = RoundedCornerShape(8.dp),
                                    contentDescription = "Square image"
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "29. 1:1",
                                    type = SushiTextType.Regular200
                                ),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }

                        // 30. Portrait (3:4)
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(1f)
                        ) {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = aspectRatioPainter,
                                    aspectRatio = 3f/4f,
                                    contentScale = ContentScale.Crop,
                                    shape = RoundedCornerShape(8.dp),
                                    contentDescription = "Portrait image"
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "30. 3:4",
                                    type = SushiTextType.Regular200
                                ),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }

                        // 31. Landscape (16:9)
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(1f)
                        ) {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = aspectRatioPainter,
                                    aspectRatio = 16f/9f,
                                    contentScale = ContentScale.Crop,
                                    shape = RoundedCornerShape(8.dp),
                                    contentDescription = "Landscape image"
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "31. 16:9",
                                    type = SushiTextType.Regular200
                                ),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }

                        // 32. Panorama (21:9)
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(1f)
                        ) {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = aspectRatioPainter,
                                    aspectRatio = 21f/9f,
                                    contentScale = ContentScale.Crop,
                                    shape = RoundedCornerShape(8.dp),
                                    contentDescription = "Panorama image"
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "32. 21:9",
                                    type = SushiTextType.Regular200
                                ),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // 33. Image with Custom Background (Transparent Image)
                    val logoImagePainter = rememberAsyncImagePainter(
                        model = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Instagram_logo.svg/1200px-Instagram_logo.svg.png"
                    )

                    Box(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth()
                            .background(
                                SushiColorData(ColorName.Grey, ColorVariation.Variation200).value,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = logoImagePainter,
                                    width = 150.dp,
                                    height = 150.dp,
                                    contentDescription = "Logo with background"
                                )
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "33. Image with Custom Background",
                                    type = SushiTextType.Medium400
                                ),
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }

                    // 34. Inverted Color Image (Negative)
                    val invertMatrix = ColorMatrix(
                        floatArrayOf(
                            -1f, 0f, 0f, 0f, 255f,
                            0f, -1f, 0f, 0f, 255f,
                            0f, 0f, -1f, 0f, 255f,
                            0f, 0f, 0f, 1f, 0f
                        )
                    )

                    ImageWithDescription(
                        props = SushiImageProps(
                            painter = rememberAsyncImagePainter(
                                model = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?w=500"
                            ),
                            width = 200.dp,
                            height = 150.dp,
                            shape = RoundedCornerShape(8.dp),
                            colorFilter = ColorFilter.colorMatrix(invertMatrix),
                            contentDescription = "Inverted colors image"
                        ),
                        description = "34. Inverted Colors Effect"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // 35. Placeholder & Loading States
                    SushiText(
                        props = SushiTextProps(
                            text = "35. Image with Placeholder",
                            type = SushiTextType.Medium500
                        ),
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(SushiTheme.colors.grey.v200.value),
                        contentAlignment = Alignment.Center
                    ) {
                        // Use a very slow-loading or non-existent URL to simulate loading
                        val slowLoadingPainter = rememberAsyncImagePainter(
                            model = "https://images.unsplash.com/photo-1589118949245-7d38baf380d6?w=2000"
                        )

                        SushiImage(
                            props = SushiImageProps(
                                painter = slowLoadingPainter,
                                contentScale = ContentScale.Crop,
                                contentDescription = "Slow loading image"
                            ),
                            modifier = Modifier.fillMaxSize()
                        )

                        // This would typically be shown during loading
                        SushiText(
                            props = SushiTextProps(
                                text = "Image is loading...",
                                type = SushiTextType.Medium400,
                                color = SushiTheme.colors.text.secondary
                            )
                        )
                    }

                    // 36. Edge-to-edge full width image
                    SushiText(
                        props = SushiTextProps(
                            text = "36. Edge-to-Edge Image",
                            type = SushiTextType.Medium500
                        ),
                        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                    )

                    SushiImage(
                        props = SushiImageProps(
                            painter = rememberAsyncImagePainter(
                                model = "https://images.unsplash.com/photo-1499028344343-cd173ffc68a9?w=800"
                            ),
                            aspectRatio = 2f,
                            contentScale = ContentScale.Crop,
                            contentDescription = "Edge-to-edge image"
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    // 37. Combination of Effects
                    val comboPainter = rememberAsyncImagePainter(
                        model = "https://images.unsplash.com/photo-1490645935967-10de6ba17061?w=500"
                    )

                    Card(
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    ) {
                        Column {
                            Box {
                                // Semi-transparent duotone effect
                                val duotoneMatrix = ColorMatrix().apply {
                                    setToSaturation(0.5f) // Reduce saturation for duotone-like effect
                                }

                                SushiImage(
                                    props = SushiImageProps(
                                        painter = comboPainter,
                                        aspectRatio = 1.5f,
                                        contentScale = ContentScale.Crop,
                                        colorFilter = ColorFilter.colorMatrix(duotoneMatrix),
                                        contentDescription = "Combined effects image"
                                    ),
                                    modifier = Modifier.fillMaxWidth()
                                )

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                        .align(Alignment.BottomStart)
                                ) {
                                    SushiText(
                                        props = SushiTextProps(
                                            text = "37. Combination of Effects",
                                            type = SushiTextType.SemiBold600,
                                            color = SushiColorData(ColorName.White, ColorVariation.Variation900)
                                        )
                                    )
                                }
                            }

                            Column(modifier = Modifier.padding(16.dp)) {
                                SushiText(
                                    props = SushiTextProps(
                                        text = "Custom color matrix with tint and overlay text",
                                        type = SushiTextType.Regular400
                                    )
                                )
                            }
                        }
                    }

                    // 38. Side-by-Side Comparison
                    SushiText(
                        props = SushiTextProps(
                            text = "38. Side-by-Side Comparison",
                            type = SushiTextType.Medium500
                        ),
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        val comparisonPainter = rememberAsyncImagePainter(
                            model = "https://images.unsplash.com/photo-1539136788836-5699e78bfc75?w=500"
                        )

                        // Original Image
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(1f)
                        ) {
                            SushiImage(
                                props = SushiImageProps(
                                    painter = comparisonPainter,
                                    aspectRatio = 1f,
                                    contentScale = ContentScale.Crop,
                                    shape = RoundedCornerShape(8.dp),
                                    contentDescription = "Original image"
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "Original",
                                    type = SushiTextType.Regular300
                                ),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }

                        // Processed Image
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(1f)
                        ) {
                            val highContrastMatrix = ColorMatrix().apply {
                                setToSaturation(1.8f) // Higher saturation for enhanced look
                            }

                            SushiImage(
                                props = SushiImageProps(
                                    painter = comparisonPainter,
                                    aspectRatio = 1f,
                                    contentScale = ContentScale.Crop,
                                    shape = RoundedCornerShape(8.dp),
                                    colorFilter = ColorFilter.colorMatrix(highContrastMatrix),
                                    contentDescription = "Processed image"
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                            SushiText(
                                props = SushiTextProps(
                                    text = "Enhanced",
                                    type = SushiTextType.Regular300
                                ),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }

                    // 39. Product Image with Background
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    ) {
                        val productPainter = rememberAsyncImagePainter(
                            model = "https://images.unsplash.com/photo-1576566588028-4147f3842f27?w=500"
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFF8F1E7))
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                SushiImage(
                                    props = SushiImageProps(
                                        painter = productPainter,
                                        width = 200.dp,
                                        height = 200.dp,
                                        contentScale = ContentScale.Fit,
                                        contentDescription = "Product image"
                                    )
                                )
                                SushiText(
                                    props = SushiTextProps(
                                        text = "39. Product Image with Background",
                                        type = SushiTextType.Medium500
                                    ),
                                    modifier = Modifier.padding(top = 16.dp)
                                )
                                SushiText(
                                    props = SushiTextProps(
                                        text = "Product showcase with custom background color",
                                        type = SushiTextType.Regular300
                                    ),
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }
                        }
                    }

                    // 40. Food Image Collage
                    SushiText(
                        props = SushiTextProps(
                            text = "40. Food Image Collage",
                            type = SushiTextType.Medium500
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                        // Main large image (left side)
                        SushiImage(
                            props = SushiImageProps(
                                painter = rememberAsyncImagePainter(
                                    model = "https://images.unsplash.com/photo-1473093295043-cdd812d0e601?w=500"
                                ),
                                contentScale = ContentScale.Crop,
                                contentDescription = "Main food image"
                            ),
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.65f)
                                .align(Alignment.CenterStart)
                        )

                        // Right column with two images
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.35f)
                                .align(Alignment.CenterEnd),
                            verticalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            // Top right image
                            SushiImage(
                                props = SushiImageProps(
                                    painter = rememberAsyncImagePainter(
                                        model = "https://images.unsplash.com/photo-1481931098730-318b6f776db0?w=500"
                                    ),
                                    contentScale = ContentScale.Crop,
                                    contentDescription = "Food image top"
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            )

                            // Bottom right image
                            SushiImage(
                                props = SushiImageProps(
                                    painter = rememberAsyncImagePainter(
                                        model = "https://images.unsplash.com/photo-1529042410759-befb1204b468?w=500"
                                    ),
                                    contentScale = ContentScale.Crop,
                                    contentDescription = "Food image bottom"
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    SushiText(
        props = SushiTextProps(
            text = title,
            type = SushiTextType.SemiBold600,
            color = SushiTheme.colors.text.primary
        ),
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
private fun ImageWithDescription(
    props: SushiImageProps,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SushiImage(
            props = props,
            modifier = Modifier
        )
        SushiText(
            props = SushiTextProps(
                text = description,
                type = SushiTextType.Regular400
            ),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
@SushiPreview
private fun ImageShowcaseScreenPreview() {
    AppTheme {
        ImageShowcaseScreen()
    }
}