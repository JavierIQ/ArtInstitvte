package com.javieriq.artinstitvte.data.repositories

import com.javieriq.artinstitvte.data.models.ArtworksResponse
import com.javieriq.artinstitvte.domain.models.Artwork
import com.javieriq.artinstitvte.domain.models.ArtworkDomain
import com.javieriq.artinstitvte.utils.Result

interface ArtRepository {
    suspend fun fetchArtworks(): Result<ArtworkDomain>
    suspend fun getArtworkById(id: Int): Result<Artwork>
}