package com.mosalab.spacecraftsapp.core.api

import com.mosalab.spacecraftsapp.core.model.Spacecraft
import com.mosalab.spacecraftsapp.core.model.SpacecraftDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("spacecrafts")
    suspend fun getSpacecrafts(): List<SpacecraftDto>
}
//
//object ApiClient {
//    val apiService: ApiService by lazy {
//        Retrofit.Builder()
//            .baseUrl("https://isro.vercel.app/api/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiService::class.java)
//    }
//}