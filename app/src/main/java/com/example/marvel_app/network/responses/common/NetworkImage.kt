package com.example.marvel_app.network.responses.common


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkImage(
    @Json(name = "extension")
    val extension: String,
    @Json(name = "path")
    val path: String
)