package com.yoti.android.cryptocurrencychallenge.data.di

import com.yoti.android.cryptocurrencychallenge.data.CAPCOIN_ENDPOINT_HOST
import com.yoti.android.cryptocurrencychallenge.data.CoincapService
import com.yoti.android.cryptocurrencychallenge.data.datasource.RemoteDataSource
import com.yoti.android.cryptocurrencychallenge.data.datasource.RetrofitDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    @Singleton
    fun provideCoincapService(): CoincapService {
        return Retrofit.Builder()
            .baseUrl(CAPCOIN_ENDPOINT_HOST)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoincapService::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(api: CoincapService): RemoteDataSource {
        return RetrofitDataSource(api)
    }
}