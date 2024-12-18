package com.javieriq.artinstitvte.domain.usecases

import com.javieriq.artinstitvte.data.repositories.ArtRepository
import com.javieriq.artinstitvte.domain.models.Artwork
import com.javieriq.artinstitvte.utils.Result
import javax.inject.Inject

/**
 * Use case for fetching a list of artworks.
 *
 * @return [Result] containing an specific artwork or an error.
 */
class GetArtworkDetailsUseCase @Inject constructor(
    private val artRepository: ArtRepository
) {
    suspend operator fun invoke(id: Int): Result<Artwork> {
        return artRepository.getArtworkById(id)
    }
}