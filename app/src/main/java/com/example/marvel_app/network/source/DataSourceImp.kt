package com.example.marvel_app.network.source

import arrow.core.Either
import com.example.marvel_app.network.api.ApiService
import com.example.marvel_app.network.responses.charactes.NetworkCharacters
import com.example.marvel_app.network.responses.comics.NetworkComics
import com.example.marvel_app.network.utils.Failure
import com.example.marvel_app.network.utils.tryCall
import javax.inject.Inject

class DataSourceImp @Inject constructor(private val apiService: ApiService) : DataSource {
    override suspend fun getCharacters(
        offset: Int,
        limit: Int
    ): Either<Failure, NetworkCharacters> = tryCall {
        apiService.getCharacters(offset = offset, limit = limit)
    }

    override suspend fun getComics(offset: Int, limit: Int): Either<Failure, NetworkComics> =
        tryCall {
            apiService.getComics(offset = offset, limit = limit)
        }

    override suspend fun getCharacterById(characterId: String): Either<Failure, NetworkCharacters> =
        tryCall {
            apiService.getCharacterById(characterId)
        }
}