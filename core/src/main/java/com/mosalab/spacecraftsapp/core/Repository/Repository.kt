package com.mosalab.spacecraftsapp.core.Repository

import com.mosalab.spacecraftsapp.core.api.ApiService
import com.mosalab.spacecraftsapp.core.model.FavoriteEntity
import com.mosalab.spacecraftsapp.core.model.Spacecraft
import com.mosalab.spacecraftsapp.core.room.FavoriteDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SpacecraftRepository @Inject constructor(
    private val apiService: ApiService,
    private val favoriteDao: FavoriteDao
) {
    fun getSpacecrafts(): Flow<List<Spacecraft>> = flow {
        emit(apiService.getSpacecrafts())
    }

    fun getFavorites(): Flow<List<FavoriteEntity>> = favoriteDao.getAllFavorites()

    suspend fun addFavorite(spacecraft: Spacecraft) {
        favoriteDao.insert(FavoriteEntity(spacecraft.id, spacecraft.name))
    }

    suspend fun removeFavorite(spacecraft: Spacecraft) {
        favoriteDao.delete(FavoriteEntity(spacecraft.id, spacecraft.name))
    }
}

