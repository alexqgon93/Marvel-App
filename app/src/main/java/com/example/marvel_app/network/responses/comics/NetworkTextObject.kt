package com.example.marvel_app.network.responses.comics


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkTextObject(
    @Json(name = "language")
    val language: String,
    @Json(name = "text")
    val text: String,
    @Json(name = "type")
    val type: String
)