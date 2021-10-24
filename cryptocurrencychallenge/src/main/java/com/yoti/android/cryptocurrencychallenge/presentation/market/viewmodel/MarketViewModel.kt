package com.yoti.android.cryptocurrencychallenge.presentation.market.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yoti.android.cryptocurrencychallenge.commons.Mappers.toUi
import com.yoti.android.cryptocurrencychallenge.commons.Resource
import com.yoti.android.cryptocurrencychallenge.domain.usecase.GetHighestMarketByCoinUseCase
import com.yoti.android.cryptocurrencychallenge.presentation.market.MarketUiModel
import com.yoti.android.cryptocurrencychallenge.presentation.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MarketViewModel @Inject constructor(private val getHighestMarketByCoinUseCase: GetHighestMarketByCoinUseCase) :
    BaseViewModel() {
    private val _market = MutableLiveData<MarketUiModel>()
    val market: LiveData<MarketUiModel> = _market

    fun load(baseId: String) {
        resetViewState()

        getHighestMarketByCoinUseCase(baseId).flowOn(Dispatchers.IO).onEach {
            when (it) {
                is Resource.Success -> {
                    _isLoading.value = false

                    if (it.data != null)
                        _market.value = it.data.toUi()
                    else
                        _showEmpty.value = true
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