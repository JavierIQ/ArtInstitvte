package com.javieriq.artinstitvte.data.repositories

import com.javieriq.artinstitvte.data.datasources.local.ArtworkDao
import com.javieriq.artinstitvte.data.datasources.local.ArtworkEntity
import com.javieriq.artinstitvte.data.datasources.remote.RemoteDataSource
import com.javieriq.artinstitvte.data.models.toDomain
import com.javieriq.artinstitvte.domain.models.Artwork
import com.javieriq.artinstitvte.domain.models.ArtworkDomain
import com.javieriq.artinstitvte.domain.models.Thumbnail
import com.javieriq.artinstitvte.utils.Constants
import com.javieriq.artinstitvte.utils.Logger
import com.javieriq.artinstitvte.utils.Result
import javax.inject.Inject

class ArtRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: ArtworkDao
) : ArtRepository {
    override suspend fun fetchArtworks(): Result<ArtworkDomain> {
        return try {
            val artworkResponse = remoteDataSource.fetchArtworks().toDomain()
            localDataSource.insertArtworks(artworkResponse.artworks.map {
                ArtworkEntity(
                    id = it.id,
                    title = it.title,
                    artistTitle = it.artistTitle,
                    dateDisplay = it.dateDisplay,
                    mediumDisplay = it.mediumDisplay,
                    dimensions = it.dimensions,
                    description = it.description,
                    shortDescription = it.shortDescription,
                    imageId = it.imageId,
                    styleId = it.styleId,
                    styleTitle = it.styleTitle,
                    categoryIds = it.categoryIds,
                    categoryTitles = it.categoryTitles,
                    subjectId = it.subjectId,
                    subjectIds = it.subjectIds,
                    subjectTitles = it.subjectTitles,
                    artistId = it.artistId,
                    artistIds = it.artistIds,
                    artistTitles = it.artistTitles,
                    copyrightNotice = it.copyrightNotice
                )
            })
            Result.Success(artworkResponse)
        } catch (e: Exception) {
            Logger.error(Constants.ERROR_FETCHING_ARTWORKS, e)
            Result.Error(e)
        }
    }

    override suspend fun getArtworkById(id: Int): Result<Artwork> {
        return try {
            val artworkEntity =
                localDataSource.getArtworkById(id) ?: throw Exception("Artwork not found")

            Result.Success(
                Artwork(
                    id = artworkEntity.id,
                    title = artworkEntity.title,
                    artistTitle = artworkEntity.artistTitle,
                    dateDisplay = artworkEntity.dateDisplay,
                    mediumDisplay = artworkEntity.mediumDisplay,
                    dimensions = artworkEntity.dimensions,
                    description = artworkEntity.description,
                    shortDescription = artworkEntity.shortDescription,
                    imageId = artworkEntity.imageId,
                    styleId = artworkEntity.styleId,
                    styleTitle = artworkEntity.styleTitle,
                    categoryIds = artworkEntity.categoryIds,
                    categoryTitles = artworkEntity.categoryTitles,
                    subjectId = artworkEntity.subjectId,
                    subjectIds = artworkEntity.subjectIds,
                    subjectTitles = artworkEntity.subjectTitles,
                    artistId = artworkEntity.artistId,
                    artistIds = artworkEntity.artistIds,
                    artistTitles = artworkEntity.artistTitles,
                    copyrightNotice = artworkEntity.copyrightNotice,
                    thumbnail = Thumbnail(
                        altText = String(),
                        height = 0,
                        lqip = String(),
                        width = 0
                    )
                )
            )
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}