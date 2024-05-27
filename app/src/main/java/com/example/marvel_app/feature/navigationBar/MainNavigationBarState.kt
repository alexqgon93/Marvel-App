package com.example.marvel_app.feature.navigationBar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.marvel_app.feature.characters.navigation.CHARACTER_SCREEN_ROUTE
import com.example.marvel_app.feature.charactersDetail.navigation.CHARACTER_DETAIL_SCREEN_ROUTE
import com.example.marvel_app.feature.comics.COMICS_GRAPH_ROUTE
import com.example.marvel_app.feature.comics.navigation.COMICS_SCREEN_ROUTE
import com.example.marvel_app.feature.events.EVENTS_GRAPH_ROUTE
import com.example.marvel_app.feature.events.navigation.EVENTS_SCREEN_ROUTE
import com.example.marvel_app.feature.main.MAIN_BOTTOM_GRAPH_ROUTE
import com.example.marvel_app.navigation.NavigationBarDestinations

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

    val topLevelDestinations = NavigationBarDestinations.entries

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val titleHeader: String
        @Composable get() = when {
            currentRoute.contains(CHARACTER_SCREEN_ROUTE) -> "Characters"
            currentRoute.contains(EVENTS_SCREEN_ROUTE) -> "Events"
            currentRoute.contains(CHARACTER_DETAIL_SCREEN_ROUTE) -> "Character Detail"
            currentRoute.contains(COMICS_SCREEN_ROUTE) -> "Comics"
            else -> ""
        }

    fun onNavItemClick(route: NavigationBarDestinations) = when (route) {
        NavigationBarDestinations.CHARACTERS_SCREEN -> navController.navigatePoppingUpToStartDestination(
            MAIN_BOTTOM_GRAPH_ROUTE
        )

        NavigationBarDestinations.COMICS_SCREEN -> navController.navigatePoppingUpToStartDestination(
            COMICS_GRAPH_ROUTE
        )

        NavigationBarDestinations.EVENTS -> navController.navigatePoppingUpToStartDestination(
            EVENTS_GRAPH_ROUTE
        )
    }

    val showUpNavigation: Boolean
        @Composable get() = when (currentRoute) {
            CHARACTER_SCREEN_ROUTE,
            COMICS_SCREEN_ROUTE,
            EVENTS_SCREEN_ROUTE -> false

            else -> true
        }
}

fun NavHostController.navigatePoppingUpToStartDestination(route: String) = navigate(route) {
    popUpTo(graph.findStartDestination().id) {
        saveState = true
    }
    launchSingleTop = true
    restoreState = true
}