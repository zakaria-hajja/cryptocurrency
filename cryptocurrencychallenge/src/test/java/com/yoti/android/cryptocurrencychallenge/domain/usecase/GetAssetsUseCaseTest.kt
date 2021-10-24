package com.yoti.android.cryptocurrencychallenge.domain.usecase

import com.yoti.android.cryptocurrencychallenge.commons.Resource
import com.yoti.android.cryptocurrencychallenge.domain.model.AssetDomain
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

class GetAssetsUseCaseTest {
    val repository: CryptoRepository = mockk()


    @ExperimentalCoroutinesApi
    @Test
    fun `When getAssetsUseCase is invoked,repository getAssets returns success`() {
        runBlockingTest {
            coEvery {
                repository.getAssets()
            } returns listOf()

            val useCase = GetAssetsUseCase(repository)

            val result = mutableListOf<Resource<List<AssetDomain>>>()
            useCase().collect {
                result.add(it)
            }
            assert(result[0] is Resource.Loading)
            assert(result[1] is Resource.Success)
            coVerify(exactly = 1) {
                repository.getAssets()
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `When getAssetsUseCase is invoked,repository getAssets returns emptyList`() {
        runBlockingTest {
            coEvery {
                repository.getAssets()
            } returns emptyList()

            val useCase = GetAssetsUseCase(repository)

            val result = mutableListOf<Resource<List<AssetDomain>>>()
            useCase().collect {
                result.add(it)
            }
            assert(result[0] is Resource.Loading)
            assert(result[1] is Resource.Success)
            assert(result[1].data == emptyList<AssetDomain>())
            coVerify(exactly = 1) {
                repository.getAssets()
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `When getAssetsUseCase is invoked, repository getAssets throws IOException`() {
        runBlockingTest {
            coEvery {
                repository.getAssets()
            } throws IOException()

            val useCase = GetAssetsUseCase(repository)

            val result = mutableListOf<Resource<List<AssetDomain>>>()
            useCase().collect {
                result.add(it)
            }
            assert(result.size == 2)
            assert(result[0] is Resource.Loading)
            assert(result[1] is Resource.Exception)
            assert(result[1].cause is Resource.Exception.Cause.NoInternetConnectionCause)
            coVerify(exactly = 1) {
                repository.getAssets()
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `When getAssetsUseCase is invoked, repository getAssets throws http error`() {
        runBlockingTest {

            val response = Response.error<ResponseBody>(
                429,
                ResponseBody.create(MediaType.parse("plain/text"), "some content")
            )
            coEvery {
                repository.getAssets()
            } throws HttpException(response)

            val useCase = GetAssetsUseCase(repository)

            val result = mutableListOf<Resource<List<AssetDomain>>>()
            useCase().collect {
                result.add(it)
            }
            assert(result.size == 2)
            assert(result[0] is Resource.Loading)
            assert(result[1] is Resource.Exception)
            assert(result[1].cause is Resource.Exception.Cause.HttpCause)
            coVerify(exactly = 1) {
                repository.getAssets()
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `When getAssetsUseCase is invoked, repository getAssets throws Unknown Exception`() {
        runBlockingTest {
            coEvery {
                repository.getAssets()
            } throws Exception()

            val useCase = GetAssetsUseCase(repository)

            val result = mutableListOf<Resource<List<AssetDomain>>>()
            useCase().collect {
                result.add(it)
            }
            assert(result.size == 2)
            assert(result[0] is Resource.Loading)
            assert(result[1] is Resource.Exception)
            assert(result[1].cause is Resource.Exception.Cause.UnknownCause)
            coVerify(exactly = 1) {
                repository.getAssets()
            }
        }
    }
}