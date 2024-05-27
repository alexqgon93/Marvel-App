package com.example.marvel_app.data.mappers

import com.example.marvel_app.domain.models.common.Image
import com.example.marvel_app.domain.models.common.Item
import com.example.marvel_app.domain.models.common.Items
import com.example.marvel_app.domain.models.common.Url
import com.example.marvel_app.network.responses.common.NetworkImage
import com.example.marvel_app.network.responses.common.NetworkItem
import com.example.marvel_app.network.responses.common.NetworkItems
import com.example.marvel_app.network.responses.common.NetworkUrl

fun NetworkImage.toDomainModel() = Image(extension = extension, path = path)

fun NetworkItem.toDomainModel() = Item(
    name = name,
    resourceURI = resourceURI,
    type = type,
    role = role
)

fun NetworkItems.toDomainModel() = Items(
    available = available,
    collectionURI = collectionURI,
    items = items.map { it.toDomainModel() },
    returned = returned
)

fun NetworkUrl.toDomainModel() = Url(
    type = type,
    url = url
)