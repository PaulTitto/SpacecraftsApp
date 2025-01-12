package com.mosalab.spacecraftsapp.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mosalab.spacecraftsapp.core.ViewModel.DetailViewModel


@Composable
fun DetailScreen(
    id: String,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val spacecraft by viewModel.spacecraft.collectAsState(initial = null)

    LaunchedEffect(id) {
        viewModel.fetchSpacecraftById(id.toInt())
    }

    spacecraft?.let { spacecraft ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = spacecraft.name,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "ID: ${spacecraft.id}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            IconButton(
                onClick = {
                    if (spacecraft.isFavorite) {
                        viewModel.removeFavorite(spacecraft)
                    } else {
                        viewModel.addFavorite(spacecraft)
                    }
                }
            ) {
                Icon(
                    imageVector = if (spacecraft.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite"
                )
            }
        }
    } ?: run {
        CircularProgressIndicator(modifier = Modifier.fillMaxSize())
    }
}
