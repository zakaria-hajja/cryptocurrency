package com.yoti.android.cryptocurrencychallenge.domain.repository

import com.yoti.android.cryptocurrencychallenge.data.model.assets.AssetData
import com.yoti.android.cryptocurrencychallenge.data.model.markets.MarketData

interface CryptoRepository {
    suspend fun getAssets(): List<AssetData>
    suspend fun getMarkets(): List<MarketData>
}