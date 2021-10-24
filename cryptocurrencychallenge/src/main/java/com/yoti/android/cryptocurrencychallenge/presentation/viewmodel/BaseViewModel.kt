package com.yoti.android.cryptocurrencychallenge.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yoti.android.cryptocurrencychallenge.commons.Resource

open class BaseViewModel : ViewModel() {
    protected val _showError = MutableLiveData<Resource.Exception.Cause?>().apply { value = null }
    val showError: LiveData<Resource.Exception.Cause?> = _showError
    protected val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    protected val _showEmpty = MutableLiveData<Boolean>(false)
    val showEmpty: LiveData<Boolean> = _showEmpty

    protected fun resetViewState() {
        _showError.value = null
        _showEmpty.value = false
    }
}