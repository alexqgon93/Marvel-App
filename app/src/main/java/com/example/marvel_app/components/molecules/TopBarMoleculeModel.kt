package com.example.marvel_app.components.molecules

data class TopBarMoleculeModel(
    val title: String,
    val onBackClick: () -> Unit,
    val enabledBackPressed: Boolean = false
)
