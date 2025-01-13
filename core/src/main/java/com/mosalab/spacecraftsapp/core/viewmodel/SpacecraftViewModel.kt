package com.mosalab.spacecraftsapp.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mosalab.spacecraftsapp.core.data.local.SpacecraftEntity
import com.mosalab.spacecraftsapp.core.domain.model.Spacecraft
import com.mosalab.spacecraftsapp.core.domain.usecase.GetFavoritesUseCase
import com.mosalab.spacecraftsapp.core.domain.usecase.GetSpacecraftsUseCase
import com.mosalab.spacecraftsapp.core.domain.usecase.ToggleFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpacecraftViewModel @Inject constructor(
    private val getSpacecraftsUseCase: GetSpacecraftsUseCase,
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase
) : ViewModel() {

    private val _spacecrafts = MutableStateFlow<List<Spacecraft>>(emptyList())
    val spacecrafts: StateFlow<List<Spacecraft>> = _spacecrafts.asStateFlow()


    private val _favorites = MutableStateFlow<List<SpacecraftEntity>>(emptyList())
    val favorites: StateFlow<List<SpacecraftEntity>> = _favorites.asStateFlow()

    init {
        loadSpacecrafts()
        loadFavorites()
    }

    private fun loadSpacecrafts() {
        viewModelScope.launch {
            getSpacecraftsUseCase.execute().collect { result ->
                _spacecrafts.value = result
            }
        }
    }

    private fun loadFavorites() {
        viewModelScope.launch {
            getFavoritesUseCase.execute().collect { result ->
                _favorites.value = result
            }
        }
    }
    fun getSpacecraftById(id: Int): Spacecraft? {
        return _spacecrafts.value.firstOrNull { it.id == id }
    }

    fun toggleFavorite(spacecraft: Spacecraft) {
        viewModelScope.launch {
            val entity = SpacecraftEntity(spacecraft.id, spacecraft.name, !spacecraft.isFavorite)
            toggleFavoriteUseCase.execute(entity)
            loadFavorites() // Refresh favorites after toggling
        }
    }
}

