@file:SuppressLint("ComposePreviewPublic")

package com.zomato.sushi.compose.atoms.radio

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

class SushiRadioButtonTest {

    @SushiPreview
    @Composable
    private fun SushiRadioButtonPreview1() {
        SushiPreview {
            Column {
                var firstSelected by remember {
                    mutableStateOf(false)
                }
                SushiRadioButton(
                    SushiRadioButtonProps(
                        id = "first_radio_button",
                        selected = firstSelected == true,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends")
                    ),
                    onClick = {
                        firstSelected = true
                    }
                )
                SushiRadioButton(
                    SushiRadioButtonProps(
                        id = "second_radio_button",
                        selected = firstSelected == false,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends")
                    ),
                    onClick = {
                        firstSelected = false
                    }
                )
            }
        }
    }

    @SushiPreview
    @Composable
    private fun SushiRadioButtonPreview2() {
        SushiPreview {
            Column {
                var firstSelected by remember {
                    mutableStateOf(false)
                }
                SushiRadioButton(
                    SushiRadioButtonProps(
                        id = "first_radio_button",
                        selected = firstSelected == true,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                        verticalAlignment = Alignment.Top
                    ),
                    onClick = {
                        firstSelected = true
                    }
                )
                SushiRadioButton(
                    SushiRadioButtonProps(
                        id = "second_radio_button",
                        selected = firstSelected == false,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                        verticalAlignment = Alignment.Top,
                        enabled = false
                    ),
                    onClick = {
                        firstSelected = false
                    }
                )
            }
        }
    }

    @SushiPreview
    @Composable
    private fun SushiRadioButtonPreview3() {
        SushiPreview {
            Column(horizontalAlignment = Alignment.End) {
                var firstSelected by remember {
                    mutableStateOf(false)
                }
                SushiRadioButton(
                    SushiRadioButtonProps(
                        id = "first_radio_button",
                        selected = firstSelected == true,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                        direction = RadioButtonDirection.End
                    ),
                    onClick = {
                        firstSelected = true
                    }
                )
                SushiRadioButton(
                    SushiRadioButtonProps(
                        id = "second_radio_button",
                        selected = firstSelected == false,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends"),
                        direction = RadioButtonDirection.End
                    ),
                    onClick = {
                        firstSelected = false
                    }
                )
            }
        }
    }

    @SushiPreview
    @Composable
    private fun SushiRadioButtonPreview4() {
        SushiPreview {
            Column(horizontalAlignment = Alignment.End) {
                var firstSelected by remember {
                    mutableStateOf(false)
                }
                SushiRadioButton(
                    SushiRadioButtonProps(
                        id = "first_radio_button",
                        selected = firstSelected == true,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                        verticalAlignment = Alignment.Top,
                        direction = RadioButtonDirection.End
                    ),
                    onClick = {
                        firstSelected = true
                    }
                )
                SushiRadioButton(
                    SushiRadioButtonProps(
                        id = "second_radio_button",
                        selected = firstSelected == false,
                        text = SushiTextProps(text = "I recommend this restaurant to my friends\nI recommend this restaurant to my friends\nI recommend this restaurant to my friends"),
                        subText = SushiTextProps(text = "SubText"),
                        verticalAlignment = Alignment.Top,
                        enabled = false,
                        direction = RadioButtonDirection.End
                    ),
                    onClick = {
                        firstSelected = false
                    },
                    Modifier.fillMaxWidth()
                )
            }
        }
    }
}