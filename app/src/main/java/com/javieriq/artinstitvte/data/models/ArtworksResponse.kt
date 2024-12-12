package com.javieriq.artinstitvte.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtworksResponse(
    val pagination: Pagination,
    val data: List<ArtworkDto>,
    val info: Info,
    val config: Config
)

@Serializable
data class Info(
    @SerialName("license_text")
    val licenseText: String,
    @SerialName("license_links")
    val licenseLinks: List<String>,
    @SerialName("version")
    val version: String
)

@Serializable
data class Config(
    @SerialName("iiif_url")
    val ifUrl: String,
    @SerialName("website_url")
    val websiteUrl: String
)
