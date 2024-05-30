package com.example.marvel_app.feature.events

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.marvel_app.feature.events.navigation.EVENTS_SCREEN_ROUTE
import com.example.marvel_app.feature.events.navigation.eventsScreen

internal const val EVENTS_GRAPH_ROUTE = "events_graph_route"

fun NavGraphBuilder.eventsNavGraph() = navigation(
    startDestination = EVENTS_SCREEN_ROUTE,
    route = EVENTS_GRAPH_ROUTE
) {
    eventsScreen()
}