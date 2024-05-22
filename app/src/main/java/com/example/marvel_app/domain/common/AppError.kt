package com.example.marvel_app.domain.common

sealed interface AppError {
    data class BadRequest(val message: String?) : AppError
    data class ServerError(val message: String?) : AppError
    data class Unknown(val message: String?) : AppError
    data object Connectivity : AppError
    data object Server : AppError
    data object NoConnectionError : AppError
}