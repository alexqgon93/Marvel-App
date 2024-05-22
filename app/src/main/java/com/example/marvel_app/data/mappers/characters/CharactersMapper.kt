package com.example.marvel_app.data.mappers.characters

import com.example.marvel_app.data.mappers.toDomainModel
import com.example.marvel_app.domain.models.characters.Characters
import com.example.marvel_app.domain.models.characters.Data
import com.example.marvel_app.domain.models.characters.Character
import com.example.marvel_app.network.responses.charactes.NetworkCharacters
import com.example.marvel_app.network.responses.charactes.NetworkData
import com.example.marvel_app.network.responses.charactes.NetworkCharacter

fun NetworkCharacters.toDomainModel() = Characters(
    attributionHTML = attributionHTML,
    attributionText = attributionText,
    code = code,
    copyright = copyright,
    data = data.toDomainModel(),
    etag = etag,
    status = status
)

fun NetworkData.toDomainModel() = Data(
    count = count,
    limit = limit,
    offset = offset,
    results = results.map { it.toDomainModel() },
    total = total
)

fun NetworkCharacter.toDomainModel() = Character(
    comics = comics.toDomainModel(),
    description = description,
    events = events.toDomainModel(),
    id = id,
    modified = modified,
    name = name,
    resourceURI = resourceURI,
    series = series.toDomainModel(),
    stories = stories.toDomainModel(),
    thumbnail = thumbnail.toDomainModel(),
    urls = urls.map { it.toDomainModel() }
)