package com.zomato.sushi.core

/**
 * @author gupta.anirudh@zomato.com
 */
interface SushiColorToken {
    val token: String
}

fun SushiColorToken(token: String) = object : SushiColorToken {
    override val token: String get() = token
}