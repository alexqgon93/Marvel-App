package com.example.marvel_app.feature.events.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.marvel_app.feature.events.EventsScreenRoute

const val EVENTS_SCREEN_ROUTE = "events_screen_route"

fun NavGraphBuilder.eventsScreen() {
    composable(route = EVENTS_SCREEN_ROUTE) {
        EventsScreenRoute()
    }
}