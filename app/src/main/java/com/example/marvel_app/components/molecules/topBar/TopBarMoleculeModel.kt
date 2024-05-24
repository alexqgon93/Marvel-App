package com.example.marvel_app.components.molecules.topBar

data class TopBarMoleculeModel(
    val title: String,
    val onBackClick: () -> Unit,
    val enabledBackPressed: Boolean = false
)
