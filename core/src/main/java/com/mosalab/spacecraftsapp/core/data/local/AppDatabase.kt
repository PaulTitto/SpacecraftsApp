package com.mosalab.spacecraftsapp.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SpacecraftEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun spacecraftDao(): SpacecraftDao
}