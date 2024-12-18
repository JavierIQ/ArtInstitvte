package com.javieriq.artinstitvte.data.models

import android.util.Log
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.*
import kotlinx.serialization.json.Json
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class RealApiIntegrationTest {

    private val httpClient = HttpClient(Android) {
        install(HttpTimeout) {
            requestTimeoutMillis = 30_000 // 30 seconds
            connectTimeoutMillis = 15_000 // 15 seconds
            socketTimeoutMillis = 15_000 // 15 seconds
        }
    }

    @Test
    fun `fetch artworks from live API`() = runBlocking {
        // Call the real API
        val response: HttpResponse = httpClient.get("https://api.artic.edu/api/v1/artworks") {
            contentType(ContentType.Application.Json)
        }.body()

        // Ensure HTTP response is successful
        assertEquals(HttpStatusCode.OK, response.status)

        // Deserialize response
        val json = Json { ignoreUnknownKeys = true }
        val artworksResponse = json.decodeFromString<ArtworksResponse>(response.bodyAsText())

        // Basic assertions
        assertNotNull(artworksResponse)
        assertTrue(artworksResponse.pagination.total > 0)
        assertTrue(artworksResponse.data.isNotEmpty())

        // Assert some fields in the first artwork
        val firstArtwork = artworksResponse.data.first()
        assertNotNull(firstArtwork.id)
        assertNotNull(firstArtwork.title)
        assertNotNull(firstArtwork.artistTitle)
    }
}