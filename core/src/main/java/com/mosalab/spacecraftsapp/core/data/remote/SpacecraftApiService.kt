package com.mosalab.spacecraftsapp.core.data.remote

import retrofit2.Response
import retrofit2.http.GET

data class SpacecraftResponse(val spacecrafts: List<SpacecraftDto>)

data class SpacecraftDto(val id: Int, val name: String)

interface SpacecraftApiService {
    @GET("api/spacecrafts")
    suspend fun getSpacecrafts(): Response<SpacecraftResponse>
}