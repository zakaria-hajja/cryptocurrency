package com.yoti.android.cryptocurrencychallenge.data.datasource

import com.yoti.android.cryptocurrencychallenge.data.model.assets.AssetsApiData
import com.yoti.android.cryptocurrencychallenge.data.model.markets.MarketsApiData

interface RemoteDataSource {
    suspend fun getAssets(): AssetsApiData
    suspend fun getMarkets(): MarketsApiData

}