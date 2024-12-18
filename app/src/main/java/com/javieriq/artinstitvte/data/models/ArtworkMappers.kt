package com.javieriq.artinstitvte.data.models

import com.javieriq.artinstitvte.domain.models.Artwork
import com.javieriq.artinstitvte.domain.models.ArtworkDomain
import com.javieriq.artinstitvte.domain.models.Config
import com.javieriq.artinstitvte.domain.models.Info
import com.javieriq.artinstitvte.domain.models.Pagination
import com.javieriq.artinstitvte.domain.models.Thumbnail
import com.javieriq.artinstitvte.utils.orEmptyList
import com.javieriq.artinstitvte.utils.orEmptyString
import com.javieriq.artinstitvte.utils.orZero

fun ArtworksResponse.toDomain(): ArtworkDomain {
    return ArtworkDomain(
        pagination = this.pagination.toDomain(),
        artworks = this.data.map { it.toDomain() },
        info = this.info.toDomain(),
        config = this.config.toDomain()
    )
}

fun ArtworkDto.toDomain(): Artwork {
    return Artwork(
        id = this.id,
        title = this.title.orEmptyString(),
        artistTitle = this.artistTitle,
        artistId = this.artistId,
        artistIds = this.artistIds,
        artistTitles = this.artistTitles.orEmptyList(),
        categoryIds = this.categoryIds.orEmptyList(),
        categoryTitles = this.categoryTitles.orEmptyList(),
        copyrightNotice = this.copyrightNotice.orEmptyString(),
        dateDisplay = this.dateDisplay,
        description = this.description.orEmptyString(),
        dimensions = this.dimensions.orEmptyString(),
        imageId = this.imageId.orEmpty(),
        mediumDisplay = this.mediumDisplay.orEmptyString(),
        shortDescription = this.shortDescription.orEmptyString(),
        styleId = this.styleId.orEmptyString(),
        styleTitle = this.styleTitle.orEmptyString(),
        subjectId = this.subjectId.orEmptyString(),
        subjectIds = this.subjectIds.orEmptyList(),
        subjectTitles = this.subjectTitles.orEmptyList(),
        thumbnail = Thumbnail(
            lqip = this.thumbnail?.lowQualityImageUrl.orEmptyString(),
            width = this.thumbnail?.width?.orZero(),
            height = this.thumbnail?.height?.orZero(),
            altText = this.thumbnail?.altText.orEmptyString()
        ),
    )
}

fun PaginationDto.toDomain(): Pagination {
    return Pagination(
        total = this.total,
        limit = this.limit,
        offset = this.offset,
        totalPages = this.totalPages,
        currentPage = this.currentPage,
        nextUrl = this.nextUrl.orEmptyString(),
        prevUrl = this.prevUrl.orEmptyString()
    )
}

fun InfoDto.toDomain(): Info {
    return Info(
        licenseText = this.licenseText.orEmptyString(),
        licenseLinks = this.licenseLinks.orEmptyList(),
        version = this.version.orEmptyString()
    )
}

fun ConfigDto.toDomain(): Config {
    return Config(
        ifUrl = this.ifUrl.orEmptyString(),
        websiteUrl = this.websiteUrl.orEmptyString()
    )
}
