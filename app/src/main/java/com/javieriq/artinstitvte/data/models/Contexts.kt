package com.javieriq.artinstitvte.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Contexts(
    @SerialName("groupings")
    val groupings: List<String>
)