package com.mosalab.spacecraftsapp.core.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SpacecraftDao {
    @Query("SELECT * FROM spacecraft")
    fun getAllSpacecraft(): Flow<List<SpacecraftEntity>>

    @Query("SELECT * FROM spacecraft WHERE isFavorite = 1")
    fun getFavorites(): Flow<List<SpacecraftEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(spacecraft: SpacecraftEntity)

    @Query("DELETE FROM spacecraft WHERE id = :id")
    suspend fun deleteById(id: Int)
}