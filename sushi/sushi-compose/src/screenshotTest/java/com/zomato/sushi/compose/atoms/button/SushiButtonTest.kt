@file:SuppressLint("ComposePreviewPublic")

package com.zomato.sushi.compose.atoms.button

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.internal.SushiPreview

class SushiButtonTest {

    @SushiPreview
    @Composable
    fun ZSolidButtonPreview1() {
        SushiPreview {
            SushiButton(
                SushiButtonProps(
                    type = SushiButtonType.Solid,
                    text = "Tsogy",
                    enabled = false
                ),
                onClick = {}
            )
        }
    }

    @SushiPreview
    @Composable
    fun ZSolidButtonPreview2() {
        SushiPreview {
            SushiButton(
                SushiButtonProps(
                    type = SushiButtonType.Solid,
                    text = "Tsogy"
                ),
                onClick = {}
            )
        }
    }

    @SushiPreview
    @Composable
    fun ZSolidButtonPreview3() {
        SushiPreview {
            SushiButton(
                SushiButtonProps(
                    type = SushiButtonType.Solid,
                    text = "Tsogy",
                    subText = "hehe"
                ),
                onClick = {}
            )
        }
    }

    @SushiPreview
    @Composable
    fun ZSolidButtonPreview4() {
        SushiPreview {
            SushiButton(
                SushiButtonProps(
                    type = SushiButtonType.Solid,
                    text = "Small",
                    size = SushiButtonSize.Small
                ),
                onClick = {}
            )
        }
    }

    @SushiPreview
    @Composable
    fun ZSolidButtonPreview5() {
        SushiPreview {
            SushiButton(
                SushiButtonProps(
                    type = SushiButtonType.Solid,
                    text = "Large",
                    size = SushiButtonSize.Large,
                    verticalAlignment = Alignment.CenterVertically,
                    suffixIcon = SushiIconProps(code = SushiIconCodes.IconNextArrowCircleFill),
                    horizontalArrangement = Arrangement.SpaceBetween
                ),
                onClick = {},
                Modifier.width(180.dp).height(70.dp)
            )
        }
    }

    @SushiPreview
    @Composable
    fun ZOutlineButtonPreview1() {
        SushiPreview {
            SushiButton(
                SushiButtonProps(
                    type = SushiButtonType.Outline,
                    text = "Tsogy",
                    enabled = false
                ),
                onClick = {}
            )
        }
    }

    @SushiPreview
    @Composable
    fun ZOutlineButtonPreview2() {
        SushiPreview {
            SushiButton(
                SushiButtonProps(
                    type = SushiButtonType.Outline,
                    text = "Tsogy"
                ),
                onClick = {}
            )
        }
    }

    @SushiPreview
    @Composable
    fun ZOutlineButtonPreview3() {
        SushiPreview {
            SushiButton(
                SushiButtonProps(
                    type = SushiButtonType.Outline,
                    text = "Tsogy",
                    subText = "hehe"
                ),
                onClick = {}
            )
        }
    }

    @SushiPreview
    @Composable
    fun ZOutlineButtonPreview4() {
        SushiPreview {
            SushiButton(
                SushiButtonProps(
                    type = SushiButtonType.Outline,
                    text = "Small",
                    size = SushiButtonSize.Small
                ),
                onClick = {}
            )
        }
    }

    @SushiPreview
    @Composable
    fun ZTextButtonPreview1() {
        SushiPreview {
            SushiButton(
                SushiButtonProps(
                    type = SushiButtonType.Text,
                    text = "Tsogy",
                    enabled = false
                ),
                onClick = {}
            )
        }
    }

    @SushiPreview
    @Composable
    fun ZTextButtonPreview2() {
        SushiPreview {
            SushiButton(
                SushiButtonProps(
                    type = SushiButtonType.Text,
                    text = "Tsogy"
                ),
                onClick = {}
            )
        }
    }

    @SushiPreview
    @Composable
    fun ZTextButtonPreview3() {
        SushiPreview {
            SushiButton(
                SushiButtonProps(
                    type = SushiButtonType.Text,
                    text = "Tsogy",
                    subText = "hehe"
                ),
                onClick = {}
            )
        }
    }

    @SushiPreview
    @Composable
    fun ZTextButtonPreview4() {
        SushiPreview {
            SushiButton(
                SushiButtonProps(
                    type = SushiButtonType.Text,
                    text = "Small",
                    size = SushiButtonSize.Small
                ),
                onClick = {}
            )
        }
    }

    @SushiPreview
    @Composable
    fun ZTextButtonPreview5() {
        SushiPreview {
            SushiButton(
                SushiButtonProps(
                    type = SushiButtonType.Text,
                    text = "Tsogy",
                    subText = "hehe",
                    size = SushiButtonSize.Large,
                    verticalAlignment = Alignment.CenterVertically,
                    suffixIcon = SushiIconProps(code = SushiIconCodes.IconNextArrowCircleFill),
                    horizontalArrangement = Arrangement.SpaceBetween
                ),
                onClick = {},
                Modifier.width(180.dp).height(70.dp)
            )
        }
    }
}