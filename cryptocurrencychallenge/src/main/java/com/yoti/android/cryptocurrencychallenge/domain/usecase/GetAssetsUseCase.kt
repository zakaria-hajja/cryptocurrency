package com.yoti.android.cryptocurrencychallenge.domain.usecase

import com.yoti.android.cryptocurrencychallenge.commons.Resource
import com.yoti.android.cryptocurrencychallenge.commons.Resource.Exception.Cause
import com.yoti.android.cryptocurrencychallenge.data.model.assets.toDomain
import com.yoti.android.cryptocurrencychallenge.domain.model.AssetDomain
import com.yoti.android.cryptocurrencychallenge.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAssetsUseCase @Inject constructor(private val repository: CryptoRepository) {

    operator fun invoke(): Flow<Resource<List<AssetDomain>>> = flow {
        try {
            emit(Resource.Loading<List<AssetDomain>>())
            val result = repository.getAssets().map { assetData ->
                assetData.toDomain()
            }
            emit(Resource.Success(result))
        } catch (_: HttpException) {
            emit(Resource.Exception<List<AssetDomain>>(Cause.HttpCause))
        } catch (_: IOException) {
            emit(Resource.Exception<List<AssetDomain>>(Cause.NoInternetConnectionCause))
        } catch (_: Exception) {
            emit(Resource.Exception<List<AssetDomain>>(Cause.UnknownCause))
        }
    }
}