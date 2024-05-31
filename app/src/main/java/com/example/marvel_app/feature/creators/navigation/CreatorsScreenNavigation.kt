package com.example.marvel_app.feature.creators.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.marvel_app.feature.creators.CreatorsScreenRoute


const val CREATORS_SCREEN_ROUTE = "creators_screen_route"

fun NavGraphBuilder.creatorsScreen() {
    composable(route = CREATORS_SCREEN_ROUTE) {
        CreatorsScreenRoute()
    }
}