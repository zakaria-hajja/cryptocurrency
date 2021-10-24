package com.yoti.android.cryptocurrencychallenge.presentation

import android.content.Context
import com.yoti.android.cryptocurrencychallenge.R
import com.yoti.android.cryptocurrencychallenge.commons.Resource

object Utils {

    fun resolveErrorMessage(ctx: Context, cause: Resource.Exception.Cause): String {
        return when (cause) {
            is Resource.Exception.Cause.UnknownCause -> ctx.getString(R.string.unknown_error)
            is Resource.Exception.Cause.NoInternetConnectionCause -> ctx.getString(R.string.no_internet_error)
            is Resource.Exception.Cause.HttpCause -> ctx.getString(R.string.too_many_request_error)
        }
    }
}