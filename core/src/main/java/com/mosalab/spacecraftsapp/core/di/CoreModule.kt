package com.mosalab.spacecraftsapp.core.di

import android.content.Context
import androidx.room.Room
import com.mosalab.spacecraftsapp.core.data.local.AppDatabase
import com.mosalab.spacecraftsapp.core.data.local.SpacecraftDao
import com.mosalab.spacecraftsapp.core.data.remote.SpacecraftApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "spacecraft_db"
        ).build()
    }

    @Provides
    fun provideDao(database: AppDatabase): SpacecraftDao = database.spacecraftDao()

    @Provides
    @Singleton
    fun provideApiService(): SpacecraftApiService {
        return Retrofit.Builder()
            .baseUrl("https://isro.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SpacecraftApiService::class.java)
    }
}