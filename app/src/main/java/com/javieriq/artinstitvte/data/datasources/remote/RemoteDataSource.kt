package com.javieriq.artinstitvte.data.datasources.remote

import com.javieriq.artinstitvte.data.models.ArtworkDto
import com.javieriq.artinstitvte.data.models.ArtworksResponse

interface RemoteDataSource {
    suspend fun fetchArtworks(): ArtworksResponse
}