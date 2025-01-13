package com.mosalab.spacecraftsapp.core.domain.usecase


import com.mosalab.spacecraftsapp.core.data.local.SpacecraftEntity
import com.mosalab.spacecraftsapp.core.data.repository.SpacecraftRepository
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val repository: SpacecraftRepository
) {
    suspend fun execute(spacecraft: SpacecraftEntity) {
        if (spacecraft.isFavorite) {
            repository.removeFavorite(spacecraft.id)
        } else {
            repository.addFavorite(spacecraft)
        }
    }
}