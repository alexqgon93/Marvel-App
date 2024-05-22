package com.example.marvel_app.network.responses.comics


import com.example.marvel_app.network.responses.common.NetworkImage
import com.example.marvel_app.network.responses.common.NetworkItem
import com.example.marvel_app.network.responses.common.NetworkItems
import com.example.marvel_app.network.responses.common.NetworkStories
import com.example.marvel_app.network.responses.common.NetworkUrl
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkComic(
    @Json(name = "characters")
    val characters: NetworkCharacters,
    @Json(name = "collectedIssues")
    val collectedIssues: List<NetworkItem>,
    @Json(name = "collections")
    val collections: List<Any>,
    @Json(name = "creators")
    val creators: NetworkCreators,
    @Json(name = "dates")
    val dates: List<NetworkDate>,
    @Json(name = "description")
    val description: String,
    @Json(name = "diamondCode")
    val diamondCode: String,
    @Json(name = "digitalId")
    val digitalId: Int,
    @Json(name = "ean")
    val ean: String,
    @Json(name = "events")
    val events: NetworkItems,
    @Json(name = "format")
    val format: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "images")
    val images: List<NetworkImage>,
    @Json(name = "isbn")
    val isbn: String,
    @Json(name = "issn")
    val issn: String,
    @Json(name = "issueNumber")
    val issueNumber: Int,
    @Json(name = "modified")
    val modified: String,
    @Json(name = "pageCount")
    val pageCount: Int,
    @Json(name = "prices")
    val prices: List<NetworkPrice>,
    @Json(name = "resourceURI")
    val resourceURI: String,
    @Json(name = "series")
    val series: NetworkItem,
    @Json(name = "stories")
    val stories: NetworkStories,
    @Json(name = "textObjects")
    val textObjects: List<NetworkTextObject>,
    @Json(name = "thumbnail")
    val thumbnail: NetworkImage,
    @Json(name = "title")
    val title: String,
    @Json(name = "upc")
    val upc: String,
    @Json(name = "urls")
    val urls: List<NetworkUrl>,
    @Json(name = "variantDescription")
    val variantDescription: String,
    @Json(name = "variants")
    val variants: List<NetworkItem>
)