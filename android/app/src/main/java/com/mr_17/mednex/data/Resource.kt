package com.mr_17.mednex.data

sealed class Resource<T>(val data: T? = null, val message: String? = null, val code: Int? = null) {
    class Success<T>(data: T) : Resource<T>(data = data)

    class Error<T>(message: String = "An unknown error occurred") :
        Resource<T>(message = message)

    class Loading<T> : Resource<T>()
}
