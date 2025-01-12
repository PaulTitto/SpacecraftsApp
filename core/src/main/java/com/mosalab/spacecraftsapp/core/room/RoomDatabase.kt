package com.mosalab.spacecraftsapp.core.room

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import com.mosalab.spacecraftsapp.core.model.FavoriteEntity
import kotlinx.coroutines.flow.Flow

//@Entity(tableName = "favorite_spacecrafts")
//data class FavoriteEntity(
//    @PrimaryKey val id: Int,
//    val name: String
//)

@Dao
interface SpacecraftDao {
    @Query("SELECT * FROM favorite_spacecrafts")
    fun getAllFavorites(): Flow<List<FavoriteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: FavoriteEntity)

    @Delete
    suspend fun deleteFavorite(favorite: FavoriteEntity)
}

@Database(entities = [FavoriteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun spacecraftDao(): SpacecraftDao
}
