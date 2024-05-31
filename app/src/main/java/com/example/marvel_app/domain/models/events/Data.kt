package com.example.marvel_app.domain.models.events

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val events: List<Event>,
    val total: Int
)
