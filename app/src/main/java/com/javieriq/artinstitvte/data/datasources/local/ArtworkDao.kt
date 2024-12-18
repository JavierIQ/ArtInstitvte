package com.javieriq.artinstitvte.data.datasources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArtworkDao {
    @Query("SELECT * FROM artworks")
    suspend fun getAllArtworks(): List<ArtworkEntity>

    @Query("SELECT * FROM artworks WHERE id = :id")
    suspend fun getArtworkById(id: Int): ArtworkEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArtworks(artworks: List<ArtworkEntity>)
}