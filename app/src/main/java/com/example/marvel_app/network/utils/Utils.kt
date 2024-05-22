package com.example.marvel_app.network.utils

import arrow.core.Either
import arrow.core.left
import com.example.marvel_app.network.responses.common.NetworkError
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

suspend fun <T> tryCall(call: suspend () -> Response<T>): Either<Failure, T> {
    return try {
        call().safeCall()
    } catch (ex: Exception) {
        ex.toError().left()
    }
}

fun <T> Response<T>.safeCall(errorFactory: FailureFactory = FailureFactory()): Either<Failure, T> {
    return try {
        val response = this
        val baseResponse = response.body()
        val errorBody = response.getErrorBody()
        when (response.isSuccessful && baseResponse != null) {
            true -> Either.Right(baseResponse)
            else -> Either.Left(
                errorFactory.handleCode(
                    code = response.code(),
                    message = response.message(),
                    errorResponse = errorBody
                )
            )
        }
    } catch (exception: Exception) {
        Either.Left(errorFactory.handleException(exception))
    }
}

fun <T> Response<T>.getErrorBody(): NetworkError? {
    val errorBody = errorBody()?.string()
    if (errorBody != null) {
        val moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<NetworkError> = moshi.adapter(NetworkError::class.java)
        return adapter.fromJson(
            errorBody
        )
    }
    return null
}

fun Throwable.toError(): Failure = when (this) {
    is IOException -> Failure.Connectivity
    is HttpException -> Failure.Server(code())
    else -> Failure.Unknown(message ?: "")
}

private fun md5(stringToHash: String): String {
    val md5 = "MD5"

    try {
        val digest = MessageDigest.getInstance(md5)
        digest.update(stringToHash.toByteArray())
        val messageDigest = digest.digest()

        val hexString = StringBuilder()
        for (aMessageDigest in messageDigest) {
            var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
            while (h.length < 2) {
                h = "0$h"
            }
            hexString.append(h)
        }
        return hexString.toString()

    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }

    return ""
}

fun generateHash(time: Long, privateKey: String, publicKey: String): String =
    md5(time.toString() + privateKey + publicKey)