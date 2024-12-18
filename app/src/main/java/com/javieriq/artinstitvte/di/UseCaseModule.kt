package com.javieriq.artinstitvte.di

import com.javieriq.artinstitvte.data.repositories.ArtRepository
import com.javieriq.artinstitvte.domain.usecases.FetchArtworksUseCase
import com.javieriq.artinstitvte.domain.usecases.GetArtworkDetailsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindFetchArtworksUseCase(
        fetchArtworksUseCase: FetchArtworksUseCase
    ): FetchArtworksUseCase

    @Binds
    abstract fun bindGetArtworkDetailsUseCase(
        getArtworkDetailsUseCase: GetArtworkDetailsUseCase
    ): GetArtworkDetailsUseCase
}