package com.yoti.android.cryptocurrencychallenge.domain.repository

import com.yoti.android.cryptocurrencychallenge.data.datasource.RemoteDataSource
import com.yoti.android.cryptocurrencychallenge.data.repository.CryptoRepositoryImpl
import com.yoti.android.cryptocurrencychallenge.domain.usecase.dummyAssetApiData
import com.yoti.android.cryptocurrencychallenge.domain.usecase.dummyMarketApiData
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class CryptoRepositoryTest {

    val dataSource: RemoteDataSource = mockk()

    @ExperimentalCoroutinesApi
    @Test
    fun `When getAssets is invoked, datasource getAssets invoked`() {
        runBlockingTest {
            coEvery {
                dataSource.getAssets()
            } returns dummyAssetApiData

            val repository = CryptoRepositoryImpl(dataSource)
            repository.getAssets()

            coVerify(exactly = 1) {
                dataSource.getAssets()
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `When getMarkets is invoked, datasource getMarkets invoked`() {
        runBlockingTest {
            coEvery {
                dataSource.getMarkets()
            } returns dummyMarketApiData

            val repository = CryptoRepositoryImpl(dataSource)
            repository.getMarkets()

            coVerify(exactly = 1) {
                dataSource.getMarkets()
            }
        }
    }

}