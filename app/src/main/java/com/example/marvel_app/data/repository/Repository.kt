package com.example.marvel_app.data.repository

import arrow.core.Either
import com.example.marvel_app.domain.common.AppError
import com.example.marvel_app.domain.models.characters.Characters
import com.example.marvel_app.domain.models.comics.Comics

interface Repository {
    suspend fun getCharacters(offset: Int, limit: Int): Either<AppError, Characters>
    suspend fun getComics(offset: Int, limit: Int): Either<AppError, Comics>
    suspend fun getCharacterById(characterId: String): Either<AppError, Characters>

}