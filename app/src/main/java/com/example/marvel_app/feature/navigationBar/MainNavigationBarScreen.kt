package com.example.marvel_app.feature.navigationBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.marvel_app.components.molecules.bottomAppBar.BottomAppBarMolecule
import com.example.marvel_app.components.molecules.bottomAppBar.BottomAppBarMoleculeModel
import com.example.marvel_app.components.molecules.topBar.TopBarMolecule
import com.example.marvel_app.components.molecules.topBar.TopBarMoleculeModel
import com.example.marvel_app.feature.comics.COMICS_GRAPH_ROUTE
import com.example.marvel_app.feature.events.EVENTS_GRAPH_ROUTE
import com.example.marvel_app.feature.main.MAIN_BOTTOM_GRAPH_ROUTE
import com.example.marvel_app.navigation.NavigationBarDestinations
import com.example.marvel_app.navigation.NavigationBarHost
import com.example.marvel_app.ui.theme.MarvelAppTheme

@Composable
fun MainNavigationBarScreenRoute() = MainNavigationBarScreen()

@Composable
fun MainNavigationBarScreen(
    appState: MainNavigationBarState = rememberMainNavigationBarState()
) {
    Scaffold(
        topBar = {
            TopBarMolecule(
                model = TopBarMoleculeModel(
                    title = appState.titleHeader,
                    onBackClick = { appState.navController.popBackStack() },
                    enabledBackPressed = appState.showUpNavigation
                )
            )
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                NavigationBarHost(appState.navController)
            }
        },
        bottomBar = {
            BottomAppBarMolecule(
                model = BottomAppBarMoleculeModel(
                    destinations = appState.topLevelDestinations,
                    currentDestination = appState.currentDestination,
                    onNavigateToDestination = { item ->
                        appState.onNavItemClick(item)
                    }
                )
            )
        }
    )
}

fun NavDestination?.isTopLevelDestinationInHierarchy(destination: NavigationBarDestinations): Boolean {
    val graph = when (destination) {
        NavigationBarDestinations.CHARACTERS_SCREEN -> MAIN_BOTTOM_GRAPH_ROUTE
        NavigationBarDestinations.COMICS_SCREEN -> COMICS_GRAPH_ROUTE
        NavigationBarDestinations.EVENTS -> EVENTS_GRAPH_ROUTE
    }
    return this?.hierarchy?.any {
        it.route?.contains(graph, true) ?: false
    } ?: false
}

@Preview
@Composable
private fun MainNavigationBarScreenPreview() = MarvelAppTheme {
    MainNavigationBarScreen()
}