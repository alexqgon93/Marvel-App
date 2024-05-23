package com.example.marvel_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.marvel_app.feature.navigationBar.navigation.NAVIGATION_BAR_SCREEN_ROUTE
import com.example.marvel_app.feature.navigationBar.navigation.mainNavigationBar

@Composable
internal fun RootHost() {
    val rootController = rememberNavController()
    NavHost(navController = rootController, startDestination = NAVIGATION_BAR_SCREEN_ROUTE) {
        mainNavigationBar()
    }
}