package com.example.marvel_app.network.responses.comics


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkPrice(
    @Json(name = "price")
    val price: Double,
    @Json(name = "type")
    val type: String
)