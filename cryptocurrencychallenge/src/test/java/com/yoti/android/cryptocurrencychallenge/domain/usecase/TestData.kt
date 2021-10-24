package com.yoti.android.cryptocurrencychallenge.domain.usecase

import com.yoti.android.cryptocurrencychallenge.data.model.markets.MarketData

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