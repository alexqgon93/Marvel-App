package com.example.marvel_app.feature.navigationBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.marvel_app.components.molecules.bottomAppBar.BottomAppBarMolecule
import com.example.marvel_app.components.molecules.bottomAppBar.BottomAppBarMoleculeModel
import com.example.marvel_app.components.molecules.topBar.TopBarMolecule
import com.example.marvel_app.components.molecules.topBar.TopBarMoleculeModel
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
                    title = "mus",
                    onBackClick = {},
                    enabledBackPressed = false
                )
            )
        }
    )
}

@Preview
@Composable
private fun MainNavigationBarScreenPreview() = MarvelAppTheme {
    MainNavigationBarScreen()
}