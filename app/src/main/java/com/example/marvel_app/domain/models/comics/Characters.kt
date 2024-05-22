package com.example.marvel_app.domain.models.comics

import com.example.marvel_app.domain.models.common.Item

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)