package com.yoti.android.cryptocurrencychallenge.commons

sealed class Resource<T>(
    val data: T? = null,
    val cause: Exception.Cause? = null
) {
    class Success<T>(data: T?) : Resource<T>(data = data)
    class Exception<T>(cause: Cause?) : Resource<T>(cause = cause) {
        sealed class Cause {
            object NoInternetConnectionCause : Cause()
            object HttpCause : Cause()
            object UnknownCause : Cause()
        }
    }

    class Loading<T> : Resource<T>()
}