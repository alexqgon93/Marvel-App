package com.example.marvel_app.network.responses.creators


import com.example.marvel_app.network.responses.common.NetworkImage
import com.example.marvel_app.network.responses.common.NetworkItems
import com.example.marvel_app.network.responses.common.NetworkUrl
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkCreator(
    @Json(name = "comics")
    val comics: NetworkItems,
    @Json(name = "events")
    val events: NetworkItems,
    @Json(name = "firstName")
    val firstName: String,
    @Json(name = "fullName")
    val fullName: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "lastName")
    val lastName: String,
    @Json(name = "middleName")
    val middleName: String,
    @Json(name = "modified")
    val modified: String,
    @Json(name = "resourceURI")
    val resourceURI: String,
    @Json(name = "series")
    val series: NetworkItems,
    @Json(name = "stories")
    val stories: NetworkItems,
    @Json(name = "suffix")
    val suffix: String,
    @Json(name = "thumbnail")
    val thumbnail: NetworkImage,
    @Json(name = "urls")
    val urls: List<NetworkUrl>
)