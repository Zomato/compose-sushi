@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.textfield

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zomato.sushi.compose.atoms.internal.Base
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.internal.Preview
import com.zomato.sushi.compose.internal.SushiPreview

private object Defaults {

}

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
@Composable
fun SushiTextField(
    props: SushiTextFieldProps,
    modifier: Modifier = Modifier
) {
    Base(modifier) {
        SushiTextFieldImpl(props)
    }
}

@Composable
private fun SushiTextFieldImpl(
    props: SushiTextFieldProps,
    modifier: Modifier = Modifier
) {

}

@SushiPreview
@Composable
private fun SushiTextFieldPreview1() {
    Preview {

    }
}