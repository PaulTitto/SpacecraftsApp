package com.mosalab.spacecraftsapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.hilt.navigation.compose.hiltViewModel
import com.mosalab.spacecraftsapp.Screen.DetailScreen
import com.mosalab.spacecraftsapp.Screen.HomeScreen
import com.mosalab.spacecraftsapp.core.ViewModel.DetailViewModel
import com.mosalab.spacecraftsapp.core.ViewModel.HomeViewModel
import com.mosalab.spacecraftsapp.favorite.FavoriteScreen

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("home") },
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("favorites") },
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") {
                // Menggunakan Hilt untuk mendapatkan ViewModel
                val viewModel: HomeViewModel = hiltViewModel()
                HomeScreen(navController, viewModel)
            }
            composable("favorites") { FavoriteScreen(navController) }
            composable("detail/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id") ?: ""
                val viewModel: DetailViewModel = hiltViewModel()
                DetailScreen(id, viewModel)
            }
        }
    }
}
