package com.zomato.sushi.compose.atoms.tag

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.icon.asIconSizeSpec
import com.zomato.sushi.compose.atoms.internal.Base
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.asTextTypeSpec
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.utils.atomClickable
import com.zomato.sushi.compose.utils.dashedBorder
import com.zomato.sushi.compose.utils.ifNonNull
import com.zomato.sushi.compose.utils.ifTrue
import com.zomato.sushi.compose.utils.takeIfSpecified

/**
 * Created by Kashish on 13,January,2025
 * Zomato, Gurgaon, India.
 */
@ExperimentalSushiApi
@Composable
fun SushiTag(
    props: SushiTagProps,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Base(
        modifier
            .width(IntrinsicSize.Max)
            .height(IntrinsicSize.Max)
    ) {
        SushiTagImpl(
            props = props,
            modifier = Modifier.fillMaxSize(),
            onClick = onClick
        )
    }
}

@ExperimentalSushiApi
@Composable
private fun SushiTagImpl(
    props: SushiTagProps,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {

    val surfaceShape = props.shape ?: props.getTagShapeForType()
    Surface(
        modifier = modifier
            .ifNonNull(onClick) {
                this.clickable(
                    onClick = it,
                    indication = ripple(),
                    interactionSource = remember { MutableInteractionSource() }
                )
            }
            .ifTrue(dashedBorderNeededForTag(props.type)) {
                this.dashedBorder(
                    color = props.borderColor?.value ?: SushiTheme.colors.border.accentBlueIntense.value,
                    strokeWidth = SushiTheme.dimens.spacing.nano,
                    cornerRadiusDp = props.getTagCornerRadiusForType()
                )
            },
        color = props.color?.value ?: SushiTheme.colors.theme.accentColor.value,
        shape = surfaceShape,
        border = props.getBorderForType()
    ) {

        val textType = props.getTagTextType()
        val textColor = props.fontColor ?: SushiTheme.colors.theme.accentColor

        val tagPadding = props.getTagPaddingForSize()

        val defaultIconSize: TextUnit = props.getTagIconSize()
        val iconPadding: Dp = props.iconSpacing ?: tagPadding.calculateLeftPadding(LayoutDirection.Ltr)
        val prefixIcon = props.prefixIcon?.copy(
            size = props.prefixIcon.size ?: defaultIconSize.asIconSizeSpec(),
            color = props.prefixIcon.color.takeIfSpecified() ?: textColor
        )
        val suffixIcon = props.suffixIcon?.copy(
            size = props.suffixIcon.size ?: defaultIconSize.asIconSizeSpec(),
            color = props.suffixIcon.color.takeIfSpecified() ?: textColor
        )

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (prefixIcon != null) {
                SushiIcon(
                    props = prefixIcon,
                    Modifier.padding(start = iconPadding)
                )
            }
            SushiText(
                modifier = Modifier.weight(1f).padding(tagPadding),
                props = SushiTextProps(
                    type = textType.asTextTypeSpec(),
                    text = props.text.orEmpty(),
                    color = textColor,
                    isMarkDownEnabled = props.markdown,
                    horizontalArrangement = Arrangement.Center
                )
            )
            if (suffixIcon != null) {
                SushiIcon(
                    props = suffixIcon,
                    Modifier.padding(end = iconPadding)
                )
            }
        }
    }
}

@ExperimentalSushiApi
@Preview(name = "Large capsule")
@Composable
private fun SushiTagPreview1() {
    SushiTag(
        modifier = Modifier.padding(SushiTheme.dimens.spacing.micro),
        props = SushiTagProps(
            text = "recommended",
            size = SushiTagSize.Large,
            type = SushiTagType.Capsule,
            color = SushiTheme.colors.green.v400,
            borderColor = SushiTheme.colors.black
        )
    )
}

