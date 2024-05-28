package com.example.marvel_app.data.repository

import arrow.core.Either
import com.example.marvel_app.domain.common.AppError
import com.example.marvel_app.domain.models.characters.Characters
import com.example.marvel_app.domain.models.comics.Comics
import com.example.marvel_app.domain.models.creators.Creators
import com.example.marvel_app.domain.models.events.Events

interface Repository {
    suspend fun getCharacters(): Either<AppError, Characters>
    suspend fun getComics(format: String): Either<AppError, Comics>
    suspend fun getCharacterById(characterId: String): Either<AppError, Characters>
    suspend fun getCreators(): Either<AppError, Creators>
    suspend fun getEvents(): Either<AppError, Events>

}