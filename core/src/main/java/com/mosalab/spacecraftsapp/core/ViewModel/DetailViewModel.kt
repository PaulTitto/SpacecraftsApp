package com.mosalab.spacecraftsapp.core.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mosalab.spacecraftsapp.core.Repository.SpacecraftRepository
import com.mosalab.spacecraftsapp.core.model.Spacecraft
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: SpacecraftRepository
) : ViewModel() {

    private val _spacecraft = MutableStateFlow<Spacecraft?>(null)
    val spacecraft: StateFlow<Spacecraft?> = _spacecraft.asStateFlow()

    fun fetchSpacecraftById(id: Int) {
        viewModelScope.launch {
            val allSpacecrafts = repository.getSpacecrafts().firstOrNull() ?: emptyList()
            val spacecraft = allSpacecrafts.find { it.id == id }
            _spacecraft.value = spacecraft
        }
    }

    fun addFavorite(spacecraft: Spacecraft) {
        viewModelScope.launch {
            repository.addFavorite(spacecraft)
        }
    }

    fun removeFavorite(spacecraft: Spacecraft) {
        viewModelScope.launch {
            repository.removeFavorite(spacecraft)
        }
    }
}
