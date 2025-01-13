package com.mosalab.spacecraftsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mosalab.spacecraftsapp.ui.screens.DetailScreen
import com.mosalab.spacecraftsapp.ui.screens.FavoriteScreen
import com.mosalab.spacecraftsapp.ui.screens.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) { HomeScreen(navController) }
        composable(Routes.Favorite.route) { FavoriteScreen(navController) }
        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            if (id != null) {
                DetailScreen(spacecraftId = id, navController = navController)
            }
        }

    }
}
