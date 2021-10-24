package com.yoti.android.cryptocurrencychallenge.data.model.markets


import com.google.gson.annotations.SerializedName
import com.yoti.android.cryptocurrencychallenge.domain.model.MarketDomain

data class MarketData(
    @SerializedName("baseId")
    val baseId: String?,
    @SerializedName("baseSymbol")
    val baseSymbol: String?,
    @SerializedName("exchangeId")
    val exchangeId: String?,
    @SerializedName("percentExchangeVolume")
    val percentExchangeVolume: Any?,
    @SerializedName("priceQuote")
    val priceQuote: String?,
    @SerializedName("priceUsd")
    val priceUsd: String?,
    @SerializedName("quoteId")
    val quoteId: String?,
    @SerializedName("quoteSymbol")
    val quoteSymbol: String?,
    @SerializedName("rank")
    val rank: String?,
    @SerializedName("tradesCount24Hr")
    val tradesCount24Hr: Any?,
    @SerializedName("updated")
    val updated: Long?,
    @SerializedName("volumeUsd24Hr")
    val volumeUsd24Hr: String?
)

fun MarketData.toDomain() = MarketDomain(
    baseId = baseId,
    baseSymbol = baseSymbol,
    exchangeId = exchangeId,
    percentExchangeVolume = percentExchangeVolume,
    priceQuote = priceQuote,
    priceUsd = priceUsd,
    quoteId = quoteId,
    quoteSymbol = quoteSymbol,
    rank = rank,
    tradesCount24Hr = tradesCount24Hr,
    updated = updated,
    volumeUsd24Hr = volumeUsd24Hr,
)