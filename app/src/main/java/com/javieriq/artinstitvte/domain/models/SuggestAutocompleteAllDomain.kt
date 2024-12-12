package com.javieriq.artinstitvte.domain.models

data class SuggestAutocompleteAllDomain(
    val contexts: ContextsDomain,
    val input: List<String>
)