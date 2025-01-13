package com.mosalab.spacecraftsapp.core.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spacecraft")
data class SpacecraftEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val isFavorite: Boolean
)