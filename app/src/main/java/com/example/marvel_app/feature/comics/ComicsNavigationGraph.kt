package com.example.marvel_app.feature.comics

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.marvel_app.feature.comics.navigation.COMICS_SCREEN_ROUTE
import com.example.marvel_app.feature.comics.navigation.comicsScreen

internal const val COMICS_GRAPH_ROUTE = "comics_graph_route"

fun NavGraphBuilder.comicsNavGraph() {
    navigation(
        startDestination = COMICS_SCREEN_ROUTE,
        route = COMICS_GRAPH_ROUTE
    ) {
        comicsScreen()
    }
}