package com.zomato.sushi.compose.components.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.zomato.sushi.compose.R
import com.zomato.sushi.compose.atoms.button.SushiButton
import com.zomato.sushi.compose.atoms.button.SushiButtonProps
import com.zomato.sushi.compose.atoms.button.SushiButtonType
import com.zomato.sushi.compose.atoms.image.SushiImage
import com.zomato.sushi.compose.atoms.image.SushiImageProps
import com.zomato.sushi.compose.atoms.internal.SushiComponentBase
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview

/**
 * Created by Piyush Maheswari on 07/01/25
 * Zomato, Gurgaon, India.
 **/
@Composable
fun SushiAlertDialog(
    props: SushiAlertDialogProps?,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    onPositiveButtonClick: (() -> Unit)? = null,
    onNegativeButtonClick: (() -> Unit)? = null,
    onNeutralButtonClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    if (props != null) {
        SushiComponentBase(
            modifier
                .testTag("SushiAlertDialog")
                .height(IntrinsicSize.Max)
                .width(IntrinsicSize.Max)
        ) {
            SushiAlertDialogImpl(
                props = props,
                onDismissRequest = onDismissRequest,
                onPositiveButtonClick = onPositiveButtonClick,
                onNegativeButtonClick = onNegativeButtonClick,
                onNeutralButtonClick = onNeutralButtonClick,
                modifier = Modifier.wrapContentHeight(),
                content = content
            )
        }
    }
}

