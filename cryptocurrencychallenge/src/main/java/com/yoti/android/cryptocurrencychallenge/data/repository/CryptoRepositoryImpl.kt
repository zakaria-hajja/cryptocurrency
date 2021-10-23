package com.yoti.android.cryptocurrencychallenge.data.repository

import com.yoti.android.cryptocurrencychallenge.data.datasource.RemoteDataSource
import com.yoti.android.cryptocurrencychallenge.domain.repository.CryptoRepository

class CryptoRepositoryImpl(private val dataSource: RemoteDataSource) : CryptoRepository {
    override suspend fun getAssets() = dataSource.getAssets().assetData ?: emptyList()
    override suspend fun getMarkets() = dataSource.getMarkets().marketData ?: emptyList()
}