package com.javieriq.artinstitvte.data.datasources.remote

import com.javieriq.artinstitvte.data.models.ArtworkDto
import com.javieriq.artinstitvte.data.models.ArtworksResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.ContentType
import io.ktor.http.contentType
import javax.inject.Inject

class KtorRemoteDataSource @Inject constructor(
    private val client: HttpClient
) : RemoteDataSource {
    override suspend fun fetchArtworks(): ArtworksResponse {
        return try {
            client.get(urlString = "https://api.artic.edu/api/v1/artworks") {
                contentType(ContentType.Application.Json)
            }.body()
        } catch (e: Exception) {
            // Log and handle exceptions
            throw Exception("Error fetching artworks: ${e.message}")
        }
    }
}