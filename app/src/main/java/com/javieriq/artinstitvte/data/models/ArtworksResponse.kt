package com.javieriq.artinstitvte.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtworksResponse(
    val pagination: PaginationDto,
    val data: List<ArtworkDto>,
    val info: InfoDto,
    val config: ConfigDto
)

@Serializable
data class PaginationDto(
    @SerialName("total")
    val total: Int,
    @SerialName("limit")
    val limit: Int,
    @SerialName("offset")
    val offset: Int,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("current_page")
    val currentPage: Int,
    @SerialName("next_url")
    val nextUrl: String? = null
)

@Serializable
data class ArtworkDto(
    // General Information
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("artist_title")
    val artistTitle: String,
    @SerialName("date_display")
    val dateDisplay: String,
    @SerialName("medium_display")
    val mediumDisplay: String,
    @SerialName("dimensions")
    val dimensions: String,
    //Description
    @SerialName("description")
    val description: String,
    @SerialName("short_description")
    val shortDescription: String,
    //Image
    @SerialName("image_id")
    val imageId: String,
    @SerialName("thumbnail")
    val thumbnail: ThumbnailDto?,
    //Additional Information:
    @SerialName("style_id")
    val styleId: String,
    @SerialName("style_title")
    val styleTitle: String,
    @SerialName("category_ids")
    val categoryIds: List<String>,
    @SerialName("category_titles")
    val categoryTitles: List<String>,
    @SerialName("subject_id")
    val subjectId: String,
    @SerialName("subject_ids")
    val subjectIds: List<String>,
    @SerialName("subject_titles")
    val subjectTitles: List<String>,
    @SerialName("artist_id")
    val artistId: Int,
    @SerialName("artist_ids")
    val artistIds: List<Int>,
    @SerialName("artist_titles")
    val artistTitles: List<String>,
    //Copyright
    @SerialName("copyright_notice")
    val copyrightNotice: String?,
)

@Serializable
data class InfoDto(
    @SerialName("license_text")
    val licenseText: String,
    @SerialName("license_links")
    val licenseLinks: List<String>,
    @SerialName("version")
    val version: String
)

@Serializable
data class ConfigDto(
    @SerialName("iiif_url")
    val ifUrl: String,
    @SerialName("website_url")
    val websiteUrl: String
)

@Serializable
data class ThumbnailDto(
    @SerialName("lqip")
    val lowQualityImageUrl: String?, // Low-quality image placeholder
    @SerialName("width")
    val width: Int?,
    @SerialName("height")
    val height: Int?,
    @SerialName("alt_text")
    val altText: String? = null // Alternative text for accessibility
)
