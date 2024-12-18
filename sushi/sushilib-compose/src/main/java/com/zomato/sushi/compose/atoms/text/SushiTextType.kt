@file:OptIn(ExperimentalSushiApi::class)

package com.zomato.sushi.compose.atoms.text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiTheme

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
@Immutable
sealed interface TextTypeSpec {
    @get:Composable @Stable val typeStyle: TextStyle
}

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
@JvmInline
internal value class TextStyleTextType(val textStyle: TextStyle) : TextTypeSpec {
    override val typeStyle: TextStyle
        @Composable @Stable get() = textStyle
}

fun TextStyle.asTextTypeSpec(): TextTypeSpec = TextStyleTextType(this)

/**
 * @author gupta.anirudh@zomato.com
 */
@ExperimentalSushiApi
enum class SushiTextType : TextTypeSpec {
    Light50,
    Light100,
    Light200,
    Light300,
    Light400,
    Light500,
    Light600,
    Light700,
    Light800,
    Light900,

    Regular50,
    Regular100,
    Regular200,
    Regular300,
    Regular400,
    Regular500,
    Regular600,
    Regular700,
    Regular800,
    Regular900,

    Medium50,
    Medium100,
    Medium200,
    Medium300,
    Medium400,
    Medium500,
    Medium600,
    Medium700,
    Medium800,
    Medium900,

    SemiBold50,
    SemiBold100,
    SemiBold200,
    SemiBold300,
    SemiBold400,
    SemiBold500,
    SemiBold600,
    SemiBold700,
    SemiBold800,
    SemiBold900,

    Bold50,
    Bold100,
    Bold200,
    Bold300,
    Bold400,
    Bold500,
    Bold600,
    Bold700,
    Bold800,
    Bold900,

    ExtraBold50,
    ExtraBold100,
    ExtraBold200,
    ExtraBold300,
    ExtraBold400,
    ExtraBold500,
    ExtraBold600,
    ExtraBold700,
    ExtraBold800,
    ExtraBold900;

    override val typeStyle: TextStyle @Composable @Stable get() = when (this) {
        Light50       -> SushiTheme.typography.light050
        Light100      -> SushiTheme.typography.light100
        Light200      -> SushiTheme.typography.light200
        Light300      -> SushiTheme.typography.light300
        Light400      -> SushiTheme.typography.light400
        Light500      -> SushiTheme.typography.light500
        Light600      -> SushiTheme.typography.light600
        Light700      -> SushiTheme.typography.light700
        Light800      -> SushiTheme.typography.light800
        Light900      -> SushiTheme.typography.light900
        Regular50     -> SushiTheme.typography.regular050
        Regular100    -> SushiTheme.typography.regular100
        Regular200    -> SushiTheme.typography.regular200
        Regular300    -> SushiTheme.typography.regular300
        Regular400    -> SushiTheme.typography.regular400
        Regular500    -> SushiTheme.typography.regular500
        Regular600    -> SushiTheme.typography.regular600
        Regular700    -> SushiTheme.typography.regular700
        Regular800    -> SushiTheme.typography.regular800
        Regular900    -> SushiTheme.typography.regular900
        Medium50      -> SushiTheme.typography.medium050
        Medium100     -> SushiTheme.typography.medium100
        Medium200     -> SushiTheme.typography.medium200
        Medium300     -> SushiTheme.typography.medium300
        Medium400     -> SushiTheme.typography.medium400
        Medium500     -> SushiTheme.typography.medium500
        Medium600     -> SushiTheme.typography.medium600
        Medium700     -> SushiTheme.typography.medium700
        Medium800     -> SushiTheme.typography.medium800
        Medium900     -> SushiTheme.typography.medium900
        SemiBold50    -> SushiTheme.typography.semiBold050
        SemiBold100   -> SushiTheme.typography.semiBold100
        SemiBold200   -> SushiTheme.typography.semiBold200
        SemiBold300   -> SushiTheme.typography.semiBold300
        SemiBold400   -> SushiTheme.typography.semiBold400
        SemiBold500   -> SushiTheme.typography.semiBold500
        SemiBold600   -> SushiTheme.typography.semiBold600
        SemiBold700   -> SushiTheme.typography.semiBold700
        SemiBold800   -> SushiTheme.typography.semiBold800
        SemiBold900   -> SushiTheme.typography.semiBold900
        Bold50        -> SushiTheme.typography.bold050
        Bold100       -> SushiTheme.typography.bold100
        Bold200       -> SushiTheme.typography.bold200
        Bold300       -> SushiTheme.typography.bold300
        Bold400       -> SushiTheme.typography.bold400
        Bold500       -> SushiTheme.typography.bold500
        Bold600       -> SushiTheme.typography.bold600
        Bold700       -> SushiTheme.typography.bold700
        Bold800       -> SushiTheme.typography.bold800
        Bold900       -> SushiTheme.typography.bold900
        ExtraBold50   -> SushiTheme.typography.extraBold050
        ExtraBold100  -> SushiTheme.typography.extraBold100
        ExtraBold200  -> SushiTheme.typography.extraBold200
        ExtraBold300  -> SushiTheme.typography.extraBold300
        ExtraBold400  -> SushiTheme.typography.extraBold400
        ExtraBold500  -> SushiTheme.typography.extraBold500
        ExtraBold600  -> SushiTheme.typography.extraBold600
        ExtraBold700  -> SushiTheme.typography.extraBold700
        ExtraBold800  -> SushiTheme.typography.extraBold800
        ExtraBold900  -> SushiTheme.typography.extraBold900
    }
}
