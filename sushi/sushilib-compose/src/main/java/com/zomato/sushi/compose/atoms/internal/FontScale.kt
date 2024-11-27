package com.zomato.sushi.compose.atoms.internal

import android.content.Context
import android.util.TypedValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp

fun TextUnit.scaled(context: Context): TextUnit {
    val scaledDensity = context.resources.displayMetrics.scaledDensity
    return when (this.type) {
        TextUnitType.Sp -> (context.spToPx(this.value) / scaledDensity).sp
        TextUnitType.Em -> this
        TextUnitType.Unspecified -> this
        else -> TextUnit.Unspecified
    }
}

fun Context.spToPx(sp: Float): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        sp,
        this.resources.displayMetrics
    ).toInt()
}

@Composable
fun TextUnit.toDp(): Dp {
    return with(LocalDensity.current) { this@toDp.toDp() }
}