@Composable
fun SushiAlertDialogImpl(
    props: SushiAlertDialogProps,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    onPositiveButtonClick: (() -> Unit)? = null,
    onNegativeButtonClick: (() -> Unit)? = null,
    onNeutralButtonClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            dismissOnBackPress = props.dismissOnBackPress != false,
            dismissOnClickOutside = props.dismissOnClickOutside != false
        )
    ) {
        Box(
            modifier
                .clip(RoundedCornerShape(SushiTheme.dimens.spacing.base))
                .background(SushiTheme.colors.surface.primary.value),
            propagateMinConstraints = true
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (props.image != null
                    || props.title != null
                    || props.subtitle != null
                ) {
                    Spacer(
                        Modifier.height(SushiTheme.dimens.spacing.base)
                    )
                }
                if (props.image != null) {
                    SushiImage(
                        props = props.image,
                        modifier = Modifier
                            .padding(bottom = SushiTheme.dimens.spacing.base)
                    )
                }
                if (props.title != null) {
                    SushiText(
                        props = props.title,
                        Modifier.padding(bottom = SushiTheme.dimens.spacing.base)
                    )
                }
                if (props.subtitle != null) {
                    SushiText(
                        props = props.subtitle,
                        Modifier.padding(bottom = SushiTheme.dimens.spacing.base)
                    )
                }
                content()
                when (props.alignment) {
                    SushiAlertDialogProps.ButtonAlignment.Vertical -> {
                        HorizontalDivider(
                            thickness = SushiTheme.dimens.spacing.pointFive,
                            color = SushiTheme.colors.border.moderate.value,
                            modifier = Modifier.padding(bottom = SushiTheme.dimens.spacing.base)
                        )
                        if (props.positiveButton != null) {
                            SushiButton(
                                props = props.positiveButton,
                                onClick = onPositiveButtonClick ?: {},
                                Modifier.padding(bottom = SushiTheme.dimens.spacing.base)
                            )
                        }
                        HorizontalDivider(
                            thickness = SushiTheme.dimens.spacing.pointFive,
                            color = SushiTheme.colors.border.moderate.value,
                            modifier = Modifier.padding(bottom = SushiTheme.dimens.spacing.base)
                        )
                        if (props.negativeButton != null) {
                            SushiButton(
                                props = props.negativeButton,
                                onClick = onNegativeButtonClick ?: {},
                                Modifier.padding(bottom = SushiTheme.dimens.spacing.base)
                            )
                        }
                        HorizontalDivider(
                            thickness = SushiTheme.dimens.spacing.pointFive,
                            color = SushiTheme.colors.border.moderate.value,
                            modifier = Modifier.padding(bottom = SushiTheme.dimens.spacing.base)
                        )
                        if (props.neutralButton != null) {
                            SushiButton(
                                props = props.neutralButton,
                                onClick = onNeutralButtonClick ?: {},
                                Modifier.padding(bottom = SushiTheme.dimens.spacing.base)
                            )
                        }
                        Spacer(Modifier)
                    }
                    SushiAlertDialogProps.ButtonAlignment.Horizontal, null -> {
                        HorizontalDivider(
                            thickness = SushiTheme.dimens.spacing.pointFive,
                            color = SushiTheme.colors.border.moderate.value
                        )
                        Row(
                            Modifier
                                .height(IntrinsicSize.Max)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly

                        ) {
                            if (props.positiveButton != null) {
                                SushiButton(
                                    props = props.positiveButton,
                                    onClick = onPositiveButtonClick ?: {},
                                    modifier = Modifier.padding(vertical = SushiTheme.dimens.spacing.base)
                                )
                            }
                            VerticalDivider(
                                thickness = SushiTheme.dimens.spacing.pointFive,
                                color = SushiTheme.colors.border.moderate.value,
                                modifier = Modifier.fillMaxHeight()
                            )
                            if (props.negativeButton != null) {
                                SushiButton(
                                    props = props.negativeButton,
                                    onClick = onNegativeButtonClick ?: {},
                                    modifier = Modifier.padding(vertical = SushiTheme.dimens.spacing.base)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@SushiPreview
@Composable
private fun SushiAlertDialogPreview1() {
    SushiPreview {
        SushiAlertDialog(
            SushiAlertDialogProps(
                title = SushiTextProps(text = "I recommend this restaurant to my friends"),
                subtitle = SushiTextProps(text = "I recommend this restaurant to my friends"),
                alignment = SushiAlertDialogProps.ButtonAlignment.Vertical,
                positiveButton = SushiButtonProps(
                    text = "Submit",
                    type = SushiButtonType.Text,
                    horizontalArrangement = Arrangement.Center
                ),
                negativeButton = SushiButtonProps(
                    text = "Cancel",
                    type = SushiButtonType.Text,
                    horizontalArrangement = Arrangement.Center
                ),
                neutralButton = SushiButtonProps(
                    text = "Okay",
                    type = SushiButtonType.Text,
                    horizontalArrangement = Arrangement.Center
                )
            ),
            onDismissRequest = {},
            onPositiveButtonClick = { },
            onNegativeButtonClick = { },
            modifier = Modifier,
            onNeutralButtonClick = { },
            content = { }
        )
    }
}

@SushiPreview
@Composable
private fun SushiAlertDialogPreview2() {
    SushiPreview {
        SushiAlertDialog(
            SushiAlertDialogProps(
                image = SushiImageProps(
                    painter = painterResource(R.drawable.sushi_rating_star),
                    bgColor = SushiTheme.colors.red.v500,
                    width = 50.dp,
                    shape = RoundedCornerShape(10.dp),
                    contentDescription = "star",
                    contentScale = ContentScale.Fit,
                    alpha = 0.3f,
                    scaleFactor = 0.6f,
                    colorFilter = ColorFilter.tint(
                        SushiTheme.colors.green.v900.value,
                        blendMode = BlendMode.SrcIn
                    ),
                    aspectRatio = 1f
                ),
                title = SushiTextProps(text = "I recommend this restaurant to my friends"),
                subtitle = SushiTextProps(text = "I recommend this restaurant to my friends"),
                alignment = SushiAlertDialogProps.ButtonAlignment.Horizontal,
                positiveButton = SushiButtonProps(
                    text = "Submit",
                    type = SushiButtonType.Text,
                    horizontalArrangement = Arrangement.Center
                ),
                negativeButton = SushiButtonProps(
                    text = "Cancel",
                    type = SushiButtonType.Text,
                    horizontalArrangement = Arrangement.Center
                )
            ),
            onDismissRequest = {},
            onPositiveButtonClick = { },
            onNegativeButtonClick = { },
            modifier = Modifier,
            onNeutralButtonClick = { },
            content = { }
        )
    }
}

@SushiPreview
@Composable
private fun SushiAlertDialogPreview3() {
    SushiPreview {
        SushiAlertDialog(
            SushiAlertDialogProps(),
            onDismissRequest = {},
            modifier = Modifier,
            content = {
                SushiText(SushiTextProps("Konichiwa"))
            }
        )
    }
}
