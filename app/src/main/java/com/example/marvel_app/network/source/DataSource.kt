package com.example.marvel_app.network.source

import arrow.core.Either
import com.example.marvel_app.network.responses.charactes.NetworkCharacters
import com.example.marvel_app.network.responses.comics.NetworkComics
import com.example.marvel_app.network.utils.Failure

interface DataSource {

    suspend fun getCharacters(offset: Int, limit: Int): Either<Failure, NetworkCharacters>
    suspend fun getComics(offset: Int, limit: Int): Either<Failure, NetworkComics>
    suspend fun getCharacterById(characterId: String): Either<Failure, NetworkCharacters>
}