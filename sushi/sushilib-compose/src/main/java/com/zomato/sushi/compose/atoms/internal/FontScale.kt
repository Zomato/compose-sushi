package com.zomato.sushi.compose.atoms.internal

import android.content.Context
import android.util.TypedValue
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp

internal fun TextUnit.scaled(context: Context): TextUnit {
    val scaledDensity = context.resources.displayMetrics.scaledDensity
    return when (this.type) {
        TextUnitType.Sp -> (context.spToPx(this.value) / scaledDensity).sp
        TextUnitType.Em -> this
        TextUnitType.Unspecified -> this
        else -> TextUnit.Unspecified
    }
}

private fun Context.spToPx(sp: Float): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        sp,
        this.resources.displayMetrics
    ).toInt()
}