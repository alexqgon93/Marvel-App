package com.example.marvel_app.network.source

import arrow.core.Either
import com.example.marvel_app.network.api.ApiService
import com.example.marvel_app.network.responses.charactes.NetworkCharacters
import com.example.marvel_app.network.responses.comics.NetworkComics
import com.example.marvel_app.network.utils.Failure
import com.example.marvel_app.network.utils.tryCall
import javax.inject.Inject

class DataSourceImp @Inject constructor(private val apiService: ApiService) : DataSource {
    override suspend fun getCharacters(): Either<Failure, NetworkCharacters> = tryCall {
        apiService.getCharacters()
    }

    override suspend fun getComics(): Either<Failure, NetworkComics> = tryCall {
        apiService.getComics()
    }

    override suspend fun getCharacterById(characterId: String): Either<Failure, NetworkCharacters> =
        tryCall {
            apiService.getCharacterById(characterId)
        }
}