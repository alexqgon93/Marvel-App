package com.example.marvel_app.network.utils

import com.example.marvel_app.network.responses.common.NetworkError
import com.example.marvel_app.network.utils.Failure.NoConnectionError
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class FailureFactory {

    companion object {
        private const val ERROR = 400
        private const val SERVER_ERROR = 200
    }

    open fun handleCode(code: Int?, message: String?, errorResponse: NetworkError?): Failure =
        when (code) {
            ERROR -> Failure.BadRequest(code, message)
            SERVER_ERROR -> Failure.ServerError(code, message)
            else -> Failure.Unknown("Unkwon Error")
        }

    open fun handleException(exception: Exception) = when (exception) {
        is UnknownHostException, is SocketTimeoutException -> NoConnectionError
        else -> NoConnectionError
    }
}