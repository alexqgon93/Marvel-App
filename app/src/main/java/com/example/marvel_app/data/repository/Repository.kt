package com.example.marvel_app.data.repository

import arrow.core.Either
import com.example.marvel_app.domain.common.AppError
import com.example.marvel_app.domain.models.characters.Characters
import com.example.marvel_app.domain.models.comics.Comics

interface Repository {
    suspend fun getCharacters(): Either<AppError, Characters>
    suspend fun getComics(): Either<AppError, Comics>

}