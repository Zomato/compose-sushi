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
import composesushi.website.generated.resources.Res
import composesushi.website.generated.resources.sushi_icon
import org.jetbrains.compose.resources.painterResource

@Composable
fun HeaderLogo(
    modifier: Modifier = Modifier
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(Res.drawable.sushi_icon),
            null,
            Modifier.size(27.dp)
        )
        Row(
            Modifier.padding(start = SushiTheme.dimens.spacing.mini),
            verticalAlignment = Alignment.Bottom,
        ) {
            WebText(
                SushiTextProps(
                    text = "<bold-900|sushi> <regular-300|{grey-700|Compose UI Kit}>",
                    type = SushiTextType.Bold900
                )
            )
        }
    }
}