@file:SuppressLint("ComposePreviewPublic")

package com.zomato.sushi.compose.atoms.icon

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview

class SushiIconTest {
    @SushiPreview
    @Composable
    fun SushiIconPreview1() {
        SushiPreview {
            SushiIcon(
                SushiIconProps(
                    code = SushiIconCodes.IconMoon,
                    size = SushiIconSize.Size300
                ),
                Modifier
            )
        }
    }

    @SushiPreview
    @Composable
    fun SushiIconPreview2() {
        SushiPreview {
            SushiIcon(
                SushiIconProps(
                    code = SushiIconCodes.IconContactlessDining,
                    color = SushiTheme.colors.red.v500
                ),
                Modifier
            )
        }
    }

    @SushiPreview
    @Composable
    fun SushiIconPreview3() {
        SushiPreview {
            SushiIcon(
                SushiIconProps(
                    code = SushiIconCodes.IconContactlessDining,
                    color = SushiTheme.colors.red.v500,
                    size = SushiIconSize.Size900
                ),
                Modifier
            )
        }
    }

    @SushiPreview
    @Composable
    fun SushiIconPreview4() {
        SushiPreview {
            SushiIcon(
                SushiIconProps(
                    code = SushiIconCodes.IconContactlessDining,
                    color = SushiTheme.colors.red.v500,
                    size = 100.dp.asIconSizeSpec()
                ),
                Modifier.size(200.dp)
            )
        }
    }

    @SushiPreview
    @Composable
    fun SushiIconPreview5() {
        SushiPreview {
            SushiIcon(
                SushiIconProps(
                    code = SushiIconCodes.IconContactlessDining,
                    color = SushiTheme.colors.red.v500,
                    size = 100.dp.asIconSizeSpec()
                )
            )
        }
    }
}