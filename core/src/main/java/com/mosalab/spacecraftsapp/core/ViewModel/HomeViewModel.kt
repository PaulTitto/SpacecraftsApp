package com.mosalab.spacecraftsapp.core.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mosalab.spacecraftsapp.core.Repository.SpacecraftRepository
import com.mosalab.spacecraftsapp.core.model.Spacecraft
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: SpacecraftRepository
) : ViewModel() {

    private val _spacecrafts = MutableStateFlow<List<Spacecraft>>(emptyList())
    val spacecrafts: StateFlow<List<Spacecraft>> = _spacecrafts.asStateFlow()

    init {
        fetchSpacecrafts()
    }

    private fun fetchSpacecrafts() {
        viewModelScope.launch {
            repository.getSpacecrafts()
                .combine(repository.getFavorites()) { allSpacecrafts, favoriteSpacecrafts ->
                    allSpacecrafts.map { spacecraft ->
                        spacecraft.copy(
                            isFavorite = favoriteSpacecrafts.any { it.id == spacecraft.id }
                        )
                    }
                }
                .collect { _spacecrafts.value = it }
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


