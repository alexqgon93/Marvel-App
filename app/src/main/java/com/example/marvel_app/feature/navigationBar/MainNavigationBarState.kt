package com.example.marvel_app.feature.navigationBar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.marvel_app.feature.characters.navigation.CHARACTER_SCREEN_ROUTE
import com.example.marvel_app.feature.charactersDetail.navigation.CHARACTER_DETAIL_SCREEN_ROUTE

@Composable
fun rememberMainNavigationBarState(
    navController: NavHostController = rememberNavController()
): MainNavigationBarState = remember(navController) {
    MainNavigationBarState(navController)
}

@Stable
class MainNavigationBarState(
    val navController: NavHostController
) {
    private val currentRoute: String
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route
            ?: ""

    val titleHeader: String
        @Composable get() = when {
            currentRoute.contains(CHARACTER_SCREEN_ROUTE) -> "Characters"
            currentRoute.contains("Comics") -> "Comics"
            currentRoute.contains(CHARACTER_DETAIL_SCREEN_ROUTE) -> "Character Detail"
            else -> ""
        }

    val showUpNavigation: Boolean
        @Composable get() = when (currentRoute) {
            CHARACTER_SCREEN_ROUTE,
            "ComicsScreen" -> false

            else -> true
        }
}