package com.example.marvel_app.components.molecules.bottomAppBar

import androidx.navigation.NavDestination
import com.example.marvel_app.navigation.NavigationBarDestinations

data class BottomAppBarMoleculeModel(
    val destinations: List<NavigationBarDestinations>,
    val currentDestination: NavDestination?,
    val onNavigateToDestination: (NavigationBarDestinations) -> Unit
)
