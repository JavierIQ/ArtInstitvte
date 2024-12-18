package com.javieriq.artinstitvte.domain.models

data class ArtworkDomain(
    val pagination: Pagination,
    val artworks: List<Artwork>,
    val info: Info,
    val config: Config
)
