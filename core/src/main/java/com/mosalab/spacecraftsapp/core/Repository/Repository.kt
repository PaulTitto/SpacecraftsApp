package com.mosalab.spacecraftsapp.core.Repository

import com.mosalab.spacecraftsapp.core.api.ApiService
import com.mosalab.spacecraftsapp.core.model.FavoriteEntity
import com.mosalab.spacecraftsapp.core.model.Spacecraft
import com.mosalab.spacecraftsapp.core.room.AppDatabase
import com.mosalab.spacecraftsapp.core.room.SpacecraftDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SpacecraftRepository @Inject constructor(
    private val apiService: ApiService,
    private val spacecraftDao: SpacecraftDao
) {
    fun getSpacecrafts(): Flow<List<Spacecraft>> = flow {
        val apiResponse = apiService.getSpacecrafts()
        val spacecrafts = apiResponse.map { dto ->
            Spacecraft(dto.id, dto.name)
        }
        emit(spacecrafts)
    }

    fun getFavorites(): Flow<List<Spacecraft>> =
        spacecraftDao.getAllFavorites().map { entities ->
            entities.map { Spacecraft(it.id, it.name, isFavorite = true) }
        }

    suspend fun addFavorite(spacecraft: Spacecraft) {
        spacecraftDao.insertFavorite(FavoriteEntity(spacecraft.id, spacecraft.name))
    }

    suspend fun removeFavorite(spacecraft: Spacecraft) {
        spacecraftDao.deleteFavorite(FavoriteEntity(spacecraft.id, spacecraft.name))
    }
}
