package com.example.marvel_app.components.molecules.bottomAppBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.marvel_app.ui.DevicePreviews
import com.example.marvel_app.ui.theme.MarvelAppTheme

@Composable
fun BottomAppBarMolecule(model: BottomAppBarMoleculeModel) = with(model) {
    NavigationBar(
        windowInsets = NavigationBarDefaults.windowInsets,
        // containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
        // contentColor = MaterialTheme.colorScheme.onSecondary
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Filled.Face, null) },
            label = { Text(text = "Characters", color = MaterialTheme.colorScheme.onSecondary) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Default.DateRange, null) },
            label = { Text(text = "Comics") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Filled.Favorite, null) },
            label = { Text(text = "Favorites") }
        )
    }
}

@DevicePreviews
@Composable
private fun BottomAppBarMoleculePreview() = MarvelAppTheme {
    BottomAppBarMolecule(
        BottomAppBarMoleculeModel(
            title = "iusto",
            onBackClick = {},
            enabledBackPressed = false
        )
    )
}
