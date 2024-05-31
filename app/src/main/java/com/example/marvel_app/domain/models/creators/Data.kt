package com.example.marvel_app.domain.models.creators

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val creators: List<Creator>,
    val total: Int
)
