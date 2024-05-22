package com.example.marvel_app.data.mappers.comics

import com.example.marvel_app.domain.models.comics.Characters
import com.example.marvel_app.domain.models.comics.Comics
import com.example.marvel_app.domain.models.comics.Data
import com.example.marvel_app.domain.models.comics.Comic
import com.example.marvel_app.data.mappers.toDomainModel
import com.example.marvel_app.domain.models.comics.Creators
import com.example.marvel_app.domain.models.comics.Date
import com.example.marvel_app.domain.models.comics.Price
import com.example.marvel_app.domain.models.comics.TextObject
import com.example.marvel_app.network.responses.comics.NetworkCharacters
import com.example.marvel_app.network.responses.comics.NetworkComics
import com.example.marvel_app.network.responses.comics.NetworkCreators
import com.example.marvel_app.network.responses.comics.NetworkData
import com.example.marvel_app.network.responses.comics.NetworkDate
import com.example.marvel_app.network.responses.comics.NetworkPrice
import com.example.marvel_app.network.responses.comics.NetworkComic
import com.example.marvel_app.network.responses.comics.NetworkTextObject

fun NetworkComics.toDomainModel() = Comics(
    attributionHTML = attributionHTML,
    attributionText = attributionText,
    code = code,
    copyright = copyright,
    data = data.toDomainModel(),
    etag = etag,
    status = status
)

fun NetworkCharacters.toDomainModel() = Characters(
    available = available,
    collectionURI = collectionURI,
    items = items.map { it.toDomainModel() },
    returned = returned
)

fun NetworkCreators.toDomainModel() = Creators(
    available = available,
    collectionURI = collectionURI,
    items = items.map { it.toDomainModel() },
    returned = returned
)

fun NetworkData.toDomainModel() = Data(
    count = count,
    limit = limit,
    offset = offset,
    results = results.map { it.toDomainModel() },
    total = total
)

fun NetworkDate.toDomainModel() = Date(
    date = date,
    type = type
)

fun NetworkPrice.toDomainModel() = Price(
    price = price,
    type = type
)

fun NetworkComic.toDomainModel() = Comic(
    characters = characters.toDomainModel(),
    collectedIssues = collectedIssues.map { it.toDomainModel() },
    collections = collections,
    creators = creators.toDomainModel(),
    dates = dates.map { it.toDomainModel() },
    description = description,
    diamondCode = diamondCode,
    digitalId = digitalId,
    ean = ean,
    events = events.toDomainModel(),
    format = format,
    id = id,
    images = images.map { it.toDomainModel() },
    isbn = isbn,
    issn = issn,
    issueNumber = issueNumber,
    modified = modified,
    pageCount = pageCount,
    prices = prices.map { it.toDomainModel() },
    resourceURI = resourceURI,
    series = series.toDomainModel(),
    stories = stories.toDomainModel(),
    textObjects = textObjects.map { it.toDomainModel() },
    thumbnail = thumbnail.toDomainModel(),
    title = title,
    upc = upc,
    urls = urls.map { it.toDomainModel() },
    variantDescription = variantDescription,
    variants = variants.map { it.toDomainModel() }
)

fun NetworkTextObject.toDomainModel() = TextObject(
    language = language,
    text = text,
    type = type
)



