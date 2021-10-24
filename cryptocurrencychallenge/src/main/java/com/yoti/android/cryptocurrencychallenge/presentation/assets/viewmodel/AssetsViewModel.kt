package com.yoti.android.cryptocurrencychallenge.presentation.assets.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yoti.android.cryptocurrencychallenge.commons.Mappers.toUi
import com.yoti.android.cryptocurrencychallenge.commons.Resource
import com.yoti.android.cryptocurrencychallenge.domain.usecase.GetAssetsUseCase
import com.yoti.android.cryptocurrencychallenge.presentation.assets.AssetUiItem
import com.yoti.android.cryptocurrencychallenge.presentation.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AssetsViewModel @Inject constructor(
    val getAssetsUseCase: GetAssetsUseCase
) : BaseViewModel() {

    private val _assets = MutableLiveData<List<AssetUiItem>>()
    val assets: LiveData<List<AssetUiItem>> = _assets


    init {
        load()
    }

    fun load() {
        resetViewState()
        getAssetsUseCase().flowOn(Dispatchers.IO).onEach {
            when (it) {
                is Resource.Success -> {

                    _isLoading.value = false
                    _assets.value = it.data?.map { assetDomain ->
                        assetDomain.toUi()
                    } ?: emptyList()
                }

                is Resource.Exception -> {

                    _isLoading.value = false
                    _showError.value = it.cause ?: Resource.Exception.Cause.UnknownCause
                }
                is Resource.Loading -> {

                    _isLoading.value = true
                }
            }

        }.launchIn(viewModelScope)
    }

}