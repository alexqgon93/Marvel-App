package com.example.marvel_app.domain.models.creators

import com.example.marvel_app.domain.models.common.Items
import com.example.marvel_app.domain.models.common.Url
import com.example.marvel_app.domain.models.common.Image

data class Creator(
    val comics: Items,
    val events: Items,
    val firstName: String,
    val fullName: String,
    val id: Int,
    val lastName: String,
    val middleName: String,
    val modified: String,
    val resourceURI: String,
    val series: Items,
    val stories: Items,
    val suffix: String,
    val thumbnail: Image,
    val urls: List<Url>
)
