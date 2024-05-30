package com.example.marvel_app.domain.models.characters

import com.example.marvel_app.domain.models.common.Image
import com.example.marvel_app.domain.models.common.Items
import com.example.marvel_app.domain.models.common.Url

data class Character(
    val comics: Items,
    val description: String,
    val events: Items,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Items,
    val stories: Items,
    val thumbnail: Image,
    val urls: List<Url>
)