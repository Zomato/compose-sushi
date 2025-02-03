@file:SuppressLint("ComposePreviewPublic")

package com.zomato.sushi.compose.atoms.checkbox

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.internal.SushiPreview

class SushiCheckBoxTest {

    @SushiPreview
    @Composable
    fun SushiCheckBoxPreview1() {
        SushiPreview {
            Column {
                var checked by remember {
                    mutableStateOf(false)
                }
                SushiCheckBox(
                    SushiCheckBoxProps(
                        checked = checked,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                        size = SushiCheckboxSize.Default
                    ),
                    onCheckedChange = {
                        checked = it
                    }
                )
                SushiCheckBox(
                    SushiCheckBoxProps(
                        checked = checked,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                        size = SushiCheckboxSize.Mini
                    ),
                    onCheckedChange = {
                        checked = it
                    }
                )
            }
        }
    }

    @SushiPreview
    @Composable
    fun SushiCheckBoxPreview2() {
        SushiPreview {
            Column {
                var checked by remember {
                    mutableStateOf(false)
                }
                SushiCheckBox(
                    SushiCheckBoxProps(
                        checked = checked,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                        size = SushiCheckboxSize.Default,
                        verticalAlignment = Alignment.Bottom
                    ),
                    onCheckedChange = {
                        checked = it
                    }
                )
                SushiCheckBox(
                    SushiCheckBoxProps(
                        checked = checked,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                        size = SushiCheckboxSize.Mini,
                        verticalAlignment = Alignment.Bottom,
                        enabled = false
                    ),
                    onCheckedChange = {
                        checked = it
                    }
                )
            }
        }
    }

    @SushiPreview
    @Composable
    fun SushiCheckBoxPreview3() {
        SushiPreview {
            Column(horizontalAlignment = Alignment.End) {
                var checked by remember {
                    mutableStateOf(false)
                }
                SushiCheckBox(
                    SushiCheckBoxProps(
                        checked = checked,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                        size = SushiCheckboxSize.Default,
                        direction = CheckBoxDirection.End
                    ),
                    onCheckedChange = {
                        checked = it
                    }
                )
                SushiCheckBox(
                    SushiCheckBoxProps(
                        checked = checked,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                        size = SushiCheckboxSize.Mini,
                        direction = CheckBoxDirection.End
                    ),
                    onCheckedChange = {
                        checked = it
                    }
                )
            }
        }
    }

    @SushiPreview
    @Composable
    fun SushiCheckBoxPreview4() {
        SushiPreview {
            Column(horizontalAlignment = Alignment.End) {
                var checked by remember {
                    mutableStateOf(false)
                }
                SushiCheckBox(
                    SushiCheckBoxProps(
                        checked = checked,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                        size = SushiCheckboxSize.Default,
                        verticalAlignment = Alignment.Bottom,
                        direction = CheckBoxDirection.End
                    ),
                    onCheckedChange = {
                        checked = it
                    },
                    Modifier.fillMaxWidth()
                )
                SushiCheckBox(
                    SushiCheckBoxProps(
                        checked = checked,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                        size = SushiCheckboxSize.Mini,
                        verticalAlignment = Alignment.Bottom,
                        enabled = false,
                        direction = CheckBoxDirection.End
                    ),
                    onCheckedChange = {
                        checked = it
                    }
                )
            }
        }
    }
}