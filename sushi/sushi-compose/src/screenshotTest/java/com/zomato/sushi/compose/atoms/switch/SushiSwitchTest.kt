@file:SuppressLint("ComposePreviewPublic")

package com.zomato.sushi.compose.atoms.switch

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

class SushiSwitchTest {

    @SushiPreview
    @Composable
    private fun SushiSwitchPreview1() {
        SushiPreview {
            Column {
                var firstSelected by remember {
                    mutableStateOf(false)
                }
                SushiSwitch(
                    SushiSwitchProps(
                        id = "first_switch",
                        isChecked = firstSelected == true,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends")
                    ),
                    onCheckedChange = {
                        firstSelected = true
                    }
                )
                SushiSwitch(
                    SushiSwitchProps(
                        id = "second_switch",
                        isChecked = firstSelected == false,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends")
                    ),
                    onCheckedChange = {
                        firstSelected = false
                    }
                )
            }
        }
    }

    @SushiPreview
    @Composable
    private fun SushiSwitchPreview2() {
        SushiPreview {
            Column {
                var firstSelected by remember {
                    mutableStateOf(false)
                }
                SushiSwitch(
                    SushiSwitchProps(
                        id = "first_switch",
                        isChecked = firstSelected == true,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends")
                    ),
                    onCheckedChange = {
                        firstSelected = true
                    }
                )
                SushiSwitch(
                    SushiSwitchProps(
                        id = "second_switch",
                        isChecked = firstSelected == false,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                        isEnabled = false
                    ),
                    onCheckedChange = {
                        firstSelected = false
                    }
                )
            }
        }
    }

    @SushiPreview
    @Composable
    private fun SushiSwitchPreview3() {
        SushiPreview {
            Column(horizontalAlignment = Alignment.End) {
                var firstSelected by remember {
                    mutableStateOf(false)
                }
                SushiSwitch(
                    SushiSwitchProps(
                        id = "first_switch",
                        isChecked = firstSelected == true,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                        direction = SwitchDirection.End
                    ),
                    onCheckedChange = {
                        firstSelected = true
                    }
                )
                SushiSwitch(
                    SushiSwitchProps(
                        id = "second_switch",
                        isChecked = firstSelected == false,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                        direction = SwitchDirection.End
                    ),
                    onCheckedChange = {
                        firstSelected = false
                    }
                )
            }
        }
    }

    @SushiPreview
    @Composable
    private fun SushiSwitchPreview4() {
        SushiPreview {
            Column(horizontalAlignment = Alignment.End) {
                var firstSelected by remember {
                    mutableStateOf(false)
                }
                SushiSwitch(
                    SushiSwitchProps(
                        id = "first_switch",
                        isChecked = firstSelected == true,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                        direction = SwitchDirection.End
                    ),
                    onCheckedChange = {
                        firstSelected = true
                    }
                )
                SushiSwitch(
                    SushiSwitchProps(
                        id = "second_switch",
                        isChecked = firstSelected == false,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                        subText = SushiTextProps(text = "SubText"),
                        isEnabled = false,
                        direction = SwitchDirection.End,
                    ),
                    onCheckedChange = {
                        firstSelected = false
                    },
                    Modifier.fillMaxWidth()
                )
            }
        }
    }
}