package com.example.marvel_app.network.utils

sealed interface Failure {
    data class BadRequest(val code: Int?, val message: String?) : Failure
    data class ServerError(val code: Int?, val message: String?) : Failure
    data object Connectivity : Failure
    data class Server(val code: Int) : Failure
    data class Unknown(val message: String?) : Failure
    data object NoConnectionError : Failure
}