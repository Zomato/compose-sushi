@file:SuppressLint("ComposePreviewPublic")

package com.zomato.sushi.compose.atoms.image

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview

class SushiImageTest {
    @SushiPreview
    @Composable
    fun SushiImagePreview1() {
        SushiPreview {
            Row(Modifier.width(200.dp)) {
                SushiImage(
                    props = SushiImageProps(
                        painter = painterResource(0),   // todo: cant access resource, fix when screenshot is stable.
                        bgColor = SushiTheme.colors.red.v500,
                        width = 50.dp,
                        // height = 10.dp,
                        shape = RoundedCornerShape(10.dp),
                        contentDescription = "star",
                        contentScale = ContentScale.Fit,
                        alpha = 0.7f,
                        scaleFactor = 1f,
                        colorFilter = ColorFilter.grayscale(percentage = 80),
                        aspectRatio = 3f
                    ),
                    Modifier.weight(1f)
                )
                SushiImage(
                    props = SushiImageProps(
                        painter = painterResource(0),   // todo: cant access resource, fix when screenshot is stable.
                        bgColor = SushiTheme.colors.red.v500,
                        width = 50.dp,
                        // height = 10.dp,
                        shape = RoundedCornerShape(10.dp),
                        contentDescription = "star",
                        contentScale = ContentScale.Fit,
                        alpha = 0.3f,
                        scaleFactor = 0.6f,
                        colorFilter = ColorFilter.tint(SushiTheme.colors.green.v900.value, blendMode = BlendMode.SrcIn),
                        aspectRatio = 3f
                    ),
                    Modifier.weight(1f)
                )
                SushiImage(
                    props = SushiImageProps(
                        painter = painterResource(0),   // todo: cant access resource, fix when screenshot is stable.
                        bgColor = SushiTheme.colors.red.v500,
                        width = 50.dp,
                        shape = RoundedCornerShape(10.dp),
                        contentDescription = "star",
                        contentScale = ContentScale.Fit,
                        scaleFactor = 1f,
                        aspectRatio = 3f
                    ),
                    Modifier.weight(1f)
                )
            }
        }
    }
}