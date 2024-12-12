package com.javieriq.artinstitvte.data.models

import com.javieriq.artinstitvte.domain.models.ArtworkDomain
import com.javieriq.artinstitvte.domain.models.ColorDomain
import com.javieriq.artinstitvte.domain.models.ConfigDomain
import com.javieriq.artinstitvte.domain.models.ContextsDomain
import com.javieriq.artinstitvte.domain.models.DimensionsDetailDomain
import com.javieriq.artinstitvte.domain.models.InfoDomain
import com.javieriq.artinstitvte.domain.models.PaginationDomain
import com.javieriq.artinstitvte.domain.models.SuggestAutocompleteAllDomain
import com.javieriq.artinstitvte.domain.models.ThumbnailDomain

fun ArtworkDto.toDomainModel(): ArtworkDomain {
    return ArtworkDomain(
        id = this.id,
        title = this.title,
        artistTitle = this.artistTitle,
        apiLink = this.apiLink,
        apiModel = this.apiModel,
        artistDisplay = this.artistDisplay,
        altClassificationIds = this.altClassificationIds,
        altSubjectIds = this.altSubjectIds,
        altTechniqueIds = this.altTechniqueIds,
        artistId = this.artistId,
        artistIds = this.artistIds,
        artistTitles = this.artistTitles,
        artworkTypeId = this.artworkTypeId,
        artworkTypeTitle = this.artworkTypeTitle,
        categoryIds = this.categoryIds,
        categoryTitles = this.categoryTitles,
        classificationId = this.classificationId,
        classificationIds = this.classificationIds,
        classificationTitle = this.classificationTitle,
        classificationTitles = this.classificationTitles,
        color = ColorDomain(
            h = this.color.h,
            l = this.color.l,
            s = this.color.s,
            percentage = this.color.percentage,
            population = this.color.population
        ),
        colorfulness = this.colorfulness,
        copyrightNotice = this.copyrightNotice,
        creditLine = this.creditLine,
        dateDisplay = this.dateDisplay,
        dateEnd = this.dateEnd,
        dateQualifierTitle = this.dateQualifierTitle,
        dateStart = this.dateStart,
        departmentId = this.departmentId,
        departmentTitle = this.departmentTitle,
        description = this.description,
        dimensions = this.dimensions,
        dimensionsDetail = this.dimensionsDetail.map { detail ->
            DimensionsDetailDomain(
                height = detail.height,
                width = detail.width
            )
        },
        exhibitionHistory = this.exhibitionHistory,
        galleryId = this.galleryId,
        galleryTitle = this.galleryTitle,
        hasAdvancedImaging = this.hasAdvancedImaging,
        hasEducationalResources = this.hasEducationalResources,
        hasMultimediaResources = this.hasMultimediaResources,
        hasNotBeenViewedMuch = this.hasNotBeenViewedMuch,
        imageId = this.imageId,
        inscriptions = this.inscriptions,
        internalDepartmentId = this.internalDepartmentId,
        isBoosted = this.isBoosted,
        isOnView = this.isOnView,
        isPublicDomain = this.isPublicDomain,
        isZoomable = this.isZoomable,
        mainReferenceNumber = this.mainReferenceNumber,
        materialId = this.materialId,
        materialIds = this.materialIds,
        materialTitles = this.materialTitles,
        maxZoomWindowSize = this.maxZoomWindowSize,
        mediumDisplay = this.mediumDisplay,
        placeOfOrigin = this.placeOfOrigin,
        provenanceText = this.provenanceText,
        publicationHistory = this.publicationHistory,
        publishingVerificationLevel = this.publishingVerificationLevel,
        shortDescription = this.shortDescription,
        sourceUpdatedAt = this.sourceUpdatedAt,
        styleId = this.styleId,
        styleIds = this.styleIds,
        styleTitle = this.styleTitle,
        styleTitles = this.styleTitles,
        subjectId = this.subjectId,
        subjectIds = this.subjectIds,
        subjectTitles = this.subjectTitles,
        suggestAutocompleteAll = this.suggestAutocompleteAll.map { suggestAutocompleteAll ->
            SuggestAutocompleteAllDomain(
                contexts = ContextsDomain(
                    groupings = suggestAutocompleteAll.contexts.groupings
                ),
                input = suggestAutocompleteAll.input
            )
        },
        suggestAutocompleteBoosted = this.suggestAutocompleteBoosted,
        techniqueId = this.techniqueId,
        techniqueIds = this.techniqueIds,
        techniqueTitles = this.techniqueTitles,
        termTitles = this.termTitles,
        themeTitles = this.themeTitles,
        thumbnail = ThumbnailDomain(
            lqip = this.thumbnail.lowQualityImageUrl,
            width = this.thumbnail.width,
            height = this.thumbnail.height,
            altText = this.thumbnail.altText
        ),
        timestamp = this.timestamp,
        updatedAt = this.updatedAt
    )
}

fun Pagination.toDomainModel(): PaginationDomain {
    return PaginationDomain(
        total = this.total,
        limit = this.limit,
        offset = this.offset,
        totalPages = this.totalPages,
        currentPage = this.currentPage,
        nextUrl = this.nextUrl.orEmpty()
    )
}

fun Info.toDomainModel(): InfoDomain {
    return InfoDomain(
        licenseText = this.licenseText,
        licenseLinks = this.licenseLinks,
        version = this.version
    )
}

fun Config.toDomainModel(): ConfigDomain {
    return ConfigDomain(
        ifUrl = this.ifUrl,
        websiteUrl = this.websiteUrl
    )
}
