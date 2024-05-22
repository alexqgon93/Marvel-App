package com.example.marvel_app.domain.models.common

data class Item(
    val name: String,
    val resourceURI: String,
    val type: String?,
    val role: String?
)