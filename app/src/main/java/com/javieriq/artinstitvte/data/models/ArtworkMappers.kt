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
        title = this.title,
        artistTitle = this.artistTitle,
        artistId = this.artistId,
        artistIds = this.artistIds,
        artistTitles = this.artistTitles,
        categoryIds = this.categoryIds,
        categoryTitles = this.categoryTitles,
        copyrightNotice = this.copyrightNotice.orEmpty(),
        dateDisplay = this.dateDisplay,
        description = this.description,
        dimensions = this.dimensions,
        imageId = this.imageId,
        mediumDisplay = this.mediumDisplay,
        shortDescription = this.shortDescription,
        styleId = this.styleId,
        styleTitle = this.styleTitle,
        subjectId = this.subjectId,
        subjectIds = this.subjectIds,
        subjectTitles = this.subjectTitles,
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
        licenseText = this.licenseText,
        licenseLinks = this.licenseLinks,
        version = this.version
    )
}

fun ConfigDto.toDomain(): Config {
    return Config(
        ifUrl = this.ifUrl,
        websiteUrl = this.websiteUrl
    )
}
