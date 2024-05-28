package com.example.marvel_app.network.api

import com.example.marvel_app.network.responses.charactes.NetworkCharacters
import com.example.marvel_app.network.responses.comics.NetworkComics
import com.example.marvel_app.network.responses.creators.NetworkCreators
import com.example.marvel_app.network.responses.events.NetworkEvents
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/v1/public/characters")
    suspend fun getCharacters(): Response<NetworkCharacters>

    @GET("/v1/public/comics")
    suspend fun getComics(
        @Query("format") format: String?
    ): Response<NetworkComics>

    @GET("/v1/public/characters/{characterId}")
    suspend fun getCharacterById(
        @Path("characterId") characterId: String
    ): Response<NetworkCharacters>

    @GET("/v1/public/events")
    suspend fun getEvents(): Response<NetworkEvents>

    @GET("/v1/public/creators")
    suspend fun getCreators(): Response<NetworkCreators>
}