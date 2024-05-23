package com.example.marvel_app.feature.navigationBar.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.marvel_app.feature.navigationBar.MainNavigationBarScreenRoute

internal const val NAVIGATION_BAR_SCREEN_ROUTE = "navigation_screen_route"

fun NavGraphBuilder.mainNavigationBar() {
    composable(route = NAVIGATION_BAR_SCREEN_ROUTE) {
        MainNavigationBarScreenRoute()
    }
}