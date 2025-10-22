package com.zomato.sushi.compose.atoms.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.icon.SushiIcon
import com.zomato.sushi.compose.atoms.icon.asIconSizeSpec
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextDecoration
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.asTextTypeSpec
import com.zomato.sushi.compose.utils.takeIfSpecified

@Composable
internal fun RowScope.SushiButtonContentImpl(
    props: SushiButtonProps,
    isDisabled: Boolean,
    isTapped: Boolean,
    fontColorDisabled: ColorSpec,
    fontColorPressed: ColorSpec,
    fontColor: ColorSpec,
    modifier: Modifier = Modifier
) {

    val appliedFontColor = when {
        isDisabled -> fontColorDisabled
        isTapped -> fontColorPressed
        else -> fontColor
    }

    val textType: TextStyle = props.fontType?.typeStyle ?: with(SushiButtonDefaults) { getButtonTextType(props.sizeOrDefault) }
    val defaultIconSize: TextUnit = props.fontType?.typeStyle?.fontSize ?: with(SushiButtonDefaults) { getButtonIconSize(props.sizeOrDefault) }
    val iconPadding: Dp = props.iconSpacing ?: with(SushiButtonDefaults) { getButtonIconPadding(props.sizeOrDefault) }

    val prefixIcon = props.prefixIcon?.copy(
        size = props.prefixIcon.size ?: defaultIconSize.asIconSizeSpec(),
        color = props.prefixIcon.color.takeIfSpecified() ?: appliedFontColor
    )

    val suffixIcon = props.suffixIcon?.copy(
        size = props.suffixIcon.size ?: defaultIconSize.asIconSizeSpec(),
        color = props.suffixIcon.color.takeIfSpecified() ?: appliedFontColor
    )

    val horizontalArrangement = with(SushiButtonDefaults) { props.horizontalArrangementOrDefault }
    val verticalAlignment = with(SushiButtonDefaults) { props.verticalAlignmentOrDefault }

    val isUnderlined = props.type == SushiButtonType.Underline
    val textDecoration = if (isUnderlined) SushiTextDecoration.Underline() else null

    Row(
        modifier,
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment
    ) {
        if (prefixIcon != null) {
            SushiIcon(
                props = prefixIcon,
                Modifier.padding(end = iconPadding)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            SushiText(
                SushiTextProps(
                    text = props.text,
                    color = appliedFontColor,
                    type = textType.asTextTypeSpec(),
                    markdown = props.markdown,
                    textDecoration = textDecoration
                )
            )
            if (!props.subText.isNullOrEmpty()) {
                SushiText(
                    SushiTextProps(
                        text = props.subText,
                        color = appliedFontColor,
                        type = with(SushiButtonDefaults) { getSubtextTextStyle(textType).asTextTypeSpec() },
                        textDecoration = textDecoration
                    )
                )
            }
        }
        if (suffixIcon != null) {
            SushiIcon(
                props = suffixIcon,
                Modifier.padding(start = iconPadding)
            )
        }
    }
}