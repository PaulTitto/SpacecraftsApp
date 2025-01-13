package com.mosalab.spacecraftsapp.core.data.repository


import com.mosalab.spacecraftsapp.core.data.local.SpacecraftDao
import com.mosalab.spacecraftsapp.core.data.local.SpacecraftEntity
import com.mosalab.spacecraftsapp.core.data.remote.SpacecraftApiService
import com.mosalab.spacecraftsapp.core.domain.model.Spacecraft
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SpacecraftRepository @Inject constructor(
    private val apiService: SpacecraftApiService,
    private val dao: SpacecraftDao
) {
    fun getSpacecrafts(): Flow<List<Spacecraft>> = flow {
        val response = apiService.getSpacecrafts()
        if (response.isSuccessful) {
            val spacecrafts = response.body()?.spacecrafts?.map {
                Spacecraft(it.id, it.name, false)
            } ?: emptyList()
            emit(spacecrafts)
        } else {
            emit(emptyList())
        }
    }

    fun getFavorites(): Flow<List<SpacecraftEntity>> = dao.getFavorites()

    suspend fun addFavorite(spacecraft: SpacecraftEntity) = dao.insert(spacecraft)

    suspend fun removeFavorite(id: Int) = dao.deleteById(id)
}