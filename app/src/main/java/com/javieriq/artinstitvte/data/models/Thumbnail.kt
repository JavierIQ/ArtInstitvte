package com.javieriq.artinstitvte.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail(
    @SerialName("lqip")
    val lowQualityImageUrl: String?, // Low-quality image placeholder
    @SerialName("width")
    val width: Int?,
    @SerialName("height")
    val height: Int?,
    @SerialName("alt_text")
    val altText: String? = null // Alternative text for accessibility
)
