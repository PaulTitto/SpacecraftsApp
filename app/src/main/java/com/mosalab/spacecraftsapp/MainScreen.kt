package com.mosalab.spacecraftsapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mosalab.spacecraftsapp.ui.screens.DetailScreen
import com.mosalab.spacecraftsapp.ui.screens.FavoriteScreen
import com.mosalab.spacecraftsapp.ui.screens.HomeScreen

@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = false,
                    onClick = { navController.navigate("home") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorite") },
                    label = { Text("Favorite") },
                    selected = false,
                    onClick = { navController.navigate("favorite") }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("favorite") { FavoriteScreen(navController) }
            composable("detail/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                id?.let { DetailScreen(it, navController) }
            }
        }
    }

}
