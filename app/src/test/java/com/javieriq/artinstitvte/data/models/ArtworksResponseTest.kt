package com.javieriq.artinstitvte.data.models

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Assert.*
import org.junit.Test

class ArtworksResponseTest {

    private val artworksResponseJson = """
{
    "pagination": {
        "total": 126335,
        "limit": 12,
        "offset": 0,
        "total_pages": 10528,
        "current_page": 1,
        "next_url": "https://api.artic.edu/api/v1/artworks?page=2"
    },
    "data": [
        {
            "id": 16964,
            "title": "The Plough and the Song",
            "artist_title": "Arshile Gorky",
            "date_display": "1946–47",
            "medium_display": "Oil on canvas",
            "dimensions": "134.2 × 155.7 cm (51 7/8 × 61 3/8 in.)",
            "description": "<p>Born in Turkish Armenia, Arshile Gorky immigrated to the United States in the 1920s and became an influential member of the New York art scene. Profoundly interested in avant-garde European art, he experimented with a variety of styles. Young artists working in New York were particularly stimulated by the European Surrealists, many of whom moved to the city before and during World War II and whose circle Gorky joined. The 1940s, especially the years 1944–47, marked the creation of his most important work, produced in a kind of stream of consciousness or “automatic” manner of painting. <em>The Plough and the Song</em> reflects the artist’s indebtedness to the lyrical Surrealism of Joan Miró, but the sketchy handling of paint, translucent color, and tumbling pile of shapes are hallmarks of Gorky’s mature work. A delicate contour line delineates the biomorphic forms in the center of the composition, in marked contrast to the loose brushwork that defines the background. The title signals Gorky’s nostalgia for his heritage, as the artist wrote in 1944: “You cannot imagine the fertility of forms that leap from our Armenian plows. . . . And the songs, our ancient songs of the Armenian people, our suffering people. . . . So many shapes, so many shapes and ideas, happily a secret treasure to which I have been entrusted the key.” Deeply earthbound and poetic, <em>The Plough and the Song</em> is at once a still life, a landscape, and a fantasy.</p>\n",
            "short_description": "Born in Turkish Armenia, Arshile Gorky immigrated to the United States in the 1920s and became an influential member of the New York art scene. During 1944–47 he created his most important work in a kind of stream of consciousness or “automatic” manner of painting. This work reflects Gorky's indebtedness to the lyrical Surrealism of Joan Miró, but the sketchy handling of paint, translucent color, and tumbling pile of shapes are distinctly Gorky.",
            "image_id": "77245c86-908f-83a8-4a17-119633f80a5e",
            "thumbnail": {
                "lqip": "data:image/gif;base64,R0lGODlhBgAFAPQAAJVHE5l6Wo55dKJ8YayBW4WJf7+db7qMeLelfClxu0l5kVl6ozuEsVSMi5WXiICPka6chqahirSqjqapl6ijnq+1n7azm7u+pM+kiMzGmMDBoMTOrNTQo9/gswAAAAAAACH5BAAAAAAALAAAAAAGAAUAAAUY4NIwifIIhUNNUXBgA7RV0pUhhKVxnQGEADs=",
                "width": 5582,
                "height": 4736,
                "alt_text": "Abstract painting with soft shapes of brown, pink, yellow, red."
            },
            "style_id": "TM-5981",
            "style_title": "Modernism",
            "category_ids":[
            "PC-8",
            "PC-831"],
            "category_titles": [
            "Contemporary Art",
            "Essentials"],
            "subject_id": "TM-12688",
            "subject_ids": [
            "TM-12688",
            "TM-11843",
            "TM-11844",
            "TM-11849"],
            "subject_titles": [
                "abstract figures",
                "blue (color)",
                "brown (color)",
                "green (color)"
            ],
            "artist_id": 31309,
            "artist_ids": [
                31309
            ],
             "artist_titles": [
                "Arshile Gorky"
            ],
            "copyright_notice": "© 2018 The Arshile Gorky Foundation / The Artists Rights Society (ARS), New York"
        }
    ],
    "info": {
        "license_text": "The `description` field in this response is licensed under a Creative Commons Attribution 4.0 Generic License (CC-By) and the Terms and Conditions of artic.edu. All other data in this response is licensed under a Creative Commons Zero (CC0) 1.0 designation and the Terms and Conditions of artic.edu.",
        "license_links": [
            "https://creativecommons.org/publicdomain/zero/1.0/",
            "https://www.artic.edu/terms"
        ],
        "version": "1.10"
    },
    "config": {
        "iiif_url": "https://www.artic.edu/iiif/2",
        "website_url": "http://www.artic.edu"
    }
}
        """.trimIndent()

    @Test
    fun `deserialize ArtworksResponse correctly`() {
        val json = Json { ignoreUnknownKeys = true }
        val response = json.decodeFromString<ArtworksResponse>(artworksResponseJson)

        // Assertions for pagination
        assertEquals(126335, response.pagination.total)
        assertEquals(12, response.pagination.limit)
        assertEquals(0, response.pagination.offset)
        assertEquals(10528, response.pagination.totalPages)
        assertEquals(1, response.pagination.currentPage)
        assertEquals("https://api.artic.edu/api/v1/artworks?page=2", response.pagination.nextUrl)

        // Assertions for data
        assertEquals(1, response.data.size)
        val artwork = response.data[0]
        assertEquals(16964, artwork.id)
        assertEquals("The Plough and the Song", artwork.title)
        assertEquals(
            "Arshile Gorky",
            artwork.artistTitle
        )
        assertNotNull(artwork.thumbnail)
        assertEquals(
            "data:image/gif;base64,R0lGODlhBgAFAPQAAJVHE5l6Wo55dKJ8YayBW4WJf7+db7qMeLelfClxu0l5kVl6ozuEsVSMi5WXiICPka6chqahirSqjqapl6ijnq+1n7azm7u+pM+kiMzGmMDBoMTOrNTQo9/gswAAAAAAACH5BAAAAAAALAAAAAAGAAUAAAUY4NIwifIIhUNNUXBgA7RV0pUhhKVxnQGEADs=",
            artwork.thumbnail?.lowQualityImageUrl.orEmpty()
        )
        assertEquals(5582, artwork.thumbnail?.width ?: 0)
        assertEquals(4736, artwork.thumbnail?.height ?: 0)
        assertEquals("Abstract painting with soft shapes of brown, pink, yellow, red.", artwork.thumbnail?.altText.orEmpty())
    }
}