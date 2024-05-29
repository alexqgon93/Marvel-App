package com.example.marvel_app.domain.usecases

import arrow.core.Either
import com.example.marvel_app.data.repository.Repository
import com.example.marvel_app.domain.common.AppError
import com.example.marvel_app.domain.models.events.Events
import javax.inject.Inject

class UseCaseEvents @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(): Either<AppError, Events> = repository.getEvents()
}