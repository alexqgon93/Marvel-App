package com.example.marvel_app.navigation

import com.example.marvel_app.R

enum class NavigationBarDestinations(val route: String, val icon: Int) {
    CHARACTERS_SCREEN("characters_screen", R.drawable.ic_character),
    COMICS_SCREEN("comics_screen", R.drawable.ic_book),
    EVENTS("menu", R.drawable.ic_event),
}