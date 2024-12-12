package com.javieriq.artinstitvte.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DimensionsDetail(
    @SerialName("height")
    val height: Int,
    @SerialName("width")
    val width: Int
)