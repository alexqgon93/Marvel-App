package com.example.marvel_app.feature.comics.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.marvel_app.feature.comics.ComicsScreenRoute


const val COMICS_SCREEN_ROUTE = "comics_screen_route"

fun NavGraphBuilder.comicsScreen() {
    composable(route = COMICS_SCREEN_ROUTE) {
        ComicsScreenRoute()
    }
}