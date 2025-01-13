package com.mosalab.spacecraftsapp.navigation

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Favorite : Routes("favorite")
    object Detail : Routes("detail")
}
