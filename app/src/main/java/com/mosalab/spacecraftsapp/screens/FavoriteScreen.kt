package com.mosalab.spacecraftsapp.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mosalab.spacecraftsapp.core.viewmodel.SpacecraftViewModel

@Composable
fun FavoriteScreen(navController: NavController) {
    val viewModel: SpacecraftViewModel = hiltViewModel()
    val favorites by viewModel.favorites.collectAsState()

    LazyColumn {
        items(favorites) { spacecraft ->
            Text(spacecraft.name)
        }
    }
}
