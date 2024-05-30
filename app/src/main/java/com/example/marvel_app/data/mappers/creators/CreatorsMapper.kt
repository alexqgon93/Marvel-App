package com.example.marvel_app.data.mappers.creators

import com.example.marvel_app.data.mappers.toDomainModel
import com.example.marvel_app.domain.models.creators.Creator
import com.example.marvel_app.domain.models.creators.Creators
import com.example.marvel_app.domain.models.creators.Data
import com.example.marvel_app.network.responses.creators.NetworkCreator
import com.example.marvel_app.network.responses.creators.NetworkCreators
import com.example.marvel_app.network.responses.creators.NetworkData

fun NetworkCreators.toDomainModel() = Creators(
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
    creators = creators.map { it.toDomainModel() },
    total = total
)

fun NetworkCreator.toDomainModel() = Creator(
    comics = comics.toDomainModel(),
    events = events.toDomainModel(),
    firstName = firstName,
    fullName = fullName,
    id = id,
    lastName = lastName,
    middleName = middleName,
    modified = modified,
    resourceURI = resourceURI,
    series = series.toDomainModel(),
    stories = stories.toDomainModel(),
    suffix = suffix,
    thumbnail = thumbnail.toDomainModel(),
    urls = urls.map { it.toDomainModel() }
)