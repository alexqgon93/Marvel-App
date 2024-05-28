package com.example.marvel_app.network.source

import arrow.core.Either
import com.example.marvel_app.network.api.ApiService
import com.example.marvel_app.network.responses.charactes.NetworkCharacters
import com.example.marvel_app.network.responses.comics.NetworkComics
import com.example.marvel_app.network.responses.creators.NetworkCreators
import com.example.marvel_app.network.responses.events.NetworkEvents
import com.example.marvel_app.network.utils.Failure
import com.example.marvel_app.network.utils.tryCall
import javax.inject.Inject

class DataSourceImp @Inject constructor(private val apiService: ApiService) : DataSource {
    override suspend fun getCharacters(): Either<Failure, NetworkCharacters> = tryCall {
        apiService.getCharacters()
    }

    override suspend fun getComics(format: String): Either<Failure, NetworkComics> = tryCall {
        apiService.getComics(format = format)
    }

    override suspend fun getCharacterById(characterId: String): Either<Failure, NetworkCharacters> =
        tryCall {
            apiService.getCharacterById(characterId)
        }

    override suspend fun getCreators(): Either<Failure, NetworkCreators> = tryCall {
        apiService.getCreators()
    }

    override suspend fun getEvents(): Either<Failure, NetworkEvents> = tryCall {
        apiService.getEvents()
    }
}