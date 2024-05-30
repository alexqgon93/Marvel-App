package com.example.marvel_app.network.responses.events


import com.example.marvel_app.network.responses.common.NetworkImage
import com.example.marvel_app.network.responses.common.NetworkItem
import com.example.marvel_app.network.responses.common.NetworkItems
import com.example.marvel_app.network.responses.common.NetworkUrl
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkEvent(
    @Json(name = "characters")
    val characters: NetworkItems,
    @Json(name = "comics")
    val comics: NetworkItems,
    @Json(name = "creators")
    val creators: NetworkItems,
    @Json(name = "description")
    val description: String,
    @Json(name = "end")
    val end: String?,
    @Json(name = "id")
    val id: Int,
    @Json(name = "modified")
    val modified: String,
    @Json(name = "next")
    val next: NetworkItem?,
    @Json(name = "previous")
    val previous: NetworkItem?,
    @Json(name = "resourceURI")
    val resourceURI: String,
    @Json(name = "series")
    val series: NetworkItems,
    @Json(name = "start")
    val start: String?,
    @Json(name = "stories")
    val stories: NetworkItems,
    @Json(name = "thumbnail")
    val thumbnail: NetworkImage,
    @Json(name = "title")
    val title: String,
    @Json(name = "urls")
    val urls: List<NetworkUrl>
)