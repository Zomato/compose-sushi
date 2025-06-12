package com.zomato.sushi.compose.shapes.ticket

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

/**
 * A custom shape that resembles a ticket with semi-circular cutouts on both sides.
 *
 * This shape creates a ticket-like appearance with half-circle cutouts on both the left
 * and right edges. The position of the cutouts can be adjusted by specifying the offset
 * from the top edge as a percentage of the total height.
 *
 * This shape is useful for creating event tickets, coupons, or other ticket-like UI elements
 * in the Sushi design system.
 *
 * @property circleRadius The radius of the semi-circular cutouts on both sides
 * @property offsetPercentFromTop The position of the cutouts as a percentage (0.0 to 1.0) of the shape's height
 *
 * @author Nitin Kumar (06/01/25)
 *
 *
 *
 * Implementation Detail:
 * The "startAngleDegrees" defines where the arc starts:
 *
 * Assume these are similar to quadrants of trigonometry -
 *
 * 0 degrees = Rightmost point of the circle (along the positive X-axis).
 * 90 degrees = Topmost point of the circle (along the positive Y-axis).
 * 180 degrees = Leftmost point of the circle (along the negative X-axis).
 * 270 degrees = Bottommost point of the circle (along the negative Y-axis).
 *
 * sweepAngleDegrees :
 *
 * This is the angle (in degrees) that specifies how far the arc extends from the start angle.
 * Positive values sweep the arc in a "clockwise direction".
 * Negative values sweep the arc in a "anti-clockwise" direction.
 *
 * e.g
 * sweepAngleDegrees = 180: The arc will cover half the circle (a semicircle) clockwise from the start angle.
 * sweepAngleDegrees = -90: The arc will cover a quarter of the circle counterclockwise from the start angle.
 *
 */
class TicketShape(
    private val circleRadius: Float,
    private val offsetPercentFromTop: Float // percent from 0 to 1
) : Shape {
    /**
     * Creates the outline path for the ticket shape.
     *
     * The outline consists of a rectangular shape with semi-circular cutouts on both the left and right sides.
     * The position of these cutouts is determined by the [offsetPercentFromTop] property.
     *
     * @param size The dimensions of the space available for drawing the shape
     * @param layoutDirection The current layout direction (LTR or RTL)
     * @param density The current display density
     * @return An [Outline.Generic] containing the path that defines the ticket shape
     */
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        // Calculate the offset based on the height of the shape
        val offsetFromTop = size.height * offsetPercentFromTop
        return Outline.Generic(
            path = Path().apply {
                // Start from top-left corner
                moveTo(0f, 0f)

                // Top edge
                lineTo(size.width, 0f)

                // Right edge with half-circle cutout
                lineTo(size.width, offsetFromTop) // also add support for middle elements
                arcTo(
                    rect = Rect(
                        left = size.width - circleRadius,
                        top = offsetFromTop,
                        right = size.width + circleRadius,
                        bottom = offsetFromTop + circleRadius * 2
                    ),
                    startAngleDegrees = -90f,
                    sweepAngleDegrees = -180f,
                    forceMoveTo = false
                )
                lineTo(size.width, size.height)

                // Bottom edge
                lineTo(0f, size.height)

                // Left edge with half-circle cutout
                lineTo(0f, offsetFromTop + circleRadius * 2)
                arcTo(
                    rect = Rect(
                        left = -circleRadius,
                        top = offsetFromTop,
                        right = circleRadius,
                        bottom = offsetFromTop + circleRadius * 2
                    ),
                    startAngleDegrees = 90f,
                    sweepAngleDegrees = -180f,
                    forceMoveTo = false
                )
                lineTo(0f, 0f) // Back to start
            }
        )
    }
}