@ExperimentalSushiApi
@Preview(name = "Small capsule outline")
@Composable
private fun SushiTagPreview2() {
    SushiTag(
        modifier = Modifier.padding(SushiTheme.dimens.spacing.micro),
        props = SushiTagProps(
            text = "recommended",
            size = SushiTagSize.Small,
            type = SushiTagType.CapsuleOutline,
            color = SushiTheme.colors.green.v400,
            borderColor = SushiTheme.colors.black
        )
    )
}

@ExperimentalSushiApi
@Preview(name = "Large capsule dashed")
@Composable
private fun SushiTagPreview3() {
    SushiTag(
        modifier = Modifier.padding(SushiTheme.dimens.spacing.micro),
        props = SushiTagProps(
            text = "recommended",
            size = SushiTagSize.Large,
            type = SushiTagType.CapsuleDashed,
            color = SushiTheme.colors.green.v400,
            borderColor = SushiTheme.colors.black,
            suffixIcon = SushiIconProps(code = "edae"),
        )
    )
}

@ExperimentalSushiApi
@Preview(name = "Large Rounded outline")
@Composable
private fun SushiTagPreview4() {
    SushiTag(
        modifier = Modifier.padding(SushiTheme.dimens.spacing.micro),
        props = SushiTagProps(
            text = "recommended",
            size = SushiTagSize.Large,
            type = SushiTagType.RoundedOutline,
            color = SushiTheme.colors.blue.v300,
            borderColor = SushiTheme.colors.black,
            prefixIcon = SushiIconProps(code = "edae"),
            suffixIcon = SushiIconProps(code = "edae"),
        )
    )
}

@ExperimentalSushiApi
@Preview(name = "Large Rounded dashed")
@Composable
private fun SushiTagPreview5() {
    SushiTag(
        modifier = Modifier.padding(SushiTheme.dimens.spacing.micro),
        props = SushiTagProps(
            text = "recommended",
            size = SushiTagSize.Large,
            type = SushiTagType.RoundedDashed,
            color = SushiTheme.colors.blue.v300,
            borderColor = SushiTheme.colors.black,
            prefixIcon = SushiIconProps(code = "edae"),
            suffixIcon = SushiIconProps(code = "edae"),
        )
    )
}

@ExperimentalSushiApi
@Preview(name = "Medium Rounded")
@Composable
private fun SushiTagPreview6() {
    SushiTag(
        modifier = Modifier.padding(SushiTheme.dimens.spacing.micro),
        props = SushiTagProps(
            text = "recommended",
            size = SushiTagSize.Medium,
            type = SushiTagType.Rounded,
            color = SushiTheme.colors.blue.v300,
            borderColor = SushiTheme.colors.black,
            prefixIcon = SushiIconProps(code = "edae"),
        )
    )
}

@ExperimentalSushiApi
@Preview(name = "Nano capsule dashed")
@Composable
private fun SushiTagPreview7() {
    SushiTag(
        modifier = Modifier.padding(SushiTheme.dimens.spacing.micro),
        props = SushiTagProps(
            text = "recommended",
            size = SushiTagSize.Nano,
            type = SushiTagType.CapsuleDashed,
            fontColor = SushiTheme.colors.white,
            color = SushiTheme.colors.green.v900,
            borderColor = SushiTheme.colors.yellow.v700,
            suffixIcon = SushiIconProps(code = "edae"),
        )
    )
}

@ExperimentalSushiApi
@Preview(name = "Tiny capsule dashed")
@Composable
private fun SushiTagPreview8() {
    SushiTag(
        modifier = Modifier.padding(SushiTheme.dimens.spacing.micro),
        props = SushiTagProps(
            text = "recommended",
            size = SushiTagSize.Tiny,
            type = SushiTagType.CapsuleDashed,
            fontColor = SushiTheme.colors.white,
            color = SushiTheme.colors.green.v900,
            borderColor = SushiTheme.colors.yellow.v700,
            suffixIcon = SushiIconProps(code = "edae"),
        )
    )
}