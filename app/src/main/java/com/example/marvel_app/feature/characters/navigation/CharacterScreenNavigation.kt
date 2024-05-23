package com.example.marvel_app.feature.characters.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.marvel_app.feature.characters.CharactersScreenRoute

const val CHARACTER_SCREEN_ROUTE = "character_screen_route"

fun NavGraphBuilder.charactersScreen() {
    composable(route = CHARACTER_SCREEN_ROUTE) {
        CharactersScreenRoute()
    }
}