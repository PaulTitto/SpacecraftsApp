package com.mosalab.spacecraftsapp.core.domain.usecase


import com.mosalab.spacecraftsapp.core.data.local.SpacecraftEntity
import com.mosalab.spacecraftsapp.core.data.repository.SpacecraftRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val repository: SpacecraftRepository
) {
    fun execute(): Flow<List<SpacecraftEntity>> {
        return repository.getFavorites()
    }
}
