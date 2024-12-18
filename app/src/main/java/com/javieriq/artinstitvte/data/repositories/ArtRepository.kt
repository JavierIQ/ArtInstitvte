package com.javieriq.artinstitvte.data.repositories

import com.javieriq.artinstitvte.data.models.ArtworksResponse
import com.javieriq.artinstitvte.domain.models.Artwork
import com.javieriq.artinstitvte.domain.models.ArtworkDomain

interface ArtRepository {
    suspend fun fetchArtworks(): Result<ArtworkDomain>
    suspend fun getArtworkById(id: Int): Result<Artwork>
}