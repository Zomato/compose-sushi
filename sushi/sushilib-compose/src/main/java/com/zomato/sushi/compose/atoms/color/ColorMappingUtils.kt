package com.zomato.sushi.compose.atoms.color

import com.zomato.sushi.compose.atoms.color.ColorVariation.Variation100
import com.zomato.sushi.compose.atoms.color.ColorVariation.Variation200
import com.zomato.sushi.compose.atoms.color.ColorVariation.Variation300
import com.zomato.sushi.compose.atoms.color.ColorVariation.Variation400
import com.zomato.sushi.compose.atoms.color.ColorVariation.Variation50
import com.zomato.sushi.compose.atoms.color.ColorVariation.Variation500
import com.zomato.sushi.compose.atoms.color.ColorVariation.Variation600
import com.zomato.sushi.compose.atoms.color.ColorVariation.Variation700
import com.zomato.sushi.compose.atoms.color.ColorVariation.Variation800
import com.zomato.sushi.compose.atoms.color.ColorVariation.Variation900
import com.zomato.sushi.compose.foundation.ExperimentalSushiApi
import com.zomato.sushi.compose.foundation.SushiColorScheme

@ExperimentalSushiApi
internal fun getColor(colorName: ColorName, tint: ColorVariation, colors: SushiColorScheme): ColorSpec {
    return when (colorName) {
        ColorName.Red -> when (tint) {
            Variation50 -> colors.red.v050
            Variation100 -> colors.red.v100
            Variation200 -> colors.red.v200
            Variation300 -> colors.red.v300
            Variation400 -> colors.red.v400
            Variation500 -> colors.red.v500
            Variation600 -> colors.red.v600
            Variation700 -> colors.red.v700
            Variation800 -> colors.red.v800
            Variation900 -> colors.red.v900
        }
        ColorName.Green -> when (tint) {
            Variation50 -> colors.green.v050
            Variation100 -> colors.green.v100
            Variation200 -> colors.green.v200
            Variation300 -> colors.green.v300
            Variation400 -> colors.green.v400
            Variation500 -> colors.green.v500
            Variation600 -> colors.green.v600
            Variation700 -> colors.green.v700
            Variation800 -> colors.green.v800
            Variation900 -> colors.green.v900
        }
        ColorName.Blue -> when (tint) {
            Variation50 -> colors.blue.v050
            Variation100 -> colors.blue.v100
            Variation200 -> colors.blue.v200
            Variation300 -> colors.blue.v300
            Variation400 -> colors.blue.v400
            Variation500 -> colors.blue.v500
            Variation600 -> colors.blue.v600
            Variation700 -> colors.blue.v700
            Variation800 -> colors.blue.v800
            Variation900 -> colors.blue.v900
        }
        ColorName.Yellow -> when (tint) {
            Variation50 -> colors.yellow.v050
            Variation100 -> colors.yellow.v100
            Variation200 -> colors.yellow.v200
            Variation300 -> colors.yellow.v300
            Variation400 -> colors.yellow.v400
            Variation500 -> colors.yellow.v500
            Variation600 -> colors.yellow.v600
            Variation700 -> colors.yellow.v700
            Variation800 -> colors.yellow.v800
            Variation900 -> colors.yellow.v900
        }
        ColorName.Grey -> when (tint) {
            Variation50 -> colors.grey.v050
            Variation100 -> colors.grey.v100
            Variation200 -> colors.grey.v200
            Variation300 -> colors.grey.v300
            Variation400 -> colors.grey.v400
            Variation500 -> colors.grey.v500
            Variation600 -> colors.grey.v600
            Variation700 -> colors.grey.v700
            Variation800 -> colors.grey.v800
            Variation900 -> colors.grey.v900
        }
        ColorName.Purple -> when (tint) {
            Variation50 -> colors.purple.v050
            Variation100 -> colors.purple.v100
            Variation200 -> colors.purple.v200
            Variation300 -> colors.purple.v300
            Variation400 -> colors.purple.v400
            Variation500 -> colors.purple.v500
            Variation600 -> colors.purple.v600
            Variation700 -> colors.purple.v700
            Variation800 -> colors.purple.v800
            Variation900 -> colors.purple.v900
        }
        ColorName.Lime -> when (tint) {
            Variation50 -> colors.lime.v050
            Variation100 -> colors.lime.v100
            Variation200 -> colors.lime.v200
            Variation300 -> colors.lime.v300
            Variation400 -> colors.lime.v400
            Variation500 -> colors.lime.v500
            Variation600 -> colors.lime.v600
            Variation700 -> colors.lime.v700
            Variation800 -> colors.lime.v800
            Variation900 -> colors.lime.v900
        }
        ColorName.Indigo -> when (tint) {
            Variation50 -> colors.indigo.v050
            Variation100 -> colors.indigo.v100
            Variation200 -> colors.indigo.v200
            Variation300 -> colors.indigo.v300
            Variation400 -> colors.indigo.v400
            Variation500 -> colors.indigo.v500
            Variation600 -> colors.indigo.v600
            Variation700 -> colors.indigo.v700
            Variation800 -> colors.indigo.v800
            Variation900 -> colors.indigo.v900
        }
        ColorName.Cider -> when (tint) {
            Variation50 -> colors.cider.v050
            Variation100 -> colors.cider.v100
            Variation200 -> colors.cider.v200
            Variation300 -> colors.cider.v300
            Variation400 -> colors.cider.v400
            Variation500 -> colors.cider.v500
            Variation600 -> colors.cider.v600
            Variation700 -> colors.cider.v700
            Variation800 -> colors.cider.v800
            Variation900 -> colors.cider.v900
        }
        ColorName.Brown -> when (tint) {
            Variation50 -> colors.brown.v050
            Variation100 -> colors.brown.v100
            Variation200 -> colors.brown.v200
            Variation300 -> colors.brown.v300
            Variation400 -> colors.brown.v400
            Variation500 -> colors.brown.v500
            Variation600 -> colors.brown.v600
            Variation700 -> colors.brown.v700
            Variation800 -> colors.brown.v800
            Variation900 -> colors.brown.v900
        }
        ColorName.Teal -> when (tint) {
            Variation50 -> colors.teal.v050
            Variation100 -> colors.teal.v100
            Variation200 -> colors.teal.v200
            Variation300 -> colors.teal.v300
            Variation400 -> colors.teal.v400
            Variation500 -> colors.teal.v500
            Variation600 -> colors.teal.v600
            Variation700 -> colors.teal.v700
            Variation800 -> colors.teal.v800
            Variation900 -> colors.teal.v900
        }
        ColorName.Orange -> when (tint) {
            Variation50 -> colors.orange.v050
            Variation100 -> colors.orange.v100
            Variation200 -> colors.orange.v200
            Variation300 -> colors.orange.v300
            Variation400 -> colors.orange.v400
            Variation500 -> colors.orange.v500
            Variation600 -> colors.orange.v600
            Variation700 -> colors.orange.v700
            Variation800 -> colors.orange.v800
            Variation900 -> colors.orange.v900
        }
        ColorName.Pink -> when (tint) {
            Variation50 -> colors.pink.v050
            Variation100 -> colors.pink.v100
            Variation200 -> colors.pink.v200
            Variation300 -> colors.pink.v300
            Variation400 -> colors.pink.v400
            Variation500 -> colors.pink.v500
            Variation600 -> colors.pink.v600
            Variation700 -> colors.pink.v700
            Variation800 -> colors.pink.v800
            Variation900 -> colors.pink.v900
        }
        ColorName.Corn -> when (tint) {
            Variation50 -> colors.corn.v050
            Variation100 -> colors.corn.v100
            Variation200 -> colors.corn.v200
            Variation300 -> colors.corn.v300
            Variation400 -> colors.corn.v400
            Variation500 -> colors.corn.v500
            Variation600 -> colors.corn.v600
            Variation700 -> colors.corn.v700
            Variation800 -> colors.corn.v800
            Variation900 -> colors.corn.v900
        }
        ColorName.Avacado -> when (tint) {
            Variation50 -> colors.avacado.v050
            Variation100 -> colors.avacado.v100
            Variation200 -> colors.avacado.v200
            Variation300 -> colors.avacado.v300
            Variation400 -> colors.avacado.v400
            Variation500 -> colors.avacado.v500
            Variation600 -> colors.avacado.v600
            Variation700 -> colors.avacado.v700
            Variation800 -> colors.avacado.v800
            Variation900 -> colors.avacado.v900
        }
        ColorName.Gold -> when (tint) {
            Variation50 -> colors.gold.v050
            Variation100 -> colors.gold.v100
            Variation200 -> colors.gold.v200
            Variation300 -> colors.gold.v300
            Variation400 -> colors.gold.v400
            Variation500 -> colors.gold.v500
            Variation600 -> colors.gold.v600
            Variation700 -> colors.gold.v700
            Variation800 -> colors.gold.v800
            Variation900 -> colors.gold.v900
        }
        ColorName.Onion -> when (tint) {
            Variation50 -> colors.onion.v050
            Variation100 -> colors.onion.v100
            Variation200 -> colors.onion.v200
            Variation300 -> colors.onion.v300
            Variation400 -> colors.onion.v400
            Variation500 -> colors.onion.v500
            Variation600 -> colors.onion.v600
            Variation700 -> colors.onion.v700
            Variation800 -> colors.onion.v800
            Variation900 -> colors.onion.v900
        }
        ColorName.Charcoal -> when (tint) {
            Variation50 -> colors.charcoal.v050
            Variation100 -> colors.charcoal.v100
            Variation200 -> colors.charcoal.v200
            Variation300 -> colors.charcoal.v300
            Variation400 -> colors.charcoal.v400
            Variation500 -> colors.charcoal.v500
            Variation600 -> colors.charcoal.v600
            Variation700 -> colors.charcoal.v700
            Variation800 -> colors.charcoal.v800
            Variation900 -> colors.charcoal.v900
        }
        ColorName.Honey -> when (tint) {
            Variation50 -> colors.honey.v050
            Variation100 -> colors.honey.v100
            Variation200 -> colors.honey.v200
            Variation300 -> colors.honey.v300
            Variation400 -> colors.honey.v400
            Variation500 -> colors.honey.v500
            Variation600 -> colors.honey.v600
            Variation700 -> colors.honey.v700
            Variation800 -> colors.honey.v800
            Variation900 -> colors.honey.v900
        }
        ColorName.Tangerine -> when (tint) {
            Variation50 -> colors.tangerine.v050
            Variation100 -> colors.tangerine.v100
            Variation200 -> colors.tangerine.v200
            Variation300 -> colors.tangerine.v300
            Variation400 -> colors.tangerine.v400
            Variation500 -> colors.tangerine.v500
            Variation600 -> colors.tangerine.v600
            Variation700 -> colors.tangerine.v700
            Variation800 -> colors.tangerine.v800
            Variation900 -> colors.tangerine.v900
        }
        ColorName.Slate -> when (tint) {
            Variation50 -> colors.slate.v050
            Variation100 -> colors.slate.v100
            Variation200 -> colors.slate.v200
            Variation300 -> colors.slate.v300
            Variation400 -> colors.slate.v400
            Variation500 -> colors.slate.v500
            Variation600 -> colors.slate.v600
            Variation700 -> colors.slate.v700
            Variation800 -> colors.slate.v800
            Variation900 -> colors.slate.v900
        }
        ColorName.Black -> colors.black
        ColorName.White -> colors.white
        ColorName.Transparent -> colors.transparent
        else -> colors.red.v500
    }
}
