package com.yoti.android.cryptocurrencychallenge.domain.usecase

import com.yoti.android.cryptocurrencychallenge.data.model.assets.AssetData
import com.yoti.android.cryptocurrencychallenge.data.model.assets.AssetsApiData
import com.yoti.android.cryptocurrencychallenge.data.model.markets.MarketData
import com.yoti.android.cryptocurrencychallenge.data.model.markets.MarketsApiData
import com.yoti.android.cryptocurrencychallenge.domain.model.AssetDomain
import com.yoti.android.cryptocurrencychallenge.domain.model.MarketDomain
import com.yoti.android.cryptocurrencychallenge.presentation.assets.AssetUiItem
import com.yoti.android.cryptocurrencychallenge.presentation.market.MarketUiModel

val dummyBitcoinMarkets = listOf(
    MarketData(
        baseId = "bitcoin",
        baseSymbol = "BTC",
        exchangeId = "bitstamp",
        percentExchangeVolume = "67.2199253376108585",
        priceQuote = "6927.3300000000000000",
        volumeUsd24Hr = "43341291.9576547008000000",
        quoteId = "united-states-dollar",
        tradesCount24Hr = 420721,
        updated = 1533581033590,
        quoteSymbol = "USD",
        priceUsd = "6927.3300000000000000",
        rank = "1"
    ),
    MarketData(
        baseId = "bitcoin",
        baseSymbol = "BTC",
        exchangeId = "hitbtc",
        percentExchangeVolume = "22.8693492128634858",
        priceQuote = "6941.4400000000000000",
        volumeUsd24Hr = "57814559.6160000000000000",
        quoteId = "united-states-dollar",
        tradesCount24Hr = 11827,
        updated = 1533581015313,
        quoteSymbol = "USD",
        priceUsd = "6941.4400000000000000",
        rank = "1"
    ),
    MarketData(
        baseId = "bitcoin",
        baseSymbol = "BTC",
        exchangeId = "acx",
        percentExchangeVolume = "76.3351850007240360",
        priceQuote = "9357.0500000000000000",
        volumeUsd24Hr = "934880.2520612808644314",
        quoteId = "australian-dollar",
        tradesCount24Hr = 256,
        updated = 1533581026840,
        quoteSymbol = "AUD",
        priceUsd = "6942.3227164910630424",
        rank = "1"
    ),
    MarketData(
        baseId = "bitcoin",
        baseSymbol = "BTC",
        exchangeId = "btctradeua",
        percentExchangeVolume = "43.2161016383075345",
        priceQuote = "183944.9299327354000000",
        volumeUsd24Hr = "46311.8964988674459445",
        quoteId = "ukrainian-hryvnia",
        tradesCount24Hr = 1279,
        updated = 1533581056888,
        quoteSymbol = "UAH",
        priceUsd = "6927.3300000000000000",
        rank = "1"
    )
)

val dummyAssetApiData = AssetsApiData(
    listOf(
        AssetData(
            changePercent24Hr = "43.2161016383075345",
            explorer = null,
            id = "bitcoin",
            marketCapUsd = "6942.3227164910630424",
            maxSupply = "6942.3227164910630424",
            name = "Bitoin",
            priceUsd = "6942.3227164910630424",
            rank = "1",
            supply = "101160540.0000000000000000",
            symbol = "BTC",
            volumeUsd24Hr = "101160540.0000000000000000",
            vwap24Hr = null
        )
    ), 1533581056888
)

val dummyMarketApiData = MarketsApiData(
    listOf(
        MarketData(
            baseId = "bitcoin",
            baseSymbol = "BTC",
            exchangeId = "acx",
            percentExchangeVolume = "76.3351850007240360",
            priceQuote = "9357.0500000000000000",
            volumeUsd24Hr = "934880.2520612808644314",
            quoteId = "australian-dollar",
            tradesCount24Hr = 256,
            updated = 1533581026840,
            quoteSymbol = "AUD",
            priceUsd = "6942.3227164910630424",
            rank = "1"
        )
    ), 1533581056888
)

val dummyMarketData = MarketData(
    baseId = "bitcoin",
    baseSymbol = "BTC",
    exchangeId = "acx",
    percentExchangeVolume = "76.3351850007240360",
    priceQuote = "9357.0500000000000000",
    volumeUsd24Hr = "934880.2520612808644314",
    quoteId = "australian-dollar",
    tradesCount24Hr = 256,
    updated = 1533581026840,
    quoteSymbol = "AUD",
    priceUsd = "6942.3227164910630424",
    rank = "1"
)
val dummyMarketDomain = MarketDomain(
    baseId = "bitcoin",
    baseSymbol = "BTC",
    exchangeId = "acx",
    percentExchangeVolume = "76.3351850007240360",
    priceQuote = "9357.0500000000000000",
    volumeUsd24Hr = "934880.2520612808644314",
    quoteId = "australian-dollar",
    tradesCount24Hr = 256,
    updated = 1533581026840,
    quoteSymbol = "AUD",
    priceUsd = "6942.3227164910630424",
    rank = "1"
)
val dummyNullMarketDomain = MarketDomain(
    baseId = "bitcoin",
    baseSymbol = "BTC",
    exchangeId = null,
    percentExchangeVolume = "76.3351850007240360",
    priceQuote = "9357.0500000000000000",
    volumeUsd24Hr = "934880.2520612808644314",
    quoteId = "australian-dollar",
    tradesCount24Hr = 256,
    updated = null,
    quoteSymbol = "AUD",
    priceUsd = null,
    rank = null
)

val dummyMarketUi = MarketUiModel(
    exchangeId = "acx",
    date = "06/08/2018",
    price = "$6,942.32",
    rank = "1"
)
val dummyEmptyMarketUi = MarketUiModel(
    exchangeId = "",
    date = "",
    price = "",
    rank = ""
)

val dummyAssetData = AssetData(
    changePercent24Hr = "43.2161016383075345",
    explorer = null,
    id = "bitcoin",
    marketCapUsd = "6942.3227164910630424",
    maxSupply = "6942.3227164910630424",
    name = "Bitoin",
    priceUsd = "6942.3227164910630424",
    rank = "1",
    supply = "101160540.0000000000000000",
    symbol = "BTC",
    volumeUsd24Hr = "101160540.0000000000000000",
    vwap24Hr = null
)

val dummyAssetDomain = AssetDomain(
    changePercent24Hr = "43.2161016383075345",
    explorer = null,
    id = "bitcoin",
    marketCapUsd = "6942.3227164910630424",
    maxSupply = "6942.3227164910630424",
    name = "Bitoin",
    priceUsd = "6942.3227164910630424",
    rank = "1",
    supply = "101160540.0000000000000000",
    symbol = "BTC",
    volumeUsd24Hr = "101160540.0000000000000000",
    vwap24Hr = null
)
val dummyNullAssetDomain = AssetDomain(
    changePercent24Hr = "43.2161016383075345",
    explorer = null,
    id = null,
    marketCapUsd = "6942.3227164910630424",
    maxSupply = "6942.3227164910630424",
    name = null,
    priceUsd = null,
    rank = "1",
    supply = "101160540.0000000000000000",
    symbol = null,
    volumeUsd24Hr = "101160540.0000000000000000",
    vwap24Hr = null
)


val dummyAssetUI = AssetUiItem(
    id = "bitcoin",
    name = "Bitoin",
    price = "$6,942.32",
    symbol = "BTC",
)

val dummyEmptyAssetUI = AssetUiItem(
    id = "",
    name = "",
    price = "",
    symbol = "",
)


