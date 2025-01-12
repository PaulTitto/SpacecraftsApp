package com.mosalab.spacecraftsapp.core.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mosalab.spacecraftsapp.core.Repository.SpacecraftRepository
import com.mosalab.spacecraftsapp.core.model.Spacecraft
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repository: SpacecraftRepository
) : ViewModel() {
    val favorites = repository.getFavorites().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun removeFavorite(spacecraft: Spacecraft) {
        viewModelScope.launch {
            repository.removeFavorite(spacecraft)
        }
    }
}
