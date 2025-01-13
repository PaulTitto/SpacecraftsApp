package com.mosalab.spacecraftsapp.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mosalab.spacecraftsapp.ui.components.SpacecraftItem
import com.mosalab.spacecraftsapp.viewmodel.SpacecraftViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: SpacecraftViewModel = hiltViewModel()
    val spacecrafts by viewModel.spacecrafts.collectAsState()

    LazyColumn {
        items(spacecrafts) { spacecraft ->
            SpacecraftItem(
                spacecraft = spacecraft,
                onClick = { navController.navigate("detail/${spacecraft.id}") },
                onFavoriteClick = { viewModel.toggleFavorite(spacecraft) }
            )
        }
    }
}

