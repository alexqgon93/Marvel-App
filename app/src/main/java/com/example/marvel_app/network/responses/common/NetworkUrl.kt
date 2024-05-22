package com.example.marvel_app.network.responses.common


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkUrl(
    @Json(name = "type")
    val type: String,
    @Json(name = "url")
    val url: String
)