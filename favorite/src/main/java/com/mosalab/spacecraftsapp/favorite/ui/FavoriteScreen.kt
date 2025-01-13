package com.mosalab.spacecraftsapp.favorite.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mosalab.spacecraftsapp.core.viewmodel.SpacecraftViewModel

@Composable
fun FavoriteScreen(navController: NavController) {
    val viewModel: SpacecraftViewModel = hiltViewModel()
    val favorites = viewModel.favorites.collectAsState()

    LazyColumn {
        items(favorites.value) { spacecraft ->
            Text(spacecraft.name)
        }
    }
}