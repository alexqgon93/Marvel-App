package com.example.marvel_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.marvel_app.feature.main.MAIN_HOME_GRAPH_ROUTE
import com.example.marvel_app.feature.main.mainHomeNavGraph

@Composable
fun NavigationBarHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MAIN_HOME_GRAPH_ROUTE,
    ) {
        mainHomeNavGraph()//navController = navController)
    }
}