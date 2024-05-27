package com.example.marvel_app.domain.models.events

import com.example.marvel_app.domain.models.common.Image
import com.example.marvel_app.domain.models.common.Item
import com.example.marvel_app.domain.models.common.Items
import com.example.marvel_app.domain.models.common.Url

data class Event(
    val characters: Items,
    val comics: Items,
    val creators: Items,
    val description: String,
    val end: String?,
    val id: Int,
    val modified: String,
    val next: Item?,
    val previous: Item?,
    val resourceURI: String,
    val series: Items,
    val start: String?,
    val stories: Items,
    val thumbnail: Image,
    val title: String,
    val urls: List<Url>
)
