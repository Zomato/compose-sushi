@file:SuppressLint("ComposePreviewPublic")

package com.zomato.sushi.compose.atoms.text

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.zomato.sushi.compose.atoms.color.ColorName
import com.zomato.sushi.compose.atoms.color.ColorVariation
import com.zomato.sushi.compose.atoms.color.SushiColorData
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview

class SushiTextTest {

    @Composable
    @SushiPreview
    fun SushiTextPreview1() {
        SushiPreview {
            Column {
                SushiText(
                    props = SushiTextProps(
                        text = "ladyfinger",
                        prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                        suffixIcon = SushiIconProps(code = SushiIconCodes.IconContactlessDining, color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)),
                        color = SushiColorData(ColorName.Red, ColorVariation.Variation500),
                        type = SushiTextType.Regular300,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        textDecoration = SushiTextDecoration.Underline()
                    ),
                    Modifier.fillMaxWidth()
                )
                SushiText(
                    props = SushiTextProps(
                        text = "ladyfinger",
                        prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                        suffixIcon = SushiIconProps(code = SushiIconCodes.IconContactlessDining, color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)),
                        color = SushiTheme.colors.text.success,
                        type = SushiTextType.Regular400,
                        textDecoration = SushiTextDecoration.Underline()
                    )
                )
                SushiText(
                    props = SushiTextProps(
                        text = "normal_italic_<bold-100|{red-500|smallBoldRed}smallBold>normal**bold**normal",
                        prefixIcon = SushiIconProps(code = SushiIconCodes.IconMoon),
                        suffixIcon = SushiIconProps(code = SushiIconCodes.IconContactlessDining, color = SushiColorData(ColorName.Blue, ColorVariation.Variation500)),
                        color = SushiTheme.colors.text.success,
                        maxLines = 2,
                        letterSpacing = 4.sp,
                        type = SushiTextType.Regular900,
                        textDecoration = SushiTextDecoration.Underline()
                    )
                )
            }
        }
    }
}