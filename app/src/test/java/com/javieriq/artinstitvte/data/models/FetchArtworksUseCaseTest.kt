package com.javieriq.artinstitvte.data.models

import com.javieriq.artinstitvte.data.repositories.ArtRepository
import com.javieriq.artinstitvte.domain.models.Artwork
import com.javieriq.artinstitvte.domain.models.ArtworkDomain
import com.javieriq.artinstitvte.domain.models.Config
import com.javieriq.artinstitvte.domain.models.Info
import com.javieriq.artinstitvte.domain.models.Pagination
import com.javieriq.artinstitvte.domain.models.Thumbnail
import com.javieriq.artinstitvte.domain.usecases.FetchArtworksUseCase
import io.mockk.mockk
import com.javieriq.artinstitvte.utils.Result
import io.mockk.coEvery
import io.mockk.coVerify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class FetchArtworksUseCaseTest {

    private val mockRepository = mockk<ArtRepository>()
    private lateinit var fetchArtworksUseCase: FetchArtworksUseCase

    @Before
    fun setUp() {
        fetchArtworksUseCase = FetchArtworksUseCase(mockRepository)
    }

    // Add more test cases as needed
    @Test
    fun `when repository returns success, use case returns success`(): Unit = runBlocking {
        val mockData = ArtworkDomain(
            pagination = Pagination(
                total = 126335,
                limit = 12,
                offset = 0,
                totalPages = 10528,
                currentPage = 1,
                nextUrl = "https://api.artic.edu/api/v1/artworks?page=2"
            ),
            artworks = listOf(
                Artwork(
                    id = 16964,
                    title = "The Plough and the Song",
                    artistTitle = "Arshile Gorky",
                    dateDisplay = "1946–47",
                    mediumDisplay = "Oil on canvas",
                    dimensions = "134.2 × 155.7 cm (51 7/8 × 61 3/8 in.)",
                    description = "(Insert description here)", // Replace with actual description from API
                    shortDescription = "An abstract painting with soft shapes of brown, pink, yellow, and red.",
                    imageId = "77245c86-908f-83a8-4a17-119633f80a5e",
                    thumbnail = Thumbnail(
                        altText = "Abstract painting with soft shapes of brown, pink, yellow, red.",
                        height = 4736,
                        lqip = "data:image/gif;base64,R0lGODlhBgAFAPQAAJVHE5l6Wo55dKJ8YayBW4WJf7+db7qMeLelfClxu0l5kVl6ozuEsVSMi5WXiICPka6chqahirSqjqapl6ijnq+1n7azm7u+pM+kiMzGmMDBoMTOrNTQo9/gswAAAAAAACH5BAAAAAAALAAAAAAGAAUAAAUY4NIwifIIhUNNUXBgA7RV0pUhhKVxnQGEADs=",
                        width = 5582
                    ),
                    styleId = "TM-5981",
                    styleTitle = "Modernism",
                    categoryIds = listOf("PC-8", "PC-831"),
                    categoryTitles = listOf("Contemporary Art", "Essentials"),
                    subjectId = "TM-12688",
                    subjectIds = listOf("TM-12688", "TM-11843", "TM-11844", "TM-11849"),
                    subjectTitles = listOf(
                        "abstract figures",
                        "blue (color)",
                        "brown (color)",
                        "green (color)"
                    ),
                    artistId = 31309,
                    artistIds = listOf(31309),
                    artistTitles = listOf("Arshile Gorky"),
                    copyrightNotice = "© 2018 The Arshile Gorky Foundation / The Artists Rights Society (ARS), New York"
                )
            ),
            info = Info(
                licenseText = "The `description` field in this response is licensed under a Creative Commons Attribution 4.0 Generic License (CC-By) and the Terms and Conditions of artic.edu. All other data in this response is licensed under a Creative Commons Zero (CC0) 1.0 designation and the Terms and Conditions of artic.edu.",
                licenseLinks = listOf(
                    "https://creativecommons.org/publicdomain/zero/1.0/",
                    "https://www.artic.edu/terms"
                ),
                version = "1.10"
            ),
            config = Config(
                ifUrl = "https://www.artic.edu/iiif/2",
                websiteUrl = "http://www.artic.edu"
            )
        )
        coEvery { mockRepository.fetchArtworks() } returns Result.Success(mockData)

        val result = fetchArtworksUseCase()

        assertTrue(result is Result.Success && result.data == mockData)
        coVerify { mockRepository.fetchArtworks() }
    }

    @Test
    fun `when repository returns error, use case returns error`(): Unit = runBlocking {
        val exception = Exception("Error fetching artworks")
        coEvery { mockRepository.fetchArtworks() } returns Result.Error(exception)

        val result = fetchArtworksUseCase()

        assertTrue(result is Result.Error && result.exception == exception)
        coVerify { mockRepository.fetchArtworks() }
    }
}