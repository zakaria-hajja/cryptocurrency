package com.yoti.android.cryptocurrencychallenge.commons

import com.yoti.android.cryptocurrencychallenge.commons.Mappers.toDomain
import com.yoti.android.cryptocurrencychallenge.commons.Mappers.toUi
import com.yoti.android.cryptocurrencychallenge.domain.usecase.*
import org.junit.Assert
import org.junit.Test

class MapperTest {

    @Test
    fun `Test MarketData toDomain()`() {
        Assert.assertEquals(dummyMarketData.toDomain(), dummyMarketDomain)
    }

    @Test
    fun `Test AssetData toDomain()`() {
        Assert.assertEquals(dummyAssetData.toDomain(), dummyAssetDomain)
    }

    @Test
    fun `Test MarketDomain toUi()`() {
        Assert.assertEquals(dummyMarketDomain.toUi(), dummyMarketUi)
    }

    @Test
    fun `Test AssetDomain toUi()`() {
        Assert.assertEquals(dummyAssetDomain.toUi(), dummyAssetUI)
    }

    @Test
    fun `Test MarketDomain toUi() all attributes null`() {
        Assert.assertEquals(dummyNullMarketDomain.toUi(), dummyEmptyMarketUi)
    }

    @Test
    fun `Test AssetDomain toUi() all attributes null`() {
        Assert.assertEquals(dummyNullAssetDomain.toUi(), dummyEmptyAssetUI)
    }
}