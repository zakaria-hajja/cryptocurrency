package com.yoti.android.cryptocurrencychallenge.commons

import com.yoti.android.cryptocurrencychallenge.data.model.assets.AssetData
import com.yoti.android.cryptocurrencychallenge.data.model.markets.MarketData
import com.yoti.android.cryptocurrencychallenge.domain.model.AssetDomain
import com.yoti.android.cryptocurrencychallenge.domain.model.MarketDomain
import com.yoti.android.cryptocurrencychallenge.presentation.assets.AssetUiItem
import com.yoti.android.cryptocurrencychallenge.presentation.market.MarketUiModel
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

object Mappers {
    fun AssetData.toDomain() = AssetDomain(
        changePercent24Hr = changePercent24Hr,
        explorer = explorer,
        id = id,
        marketCapUsd = marketCapUsd,
        maxSupply = maxSupply,
        name = name,
        priceUsd = priceUsd,
        rank = rank,
        supply = supply,
        symbol = symbol,
        volumeUsd24Hr = volumeUsd24Hr,
        vwap24Hr = vwap24Hr,
    )

    fun AssetDomain.toUi(): AssetUiItem {
        val formatter = DecimalFormat("$#,###.##")
        val price = priceUsd?.let {
            formatter.format(priceUsd.toDouble()).trim()
        } ?: run {
            ""
        }
        return AssetUiItem(
            id = id ?: "",
            symbol = symbol ?: "",
            name = name ?: "",
            price = price
        )

    }

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

    fun MarketDomain.toUi(): MarketUiModel {
        val formatter = DecimalFormat("$#,###.##")
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")

        val price = priceUsd?.let {
            formatter.format(priceUsd.toDouble()).trim()
        } ?: run {
            ""
        }

        val date = updated?.let {
            dateFormat.format(Date(updated))
        } ?: run {
            ""
        }
        return MarketUiModel(
            exchangeId = exchangeId ?: "",
            rank = rank ?: "",
            price = price,
            date = date
        )
    }
}