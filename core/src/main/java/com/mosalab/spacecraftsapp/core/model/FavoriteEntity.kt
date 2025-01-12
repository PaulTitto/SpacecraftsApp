package com.mosalab.spacecraftsapp.core.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "favorites")
//data class FavoriteEntity(
//    @PrimaryKey val id: Int,
//    val name: String
//)

@Entity(tableName = "favorite_spacecrafts")
data class FavoriteEntity(
    @PrimaryKey val id: Int,
    val name: String
)