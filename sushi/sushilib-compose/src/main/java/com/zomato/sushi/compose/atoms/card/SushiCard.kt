package com.zomato.sushi.compose.atoms.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zomato.sushi.compose.atoms.color.ColorSpec
import com.zomato.sushi.compose.atoms.text.SushiText
import com.zomato.sushi.compose.atoms.text.SushiTextProps
import com.zomato.sushi.compose.atoms.text.SushiTextType
import com.zomato.sushi.compose.foundation.SushiTheme
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.shapes.ticket.TicketShape
import com.zomato.sushi.compose.utils.BorderConfig
import com.zomato.sushi.compose.utils.DashedBorderConfig
import com.zomato.sushi.compose.utils.border
import com.zomato.sushi.compose.utils.toPx

/**
 * A customizable card component for the Sushi design system.
 *
 * SushiCard provides a surface for displaying related content in a contained unit. It supports:
 * - Custom shapes including rounded corners and ticket shapes
 * - Solid and dashed borders
 * - Elevation control
 * - Custom background colors
 * - Content composition through ColumnScope
 *
 * @param modifier The modifier to be applied to the card
 * @param borderConfig Optional configuration for custom borders (e.g., dashed borders)
 * @param shape The shape of the card (defaults to rounded corners)
 * @param containerColor The background color of the card
 * @param border Optional border stroke for the card (for solid borders)
 * @param elevation The elevation of the card which determines its shadow
 * @param content The composable content to be displayed inside the card
 *
 * @author Nitin Kumar
 */
@Composable
fun SushiCard(
    modifier: Modifier = Modifier,
    borderConfig: BorderConfig? = null,
    shape: Shape = RoundedCornerShape(SushiTheme.dimens.spacing.base),
    containerColor: ColorSpec = SushiTheme.colors.surface.primary,
    border: BorderStroke? = null,
    elevation: Dp = SushiTheme.dimens.spacing.femto,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier
            .testTag("SushiCard")
            .border(borderConfig),
        shape = shape,
        colors = CardDefaults.cardColors(containerColor = containerColor.value),
        elevation = CardDefaults.cardElevation(defaultElevation = elevation),
        border = border,
        content = content
    )
}

@SushiPreview
@Composable
private fun FilledCardPreview() {
    SushiPreview {
        Box(modifier = Modifier.size(300.dp, 300.dp)) {
            SushiCard(
                shape = RoundedCornerShape(SushiTheme.dimens.spacing.base),
                containerColor = SushiTheme.colors.green.v200,
                modifier = Modifier
                    .size(width = 240.dp, height = 240.dp)
                    .align(Alignment.Center)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                ) {
                    SushiText(
                        props = SushiTextProps(
                            text = "Filled Card",
                            color = SushiTheme.colors.red.v500,
                            type = SushiTextType.Medium400
                        )
                    )
                }
            }
        }
    }
}

@SushiPreview
@Composable
private fun OutlinedElevatedCardPreview() {
    SushiPreview {
        Box(modifier = Modifier.size(300.dp, 300.dp)) {
            SushiCard(
                shape = RoundedCornerShape(SushiTheme.dimens.spacing.base),
                border = BorderStroke(SushiTheme.dimens.spacing.pico, Color.Red),
                elevation = SushiTheme.dimens.spacing.micro,
                modifier = Modifier
                    .size(width = 240.dp, height = 240.dp)
                    .align(Alignment.Center)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                ) {
                    SushiText(
                        props = SushiTextProps(
                            text = "Outlined Elevated Card",
                            color = SushiTheme.colors.red.v500,
                            type = SushiTextType.Medium400
                        )
                    )
                }
            }
        }
    }
}

@SushiPreview
@Composable
private fun FilledElevatedCardPreview() {
    SushiPreview {
        Box(modifier = Modifier.size(300.dp, 300.dp)) {
            SushiCard(
                shape = RoundedCornerShape(SushiTheme.dimens.spacing.base),
                elevation = SushiTheme.dimens.spacing.macro,
                modifier = Modifier
                    .size(width = 240.dp, height = 240.dp)
                    .align(Alignment.Center)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                ) {
                    SushiText(
                        props = SushiTextProps(
                            text = "Filled Elevated Card",
                            color = SushiTheme.colors.red.v500,
                            type = SushiTextType.Medium400
                        )
                    )
                }
            }
        }
    }
}

@SushiPreview
@Composable
private fun DashedBorderCardPreview() {
    SushiPreview {
        Box(modifier = Modifier.size(300.dp, 300.dp)) {
            SushiCard(
                shape = TicketShape(24.dp.toPx(), 0.6f),
                borderConfig = DashedBorderConfig(
                    color = Color.Red,
                    width = 2.dp,
                    dashWidth = 5.dp,
                    dashGap = 6.dp,
                    shape = TicketShape(24.dp.toPx(), 0.6f) // Same shape as card
                ),
                containerColor = SushiTheme.colors.green.v200,
                modifier = Modifier
                    .size(240.dp)
                    .align(Alignment.Center)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                ) {
                    SushiText(
                        props = SushiTextProps(
                            text = "Dashed Border Card",
                            color = SushiTheme.colors.red.v500,
                            type = SushiTextType.Medium400
                        )
                    )
                }
            }
        }
    }
}

@SushiPreview
@Composable
private fun TicketCardPreview() {
    SushiPreview {
        Box(modifier = Modifier.size(300.dp, 300.dp)) {
            SushiCard(
                containerColor = SushiTheme.colors.green.v200,
                shape = TicketShape(16.dp.toPx(), 0.7f),
                elevation = SushiTheme.dimens.spacing.micro,
                modifier = Modifier
                    .size(width = 240.dp, height = 240.dp)
                    .align(Alignment.Center)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                ) {
                    SushiText(
                        props = SushiTextProps(
                            text = "Ticket Card",
                            color = SushiTheme.colors.red.v500,
                            type = SushiTextType.Medium400
                        )
                    )
                }
            }
        }
    }
}
