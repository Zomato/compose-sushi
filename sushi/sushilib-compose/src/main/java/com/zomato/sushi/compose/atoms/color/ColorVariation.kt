package com.zomato.sushi.compose.atoms.color

/**
 * @author gupta.anirudh@zomato.com
 */
enum class ColorVariation(val variation: Int) {
    Variation50(50),
    Variation100(100),
    Variation200(200),
    Variation300(300),
    Variation400(400),
    Variation500(500),
    Variation600(600),
    Variation700(700),
    Variation800(800),
    Variation900(900);

    companion object {
        fun fromInt(variation: Int): ColorVariation? {
            return entries.firstOrNull { it.variation == variation }
        }
    }
}
