package com.example.marvel_app.data.mappers.events

import com.example.marvel_app.data.mappers.toDomainModel
import com.example.marvel_app.domain.models.events.Data
import com.example.marvel_app.domain.models.events.Event
import com.example.marvel_app.domain.models.events.Events
import com.example.marvel_app.network.responses.events.NetworkData
import com.example.marvel_app.network.responses.events.NetworkEvent
import com.example.marvel_app.network.responses.events.NetworkEvents

fun NetworkEvents.toDomainModel() = Events(
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
    events = events.map { it.toDomainModel() },
    total = total
)

fun NetworkEvent.toDomainModel() = Event(
    characters = characters.toDomainModel(),
    comics = comics.toDomainModel(),
    creators = creators.toDomainModel(),
    description = description,
    end = end,
    id = id,
    modified = modified,
    next = next.toDomainModel(),
    previous = previous.toDomainModel(),
    resourceURI = resourceURI,
    series = series.toDomainModel(),
    start = start,
    stories = stories.toDomainModel(),
    thumbnail = thumbnail.toDomainModel(),
    title = title,
    urls = urls.map { it.toDomainModel() }
)

