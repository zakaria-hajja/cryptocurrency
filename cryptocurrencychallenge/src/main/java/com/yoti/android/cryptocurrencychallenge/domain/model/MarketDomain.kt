package com.yoti.android.cryptocurrencychallenge.domain.model

data class MarketDomain(
    val baseId: String?,
    val baseSymbol: String?,
    val exchangeId: String?,
    val percentExchangeVolume: Any?,
    val priceQuote: String?,
    val priceUsd: String?,
    val quoteId: String?,
    val quoteSymbol: String?,
    val rank: String?,
    val tradesCount24Hr: Any?,
    val updated: Long?,
    val volumeUsd24Hr: String?
)