package com.zomato.sushi.compose.atoms.icon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.asColorSpec
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextDecoration
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.textfield.SushiTextField
import com.zomato.sushi.compose.atoms.textfield.SushiTextFieldDefaults
import com.zomato.sushi.compose.atoms.textfield.SushiTextFieldProps
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.modifiers.scrollbar.drawVerticalScrollbar

@Composable
internal fun SushiIconCodesPreview(
    icons: List<Pair<String, SushiIconCode>>,
    modifier: Modifier = Modifier
) {
    SushiPreview {
        Column(
            modifier.background(Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val textFieldValue = remember {
                mutableStateOf(TextFieldValue(""))
            }
            SushiTextField(
                SushiTextFieldProps(
                    textFieldValue = textFieldValue.value,
                    colors = SushiTextFieldDefaults.outlinedColors(

                    ),
                    placeholder = SushiTextProps("Enter Icon Name/Code to Search")
                ),
                onTextFieldValueChange = {
                    textFieldValue.value = it
                },
                Modifier
                    .padding(
                        top = 10.dp,
                        start = 10.dp,
                        end = 10.dp
                    )
                    .fillMaxWidth()
            )
            val filteredList = remember(textFieldValue.value.text, icons) {
                val searchText = textFieldValue.value.text
                icons.filter {
                    searchText.isBlank()
                            || it.first.contains(searchText, ignoreCase = true)
                            || it.second.value.contains(searchText, ignoreCase = true)
                }
            }
            val state = rememberLazyGridState()
            LazyVerticalGrid(
                columns = GridCells.Fixed(6),
                Modifier
                    .drawVerticalScrollbar(state, 6, autoHide = false)
                    .fillMaxSize(),
                contentPadding = PaddingValues(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(filteredList) { iconEntry ->
                    Box(
                        Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .height(90.dp)
                    ) {
                        Column(
                            Modifier
                                .align(Alignment.Center)
                                .padding(4.dp)
                                .height(IntrinsicSize.Max),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            SushiIcon(
                                SushiIconProps(
                                    code = iconEntry.second,
                                    size = SushiIconSize.Size600
                                )
                            )
                            SushiText(
                                SushiTextProps(
                                    text = iconEntry.first,
                                    textAlign = TextAlign.Center,
                                ),
                                Modifier.padding(top = 10.dp)
                            )
                            SushiText(
                                SushiTextProps(
                                    text = iconEntry.second.value,
                                    textAlign = TextAlign.Center,
                                    color = Color(0xE1494949).asColorSpec(),
                                    textDecoration = SushiTextDecoration.Underline()
                                ),
                                Modifier.padding(top = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}