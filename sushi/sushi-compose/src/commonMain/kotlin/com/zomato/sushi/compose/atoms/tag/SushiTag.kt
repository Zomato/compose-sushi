package com.zomato.sushi.compose.atoms.tag

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.SushiIconCodes
import com.zomato.sushi.compose.atoms.icon.SushiIconProps
import com.zomato.sushi.compose.atoms.icon.asIconSizeSpec
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.atoms.tag.SushiTagDefaults.typeOrDefault
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.asTextTypeSpec
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.modifiers.dashedBorder
import com.zomato.sushi.compose.modifiers.ifNonNull
import com.zomato.sushi.compose.modifiers.ifTrue
import com.zomato.sushi.compose.utils.takeIfSpecified
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * A customizable tag component for the Sushi design system.
 *
 * SushiTag is a small, compact component typically used to display categories,
 * attributes, or status information. It supports various visual styles (rounded,
 * capsule, outlined, dashed), sizes, and optional prefix/suffix icons.
 * 
 * Tags can be interactive (clickable) or static, and can contain custom content
 * or use the standard text and icon layout.
 *
 * @param props The properties to configure the tag's appearance and content
 * @param modifier The modifier to be applied to the component
 * @param content Optional custom content to replace the default tag layout
 * @param onClick Optional callback for handling click events on the tag
 *
 * Created by Kashish on 13,January,2025
 * Zomato, Gurgaon, India.
 */
@Composable
fun SushiTag(
    props: SushiTagProps,
    modifier: Modifier = Modifier,
    content: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    SushiComponentBase(
        modifier
            .width(IntrinsicSize.Max)
            .height(IntrinsicSize.Max)
    ) {
        SushiTagImpl(
            props = props,
            modifier = Modifier.fillMaxSize(),
            content = content,
            onClick = onClick
        )
    }
}

@Composable
private fun SushiTagImpl(
    props: SushiTagProps,
    modifier: Modifier = Modifier,
    content: @Composable (() -> Unit)? = null,
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
            .ifTrue(dashedBorderNeededForTag(props.typeOrDefault)) {
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
        if (content != null) content()
        else SushiTagDefaultContent(props = props)
    }
}

@Composable
private fun SushiTagDefaultContent(
    props: SushiTagProps,
    modifier: Modifier = Modifier
) {
    val textType = props.getTagTextType()
    val textColor = props.fontColor ?: SushiTheme.colors.button.primaryLabel

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
        modifier = modifier.fillMaxSize(),
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
                markdown = props.markdown,
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

// Large capsule
@SushiPreview
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

// Small capsule outline
@SushiPreview
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

// Large capsule dashed
@SushiPreview
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
            suffixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
        )
    )
}

// Large Rounded outline
@SushiPreview
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
            prefixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
            suffixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
        )
    )
}

// Large Rounded dashed
@SushiPreview
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
            prefixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
            suffixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
        )
    )
}

// Medium Rounded
@SushiPreview
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
            prefixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
        )
    )
}

// Nano capsule dashed
@SushiPreview
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
            suffixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
        )
    )
}

// Tiny capsule dashed
@SushiPreview
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
            suffixIcon = SushiIconProps(code = SushiIconCodes.IconScooterSharp),
        )
    )
}