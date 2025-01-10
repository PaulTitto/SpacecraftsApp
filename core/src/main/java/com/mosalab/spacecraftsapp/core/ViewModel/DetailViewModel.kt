package com.mosalab.spacecraftsapp.core.ViewModel

import androidx.lifecycle.ViewModel
import com.mosalab.spacecraftsapp.core.Repository.SpacecraftRepository
import com.mosalab.spacecraftsapp.core.model.Spacecraft
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: SpacecraftRepository
):ViewModel(){
    fun getSpacecraftById(id: Int): Flow<Spacecraft?>{
        return repository.getSpacecrafts()
            .map { spacecrafts -> spacecrafts.find { it.id == id } }

    }
}