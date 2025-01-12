package com.mosalab.spacecraftsapp.favorite

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun FavoriteScreen(navController: NavController, viewModel: com.mosalab.spacecraftsapp.core.ViewModel.FavoriteViewModel = hiltViewModel()) {
    val favorites by viewModel.favorites.collectAsState(initial = emptyList())

    LazyColumn {
        items(favorites) { spacecraft ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate("detail/${spacecraft.id}") }
            ) {
                Text(spacecraft.name, Modifier.weight(1f))
                IconButton(onClick = { viewModel.removeFavorite(spacecraft) }) {
                    Icon(Icons.Default.Favorite, contentDescription = "Remove from favorites")
                }
            }
        }
    }
}

