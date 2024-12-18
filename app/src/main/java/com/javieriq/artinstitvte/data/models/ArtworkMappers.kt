package com.javieriq.artinstitvte.data.models

import com.javieriq.artinstitvte.domain.models.Artwork
import com.javieriq.artinstitvte.domain.models.ArtworkDomain
import com.javieriq.artinstitvte.domain.models.Config
import com.javieriq.artinstitvte.domain.models.Info
import com.javieriq.artinstitvte.domain.models.Pagination
import com.javieriq.artinstitvte.domain.models.Thumbnail
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
        title = this.title.orEmpty(),
        artistTitle = this.artistTitle,
        artistId = this.artistId,
        artistIds = this.artistIds,
        artistTitles = this.artistTitles.orEmpty(),
        categoryIds = this.categoryIds.orEmpty(),
        categoryTitles = this.categoryTitles.orEmpty(),
        copyrightNotice = this.copyrightNotice.orEmpty(),
        dateDisplay = this.dateDisplay,
        description = this.description.orEmpty(),
        dimensions = this.dimensions.orEmpty(),
        imageId = this.imageId.orEmpty(),
        mediumDisplay = this.mediumDisplay.orEmpty(),
        shortDescription = this.shortDescription.orEmpty(),
        styleId = this.styleId.orEmpty(),
        styleTitle = this.styleTitle.orEmpty(),
        subjectId = this.subjectId.orEmpty(),
        subjectIds = this.subjectIds.orEmpty(),
        subjectTitles = this.subjectTitles.orEmpty(),
        thumbnail = Thumbnail(
            lqip = this.thumbnail?.lowQualityImageUrl.orEmpty(),
            width = this.thumbnail?.width?.orZero(),
            height = this.thumbnail?.height?.orZero(),
            altText = this.thumbnail?.altText.orEmpty()
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
        nextUrl = this.nextUrl.orEmpty()
    )
}

fun InfoDto.toDomain(): Info {
    return Info(
        licenseText = this.licenseText.orEmpty(),
        licenseLinks = this.licenseLinks.orEmpty(),
        version = this.version.orEmpty()
    )
}

fun ConfigDto.toDomain(): Config {
    return Config(
        ifUrl = this.ifUrl.orEmpty(),
        websiteUrl = this.websiteUrl.orEmpty()
    )
}
