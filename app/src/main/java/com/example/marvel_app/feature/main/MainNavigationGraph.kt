package com.example.marvel_app.feature.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.marvel_app.feature.characters.navigation.CHARACTER_SCREEN_ROUTE
import com.example.marvel_app.feature.characters.navigation.charactersScreen

const val MAIN_HOME_GRAPH_ROUTE = "main_navigation_graph"

fun NavGraphBuilder.mainHomeNavGraph() {
    navigation(
        startDestination = CHARACTER_SCREEN_ROUTE,
        route = MAIN_HOME_GRAPH_ROUTE
    ) {
        charactersScreen()
        // ComicsScreen()
    }
}