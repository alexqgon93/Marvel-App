package com.example.marvel_app.network.source

import arrow.core.Either
import com.example.marvel_app.network.responses.charactes.NetworkCharacters
import com.example.marvel_app.network.responses.comics.NetworkComics
import com.example.marvel_app.network.responses.creators.NetworkCreators
import com.example.marvel_app.network.responses.events.NetworkEvents
import com.example.marvel_app.network.utils.Failure

interface DataSource {

    suspend fun getCharacters(offset: Int, limit: Int): Either<Failure, NetworkCharacters>
    suspend fun getComics(format: String, offset: Int, limit: Int): Either<Failure, NetworkComics>
    suspend fun getCharacterById(characterId: String): Either<Failure, NetworkCharacters>
    suspend fun getCreators(): Either<Failure, NetworkCreators>
    suspend fun getEvents(): Either<Failure, NetworkEvents>
}