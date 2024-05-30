package com.example.marvel_app.network.responses.events


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkData(
    @Json(name = "count")
    val count: Int,
    @Json(name = "limit")
    val limit: Int,
    @Json(name = "offset")
    val offset: Int,
    @Json(name = "results")
    val events: List<NetworkEvent>,
    @Json(name = "total")
    val total: Int
)