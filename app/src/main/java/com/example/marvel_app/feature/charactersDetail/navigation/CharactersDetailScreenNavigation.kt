package com.example.marvel_app.feature.charactersDetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.marvel_app.domain.models.characters.Character
import com.example.marvel_app.feature.charactersDetail.CharactersDetailScreenRoute

const val CHARACTER_DETAIL_SCREEN_ROUTE = "character_detail_screen_route"
const val CHARACTER_DETAIL_ARGUMENT = "character_detail_argument"

fun NavController.navigateToCharactersDetailScreen(
    navOptions: NavOptions? = null,
    characterId: String,
) = navigate("$CHARACTER_DETAIL_SCREEN_ROUTE/$characterId", navOptions)

fun NavGraphBuilder.charactersDetailScreen() {
    composable(
        route = "$CHARACTER_DETAIL_SCREEN_ROUTE/{$CHARACTER_DETAIL_ARGUMENT}",
        arguments = listOf(navArgument(CHARACTER_DETAIL_ARGUMENT) { type = NavType.StringType })
    ) {
        CharactersDetailScreenRoute()
    }
}