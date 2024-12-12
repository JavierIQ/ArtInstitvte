package com.javieriq.artinstitvte.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SuggestAutocompleteAll(
    @SerialName("contexts")
    val contexts: Contexts,
    @SerialName("input")
    val input: List<String>
)