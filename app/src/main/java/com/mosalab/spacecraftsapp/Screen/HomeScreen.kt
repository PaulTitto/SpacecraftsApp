package com.mosalab.spacecraftsapp.Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mosalab.spacecraftsapp.core.ViewModel.HomeViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val spacecrafts by viewModel.spacecrafts.collectAsState(initial = emptyList())

    LazyColumn {
        items(spacecrafts) { spacecraft ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate("detail/${spacecraft.id}") }
            ) {
                Text(spacecraft.name, Modifier.weight(1f))
                IconButton(onClick = {
                    if (spacecraft.isFavorite) {
                        viewModel.removeFavorite(spacecraft)
                    } else {
                        viewModel.addFavorite(spacecraft)
                    }
                }) {
                    Icon(
                        imageVector = if (spacecraft.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite"
                    )
                }
            }
        }
    }
}

