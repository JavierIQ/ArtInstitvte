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
            "api_model": "artworks",
            "api_link": "https://api.artic.edu/api/v1/artworks/16964",
            "is_boosted": true,
            "title": "The Plough and the Song",
            "alt_titles": null,
            "thumbnail": {
                "lqip": "data:image/gif;base64,R0lGODlhBgAFAPQAAJVHE5l6Wo55dKJ8YayBW4WJf7+db7qMeLelfClxu0l5kVl6ozuEsVSMi5WXiICPka6chqahirSqjqapl6ijnq+1n7azm7u+pM+kiMzGmMDBoMTOrNTQo9/gswAAAAAAACH5BAAAAAAALAAAAAAGAAUAAAUY4NIwifIIhUNNUXBgA7RV0pUhhKVxnQGEADs=",
                "width": 5582,
                "height": 4736,
                "alt_text": "Abstract painting with soft shapes of brown, pink, yellow, red."
            },
            "main_reference_number": "1963.208",
            "has_not_been_viewed_much": false,
            "boost_rank": null,
            "date_start": 1946,
            "date_end": 1946,
            "date_display": "1946–47",
            "date_qualifier_title": "",
            "date_qualifier_id": null,
            "artist_display": "Arshile Gorky\nAmerican, born Ottoman Empire (Present Day Turkey) c.1904–1948",
            "place_of_origin": "United States",
            "description": "<p>Born in Turkish Armenia, Arshile Gorky immigrated to the United States in the 1920s and became an influential member of the New York art scene. Profoundly interested in avant-garde European art, he experimented with a variety of styles. Young artists working in New York were particularly stimulated by the European Surrealists, many of whom moved to the city before and during World War II and whose circle Gorky joined. The 1940s, especially the years 1944–47, marked the creation of his most important work, produced in a kind of stream of consciousness or “automatic” manner of painting. <em>The Plough and the Song</em> reflects the artist’s indebtedness to the lyrical Surrealism of Joan Miró, but the sketchy handling of paint, translucent color, and tumbling pile of shapes are hallmarks of Gorky’s mature work. A delicate contour line delineates the biomorphic forms in the center of the composition, in marked contrast to the loose brushwork that defines the background. The title signals Gorky’s nostalgia for his heritage, as the artist wrote in 1944: “You cannot imagine the fertility of forms that leap from our Armenian plows. . . . And the songs, our ancient songs of the Armenian people, our suffering people. . . . So many shapes, so many shapes and ideas, happily a secret treasure to which I have been entrusted the key.” Deeply earthbound and poetic, <em>The Plough and the Song</em> is at once a still life, a landscape, and a fantasy.</p>\n",
            "short_description": "Born in Turkish Armenia, Arshile Gorky immigrated to the United States in the 1920s and became an influential member of the New York art scene. During 1944–47 he created his most important work in a kind of stream of consciousness or “automatic” manner of painting. This work reflects Gorky's indebtedness to the lyrical Surrealism of Joan Miró, but the sketchy handling of paint, translucent color, and tumbling pile of shapes are distinctly Gorky.",
            "dimensions": "134.2 × 155.7 cm (51 7/8 × 61 3/8 in.)",
            "dimensions_detail": [
                {
                    "depth": null,
                    "width": 155,
                    "height": 134,
                    "diameter": null,
                    "clarification": null
                }
            ],
            "medium_display": "Oil on canvas",
            "inscriptions": "No inscriptions.",
            "credit_line": "Mr. and Mrs. Lewis L. Coburn Fund",
            "catalogue_display": null,
            "publication_history": "Ethel Schwabacher, Arshile Gorky: Memorial Exhibition, ex., cat. (Plantin Press, 1951), pp. 41; 47, cat. 51 (as The Plow and The Song, c. 1947).\n\nArshile Gorky: A Loan Exhibition of Paintings and Drawings, exh. brochure (The Art Museum of Princeton Unversity, 1952), cat. 22 (as The Plow and the Song II, circa 1947).\n\nArshile Gorky in the Final Years, exh. brochure (Sidney Janis Gallery, 1953), cat. 10.\n\nEthel Schwabacher, Arshile Gorky (Whitney Museum of American Art; Macmillan Company, 1957), p. 114\n\nGorky, exh. cat. (Sidney Janis Gallery, 1957), cat. 25 (ill. as The Plow & The Song II, 1946).\n\nWilliam C. Seitz, Arshile Gorky: Paintings, Drawings, Studies, exh. cat. (Museum of Modern Art, 1962), pp. 45–46 (ill.).\n\nThe Art Institute of Chicago, Annual Report 1962-63 (Art Institute of Chicago, 1963), p. 15 (as The Plough and the Song, II, 1946).\n\n “Recent Acquisitions,” The Art Institute of Chicago Quarterly 57, no. 4 (1963-1964):  pp. 6 (ill., as The Plough and the Song #2, 1946); 7.\n\nArshile Gorky: Paintings and Drawings, exh. cat. (The Tate Gallery Arts Council, 1965), cat. 93.\n\nJulien Levy, Arshile Gorky (Harry N. Abrams, 1966), pp. 21, 31, 36, pl. 183 (ill., as The Plow and the Song II, 1946).\n\nCharles C. Cunningham, Instituto de Arte de Chicago, El mundo de los museos (Editorial Codex, 1967), p. 80 (color ill., as El arado y la cancion II).\n\nPaintings and Drawings by Arshile Gorky, exh. brochure (Peale Galleries of the Pennsylvania Academy of the Fine Arts, 1967), cat. 3.\n\nJohn Maxon, The Art Institute of Chicago (Harry N. Abrams, 1970), pp. 274 (ill., as The Plough and the Song No. 2); 281.\n\nAcquisition Priorities: Aspects of Postwar Painting in America, Including Arshile Gorky: Works 1944-1948, exh. cat. (Solomon R. Guggenheim Foundation, 1976), p. 36, cat. 3 (ill.).\n\nHayden Herrera, “The Sculptures of Arshile Gorky,” Arts Magazine 50, no. 7, Special Issue: Arshile Gorky (Mar. 1976): p. 89.\n\nRobert F. Reiff, A Stylistic Analysis of Arshile Gorky’s Art from 1943–1948 (Garland Publishing, 1977), pp. x, cat. 79; 357 (ill., as The Plow and the Song (Wolf version)).\n\nDiane Waldman, Arshile Gorky: 1904–1948, A Retrospective, exh. cat. (Harry N. Abrams; Solomon R. Guggenheim Museum, 1981), pp. 54-55; 58; cat. 203 (ill.).\n\nJim M Jordan and Robert Goldwater, The Paintings of Arshile Gorky: A Critical Catalogue (New York University Press, 1982), pp. 89–90; 103; 481, cat. 315; 482 (ill.)\n\nJames N. Wood and Katharine C. Lee, Master Paintings in the Art Institute of Chicago (Art Institute of Chicago; New York Graphic Society Books, Little, Brown and Company, 1988), pp. 146 (color ill., as The Plow and the Song II, 1946), 166.\n\nJudith A. Barter, Douglas W. Druick, and Charles F. Stuckey, eds., Shikago Bijutsukan ten: kindai kaiga no 100-nen (Masterworks of Modern Art from the Art Institute of Chicago) (Asahi Shinbunsha, 1994), pp. 176-177 (color ill.).\n\nJames N. Wood and Teri J. Edelstein, The Art Institute of Chicago: Twentieth Century Painting and Sculpture (Art Institute of Chicago; Hudson Hills Press, 1996), pp. 92 (color ill., as The Plow and the Song), 159.\n\nNouritza Matossian, Black Angel: A Life of Arshile Gorky (Chatto & Windus, 1998), p. 425.\n\nArshile Gorky: Hommage, exh. cat. (Éditions du Centre Pompidou, 2007), pp. 92, 93.\n\nRobert V. Sharp, Elizabeth Stepina, and Susan E. Weidemeyer, The Essential Guide (Art Institute of Chicago, 2009), p. 127 (ill.).\n\nMichael R. Taylor, ed., Arshile Gorky: A Retrospective, exh. cat. (Philadelphia Museum of Art, 2009), pp. 307, cat. 147 (color ill., as The Plow and the Song II, 1946); 391.",
            "exhibition_history": "New York, Whitney Museum of American Art, Arshile Gorky: Memorial Exhibition, Jan. 5–Feb. 18, 1951, cat. 51 (as The Plow and the Song); Minneapolis, Walker Art Center, Mar. 4–Apr. 22, 1951; San Francisco Museum of Art, May 9–July 9, 1951.\n\nPrinceton, The Art Museum of Princeton University, Arshile Gorky: A Loan Exhibition of Paintings and Drawings, Oct. 6–26, 1952, cat. 22 (as The Plow and The Song II, circa 1947).\n\nNew York, Sidney Janis Gallery, Arshile Gorky in the Final Years, Feb. 16–Mar. 14, 1953, cat. 10.\n\nNew York, Sidney Janis Gallery, Gorky, Dec. 2–28, 1957, cat. 25 (ill. as The Plow & the Song II, 1946).\n\nLondon, Tate Gallery, Arshile Gorky: Paintings and Drawings, April 2– May 2, 1965, cat. 93; Brussels, Palais des Beaux Arts, May 22–June 27, 1965; Rotterdam, Museum Boymans Van Beuningen, July 9–Aug. 15, 1965.\n\nPhiladelphia, The Peale Galleries of the Pennsylvania Academy of the Fine Arts, Paintings and Drawings by Arshile Gorky, Nov. 9–Dec. 10, 1967, cat. 3.\n\nNew York, Solomon R. Guggenheim Museum, Acquisition Priorities: Aspects of Postwar Painting in America, Including Arshile Gorky: Works 1944 – 1948, Oct. 15, 1976–Jan. 16, 1977, cat. 3.\n\nNew York, Solomon R. Guggenheim Museum, Arshile Gorky: 1904–1948, A Retrospective, Apr. 24–July 19, 1981, cat. 203 (as The Plough and the Song No. 2).\n\nNagaoka, Japan, Niigata Prefectural Museum of Modern Art, Masterworks of Modern Art from The Art Institute of Chicago, Apr. 20–May 29, 1994, cat. 61 (as “The Plow and the Song); Nagoya, Aichi Prefectural Museum of Modern Art, June 10–July 24, 1994; Yokohama Museum of Art, Aug. 6–Sept. 25, 1994.\n\nPhiladelphia Museum of Art, Arshile Gorky: A Retrospective, Oct. 11, 2009–Jan. 3, 2010, cat. 147; London, Tate Modern, Feb. 3–May 9, 2010; Los Angeles, Museum of Contemporary Art, Jun. 6–Sept. 20, 2010.",
            "provenance_text": "The artist (d. 1948); by descent to the Estate of the Artist, 1948; by descent to his wife, Agnes Fielding Gorky Phillips (Mrs. John C. Phillips) until at least October 1952 [Princeton 1952]. Mr. and Mrs. Stanley J. Wolf, Great Neck, New York, by 1962 [Seitz 1962]. Sold through Sidney Janis Gallery, New York, to the Art Institute of Chicago, April 4, 1963.",
            "edition": null,
            "publishing_verification_level": "Web Cataloged",
            "internal_department_id": 246,
            "fiscal_year": null,
            "fiscal_year_deaccession": null,
            "is_public_domain": false,
            "is_zoomable": true,
            "max_zoom_window_size": 1280,
            "copyright_notice": "© 2018 The Arshile Gorky Foundation / The Artists Rights Society (ARS), New York",
            "has_multimedia_resources": false,
            "has_educational_resources": false,
            "has_advanced_imaging": false,
            "colorfulness": 58.4845,
            "color": {
                "h": 210,
                "l": 42,
                "s": 65,
                "percentage": 0.10531412057718129,
                "population": 633
            },
            "latitude": null,
            "longitude": null,
            "latlon": null,
            "is_on_view": true,
            "on_loan_display": null,
            "gallery_title": "Gallery 398",
            "gallery_id": 25479,
            "nomisma_id": null,
            "artwork_type_title": "Painting",
            "artwork_type_id": 1,
            "department_title": "Contemporary Art",
            "department_id": "PC-8",
            "artist_id": 31309,
            "artist_title": "Arshile Gorky",
            "artist_ids": [
                31309
            ],
            "artist_titles": [
                "Arshile Gorky"
            ],
            "category_ids": [
                "PC-8",
                "PC-831"
            ],
            "category_titles": [
                "Contemporary Art",
                "Essentials"
            ],
            "term_titles": [
                "painting",
                "oil painting",
                "abstract figures",
                "Modernism",
                "oil paint (paint)",
                "painting (image making)",
                "modern and contemporary art",
                "blue (color)",
                "brown (color)",
                "green (color)"
            ],
            "style_id": "TM-5981",
            "style_title": "Modernism",
            "style_ids": [
                "TM-5981"
            ],
            "style_titles": [
                "Modernism"
            ],
            "classification_id": "TM-9",
            "classification_title": "painting",
            "alt_classification_ids": [
                "TM-155"
            ],
            "classification_ids": [
                "TM-9",
                "TM-155"
            ],
            "classification_titles": [
                "painting",
                "modern and contemporary art"
            ],
            "subject_id": "TM-12688",
            "alt_subject_ids": [
                "TM-11843",
                "TM-11844",
                "TM-11849"
            ],
            "subject_ids": [
                "TM-12688",
                "TM-11843",
                "TM-11844",
                "TM-11849"
            ],
            "subject_titles": [
                "abstract figures",
                "blue (color)",
                "brown (color)",
                "green (color)"
            ],
            "material_id": "TM-2451",
            "material_ids": [
                "TM-2451"
            ],
            "material_titles": [
                "oil paint (paint)"
            ],
            "technique_id": "TM-4273",
            "alt_technique_ids": [
                "TM-3891"
            ],
            "technique_ids": [
                "TM-4273",
                "TM-3891"
            ],
            "technique_titles": [
                "oil painting",
                "painting (image making)"
            ],
            "theme_titles": [
                "Essentials"
            ],
            "image_id": "77245c86-908f-83a8-4a17-119633f80a5e",
            "suggest_autocomplete_boosted": "The Plough and the Song",
            "suggest_autocomplete_all": [
                {
                    "input": [
                        "1963.208"
                    ],
                    "contexts": {
                        "groupings": [
                            "accession"
                        ]
                    }
                },
                {
                    "input": [
                        "The Plough and the Song"
                    ],
                    "weight": 4892,
                    "contexts": {
                        "groupings": [
                            "title"
                        ]
                    }
                }
            ],
            "source_updated_at": "2024-02-21T22:58:15-06:00",
            "updated_at": "2024-12-11T18:00:25-06:00",
            "timestamp": "2024-12-11T18:00:25-06:00"
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
            artwork.thumbnail.lowQualityImageUrl
        )
        assertEquals(5582, artwork.thumbnail.width)
        assertEquals(4736, artwork.thumbnail.height)
        assertEquals("Abstract painting with soft shapes of brown, pink, yellow, red.", artwork.thumbnail.altText)
    }
}