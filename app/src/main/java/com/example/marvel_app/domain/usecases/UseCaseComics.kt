package com.example.marvel_app.domain.usecases

import arrow.core.Either
import com.example.marvel_app.data.repository.Repository
import com.example.marvel_app.domain.common.AppError
import com.example.marvel_app.domain.models.comics.Comics
import javax.inject.Inject

class UseCaseComics @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(): Either<AppError, Comics> = repository.getComics()
}