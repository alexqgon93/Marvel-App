package com.example.marvel_app.navigation

import com.example.marvel_app.R

enum class NavigationBarDestinations(val route: String, val icon: Int) {
    CHARACTERS_SCREEN("characters", R.drawable.ic_character),
    COMICS_SCREEN("comics", R.drawable.ic_book),
    EVENTS("events", R.drawable.ic_event),
    CREATORS("creators", R.drawable.ic_stories),
}