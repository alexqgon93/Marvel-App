package com.example.marvel_app.components.molecules.bottomAppBar

data class BottomAppBarMoleculeModel(
    val title: String,
    val onBackClick: () -> Unit,
    val enabledBackPressed: Boolean = false
)
