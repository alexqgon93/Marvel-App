package com.example.marvel_app.feature.main

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.marvel_app.feature.characters.navigation.CHARACTER_SCREEN_ROUTE
import com.example.marvel_app.feature.characters.navigation.charactersScreen
import com.example.marvel_app.feature.charactersDetail.navigation.charactersDetailScreen
import com.example.marvel_app.feature.charactersDetail.navigation.navigateToCharactersDetailScreen

const val MAIN_BOTTOM_GRAPH_ROUTE = "main_navigation_graph"

fun NavGraphBuilder.mainHomeNavGraph(navController: NavController) {
    navigation(
        startDestination = CHARACTER_SCREEN_ROUTE,
        route = MAIN_BOTTOM_GRAPH_ROUTE
    ) {
        charactersScreen(onClickCharacter = {
            navController.navigateToCharactersDetailScreen(characterId = it.id.toString())
        })
        charactersDetailScreen()
    }
}