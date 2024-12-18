package com.javieriq.artinstitvte.data.datasources.remote

import com.javieriq.artinstitvte.data.models.ArtworksResponse
import com.javieriq.artinstitvte.utils.Constants
import com.javieriq.artinstitvte.utils.Logger
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
            client.get(urlString = "${Constants.BASE_URL}artworks") {
                contentType(ContentType.Application.Json)
            }.body()
        } catch (e: Exception) {
            Logger.error(Constants.ERROR_FETCHING_ARTWORKS, e)
            throw Exception("Error fetching artworks: ${e.message}")
        }
    }
}