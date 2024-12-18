package com.javieriq.artinstitvte.data.datasources.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.javieriq.artinstitvte.domain.models.Thumbnail

@Entity(tableName = "artworks")
data class ArtworkEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val artistTitle: String,
    val dateDisplay: String,
    val mediumDisplay: String,
    val dimensions: String,
    //Description
    val description: String,
    val shortDescription: String,
    //Image
    val imageId: String,
    //Additional Information:
    val styleId: String,
    val styleTitle: String,
    val categoryIds: List<String>,
    val categoryTitles: List<String>,
    val subjectId: String,
    val subjectIds: List<String>,
    val subjectTitles: List<String>,
    val artistId: Int,
    val artistIds: List<Int>,
    val artistTitles: List<String>,
    //Copyright
    val copyrightNotice: String
)
