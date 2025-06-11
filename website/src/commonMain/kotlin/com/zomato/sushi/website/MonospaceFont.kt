package com.zomato.sushi.website

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import composesushi.website.generated.resources.Res
import composesushi.website.generated.resources.roboto_mono_bold
import composesushi.website.generated.resources.roboto_mono_bolditalic
import composesushi.website.generated.resources.roboto_mono_extralight
import composesushi.website.generated.resources.roboto_mono_extralightitalic
import composesushi.website.generated.resources.roboto_mono_italic
import composesushi.website.generated.resources.roboto_mono_light
import composesushi.website.generated.resources.roboto_mono_lightitalic
import composesushi.website.generated.resources.roboto_mono_medium
import composesushi.website.generated.resources.roboto_mono_mediumitalic
import composesushi.website.generated.resources.roboto_mono_regular
import composesushi.website.generated.resources.roboto_mono_semibold
import composesushi.website.generated.resources.roboto_mono_semibolditalic
import composesushi.website.generated.resources.roboto_mono_thin
import composesushi.website.generated.resources.roboto_mono_thinitalic
import org.jetbrains.compose.resources.Font

val MonoSpaceFontFamily
    @Composable get() = FontFamily(
        Font(Res.font.roboto_mono_thin, FontWeight(50)),
        Font(Res.font.roboto_mono_thinitalic, FontWeight(50), FontStyle.Italic),
        Font(Res.font.roboto_mono_thin, FontWeight.W100),
        Font(Res.font.roboto_mono_thinitalic, FontWeight.W100, FontStyle.Italic),
        Font(Res.font.roboto_mono_extralight, FontWeight.W200),
        Font(Res.font.roboto_mono_extralightitalic, FontWeight.W200, FontStyle.Italic),
        Font(Res.font.roboto_mono_light, FontWeight.W300),
        Font(Res.font.roboto_mono_lightitalic, FontWeight.W300, FontStyle.Italic),
        Font(Res.font.roboto_mono_regular, FontWeight.W400),
        Font(Res.font.roboto_mono_italic, FontWeight.W400, FontStyle.Italic),
        Font(Res.font.roboto_mono_regular, FontWeight.W500),
        Font(Res.font.roboto_mono_italic, FontWeight.W500, FontStyle.Italic),
        Font(Res.font.roboto_mono_medium, FontWeight.W600),
        Font(Res.font.roboto_mono_mediumitalic, FontWeight.W600, FontStyle.Italic),
        Font(Res.font.roboto_mono_semibold, FontWeight.W700),
        Font(Res.font.roboto_mono_semibolditalic, FontWeight.W700, FontStyle.Italic),
        Font(Res.font.roboto_mono_bold, FontWeight.W800),
        Font(Res.font.roboto_mono_bolditalic, FontWeight.W800, FontStyle.Italic),
        Font(Res.font.roboto_mono_bold, FontWeight.W900),
        Font(Res.font.roboto_mono_bolditalic, FontWeight.W900, FontStyle.Italic),
    )