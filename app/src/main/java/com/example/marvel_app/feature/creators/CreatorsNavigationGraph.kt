package com.example.marvel_app.feature.creators

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.marvel_app.feature.creators.navigation.CREATORS_SCREEN_ROUTE
import com.example.marvel_app.feature.creators.navigation.creatorsScreen

internal const val CREATORS_GRAPH_ROUTE = "creators_graph_route"

fun NavGraphBuilder.creatorsNavGraph() {
    navigation(
        startDestination = CREATORS_SCREEN_ROUTE,
        route = CREATORS_GRAPH_ROUTE
    ) {
        creatorsScreen()
    }
}
