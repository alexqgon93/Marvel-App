package com.example.marvel_app.network.responses.comics


import com.example.marvel_app.network.responses.common.NetworkItem
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkCreators(
    @Json(name = "available")
    val available: Int,
    @Json(name = "collectionURI")
    val collectionURI: String,
    @Json(name = "items")
    val items: List<NetworkItem>,
    @Json(name = "returned")
    val returned: Int
)