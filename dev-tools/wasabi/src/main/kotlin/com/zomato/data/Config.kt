package com.zomato.data

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonIgnoreUnknownKeys

@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonIgnoreUnknownKeys
data class Config(
    @SerialName("glyphs") val glyphs: List<Glyph>
) {
    @Serializable
    @JsonIgnoreUnknownKeys
    data class Glyph(
        @SerialName("code") val code: Int,
        @SerialName("css") val css: String
    )
}