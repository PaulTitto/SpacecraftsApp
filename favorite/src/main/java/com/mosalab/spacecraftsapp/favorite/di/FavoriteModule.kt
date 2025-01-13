package com.mosalab.spacecraftsapp.favorite.di

import com.mosalab.spacecraftsapp.core.data.repository.SpacecraftRepository
import com.mosalab.spacecraftsapp.core.domain.usecase.GetFavoritesUseCase
import com.mosalab.spacecraftsapp.core.domain.usecase.ToggleFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
object FavoriteModule {

    @Provides
    fun provideGetFavoritesUseCase(repository: SpacecraftRepository): GetFavoritesUseCase {
        return GetFavoritesUseCase(repository)
    }

    @Provides
    fun provideToggleFavoriteUseCase(repository: SpacecraftRepository): ToggleFavoriteUseCase {
        return ToggleFavoriteUseCase(repository)
    }
}