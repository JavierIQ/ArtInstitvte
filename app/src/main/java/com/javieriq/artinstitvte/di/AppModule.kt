package com.javieriq.artinstitvte.di

import android.content.Context
import androidx.room.Room
import com.javieriq.artinstitvte.data.datasources.local.AppDatabase
import com.javieriq.artinstitvte.data.datasources.local.ArtworkDao
import com.javieriq.artinstitvte.data.repositories.ArtRepository
import com.javieriq.artinstitvte.data.repositories.ArtRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(Android)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "art_institvte_db"
        ).build()
    }

    @Provides
    fun provideArtworkDao(db: AppDatabase): ArtworkDao = db.artworkDao()

    @Provides
    @Singleton
    fun provideJson(): Json = Json { ignoreUnknownKeys = true }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindArtRepository(
        artRepositoryImpl: ArtRepositoryImpl
    ): ArtRepository
}
