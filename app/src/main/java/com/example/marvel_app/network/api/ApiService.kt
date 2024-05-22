package com.example.marvel_app.network.api

import com.example.marvel_app.network.responses.charactes.NetworkCharacters
import com.example.marvel_app.network.responses.comics.NetworkComics
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/v1/public/characters")
    suspend fun getCharacters(): Response<NetworkCharacters>

    @GET("/v1/public/comics")
    suspend fun getComics(): Response<NetworkComics>

   /* @GET("/v1/public/creators")
    suspend fun getCreators(): Response<NetworkCreators>*/
}