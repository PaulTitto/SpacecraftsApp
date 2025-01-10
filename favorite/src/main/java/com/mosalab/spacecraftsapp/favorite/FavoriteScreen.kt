package com.mosalab.spacecraftsapp.favorite

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FavoriteScreen(navController: NavController, viewModel: FavoriteViewModel = hiltViewModel()) {
    val favorites by viewModel.favorites.collectAsState(initial = emptyList())

    LazyColumn {
        items(favorites) { favorite ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate("detail/${favorite.id}") }
            ) {
                Text(favorite.name, Modifier.weight(1f))
                IconButton(onClick = { viewModel.removeFromFavorites(favorite) }) {
                    Icon(Icons.Default.Favorite, contentDescription = "Remove from favorites")
                }
            }
        }
    }
}
