package com.mosalab.spacecraftsapp.core.model

// Data Layer Model
data class SpacecraftDto(
    val id: Int,
    val name: String
)

// Domain Model
data class Spacecraft(
    val id: Int,
    val name: String,
    var isFavorite: Boolean = false
)
