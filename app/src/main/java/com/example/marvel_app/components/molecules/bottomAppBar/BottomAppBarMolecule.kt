package com.example.marvel_app.components.molecules.bottomAppBar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.example.marvel_app.feature.navigationBar.isTopLevelDestinationInHierarchy
import com.example.marvel_app.feature.toStringResource
import com.example.marvel_app.navigation.NavigationBarDestinations
import com.example.marvel_app.ui.DevicePreviews
import com.example.marvel_app.ui.theme.MarvelAppTheme

@Composable
fun BottomAppBarMolecule(model: BottomAppBarMoleculeModel) = with(model) {
    NavigationBar(
        windowInsets = NavigationBarDefaults.windowInsets
    ) {
        destinations.forEach { item ->
            val isSelected = currentDestination.isTopLevelDestinationInHierarchy(item)
            NavigationBarItem(
                selected = isSelected,
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = item.icon),
                        contentDescription = item.name
                    )
                },
                label = {
                    Text(text = stringResource(id = item.toStringResource()))
                },
                onClick = { onNavigateToDestination(item) }
            )
        }
    }
}

@DevicePreviews
@Composable
private fun BottomAppBarMoleculePreview() = MarvelAppTheme {
    BottomAppBarMolecule(
        BottomAppBarMoleculeModel(
            destinations = listOf(
                NavigationBarDestinations.CHARACTERS_SCREEN,
                NavigationBarDestinations.COMICS_SCREEN,
                NavigationBarDestinations.EVENTS,
                NavigationBarDestinations.CREATORS
            ),
            currentDestination = null,
            onNavigateToDestination = { }
        )
    )
}
