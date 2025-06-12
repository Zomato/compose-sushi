package com.zomato.sushi.website.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.website.WebText
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun HeaderOption(
    text: String,
    prefixImageRes: DrawableResource,
    modifier: Modifier = Modifier
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painterResource(prefixImageRes), null, Modifier.size(24.dp))
        WebText(
            SushiTextProps(
                text = text,
                type = SushiTextType.Medium400
            ),
            Modifier.padding(start = SushiTheme.dimens.spacing.macro)
        )
    }
}
