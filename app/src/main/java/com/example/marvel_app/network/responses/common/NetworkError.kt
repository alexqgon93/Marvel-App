package com.example.marvel_app.network.responses.common


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkError(
    @Json(name = "data")
    val code: String,
    @Json(name = "message")
    val message: String
)