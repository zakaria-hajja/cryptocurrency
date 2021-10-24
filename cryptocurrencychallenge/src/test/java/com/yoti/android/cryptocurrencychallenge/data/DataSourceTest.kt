package com.yoti.android.cryptocurrencychallenge.data


import com.yoti.android.cryptocurrencychallenge.data.datasource.RetrofitDataSource
import com.yoti.android.cryptocurrencychallenge.domain.usecase.dummyAssetApiData
import com.yoti.android.cryptocurrencychallenge.domain.usecase.dummyMarketApiData
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class DataSourceTest {


    val api: CoincapService = mockk()

    @ExperimentalCoroutinesApi
    @Test
    fun `When getAssets is invoked, api getAssets invoked`() {
        runBlockingTest {
            coEvery {
                api.getAssets()
            } returns dummyAssetApiData

            val dataSource = RetrofitDataSource(api)
            dataSource.getAssets()

            coVerify(exactly = 1) {
                api.getAssets()
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `When getMarkets is invoked, api getMarkets invoked`() {
        runBlockingTest {
            coEvery {
                api.getMarkets()
            } returns dummyMarketApiData

            val dataSource = RetrofitDataSource(api)
            dataSource.getMarkets()

            coVerify(exactly = 1) {
                api.getMarkets()
            }
        }
    }
}