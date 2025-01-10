package com.mosalab.spacecraftsapp.core.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mosalab.spacecraftsapp.core.model.FavoriteEntity

@Database(entities = [FavoriteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}