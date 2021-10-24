package com.yoti.android.cryptocurrencychallenge.domain.usecase

import com.yoti.android.cryptocurrencychallenge.commons.Resource
import com.yoti.android.cryptocurrencychallenge.data.model.markets.toDomain
import com.yoti.android.cryptocurrencychallenge.domain.model.MarketDomain
import com.yoti.android.cryptocurrencychallenge.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetHighestMarketByCoin @Inject constructor(private val repository: CryptoRepository) {
    operator fun invoke(coinId: String): Flow<Resource<MarketDomain>> = flow {
        try {
            emit(Resource.Loading())
            val result =
                repository.getMarkets().map { marketData -> marketData.toDomain() }
                    .filter { data -> data.baseId == coinId }
                    .maxByOrNull {
                        it.volumeUsd24Hr?.toDouble() ?: 0.0
                    }
            emit(Resource.Success(result))
        } catch (httpException: HttpException) {
            emit(Resource.Exception(Resource.Exception.Cause.HttpCause))
        } catch (_: IOException) {
            emit(Resource.Exception(Resource.Exception.Cause.NoInternetConnectionCause))
        } catch (_: Exception) {
            emit(Resource.Exception(Resource.Exception.Cause.UnknownCause))
        }
    }
}