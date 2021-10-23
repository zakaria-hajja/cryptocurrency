package com.yoti.android.cryptocurrencychallenge.data.datasource

import com.yoti.android.cryptocurrencychallenge.data.CoincapService

class RetrofitDataSource(private val service: CoincapService) : RemoteDataSource {
    override suspend fun getAssets() = service.getAssets()
    override suspend fun getMarkets() = service.getMarkets()
}