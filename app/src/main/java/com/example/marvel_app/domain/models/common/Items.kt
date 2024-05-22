package com.example.marvel_app.domain.models.common

data class Items(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)
