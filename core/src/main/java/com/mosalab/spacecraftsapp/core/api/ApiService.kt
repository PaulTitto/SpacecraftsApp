package com.mosalab.spacecraftsapp.core.api

import com.mosalab.spacecraftsapp.core.model.Spacecraft
import retrofit2.http.GET

interface ApiService {
    @GET("spacecrafts")
    suspend fun getSpacecrafts(): List<Spacecraft>
}

