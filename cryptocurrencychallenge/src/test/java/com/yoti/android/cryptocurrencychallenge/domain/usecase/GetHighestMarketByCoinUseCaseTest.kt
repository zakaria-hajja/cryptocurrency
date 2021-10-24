package com.yoti.android.cryptocurrencychallenge.domain.usecase

import com.yoti.android.cryptocurrencychallenge.commons.Resource
import com.yoti.android.cryptocurrencychallenge.domain.model.MarketDomain
import com.yoti.android.cryptocurrencychallenge.domain.repository.CryptoRepository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect

import kotlinx.coroutines.test.runBlockingTest
import okhttp3.MediaType
import okhttp3.ResponseBody


import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class GetHighestMarketByCoinUseCaseTest {
    val repository: CryptoRepository = mockk()


    @ExperimentalCoroutinesApi
    @Test
    fun `When GetHighestMarketsByCoinUseCase is invoked with param, and repository getMarkets return Success`() {
        runBlockingTest {
            coEvery {
                repository.getMarkets()
            } returns listOf()

            val useCase = GetHighestMarketByCoinUseCase(repository)

            val result = mutableListOf<Resource<MarketDomain>>()
            useCase("bitcoin").collect {
                result.add(it)
            }
            assert(result[0] is Resource.Loading)
            assert(result[1] is Resource.Success)
            coVerify(exactly = 1) {
                repository.getMarkets()
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `When GetHighestMarketsByCoinUseCase is invoked with param, repository getMarkets throws IOException`() {
        runBlockingTest {
            coEvery {
                repository.getMarkets()
            } throws IOException()

            val useCase = GetHighestMarketByCoinUseCase(repository)

            val result = mutableListOf<Resource<MarketDomain>>()
            useCase("bitcoin").collect {
                result.add(it)
            }
            assert(result.size == 2)
            assert(result[0] is Resource.Loading)
            assert(result[1] is Resource.Exception)
            assert(result[1].cause is Resource.Exception.Cause.NoInternetConnectionCause)
            coVerify(exactly = 1) {
                repository.getMarkets()
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `When GetHighestMarketsByCoinUseCase is invoked with param, repository getMarkets throws http error`() {
        runBlockingTest {

            val response = Response.error<ResponseBody>(
                429,
                ResponseBody.create(MediaType.parse("plain/text"), "some content")
            )
            coEvery {
                repository.getMarkets()
            } throws HttpException(response)

            val useCase = GetHighestMarketByCoinUseCase(repository)

            val result = mutableListOf<Resource<MarketDomain>>()
            useCase("bitcoin").collect {
                result.add(it)
            }
            assert(result.size == 2)
            assert(result[0] is Resource.Loading)
            assert(result[1] is Resource.Exception)
            assert(result[1].cause is Resource.Exception.Cause.HttpCause)
            coVerify(exactly = 1) {
                repository.getMarkets()
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `When GetHighestMarketsByCoinUseCase is invoked with param, repository getMarkets throws Unknown Exception`() {
        runBlockingTest {
            coEvery {
                repository.getMarkets()
            } throws Exception()

            val useCase = GetHighestMarketByCoinUseCase(repository)

            val result = mutableListOf<Resource<MarketDomain>>()
            useCase("bitcoin").collect {
                result.add(it)
            }
            assert(result.size == 2)
            assert(result[0] is Resource.Loading)
            assert(result[1] is Resource.Exception)
            assert(result[1].cause is Resource.Exception.Cause.UnknownCause)
            coVerify(exactly = 1) {
                repository.getMarkets()
            }
        }
    }
}