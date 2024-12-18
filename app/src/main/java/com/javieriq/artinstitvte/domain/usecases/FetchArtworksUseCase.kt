package com.javieriq.artinstitvte.domain.usecases

import com.javieriq.artinstitvte.data.repositories.ArtRepository
import com.javieriq.artinstitvte.domain.models.ArtworkDomain
import com.javieriq.artinstitvte.utils.Result
import javax.inject.Inject

/**
 * Use case for fetching a list of artworks.
 *
 * @return [Result] containing either the list of artworks or an error.
 */
class FetchArtworksUseCase @Inject constructor(
    private val artRepository: ArtRepository
) {
    suspend operator fun invoke(): Result<ArtworkDomain> {
        return artRepository.fetchArtworks()
    }
}
