@file:SuppressLint("ComposePreviewPublic")

package com.zomato.sushi.compose.atoms.loader

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.internal.SushiPreview

class SushiLoaderTest {

    @SushiPreview
    @Composable
    private fun SushiLoaderPreview1() {
        SushiPreview {
            SushiLoader(
                SushiLoaderProps(

                )
            )
        }
    }

    @SushiPreview
    @Composable
    private fun SushiLoaderPreview2() {
        SushiPreview {
            SushiLoader(
                SushiLoaderProps(

                ),
                Modifier.size(100.dp)
            )
        }
    }

    @SushiPreview
    @Composable
    private fun SushiLoaderPreview3() {
        SushiPreview {
            SushiLoader(
                SushiLoaderProps(),
                Modifier.width(100.dp)
            )
        }
    }
}