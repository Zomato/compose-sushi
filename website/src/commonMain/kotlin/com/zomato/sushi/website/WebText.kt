package com.zomato.sushi.website

import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextLayoutResult
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps

@Composable
fun WebText(
    props: SushiTextProps,
    modifier: Modifier = Modifier,
    prefix: (@Composable () -> Unit)? = null,
    suffix: (@Composable () -> Unit)? = null,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (() -> Unit)? = null
) {
    SelectionContainer(modifier) {
        SushiText(
            props = props,
            prefix = prefix,
            suffix = suffix,
            onTextLayout = onTextLayout,
            onClick = onClick,
        )
    }
}