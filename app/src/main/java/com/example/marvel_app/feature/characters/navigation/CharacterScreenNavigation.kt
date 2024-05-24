package com.example.marvel_app.feature.characters.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.marvel_app.domain.models.characters.Character
import com.example.marvel_app.feature.characters.CharactersScreenRoute

const val CHARACTER_SCREEN_ROUTE = "character_screen_route"

fun NavGraphBuilder.charactersScreen( onClickCharacter: (Character) -> Unit) {
    composable(route = CHARACTER_SCREEN_ROUTE) {
        CharactersScreenRoute(
            onClickCharacter = {
                onClickCharacter(it)
            }
        )
    }
}