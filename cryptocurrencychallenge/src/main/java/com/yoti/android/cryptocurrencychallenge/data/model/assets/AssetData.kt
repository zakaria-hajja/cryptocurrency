package com.yoti.android.cryptocurrencychallenge.data.model.assets


import com.google.gson.annotations.SerializedName
import com.yoti.android.cryptocurrencychallenge.domain.model.AssetDomain

data class AssetData(
    @SerializedName("changePercent24Hr")
    val changePercent24Hr: String?,
    @SerializedName("explorer")
    val explorer: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("marketCapUsd")
    val marketCapUsd: String?,
    @SerializedName("maxSupply")
    val maxSupply: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("priceUsd")
    val priceUsd: String?,
    @SerializedName("rank")
    val rank: String?,
    @SerializedName("supply")
    val supply: String?,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("volumeUsd24Hr")
    val volumeUsd24Hr: String?,
    @SerializedName("vwap24Hr")
    val vwap24Hr: String?
)

fun AssetData.toDomain() = AssetDomain(
    changePercent24Hr = changePercent24Hr,
    explorer = explorer,
    id = id,
    marketCapUsd = explorer,
    maxSupply = maxSupply,
    name = name,
    priceUsd = priceUsd,
    rank = rank,
    supply = supply,
    symbol = symbol,
    volumeUsd24Hr = volumeUsd24Hr,
    vwap24Hr = vwap24Hr,
)