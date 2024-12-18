package com.javieriq.artinstitvte.data.datasources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.javieriq.artinstitvte.data.models.Converters

@Database(entities = [ArtworkEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun artworkDao(): ArtworkDao
}