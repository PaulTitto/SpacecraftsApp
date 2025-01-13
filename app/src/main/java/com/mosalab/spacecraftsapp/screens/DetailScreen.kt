package com.mosalab.spacecraftsapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mosalab.spacecraftsapp.core.viewmodel.SpacecraftViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    spacecraftId: Int,
    navController: NavController,
    viewModel: SpacecraftViewModel = hiltViewModel()
) {
    val spacecraft = viewModel.getSpacecraftById(spacecraftId)

    if (spacecraft != null) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(spacecraft.name) },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = spacecraft.name,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Button(onClick = { viewModel.toggleFavorite(spacecraft) }) {
                    Text(
                        text = if (spacecraft.isFavorite) "Remove from Favorites" else "Add to Favorites"
                    )
                }
            }
        }
    } else {
        Text(
            text = "Spacecraft not found.",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.fillMaxSize().wrapContentSize()
        )
    }
}

