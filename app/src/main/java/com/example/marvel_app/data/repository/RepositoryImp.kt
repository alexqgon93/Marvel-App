package com.example.marvel_app.data.repository

import arrow.core.Either
import com.example.marvel_app.data.mappers.characters.toDomainModel
import com.example.marvel_app.data.mappers.comics.toDomainModel
import com.example.marvel_app.data.mappers.creators.toDomainModel
import com.example.marvel_app.data.mappers.events.toDomainModel
import com.example.marvel_app.data.utils.mapResult
import com.example.marvel_app.domain.common.AppError
import com.example.marvel_app.domain.models.characters.Characters
import com.example.marvel_app.domain.models.comics.Comics
import com.example.marvel_app.domain.models.creators.Creators
import com.example.marvel_app.domain.models.events.Events
import com.example.marvel_app.network.source.DataSource
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val dataSource: DataSource,
) : Repository {
    override suspend fun getCharacters(): Either<AppError, Characters> =
        dataSource.getCharacters().mapResult { it.toDomainModel() }

    override suspend fun getComics(format: String): Either<AppError, Comics> =
        dataSource.getComics(format = format).mapResult { it.toDomainModel() }

    override suspend fun getCharacterById(characterId: String): Either<AppError, Characters> =
        dataSource.getCharacterById(characterId).mapResult { it.toDomainModel() }

    override suspend fun getCreators(): Either<AppError, Creators> =
        dataSource.getCreators().mapResult { it.toDomainModel() }

    override suspend fun getEvents(): Either<AppError, Events> =
        dataSource.getEvents().mapResult { it.toDomainModel() }
}