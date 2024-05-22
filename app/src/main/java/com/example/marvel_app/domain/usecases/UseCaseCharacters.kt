package com.example.marvel_app.domain.usecases

import arrow.core.Either
import com.example.marvel_app.data.repository.Repository
import com.example.marvel_app.domain.common.AppError
import com.example.marvel_app.domain.models.characters.Characters
import javax.inject.Inject

class UseCaseCharacters @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(): Either<AppError, Characters> = repository.getCharacters()
}