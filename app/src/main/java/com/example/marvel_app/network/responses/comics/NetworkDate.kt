package com.example.marvel_app.network.responses.comics


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkDate(
    @Json(name = "date")
    val date: String,
    @Json(name = "type")
    val type: String
)