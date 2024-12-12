package com.javieriq.artinstitvte.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtworkDto(
    @SerialName("alt_classification_ids")
    val altClassificationIds: List<String>,
    @SerialName("alt_subject_ids")
    val altSubjectIds: List<String>,
    @SerialName("alt_technique_ids")
    val altTechniqueIds: List<String>,
    @SerialName("api_link")
    val apiLink: String,
    @SerialName("api_model")
    val apiModel: String,
    @SerialName("artist_display")
    val artistDisplay: String,
    @SerialName("artist_id")
    val artistId: Int,
    @SerialName("artist_ids")
    val artistIds: List<Int>,
    @SerialName("artist_title")
    val artistTitle: String,
    @SerialName("artist_titles")
    val artistTitles: List<String>,
    @SerialName("artwork_type_id")
    val artworkTypeId: Int,
    @SerialName("artwork_type_title")
    val artworkTypeTitle: String,
    @SerialName("category_ids")
    val categoryIds: List<String>,
    @SerialName("category_titles")
    val categoryTitles: List<String>,
    @SerialName("classification_id")
    val classificationId: String,
    @SerialName("classification_ids")
    val classificationIds: List<String>,
    @SerialName("classification_title")
    val classificationTitle: String,
    @SerialName("classification_titles")
    val classificationTitles: List<String>,
    @SerialName("color")
    val color: Color,
    @SerialName("colorfulness")
    val colorfulness: Double,
    @SerialName("copyright_notice")
    val copyrightNotice: String,
    @SerialName("credit_line")
    val creditLine: String,
    @SerialName("date_display")
    val dateDisplay: String,
    @SerialName("date_end")
    val dateEnd: Int,
    @SerialName("date_qualifier_title")
    val dateQualifierTitle: String,
    @SerialName("date_start")
    val dateStart: Int,
    @SerialName("department_id")
    val departmentId: String,
    @SerialName("department_title")
    val departmentTitle: String,
    @SerialName("description")
    val description: String,
    @SerialName("dimensions")
    val dimensions: String,
    @SerialName("dimensions_detail")
    val dimensionsDetail: List<DimensionsDetail>,
    @SerialName("exhibition_history")
    val exhibitionHistory: String,
    @SerialName("gallery_id")
    val galleryId: Int,
    @SerialName("gallery_title")
    val galleryTitle: String,
    @SerialName("has_advanced_imaging")
    val hasAdvancedImaging: Boolean,
    @SerialName("has_educational_resources")
    val hasEducationalResources: Boolean,
    @SerialName("has_multimedia_resources")
    val hasMultimediaResources: Boolean,
    @SerialName("has_not_been_viewed_much")
    val hasNotBeenViewedMuch: Boolean,
    @SerialName("id")
    val id: Int,
    @SerialName("image_id")
    val imageId: String,
    @SerialName("inscriptions")
    val inscriptions: String,
    @SerialName("internal_department_id")
    val internalDepartmentId: Int,
    @SerialName("is_boosted")
    val isBoosted: Boolean,
    @SerialName("is_on_view")
    val isOnView: Boolean,
    @SerialName("is_public_domain")
    val isPublicDomain: Boolean,
    @SerialName("is_zoomable")
    val isZoomable: Boolean,
    @SerialName("main_reference_number")
    val mainReferenceNumber: String,
    @SerialName("material_id")
    val materialId: String,
    @SerialName("material_ids")
    val materialIds: List<String>,
    @SerialName("material_titles")
    val materialTitles: List<String>,
    @SerialName("max_zoom_window_size")
    val maxZoomWindowSize: Int,
    @SerialName("medium_display")
    val mediumDisplay: String,
    @SerialName("place_of_origin")
    val placeOfOrigin: String,
    @SerialName("provenance_text")
    val provenanceText: String,
    @SerialName("publication_history")
    val publicationHistory: String,
    @SerialName("publishing_verification_level")
    val publishingVerificationLevel: String,
    @SerialName("short_description")
    val shortDescription: String,
    @SerialName("source_updated_at")
    val sourceUpdatedAt: String,
    @SerialName("style_id")
    val styleId: String,
    @SerialName("style_ids")
    val styleIds: List<String>,
    @SerialName("style_title")
    val styleTitle: String,
    @SerialName("style_titles")
    val styleTitles: List<String>,
    @SerialName("subject_id")
    val subjectId: String,
    @SerialName("subject_ids")
    val subjectIds: List<String>,
    @SerialName("subject_titles")
    val subjectTitles: List<String>,
    @SerialName("suggest_autocomplete_all")
    val suggestAutocompleteAll: List<SuggestAutocompleteAll>,
    @SerialName("suggest_autocomplete_boosted")
    val suggestAutocompleteBoosted: String,
    @SerialName("technique_id")
    val techniqueId: String,
    @SerialName("technique_ids")
    val techniqueIds: List<String>,
    @SerialName("technique_titles")
    val techniqueTitles: List<String>,
    @SerialName("term_titles")
    val termTitles: List<String>,
    @SerialName("theme_titles")
    val themeTitles: List<String>,
    @SerialName("thumbnail")
    val thumbnail: Thumbnail,
    @SerialName("timestamp")
    val timestamp: String,
    @SerialName("title")
    val title: String,
    @SerialName("updated_at")
    val updatedAt: String
)
