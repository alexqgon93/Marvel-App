package com.example.marvel_app.feature.navigationBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.marvel_app.components.molecules.TopBarMolecule
import com.example.marvel_app.components.molecules.TopBarMoleculeModel
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
                    onBackClick = {},
                    enabledBackPressed = appState.showUpNavigation
                )
            )
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                NavigationBarHost(appState.navController)
            }
        },
        bottomBar = {}
    )
}

@Preview
@Composable
private fun MainNavigationBarScreenPreview() = MarvelAppTheme {
    MainNavigationBarScreen()
}