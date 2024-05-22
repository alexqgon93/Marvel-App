package com.example.marvel_app.network.responses.charactes


import com.example.marvel_app.network.responses.common.NetworkImage
import com.example.marvel_app.network.responses.common.NetworkItems
import com.example.marvel_app.network.responses.common.NetworkStories
import com.example.marvel_app.network.responses.common.NetworkUrl
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkResult(
    @Json(name = "comics")
    val comics: NetworkItems,
    @Json(name = "description")
    val description: String,
    @Json(name = "events")
    val events: NetworkItems,
    @Json(name = "id")
    val id: Int,
    @Json(name = "modified")
    val modified: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "resourceURI")
    val resourceURI: String,
    @Json(name = "series")
    val series: NetworkStories,
    @Json(name = "stories")
    val stories: NetworkStories,
    @Json(name = "thumbnail")
    val thumbnail: NetworkImage,
    @Json(name = "urls")
    val urls: List<NetworkUrl>
)