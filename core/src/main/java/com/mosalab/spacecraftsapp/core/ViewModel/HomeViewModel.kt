package com.mosalab.spacecraftsapp.core.ViewModel

import androidx.lifecycle.ViewModel
import com.mosalab.spacecraftsapp.core.Repository.SpacecraftRepository
import com.mosalab.spacecraftsapp.core.model.Spacecraft
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: SpacecraftRepository
) : ViewModel() {

    private val _spacecrafts = MutableStateFlow<List<Spacecraft>>(emptyList())
    val spacecrafts: StateFlow<List<Spacecraft>> = _spacecrafts

    init {
        fetchSpacecrafts()
    }

    private fun fetchSpacecrafts() {
        viewModelScope.launch {
            repository.getSpacecrafts()
                .combine(repository.getFavorites()) { spacecrafts, favorites ->
                    spacecrafts.map { spacecraft ->
                        spacecraft.copy(isFavorite = favorites.any { it.id == spacecraft.id })
                    }
                }
                .collect { _spacecrafts.value = it }
        }
    }

    fun toggleFavorite(spacecraft: Spacecraft) {
        viewModelScope.launch {
            if (spacecraft.isFavorite) {
                repository.removeFavorite(spacecraft)
            } else {
                repository.addFavorite(spacecraft)
            }
        }
    }
}
